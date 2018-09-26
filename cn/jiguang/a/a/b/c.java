package cn.jiguang.a.a.b;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.http.Headers;
import android.os.Message;
import com.baidu.baiduarsdk.ArBridge;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class c {
    private LocationManager jV;
    private e jW;
    private f jX;
    private String c = "";
    private final LocationListener jY = new d(this);

    public c(Context context, f fVar) {
        this.jV = (LocationManager) context.getSystemService(Headers.LOCATION);
        this.jX = fVar;
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
                this.jW = new e(latitude, longitude, location.getAltitude(), location.getBearing(), location.getAccuracy(), str, cn.jiguang.d.a.a.a(location.getTime()), z);
                if (this.jW != null && (f = this.jW.f()) != null) {
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
        this.jW = new e(str);
    }

    private boolean c() {
        try {
            if (this.jV != null) {
                if (!this.jV.isProviderEnabled("gps") && !this.jV.isProviderEnabled("network")) {
                    if (!this.jV.isProviderEnabled("passive")) {
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
        if (this.jX == null) {
            cn.jiguang.e.c.c("GpsInfoManager", "cellLocationManager is null,please check it");
            return;
        }
        if (this.jX.b != null) {
            if (this.jX.b.hasMessages(1004)) {
                this.jX.b.removeMessages(1004);
            }
            if (this.jX.b.hasMessages(1003)) {
                this.jX.b.removeMessages(1003);
            }
            if (this.jX.b.hasMessages(1001)) {
                this.jX.b.removeMessages(1001);
            }
            if (this.jX.b.hasMessages(ArBridge.MessageType.MSG_TYPE_RESUME_MUSIC)) {
                this.jX.b.removeMessages(ArBridge.MessageType.MSG_TYPE_RESUME_MUSIC);
            }
        }
        this.jX.b();
    }

    private void e() {
        try {
            if (this.jY == null || this.jV == null) {
                return;
            }
            this.jV.removeUpdates(this.jY);
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(Context context) {
        if (this.jX.a) {
            a("skip gps collect");
            this.jX.b();
        } else if (!cn.jiguang.g.a.a(context, "android.permission.ACCESS_FINE_LOCATION")) {
            a("no permission");
            this.jX.b();
        } else if (!c()) {
            a("no enabled provider");
            this.jX.b();
        } else {
            try {
                if (this.jV == null) {
                    d();
                    return;
                }
                Location lastKnownLocation = this.jV.getLastKnownLocation("gps");
                Location lastKnownLocation2 = this.jV.getLastKnownLocation("network");
                Location lastKnownLocation3 = this.jV.getLastKnownLocation("passive");
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
                } else if (this.jV.isProviderEnabled("network")) {
                    this.c = "network";
                    this.jX.b.sendEmptyMessage(1003);
                } else if (this.jV.isProviderEnabled("gps")) {
                    this.c = "gps";
                    this.jX.b.sendEmptyMessage(1003);
                } else {
                    this.c = "network";
                    this.jX.b.sendEmptyMessage(1004);
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
                        this.jV.requestLocationUpdates(this.c, 2000L, 0.0f, this.jY);
                        this.jX.b.sendEmptyMessageDelayed(1001, 10000L);
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
            case ArBridge.MessageType.MSG_TYPE_RESUME_MUSIC /* 1005 */:
                d();
                return;
        }
        try {
            this.jV.requestLocationUpdates(this.c, 2000L, 0.0f, this.jY);
            this.jX.b.sendEmptyMessageDelayed(i, 20000L);
        } catch (SecurityException e) {
            d();
        } catch (Throwable th2) {
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final e aX() {
        return this.jW;
    }

    public final void b() {
        this.jW = null;
    }
}
