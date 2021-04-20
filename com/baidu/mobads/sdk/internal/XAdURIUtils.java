package com.baidu.mobads.sdk.internal;

import com.baidu.tbadk.core.util.UrlSchemaHelper;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
/* loaded from: classes2.dex */
public class XAdURIUtils {
    public static volatile XAdURIUtils shareInstance;
    public boolean mLpMultiProcess;
    public boolean mSupportHttps;

    public static XAdURIUtils getInstance() {
        if (shareInstance == null) {
            synchronized (XAdURIUtils.class) {
                if (shareInstance == null) {
                    shareInstance = new XAdURIUtils();
                }
            }
        }
        return shareInstance;
    }

    private Boolean isXProtocol(String str, String str2) {
        boolean z = false;
        if (str != null && str.trim().toLowerCase(Locale.getDefault()).indexOf(str2) == 0) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    public String addParameters(String str, HashMap<String, String> hashMap) {
        StringBuilder sb = new StringBuilder(str);
        if (hashMap != null && !hashMap.isEmpty()) {
            sb.append("?");
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                try {
                    sb.append(entry.getKey());
                    sb.append("=");
                    sb.append(entry.getValue());
                    sb.append("&");
                } catch (Exception e2) {
                    XAdLogger.getInstance().e(e2);
                }
            }
            String sb2 = sb.toString();
            return sb2.substring(0, sb2.length() - 1);
        }
        return sb.toString();
    }

    public void closeHttpURLConnection(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.getInputStream().close();
            } catch (Throwable unused) {
            }
            try {
                httpURLConnection.getOutputStream().close();
            } catch (Throwable unused2) {
            }
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused3) {
            }
        }
    }

    public String getFileName(String str) {
        try {
            String path = new URI(str).getPath();
            return path.substring(path.lastIndexOf(47) + 1, path.length());
        } catch (URISyntaxException unused) {
            return "";
        }
    }

    public String getFixedString(String str) {
        if (str == null) {
            return null;
        }
        return (isHttpProtocol(str).booleanValue() || isHttpsProtocol(str).booleanValue()) ? str.split("\\?")[0] : str;
    }

    public HttpURLConnection getHttpURLConnection(URL url) throws IOException {
        if (url.getProtocol().toLowerCase().equals("https")) {
            SslUtils.ignoreSsl();
            return (HttpsURLConnection) url.openConnection();
        }
        return (HttpURLConnection) url.openConnection();
    }

    public boolean getLpMultiProcess() {
        return this.mLpMultiProcess;
    }

    public String getQueryString(String str) {
        if (str == null) {
            return null;
        }
        String[] split = (isHttpProtocol(str).booleanValue() || isHttpsProtocol(str).booleanValue()) ? str.split("\\?") : null;
        if (split == null || split.length < 2) {
            return null;
        }
        return split[1];
    }

    public Boolean isHttpProtocol(String str) {
        return isXProtocol(str, UrlSchemaHelper.SCHEMA_TYPE_HTTP);
    }

    public Boolean isHttpsProtocol(String str) {
        return isXProtocol(str, UrlSchemaHelper.SCHEMA_TYPE_HTTPS);
    }

    public Boolean isMessageProtocol(String str) {
        return Boolean.valueOf(isXProtocol(str, UrlSchemaHelper.SCHEMA_TYPE_SMS).booleanValue() || isXProtocol(str, "smsto:").booleanValue() || isXProtocol(str, "mms:").booleanValue());
    }

    public String replaceURLWithSupportProtocol(String str) {
        return (this.mSupportHttps && isHttpProtocol(str).booleanValue()) ? str.replaceFirst("(?i)http", "https") : str;
    }

    public void setHttps(boolean z) {
        this.mSupportHttps = z;
    }

    public void setLpMultiProcess(boolean z) {
        this.mLpMultiProcess = z;
    }
}
