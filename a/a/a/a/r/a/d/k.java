package a.a.a.a.r.a.d;

import a.a.a.a.r.a.d.g;
import com.fun.ad.sdk.ChannelNativeAds_5;
import com.qq.e.ads.nativ.NativeUnifiedADData;
/* loaded from: classes4.dex */
public class k implements g.d {
    public final /* synthetic */ NativeUnifiedADData AK;
    public final /* synthetic */ ChannelNativeAds_5.GdtADStatusChangeListener AN;

    public k(g gVar, ChannelNativeAds_5.GdtADStatusChangeListener gdtADStatusChangeListener, NativeUnifiedADData nativeUnifiedADData) {
        this.AN = gdtADStatusChangeListener;
        this.AK = nativeUnifiedADData;
    }

    @Override // a.a.a.a.r.a.d.g.d
    public void onADStatusChanged() {
        ChannelNativeAds_5.GdtADStatusChangeListener gdtADStatusChangeListener = this.AN;
        if (gdtADStatusChangeListener != null) {
            gdtADStatusChangeListener.onADStatusChanged(this.AK);
        }
    }
}
