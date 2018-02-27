package android.support.v7.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.net.http.Headers;
import android.support.v4.content.PermissionChecker;
import android.util.Log;
import com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity;
import java.util.Calendar;
/* loaded from: classes2.dex */
class o {
    private static o DW;
    private final LocationManager DX;
    private final a DY = new a();
    private final Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o W(Context context) {
        if (DW == null) {
            Context applicationContext = context.getApplicationContext();
            DW = new o(applicationContext, (LocationManager) applicationContext.getSystemService(Headers.LOCATION));
        }
        return DW;
    }

    o(Context context, LocationManager locationManager) {
        this.mContext = context;
        this.DX = locationManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isNight() {
        a aVar = this.DY;
        if (eo()) {
            return aVar.DZ;
        }
        Location en = en();
        if (en != null) {
            a(en);
            return aVar.DZ;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }

    private Location en() {
        Location A = PermissionChecker.checkSelfPermission(this.mContext, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? A(LivenessRecogActivity.f.J) : null;
        Location A2 = PermissionChecker.checkSelfPermission(this.mContext, "android.permission.ACCESS_FINE_LOCATION") == 0 ? A("gps") : null;
        if (A2 != null && A != null) {
            return A2.getTime() > A.getTime() ? A2 : A;
        }
        if (A2 == null) {
            A2 = A;
        }
        return A2;
    }

    private Location A(String str) {
        if (this.DX != null) {
            try {
                if (this.DX.isProviderEnabled(str)) {
                    return this.DX.getLastKnownLocation(str);
                }
            } catch (Exception e) {
                Log.d("TwilightManager", "Failed to get last known location", e);
            }
        }
        return null;
    }

    private boolean eo() {
        return this.DY != null && this.DY.Ee > System.currentTimeMillis();
    }

    private void a(Location location) {
        long j;
        long j2;
        a aVar = this.DY;
        long currentTimeMillis = System.currentTimeMillis();
        n em = n.em();
        em.a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j3 = em.DU;
        em.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = em.state == 1;
        long j4 = em.DV;
        long j5 = em.DU;
        em.a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j6 = em.DV;
        if (j4 == -1 || j5 == -1) {
            j = 43200000 + currentTimeMillis;
        } else {
            if (currentTimeMillis > j5) {
                j2 = 0 + j6;
            } else if (currentTimeMillis > j4) {
                j2 = 0 + j5;
            } else {
                j2 = 0 + j4;
            }
            j = j2 + 60000;
        }
        aVar.DZ = z;
        aVar.Ea = j3;
        aVar.Eb = j4;
        aVar.Ec = j5;
        aVar.Ed = j6;
        aVar.Ee = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        boolean DZ;
        long Ea;
        long Eb;
        long Ec;
        long Ed;
        long Ee;

        a() {
        }
    }
}
