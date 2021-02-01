package com.baidu.pass.biometrics.face.liveness.activity;

import android.view.View;
import com.baidu.pass.biometrics.base.debug.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class p implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.pass.biometrics.face.liveness.view.a f4030a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ LivenessRecogActivity f4031b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(LivenessRecogActivity livenessRecogActivity, com.baidu.pass.biometrics.face.liveness.view.a aVar) {
        this.f4031b = livenessRecogActivity;
        this.f4030a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int g;
        Log.w("LivenessRecog", "showVerifyTimeoutDialog, livenessStat.resetTimePoint()");
        this.f4031b.da.a();
        this.f4031b.da.R = 1;
        this.f4031b.r();
        this.f4031b.P.s = 1;
        this.f4031b.w();
        LivenessRecogActivity livenessRecogActivity = this.f4031b;
        g = livenessRecogActivity.g();
        livenessRecogActivity.J = g;
        this.f4031b.Q.h = false;
        this.f4031b.Q.i = false;
        this.f4031b.P.v = System.currentTimeMillis();
        this.f4030a.dismiss();
    }
}
