package com.baidu.location.a;

import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
/* loaded from: classes2.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    public static Object f6864a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static x f6865b;

    /* renamed from: c  reason: collision with root package name */
    public HandlerThread f6866c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f6867d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6868e = false;

    public static x a() {
        x xVar;
        synchronized (f6864a) {
            if (f6865b == null) {
                f6865b = new x();
            }
            xVar = f6865b;
        }
        return xVar;
    }

    public void a(Location location, int i2) {
        if (!this.f6868e || location == null) {
            return;
        }
        try {
            if (this.f6867d != null) {
                Message obtainMessage = this.f6867d.obtainMessage(1);
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
        if (this.f6868e) {
            try {
                if (this.f6867d != null) {
                    this.f6867d.obtainMessage(3).sendToTarget();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void c() {
        if (this.f6868e) {
            try {
                if (this.f6867d != null) {
                    this.f6867d.obtainMessage(2).sendToTarget();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void d() {
        if (this.f6868e) {
            try {
                if (this.f6867d != null) {
                    this.f6867d.obtainMessage(7).sendToTarget();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void e() {
        if (this.f6868e) {
            return;
        }
        this.f6868e = true;
        if (this.f6866c == null) {
            HandlerThread handlerThread = new HandlerThread("LocUploadThreadManager");
            this.f6866c = handlerThread;
            handlerThread.start();
            this.f6867d = new y(this, this.f6866c.getLooper());
        }
        try {
            if (this.f6867d != null) {
                this.f6867d.obtainMessage(5).sendToTarget();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            if (this.f6867d != null) {
                this.f6867d.sendEmptyMessageDelayed(4, com.baidu.location.d.j.Q);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void f() {
        if (this.f6868e) {
            d.a().b();
            try {
                if (this.f6867d != null) {
                    this.f6867d.removeCallbacksAndMessages(null);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f6867d = null;
            try {
                if (this.f6866c != null) {
                    this.f6866c.quit();
                    this.f6866c.interrupt();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            this.f6866c = null;
            this.f6868e = false;
        }
    }
}
