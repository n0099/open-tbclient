package com.baidu.pass.biometrics.face.liveness.enums;

import com.baidu.pass.biometrics.face.liveness.view.face.CircleProgressView;
import java.util.TimerTask;
/* loaded from: classes2.dex */
public class b extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    public CircleProgressView f9174a;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int progress;
            if (b.this.f9174a == null || (progress = b.this.f9174a.getProgress()) >= 100) {
                return;
            }
            b.this.f9174a.setProgress(progress + 1);
        }
    }

    public b(CircleProgressView circleProgressView) {
        this.f9174a = circleProgressView;
    }

    @Override // java.util.TimerTask
    public boolean cancel() {
        this.f9174a = null;
        return super.cancel();
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        CircleProgressView circleProgressView = this.f9174a;
        if (circleProgressView != null) {
            circleProgressView.post(new a());
        }
    }
}
