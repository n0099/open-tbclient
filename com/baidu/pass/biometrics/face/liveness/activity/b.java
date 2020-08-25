package com.baidu.pass.biometrics.face.liveness.activity;

import android.view.View;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ LivenessRecogActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(LivenessRecogActivity livenessRecogActivity) {
        this.a = livenessRecogActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.pass.biometrics.face.liveness.view.a aVar;
        PassFaceRecogCallback passFaceRecogCallback;
        PassFaceRecogCallback passFaceRecogCallback2;
        aVar = this.a.D;
        aVar.dismiss();
        this.a.P.y = false;
        passFaceRecogCallback = this.a.t;
        if (passFaceRecogCallback != null) {
            PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
            passFaceRecogResult.setResultCode(-307);
            passFaceRecogCallback2 = this.a.t;
            passFaceRecogCallback2.onFailure(passFaceRecogResult);
        }
        this.a.a(-307);
    }
}
