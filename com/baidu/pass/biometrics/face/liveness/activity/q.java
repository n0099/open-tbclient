package com.baidu.pass.biometrics.face.liveness.activity;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class q implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.pass.biometrics.face.liveness.view.a f4066a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ LivenessRecogActivity f4067b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(LivenessRecogActivity livenessRecogActivity, com.baidu.pass.biometrics.face.liveness.view.a aVar) {
        this.f4067b = livenessRecogActivity;
        this.f4066a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4066a.dismiss();
        this.f4067b.y();
        this.f4067b.U.a();
        this.f4067b.da.Q = 1;
        this.f4067b.setActivityResult(0);
        this.f4067b.a(-204);
    }
}
