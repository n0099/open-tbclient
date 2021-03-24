package com.baidu.mobstat;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;
import androidx.appcompat.widget.TooltipCompatHandler;
import com.baidu.mobstat.al;
/* loaded from: classes2.dex */
public class ak {

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f8905a = true;

    /* renamed from: b  reason: collision with root package name */
    public a f8906b;

    /* renamed from: c  reason: collision with root package name */
    public Activity f8907c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f8908d = new Handler(Looper.getMainLooper()) { // from class: com.baidu.mobstat.ak.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 100 && ak.this.f8906b != null) {
                ak.this.f8906b.a();
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void a();
    }

    public ak(a aVar) {
        this.f8906b = aVar;
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
        window.setCallback(new al(callback, new al.a() { // from class: com.baidu.mobstat.ak.2
            @Override // com.baidu.mobstat.al.a
            public void a(KeyEvent keyEvent) {
            }

            @Override // com.baidu.mobstat.al.a
            public void a(MotionEvent motionEvent) {
                ak.a(true);
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked != 5) {
                    if (actionMasked == 6 && motionEvent.getEventTime() - motionEvent.getDownTime() < TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS) {
                        ak.this.f8908d.removeMessages(100);
                        return;
                    }
                    return;
                }
                int pointerCount = motionEvent.getPointerCount();
                if (pointerCount == 3 && motionEvent.getEventTime() - motionEvent.getDownTime() <= 50) {
                    ak.this.f8908d.sendEmptyMessageDelayed(100, TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS);
                } else if (pointerCount > 3) {
                    ak.this.f8908d.removeMessages(100);
                }
            }
        }));
    }

    public static void a(boolean z) {
        if (z) {
            an.a();
        }
        f8905a = z;
    }

    public void b() {
        c(this.f8907c);
        this.f8907c = null;
    }

    public static boolean a() {
        return f8905a;
    }

    private void b(Activity activity) {
        d(activity);
    }

    public void a(Activity activity) {
        if (activity != null) {
            this.f8907c = activity;
            b(activity);
        }
    }

    private Window.Callback a(Window.Callback callback) {
        while (callback != null && (callback instanceof al)) {
            callback = ((al) callback).a();
        }
        return callback;
    }
}
