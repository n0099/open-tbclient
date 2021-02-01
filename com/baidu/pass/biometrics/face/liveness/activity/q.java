package com.baidu.pass.biometrics.face.liveness.activity;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class q implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.pass.biometrics.face.liveness.view.a f4032a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ LivenessRecogActivity f4033b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(LivenessRecogActivity livenessRecogActivity, com.baidu.pass.biometrics.face.liveness.view.a aVar) {
        this.f4033b = livenessRecogActivity;
        this.f4032a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4032a.dismiss();
        this.f4033b.y();
        this.f4033b.U.a();
        this.f4033b.da.Q = 1;
        this.f4033b.setActivityResult(0);
        this.f4033b.a(-204);
    }
}
