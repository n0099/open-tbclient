package a.a.a.a.u.a.e;

import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.api.KsFeedAd;
/* loaded from: classes.dex */
public class f implements KsFeedAd.AdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1259a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1260b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KsFeedAd f1261c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1262d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ View f1263e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ e f1264f;

    public f(e eVar, KsFeedAd ksFeedAd, String str, View view) {
        this.f1264f = eVar;
        this.f1261c = ksFeedAd;
        this.f1262d = str;
        this.f1263e = view;
    }

    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
    public void onAdClicked() {
        a.a.a.a.y.d.a();
        this.f1264f.f1014h.a(this.f1260b);
        this.f1260b = true;
        this.f1264f.e();
    }

    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
    public void onAdShow() {
        a.a.a.a.y.d.a();
        this.f1264f.f1014h.b(this.f1259a);
        this.f1259a = true;
        this.f1264f.a((e) this.f1261c, this.f1262d);
    }

    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
    public void onDislikeClicked() {
        a.a.a.a.y.d.a();
        this.f1264f.f1014h.i();
        View view = this.f1263e;
        if (view != null && view.getParent() != null) {
            ((ViewGroup) this.f1263e.getParent()).removeView(this.f1263e);
        }
        this.f1264f.f();
    }
}
