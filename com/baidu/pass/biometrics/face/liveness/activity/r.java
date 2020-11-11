package com.baidu.pass.biometrics.face.liveness.activity;

import android.view.View;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes18.dex */
public class r implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.pass.biometrics.face.liveness.view.a f2747a;
    final /* synthetic */ LivenessRecogActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(LivenessRecogActivity livenessRecogActivity, com.baidu.pass.biometrics.face.liveness.view.a aVar) {
        this.b = livenessRecogActivity;
        this.f2747a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PassFaceRecogCallback passFaceRecogCallback;
        PassFaceRecogCallback passFaceRecogCallback2;
        this.f2747a.dismiss();
        this.b.da.T = 1;
        this.b.setActivityResult(-1);
        passFaceRecogCallback = this.b.t;
        if (passFaceRecogCallback != null) {
            PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
            passFaceRecogResult.setResultCode(-301);
            passFaceRecogCallback2 = this.b.t;
            passFaceRecogCallback2.onFailure(passFaceRecogResult);
        }
        this.b.a(-301);
    }
}
