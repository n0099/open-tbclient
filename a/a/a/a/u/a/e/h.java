package a.a.a.a.u.a.e;

import android.view.View;
import com.kwad.sdk.api.KsNativeAd;
/* loaded from: classes.dex */
public class h implements KsNativeAd.AdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1267a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1268b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KsNativeAd f1269c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1270d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ g f1271e;

    public h(g gVar, KsNativeAd ksNativeAd, String str) {
        this.f1271e = gVar;
        this.f1269c = ksNativeAd;
        this.f1270d = str;
    }

    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
    public void onAdClicked(View view, KsNativeAd ksNativeAd) {
        a.a.a.a.y.d.a();
        this.f1271e.f1014h.a(this.f1268b);
        this.f1268b = true;
        this.f1271e.e();
    }

    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
    public void onAdShow(KsNativeAd ksNativeAd) {
        a.a.a.a.y.d.a();
        this.f1271e.f1014h.b(this.f1267a);
        this.f1267a = true;
        this.f1271e.a((g) this.f1269c, this.f1270d);
    }
}
