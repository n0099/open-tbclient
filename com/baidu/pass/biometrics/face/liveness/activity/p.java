package com.baidu.pass.biometrics.face.liveness.activity;

import android.view.View;
import com.baidu.pass.biometrics.base.debug.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class p implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.pass.biometrics.face.liveness.view.a f4065a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ LivenessRecogActivity f4066b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(LivenessRecogActivity livenessRecogActivity, com.baidu.pass.biometrics.face.liveness.view.a aVar) {
        this.f4066b = livenessRecogActivity;
        this.f4065a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int g;
        Log.w("LivenessRecog", "showVerifyTimeoutDialog, livenessStat.resetTimePoint()");
        this.f4066b.da.a();
        this.f4066b.da.R = 1;
        this.f4066b.r();
        this.f4066b.P.s = 1;
        this.f4066b.w();
        LivenessRecogActivity livenessRecogActivity = this.f4066b;
        g = livenessRecogActivity.g();
        livenessRecogActivity.J = g;
        this.f4066b.Q.h = false;
        this.f4066b.Q.i = false;
        this.f4066b.P.v = System.currentTimeMillis();
        this.f4065a.dismiss();
    }
}
