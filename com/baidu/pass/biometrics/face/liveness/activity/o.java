package com.baidu.pass.biometrics.face.liveness.activity;

import android.view.View;
import com.baidu.pass.biometrics.base.utils.ViewUtility;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class o implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.pass.biometrics.face.liveness.view.b f4062a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ LivenessRecogActivity f4063b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(LivenessRecogActivity livenessRecogActivity, com.baidu.pass.biometrics.face.liveness.view.b bVar) {
        this.f4063b = livenessRecogActivity;
        this.f4062a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PassFaceRecogCallback passFaceRecogCallback;
        PassFaceRecogCallback passFaceRecogCallback2;
        ViewUtility.dismissDialog(this.f4063b, this.f4062a);
        passFaceRecogCallback = this.f4063b.t;
        if (passFaceRecogCallback != null) {
            PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
            passFaceRecogResult.setResultCode(-307);
            passFaceRecogCallback2 = this.f4063b.t;
            passFaceRecogCallback2.onFailure(passFaceRecogResult);
        }
        this.f4063b.a(-307);
    }
}
