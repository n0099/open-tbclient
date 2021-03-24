package com.baidu.mobads.utils;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Build;
import com.baidu.mobads.AdSettings;
import com.baidu.mobads.constants.XAdSDKProxyVersion;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
/* loaded from: classes2.dex */
public class aa implements IXAdURIUitls {
    private Boolean a(String str, String str2) {
        boolean z = false;
        if (str != null && str.trim().toLowerCase(Locale.getDefault()).indexOf(str2) == 0) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdURIUitls
    @Deprecated
    public String addParameter(String str, String str2, String str3) {
        String str4;
        String fixedString = getFixedString(str);
        String queryString = getQueryString(str);
        if (!XAdSDKFoundationFacade.getInstance().getCommonUtils().isStringAvailable(queryString)) {
            str4 = str2 + "=" + str3;
        } else {
            str4 = queryString + "&" + str2 + "=" + str3;
        }
        return fixedString + "?" + str4;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdURIUitls
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
                    q.a().e(e2);
                }
            }
            String sb2 = sb.toString();
            return sb2.substring(0, sb2.length() - 1);
        }
        return sb.toString();
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdURIUitls
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

    @Override // com.baidu.mobads.interfaces.utils.IXAdURIUitls
    public String encodeUrl(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdURIUitls
    public HashMap<String, String> getAllQueryParameters(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        Uri parse = Uri.parse(str);
        for (String str2 : getQueryParameterNames(parse)) {
            if (str2 != null && str2.length() > 0) {
                hashMap.put(str2, parse.getQueryParameter(str2));
            }
        }
        return hashMap;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdURIUitls
    public String getFileName(String str) {
        try {
            String path = new URI(str).getPath();
            return path.substring(path.lastIndexOf(47) + 1, path.length());
        } catch (URISyntaxException unused) {
            return "";
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdURIUitls
    public String getFixedString(String str) {
        if (str == null) {
            return null;
        }
        return (isHttpProtocol(str).booleanValue() || isHttpsProtocol(str).booleanValue()) ? str.split("\\?")[0] : str;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdURIUitls
    public HttpURLConnection getHttpURLConnection(URL url) {
        if (url.getProtocol().toLowerCase().equals("https")) {
            return (HttpsURLConnection) url.openConnection();
        }
        return (HttpURLConnection) url.openConnection();
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdURIUitls
    @SuppressLint({"NewApi"})
    public Set<String> getQueryParameterNames(Uri uri) {
        Set<String> unmodifiableSet;
        try {
            if (Build.VERSION.SDK_INT >= 11) {
                unmodifiableSet = uri.getQueryParameterNames();
            } else {
                String encodedQuery = uri.getEncodedQuery();
                if (encodedQuery == null) {
                    unmodifiableSet = Collections.emptySet();
                } else {
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    int i = 0;
                    do {
                        int indexOf = encodedQuery.indexOf(38, i);
                        if (indexOf == -1) {
                            indexOf = encodedQuery.length();
                        }
                        int indexOf2 = encodedQuery.indexOf(61, i);
                        if (indexOf2 > indexOf || indexOf2 == -1) {
                            indexOf2 = indexOf;
                        }
                        linkedHashSet.add(Uri.decode(encodedQuery.substring(i, indexOf2)));
                        i = indexOf + 1;
                    } while (i < encodedQuery.length());
                    unmodifiableSet = Collections.unmodifiableSet(linkedHashSet);
                }
            }
            return unmodifiableSet;
        } catch (Exception unused) {
            return new HashSet();
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdURIUitls
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

    @Override // com.baidu.mobads.interfaces.utils.IXAdURIUitls
    public String getRequestAdUrl(String str, HashMap<String, String> hashMap) {
        String sb;
        XAdSDKFoundationFacade xAdSDKFoundationFacade = XAdSDKFoundationFacade.getInstance();
        StringBuilder sb2 = new StringBuilder();
        if (hashMap != null) {
            int i = 0;
            for (String str2 : hashMap.keySet()) {
                i++;
                String str3 = hashMap.get(str2);
                if (i == 1) {
                    sb2.append(str2);
                    sb2.append("=");
                    sb2.append(str3);
                } else {
                    sb2.append("&");
                    sb2.append(str2);
                    sb2.append("=");
                    sb2.append(str3);
                }
            }
        }
        if (XAdSDKProxyVersion.DEBUG.booleanValue()) {
            if (hashMap != null) {
                for (String str4 : hashMap.keySet()) {
                    try {
                        String str5 = hashMap.get(str4);
                        if (str5 != null) {
                            hashMap.put(str4, URLEncoder.encode(str5, "UTF-8"));
                        }
                    } catch (UnsupportedEncodingException unused) {
                    }
                }
            }
            sb = xAdSDKFoundationFacade.getURIUitls().addParameters(str, hashMap) + "&b" + System.currentTimeMillis() + "=1";
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append("?code2=");
            sb3.append(xAdSDKFoundationFacade.getBase64().encode(sb2.toString() + "&b" + System.currentTimeMillis() + "=1"));
            sb = sb3.toString();
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append("&b" + System.currentTimeMillis());
        sb4.append("=");
        sb4.append("1");
        return sb + sb4.toString();
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdURIUitls
    public Boolean isHttpProtocol(String str) {
        return a(str, UrlSchemaHelper.SCHEMA_TYPE_HTTP);
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdURIUitls
    public Boolean isHttpsProtocol(String str) {
        return a(str, UrlSchemaHelper.SCHEMA_TYPE_HTTPS);
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdURIUitls
    public Boolean isMessageProtocol(String str) {
        return Boolean.valueOf(a(str, UrlSchemaHelper.SCHEMA_TYPE_SMS).booleanValue() || a(str, "smsto:").booleanValue() || a(str, "mms:").booleanValue());
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdURIUitls
    public void pintHttpInNewThread(String str) {
        com.baidu.mobads.openad.b.a aVar = new com.baidu.mobads.openad.b.a();
        com.baidu.mobads.openad.b.b bVar = new com.baidu.mobads.openad.b.b(str, "");
        bVar.f8413e = 1;
        aVar.a(bVar, Boolean.TRUE);
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdURIUitls
    public String replaceURLWithSupportProtocol(String str) {
        return (AdSettings.getSupportHttps().equals(AdSettings.b.HTTPS_PROTOCOL_TYPE.a()) && isHttpProtocol(str).booleanValue()) ? str.replaceFirst("(?i)http", "https") : str;
    }
}
