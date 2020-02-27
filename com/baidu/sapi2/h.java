package com.baidu.sapi2;

import com.baidu.sapi2.callback.AuthWidgetCallback;
import com.baidu.sapi2.callback.RegisterUserFaceIDCallback;
import com.baidu.sapi2.dto.FaceIDRegDTO;
import com.baidu.sapi2.result.SapiResult;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class h extends AuthWidgetCallback {
    final /* synthetic */ RegisterUserFaceIDCallback a;
    final /* synthetic */ FaceIDRegDTO b;
    final /* synthetic */ PassportSDK c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PassportSDK passportSDK, RegisterUserFaceIDCallback registerUserFaceIDCallback, FaceIDRegDTO faceIDRegDTO) {
        this.c = passportSDK;
        this.a = registerUserFaceIDCallback;
        this.b = faceIDRegDTO;
    }

    @Override // com.baidu.sapi2.callback.AuthWidgetCallback
    public void onFailure(SapiResult sapiResult) {
        this.a.onFailure(sapiResult);
    }

    @Override // com.baidu.sapi2.callback.AuthWidgetCallback
    public void onSuccess(String str) {
        PassportSDK passportSDK = this.c;
        RegisterUserFaceIDCallback registerUserFaceIDCallback = this.a;
        FaceIDRegDTO faceIDRegDTO = this.b;
        passportSDK.b(registerUserFaceIDCallback, "faceDetect", str, faceIDRegDTO.livingUname, faceIDRegDTO.showGuidePage, faceIDRegDTO.subpro, faceIDRegDTO.businessSence);
    }
}
