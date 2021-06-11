package a.a.a.a.u.a.b;

import a.a.a.a.v.e;
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
public class w extends g<TTSplashAd> {

    /* loaded from: classes.dex */
    public class a implements TTAdNative.SplashAdListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1167a;

        public a(FunAdSlot funAdSlot) {
            this.f1167a = funAdSlot;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener, com.bytedance.sdk.openadsdk.a.b
        @MainThread
        public void onError(int i2, String str) {
            a.a.a.a.y.d.b("CSJSplashAd onError code: " + i2 + ", message: " + str, new Object[0]);
            w.this.f1014h.a(Integer.valueOf(i2));
            w.this.b(i2, str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener
        @MainThread
        public void onSplashAdLoad(TTSplashAd tTSplashAd) {
            a.a.a.a.y.d.a();
            w.this.f1014h.b();
            w wVar = w.this;
            wVar.a((w) tTSplashAd);
            wVar.h();
            w.this.l.b(tTSplashAd, this.f1167a.getSid());
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener
        @MainThread
        public void onTimeout() {
            a.a.a.a.y.d.b();
            w.this.f1014h.a("TimeOut");
            w.this.b(0, "Load Timeout");
        }
    }

    public w(e.a aVar) {
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
        this.f1014h.g();
        tTSplashAd.setSplashInteractionListener(new x(this, tTSplashAd, str));
        return true;
    }

    @Override // a.a.a.a.c
    public void b(Context context, FunAdSlot funAdSlot) {
        if (this.n == null) {
            this.n = TTAdSdk.getAdManager().createAdNative(context);
        }
        AdSlot j = j();
        this.f1014h.a(funAdSlot, this.f1015i);
        this.n.loadSplashAd(j, new a(funAdSlot), 5000);
        g();
    }

    @Override // a.a.a.a.c
    public void b(Object obj) {
        TTSplashAd tTSplashAd = (TTSplashAd) obj;
    }

    public AdSlot j() {
        return new AdSlot.Builder().setCodeId(this.f1015i.f1342c).setSupportDeepLink(true).setImageAcceptedSize(IdCardOcrCameraActivity.G, 1920).build();
    }
}
