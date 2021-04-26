package a.a.a.a.t.a.e;

import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.api.KsFeedAd;
/* loaded from: classes.dex */
public class f implements KsFeedAd.AdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1251a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1252b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KsFeedAd f1253c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1254d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ View f1255e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ e f1256f;

    public f(e eVar, KsFeedAd ksFeedAd, String str, View view) {
        this.f1256f = eVar;
        this.f1253c = ksFeedAd;
        this.f1254d = str;
        this.f1255e = view;
    }

    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
    public void onAdClicked() {
        a.a.a.a.x.d.a();
        this.f1256f.f1013g.a(this.f1252b);
        this.f1252b = true;
        this.f1256f.e();
    }

    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
    public void onAdShow() {
        a.a.a.a.x.d.a();
        this.f1256f.f1013g.b(this.f1251a);
        this.f1251a = true;
        this.f1256f.a((e) this.f1253c, this.f1254d);
    }

    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
    public void onDislikeClicked() {
        a.a.a.a.x.d.a();
        this.f1256f.f1013g.h();
        View view = this.f1255e;
        if (view != null && view.getParent() != null) {
            ((ViewGroup) this.f1255e.getParent()).removeView(this.f1255e);
        }
        this.f1256f.f();
    }
}
