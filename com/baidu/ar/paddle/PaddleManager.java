package com.baidu.ar.paddle;

import android.content.Context;
import com.baidu.ar.algo.a.a.a;
import com.baidu.ar.paddle.PaddleController;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class PaddleManager {
    private static PaddleManager a;
    private Context b;
    private PaddleController c;
    private boolean d = false;

    private PaddleManager() {
    }

    private static void a() {
        a = null;
    }

    public static synchronized PaddleManager getInstance() {
        PaddleManager paddleManager;
        synchronized (PaddleManager.class) {
            if (a == null) {
                a = new PaddleManager();
            }
            paddleManager = a;
        }
        return paddleManager;
    }

    public void destroy() {
        a();
    }

    public void detectGesture(byte[] bArr, int i, int i2) {
        if (this.c != null) {
            this.c.detectGesture(bArr, i, i2);
        }
    }

    public void enablePaddle(boolean z) {
        if (this.c != null) {
            this.c.setEnabled(z);
            this.d = z;
        }
    }

    public void initPaddle(Context context, String str, String str2, a aVar, PaddleController.ActionListener actionListener) {
        if (this.b == null) {
            this.b = (Context) new WeakReference(context).get();
        }
        if (this.c == null) {
            this.c = new PaddleController(this.b, str, str2, aVar, actionListener);
        }
    }

    public boolean isValid() {
        return this.d;
    }

    public void notifyFrontCamera(boolean z) {
        if (this.c != null) {
            if (z) {
                this.c.setCameraType(1);
            } else {
                this.c.setCameraType(0);
            }
        }
    }

    public void notifyIsSharing(boolean z) {
        this.d = !z;
    }

    public void release() {
        if (this.c != null) {
            this.c.release();
            this.c = null;
        }
        if (this.b != null) {
            this.b = null;
        }
    }
}
