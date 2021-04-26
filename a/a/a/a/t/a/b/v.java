package a.a.a.a.t.a.b;

import a.a.a.a.u.e;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.MainThread;
import com.baidu.sapi2.activity.IdCardOcrCameraActivity;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.fun.ad.sdk.FunAdSlot;
/* loaded from: classes.dex */
public class v extends g<TTSplashAd> {

    /* loaded from: classes.dex */
    public class a implements TTAdNative.SplashAdListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1164a;

        public a(FunAdSlot funAdSlot) {
            this.f1164a = funAdSlot;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener, com.bytedance.sdk.openadsdk.a.b
        @MainThread
        public void onError(int i2, String str) {
            a.a.a.a.x.d.b("CSJSplashAd onError code: " + i2 + ", message: " + str, new Object[0]);
            v.this.f1013g.a(Integer.valueOf(i2));
            v.this.b(i2, str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener
        @MainThread
        public void onSplashAdLoad(TTSplashAd tTSplashAd) {
            a.a.a.a.x.d.a();
            v.this.f1013g.b();
            v vVar = v.this;
            vVar.a((v) tTSplashAd);
            vVar.h();
            v.this.k.b(tTSplashAd, this.f1164a.getSid());
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener
        @MainThread
        public void onTimeout() {
            a.a.a.a.x.d.b();
            v.this.f1013g.a("TimeOut");
            v.this.b(0, "Load Timeout");
        }
    }

    public v(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        TTSplashAd tTSplashAd = (TTSplashAd) obj;
        View splashView = tTSplashAd.getSplashView();
        if (splashView.getParent() != null) {
            ((ViewGroup) splashView.getParent()).removeView(splashView);
        }
        viewGroup.removeAllViews();
        viewGroup.addView(splashView);
        this.f1013g.g();
        tTSplashAd.setSplashInteractionListener(new w(this, tTSplashAd, str));
        return true;
    }

    @Override // a.a.a.a.c
    public void b(Context context, FunAdSlot funAdSlot) {
        if (this.m == null) {
            this.m = TTAdSdk.getAdManager().createAdNative(context);
        }
        AdSlot j = j();
        this.f1013g.a(funAdSlot, this.f1014h);
        this.m.loadSplashAd(j, new a(funAdSlot), 5000);
        g();
    }

    @Override // a.a.a.a.c
    public void b(Object obj) {
        TTSplashAd tTSplashAd = (TTSplashAd) obj;
    }

    public AdSlot j() {
        return new AdSlot.Builder().setCodeId(this.f1014h.f1334c).setSupportDeepLink(true).setImageAcceptedSize(IdCardOcrCameraActivity.G, 1920).build();
    }
}
