package com.baidu.live.tbadk.scheme;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpHost;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class SchemeUtils {
    private static final String DEFAULT_PROTOCOL = "bdlive";
    private static Set<String> protocolSet = new HashSet();
    private static Map<String, Class<? extends ILiveScheme>> schemeMap;

    static {
        protocolSet.add(DEFAULT_PROTOCOL);
        schemeMap = new HashMap();
    }

    public static void setCustomProtocol(String str) {
        protocolSet.add(str);
    }

    public static void putCustomSchemePath(String str, Class<? extends ILiveScheme> cls) {
        schemeMap.put(str, cls);
    }

    public static boolean checkScheme(String str) {
        Uri parse;
        try {
            parse = Uri.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (protocolSet.contains(parse.getScheme())) {
            String host = parse.getHost();
            String path = parse.getPath();
            if (!TextUtils.isEmpty(path) && path.endsWith("/")) {
                path = path.substring(0, path.length() - 1);
            }
            if (schemeMap.get(host + path) != null) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static boolean openScheme(String str) {
        return openScheme(str, null);
    }

    public static boolean openScheme(String str, SchemeCallback schemeCallback) {
        try {
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            if (!protocolSet.contains(scheme)) {
                return openOtherScheme(scheme, parse);
            }
            String host = parse.getHost();
            String path = parse.getPath();
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(path) && path.endsWith("/")) {
                path = path.substring(0, path.length() - 1);
            }
            Class<? extends ILiveScheme> cls = schemeMap.get(host + path);
            if (cls == null) {
                return false;
            }
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            if (queryParameterNames != null && !queryParameterNames.isEmpty()) {
                for (String str2 : queryParameterNames) {
                    String queryParameter = parse.getQueryParameter(str2);
                    hashMap.put(str2, queryParameter);
                    if (TextUtils.equals(str2, "params") && !TextUtils.isEmpty(queryParameter)) {
                        try {
                            JSONObject jSONObject = new JSONObject(queryParameter);
                            Iterator<String> keys = jSONObject.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                hashMap.put(next, jSONObject.optString(next, ""));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            cls.newInstance().excute(hashMap, schemeCallback);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private static boolean openOtherScheme(String str, Uri uri) {
        if (HttpHost.DEFAULT_SCHEME_NAME.equals(str) || "https".equals(str)) {
            BrowserHelper.startInternalWebActivity(TbadkCoreApplication.getInst(), uri.toString());
            return true;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            intent.setFlags(268435456);
            if (intent.resolveActivity(TbadkCoreApplication.getInst().getPackageManager()) != null) {
                TbadkCoreApplication.getInst().startActivity(intent);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String assembJavaScript(int i, String str, JSONObject jSONObject, String str2) {
        try {
            if (TextUtils.isEmpty(str2)) {
                str2 = BuyTBeanActivityConfig.CALLBACK;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("status", i);
            if (str == null) {
                str = "";
            }
            jSONObject2.put("message", str);
            if (jSONObject != null) {
                jSONObject2.put("data", jSONObject);
            }
            return "javascript:" + str2 + "('" + jSONObject2.toString() + "');";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
