package com.baidu.pass.biometrics.face.liveness.activity;

import android.view.View;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes18.dex */
public class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LivenessRecogActivity f2731a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(LivenessRecogActivity livenessRecogActivity) {
        this.f2731a = livenessRecogActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.pass.biometrics.face.liveness.view.a aVar;
        PassFaceRecogCallback passFaceRecogCallback;
        PassFaceRecogCallback passFaceRecogCallback2;
        aVar = this.f2731a.D;
        aVar.dismiss();
        this.f2731a.P.y = false;
        passFaceRecogCallback = this.f2731a.t;
        if (passFaceRecogCallback != null) {
            PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
            passFaceRecogResult.setResultCode(-307);
            passFaceRecogCallback2 = this.f2731a.t;
            passFaceRecogCallback2.onFailure(passFaceRecogResult);
        }
        this.f2731a.a(-307);
    }
}
