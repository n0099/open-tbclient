package b.a.a.a.a;

import android.location.Location;
import android.net.http.Headers;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.map.geoloclite.tsa.TencentLiteLocation;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public final class ad implements TencentLiteLocation {
    public static final ad Bg = new ad(-1);
    private o Bh;
    private final Bundle Bi;

    /* renamed from: b  reason: collision with root package name */
    private Location f1051b;
    private final long d;
    private long e;
    private int f;
    private String g;
    private String h;
    private String i;

    private ad(int i) {
        this.h = "network";
        this.i = "";
        this.Bi = new Bundle();
        this.f = i;
        this.d = SystemClock.elapsedRealtime();
        this.e = System.currentTimeMillis();
    }

    private ad(String str) throws JSONException {
        this(0);
        JSONObject jSONObject = new JSONObject(str);
        this.Bh = new o(jSONObject.getJSONObject(Headers.LOCATION));
        this.g = jSONObject.optString("bearing");
        this.e = jSONObject.optLong("timestamp", System.currentTimeMillis());
        try {
            this.i = jSONObject.optJSONObject("indoorinfo").optString("bid", "");
        } catch (Throwable th) {
            this.i = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ad(String str, byte b2) throws JSONException {
        this(str);
    }

    public static ad a(ad adVar) {
        double d;
        if (adVar != null) {
            try {
                if (adVar.g != null && adVar.Bh != null) {
                    String str = adVar.g;
                    int i = 0;
                    if (str != null && str.split(",").length > 1) {
                        i = Integer.parseInt(str.split(",")[1]);
                    }
                    o oVar = adVar.Bh;
                    double d2 = adVar.Bh.d;
                    if (i >= 6) {
                        d = 40.0d;
                    } else if (i == 5) {
                        d = 60.0d;
                    } else if (i == 4) {
                        d = 70.0d;
                    } else if (i == 3) {
                        d = 90.0d;
                    } else if (i == 2) {
                        d = 110.0d;
                    } else {
                        d = i == 0 ? ((int) ((0.45d * d2) / 10.0d)) * 10 : d2 <= 100.0d ? ((int) (((d2 - 1.0d) / 10.0d) + 1.0d)) * 10 : (d2 <= 100.0d || d2 > 800.0d) ? ((int) ((0.8d * d2) / 10.0d)) * 10 : ((int) ((0.85d * d2) / 10.0d)) * 10;
                    }
                    oVar.d = (float) d;
                }
            } catch (Throwable th) {
            }
        }
        return adVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ad b(ad adVar) {
        ad adVar2 = new ad(-1);
        if (adVar == null) {
            adVar2.Bh = new o();
        } else {
            o oVar = adVar.Bh;
            o oVar2 = new o();
            if (oVar != null) {
                oVar2.f1068a = oVar.f1068a;
                oVar2.f1069b = oVar.f1069b;
                oVar2.c = oVar.c;
                oVar2.d = oVar.d;
            }
            adVar2.Bh = oVar2;
            adVar2.f = adVar.f;
            adVar2.g = adVar.g;
            adVar2.i = adVar.i;
            if (adVar.Bi.size() > 0) {
                adVar2.Bi.putAll(adVar.Bi);
            }
        }
        return adVar2;
    }

    public final void a(Location location) {
        if (location == null || this.Bh == null) {
            return;
        }
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        this.Bh.f1068a = Math.round(latitude * 1000000.0d) / 1000000.0d;
        this.Bh.f1069b = Math.round(longitude * 1000000.0d) / 1000000.0d;
        this.Bh.c = location.getAltitude();
        this.Bh.d = location.getAccuracy();
    }

    public final boolean a() {
        return this.i.length() > 0;
    }

    @Override // com.tencent.map.geoloclite.tsa.TencentLiteLocation
    public final float getAccuracy() {
        if (this.Bh != null) {
            return this.Bh.d;
        }
        return 0.0f;
    }

    @Override // com.tencent.map.geoloclite.tsa.TencentLiteLocation
    public final double getAltitude() {
        if (this.Bh != null) {
            return this.Bh.c;
        }
        return 0.0d;
    }

    @Override // com.tencent.map.geoloclite.tsa.TencentLiteLocation
    public final long getElapsedRealtime() {
        return this.d;
    }

    @Override // com.tencent.map.geoloclite.tsa.TencentLiteLocation
    public final Bundle getExtra() {
        return this.Bi;
    }

    @Override // com.tencent.map.geoloclite.tsa.TencentLiteLocation
    public final double getLatitude() {
        if (this.Bh != null) {
            return this.Bh.f1068a;
        }
        return 0.0d;
    }

    @Override // com.tencent.map.geoloclite.tsa.TencentLiteLocation
    public final double getLongitude() {
        if (this.Bh != null) {
            return this.Bh.f1069b;
        }
        return 0.0d;
    }

    @Override // com.tencent.map.geoloclite.tsa.TencentLiteLocation
    public final String getProvider() {
        return this.h;
    }

    @Override // com.tencent.map.geoloclite.tsa.TencentLiteLocation
    public final float getSpeed() {
        if (this.f1051b != null) {
            return this.f1051b.getSpeed();
        }
        return 0.0f;
    }

    @Override // com.tencent.map.geoloclite.tsa.TencentLiteLocation
    public final long getTime() {
        return this.e;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TxLocation{");
        sb.append("level=").append(this.f).append(",");
        sb.append("provider=").append(getProvider()).append(",");
        sb.append("latitude=").append(getLatitude()).append(",");
        sb.append("longitude=").append(getLongitude()).append(",");
        sb.append("altitude=").append(getAltitude()).append(",");
        sb.append("accuracy=").append(getAccuracy()).append(",");
        sb.append("time=").append(getTime()).append(",");
        sb.append("}");
        return sb.toString();
    }
}
