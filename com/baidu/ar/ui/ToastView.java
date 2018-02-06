package com.baidu.ar.ui;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public class ToastView extends TextView {
    protected Timer a;
    protected TimerTask b;
    protected Timer c;
    protected TimerTask d;
    boolean e;
    private int f;
    private int g;
    private b h;
    private a i;
    private c j;

    /* loaded from: classes3.dex */
    public interface a {
        void a(ToastView toastView);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(ToastView toastView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class c extends Handler {
        private ToastView a;

        c(ToastView toastView) {
            this.a = toastView;
        }

        public void a() {
            this.a = null;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.a == null) {
                return;
            }
            switch (message.what) {
                case 1:
                    this.a.setVisibility(0);
                    this.a.e();
                    if (this.a.h != null) {
                        this.a.h.a(this.a);
                        return;
                    }
                    return;
                case 2:
                    this.a.setVisibility(8);
                    if (this.a.i != null) {
                        this.a.i.a(this.a);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public ToastView(Context context) {
        super(context);
        this.f = 7000;
        this.g = 2000;
        this.e = false;
    }

    public ToastView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = 7000;
        this.g = 2000;
        this.e = false;
    }

    public ToastView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = 7000;
        this.g = 2000;
        this.e = false;
    }

    private void b() {
        c();
        this.a = new Timer();
        if (this.b == null) {
            this.b = new TimerTask() { // from class: com.baidu.ar.ui.ToastView.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    try {
                        if (ToastView.this.j != null) {
                            ToastView.this.j.sendEmptyMessage(1);
                        }
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }
                }
            };
        }
        this.a.schedule(this.b, this.f);
    }

    private void c() {
        if (this.a != null) {
            this.a.cancel();
            this.a.purge();
            this.a = null;
        }
        if (this.b != null) {
            this.b.cancel();
            this.b = null;
        }
    }

    private void d() {
        if (this.c != null) {
            this.c.cancel();
            this.c.purge();
            this.c = null;
        }
        if (this.d != null) {
            this.d.cancel();
            this.d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        d();
        this.c = new Timer();
        if (this.j == null) {
            this.j = new c(this);
        }
        if (this.d == null) {
            this.d = new TimerTask() { // from class: com.baidu.ar.ui.ToastView.2
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    try {
                        if (ToastView.this.j != null) {
                            ToastView.this.j.sendEmptyMessage(2);
                        }
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }
                }
            };
        }
        this.c.schedule(this.d, this.g);
    }

    public void a() {
        this.e = false;
        c();
        d();
        setVisibility(8);
        if (this.j != null) {
            this.j.a();
            this.j = null;
        }
    }

    public void a(int i, int i2) {
        a(i, null, i2, null);
    }

    public void a(int i, b bVar, int i2, a aVar) {
        if (this.e) {
            return;
        }
        this.e = true;
        this.h = bVar;
        this.i = aVar;
        this.f = i;
        this.g = i2;
        if (i > 0) {
            if (this.j == null) {
                this.j = new c(this);
            }
            b();
            return;
        }
        if (i2 > 0) {
            if (this.j == null) {
                this.j = new c(this);
            }
            e();
        }
        setVisibility(0);
    }

    public void setShowingTime(int i) {
        this.f = i;
    }
}
