package com.baidu.pass.biometrics.face.liveness.activity;

import android.view.View;
import com.baidu.pass.biometrics.base.utils.ViewUtility;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class o implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.pass.biometrics.face.liveness.view.b f4025a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ LivenessRecogActivity f4026b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(LivenessRecogActivity livenessRecogActivity, com.baidu.pass.biometrics.face.liveness.view.b bVar) {
        this.f4026b = livenessRecogActivity;
        this.f4025a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PassFaceRecogCallback passFaceRecogCallback;
        PassFaceRecogCallback passFaceRecogCallback2;
        ViewUtility.dismissDialog(this.f4026b, this.f4025a);
        passFaceRecogCallback = this.f4026b.t;
        if (passFaceRecogCallback != null) {
            PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
            passFaceRecogResult.setResultCode(-307);
            passFaceRecogCallback2 = this.f4026b.t;
            passFaceRecogCallback2.onFailure(passFaceRecogResult);
        }
        this.f4026b.a(-307);
    }
}
