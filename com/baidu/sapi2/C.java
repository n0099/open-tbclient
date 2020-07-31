package com.baidu.sapi2;

import android.text.TextUtils;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.callback.Web2NativeLoginCallback;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.sapi2.result.Web2NativeLoginResult;
import com.baidu.sapi2.share.SapiShareClient;
import com.baidu.sapi2.utils.SapiUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes19.dex */
public class C extends GetUserInfoCallback {
    final /* synthetic */ Web2NativeLoginResult a;
    final /* synthetic */ Web2NativeLoginCallback b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ L e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C(L l, Web2NativeLoginResult web2NativeLoginResult, Web2NativeLoginCallback web2NativeLoginCallback, String str, String str2) {
        this.e = l;
        this.a = web2NativeLoginResult;
        this.b = web2NativeLoginCallback;
        this.c = str;
        this.d = str2;
    }

    @Override // com.baidu.sapi2.callback.SapiCallback
    public void onFinish() {
        this.b.onFinish();
    }

    @Override // com.baidu.sapi2.callback.SapiCallback
    public void onStart() {
        this.b.onStart();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.sapi2.callback.LoginStatusAware
    public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
        this.a.setResultCode(400021);
        this.b.onBdussExpired(this.a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.sapi2.callback.SapiCallback
    public void onFailure(GetUserInfoResult getUserInfoResult) {
        this.a.setResultCode(-202);
        this.b.onFailure(this.a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.sapi2.callback.SapiCallback
    public void onSuccess(GetUserInfoResult getUserInfoResult) {
        SapiConfiguration sapiConfiguration;
        SapiAccount sapiAccount = new SapiAccount();
        sapiAccount.uid = getUserInfoResult.uid;
        sapiAccount.username = getUserInfoResult.username;
        sapiAccount.displayname = getUserInfoResult.displayname;
        sapiAccount.bduss = this.c;
        if (!TextUtils.isEmpty(this.d)) {
            sapiAccount.ptoken = this.d;
        }
        sapiConfiguration = this.e.d;
        sapiAccount.app = SapiUtils.getAppName(sapiConfiguration.context);
        SapiShareClient.getInstance().validate(sapiAccount);
        this.a.setResultCode(0);
        this.b.onSuccess(this.a);
        new com.baidu.sapi2.utils.b().a(com.baidu.sapi2.utils.b.g);
    }
}
