package a.a.a.a.r.a.c;

import a.a.a.a.s.e;
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
/* loaded from: classes.dex */
public class t extends e<TTSplashAd> {

    /* loaded from: classes.dex */
    public class a implements TTAdNative.SplashAdListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1155a;

        public a(FunAdSlot funAdSlot) {
            this.f1155a = funAdSlot;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener, com.bytedance.sdk.openadsdk.a.b
        @MainThread
        public void onError(int i, String str) {
            a.a.a.a.v.d.b("CSJSplashAd onError code: " + i + ", message: " + str, new Object[0]);
            t.this.f1010g.a(Integer.valueOf(i));
            t.this.b(i, str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener
        @MainThread
        public void onSplashAdLoad(TTSplashAd tTSplashAd) {
            a.a.a.a.v.d.a();
            t.this.f1010g.b();
            t tVar = t.this;
            tVar.a((t) tTSplashAd);
            tVar.h();
            t.this.k.b(tTSplashAd, this.f1155a.getSid());
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener
        @MainThread
        public void onTimeout() {
            a.a.a.a.v.d.b();
            t.this.f1010g.a("TimeOut");
            t.this.b(0, "Load Timeout");
        }
    }

    public t(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.b
    public boolean a(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        TTSplashAd tTSplashAd = (TTSplashAd) obj;
        View splashView = tTSplashAd.getSplashView();
        if (splashView.getParent() != null) {
            ((ViewGroup) splashView.getParent()).removeView(splashView);
        }
        viewGroup.removeAllViews();
        viewGroup.addView(splashView);
        this.f1010g.g();
        tTSplashAd.setSplashInteractionListener(new u(this, tTSplashAd, str));
        return true;
    }

    @Override // a.a.a.a.b
    public void b(Context context, FunAdSlot funAdSlot) {
        if (this.m == null) {
            this.m = TTAdSdk.getAdManager().createAdNative(context);
        }
        AdSlot j = j();
        this.f1010g.a(funAdSlot, this.f1011h);
        this.m.loadSplashAd(j, new a(funAdSlot), 5000);
        g();
    }

    @Override // a.a.a.a.b
    public void b(Object obj) {
        TTSplashAd tTSplashAd = (TTSplashAd) obj;
    }

    public AdSlot j() {
        return new AdSlot.Builder().setCodeId(this.f1011h.f1334c).setSupportDeepLink(true).setImageAcceptedSize(1080, WBConstants.SDK_NEW_PAY_VERSION).build();
    }
}
