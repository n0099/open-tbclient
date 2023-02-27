package com.baidu.pass.biometrics.face.liveness.enums;

import com.baidu.pass.biometrics.face.liveness.view.face.CircleProgressView;
import java.util.TimerTask;
/* loaded from: classes2.dex */
public class a extends TimerTask {
    public CircleProgressView a;

    /* renamed from: com.baidu.pass.biometrics.face.liveness.enums.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0121a implements Runnable {
        public RunnableC0121a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int progress;
            if (a.this.a == null || (progress = a.this.a.getProgress()) <= 0) {
                return;
            }
            a.this.a.setProgress(progress - 1);
        }
    }

    public a(CircleProgressView circleProgressView) {
        this.a = circleProgressView;
    }

    @Override // java.util.TimerTask
    public boolean cancel() {
        this.a = null;
        return super.cancel();
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        CircleProgressView circleProgressView = this.a;
        if (circleProgressView != null) {
            circleProgressView.post(new RunnableC0121a());
        }
    }
}
