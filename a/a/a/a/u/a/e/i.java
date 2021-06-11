package a.a.a.a.u.a.e;

import android.view.View;
import com.kwad.sdk.api.KsNativeAd;
/* loaded from: classes.dex */
public class i implements KsNativeAd.AdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ KsNativeAd f1272a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f1273b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ g f1274c;

    public i(g gVar, KsNativeAd ksNativeAd, String str) {
        this.f1274c = gVar;
        this.f1272a = ksNativeAd;
        this.f1273b = str;
    }

    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
    public void onAdClicked(View view, KsNativeAd ksNativeAd) {
        this.f1274c.n.b(this.f1272a);
        this.f1274c.e();
    }

    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
    public void onAdShow(KsNativeAd ksNativeAd) {
        this.f1274c.n.c(this.f1272a);
        this.f1274c.a((g) this.f1272a, this.f1273b);
    }
}
