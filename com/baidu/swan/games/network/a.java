package com.baidu.swan.games.network;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.facebook.common.internal.h;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import java.util.Set;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final Set<String> aYr = h.J("REFERER", "USER-AGENT");
    protected static final Set<String> aYq = h.J("localhost", "127.0.0.1");

    /* JADX INFO: Access modifiers changed from: protected */
    public HttpUrl gn(String str) {
        HttpUrl parse = HttpUrl.parse(str);
        if ((com.baidu.swan.apps.ae.b.QZ() == null ? null : com.baidu.swan.apps.ae.b.QZ().getActivity()) == null) {
            if (a(parse)) {
                return parse;
            }
            return null;
        } else if ((DEBUG && com.baidu.swan.apps.ac.a.a.NZ()) || a(parse)) {
            return parse;
        } else {
            return null;
        }
    }

    protected boolean a(@Nullable HttpUrl httpUrl) {
        boolean RH = com.baidu.swan.apps.af.a.b.RH();
        if (!com.baidu.swan.apps.u.a.Jl().Bl()) {
            RH = false;
        }
        if (httpUrl != null) {
            return (!RH || HttpUrl.defaultPort(httpUrl.scheme()) == httpUrl.port()) && !aYq.contains(httpUrl.host().toLowerCase());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String Xv() {
        String Rk = com.baidu.swan.apps.ae.b.Rk();
        return TextUtils.isEmpty(Rk) ? "" : Rk + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + System.currentTimeMillis();
    }

    public String MK() {
        com.baidu.swan.apps.ae.b QZ = com.baidu.swan.apps.ae.b.QZ();
        return QZ != null ? String.format("https://smartapp.baidu.com/%s/%s/page-frame.html", QZ.getAppKey(), QZ.Rn()) : "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public JSONObject a(Headers headers) throws JSONException {
        List<String> values;
        JSONObject jSONObject = new JSONObject();
        if (headers == null) {
            return jSONObject;
        }
        for (String str : headers.names()) {
            if (!TextUtils.isEmpty(str) && (values = headers.values(str)) != null) {
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
}
