package a.a.a.a.t.a.c;

import a.a.a.a.t.a.c.g;
import com.fun.ad.sdk.ChannelNativeAds_6;
import com.fun.ad.sdk.FunNativeAd;
import com.qq.e.ads.nativ.NativeUnifiedADData;
/* loaded from: classes.dex */
public class j implements g.d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FunNativeAd f1194a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NativeUnifiedADData f1195b;

    public j(g gVar, FunNativeAd funNativeAd, NativeUnifiedADData nativeUnifiedADData) {
        this.f1194a = funNativeAd;
        this.f1195b = nativeUnifiedADData;
    }

    @Override // a.a.a.a.t.a.c.g.d
    public void onADStatusChanged() {
        ChannelNativeAds_6.GdtADStatusChangeListener gdtADStatusChangeListener = this.f1194a.getChannelNativeAds_6().getGdtADStatusChangeListener();
        if (gdtADStatusChangeListener != null) {
            gdtADStatusChangeListener.onADStatusChanged(this.f1195b);
        }
    }
}
