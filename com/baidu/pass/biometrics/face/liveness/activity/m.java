package com.baidu.pass.biometrics.face.liveness.activity;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ LivenessRecogActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(LivenessRecogActivity livenessRecogActivity) {
        this.a = livenessRecogActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.y();
        this.a.a();
        this.a.setActivityResult(0);
        this.a.a(-204);
        this.a.U.a();
    }
}
