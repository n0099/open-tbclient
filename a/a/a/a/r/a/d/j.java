package a.a.a.a.r.a.d;

import a.a.a.a.r.a.d.g;
import com.fun.ad.sdk.ChannelNativeAds_5;
import com.fun.ad.sdk.FunNativeAd;
import com.qq.e.ads.nativ.NativeUnifiedADData;
/* loaded from: classes.dex */
public class j implements g.d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FunNativeAd f1186a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NativeUnifiedADData f1187b;

    public j(g gVar, FunNativeAd funNativeAd, NativeUnifiedADData nativeUnifiedADData) {
        this.f1186a = funNativeAd;
        this.f1187b = nativeUnifiedADData;
    }

    @Override // a.a.a.a.r.a.d.g.d
    public void onADStatusChanged() {
        ChannelNativeAds_5.GdtADStatusChangeListener gdtADStatusChangeListener = this.f1186a.getChannelNativeAds_5().getGdtADStatusChangeListener();
        if (gdtADStatusChangeListener != null) {
            gdtADStatusChangeListener.onADStatusChanged(this.f1187b);
        }
    }
}
