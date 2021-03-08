package a.a.a.a.r.a.c;

import a.a.a.a.a.e;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.MainThread;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.fun.ad.sdk.FunAdSlot;
import com.sina.weibo.sdk.constant.WBConstants;
/* loaded from: classes4.dex */
public class t extends e<TTSplashAd> {

    /* loaded from: classes4.dex */
    public class a implements TTAdNative.SplashAdListener {
        public final /* synthetic */ FunAdSlot zR;

        public a(FunAdSlot funAdSlot) {
            this.zR = funAdSlot;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener, com.bytedance.sdk.openadsdk.a.b
        @MainThread
        public void onError(int i, String str) {
            a.a.a.a.v.d.b("CSJSplashAd onError code: " + i + ", message: " + str, new Object[0]);
            t.this.zk.a(Integer.valueOf(i));
            t.this.b(i, str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener
        @MainThread
        public void onSplashAdLoad(TTSplashAd tTSplashAd) {
            a.a.a.a.v.d.a();
            t.this.zk.b();
            t tVar = t.this;
            tVar.a((t) tTSplashAd);
            tVar.h();
            t.this.zm.b(tTSplashAd, this.zR.getSid());
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener
        @MainThread
        public void onTimeout() {
            a.a.a.a.v.d.b();
            t.this.zk.a("TimeOut");
            t.this.b(0, "Load Timeout");
        }
    }

    public t(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.c
    public void a(Context context, FunAdSlot funAdSlot) {
        if (this.Ae == null) {
            this.Ae = TTAdSdk.getAdManager().createAdNative(context);
        }
        AdSlot hs = hs();
        this.zk.a(funAdSlot, this.zl);
        this.Ae.loadSplashAd(hs, new a(funAdSlot), 5000);
        g();
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
        this.zk.g();
        tTSplashAd.setSplashInteractionListener(new u(this, tTSplashAd, str));
        return true;
    }

    @Override // a.a.a.a.c
    public void b(Object obj) {
        TTSplashAd tTSplashAd = (TTSplashAd) obj;
    }

    public AdSlot hs() {
        return new AdSlot.Builder().setCodeId(this.zl.c).setSupportDeepLink(true).setImageAcceptedSize(1080, WBConstants.SDK_NEW_PAY_VERSION).build();
    }
}
