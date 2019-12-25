package com.baidu.sapi2;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.VerifyUserFaceIDCallback;
import com.baidu.sapi2.dto.FaceIDVerifyDTO;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.RealNameFaceIDResult;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class i extends GetTplStokenCallback {
    final /* synthetic */ Context a;
    final /* synthetic */ FaceIDVerifyDTO b;
    final /* synthetic */ VerifyUserFaceIDCallback c;
    final /* synthetic */ RealNameFaceIDResult d;
    final /* synthetic */ PassportSDK e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PassportSDK passportSDK, Context context, FaceIDVerifyDTO faceIDVerifyDTO, VerifyUserFaceIDCallback verifyUserFaceIDCallback, RealNameFaceIDResult realNameFaceIDResult) {
        this.e = passportSDK;
        this.a = context;
        this.b = faceIDVerifyDTO;
        this.c = verifyUserFaceIDCallback;
        this.d = realNameFaceIDResult;
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
        this.d.setResultCode(getTplStokenResult.getResultCode());
        this.d.setResultMsg(getTplStokenResult.getResultMsg());
        this.c.onFailure(this.d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.sapi2.callback.SapiCallback
    public void onSuccess(GetTplStokenResult getTplStokenResult) {
        String str = getTplStokenResult.tplStokenMap.get("pp");
        if (!TextUtils.isEmpty(str)) {
            PassportSDK passportSDK = this.e;
            Context context = this.a;
            FaceIDVerifyDTO faceIDVerifyDTO = this.b;
            passportSDK.a(context, faceIDVerifyDTO.subpro, null, "0", faceIDVerifyDTO.bduss, str, faceIDVerifyDTO.businessSence, this.c, this.d);
            return;
        }
        this.d.setResultCode(-402);
        this.d.setResultMsg("服务异常，请稍后再试");
        this.c.onFailure(this.d);
    }
}
