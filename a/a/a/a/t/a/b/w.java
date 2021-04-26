package a.a.a.a.t.a.b;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTSplashAd;
/* loaded from: classes.dex */
public class w implements TTSplashAd.AdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1166a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1167b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TTSplashAd f1168c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1169d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ v f1170e;

    public w(v vVar, TTSplashAd tTSplashAd, String str) {
        this.f1170e = vVar;
        this.f1168c = tTSplashAd;
        this.f1169d = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
    public void onAdClicked(View view, int i2) {
        a.a.a.a.x.d.a();
        this.f1170e.f1013g.a(this.f1167b);
        this.f1167b = true;
        this.f1170e.e();
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
    public void onAdShow(View view, int i2) {
        a.a.a.a.x.d.a();
        this.f1170e.f1013g.b(this.f1166a);
        this.f1166a = true;
        this.f1170e.a((v) this.f1168c, this.f1169d);
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
    public void onAdSkip() {
        a.a.a.a.x.d.a();
        a.a.a.a.x.f.g.c.a(this.f1170e.f1013g.f1393a, "splash_skip", new Object[0]);
        this.f1170e.f();
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
    public void onAdTimeOver() {
        a.a.a.a.x.d.a();
        a.a.a.a.x.f.g.c.a(this.f1170e.f1013g.f1393a, "splash_timeover", new Object[0]);
        this.f1170e.f();
    }
}
