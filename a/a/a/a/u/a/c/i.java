package a.a.a.a.u.a.c;

import a.a.a.a.u.a.c.g;
import com.qq.e.ads.nativ.NativeUnifiedADData;
/* loaded from: classes.dex */
public class i implements g.d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a.a.a.a.u.b.b.b f1195a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NativeUnifiedADData f1196b;

    public i(g gVar, a.a.a.a.u.b.b.b bVar, NativeUnifiedADData nativeUnifiedADData) {
        this.f1195a = bVar;
        this.f1196b = nativeUnifiedADData;
    }

    @Override // a.a.a.a.u.a.c.g.d
    public void onADStatusChanged() {
        this.f1195a.a(this.f1196b);
    }
}
