package a.a.a.a.r.a.b;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTSplashAd;
/* loaded from: classes.dex */
public class u implements TTSplashAd.AdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1149a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1150b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TTSplashAd f1151c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1152d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ t f1153e;

    public u(t tVar, TTSplashAd tTSplashAd, String str) {
        this.f1153e = tVar;
        this.f1151c = tTSplashAd;
        this.f1152d = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
    public void onAdClicked(View view, int i) {
        a.a.a.a.v.d.a();
        this.f1153e.f1010g.a(this.f1150b);
        this.f1150b = true;
        this.f1153e.e();
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
    public void onAdShow(View view, int i) {
        a.a.a.a.v.d.a();
        this.f1153e.f1010g.b(this.f1149a);
        this.f1149a = true;
        this.f1153e.a((t) this.f1151c, this.f1152d);
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
    public void onAdSkip() {
        a.a.a.a.v.d.a();
        a.a.a.a.v.f.g.c.a(this.f1153e.f1010g.f1377a, "splash_skip", new Object[0]);
        this.f1153e.f();
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
    public void onAdTimeOver() {
        a.a.a.a.v.d.a();
        a.a.a.a.v.f.g.c.a(this.f1153e.f1010g.f1377a, "splash_timeover", new Object[0]);
        this.f1153e.f();
    }
}
