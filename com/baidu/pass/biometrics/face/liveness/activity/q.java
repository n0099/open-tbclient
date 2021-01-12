package com.baidu.pass.biometrics.face.liveness.activity;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class q implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.pass.biometrics.face.liveness.view.a f4029a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ LivenessRecogActivity f4030b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(LivenessRecogActivity livenessRecogActivity, com.baidu.pass.biometrics.face.liveness.view.a aVar) {
        this.f4030b = livenessRecogActivity;
        this.f4029a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4029a.dismiss();
        this.f4030b.y();
        this.f4030b.U.a();
        this.f4030b.da.Q = 1;
        this.f4030b.setActivityResult(0);
        this.f4030b.a(-204);
    }
}
