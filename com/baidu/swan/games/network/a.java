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
    public static final Set<String> aCj = h.K("REFERER", "USER-AGENT");
    protected static final Set<String> aCi = h.K("localhost", "127.0.0.1");

    /* JADX INFO: Access modifiers changed from: protected */
    public HttpUrl fp(String str) {
        HttpUrl parse = HttpUrl.parse(str);
        if ((com.baidu.swan.apps.ae.b.IV() == null ? null : com.baidu.swan.apps.ae.b.IV().getActivity()) == null) {
            if (a(parse)) {
                return parse;
            }
            return null;
        } else if ((DEBUG && com.baidu.swan.apps.ac.a.a.Gf()) || a(parse)) {
            return parse;
        } else {
            return null;
        }
    }

    protected boolean a(@Nullable HttpUrl httpUrl) {
        boolean JC = com.baidu.swan.apps.af.a.b.JC();
        if (!com.baidu.swan.apps.u.a.Cz().vk()) {
            JC = false;
        }
        if (httpUrl != null) {
            return (!JC || HttpUrl.defaultPort(httpUrl.scheme()) == httpUrl.port()) && !aCi.contains(httpUrl.host().toLowerCase());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String OC() {
        String Jg = com.baidu.swan.apps.ae.b.Jg();
        return TextUtils.isEmpty(Jg) ? "" : Jg + "_" + System.currentTimeMillis();
    }

    public String EW() {
        com.baidu.swan.apps.ae.b IV = com.baidu.swan.apps.ae.b.IV();
        return IV != null ? String.format("https://smartapp.baidu.com/%s/%s/page-frame.html", IV.getAppKey(), IV.Jj()) : "";
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
