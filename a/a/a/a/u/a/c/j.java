package a.a.a.a.u.a.c;

import a.a.a.a.u.a.c.g;
import com.fun.ad.sdk.ChannelNativeAds_6;
import com.fun.ad.sdk.FunNativeAd;
import com.qq.e.ads.nativ.NativeUnifiedADData;
/* loaded from: classes.dex */
public class j implements g.d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FunNativeAd f1197a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NativeUnifiedADData f1198b;

    public j(g gVar, FunNativeAd funNativeAd, NativeUnifiedADData nativeUnifiedADData) {
        this.f1197a = funNativeAd;
        this.f1198b = nativeUnifiedADData;
    }

    @Override // a.a.a.a.u.a.c.g.d
    public void onADStatusChanged() {
        ChannelNativeAds_6.GdtADStatusChangeListener gdtADStatusChangeListener = this.f1197a.getChannelNativeAds_6().getGdtADStatusChangeListener();
        if (gdtADStatusChangeListener != null) {
            gdtADStatusChangeListener.onADStatusChanged(this.f1198b);
        }
    }
}
