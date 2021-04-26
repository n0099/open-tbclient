package a.a.a.a.t.a.e;

import android.content.DialogInterface;
import android.view.View;
import com.kwad.sdk.api.KsNativeAd;
/* loaded from: classes.dex */
public class h implements KsNativeAd.AdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1259a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1260b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KsNativeAd f1261c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1262d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ g f1263e;

    public h(g gVar, KsNativeAd ksNativeAd, String str) {
        this.f1263e = gVar;
        this.f1261c = ksNativeAd;
        this.f1262d = str;
    }

    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
    public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
        return false;
    }

    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
    public void onAdClicked(View view, KsNativeAd ksNativeAd) {
        a.a.a.a.x.d.a();
        this.f1263e.f1013g.a(this.f1260b);
        this.f1260b = true;
        this.f1263e.e();
    }

    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
    public void onAdShow(KsNativeAd ksNativeAd) {
        a.a.a.a.x.d.a();
        this.f1263e.f1013g.b(this.f1259a);
        this.f1259a = true;
        this.f1263e.a((g) this.f1261c, this.f1262d);
    }
}
