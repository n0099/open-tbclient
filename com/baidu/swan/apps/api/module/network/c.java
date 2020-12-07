package com.baidu.swan.apps.api.module.network;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.swan.apps.ap.ab;
import com.baidu.swan.apps.runtime.d;
import com.facebook.common.internal.i;
import java.util.List;
import java.util.Set;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class c {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected static final Set<String> cEY = i.N("localhost", "127.0.0.1");

    public static String lP(String str) {
        return str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + System.currentTimeMillis();
    }

    public static HttpUrl lQ(String str) {
        HttpUrl parse = HttpUrl.parse(str);
        if (d.aJQ().aJO() == null) {
            if (a(parse)) {
                return parse;
            }
            return null;
        } else if (com.baidu.swan.apps.ad.a.a.aHk() || a(parse)) {
            return parse;
        } else {
            return null;
        }
    }

    public static boolean a(@Nullable HttpUrl httpUrl) {
        boolean aKY = com.baidu.swan.apps.ag.a.b.aKY();
        if (!com.baidu.swan.apps.t.a.azd().aiV()) {
            aKY = false;
        }
        if (httpUrl != null) {
            return (!aKY || HttpUrl.defaultPort(httpUrl.scheme()) == httpUrl.port()) && !cEY.contains(httpUrl.host().toLowerCase());
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
                    sb.append(",");
                }
                jSONObject.put(str, sb.toString());
            }
        }
        return jSONObject;
    }

    public static JSONObject lR(String str) {
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

    public static String amq() {
        return ab.aPh();
    }
}
