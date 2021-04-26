package com.baidu.mobads.container.util;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.container.XAdSDKRemoteVersion;
import com.baidu.mobads.container.config.AppConfigImp;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
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
public class AdURIUtils {
    @Deprecated
    public static String addParameter(String str, String str2, String str3) {
        String str4;
        String fixedString = getFixedString(str);
        String queryString = getQueryString(str);
        if (TextUtils.isEmpty(queryString)) {
            str4 = str2 + "=" + str3;
        } else {
            str4 = queryString + "&" + str2 + "=" + str3;
        }
        return fixedString + "?" + str4;
    }

    public static String addParameters(String str, HashMap<String, String> hashMap) {
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
                    RemoteXAdLogger.getInstance().e(e2);
                }
            }
            String sb2 = sb.toString();
            return sb2.substring(0, sb2.length() - 1);
        }
        return sb.toString();
    }

    public static String decodeURIComponent(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (Exception unused) {
            return str;
        }
    }

    public static String encodeURIComponent(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20").replaceAll("\\%21", "!").replaceAll("\\%27", "'").replaceAll("\\%28", "(").replaceAll("\\%29", SmallTailInfo.EMOTION_SUFFIX).replaceAll("\\%7E", Constants.WAVE_SEPARATOR);
        } catch (Exception unused) {
            return str;
        }
    }

    public static String encodeUrl(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static HashMap<String, String> getAllQueryParameters(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        Uri parse = Uri.parse(str);
        for (String str2 : getQueryParameterNames(parse)) {
            if (str2 != null && str2.length() > 0) {
                hashMap.put(str2, parse.getQueryParameter(str2));
            }
        }
        return hashMap;
    }

    public static String getFixedString(String str) {
        if (str == null) {
            return null;
        }
        return (isHttpProtocol(str).booleanValue() || isHttpsProtocol(str).booleanValue()) ? str.split("\\?")[0] : str;
    }

    public static HttpURLConnection getHttpURLConnection(URL url) throws IOException {
        if (url.getProtocol().toLowerCase().equals("https")) {
            RemoteSslUtils.ignoreSsl();
            return (HttpsURLConnection) url.openConnection();
        }
        return (HttpURLConnection) url.openConnection();
    }

    @SuppressLint({"NewApi"})
    public static Set<String> getQueryParameterNames(Uri uri) {
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
                    int i2 = 0;
                    do {
                        int indexOf = encodedQuery.indexOf(38, i2);
                        if (indexOf == -1) {
                            indexOf = encodedQuery.length();
                        }
                        int indexOf2 = encodedQuery.indexOf(61, i2);
                        if (indexOf2 > indexOf || indexOf2 == -1) {
                            indexOf2 = indexOf;
                        }
                        linkedHashSet.add(Uri.decode(encodedQuery.substring(i2, indexOf2)));
                        i2 = indexOf + 1;
                    } while (i2 < encodedQuery.length());
                    unmodifiableSet = Collections.unmodifiableSet(linkedHashSet);
                }
            }
            return unmodifiableSet;
        } catch (Exception unused) {
            return new HashSet();
        }
    }

    public static String getQueryString(String str) {
        if (str == null) {
            return null;
        }
        String[] split = (isHttpProtocol(str).booleanValue() || isHttpsProtocol(str).booleanValue()) ? str.split("\\?") : null;
        if (split == null || split.length < 2) {
            return null;
        }
        return split[1];
    }

    public static String getRequestAdUrl(String str, HashMap<String, String> hashMap) {
        String sb;
        StringBuilder sb2 = new StringBuilder();
        if (hashMap != null) {
            int i2 = 0;
            for (String str2 : hashMap.keySet()) {
                i2++;
                String str3 = hashMap.get(str2);
                if (i2 == 1) {
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
        if (XAdSDKRemoteVersion.DEBUG.booleanValue()) {
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
            sb = addParameters(str, hashMap) + "&b" + System.currentTimeMillis() + "=1";
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append("?code2=");
            sb3.append(Base64.encode(sb2.toString() + "&b" + System.currentTimeMillis() + "=1"));
            sb = sb3.toString();
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append("&b" + System.currentTimeMillis());
        sb4.append("=");
        sb4.append("1");
        return sb + sb4.toString();
    }

    public static Boolean isHttpProtocol(String str) {
        return isXProtocol(str, UrlSchemaHelper.SCHEMA_TYPE_HTTP);
    }

    public static Boolean isHttpsProtocol(String str) {
        return isXProtocol(str, UrlSchemaHelper.SCHEMA_TYPE_HTTPS);
    }

    public static Boolean isMessageProtocol(String str) {
        return Boolean.valueOf(isXProtocol(str, UrlSchemaHelper.SCHEMA_TYPE_SMS).booleanValue() || isXProtocol(str, "smsto:").booleanValue() || isXProtocol(str, "mms:").booleanValue());
    }

    public static boolean isStringAvailable(String str) {
        return str != null && str.length() > 0;
    }

    public static Boolean isXProtocol(String str, String str2) {
        boolean z = false;
        if (str != null && str.trim().toLowerCase(Locale.getDefault()).indexOf(str2) == 0) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    public static String replaceURLWithSupportProtocol(String str) {
        return (AppConfigImp.getInstance().isSupportHttps() && isHttpProtocol(str).booleanValue()) ? str.replaceFirst("(?i)http", "https") : str;
    }
}
