package b.a.a.a.a;

import android.location.Location;
/* loaded from: classes15.dex */
public final class ae {
    public ad Bg;

    /* renamed from: b  reason: collision with root package name */
    public String f1052b;
    public String c = "network";
    private Location d;

    public final ae f(Location location) {
        this.d = new Location(location);
        return this;
    }

    public final ad hM() {
        ad adVar;
        if (this.f1052b != null) {
            try {
                adVar = new ad(this.f1052b, (byte) 0);
            } catch (Throwable th) {
                new StringBuilder("build: ").append(th);
                return ad.Bg;
            }
        } else {
            adVar = ad.b(this.Bg);
        }
        adVar.h = this.c.f1051b = this.d;
        return adVar;
    }
}
