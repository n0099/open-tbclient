package com.baidu.location.a;

import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
/* loaded from: classes2.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    public static Object f6637a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static x f6638b;

    /* renamed from: c  reason: collision with root package name */
    public HandlerThread f6639c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f6640d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6641e = false;

    public static x a() {
        x xVar;
        synchronized (f6637a) {
            if (f6638b == null) {
                f6638b = new x();
            }
            xVar = f6638b;
        }
        return xVar;
    }

    public void a(Location location, int i) {
        if (!this.f6641e || location == null) {
            return;
        }
        try {
            if (this.f6640d != null) {
                Message obtainMessage = this.f6640d.obtainMessage(1);
                Bundle bundle = new Bundle();
                bundle.putParcelable("loc", new Location(location));
                bundle.putInt("satnum", i);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void b() {
        if (this.f6641e) {
            try {
                if (this.f6640d != null) {
                    this.f6640d.obtainMessage(3).sendToTarget();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void c() {
        if (this.f6641e) {
            try {
                if (this.f6640d != null) {
                    this.f6640d.obtainMessage(2).sendToTarget();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void d() {
        if (this.f6641e) {
            try {
                if (this.f6640d != null) {
                    this.f6640d.obtainMessage(7).sendToTarget();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void e() {
        if (this.f6641e) {
            return;
        }
        this.f6641e = true;
        if (this.f6639c == null) {
            HandlerThread handlerThread = new HandlerThread("LocUploadThreadManager");
            this.f6639c = handlerThread;
            handlerThread.start();
            this.f6640d = new y(this, this.f6639c.getLooper());
        }
        try {
            if (this.f6640d != null) {
                this.f6640d.obtainMessage(5).sendToTarget();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            if (this.f6640d != null) {
                this.f6640d.sendEmptyMessageDelayed(4, com.baidu.location.d.j.Q);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void f() {
        if (this.f6641e) {
            d.a().b();
            try {
                if (this.f6640d != null) {
                    this.f6640d.removeCallbacksAndMessages(null);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f6640d = null;
            try {
                if (this.f6639c != null) {
                    this.f6639c.quit();
                    this.f6639c.interrupt();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            this.f6639c = null;
            this.f6641e = false;
        }
    }
}
