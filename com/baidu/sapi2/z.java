package com.baidu.sapi2;

import android.os.Looper;
import android.text.TextUtils;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.utils.Log;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes6.dex */
class z extends HttpHandlerWrap {
    final /* synthetic */ A a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(A a, Looper looper) {
        super(looper);
        this.a = a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
    public void onFailure(Throwable th, int i, String str) {
        String str2;
        str2 = L.a;
        Log.d(str2, "onFailure, error = " + th + ", errorCode = " + i + ", responseBody = " + str);
        new com.baidu.sapi2.outsdk.c().a(this.a.a, -100, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
    public void onSuccess(int i, String str, HashMap<String, String> hashMap) {
        String str2;
        String optString;
        str2 = L.a;
        Log.d(str2, "onSuccess, statusCode = " + i + ", response = " + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("errInfo");
            String optString2 = optJSONObject.optString(NetWorkUtils.NETWORK_TYPE_CELL_UN_CONNECTED);
            String optString3 = optJSONObject.optString("msg");
            if ("0".equals(optString2)) {
                this.a.c.a(hashMap);
                JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
                if (optJSONObject2 != null) {
                    SapiAccountManager.getInstance().getAccountService().handleOneKeyLoginResult(this.a.a, optJSONObject2.optString("xml"));
                    return;
                } else {
                    new com.baidu.sapi2.outsdk.c().a(this.a.a, -100, (String) null);
                    return;
                }
            }
            if (!"400101".equals(optString2) && !"400031".equals(optString2) && !"400023".equals(optString2)) {
                if (!"400704".equals(optString2) && !"400706".equals(optString2)) {
                    new com.baidu.sapi2.outsdk.c().a(this.a.a, Integer.parseInt(optString2), optString3);
                    return;
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("data");
                if (optJSONObject3 != null) {
                    optString = optJSONObject3.optString("ppDatau");
                }
                optString = null;
            } else {
                JSONObject optJSONObject4 = jSONObject.optJSONObject("data");
                if (optJSONObject4 != null) {
                    optString = optJSONObject4.optString("verifyUrl");
                }
                optString = null;
            }
            if (!TextUtils.isEmpty(optString)) {
                OneKeyLoginResult oneKeyLoginResult = new OneKeyLoginResult();
                oneKeyLoginResult.setResultCode(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_IN_GUIDE_PROCESS);
                this.a.a.onGuideProcess(oneKeyLoginResult);
                this.a.b.a("", optString);
                return;
            }
            new com.baidu.sapi2.outsdk.c().a(this.a.a, -100, (String) null);
        } catch (Exception e) {
            Log.e(e);
            new com.baidu.sapi2.outsdk.c().a(this.a.a, -100, (String) null);
        }
    }
}
