package com.baidu.mobstat;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;
import com.baidu.mobstat.as;
/* loaded from: classes6.dex */
public class ar {
    private static volatile boolean a = true;
    private a b;
    private Activity c;
    private Handler d = new Handler(Looper.getMainLooper()) { // from class: com.baidu.mobstat.ar.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 100:
                    if (ar.this.b != null) {
                        ar.this.b.a();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void a();
    }

    public ar(a aVar) {
        this.b = aVar;
    }

    public static void a(boolean z) {
        if (z) {
            au.a();
        }
        a = z;
    }

    public static boolean a() {
        return a;
    }

    public void a(Activity activity) {
        if (activity != null) {
            this.c = activity;
            b(activity);
        }
    }

    public void b() {
        c(this.c);
        this.c = null;
    }

    private void b(Activity activity) {
        d(activity);
    }

    private void c(Activity activity) {
        Window window;
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setCallback(a(window.getCallback()));
        }
    }

    private Window.Callback a(Window.Callback callback) {
        Window.Callback callback2 = callback;
        while (callback2 != null && (callback2 instanceof as)) {
            callback2 = ((as) callback2).a();
        }
        return callback2;
    }

    private void d(Activity activity) {
        Window.Callback callback;
        Window window = activity.getWindow();
        if (window != null && (callback = window.getCallback()) != null) {
            window.setCallback(new as(callback, new as.a() { // from class: com.baidu.mobstat.ar.2
                @Override // com.baidu.mobstat.as.a
                public void a(MotionEvent motionEvent) {
                    ar.a(true);
                    switch (motionEvent.getActionMasked()) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        default:
                            return;
                        case 5:
                            int pointerCount = motionEvent.getPointerCount();
                            if (pointerCount == 2 && motionEvent.getEventTime() - motionEvent.getDownTime() <= 50) {
                                ar.this.d.sendEmptyMessageDelayed(100, 2500L);
                                return;
                            } else if (pointerCount > 2) {
                                ar.this.d.removeMessages(100);
                                return;
                            } else {
                                return;
                            }
                        case 6:
                            if (motionEvent.getEventTime() - motionEvent.getDownTime() < 2500) {
                                ar.this.d.removeMessages(100);
                                return;
                            }
                            return;
                    }
                }

                @Override // com.baidu.mobstat.as.a
                public void a(KeyEvent keyEvent) {
                }
            }));
        }
    }
}
