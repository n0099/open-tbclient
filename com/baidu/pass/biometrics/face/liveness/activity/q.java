package com.baidu.pass.biometrics.face.liveness.activity;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ com.baidu.pass.biometrics.face.liveness.view.a a;
    final /* synthetic */ LivenessRecogActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(LivenessRecogActivity livenessRecogActivity, com.baidu.pass.biometrics.face.liveness.view.a aVar) {
        this.b = livenessRecogActivity;
        this.a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.dismiss();
        this.b.y();
        this.b.U.a();
        this.b.da.Q = 1;
        this.b.setActivityResult(0);
        this.b.a(-204);
    }
}
