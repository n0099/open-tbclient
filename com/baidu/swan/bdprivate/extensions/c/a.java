package com.baidu.swan.bdprivate.extensions.c;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.api.a.c;
import com.baidu.swan.apps.api.a.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.setting.oauth.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class a extends d {
    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    @SuppressLint({"SwanBindApiNote"})
    public com.baidu.swan.apps.api.c.b vx(String str) {
        return a(str, new c("getCommonSysInfo") { // from class: com.baidu.swan.bdprivate.extensions.c.a.1
            @Override // com.baidu.swan.apps.api.a.c
            protected boolean alZ() {
                return com.baidu.swan.apps.runtime.d.aJQ().aId() && com.baidu.swan.apps.runtime.d.aJQ().aJM().aKg().tp("mapp_i_get_common_sys_info");
            }

            @Override // com.baidu.swan.apps.api.a.c
            @NonNull
            protected com.baidu.swan.apps.api.c.b a(@NonNull JSONObject jSONObject, @NonNull final c.a aVar) {
                e aJV = e.aJV();
                if (aJV == null) {
                    if (d.DEBUG) {
                        Log.e("Api-getCommonSysInfo", "getCommonSysInfo failed: null swan runtime");
                    }
                    return new com.baidu.swan.apps.api.c.b(1001, "null swan runtime");
                }
                aJV.aKg().b(com.baidu.swan.apps.runtime.d.aJQ(), "mapp_i_get_common_sys_info", new com.baidu.swan.apps.ap.e.b<h<b.d>>() { // from class: com.baidu.swan.bdprivate.extensions.c.a.1.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ap.e.b
                    /* renamed from: a */
                    public void M(h<b.d> hVar) {
                        if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                            aVar.b(a.this.aQH());
                            return;
                        }
                        int errorCode = hVar.getErrorCode();
                        String hX = com.baidu.swan.apps.setting.oauth.c.hX(errorCode);
                        if (d.DEBUG) {
                            Log.e("Api-getCommonSysInfo", "getCommonSysInfo failed: auth fail(" + errorCode + ", " + hX + ")");
                        }
                        aVar.b(new com.baidu.swan.apps.api.c.b(errorCode, hX));
                    }
                });
                return new com.baidu.swan.apps.api.c.b(0);
            }

            @Override // com.baidu.swan.apps.api.a.c
            @NonNull
            protected com.baidu.swan.apps.api.c.b aE(@NonNull JSONObject jSONObject) {
                return a.this.aQH();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public com.baidu.swan.apps.api.c.b aQH() {
        com.baidu.swan.apps.runtime.d aJQ = com.baidu.swan.apps.runtime.d.aJQ();
        String bW = com.baidu.swan.apps.t.a.azf().bW(aJQ);
        String aPx = ak.aPx();
        String str = "";
        String str2 = "";
        String str3 = "";
        Bundle bundle = new Bundle();
        bundle.putString("httpUrl", ".baidu.com");
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(aJQ, C0517a.class, bundle);
        if (callOnMainWithContentProvider.isOk()) {
            str = callOnMainWithContentProvider.mResult.getString("zid");
            str2 = callOnMainWithContentProvider.mResult.getString("uid");
            str3 = callOnMainWithContentProvider.mResult.getString("cookie");
        }
        String cookieValue = ai.getCookieValue(str3, "BAIDUID");
        String cookieValue2 = ai.getCookieValue(str3, "H_WISE_SIDS");
        String uuid = com.baidu.swan.uuid.b.et(AppRuntime.getAppContext()).getUUID();
        if (DEBUG) {
            Log.d("Api-getCommonSysInfo", "cuid = " + bW + ", imei = " + aPx + ", zid = " + str + ", uid = " + str2 + ", baiduId = " + cookieValue + ", sid = " + cookieValue2 + ", uuid = " + uuid);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cuid", bW);
            jSONObject.put("imei", aPx);
            jSONObject.put("zid", str);
            jSONObject.put("uid", str2);
            jSONObject.put("baidu_id", cookieValue);
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SID, cookieValue2);
            jSONObject.put("uuid", uuid);
            if (DEBUG) {
                Log.d("Api-getCommonSysInfo", "getCommonSysInfo success: " + jSONObject.toString());
            }
            return new com.baidu.swan.apps.api.c.b(0, jSONObject);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("Api-getCommonSysInfo", "getCommonSysInfo failed: JsonException");
                e.printStackTrace();
            }
            return new com.baidu.swan.apps.api.c.b(1001, "result JSONException");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.bdprivate.extensions.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static class C0517a extends ProviderDelegation {
        private C0517a() {
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            String string = bundle.getString("httpUrl");
            Bundle bundle2 = new Bundle();
            bundle2.putString("zid", com.baidu.swan.bdprivate.a.a.cM(com.baidu.swan.apps.runtime.d.aJQ()));
            bundle2.putString("uid", com.baidu.swan.apps.t.a.azf().bV(com.baidu.swan.apps.runtime.d.aJQ()));
            bundle2.putString("cookie", TextUtils.isEmpty(string) ? "" : com.baidu.swan.apps.t.a.azz().akJ().getCookie(string));
            return bundle2;
        }
    }
}
