package com.baidu.pass.biometrics.face.liveness.activity;

import com.baidu.pass.biometrics.face.liveness.d.b;
/* loaded from: classes12.dex */
class k implements b.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LivenessRecogActivity f2742a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(LivenessRecogActivity livenessRecogActivity) {
        this.f2742a = livenessRecogActivity;
    }

    @Override // com.baidu.pass.biometrics.face.liveness.d.b.a
    public void a(float f) {
        boolean z;
        boolean a2;
        z = this.f2742a.na;
        if (z) {
            this.f2742a.na = false;
            a2 = this.f2742a.a(f);
            if (a2) {
                this.f2742a.Z = 2L;
                this.f2742a.J = 5;
            }
        }
        this.f2742a.b(f);
    }
}
