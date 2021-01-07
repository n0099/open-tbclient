package com.baidu.pass.biometrics.face.liveness.activity;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class q implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.pass.biometrics.face.liveness.view.a f4067a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ LivenessRecogActivity f4068b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(LivenessRecogActivity livenessRecogActivity, com.baidu.pass.biometrics.face.liveness.view.a aVar) {
        this.f4068b = livenessRecogActivity;
        this.f4067a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4067a.dismiss();
        this.f4068b.y();
        this.f4068b.U.a();
        this.f4068b.da.Q = 1;
        this.f4068b.setActivityResult(0);
        this.f4068b.a(-204);
    }
}
