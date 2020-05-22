package com.baidu.swan.apps.network;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.aa;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Headers;
import org.apache.http.cookie.SM;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends aa {
    public static final Set<String> bLI = com.facebook.common.internal.i.O("REFERER", "USER-AGENT");
    protected ConcurrentHashMap<String, Long> cpN;

    public a(com.baidu.swan.apps.scheme.j jVar, String str) {
        super(jVar, str);
        this.cpN = new ConcurrentHashMap<>();
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        return false;
    }

    public final long mf(String str) {
        long j;
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            j = this.cpN.get(str).longValue();
        } catch (Exception e) {
            j = 0;
        }
        return j;
    }

    public final void mg(String str) {
        if (this.cpN != null && !TextUtils.isEmpty(str)) {
            this.cpN.remove(str);
        }
    }

    protected static HashMap<String, String> aI(@Nullable JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() < 1) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next) && !bLI.contains(next.toUpperCase())) {
                String optString = jSONObject.optString(next);
                if (TextUtils.isEmpty(optString)) {
                    optString = "";
                }
                hashMap.put(next, optString);
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static HashMap<String, String> c(@Nullable JSONObject jSONObject, boolean z) {
        HashMap<String, String> aI = aI(jSONObject);
        if (z) {
            if (aI == null) {
                aI = new HashMap<>();
            }
            aI.put("Referer", com.baidu.swan.apps.api.module.network.c.Uj());
        }
        return aI;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public JSONObject hN(String str) {
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

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(com.baidu.swan.apps.runtime.e eVar, UnitedSchemeEntity unitedSchemeEntity) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
            return false;
        }
        JSONObject b = b(unitedSchemeEntity, "params");
        if (b == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal params");
            return false;
        } else if (TextUtils.isEmpty(b.optString("cb"))) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal cb");
            return false;
        } else if (TextUtils.isEmpty(b.optString("url"))) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal url");
            return false;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t(@NonNull JSONObject jSONObject, String str) throws JSONException {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            String optString = jSONObject.optString(SM.COOKIE);
            if (TextUtils.isEmpty(optString)) {
                jSONObject.put(SM.COOKIE, str);
                return;
            }
            if (optString.endsWith(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR)) {
                str2 = optString + str;
            } else {
                str2 = optString + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + str;
            }
            jSONObject.put(SM.COOKIE, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String akw() {
        return com.baidu.swan.apps.u.a.afo().SM().getCookie(".baidu.com");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public JSONObject fY(int i) {
        switch (i) {
            case 0:
                return UnitedSchemeUtility.wrapCallbackParams(0);
            case 1:
                return UnitedSchemeUtility.wrapCallbackParams(202, "illegal request");
            case 2:
                return UnitedSchemeUtility.wrapCallbackParams(202, "request url header must be https or wss");
            case 3:
                return UnitedSchemeUtility.wrapCallbackParams(202, "request:fail parameter error: arrayBuffer of data exceed size limit.");
            case 4:
                return UnitedSchemeUtility.wrapCallbackParams(202, "HTTP method is invalid");
            case 5:
                return UnitedSchemeUtility.wrapCallbackParams(202, "illegal upload file over size.");
            default:
                return UnitedSchemeUtility.wrapCallbackParams(202, "illegal request");
        }
    }
}
