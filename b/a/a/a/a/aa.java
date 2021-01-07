package b.a.a.a.a;

import android.location.Location;
/* loaded from: classes4.dex */
public final class aa extends ac {

    /* renamed from: a  reason: collision with root package name */
    public static final Location f1049a = new Location("EMPTY");

    /* renamed from: b  reason: collision with root package name */
    public final Location f1050b;
    public final long c;

    public aa(Location location, long j) {
        this.f1050b = location;
        this.c = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(double d, int i) {
        try {
            return Double.isNaN(d) ? "0" : String.format("%." + i + "f", Double.valueOf(d));
        } catch (Throwable th) {
            return "0";
        }
    }

    public final String toString() {
        return "TxGpsInfo [location=" + this.f1050b + ", gpsTime=" + this.c + "]";
    }
}
