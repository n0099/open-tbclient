package com.baidu.location.a;

import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
/* loaded from: classes2.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    public static Object f6602a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static x f6603b;

    /* renamed from: c  reason: collision with root package name */
    public HandlerThread f6604c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f6605d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6606e = false;

    public static x a() {
        x xVar;
        synchronized (f6602a) {
            if (f6603b == null) {
                f6603b = new x();
            }
            xVar = f6603b;
        }
        return xVar;
    }

    public void a(Location location, int i) {
        if (!this.f6606e || location == null) {
            return;
        }
        try {
            if (this.f6605d != null) {
                Message obtainMessage = this.f6605d.obtainMessage(1);
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
        if (this.f6606e) {
            try {
                if (this.f6605d != null) {
                    this.f6605d.obtainMessage(3).sendToTarget();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void c() {
        if (this.f6606e) {
            try {
                if (this.f6605d != null) {
                    this.f6605d.obtainMessage(2).sendToTarget();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void d() {
        if (this.f6606e) {
            try {
                if (this.f6605d != null) {
                    this.f6605d.obtainMessage(7).sendToTarget();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void e() {
        if (this.f6606e) {
            return;
        }
        this.f6606e = true;
        if (this.f6604c == null) {
            HandlerThread handlerThread = new HandlerThread("LocUploadThreadManager");
            this.f6604c = handlerThread;
            handlerThread.start();
            this.f6605d = new y(this, this.f6604c.getLooper());
        }
        try {
            if (this.f6605d != null) {
                this.f6605d.obtainMessage(5).sendToTarget();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            if (this.f6605d != null) {
                this.f6605d.sendEmptyMessageDelayed(4, com.baidu.location.d.j.Q);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void f() {
        if (this.f6606e) {
            d.a().b();
            try {
                if (this.f6605d != null) {
                    this.f6605d.removeCallbacksAndMessages(null);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f6605d = null;
            try {
                if (this.f6604c != null) {
                    this.f6604c.quit();
                    this.f6604c.interrupt();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            this.f6604c = null;
            this.f6606e = false;
        }
    }
}
