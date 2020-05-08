package com.baidu.sapi2;

import android.content.Context;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.result.GetTplStokenResult;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class M extends GetTplStokenCallback {
    final /* synthetic */ Context a;
    final /* synthetic */ SapiAccountService b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public M(SapiAccountService sapiAccountService, Context context) {
        this.b = sapiAccountService;
        this.a = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.sapi2.callback.SapiCallback
    public void onFailure(GetTplStokenResult getTplStokenResult) {
    }

    @Override // com.baidu.sapi2.callback.SapiCallback
    public void onFinish() {
    }

    @Override // com.baidu.sapi2.callback.SapiCallback
    public void onStart() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.sapi2.callback.SapiCallback
    public void onSuccess(GetTplStokenResult getTplStokenResult) {
        SapiAccountService.a(this.a, getTplStokenResult.tplStokenMap.get("pp"));
    }
}
