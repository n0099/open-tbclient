package com.baidu.pass.biometrics.face.liveness.activity;

import android.view.View;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class r implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.pass.biometrics.face.liveness.view.a f4068a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ LivenessRecogActivity f4069b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(LivenessRecogActivity livenessRecogActivity, com.baidu.pass.biometrics.face.liveness.view.a aVar) {
        this.f4069b = livenessRecogActivity;
        this.f4068a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PassFaceRecogCallback passFaceRecogCallback;
        PassFaceRecogCallback passFaceRecogCallback2;
        this.f4068a.dismiss();
        this.f4069b.da.T = 1;
        this.f4069b.setActivityResult(-1);
        passFaceRecogCallback = this.f4069b.t;
        if (passFaceRecogCallback != null) {
            PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
            passFaceRecogResult.setResultCode(-301);
            passFaceRecogCallback2 = this.f4069b.t;
            passFaceRecogCallback2.onFailure(passFaceRecogResult);
        }
        this.f4069b.a(-301);
    }
}
