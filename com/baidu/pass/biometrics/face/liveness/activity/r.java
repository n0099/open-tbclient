package com.baidu.pass.biometrics.face.liveness.activity;

import android.view.View;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ com.baidu.pass.biometrics.face.liveness.view.a a;
    final /* synthetic */ LivenessRecogActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(LivenessRecogActivity livenessRecogActivity, com.baidu.pass.biometrics.face.liveness.view.a aVar) {
        this.b = livenessRecogActivity;
        this.a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PassFaceRecogCallback passFaceRecogCallback;
        PassFaceRecogCallback passFaceRecogCallback2;
        this.a.dismiss();
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
