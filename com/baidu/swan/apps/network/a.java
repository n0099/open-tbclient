package com.baidu.swan.apps.network;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
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
    protected static final Set<String> aDV = com.facebook.common.internal.h.L("localhost", "127.0.0.1");
    public static final Set<String> aDW = com.facebook.common.internal.h.L("REFERER", "USER-AGENT");
    protected ConcurrentHashMap<String, Long> aDU;

    public a(com.baidu.swan.apps.scheme.j jVar, String str) {
        super(jVar, str);
        this.aDU = new ConcurrentHashMap<>();
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        return false;
    }

    public final long fB(String str) {
        long j;
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            j = this.aDU.get(str).longValue();
        } catch (Exception e) {
            j = 0;
        }
        return j;
    }

    public final void fC(String str) {
        if (this.aDU != null && !TextUtils.isEmpty(str)) {
            this.aDU.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static HttpUrl fD(String str) {
        HttpUrl parse = HttpUrl.parse(str);
        if ((com.baidu.swan.apps.ae.b.Lq() == null ? null : com.baidu.swan.apps.ae.b.Lq().getActivity()) == null) {
            if (a(parse)) {
                return parse;
            }
            return null;
        } else if ((DEBUG && com.baidu.swan.apps.ac.a.a.Io()) || a(parse)) {
            return parse;
        } else {
            return null;
        }
    }

    protected static boolean a(@Nullable HttpUrl httpUrl) {
        boolean LX = com.baidu.swan.apps.af.a.b.LX();
        if (!com.baidu.swan.apps.u.a.DE().vM()) {
            LX = false;
        }
        if (httpUrl != null) {
            return (!LX || HttpUrl.defaultPort(httpUrl.scheme()) == httpUrl.port()) && !aDV.contains(httpUrl.host().toLowerCase());
        }
        return false;
    }

    protected static HashMap<String, String> I(@Nullable JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() < 1) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next) && !aDW.contains(next.toUpperCase())) {
                String optString = jSONObject.optString(next);
                if (!TextUtils.isEmpty(optString)) {
                    hashMap.put(next, optString);
                }
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static HashMap<String, String> a(@Nullable JSONObject jSONObject, boolean z) {
        HashMap<String, String> I = I(jSONObject);
        if (z) {
            if (I == null) {
                I = new HashMap<>();
            }
            I.put("Referer", Hb());
        }
        return I;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String fE(String str) {
        return str + "_" + System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public JSONObject fF(String str) {
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

    public static String Hb() {
        com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
        return Lq != null ? String.format("https://smartapp.baidu.com/%s/%s/page-frame.html", Lq.getAppKey(), Lq.LE()) : "";
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
