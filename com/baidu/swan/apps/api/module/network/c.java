package com.baidu.swan.apps.api.module.network;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.swan.apps.aq.aa;
import com.baidu.swan.apps.runtime.d;
import com.facebook.common.internal.i;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import java.util.Set;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected static final Set<String> bRw = i.O("localhost", "127.0.0.1");

    public static String id(String str) {
        return str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + System.currentTimeMillis();
    }

    public static HttpUrl ie(String str) {
        HttpUrl parse = HttpUrl.parse(str);
        if (d.arr().arp() == null) {
            if (a(parse)) {
                return parse;
            }
            return null;
        } else if (com.baidu.swan.apps.ae.a.a.aoZ() || a(parse)) {
            return parse;
        } else {
            return null;
        }
    }

    public static boolean a(@Nullable HttpUrl httpUrl) {
        boolean asA = com.baidu.swan.apps.ah.a.b.asA();
        if (!com.baidu.swan.apps.t.a.ahm().SL()) {
            asA = false;
        }
        if (httpUrl != null) {
            return (!asA || HttpUrl.defaultPort(httpUrl.scheme()) == httpUrl.port()) && !bRw.contains(httpUrl.host().toLowerCase());
        }
        return false;
    }

    public static JSONObject a(Headers headers) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (headers == null) {
            return jSONObject;
        }
        for (String str : headers.names()) {
            if (!TextUtils.isEmpty(str)) {
                List<String> values = headers.values(str);
                StringBuilder sb = new StringBuilder();
                int size = values.size();
                for (int i = 0; i < size; i++) {
                    sb.append(values.get(i));
                    if (i == size - 1) {
                        break;
                    }
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                jSONObject.put(str, sb.toString());
            }
        }
        return jSONObject;
    }

    /* renamed from: if  reason: not valid java name */
    public static JSONObject m26if(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("cancelTag", str);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    public static String VV() {
        return aa.awM() == 2 ? aa.qC("https://smartapps.cn/%s/%s/page-frame.html") : aa.qC("https://smartapp.baidu.com/%s/%s/page-frame.html");
    }
}
