package com.baidu.swan.bdprivate.b;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.swan.apps.aq.t;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends ActivityDelegation {

    /* renamed from: com.baidu.swan.bdprivate.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0408a {
        void auM();

        void hg(String str);
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    protected boolean onExec() {
        if (!com.baidu.swan.bdprivate.a.a.isLogin(getAgent())) {
            com.baidu.swan.bdprivate.a.a.a(getAgent(), (Bundle) null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.bdprivate.b.a.1
                @Override // com.baidu.swan.apps.a.a
                public void onResult(int i) {
                    if (i == 0) {
                        a.this.auK();
                        return;
                    }
                    a.this.mResult.putString(TiebaInitialize.LogFields.ERROR_MESSAGE, "login failed");
                    a.this.finish();
                }
            });
            return false;
        }
        auK();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auK() {
        com.baidu.swan.bdprivate.a.a.a(getAgent(), new InterfaceC0408a() { // from class: com.baidu.swan.bdprivate.b.a.2
            @Override // com.baidu.swan.bdprivate.b.a.InterfaceC0408a
            public void hg(String str) {
                if (TextUtils.isEmpty(str)) {
                    a.this.mResult.putString(TiebaInitialize.LogFields.ERROR_MESSAGE, "addressId == null");
                    a.this.finish();
                }
                a.this.pY(str);
            }

            @Override // com.baidu.swan.bdprivate.b.a.InterfaceC0408a
            public void auM() {
                a.this.mResult.putString(TiebaInitialize.LogFields.ERROR_MESSAGE, "choose addressId failed");
                a.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pY(String str) {
        com.baidu.swan.c.c.a.aFx().getRequest().url(com.baidu.swan.apps.h.c.processCommonParams(auL())).addUrlParam("addr_id", str).cookieManager(com.baidu.swan.apps.u.a.afo().SM()).build().executeAsync(new ResponseCallback<JSONObject>() { // from class: com.baidu.swan.bdprivate.b.a.3
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
                JSONObject optJSONObject;
                if (jSONObject != null && jSONObject.optInt(BaseJsonData.TAG_ERRNO, -1) == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                    a.this.mResult.putString("address_info", optJSONObject.toString());
                    a.this.finish();
                    return;
                }
                a.this.mResult.putString(TiebaInitialize.LogFields.ERROR_MESSAGE, "GetAddressInfoResponse == null");
                a.this.finish();
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                a.this.mResult.putString(TiebaInitialize.LogFields.ERROR_MESSAGE, exc.getMessage());
                a.this.finish();
            }
        });
    }

    public static String auL() {
        return String.format("%s/ma/address/detail", "https://mbd.baidu.com");
    }
}
