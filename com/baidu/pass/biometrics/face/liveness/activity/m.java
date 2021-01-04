package com.baidu.pass.biometrics.face.liveness.activity;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class m implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LivenessRecogActivity f4059a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(LivenessRecogActivity livenessRecogActivity) {
        this.f4059a = livenessRecogActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4059a.y();
        this.f4059a.a();
        this.f4059a.setActivityResult(0);
        this.f4059a.a(-204);
        this.f4059a.U.a();
    }
}
