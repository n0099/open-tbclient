package com.baidu.pass.biometrics.face.liveness.activity;

import android.view.View;
import com.baidu.pass.biometrics.base.debug.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes18.dex */
public class p implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.pass.biometrics.face.liveness.view.a f2745a;
    final /* synthetic */ LivenessRecogActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(LivenessRecogActivity livenessRecogActivity, com.baidu.pass.biometrics.face.liveness.view.a aVar) {
        this.b = livenessRecogActivity;
        this.f2745a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int g;
        Log.w("LivenessRecog", "showVerifyTimeoutDialog, livenessStat.resetTimePoint()");
        this.b.da.a();
        this.b.da.R = 1;
        this.b.r();
        this.b.P.s = 1;
        this.b.w();
        LivenessRecogActivity livenessRecogActivity = this.b;
        g = livenessRecogActivity.g();
        livenessRecogActivity.J = g;
        this.b.Q.h = false;
        this.b.Q.i = false;
        this.b.P.v = System.currentTimeMillis();
        this.f2745a.dismiss();
    }
}
