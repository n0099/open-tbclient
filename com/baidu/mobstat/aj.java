package com.baidu.mobstat;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;
import androidx.appcompat.widget.TooltipCompatHandler;
import com.baidu.mobstat.ak;
/* loaded from: classes2.dex */
public class aj {
    public static volatile boolean a = true;
    public a b;
    public Activity c;
    public Handler d = new Handler(Looper.getMainLooper()) { // from class: com.baidu.mobstat.aj.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 100 && aj.this.b != null) {
                aj.this.b.a();
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void a();
    }

    public aj(a aVar) {
        this.b = aVar;
    }

    private Window.Callback a(Window.Callback callback) {
        while (callback != null && (callback instanceof ak)) {
            callback = ((ak) callback).a();
        }
        return callback;
    }

    private void c(Activity activity) {
        Window window;
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        window.setCallback(a(window.getCallback()));
    }

    private void d(Activity activity) {
        Window.Callback callback;
        Window window = activity.getWindow();
        if (window == null || (callback = window.getCallback()) == null) {
            return;
        }
        window.setCallback(new ak(callback, new ak.a() { // from class: com.baidu.mobstat.aj.2
            @Override // com.baidu.mobstat.ak.a
            public void a(KeyEvent keyEvent) {
            }

            @Override // com.baidu.mobstat.ak.a
            public void a(MotionEvent motionEvent) {
                aj.a(true);
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked != 5) {
                    if (actionMasked == 6 && motionEvent.getEventTime() - motionEvent.getDownTime() < TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS) {
                        aj.this.d.removeMessages(100);
                        return;
                    }
                    return;
                }
                int pointerCount = motionEvent.getPointerCount();
                if (pointerCount == 3 && motionEvent.getEventTime() - motionEvent.getDownTime() <= 50) {
                    aj.this.d.sendEmptyMessageDelayed(100, TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS);
                } else if (pointerCount > 3) {
                    aj.this.d.removeMessages(100);
                }
            }
        }));
    }

    private void b(Activity activity) {
        d(activity);
    }

    public static void a(boolean z) {
        if (z) {
            am.a();
        }
        a = z;
    }

    public static boolean a() {
        return a;
    }

    public void b() {
        c(this.c);
        this.c = null;
    }

    public void a(Activity activity) {
        if (activity != null) {
            this.c = activity;
            b(activity);
        }
    }
}
