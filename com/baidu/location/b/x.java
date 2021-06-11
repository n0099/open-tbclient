package com.baidu.location.b;

import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
/* loaded from: classes2.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    public static Object f6635a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static x f6636b;

    /* renamed from: c  reason: collision with root package name */
    public HandlerThread f6637c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f6638d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6639e = false;

    public static x a() {
        x xVar;
        synchronized (f6635a) {
            if (f6636b == null) {
                f6636b = new x();
            }
            xVar = f6636b;
        }
        return xVar;
    }

    public void a(Location location, int i2) {
        if (!this.f6639e || location == null) {
            return;
        }
        try {
            if (this.f6638d != null) {
                Message obtainMessage = this.f6638d.obtainMessage(1);
                Bundle bundle = new Bundle();
                bundle.putParcelable("loc", new Location(location));
                bundle.putInt("satnum", i2);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void b() {
        if (this.f6639e) {
            try {
                if (this.f6638d != null) {
                    this.f6638d.obtainMessage(3).sendToTarget();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void c() {
        if (this.f6639e) {
            try {
                if (this.f6638d != null) {
                    this.f6638d.obtainMessage(2).sendToTarget();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void d() {
        if (this.f6639e) {
            try {
                if (this.f6638d != null) {
                    this.f6638d.obtainMessage(7).sendToTarget();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void e() {
        if (this.f6639e) {
            return;
        }
        this.f6639e = true;
        if (this.f6637c == null) {
            HandlerThread handlerThread = new HandlerThread("LocUploadThreadManager");
            this.f6637c = handlerThread;
            handlerThread.start();
            if (this.f6637c != null) {
                this.f6638d = new y(this, this.f6637c.getLooper());
            }
        }
        try {
            if (this.f6638d != null) {
                this.f6638d.obtainMessage(5).sendToTarget();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            if (this.f6638d != null) {
                this.f6638d.sendEmptyMessageDelayed(4, com.baidu.location.e.k.R);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void f() {
        if (this.f6639e) {
            d.a().b();
            try {
                if (this.f6638d != null) {
                    this.f6638d.removeCallbacksAndMessages(null);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f6638d = null;
            try {
                if (this.f6637c != null) {
                    this.f6637c.quit();
                    this.f6637c.interrupt();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            this.f6637c = null;
            this.f6639e = false;
        }
    }
}
