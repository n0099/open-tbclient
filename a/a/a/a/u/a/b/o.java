package a.a.a.a.u.a.b;

import a.a.a.a.v.e;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
/* loaded from: classes.dex */
public class o extends k {
    public o(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.u.a.b.k
    public AdSlot a(FunAdSlot funAdSlot) {
        int expressWidth = funAdSlot.getExpressWidth();
        int expressHeight = funAdSlot.getExpressHeight();
        if (expressWidth == 0 && expressHeight == 0 && FunAdSdk.isLogEnabled()) {
            throw new RuntimeException("Invalid expressWidth and expressHeight.");
        }
        return new AdSlot.Builder().setCodeId(this.f1015i.f1342c).setSupportDeepLink(true).setExpressViewAcceptedSize(expressWidth, expressHeight).setOrientation(this.f1015i.j ? 2 : 1).build();
    }
}
