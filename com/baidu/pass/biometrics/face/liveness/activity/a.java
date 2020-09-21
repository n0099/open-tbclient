package com.baidu.pass.biometrics.face.liveness.activity;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ LivenessRecogActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(LivenessRecogActivity livenessRecogActivity) {
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
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.addFlags(268435456);
        intent.setData(Uri.fromParts("package", this.a.getPackageName(), null));
        if (intent.resolveActivity(this.a.getPackageManager()) != null) {
            this.a.startActivity(intent);
        }
    }
}
