package a.a.a.a.r.a.d;

import a.a.a.a.r.a.d.g;
import com.qq.e.ads.nativ.NativeUnifiedADData;
/* loaded from: classes4.dex */
public class i implements g.d {
    public final /* synthetic */ a.a.a.a.r.b.c.b AJ;
    public final /* synthetic */ NativeUnifiedADData AK;

    public i(g gVar, a.a.a.a.r.b.c.b bVar, NativeUnifiedADData nativeUnifiedADData) {
        this.AJ = bVar;
        this.AK = nativeUnifiedADData;
    }

    @Override // a.a.a.a.r.a.d.g.d
    public void onADStatusChanged() {
        this.AJ.a(this.AK);
    }
}
