package com.baidu.pass.biometrics.face.liveness.activity;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes18.dex */
public class m implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LivenessRecogActivity f2742a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(LivenessRecogActivity livenessRecogActivity) {
        this.f2742a = livenessRecogActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2742a.y();
        this.f2742a.a();
        this.f2742a.setActivityResult(0);
        this.f2742a.a(-204);
        this.f2742a.U.a();
    }
}
