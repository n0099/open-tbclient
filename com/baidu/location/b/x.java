package com.baidu.location.b;

import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
/* loaded from: classes2.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    public static Object f6592a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static x f6593b;

    /* renamed from: c  reason: collision with root package name */
    public HandlerThread f6594c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f6595d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6596e = false;

    public static x a() {
        x xVar;
        synchronized (f6592a) {
            if (f6593b == null) {
                f6593b = new x();
            }
            xVar = f6593b;
        }
        return xVar;
    }

    public void a(Location location, int i2) {
        if (!this.f6596e || location == null) {
            return;
        }
        try {
            if (this.f6595d != null) {
                Message obtainMessage = this.f6595d.obtainMessage(1);
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
        if (this.f6596e) {
            try {
                if (this.f6595d != null) {
                    this.f6595d.obtainMessage(3).sendToTarget();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void c() {
        if (this.f6596e) {
            try {
                if (this.f6595d != null) {
                    this.f6595d.obtainMessage(2).sendToTarget();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void d() {
        if (this.f6596e) {
            try {
                if (this.f6595d != null) {
                    this.f6595d.obtainMessage(7).sendToTarget();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void e() {
        if (this.f6596e) {
            return;
        }
        this.f6596e = true;
        if (this.f6594c == null) {
            HandlerThread handlerThread = new HandlerThread("LocUploadThreadManager");
            this.f6594c = handlerThread;
            handlerThread.start();
            if (this.f6594c != null) {
                this.f6595d = new y(this, this.f6594c.getLooper());
            }
        }
        try {
            if (this.f6595d != null) {
                this.f6595d.obtainMessage(5).sendToTarget();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            if (this.f6595d != null) {
                this.f6595d.sendEmptyMessageDelayed(4, com.baidu.location.e.k.R);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void f() {
        if (this.f6596e) {
            d.a().b();
            try {
                if (this.f6595d != null) {
                    this.f6595d.removeCallbacksAndMessages(null);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f6595d = null;
            try {
                if (this.f6594c != null) {
                    this.f6594c.quit();
                    this.f6594c.interrupt();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            this.f6594c = null;
            this.f6596e = false;
        }
    }
}
