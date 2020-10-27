package com.baidu.swan.apps.setting.a;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.AnyThread;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class h extends aa {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public interface a {
        void k(boolean z, int i);
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
        JSONObject b = b(unitedSchemeEntity, "params");
        if (b == null || !b.has("scopes")) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(100203, "illegal parameter"));
            return false;
        }
        final JSONArray optJSONArray = b.optJSONArray("scopes");
        if (optJSONArray == null || optJSONArray.length() < 2 || optJSONArray.length() > 4) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(100203, "scopes count error"));
            return false;
        }
        final String optString = b.optString("cb");
        eVar.aFg().b(context, "scope_multi_authorize", new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.setting.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void M(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
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
    /* loaded from: classes10.dex */
    public class AnonymousClass2 implements com.baidu.swan.apps.network.c.a.a {
        final /* synthetic */ com.baidu.swan.apps.runtime.e coT;
        final /* synthetic */ String coX;
        final /* synthetic */ JSONArray drx;
        final /* synthetic */ Activity val$activity;
        final /* synthetic */ CallbackHandler val$handler;

        AnonymousClass2(CallbackHandler callbackHandler, String str, JSONArray jSONArray, com.baidu.swan.apps.runtime.e eVar, Activity activity) {
            this.val$handler = callbackHandler;
            this.coX = str;
            this.drx = jSONArray;
            this.coT = eVar;
            this.val$activity = activity;
        }

        @Override // com.baidu.swan.apps.network.c.a.a
        public void aAn() {
            final List<com.baidu.swan.apps.setting.oauth.e> a2;
            Map<String, com.baidu.swan.apps.setting.oauth.e> fI = com.baidu.swan.apps.network.c.b.a.fI(true);
            final com.baidu.swan.apps.setting.oauth.e a3 = h.this.a(fI, this.val$handler, this.coX);
            if (a3 != null && (a2 = h.this.a(fI, this.drx, this.val$handler, this.coX)) != null) {
                a3.aK(a2);
                if (this.coT.aFh().isLogin(this.val$activity)) {
                    h.this.z(new com.baidu.swan.apps.ap.e.b<String>() { // from class: com.baidu.swan.apps.setting.a.h.2.2
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.ap.e.b
                        /* renamed from: onCallback */
                        public void M(String str) {
                            h.this.a(AnonymousClass2.this.val$activity, a3, str);
                            ak.m(new Runnable() { // from class: com.baidu.swan.apps.setting.a.h.2.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.this.a(a3, a2, false, AnonymousClass2.this.val$activity, AnonymousClass2.this.coT, AnonymousClass2.this.val$handler, AnonymousClass2.this.coX);
                                }
                            });
                        }
                    });
                } else {
                    com.baidu.swan.apps.t.a.auu().b(this.val$activity, new com.baidu.swan.apps.ap.e.b<Boolean>() { // from class: com.baidu.swan.apps.setting.a.h.2.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.ap.e.b
                        /* renamed from: f */
                        public void M(final Boolean bool) {
                            h.this.a(AnonymousClass2.this.val$activity, a3, bool);
                            ak.m(new Runnable() { // from class: com.baidu.swan.apps.setting.a.h.2.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.this.a(a3, a2, bool.booleanValue(), AnonymousClass2.this.val$activity, AnonymousClass2.this.coT, AnonymousClass2.this.val$handler, AnonymousClass2.this.coX);
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
        com.baidu.swan.apps.network.c.a.aAk().a(new AnonymousClass2(callbackHandler, str, jSONArray, eVar, activity));
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
                        if (!arrayList.contains(eVar) && !eVar.aGR()) {
                            arrayList.add(eVar);
                        }
                        if (!eVar.aGR()) {
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
                if (eVar2.aFh().isLogin(activity)) {
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
        if (aI(list)) {
            a(activity, list, callbackHandler, str);
        } else {
            a(eVar, activity, new a() { // from class: com.baidu.swan.apps.setting.a.h.4
                @Override // com.baidu.swan.apps.setting.a.h.a
                public void k(boolean z, int i) {
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
        if (aH(list)) {
            a(activity, list, callbackHandler, str);
        } else {
            z(new com.baidu.swan.apps.ap.e.b<String>() { // from class: com.baidu.swan.apps.setting.a.h.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: onCallback */
                public void M(String str2) {
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
        y(new com.baidu.swan.apps.ap.e.b<String>() { // from class: com.baidu.swan.apps.setting.a.h.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: onCallback */
            public void M(String str2) {
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
        com.baidu.swan.apps.t.a.auu().a(new com.baidu.swan.apps.ap.e.b<Integer>() { // from class: com.baidu.swan.apps.setting.a.h.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: d */
            public void M(Integer num) {
                if (num.intValue() == 0) {
                    h.this.a(list, activity, callbackHandler, str);
                } else {
                    com.baidu.swan.apps.setting.oauth.c.a(10003, callbackHandler, str);
                }
            }
        });
    }

    private void y(com.baidu.swan.apps.ap.e.b<String> bVar) {
        com.baidu.swan.apps.t.a.auu().a(false, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(com.baidu.swan.apps.ap.e.b<String> bVar) {
        com.baidu.swan.apps.t.a.auu().a(com.baidu.swan.apps.t.a.aua(), bVar);
    }

    private boolean aH(List<com.baidu.swan.apps.setting.oauth.e> list) {
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

    private boolean aI(List<com.baidu.swan.apps.setting.oauth.e> list) {
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

    private boolean aJ(List<com.baidu.swan.apps.setting.oauth.e> list) {
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
        com.baidu.swan.apps.runtime.d.aEQ().aES().adF().afw().a(activity, false, true, strArr, null, true).A(new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.setting.a.h.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void M(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                if (hVar == null) {
                    com.baidu.swan.apps.setting.oauth.c.a(10001, callbackHandler, str);
                    com.baidu.swan.apps.statistic.h.b(10001, null);
                    return;
                }
                int errorCode = hVar.getErrorCode();
                com.baidu.swan.apps.console.c.w("MultiAuthorize", "requestAuthorize " + hVar.aHd() + ",  code=" + errorCode + ", data=" + hVar.mData);
                if (errorCode != 0) {
                    com.baidu.swan.apps.setting.oauth.c.a(errorCode, callbackHandler, str);
                } else {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0, "success").toString());
                }
            }
        }).aGL();
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
        String name = com.baidu.swan.apps.runtime.d.aEQ().aEM().getName();
        boolean equals = TextUtils.equals(str, "1");
        if (aJ(eVar.dsg)) {
            if (equals) {
                eVar.dsf = activity.getString(a.h.swanapp_multi_auth_realname_name_head) + name + activity.getString(a.h.swanapp_multi_auth_realname_name_end);
                return;
            } else {
                eVar.dsf = activity.getString(a.h.swanapp_multi_auth_un_realname_name_head) + name + activity.getString(a.h.swanapp_multi_auth_un_realname_name_end);
                return;
            }
        }
        eVar.dsf = activity.getString(a.h.swanapp_multi_auth_realname_name_head) + name + activity.getString(a.h.swanapp_multi_auth_realname_name_end);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull Activity activity, com.baidu.swan.apps.setting.oauth.e eVar, Boolean bool) {
        String name = com.baidu.swan.apps.runtime.d.aEQ().aEM().getName();
        boolean aI = aI(eVar.dsg);
        boolean aJ = aJ(eVar.dsg);
        if (bool.booleanValue() || aI) {
            if (aJ) {
                eVar.dsf = activity.getString(a.h.swanapp_multi_auth_un_realname_name_head) + name + activity.getString(a.h.swanapp_multi_auth_not_login_name_end);
                return;
            } else {
                eVar.dsf = activity.getString(a.h.swanapp_multi_auth_not_login_name_head) + name + activity.getString(a.h.swanapp_multi_auth_not_login_name_end);
                return;
            }
        }
        eVar.dsf = activity.getString(a.h.swanapp_multi_auth_guest_login_name_head) + name + activity.getString(a.h.swanapp_multi_auth_guest_login_name_end);
    }

    private void b(@NonNull com.baidu.swan.apps.runtime.e eVar, @NonNull Activity activity, @NonNull final a aVar) {
        eVar.aFh().a(activity, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.a.h.9
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                switch (i) {
                    case 0:
                        aVar.k(true, i);
                        return;
                    default:
                        aVar.k(false, i);
                        return;
                }
            }
        });
    }
}
