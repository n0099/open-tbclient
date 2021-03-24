package a.a.a.a.r.a.f;

import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.api.KsFeedAd;
/* loaded from: classes.dex */
public class f implements KsFeedAd.AdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1240a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1241b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KsFeedAd f1242c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1243d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ View f1244e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ e f1245f;

    public f(e eVar, KsFeedAd ksFeedAd, String str, View view) {
        this.f1245f = eVar;
        this.f1242c = ksFeedAd;
        this.f1243d = str;
        this.f1244e = view;
    }

    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
    public void onAdClicked() {
        a.a.a.a.v.d.a();
        this.f1245f.f1010g.a(this.f1241b);
        this.f1241b = true;
        this.f1245f.e();
    }

    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
    public void onAdShow() {
        a.a.a.a.v.d.a();
        this.f1245f.f1010g.b(this.f1240a);
        this.f1240a = true;
        this.f1245f.a((e) this.f1242c, this.f1243d);
    }

    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
    public void onDislikeClicked() {
        a.a.a.a.v.d.a();
        this.f1245f.f1010g.h();
        View view = this.f1244e;
        if (view != null && view.getParent() != null) {
            ((ViewGroup) this.f1244e.getParent()).removeView(this.f1244e);
        }
        this.f1245f.f();
    }
}
