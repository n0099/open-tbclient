package b.a.a.a.a;

import android.location.Location;
/* loaded from: classes3.dex */
public final class ae {
    public ad Bh;
    private Location Bk;

    /* renamed from: b  reason: collision with root package name */
    public String f1052b;
    public String c = "network";

    public final ae g(Location location) {
        this.Bk = new Location(location);
        return this;
    }

    public final ad hM() {
        ad adVar;
        if (this.f1052b != null) {
            try {
                adVar = new ad(this.f1052b, (byte) 0);
            } catch (Throwable th) {
                new StringBuilder("build: ").append(th);
                return ad.Bh;
            }
        } else {
            adVar = ad.b(this.Bh);
        }
        adVar.h = this.c.f1051b = this.Bk;
        return adVar;
    }
}
