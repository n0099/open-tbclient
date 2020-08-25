package com.baidu.location.b;

import android.annotation.TargetApi;
import android.location.GnssNavigationMessage;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
/* loaded from: classes20.dex */
public class ac {
    private static Object a = new Object();
    private static ac b = null;
    private HandlerThread c;
    private Handler d;
    private boolean e = false;

    ac() {
    }

    public static ac a() {
        ac acVar;
        synchronized (a) {
            if (b == null) {
                b = new ac();
            }
            acVar = b;
        }
        return acVar;
    }

    @TargetApi(24)
    public void a(GnssNavigationMessage gnssNavigationMessage, long j) {
        if (!this.e || gnssNavigationMessage == null) {
            return;
        }
        try {
            if (this.d != null) {
                Message obtainMessage = this.d.obtainMessage(11);
                Bundle bundle = new Bundle();
                bundle.putParcelable("gnss_navigation_message", gnssNavigationMessage);
                bundle.putLong("gps_time", j);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
            if (this.c != null) {
                this.d = new ad(this, this.c.getLooper());
            }
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
                this.d.sendEmptyMessageDelayed(4, com.baidu.location.e.l.R);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void f() {
        if (this.e) {
            g.a().b();
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
