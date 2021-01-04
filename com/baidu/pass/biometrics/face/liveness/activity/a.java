package com.baidu.pass.biometrics.face.liveness.activity;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LivenessRecogActivity f4042a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(LivenessRecogActivity livenessRecogActivity) {
        this.f4042a = livenessRecogActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.pass.biometrics.face.liveness.view.a aVar;
        PassFaceRecogCallback passFaceRecogCallback;
        PassFaceRecogCallback passFaceRecogCallback2;
        aVar = this.f4042a.D;
        aVar.dismiss();
        this.f4042a.P.y = false;
        passFaceRecogCallback = this.f4042a.t;
        if (passFaceRecogCallback != null) {
            PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
            passFaceRecogResult.setResultCode(-307);
            passFaceRecogCallback2 = this.f4042a.t;
            passFaceRecogCallback2.onFailure(passFaceRecogResult);
        }
        this.f4042a.a(-307);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.addFlags(268435456);
        intent.setData(Uri.fromParts("package", this.f4042a.getPackageName(), null));
        if (intent.resolveActivity(this.f4042a.getPackageManager()) != null) {
            this.f4042a.startActivity(intent);
        }
    }
}
