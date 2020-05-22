package com.baidu.swan.bdprivate.e;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.sapi2.result.InvoiceBuildResult;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.swan.apps.aq.t;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.res.widget.b.d;
import com.baidu.swan.bdprivate.b;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends ActivityDelegation {

    /* renamed from: com.baidu.swan.bdprivate.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0412a {
        void auM();

        void ce(String str, String str2);
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    protected boolean onExec() {
        if (!com.baidu.swan.bdprivate.a.a.isLogin(getAgent())) {
            com.baidu.swan.bdprivate.a.a.a(getAgent(), (Bundle) null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.bdprivate.e.a.1
                @Override // com.baidu.swan.apps.a.a
                public void onResult(int i) {
                    if (i == 0) {
                        a.this.auR();
                        return;
                    }
                    a.this.mResult.putString(TiebaInitialize.LogFields.ERROR_MESSAGE, "login failed");
                    a.this.finish();
                }
            });
            return false;
        }
        auR();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auR() {
        com.baidu.swan.bdprivate.a.a.a(getAgent(), new InterfaceC0412a() { // from class: com.baidu.swan.bdprivate.e.a.2
            @Override // com.baidu.swan.bdprivate.e.a.InterfaceC0412a
            public void ce(String str, String str2) {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    a.this.mResult.putString(TiebaInitialize.LogFields.ERROR_MESSAGE, "invoiceId == null or invoiceType == null");
                    a.this.finish();
                }
                a.this.cd(str, str2);
            }

            @Override // com.baidu.swan.bdprivate.e.a.InterfaceC0412a
            public void auM() {
                a.this.mResult.putString(TiebaInitialize.LogFields.ERROR_MESSAGE, "choose invoiceId failed");
                a.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cd(String str, String str2) {
        if (!SwanAppNetworkUtils.isNetworkConnected(getAgent())) {
            d.k(getAgent(), b.g.invoice_network_none);
        } else {
            com.baidu.swan.c.c.a.dv(AppRuntime.getAppContext()).getRequest().url(com.baidu.swan.apps.h.c.processCommonParams(auS())).addUrlParam(InvoiceBuildResult.KEY_INVOICE_ID, str).addUrlParam("invoice_type", str2).cookieManager(com.baidu.swan.apps.u.a.afo().SM()).build().executeAsync(new ResponseCallback<JSONObject>() { // from class: com.baidu.swan.bdprivate.e.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                /* renamed from: a */
                public JSONObject parseResponse(Response response, int i) throws Exception {
                    if (response == null || response.body() == null) {
                        return null;
                    }
                    return t.parseString(response.body().string());
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                /* renamed from: b */
                public void onSuccess(JSONObject jSONObject, int i) {
                    if (jSONObject == null) {
                        a.this.mResult.putString(TiebaInitialize.LogFields.ERROR_MESSAGE, "exchange plaintext from server, but no response");
                        a.this.finish();
                        return;
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject != null) {
                        a.this.mResult.putString("invoiceInfo", optJSONObject.toString());
                        a.this.finish();
                        return;
                    }
                    a.this.mResult.putString(TiebaInitialize.LogFields.ERROR_MESSAGE, "exchange plaintext from server, but response exception");
                    a.this.finish();
                }

                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onFail(Exception exc) {
                    a.this.mResult.putString(TiebaInitialize.LogFields.ERROR_MESSAGE, exc.getMessage());
                    a.this.finish();
                }
            });
        }
    }

    private static String auS() {
        return String.format("%s/ma/invoice/detail", "https://mbd.baidu.com");
    }
}
