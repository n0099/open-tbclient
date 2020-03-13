package com.baidu.swan.apps.setting.a;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.AnyThread;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class h extends ab {
    private AtomicBoolean bSS;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public interface a {
        void g(boolean z, int i);
    }

    public h(j jVar) {
        super(jVar, "/swanAPI/multiAuthorize");
        this.bSS = new AtomicBoolean(false);
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.runtime.e eVar) {
        if (eVar == null || !(context instanceof Activity)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(401, "runtime parameter error");
            return false;
        }
        JSONObject b = b(unitedSchemeEntity, "params");
        if (b == null || !b.has("scopes")) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(100203, "illegal parameter"));
            return false;
        }
        final JSONArray optJSONArray = b.optJSONArray("scopes");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(100203, "scopes empty"));
            return false;
        }
        final String optString = b.optString("cb");
        eVar.acP().b(context, "scope_multi_authorize", new com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.setting.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void D(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                    h.this.a((Activity) context, eVar, unitedSchemeEntity, callbackHandler, optJSONArray, optString);
                } else {
                    com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, optString);
                }
            }
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public void a(@NonNull final Activity activity, @NonNull final com.baidu.swan.apps.runtime.e eVar, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull final CallbackHandler callbackHandler, @NonNull final JSONArray jSONArray, @NonNull final String str) {
        com.baidu.swan.apps.network.c.a.Zb().a(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.setting.a.h.2
            @Override // com.baidu.swan.apps.network.c.a.a
            public void Zf() {
                int i;
                Map<String, com.baidu.swan.apps.setting.oauth.e> Zn = com.baidu.swan.apps.network.c.b.a.Zn();
                com.baidu.swan.apps.setting.oauth.e eVar2 = Zn.get("scope_multi_authorize");
                if (eVar2 == null) {
                    com.baidu.swan.apps.setting.oauth.c.a(10001, callbackHandler, str);
                } else if (eVar2.forbidden) {
                    com.baidu.swan.apps.setting.oauth.c.a(10005, callbackHandler, str);
                } else {
                    final ArrayList arrayList = new ArrayList();
                    int length = jSONArray.length();
                    int i2 = 0;
                    int i3 = 0;
                    while (i2 < length) {
                        String optString = jSONArray.optString(i2);
                        if (!TextUtils.isEmpty(optString)) {
                            if (Zn.containsKey(optString)) {
                                com.baidu.swan.apps.setting.oauth.e eVar3 = Zn.get(optString);
                                if (eVar3 == null) {
                                    i = i3;
                                } else if (eVar3.forbidden) {
                                    com.baidu.swan.apps.setting.oauth.c.a(10005, callbackHandler, str);
                                    return;
                                } else {
                                    arrayList.add(eVar3);
                                    if (eVar3.aeo()) {
                                        i = i3 + 1;
                                    }
                                }
                            } else {
                                i = i3;
                            }
                            i2++;
                            i3 = i;
                        }
                        i = i3;
                        i2++;
                        i3 = i;
                    }
                    if (!arrayList.isEmpty()) {
                        if (!h.this.bSS.compareAndSet(false, true)) {
                            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, "Waiting for the end of the previous authorization process").toString());
                            return;
                        }
                        com.baidu.swan.apps.console.c.i("MultiAuthorize", "cb=" + str + ", gain=" + i3 + ", scopes=" + arrayList);
                        if (arrayList.size() == i3) {
                            h.this.bSS.set(false);
                            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                            return;
                        }
                        int size = arrayList.size();
                        StringBuilder sb = new StringBuilder();
                        for (int i4 = 0; i4 < size; i4++) {
                            sb.append(((com.baidu.swan.apps.setting.oauth.e) arrayList.get(i4)).bTo);
                            if (i4 < size - 1) {
                                sb.append("、");
                            }
                        }
                        eVar2.name = activity.getString(a.h.swanapp_get_following_info, new Object[]{sb.toString()});
                        try {
                            eVar2.bTs = String.format(eVar2.bTs, sb.toString());
                        } catch (Exception e) {
                            com.baidu.swan.apps.console.c.e("MultiAuthorize", "format explain error", e);
                        }
                        com.baidu.swan.apps.setting.oauth.c.a(activity, eVar, eVar2, new JSONObject(), new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.a.h.2.1
                            @Override // com.baidu.swan.apps.setting.oauth.a
                            public void onResult(boolean z) {
                                com.baidu.swan.apps.console.c.d("MultiAuthorize", "showAuthDialog " + z);
                                if (z) {
                                    h.this.a(eVar, activity, (List<com.baidu.swan.apps.setting.oauth.e>) arrayList, false, callbackHandler, str);
                                    return;
                                }
                                h.this.bSS.set(false);
                                com.baidu.swan.apps.setting.oauth.c.a(10003, callbackHandler, str);
                            }
                        });
                        return;
                    }
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(202, "scopes invalid").toString());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull final com.baidu.swan.apps.runtime.e eVar, @NonNull final Activity activity, @NonNull final List<com.baidu.swan.apps.setting.oauth.e> list, boolean z, @NonNull final CallbackHandler callbackHandler, final String str) {
        boolean isLogin = eVar.acQ().isLogin(activity);
        com.baidu.swan.apps.console.c.i("MultiAuthorize", "requestAuthorize login " + isLogin);
        if (!isLogin) {
            a aVar = new a() { // from class: com.baidu.swan.apps.setting.a.h.3
                @Override // com.baidu.swan.apps.setting.a.h.a
                public void g(boolean z2, int i) {
                    com.baidu.swan.apps.console.c.i("MultiAuthorize", "login result:" + i);
                    h.this.bSS.set(false);
                    if (z2) {
                        h.this.a(eVar, activity, (List<com.baidu.swan.apps.setting.oauth.e>) list, true, callbackHandler, str);
                    } else {
                        com.baidu.swan.apps.setting.oauth.c.a(10004, callbackHandler, str);
                    }
                }
            };
            if (!z) {
                a(eVar, activity, aVar);
                return;
            } else {
                aVar.g(false, -2);
                return;
            }
        }
        this.bSS.set(false);
        int size = list.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = list.get(i).id;
        }
        com.baidu.swan.apps.runtime.d.acC().acE().GV().HS().a(activity, false, true, strArr, null, true).h(new com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.setting.a.h.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void D(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                if (hVar == null) {
                    com.baidu.swan.apps.setting.oauth.c.a(10001, callbackHandler, str);
                    return;
                }
                int errorCode = hVar.getErrorCode();
                com.baidu.swan.apps.console.c.d("MultiAuthorize", "requestAuthorize " + hVar.aex() + ",  code=" + errorCode + ", data=" + hVar.mData);
                if (errorCode != 0) {
                    com.baidu.swan.apps.setting.oauth.c.a(errorCode, callbackHandler, str);
                } else {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0, "success").toString());
                }
            }
        }).aei();
    }

    private void a(@NonNull com.baidu.swan.apps.runtime.e eVar, @NonNull Activity activity, @NonNull final a aVar) {
        eVar.acQ().a(activity, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.a.h.5
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                switch (i) {
                    case 0:
                        aVar.g(true, i);
                        return;
                    default:
                        aVar.g(false, i);
                        return;
                }
            }
        });
    }
}
