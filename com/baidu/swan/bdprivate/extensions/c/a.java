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
/* loaded from: classes3.dex */
public class a extends d {
    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    @SuppressLint({"SwanBindApiNote"})
    public com.baidu.swan.apps.api.c.b tC(String str) {
        return a(str, new c("getCommonSysInfo") { // from class: com.baidu.swan.bdprivate.extensions.c.a.1
            @Override // com.baidu.swan.apps.api.a.c
            protected boolean act() {
                return com.baidu.swan.apps.runtime.d.aAn().ayA() && com.baidu.swan.apps.runtime.d.aAn().aAj().aAD().rt("mapp_i_get_common_sys_info");
            }

            @Override // com.baidu.swan.apps.api.a.c
            @NonNull
            protected com.baidu.swan.apps.api.c.b a(@NonNull JSONObject jSONObject, @NonNull final c.a aVar) {
                e aAs = e.aAs();
                if (aAs == null) {
                    if (d.DEBUG) {
                        Log.e("Api-getCommonSysInfo", "getCommonSysInfo failed: null swan runtime");
                    }
                    return new com.baidu.swan.apps.api.c.b(1001, "null swan runtime");
                }
                aAs.aAD().b(com.baidu.swan.apps.runtime.d.aAn(), "mapp_i_get_common_sys_info", new com.baidu.swan.apps.ap.e.b<h<b.d>>() { // from class: com.baidu.swan.bdprivate.extensions.c.a.1.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ap.e.b
                    /* renamed from: a */
                    public void J(h<b.d> hVar) {
                        if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                            aVar.b(a.this.aHg());
                            return;
                        }
                        int errorCode = hVar.getErrorCode();
                        String gL = com.baidu.swan.apps.setting.oauth.c.gL(errorCode);
                        if (d.DEBUG) {
                            Log.e("Api-getCommonSysInfo", "getCommonSysInfo failed: auth fail(" + errorCode + ", " + gL + ")");
                        }
                        aVar.b(new com.baidu.swan.apps.api.c.b(errorCode, gL));
                    }
                });
                return new com.baidu.swan.apps.api.c.b(0);
            }

            @Override // com.baidu.swan.apps.api.a.c
            @NonNull
            protected com.baidu.swan.apps.api.c.b as(@NonNull JSONObject jSONObject) {
                return a.this.aHg();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public com.baidu.swan.apps.api.c.b aHg() {
        com.baidu.swan.apps.runtime.d aAn = com.baidu.swan.apps.runtime.d.aAn();
        String bk = com.baidu.swan.apps.t.a.apz().bk(aAn);
        String aFW = ak.aFW();
        String str = "";
        String str2 = "";
        String str3 = "";
        Bundle bundle = new Bundle();
        bundle.putString("httpUrl", ".baidu.com");
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(aAn, C0464a.class, bundle);
        if (callOnMainWithContentProvider.isOk()) {
            str = callOnMainWithContentProvider.mResult.getString("zid");
            str2 = callOnMainWithContentProvider.mResult.getString("uid");
            str3 = callOnMainWithContentProvider.mResult.getString("cookie");
        }
        String cookieValue = ai.getCookieValue(str3, "BAIDUID");
        String cookieValue2 = ai.getCookieValue(str3, "H_WISE_SIDS");
        String uuid = com.baidu.swan.uuid.b.dI(AppRuntime.getAppContext()).getUUID();
        if (DEBUG) {
            Log.d("Api-getCommonSysInfo", "cuid = " + bk + ", imei = " + aFW + ", zid = " + str + ", uid = " + str2 + ", baiduId = " + cookieValue + ", sid = " + cookieValue2 + ", uuid = " + uuid);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cuid", bk);
            jSONObject.put("imei", aFW);
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
    /* loaded from: classes3.dex */
    public static class C0464a extends ProviderDelegation {
        private C0464a() {
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            String string = bundle.getString("httpUrl");
            Bundle bundle2 = new Bundle();
            bundle2.putString("zid", com.baidu.swan.bdprivate.a.a.ca(com.baidu.swan.apps.runtime.d.aAn()));
            bundle2.putString("uid", com.baidu.swan.apps.t.a.apz().bj(com.baidu.swan.apps.runtime.d.aAn()));
            bundle2.putString("cookie", TextUtils.isEmpty(string) ? "" : com.baidu.swan.apps.t.a.apT().abd().getCookie(string));
            return bundle2;
        }
    }
}
