package com.baidu.sapi2;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.outsdk.c;
import com.baidu.sapi2.result.OneKeyLoginResult;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class f implements c.a {
    final /* synthetic */ OneKeyLoginCallback a;
    final /* synthetic */ String b;
    final /* synthetic */ boolean c;
    final /* synthetic */ Context d;
    final /* synthetic */ PassportSDK e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PassportSDK passportSDK, OneKeyLoginCallback oneKeyLoginCallback, String str, boolean z, Context context) {
        this.e = passportSDK;
        this.a = oneKeyLoginCallback;
        this.b = str;
        this.c = z;
        this.d = context;
    }

    @Override // com.baidu.sapi2.outsdk.c.a
    public void onGetTokenComplete(JSONObject jSONObject) {
        String optString = jSONObject.optString("token");
        if (!TextUtils.isEmpty(optString)) {
            SapiAccountManager.getInstance().getAccountService().a(this.a, optString, this.b, new e(this));
        } else {
            new com.baidu.sapi2.outsdk.c().a(this.a, OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL, (String) null);
        }
    }
}
