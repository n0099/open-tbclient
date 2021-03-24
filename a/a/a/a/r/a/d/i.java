package a.a.a.a.r.a.d;

import a.a.a.a.r.a.d.g;
import com.qq.e.ads.nativ.NativeUnifiedADData;
/* loaded from: classes.dex */
public class i implements g.d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a.a.a.a.r.b.c.b f1184a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NativeUnifiedADData f1185b;

    public i(g gVar, a.a.a.a.r.b.c.b bVar, NativeUnifiedADData nativeUnifiedADData) {
        this.f1184a = bVar;
        this.f1185b = nativeUnifiedADData;
    }

    @Override // a.a.a.a.r.a.d.g.d
    public void onADStatusChanged() {
        this.f1184a.a(this.f1185b);
    }
}
