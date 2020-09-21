package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.AnyThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.ap.am;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.pms.c.d.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h extends aa {
    public h(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/downloadPackages");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        com.baidu.swan.apps.console.c.i("DownloadPackagesAction", "call DownloadPackagesAction, thread=" + Thread.currentThread().getName());
        JSONObject b = b(unitedSchemeEntity, "params");
        if (b == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "invalid parameter");
            return false;
        }
        final JSONArray optJSONArray = b.optJSONArray("appKeys");
        final JSONObject optJSONObject = b.optJSONObject("appList");
        if ((optJSONArray == null || optJSONArray.length() == 0) && optJSONObject == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "appKeys must not empty");
            return false;
        }
        String optString = b.optString("netconf");
        if (TextUtils.isEmpty(optString)) {
            optString = "0";
        }
        if (!com.baidu.swan.apps.core.a.a.a.lr(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "Network limitation");
            return false;
        }
        final String a = a(callbackHandler);
        if (!b(callbackHandler)) {
            if (optJSONArray != null) {
                c(optJSONArray, a);
            }
            if (optJSONObject != null) {
                com.baidu.swan.apps.ap.p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.h.1
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.x(optJSONObject, a);
                    }
                }, "handlePreDownloadByCommand");
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        } else if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
            return false;
        } else {
            eVar.aAD().b(context, "mapp_pre_download", new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.scheme.actions.h.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: a */
                public void J(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                    h.this.a(hVar, unitedSchemeEntity, callbackHandler, optJSONArray, a);
                }
            });
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.setting.oauth.h<b.d> hVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONArray jSONArray, String str) {
        if (!com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
            com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, unitedSchemeEntity);
            return;
        }
        c(jSONArray, str);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public void x(@NonNull JSONObject jSONObject, String str) {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next)) {
                e.b bVar = new e.b(next);
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("commands")) != null && optJSONArray.length() > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        String optString = optJSONArray.optString(i);
                        if (!TextUtils.isEmpty(optString)) {
                            try {
                                Uri parse = Uri.parse(optString);
                                if (parse != null) {
                                    arrayList2.add(ai.a(next, parse, false));
                                }
                            } catch (Exception e) {
                                if (DEBUG) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                    if (!arrayList2.isEmpty()) {
                        bVar.A((String[]) arrayList2.toArray(new String[arrayList2.size()]));
                    }
                }
                arrayList.add(bVar);
            }
        }
        com.baidu.swan.apps.core.a.a.a.e(arrayList, str);
    }

    private void c(@Nullable JSONArray jSONArray, final String str) {
        if (jSONArray != null) {
            final ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.optString(i));
            }
            com.baidu.swan.apps.ap.p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.h.3
                @Override // java.lang.Runnable
                public void run() {
                    List<String> g = com.baidu.swan.apps.core.pms.d.a.g(arrayList);
                    if (!g.isEmpty()) {
                        com.baidu.swan.pms.c.d.b bVar = new com.baidu.swan.pms.c.d.b((Collection<String>) g, (com.baidu.swan.pms.utils.a) am.aGb());
                        bVar.xi(str);
                        bVar.xh("1");
                        com.baidu.swan.pms.c.a(bVar, new com.baidu.swan.apps.core.pms.d().hs(5));
                    }
                }
            }, "小程序端能力-批量下载");
        }
    }

    @NonNull
    private String a(CallbackHandler callbackHandler) {
        return c(callbackHandler) ? "10" : "2";
    }

    private boolean b(CallbackHandler callbackHandler) {
        return c(callbackHandler);
    }

    private boolean c(CallbackHandler callbackHandler) {
        if (callbackHandler instanceof TypedCallbackHandler) {
            int invokeSourceType = ((TypedCallbackHandler) callbackHandler).getInvokeSourceType();
            return invokeSourceType == 0 || invokeSourceType == 1;
        }
        return false;
    }
}
