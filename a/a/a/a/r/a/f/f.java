package a.a.a.a.r.a.f;

import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.api.KsFeedAd;
/* loaded from: classes4.dex */
public class f implements KsFeedAd.AdInteractionListener {
    public final /* synthetic */ KsFeedAd Bl;
    public final /* synthetic */ e Bm;

    /* renamed from: a  reason: collision with root package name */
    public boolean f996a;
    public boolean b;
    public final /* synthetic */ String d;
    public final /* synthetic */ View e;

    public f(e eVar, KsFeedAd ksFeedAd, String str, View view) {
        this.Bm = eVar;
        this.Bl = ksFeedAd;
        this.d = str;
        this.e = view;
    }

    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
    public void onAdClicked() {
        a.a.a.a.v.d.a();
        this.Bm.zk.a(this.b);
        this.b = true;
        this.Bm.e();
    }

    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
    public void onAdShow() {
        a.a.a.a.v.d.a();
        this.Bm.zk.b(this.f996a);
        this.f996a = true;
        this.Bm.a((e) this.Bl, this.d);
    }

    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
    public void onDislikeClicked() {
        a.a.a.a.v.d.a();
        this.Bm.zk.h();
        View view = this.e;
        if (view != null && view.getParent() != null) {
            ((ViewGroup) this.e.getParent()).removeView(this.e);
        }
        this.Bm.f();
    }
}
