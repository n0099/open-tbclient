package a.a.a.a.r.a.c;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTSplashAd;
/* loaded from: classes.dex */
public class u implements TTSplashAd.AdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1157a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1158b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TTSplashAd f1159c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1160d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ t f1161e;

    public u(t tVar, TTSplashAd tTSplashAd, String str) {
        this.f1161e = tVar;
        this.f1159c = tTSplashAd;
        this.f1160d = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
    public void onAdClicked(View view, int i) {
        a.a.a.a.v.d.a();
        this.f1161e.f1010g.a(this.f1158b);
        this.f1158b = true;
        this.f1161e.e();
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
    public void onAdShow(View view, int i) {
        a.a.a.a.v.d.a();
        this.f1161e.f1010g.b(this.f1157a);
        this.f1157a = true;
        this.f1161e.a((t) this.f1159c, this.f1160d);
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
    public void onAdSkip() {
        a.a.a.a.v.d.a();
        a.a.a.a.v.f.g.c.a(this.f1161e.f1010g.f1391a, "splash_skip", new Object[0]);
        this.f1161e.f();
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
    public void onAdTimeOver() {
        a.a.a.a.v.d.a();
        a.a.a.a.v.f.g.c.a(this.f1161e.f1010g.f1391a, "splash_timeover", new Object[0]);
        this.f1161e.f();
    }
}
