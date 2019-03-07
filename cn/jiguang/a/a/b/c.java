package cn.jiguang.a.a.b;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.http.Headers;
import android.os.Message;
import android.support.v4.view.PointerIconCompat;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class c {
    private LocationManager kE;
    private e kF;
    private f kG;
    private String c = "";
    private final LocationListener kH = new d(this);

    public c(Context context, f fVar) {
        this.kE = (LocationManager) context.getSystemService(Headers.LOCATION);
        this.kG = fVar;
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
            if (e.a(latitude, longitude)) {
                this.kF = new e(latitude, longitude, location.getAltitude(), location.getBearing(), location.getAccuracy(), str, cn.jiguang.d.a.a.a(location.getTime()), z);
                if (this.kF != null && (f = this.kF.f()) != null) {
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
        this.kF = new e(str);
    }

    private boolean c() {
        try {
            if (this.kE != null) {
                if (!this.kE.isProviderEnabled("gps") && !this.kE.isProviderEnabled("network")) {
                    if (!this.kE.isProviderEnabled("passive")) {
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
        if (this.kG == null) {
            cn.jiguang.e.c.c("GpsInfoManager", "cellLocationManager is null,please check it");
            return;
        }
        if (this.kG.b != null) {
            if (this.kG.b.hasMessages(PointerIconCompat.TYPE_WAIT)) {
                this.kG.b.removeMessages(PointerIconCompat.TYPE_WAIT);
            }
            if (this.kG.b.hasMessages(PointerIconCompat.TYPE_HELP)) {
                this.kG.b.removeMessages(PointerIconCompat.TYPE_HELP);
            }
            if (this.kG.b.hasMessages(1001)) {
                this.kG.b.removeMessages(1001);
            }
            if (this.kG.b.hasMessages(1005)) {
                this.kG.b.removeMessages(1005);
            }
        }
        this.kG.b();
    }

    private void e() {
        try {
            if (this.kH == null || this.kE == null) {
                return;
            }
            this.kE.removeUpdates(this.kH);
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(Context context) {
        if (this.kG.a) {
            a("skip gps collect");
            this.kG.b();
        } else if (!cn.jiguang.g.a.a(context, "android.permission.ACCESS_FINE_LOCATION")) {
            a("no permission");
            this.kG.b();
        } else if (!c()) {
            a("no enabled provider");
            this.kG.b();
        } else {
            try {
                if (this.kE == null) {
                    d();
                    return;
                }
                Location lastKnownLocation = this.kE.getLastKnownLocation("gps");
                Location lastKnownLocation2 = this.kE.getLastKnownLocation("network");
                Location lastKnownLocation3 = this.kE.getLastKnownLocation("passive");
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
                } else if (this.kE.isProviderEnabled("network")) {
                    this.c = "network";
                    this.kG.b.sendEmptyMessage(PointerIconCompat.TYPE_HELP);
                } else if (this.kE.isProviderEnabled("gps")) {
                    this.c = "gps";
                    this.kG.b.sendEmptyMessage(PointerIconCompat.TYPE_HELP);
                } else {
                    this.c = "network";
                    this.kG.b.sendEmptyMessage(PointerIconCompat.TYPE_WAIT);
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
                        this.kE.requestLocationUpdates(this.c, 2000L, 0.0f, this.kH);
                        this.kG.b.sendEmptyMessageDelayed(1001, 10000L);
                    }
                    return;
                } catch (Throwable th) {
                    d();
                    return;
                }
            case 1002:
            default:
                return;
            case PointerIconCompat.TYPE_HELP /* 1003 */:
                i = 1001;
                break;
            case PointerIconCompat.TYPE_WAIT /* 1004 */:
                i = 1005;
                break;
            case 1005:
                d();
                return;
        }
        try {
            this.kE.requestLocationUpdates(this.c, 2000L, 0.0f, this.kH);
            this.kG.b.sendEmptyMessageDelayed(i, 20000L);
        } catch (SecurityException e) {
            d();
        } catch (Throwable th2) {
            d();
        }
    }

    public final void b() {
        this.kF = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final e bo() {
        return this.kF;
    }
}
