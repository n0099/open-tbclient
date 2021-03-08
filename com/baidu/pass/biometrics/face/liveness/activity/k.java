package com.baidu.pass.biometrics.face.liveness.activity;

import com.baidu.pass.biometrics.face.liveness.d.b;
/* loaded from: classes14.dex */
class k implements b.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LivenessRecogActivity f2791a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(LivenessRecogActivity livenessRecogActivity) {
        this.f2791a = livenessRecogActivity;
    }

    @Override // com.baidu.pass.biometrics.face.liveness.d.b.a
    public void a(float f) {
        boolean z;
        boolean a2;
        z = this.f2791a.na;
        if (z) {
            this.f2791a.na = false;
            a2 = this.f2791a.a(f);
            if (a2) {
                this.f2791a.Z = 2L;
                this.f2791a.J = 5;
            }
        }
        this.f2791a.b(f);
    }
}
