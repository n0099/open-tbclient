package a.a.a.a.u.a.c;

import com.fun.ad.sdk.ChannelNativeAds_6;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.util.AdError;
/* loaded from: classes.dex */
public class k implements NativeADEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NativeUnifiedADData f1199a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f1200b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ChannelNativeAds_6.GdtADStatusChangeListener f1201c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ g f1202d;

    public k(g gVar, NativeUnifiedADData nativeUnifiedADData, String str, ChannelNativeAds_6.GdtADStatusChangeListener gdtADStatusChangeListener) {
        this.f1202d = gVar;
        this.f1199a = nativeUnifiedADData;
        this.f1200b = str;
        this.f1201c = gdtADStatusChangeListener;
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADClicked() {
        this.f1202d.n.b(this.f1199a);
        this.f1202d.e();
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADError(AdError adError) {
        this.f1202d.f1014h.b(Integer.valueOf(adError.getErrorCode()));
        this.f1202d.a(adError.getErrorCode(), adError.getErrorMsg());
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADExposed() {
        this.f1202d.n.c(this.f1199a);
        this.f1202d.a((g) this.f1199a, this.f1200b);
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADStatusChanged() {
        ChannelNativeAds_6.GdtADStatusChangeListener gdtADStatusChangeListener = this.f1201c;
        if (gdtADStatusChangeListener != null) {
            gdtADStatusChangeListener.onADStatusChanged(this.f1199a);
        }
    }
}
