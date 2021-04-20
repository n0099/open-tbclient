package a.a.a.a.r.a.e;

import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.api.KsFeedAd;
/* loaded from: classes.dex */
public class f implements KsFeedAd.AdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1232a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1233b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KsFeedAd f1234c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1235d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ View f1236e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ e f1237f;

    public f(e eVar, KsFeedAd ksFeedAd, String str, View view) {
        this.f1237f = eVar;
        this.f1234c = ksFeedAd;
        this.f1235d = str;
        this.f1236e = view;
    }

    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
    public void onAdClicked() {
        a.a.a.a.v.d.a();
        this.f1237f.f1010g.a(this.f1233b);
        this.f1233b = true;
        this.f1237f.e();
    }

    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
    public void onAdShow() {
        a.a.a.a.v.d.a();
        this.f1237f.f1010g.b(this.f1232a);
        this.f1232a = true;
        this.f1237f.a((e) this.f1234c, this.f1235d);
    }

    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
    public void onDislikeClicked() {
        a.a.a.a.v.d.a();
        this.f1237f.f1010g.h();
        View view = this.f1236e;
        if (view != null && view.getParent() != null) {
            ((ViewGroup) this.f1236e.getParent()).removeView(this.f1236e);
        }
        this.f1237f.f();
    }
}
