package com.baidu.location.a;

import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
/* loaded from: classes4.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    private static Object f1941a = new Object();
    private static x b = null;
    private HandlerThread c;
    private Handler d;
    private boolean e = false;

    x() {
    }

    public static x a() {
        x xVar;
        synchronized (f1941a) {
            if (b == null) {
                b = new x();
            }
            xVar = b;
        }
        return xVar;
    }

    public void a(Location location, int i) {
        if (!this.e || location == null) {
            return;
        }
        try {
            if (this.d != null) {
                Message obtainMessage = this.d.obtainMessage(1);
                Bundle bundle = new Bundle();
                bundle.putParcelable("loc", new Location(location));
                bundle.putInt("satnum", i);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void b() {
        if (this.e) {
            try {
                if (this.d != null) {
                    this.d.obtainMessage(3).sendToTarget();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void c() {
        if (this.e) {
            try {
                if (this.d != null) {
                    this.d.obtainMessage(2).sendToTarget();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void d() {
        if (this.e) {
            try {
                if (this.d != null) {
                    this.d.obtainMessage(7).sendToTarget();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void e() {
        if (this.e) {
            return;
        }
        this.e = true;
        if (this.c == null) {
            this.c = new HandlerThread("LocUploadThreadManager");
            this.c.start();
            this.d = new y(this, this.c.getLooper());
        }
        try {
            if (this.d != null) {
                this.d.obtainMessage(5).sendToTarget();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (this.d != null) {
                this.d.sendEmptyMessageDelayed(4, com.baidu.location.d.j.Q);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void f() {
        if (this.e) {
            d.a().b();
            try {
                if (this.d != null) {
                    this.d.removeCallbacksAndMessages(null);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.d = null;
            try {
                if (this.c != null) {
                    this.c.quit();
                    this.c.interrupt();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.c = null;
            this.e = false;
        }
    }
}
