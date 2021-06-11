package a.a.a.a.u.a.b;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTSplashAd;
/* loaded from: classes.dex */
public class x implements TTSplashAd.AdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1169a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1170b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TTSplashAd f1171c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1172d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ w f1173e;

    public x(w wVar, TTSplashAd tTSplashAd, String str) {
        this.f1173e = wVar;
        this.f1171c = tTSplashAd;
        this.f1172d = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
    public void onAdClicked(View view, int i2) {
        a.a.a.a.y.d.a();
        this.f1173e.f1014h.a(this.f1170b);
        this.f1170b = true;
        this.f1173e.e();
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
    public void onAdShow(View view, int i2) {
        a.a.a.a.y.d.a();
        this.f1173e.f1014h.b(this.f1169a);
        this.f1169a = true;
        this.f1173e.a((w) this.f1171c, this.f1172d);
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
    public void onAdSkip() {
        a.a.a.a.y.d.a();
        this.f1173e.f1014h.h();
        this.f1173e.f();
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
    public void onAdTimeOver() {
        a.a.a.a.y.d.a();
        a.a.a.a.y.f.g.c.a(this.f1173e.f1014h.f1406a, "splash_timeover", new Object[0]);
        this.f1173e.f();
    }
}
