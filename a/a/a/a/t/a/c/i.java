package a.a.a.a.t.a.c;

import a.a.a.a.t.a.c.g;
import com.qq.e.ads.nativ.NativeUnifiedADData;
/* loaded from: classes.dex */
public class i implements g.d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a.a.a.a.t.b.b.b f1192a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NativeUnifiedADData f1193b;

    public i(g gVar, a.a.a.a.t.b.b.b bVar, NativeUnifiedADData nativeUnifiedADData) {
        this.f1192a = bVar;
        this.f1193b = nativeUnifiedADData;
    }

    @Override // a.a.a.a.t.a.c.g.d
    public void onADStatusChanged() {
        this.f1192a.a(this.f1193b);
    }
}
