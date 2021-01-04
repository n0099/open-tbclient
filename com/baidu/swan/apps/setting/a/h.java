package com.baidu.swan.apps.setting.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class h extends aa {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public interface a {
        void j(boolean z, int i);
    }

    public h(j jVar) {
        super(jVar, "/swanAPI/multiAuthorize");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(final Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.runtime.e eVar) {
        if (eVar == null || !(context instanceof Activity)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(401, "runtime parameter error");
            return false;
        }
        JSONObject b2 = b(unitedSchemeEntity, "params");
        if (b2 == null || !b2.has("scopes")) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(100203, "illegal parameter"));
            return false;
        }
        final JSONArray optJSONArray = b2.optJSONArray("scopes");
        if (optJSONArray == null || optJSONArray.length() < 2 || optJSONArray.length() > 4) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(100203, "scopes count error"));
            return false;
        }
        final String optString = b2.optString("cb");
        eVar.aMw().b(context, "scope_multi_authorize", new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.setting.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: a */
            public void L(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                    h.this.a((Activity) context, eVar, callbackHandler, optJSONArray, optString);
                } else {
                    com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, optString);
                }
            }
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.setting.a.h$2  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass2 implements com.baidu.swan.apps.network.c.a.a {
        final /* synthetic */ com.baidu.swan.apps.runtime.e cEQ;
        final /* synthetic */ String cEU;
        final /* synthetic */ JSONArray dLn;
        final /* synthetic */ Activity val$activity;
        final /* synthetic */ CallbackHandler val$handler;

        AnonymousClass2(CallbackHandler callbackHandler, String str, JSONArray jSONArray, com.baidu.swan.apps.runtime.e eVar, Activity activity) {
            this.val$handler = callbackHandler;
            this.cEU = str;
            this.dLn = jSONArray;
            this.cEQ = eVar;
            this.val$activity = activity;
        }

        @Override // com.baidu.swan.apps.network.c.a.a
        public void aGI() {
            final List<com.baidu.swan.apps.setting.oauth.e> a2;
            Map<String, com.baidu.swan.apps.setting.oauth.e> gs = com.baidu.swan.apps.network.c.b.a.gs(true);
            final com.baidu.swan.apps.setting.oauth.e a3 = h.this.a(gs, this.val$handler, this.cEU);
            if (a3 != null && (a2 = h.this.a(gs, this.dLn, this.val$handler, this.cEU)) != null) {
                a3.bb(a2);
                if (this.cEQ.aMx().isLogin(this.val$activity)) {
                    h.this.z(new com.baidu.swan.apps.ao.e.b<String>() { // from class: com.baidu.swan.apps.setting.a.h.2.2
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.ao.e.b
                        /* renamed from: onCallback */
                        public void L(String str) {
                            h.this.a(AnonymousClass2.this.val$activity, a3, str);
                            ak.l(new Runnable() { // from class: com.baidu.swan.apps.setting.a.h.2.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.this.a(a3, a2, false, AnonymousClass2.this.val$activity, AnonymousClass2.this.cEQ, AnonymousClass2.this.val$handler, AnonymousClass2.this.cEU);
                                }
                            });
                        }
                    });
                } else {
                    com.baidu.swan.apps.t.a.aAL().b(this.val$activity, new com.baidu.swan.apps.ao.e.b<Boolean>() { // from class: com.baidu.swan.apps.setting.a.h.2.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.ao.e.b
                        /* renamed from: g */
                        public void L(final Boolean bool) {
                            h.this.a(AnonymousClass2.this.val$activity, a3, bool);
                            ak.l(new Runnable() { // from class: com.baidu.swan.apps.setting.a.h.2.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.this.a(a3, a2, bool.booleanValue(), AnonymousClass2.this.val$activity, AnonymousClass2.this.cEQ, AnonymousClass2.this.val$handler, AnonymousClass2.this.cEU);
                                }
                            });
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public void a(@NonNull Activity activity, @NonNull com.baidu.swan.apps.runtime.e eVar, @NonNull CallbackHandler callbackHandler, @NonNull JSONArray jSONArray, @NonNull String str) {
        com.baidu.swan.apps.network.c.a.aGF().a(new AnonymousClass2(callbackHandler, str, jSONArray, eVar, activity));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.swan.apps.setting.oauth.e> a(Map<String, com.baidu.swan.apps.setting.oauth.e> map, @NonNull JSONArray jSONArray, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        boolean z2 = true;
        int length = jSONArray.length();
        int i = 0;
        while (i < length) {
            String optString = jSONArray.optString(i);
            if (!TextUtils.isEmpty(optString)) {
                if (map.containsKey(optString)) {
                    com.baidu.swan.apps.setting.oauth.e eVar = map.get(optString);
                    if (eVar == null) {
                        z = z2;
                    } else if (!e(eVar)) {
                        com.baidu.swan.apps.setting.oauth.c.a(10005, callbackHandler, str);
                        com.baidu.swan.apps.statistic.h.b(10005, eVar);
                        return null;
                    } else if (eVar.forbidden) {
                        com.baidu.swan.apps.setting.oauth.c.a(10005, callbackHandler, str);
                        com.baidu.swan.apps.statistic.h.b(10005, eVar);
                        return null;
                    } else {
                        if (!arrayList.contains(eVar) && !eVar.aOh()) {
                            arrayList.add(eVar);
                        }
                        if (!eVar.aOh()) {
                            z = false;
                        }
                    }
                } else {
                    z = z2;
                }
                i++;
                z2 = z;
            }
            z = z2;
            i++;
            z2 = z;
        }
        if (z2) {
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            return null;
        }
        com.baidu.swan.apps.console.c.i("MultiAuthorize", "cb=" + str + ", gain=false , scopes=" + arrayList);
        if (arrayList.isEmpty()) {
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(202, "scopes invalid").toString());
            return null;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.setting.oauth.e eVar, final List<com.baidu.swan.apps.setting.oauth.e> list, final boolean z, @NonNull final Activity activity, @NonNull final com.baidu.swan.apps.runtime.e eVar2, @NonNull final CallbackHandler callbackHandler, @NonNull final String str) {
        com.baidu.swan.apps.setting.oauth.c.a(activity, eVar2, eVar, new JSONObject(), new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.a.h.3
            @Override // com.baidu.swan.apps.setting.oauth.a
            public void onResult(boolean z2) {
                com.baidu.swan.apps.console.c.i("MultiAuthorize", "showAuthDialog " + z2);
                if (!z2) {
                    com.baidu.swan.apps.setting.oauth.c.a(10003, callbackHandler, str);
                    return;
                }
                boolean z3 = z;
                if (eVar2.aMx().isLogin(activity)) {
                    h.this.a(list, activity, callbackHandler, str);
                } else if (z3) {
                    h.this.b(list, activity, callbackHandler, str);
                } else {
                    h.this.a(list, activity, callbackHandler, str, eVar2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final List<com.baidu.swan.apps.setting.oauth.e> list, @NonNull final Activity activity, @NonNull final CallbackHandler callbackHandler, @NonNull final String str, @NonNull com.baidu.swan.apps.runtime.e eVar) {
        if (aZ(list)) {
            a(activity, list, callbackHandler, str);
        } else {
            a(eVar, activity, new a() { // from class: com.baidu.swan.apps.setting.a.h.4
                @Override // com.baidu.swan.apps.setting.a.h.a
                public void j(boolean z, int i) {
                    com.baidu.swan.apps.console.c.i("MultiAuthorize", "login result:" + i);
                    if (z) {
                        h.this.a(list, activity, callbackHandler, str);
                    } else {
                        com.baidu.swan.apps.setting.oauth.c.a(10004, callbackHandler, str);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final List<com.baidu.swan.apps.setting.oauth.e> list, @NonNull final Activity activity, @NonNull final CallbackHandler callbackHandler, @NonNull final String str) {
        if (aY(list)) {
            a(activity, list, callbackHandler, str);
        } else {
            z(new com.baidu.swan.apps.ao.e.b<String>() { // from class: com.baidu.swan.apps.setting.a.h.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: onCallback */
                public void L(String str2) {
                    h.this.a(TextUtils.equals(str2, "1"), list, activity, callbackHandler, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final List<com.baidu.swan.apps.setting.oauth.e> list, @NonNull final Activity activity, @NonNull final CallbackHandler callbackHandler, @NonNull final String str) {
        if (z) {
            com.baidu.swan.apps.console.c.i("MultiAuthorize", "onCallback: real name success");
            a(activity, list, callbackHandler, str);
            return;
        }
        com.baidu.swan.apps.console.c.i("MultiAuthorize", "onCallback: real name fail");
        y(new com.baidu.swan.apps.ao.e.b<String>() { // from class: com.baidu.swan.apps.setting.a.h.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: onCallback */
            public void L(String str2) {
                if (!TextUtils.isEmpty(str2)) {
                    h.this.a(activity, list, callbackHandler, str);
                } else {
                    com.baidu.swan.apps.setting.oauth.c.a(10003, callbackHandler, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final List<com.baidu.swan.apps.setting.oauth.e> list, @NonNull final Activity activity, @NonNull final CallbackHandler callbackHandler, @NonNull final String str) {
        com.baidu.swan.apps.t.a.aAL().a(new com.baidu.swan.apps.ao.e.b<Integer>() { // from class: com.baidu.swan.apps.setting.a.h.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: f */
            public void L(Integer num) {
                if (num.intValue() == 0) {
                    h.this.a(list, activity, callbackHandler, str);
                } else {
                    com.baidu.swan.apps.setting.oauth.c.a(10003, callbackHandler, str);
                }
            }
        });
    }

    private void y(com.baidu.swan.apps.ao.e.b<String> bVar) {
        com.baidu.swan.apps.t.a.aAL().a(false, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(com.baidu.swan.apps.ao.e.b<String> bVar) {
        com.baidu.swan.apps.t.a.aAL().a(com.baidu.swan.apps.t.a.aAr(), bVar);
    }

    private boolean aY(List<com.baidu.swan.apps.setting.oauth.e> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        for (com.baidu.swan.apps.setting.oauth.e eVar : list) {
            if (eVar != null && f(eVar)) {
                return false;
            }
        }
        return true;
    }

    private boolean aZ(List<com.baidu.swan.apps.setting.oauth.e> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        boolean z = true;
        for (com.baidu.swan.apps.setting.oauth.e eVar : list) {
            if (eVar != null) {
                z = !d(eVar) ? false : z;
            }
        }
        return z;
    }

    private boolean ba(List<com.baidu.swan.apps.setting.oauth.e> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        for (com.baidu.swan.apps.setting.oauth.e eVar : list) {
            if (eVar != null && f(eVar)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.apps.setting.oauth.e a(Map<String, com.baidu.swan.apps.setting.oauth.e> map, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        com.baidu.swan.apps.setting.oauth.e eVar = map.get("scope_multi_authorize");
        if (eVar == null) {
            com.baidu.swan.apps.setting.oauth.c.a(10001, callbackHandler, str);
            com.baidu.swan.apps.statistic.h.b(10001, null);
            return null;
        } else if (eVar.forbidden) {
            com.baidu.swan.apps.setting.oauth.c.a(10005, callbackHandler, str);
            com.baidu.swan.apps.statistic.h.b(10005, eVar);
            return null;
        } else {
            return eVar;
        }
    }

    private void a(@NonNull com.baidu.swan.apps.runtime.e eVar, @NonNull Activity activity, a aVar) {
        b(eVar, activity, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull Activity activity, @NonNull List<com.baidu.swan.apps.setting.oauth.e> list, @NonNull final CallbackHandler callbackHandler, final String str) {
        int size = list.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = list.get(i).id;
        }
        com.baidu.swan.apps.runtime.d.aMg().aMi().ajN().alG().a(activity, false, true, strArr, null, true).A(new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.setting.a.h.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: a */
            public void L(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                if (hVar == null) {
                    com.baidu.swan.apps.setting.oauth.c.a(10001, callbackHandler, str);
                    com.baidu.swan.apps.statistic.h.b(10001, null);
                    return;
                }
                int errorCode = hVar.getErrorCode();
                com.baidu.swan.apps.console.c.w("MultiAuthorize", "requestAuthorize " + hVar.aOt() + ",  code=" + errorCode + ", data=" + hVar.mData);
                if (errorCode != 0) {
                    com.baidu.swan.apps.setting.oauth.c.a(errorCode, callbackHandler, str);
                } else {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0, "success").toString());
                }
            }
        }).aOb();
    }

    private boolean d(com.baidu.swan.apps.setting.oauth.e eVar) {
        return TextUtils.equals(eVar.id, "mapp_location") || TextUtils.equals(eVar.id, "mapp_images") || TextUtils.equals(eVar.id, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(eVar.id, PermissionProxy.SCOPE_ID_CAMERA);
    }

    private boolean e(com.baidu.swan.apps.setting.oauth.e eVar) {
        return TextUtils.equals(eVar.id, "mapp_location") || TextUtils.equals(eVar.id, "mapp_images") || TextUtils.equals(eVar.id, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(eVar.id, PermissionProxy.SCOPE_ID_CAMERA) || TextUtils.equals(eVar.id, "ppcert") || TextUtils.equals(eVar.id, "mapp_i_face_verify") || TextUtils.equals(eVar.id, "snsapi_userinfo") || TextUtils.equals(eVar.id, "mapp_choose_address") || TextUtils.equals(eVar.id, "mobile") || TextUtils.equals(eVar.id, "mapp_choose_invoice");
    }

    private boolean f(com.baidu.swan.apps.setting.oauth.e eVar) {
        return TextUtils.equals(eVar.id, "ppcert") || TextUtils.equals(eVar.id, "mapp_i_face_verify");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull Activity activity, com.baidu.swan.apps.setting.oauth.e eVar, String str) {
        String name = com.baidu.swan.apps.runtime.d.aMg().aMc().getName();
        boolean equals = TextUtils.equals(str, "1");
        if (ba(eVar.dLW)) {
            if (equals) {
                eVar.dLV = activity.getString(a.h.swanapp_multi_auth_realname_name_head) + name + activity.getString(a.h.swanapp_multi_auth_realname_name_end);
                return;
            } else {
                eVar.dLV = activity.getString(a.h.swanapp_multi_auth_un_realname_name_head) + name + activity.getString(a.h.swanapp_multi_auth_un_realname_name_end);
                return;
            }
        }
        eVar.dLV = activity.getString(a.h.swanapp_multi_auth_realname_name_head) + name + activity.getString(a.h.swanapp_multi_auth_realname_name_end);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull Activity activity, com.baidu.swan.apps.setting.oauth.e eVar, Boolean bool) {
        String name = com.baidu.swan.apps.runtime.d.aMg().aMc().getName();
        boolean aZ = aZ(eVar.dLW);
        boolean ba = ba(eVar.dLW);
        if (bool.booleanValue() || aZ) {
            if (ba) {
                eVar.dLV = activity.getString(a.h.swanapp_multi_auth_un_realname_name_head) + name + activity.getString(a.h.swanapp_multi_auth_not_login_name_end);
                return;
            } else {
                eVar.dLV = activity.getString(a.h.swanapp_multi_auth_not_login_name_head) + name + activity.getString(a.h.swanapp_multi_auth_not_login_name_end);
                return;
            }
        }
        eVar.dLV = activity.getString(a.h.swanapp_multi_auth_guest_login_name_head) + name + activity.getString(a.h.swanapp_multi_auth_guest_login_name_end);
    }

    private void b(@NonNull com.baidu.swan.apps.runtime.e eVar, @NonNull Activity activity, @NonNull final a aVar) {
        eVar.aMx().a(activity, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.a.h.9
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                switch (i) {
                    case 0:
                        aVar.j(true, i);
                        return;
                    default:
                        aVar.j(false, i);
                        return;
                }
            }
        });
    }
}
