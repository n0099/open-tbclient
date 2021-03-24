package a.a.a.a.r.a.d;

import a.a.a.a.r.a.d.g;
import com.fun.ad.sdk.ChannelNativeAds_5;
import com.qq.e.ads.nativ.NativeUnifiedADData;
/* loaded from: classes.dex */
public class k implements g.d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ChannelNativeAds_5.GdtADStatusChangeListener f1188a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NativeUnifiedADData f1189b;

    public k(g gVar, ChannelNativeAds_5.GdtADStatusChangeListener gdtADStatusChangeListener, NativeUnifiedADData nativeUnifiedADData) {
        this.f1188a = gdtADStatusChangeListener;
        this.f1189b = nativeUnifiedADData;
    }

    @Override // a.a.a.a.r.a.d.g.d
    public void onADStatusChanged() {
        ChannelNativeAds_5.GdtADStatusChangeListener gdtADStatusChangeListener = this.f1188a;
        if (gdtADStatusChangeListener != null) {
            gdtADStatusChangeListener.onADStatusChanged(this.f1189b);
        }
    }
}
