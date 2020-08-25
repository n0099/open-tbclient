package com.baidu.pass.biometrics.face.liveness.activity;

import com.baidu.pass.biometrics.face.liveness.d.b;
/* loaded from: classes4.dex */
class k implements b.a {
    final /* synthetic */ LivenessRecogActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(LivenessRecogActivity livenessRecogActivity) {
        this.a = livenessRecogActivity;
    }

    @Override // com.baidu.pass.biometrics.face.liveness.d.b.a
    public void a(float f) {
        boolean z;
        boolean a;
        z = this.a.na;
        if (z) {
            this.a.na = false;
            a = this.a.a(f);
            if (a) {
                this.a.Z = 2L;
                this.a.J = 5;
            }
        }
        this.a.b(f);
    }
}
