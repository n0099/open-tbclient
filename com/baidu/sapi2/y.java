package com.baidu.sapi2;

import android.os.Looper;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.utils.Log;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes19.dex */
public class y extends HttpHandlerWrap {
    final /* synthetic */ OneKeyLoginResult a;
    final /* synthetic */ String b;
    final /* synthetic */ OneKeyLoginCallback c;
    final /* synthetic */ L d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(L l, Looper looper, OneKeyLoginResult oneKeyLoginResult, String str, OneKeyLoginCallback oneKeyLoginCallback) {
        super(looper);
        this.d = l;
        this.a = oneKeyLoginResult;
        this.b = str;
        this.c = oneKeyLoginCallback;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
    public void onFailure(Throwable th, int i, String str) {
        String str2;
        str2 = L.a;
        Log.d(str2, "onFailure, error = " + th + ", errorCode = " + i + ", responseBody = " + str);
        new com.baidu.sapi2.outsdk.c().b(this.c, i, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
    public void onSuccess(int i, String str) {
        String str2;
        JSONObject optJSONObject;
        str2 = L.a;
        Log.d(str2, "onSuccess, statusCode = " + i + ", response = " + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt(BaseJsonData.TAG_ERRNO);
            String optString = jSONObject.optString(BaseJsonData.TAG_ERRMSG);
            if (optInt == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                this.a.enable = optJSONObject.optInt(com.baidu.fsg.face.base.b.c.l, -1) == 1;
                this.a.hasHistory = optJSONObject.optInt("hasHistory", -1) == 1;
                this.a.encryptPhoneNum = this.b;
                this.a.sign = optJSONObject.optString("sign");
                this.a.operator = new com.baidu.sapi2.outsdk.c().c();
                String optString2 = optJSONObject.optString("js");
                String optString3 = optJSONObject.optString("md5");
                String optString4 = optJSONObject.optString("url");
                String onekeyLoginJsMd5 = SapiContext.getInstance().getOnekeyLoginJsMd5();
                if (optString3 == null || !optString3.equals(onekeyLoginJsMd5)) {
                    this.d.a(this.c, optString4, optString3, optString2, this.a);
                } else {
                    OneKeyLoginResult.secondJsCode = optString2;
                    this.c.available(this.a);
                }
            } else {
                new com.baidu.sapi2.outsdk.c().b(this.c, optInt, optString);
            }
        } catch (Exception e) {
            Log.e(e);
            new com.baidu.sapi2.outsdk.c().b(this.c, -100, null);
        }
    }
}
