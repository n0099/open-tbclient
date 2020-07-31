package com.baidu.sapi2;

import android.text.TextUtils;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.callback.IqiyiLoginCallback;
import com.baidu.sapi2.dto.IqiyiLoginDTO;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.sapi2.result.IqiyiLoginResult;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes19.dex */
public class K extends GetUserInfoCallback {
    final /* synthetic */ IqiyiLoginCallback a;
    final /* synthetic */ IqiyiLoginDTO b;
    final /* synthetic */ IqiyiLoginResult c;
    final /* synthetic */ String d;
    final /* synthetic */ L e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public K(L l, IqiyiLoginCallback iqiyiLoginCallback, IqiyiLoginDTO iqiyiLoginDTO, IqiyiLoginResult iqiyiLoginResult, String str) {
        this.e = l;
        this.a = iqiyiLoginCallback;
        this.b = iqiyiLoginDTO;
        this.c = iqiyiLoginResult;
        this.d = str;
    }

    @Override // com.baidu.sapi2.callback.SapiCallback
    public void onFinish() {
    }

    @Override // com.baidu.sapi2.callback.SapiCallback
    public void onStart() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.sapi2.callback.LoginStatusAware
    public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
        this.e.a(this.a, this.b, this.c);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.sapi2.callback.SapiCallback
    public void onFailure(GetUserInfoResult getUserInfoResult) {
        this.c.setResultCode(getUserInfoResult.getResultCode());
        this.c.setResultMsg(getUserInfoResult.getResultMsg());
        this.a.onFailure(this.c);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.sapi2.callback.SapiCallback
    public void onSuccess(GetUserInfoResult getUserInfoResult) {
        String str = getUserInfoResult.secureMobile;
        boolean z = getUserInfoResult.incompleteUser;
        if (!TextUtils.isEmpty(str)) {
            this.a.onSuccess(this.c);
        } else if (z) {
            this.e.a(this.a, this.b, this.c);
        } else if (!TextUtils.isEmpty(this.d)) {
            this.e.a(this.a, this.b, this.c);
        } else {
            this.a.onSuccess(this.c);
        }
    }
}
