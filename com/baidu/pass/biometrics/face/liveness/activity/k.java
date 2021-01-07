package com.baidu.pass.biometrics.face.liveness.activity;

import com.baidu.pass.biometrics.face.liveness.d.b;
/* loaded from: classes7.dex */
class k implements b.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LivenessRecogActivity f4057a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(LivenessRecogActivity livenessRecogActivity) {
        this.f4057a = livenessRecogActivity;
    }

    @Override // com.baidu.pass.biometrics.face.liveness.d.b.a
    public void a(float f) {
        boolean z;
        boolean a2;
        z = this.f4057a.na;
        if (z) {
            this.f4057a.na = false;
            a2 = this.f4057a.a(f);
            if (a2) {
                this.f4057a.Z = 2L;
                this.f4057a.J = 5;
            }
        }
        this.f4057a.b(f);
    }
}
