package com.baidu.sapi2;

import android.content.Context;
import com.baidu.fsg.base.BaiduRimConstants;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.sapi2.bio.BiometricsManager;
import com.baidu.sapi2.callback.ExtendSysWebViewMethodCallback;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.result.ExtendSysWebViewMethodResult;
import com.baidu.sapi2.result.GetTplStokenResult;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes19.dex */
public class d extends GetTplStokenCallback {
    final /* synthetic */ String a;
    final /* synthetic */ Map b;
    final /* synthetic */ String c;
    final /* synthetic */ SapiAccount d;
    final /* synthetic */ PassFaceRecogCallback e;
    final /* synthetic */ ExtendSysWebViewMethodResult f;
    final /* synthetic */ ExtendSysWebViewMethodCallback g;
    final /* synthetic */ PassportSDK h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PassportSDK passportSDK, String str, Map map, String str2, SapiAccount sapiAccount, PassFaceRecogCallback passFaceRecogCallback, ExtendSysWebViewMethodResult extendSysWebViewMethodResult, ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback) {
        this.h = passportSDK;
        this.a = str;
        this.b = map;
        this.c = str2;
        this.d = sapiAccount;
        this.e = passFaceRecogCallback;
        this.f = extendSysWebViewMethodResult;
        this.g = extendSysWebViewMethodCallback;
    }

    @Override // com.baidu.sapi2.callback.SapiCallback
    public void onFinish() {
    }

    @Override // com.baidu.sapi2.callback.SapiCallback
    public void onStart() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.sapi2.callback.SapiCallback
    public void onFailure(GetTplStokenResult getTplStokenResult) {
        this.f.params.put(BaiduRimConstants.RETCODE_KEY, Integer.valueOf(getTplStokenResult.getResultCode()));
        this.f.params.put("retMsg", getTplStokenResult.getResultMsg());
        this.g.onFinish(this.f);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.sapi2.callback.SapiCallback
    public void onSuccess(GetTplStokenResult getTplStokenResult) {
        Context context;
        BiometricsManager biometricsManager = BiometricsManager.getInstance();
        context = this.h.E;
        biometricsManager.recogWithBduss(context, this.a, this.b, this.c, this.d.bduss, getTplStokenResult.tplStokenMap.get("pp"), this.e);
    }
}
