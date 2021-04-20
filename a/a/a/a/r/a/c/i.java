package a.a.a.a.r.a.c;

import a.a.a.a.r.a.c.g;
import com.qq.e.ads.nativ.NativeUnifiedADData;
/* loaded from: classes.dex */
public class i implements g.d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a.a.a.a.r.b.b.b f1176a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NativeUnifiedADData f1177b;

    public i(g gVar, a.a.a.a.r.b.b.b bVar, NativeUnifiedADData nativeUnifiedADData) {
        this.f1176a = bVar;
        this.f1177b = nativeUnifiedADData;
    }

    @Override // a.a.a.a.r.a.c.g.d
    public void onADStatusChanged() {
        this.f1176a.a(this.f1177b);
    }
}
