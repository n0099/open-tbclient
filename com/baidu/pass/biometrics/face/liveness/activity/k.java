package com.baidu.pass.biometrics.face.liveness.activity;

import com.baidu.pass.biometrics.face.liveness.d.b;
/* loaded from: classes6.dex */
class k implements b.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LivenessRecogActivity f4019a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(LivenessRecogActivity livenessRecogActivity) {
        this.f4019a = livenessRecogActivity;
    }

    @Override // com.baidu.pass.biometrics.face.liveness.d.b.a
    public void a(float f) {
        boolean z;
        boolean a2;
        z = this.f4019a.na;
        if (z) {
            this.f4019a.na = false;
            a2 = this.f4019a.a(f);
            if (a2) {
                this.f4019a.Z = 2L;
                this.f4019a.J = 5;
            }
        }
        this.f4019a.b(f);
    }
}
