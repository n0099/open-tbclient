package com.baidu.pass.biometrics.face.liveness.enums;

import com.baidu.pass.biometrics.face.liveness.view.face.CircleProgressView;
import java.util.TimerTask;
/* loaded from: classes2.dex */
public class a extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    public CircleProgressView f9172a;

    /* renamed from: com.baidu.pass.biometrics.face.liveness.enums.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0116a implements Runnable {
        public RunnableC0116a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int progress;
            if (a.this.f9172a == null || (progress = a.this.f9172a.getProgress()) <= 0) {
                return;
            }
            a.this.f9172a.setProgress(progress - 1);
        }
    }

    public a(CircleProgressView circleProgressView) {
        this.f9172a = circleProgressView;
    }

    @Override // java.util.TimerTask
    public boolean cancel() {
        this.f9172a = null;
        return super.cancel();
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        CircleProgressView circleProgressView = this.f9172a;
        if (circleProgressView != null) {
            circleProgressView.post(new RunnableC0116a());
        }
    }
}
