package a.a.a.a.t.a.c;

import com.fun.ad.sdk.ChannelNativeAds_6;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.util.AdError;
/* loaded from: classes.dex */
public class k implements NativeADEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NativeUnifiedADData f1196a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f1197b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ChannelNativeAds_6.GdtADStatusChangeListener f1198c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ g f1199d;

    public k(g gVar, NativeUnifiedADData nativeUnifiedADData, String str, ChannelNativeAds_6.GdtADStatusChangeListener gdtADStatusChangeListener) {
        this.f1199d = gVar;
        this.f1196a = nativeUnifiedADData;
        this.f1197b = str;
        this.f1198c = gdtADStatusChangeListener;
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADClicked() {
        this.f1199d.m.b(this.f1196a);
        this.f1199d.e();
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADError(AdError adError) {
        this.f1199d.f1013g.b(Integer.valueOf(adError.getErrorCode()));
        this.f1199d.a(adError.getErrorCode(), adError.getErrorMsg());
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADExposed() {
        this.f1199d.m.c(this.f1196a);
        this.f1199d.a((g) this.f1196a, this.f1197b);
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADStatusChanged() {
        ChannelNativeAds_6.GdtADStatusChangeListener gdtADStatusChangeListener = this.f1198c;
        if (gdtADStatusChangeListener != null) {
            gdtADStatusChangeListener.onADStatusChanged(this.f1196a);
        }
    }
}
