package com.baidu.swan.games.network;

import android.support.annotation.Nullable;
import android.text.TextUtils;
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
    public static final Set<String> aFc = h.M("REFERER", "USER-AGENT");
    protected static final Set<String> aFb = h.M("localhost", "127.0.0.1");

    /* JADX INFO: Access modifiers changed from: protected */
    public HttpUrl fJ(String str) {
        HttpUrl parse = HttpUrl.parse(str);
        if ((com.baidu.swan.apps.ae.b.Mh() == null ? null : com.baidu.swan.apps.ae.b.Mh().getActivity()) == null) {
            if (a(parse)) {
                return parse;
            }
            return null;
        } else if ((DEBUG && com.baidu.swan.apps.ac.a.a.Jf()) || a(parse)) {
            return parse;
        } else {
            return null;
        }
    }

    protected boolean a(@Nullable HttpUrl httpUrl) {
        boolean MP = com.baidu.swan.apps.af.a.b.MP();
        if (!com.baidu.swan.apps.u.a.Er().wr()) {
            MP = false;
        }
        if (httpUrl != null) {
            return (!MP || HttpUrl.defaultPort(httpUrl.scheme()) == httpUrl.port()) && !aFb.contains(httpUrl.host().toLowerCase());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String SE() {
        String Ms = com.baidu.swan.apps.ae.b.Ms();
        return TextUtils.isEmpty(Ms) ? "" : Ms + "_" + System.currentTimeMillis();
    }

    public String HQ() {
        com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
        return Mh != null ? String.format("https://smartapp.baidu.com/%s/%s/page-frame.html", Mh.getAppKey(), Mh.Mv()) : "";
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
