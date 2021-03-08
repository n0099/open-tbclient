package a.a.a.a.r.a.d;

import a.a.a.a.r.a.d.g;
import com.fun.ad.sdk.ChannelNativeAds_5;
import com.fun.ad.sdk.FunNativeAd;
import com.qq.e.ads.nativ.NativeUnifiedADData;
/* loaded from: classes4.dex */
public class j implements g.d {
    public final /* synthetic */ NativeUnifiedADData AK;
    public final /* synthetic */ FunNativeAd AM;

    public j(g gVar, FunNativeAd funNativeAd, NativeUnifiedADData nativeUnifiedADData) {
        this.AM = funNativeAd;
        this.AK = nativeUnifiedADData;
    }

    @Override // a.a.a.a.r.a.d.g.d
    public void onADStatusChanged() {
        ChannelNativeAds_5.GdtADStatusChangeListener gdtADStatusChangeListener = this.AM.getChannelNativeAds_5().getGdtADStatusChangeListener();
        if (gdtADStatusChangeListener != null) {
            gdtADStatusChangeListener.onADStatusChanged(this.AK);
        }
    }
}
