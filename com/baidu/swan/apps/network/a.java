package com.baidu.swan.apps.network;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.scheme.actions.z;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends z {
    protected static final Set<String> aYq = com.facebook.common.internal.h.J("localhost", "127.0.0.1");
    public static final Set<String> aYr = com.facebook.common.internal.h.J("REFERER", "USER-AGENT");
    protected ConcurrentHashMap<String, Long> aYp;

    public a(com.baidu.swan.apps.scheme.j jVar, String str) {
        super(jVar, str);
        this.aYp = new ConcurrentHashMap<>();
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        return false;
    }

    public final long gl(String str) {
        long j;
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            j = this.aYp.get(str).longValue();
        } catch (Exception e) {
            j = 0;
        }
        return j;
    }

    public final void gm(String str) {
        if (this.aYp != null && !TextUtils.isEmpty(str)) {
            this.aYp.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static HttpUrl gn(String str) {
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

    protected static boolean a(@Nullable HttpUrl httpUrl) {
        boolean RH = com.baidu.swan.apps.af.a.b.RH();
        if (!com.baidu.swan.apps.u.a.Jl().Bl()) {
            RH = false;
        }
        if (httpUrl != null) {
            return (!RH || HttpUrl.defaultPort(httpUrl.scheme()) == httpUrl.port()) && !aYq.contains(httpUrl.host().toLowerCase());
        }
        return false;
    }

    protected static HashMap<String, String> ag(@Nullable JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() < 1) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next) && !aYr.contains(next.toUpperCase())) {
                String optString = jSONObject.optString(next);
                if (!TextUtils.isEmpty(optString)) {
                    hashMap.put(next, optString);
                }
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static HashMap<String, String> b(@Nullable JSONObject jSONObject, boolean z) {
        HashMap<String, String> ag = ag(jSONObject);
        if (z) {
            if (ag == null) {
                ag = new HashMap<>();
            }
            ag.put("Referer", MK());
        }
        return ag;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String go(String str) {
        return str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public JSONObject gp(String str) {
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

    public static String MK() {
        com.baidu.swan.apps.ae.b QZ = com.baidu.swan.apps.ae.b.QZ();
        return QZ != null ? String.format("https://smartapp.baidu.com/%s/%s/page-frame.html", QZ.getAppKey(), QZ.Rn()) : "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
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
}
