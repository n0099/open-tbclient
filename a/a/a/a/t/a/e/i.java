package a.a.a.a.t.a.e;

import android.content.DialogInterface;
import android.view.View;
import com.kwad.sdk.api.KsNativeAd;
/* loaded from: classes.dex */
public class i implements KsNativeAd.AdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ KsNativeAd f1264a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f1265b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ g f1266c;

    public i(g gVar, KsNativeAd ksNativeAd, String str) {
        this.f1266c = gVar;
        this.f1264a = ksNativeAd;
        this.f1265b = str;
    }

    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
    public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
        return false;
    }

    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
    public void onAdClicked(View view, KsNativeAd ksNativeAd) {
        this.f1266c.m.b(this.f1264a);
        this.f1266c.e();
    }

    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
    public void onAdShow(KsNativeAd ksNativeAd) {
        this.f1266c.m.c(this.f1264a);
        this.f1266c.a((g) this.f1264a, this.f1265b);
    }
}
