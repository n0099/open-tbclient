package com.baidu.sapi2.share;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.utils.SapiUtils;
import java.util.UUID;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class u extends GetUserInfoCallback {
    final /* synthetic */ ShareStorage.a a;
    final /* synthetic */ Context b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(ShareStorage.a aVar, Context context) {
        this.a = aVar;
        this.b = context;
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
        ShareStorage.StorageModel storageModel = new ShareStorage.StorageModel(null);
        storageModel.b = 1;
        this.a.a(storageModel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.sapi2.callback.SapiCallback
    public void onFailure(GetUserInfoResult getUserInfoResult) {
        ShareStorage.StorageModel storageModel = new ShareStorage.StorageModel(null);
        storageModel.b = 1;
        this.a.a(storageModel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.sapi2.callback.SapiCallback
    public void onSuccess(GetUserInfoResult getUserInfoResult) {
        String str;
        ShareStorage.StorageModel storageModel = new ShareStorage.StorageModel(null);
        SapiAccount currentAccount = SapiContext.getInstance(this.b).getCurrentAccount();
        if (TextUtils.isEmpty(getUserInfoResult.portraitHttps)) {
            str = ShareStorage.d;
            storageModel.url = str;
        } else {
            storageModel.url = getUserInfoResult.portraitHttps;
        }
        SapiContext.getInstance(this.b).put(SapiContext.KEY_LAST_LOGIN_USER_PORTRAIT, storageModel.url);
        storageModel.displayname = currentAccount.displayname;
        storageModel.app = SapiUtils.getAppName(this.b);
        storageModel.tpl = SapiAccountManager.getInstance().getSapiConfiguration().tpl;
        storageModel.pkg = this.b.getPackageName();
        storageModel.a = UUID.randomUUID().toString();
        storageModel.b = 0;
        storageModel.d = SapiAccountManager.getInstance().getConfignation().environment.ordinal();
        this.a.a(storageModel);
    }
}
