package cn.jiguang.a.a.b;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.http.Headers;
import android.os.Message;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.searchbox.ng.ai.apps.trace.ErrDef;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class c {
    private LocationManager kC;
    private e kD;
    private f kE;
    private String c = "";
    private final LocationListener kF = new d(this);

    public c(Context context, f fVar) {
        this.kC = (LocationManager) context.getSystemService(Headers.LOCATION);
        this.kE = fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Location location, String str, boolean z) {
        JSONObject f;
        if (location == null) {
            a("update location is null");
            return;
        }
        try {
            double latitude = location.getLatitude();
            double longitude = location.getLongitude();
            if (e.b(latitude, longitude)) {
                this.kD = new e(latitude, longitude, location.getAltitude(), location.getBearing(), location.getAccuracy(), str, cn.jiguang.d.a.a.a(location.getTime()), z);
                if (this.kD != null && (f = this.kD.f()) != null) {
                    cn.jiguang.d.a.d.b(f.toString());
                }
            } else {
                a("latitude(" + latitude + ") or longitude(" + longitude + ") is invalid");
            }
        } catch (Exception e) {
            a("update exception" + e.getMessage());
        }
    }

    private void a(String str) {
        this.kD = new e(str);
    }

    private boolean c() {
        try {
            if (this.kC != null) {
                if (!this.kC.isProviderEnabled("gps") && !this.kC.isProviderEnabled("network")) {
                    if (!this.kC.isProviderEnabled("passive")) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        } catch (IllegalArgumentException e) {
            return false;
        } catch (SecurityException e2) {
            return false;
        } catch (Exception e3) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        e();
        if (this.kE == null) {
            cn.jiguang.e.c.c("GpsInfoManager", "cellLocationManager is null,please check it");
            return;
        }
        if (this.kE.b != null) {
            if (this.kE.b.hasMessages(1004)) {
                this.kE.b.removeMessages(1004);
            }
            if (this.kE.b.hasMessages(1003)) {
                this.kE.b.removeMessages(1003);
            }
            if (this.kE.b.hasMessages(1001)) {
                this.kE.b.removeMessages(1001);
            }
            if (this.kE.b.hasMessages(1005)) {
                this.kE.b.removeMessages(1005);
            }
        }
        this.kE.b();
    }

    private void e() {
        try {
            if (this.kF == null || this.kC == null) {
                return;
            }
            this.kC.removeUpdates(this.kF);
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(Context context) {
        if (this.kE.a) {
            a("skip gps collect");
            this.kE.b();
        } else if (!cn.jiguang.g.a.a(context, "android.permission.ACCESS_FINE_LOCATION")) {
            a("no permission");
            this.kE.b();
        } else if (!c()) {
            a("no enabled provider");
            this.kE.b();
        } else {
            try {
                if (this.kC == null) {
                    d();
                    return;
                }
                Location lastKnownLocation = this.kC.getLastKnownLocation("gps");
                Location lastKnownLocation2 = this.kC.getLastKnownLocation("network");
                Location lastKnownLocation3 = this.kC.getLastKnownLocation("passive");
                long time = lastKnownLocation == null ? 0L : lastKnownLocation.getTime();
                long time2 = lastKnownLocation2 == null ? 0L : lastKnownLocation2.getTime();
                long time3 = lastKnownLocation3 == null ? 0L : lastKnownLocation3.getTime();
                if (time > time2) {
                    if (time > time3) {
                        lastKnownLocation3 = lastKnownLocation;
                    }
                } else if (time2 > time3) {
                    lastKnownLocation3 = lastKnownLocation2;
                }
                a(lastKnownLocation3, lastKnownLocation3 != null ? lastKnownLocation3.getProvider() : "", true);
                if (System.currentTimeMillis() - (lastKnownLocation3 != null ? lastKnownLocation3.getTime() : 0L) < StatisticConfig.MIN_UPLOAD_INTERVAL) {
                    d();
                } else if (this.kC.isProviderEnabled("network")) {
                    this.c = "network";
                    this.kE.b.sendEmptyMessage(1003);
                } else if (this.kC.isProviderEnabled("gps")) {
                    this.c = "gps";
                    this.kE.b.sendEmptyMessage(1003);
                } else {
                    this.c = "network";
                    this.kE.b.sendEmptyMessage(1004);
                }
            } catch (SecurityException e) {
                d();
            } catch (Exception e2) {
                d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(Message message) {
        int i;
        switch (message.what) {
            case 1001:
                try {
                    if (this.c == null || !this.c.equals("network")) {
                        d();
                    } else {
                        this.c = "gps";
                        e();
                        this.kC.requestLocationUpdates(this.c, SystemScreenshotManager.DELAY_TIME, 0.0f, this.kF);
                        this.kE.b.sendEmptyMessageDelayed(1001, ErrDef.Feature.WEIGHT);
                    }
                    return;
                } catch (Throwable th) {
                    d();
                    return;
                }
            case 1002:
            default:
                return;
            case 1003:
                i = 1001;
                break;
            case 1004:
                i = 1005;
                break;
            case 1005:
                d();
                return;
        }
        try {
            this.kC.requestLocationUpdates(this.c, SystemScreenshotManager.DELAY_TIME, 0.0f, this.kF);
            this.kE.b.sendEmptyMessageDelayed(i, 20000L);
        } catch (SecurityException e) {
            d();
        } catch (Throwable th2) {
            d();
        }
    }

    public final void b() {
        this.kD = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final e bo() {
        return this.kD;
    }
}
