package a.a.a.a.r.a.c;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTSplashAd;
/* loaded from: classes4.dex */
public class u implements TTSplashAd.AdInteractionListener {
    public final /* synthetic */ TTSplashAd Aw;
    public final /* synthetic */ t Ax;

    /* renamed from: a  reason: collision with root package name */
    public boolean f982a;
    public boolean b;
    public final /* synthetic */ String d;

    public u(t tVar, TTSplashAd tTSplashAd, String str) {
        this.Ax = tVar;
        this.Aw = tTSplashAd;
        this.d = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
    public void onAdClicked(View view, int i) {
        a.a.a.a.v.d.a();
        this.Ax.zk.a(this.b);
        this.b = true;
        this.Ax.e();
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
    public void onAdShow(View view, int i) {
        a.a.a.a.v.d.a();
        this.Ax.zk.b(this.f982a);
        this.f982a = true;
        this.Ax.a((t) this.Aw, this.d);
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
    public void onAdSkip() {
        a.a.a.a.v.d.a();
        a.a.a.a.v.f.g.c.a(this.Ax.zk.BU, "splash_skip", new Object[0]);
        this.Ax.f();
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
    public void onAdTimeOver() {
        a.a.a.a.v.d.a();
        a.a.a.a.v.f.g.c.a(this.Ax.zk.BU, "splash_timeover", new Object[0]);
        this.Ax.f();
    }
}
