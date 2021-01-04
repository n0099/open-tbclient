package com.baidu.pass.biometrics.face.liveness.activity;

import android.view.View;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LivenessRecogActivity f4043a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(LivenessRecogActivity livenessRecogActivity) {
        this.f4043a = livenessRecogActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.pass.biometrics.face.liveness.view.a aVar;
        PassFaceRecogCallback passFaceRecogCallback;
        PassFaceRecogCallback passFaceRecogCallback2;
        aVar = this.f4043a.D;
        aVar.dismiss();
        this.f4043a.P.y = false;
        passFaceRecogCallback = this.f4043a.t;
        if (passFaceRecogCallback != null) {
            PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
            passFaceRecogResult.setResultCode(-307);
            passFaceRecogCallback2 = this.f4043a.t;
            passFaceRecogCallback2.onFailure(passFaceRecogResult);
        }
        this.f4043a.a(-307);
    }
}
