package com.baidu.pass.biometrics.face.liveness.enums;

import com.baidu.pass.biometrics.face.liveness.view.face.CircleProgressView;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public class b extends TimerTask {
    public CircleProgressView a;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int progress;
            if (b.this.a == null || (progress = b.this.a.getProgress()) >= 100) {
                return;
            }
            b.this.a.setProgress(progress + 1);
        }
    }

    public b(CircleProgressView circleProgressView) {
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
            circleProgressView.post(new a());
        }
    }
}
