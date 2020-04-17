package com.baidu.swan.apps.api.module.g;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.swan.apps.as.y;
import com.baidu.swan.apps.runtime.d;
import com.facebook.common.internal.i;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import java.util.Set;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected static final Set<String> bDt = i.N("localhost", "127.0.0.1");

    public static String gV(String str) {
        return str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + System.currentTimeMillis();
    }

    public static HttpUrl gW(String str) {
        HttpUrl parse = HttpUrl.parse(str);
        if (d.akK().akJ() == null) {
            if (a(parse)) {
                return parse;
            }
            return null;
        } else if (com.baidu.swan.apps.ah.a.a.aiE() || a(parse)) {
            return parse;
        } else {
            return null;
        }
    }

    public static boolean a(@Nullable HttpUrl httpUrl) {
        boolean alO = com.baidu.swan.apps.aj.a.b.alO();
        if (!com.baidu.swan.apps.w.a.abR().Pc()) {
            alO = false;
        }
        if (httpUrl != null) {
            return (!alO || HttpUrl.defaultPort(httpUrl.scheme()) == httpUrl.port()) && !bDt.contains(httpUrl.host().toLowerCase());
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

    public static JSONObject gX(String str) {
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

    public static String RJ() {
        return y.ape() == 2 ? y.oa("https://smartapps.cn/%s/%s/page-frame.html") : y.oa("https://smartapp.baidu.com/%s/%s/page-frame.html");
    }
}
