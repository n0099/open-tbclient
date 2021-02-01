package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ao.ai;
import com.baidu.swan.apps.ao.am;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.pms.c.d.e;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class h extends aa {
    public h(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/downloadPackages");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        com.baidu.swan.apps.console.c.i("DownloadPackagesAction", "call DownloadPackagesAction, thread=" + Thread.currentThread().getName());
        JSONObject b2 = b(unitedSchemeEntity, "params");
        if (b2 == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "invalid parameter");
            return false;
        }
        final JSONArray optJSONArray = b2.optJSONArray("appKeys");
        final JSONObject optJSONObject = b2.optJSONObject("appList");
        if ((optJSONArray == null || optJSONArray.length() == 0) && optJSONObject == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "appKeys must not empty");
            return false;
        }
        String optString = b2.optString("netconf");
        if (TextUtils.isEmpty(optString)) {
            optString = "0";
        }
        if (!com.baidu.swan.apps.core.a.a.a.mm(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "Network limitation");
            return false;
        }
        final String a2 = a(callbackHandler);
        if (!b(callbackHandler)) {
            if (optJSONArray != null) {
                c(optJSONArray, a2);
            }
            if (optJSONObject != null) {
                com.baidu.swan.apps.ao.p.b(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.h.1
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.t(optJSONObject, a2);
                    }
                }, "handlePreDownloadByCommand");
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        } else if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
            return false;
        } else {
            eVar.aIW().b(context, "mapp_pre_download", new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.scheme.actions.h.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: a */
                public void L(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                    h.this.a(hVar, unitedSchemeEntity, callbackHandler, optJSONArray, a2);
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
    public void t(@NonNull JSONObject jSONObject, String str) {
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
                        bVar.J((String[]) arrayList2.toArray(new String[arrayList2.size()]));
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
            com.baidu.swan.apps.ao.p.a(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.h.3
                @Override // java.lang.Runnable
                public void run() {
                    List<String> g = com.baidu.swan.apps.core.pms.d.a.g(arrayList);
                    if (!g.isEmpty()) {
                        com.baidu.swan.pms.c.d.b bVar = new com.baidu.swan.pms.c.d.b((Collection<String>) g, (com.baidu.swan.pms.utils.a) am.aOu());
                        bVar.yk(str);
                        bVar.yj("1");
                        com.baidu.swan.pms.c.a(bVar, new com.baidu.swan.apps.core.pms.d().gW(5));
                    }
                }
            }, "小程序端能力-批量下载");
        }
    }

    @NonNull
    private String a(CallbackHandler callbackHandler) {
        return c(callbackHandler) ? Constants.VIA_REPORT_TYPE_SHARE_TO_QQ : "2";
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
