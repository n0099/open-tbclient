package a.a.a.a.r.a.b;

import a.a.a.a.s.e;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.fun.ad.sdk.FunAdSlot;
/* loaded from: classes.dex */
public class q extends e<TTRewardVideoAd> {

    /* loaded from: classes.dex */
    public class a implements TTAdNative.RewardVideoAdListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1139a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1140b;

        public a(FunAdSlot funAdSlot) {
            this.f1140b = funAdSlot;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener, com.bytedance.sdk.openadsdk.a.b
        public void onError(int i, String str) {
            a.a.a.a.v.d.b("CSJRewardVideoAd onError code: " + i + ", message: " + str, new Object[0]);
            q.this.f1010g.a(Integer.valueOf(i));
            if (this.f1139a) {
                return;
            }
            q.this.b(i, str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd) {
            this.f1139a = true;
            a.a.a.a.v.d.a();
            q.this.f1010g.b();
            q qVar = q.this;
            qVar.a((q) tTRewardVideoAd);
            qVar.h();
            q.this.k.b(tTRewardVideoAd, this.f1140b.getSid());
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoCached() {
            a.a.a.a.v.d.a();
            q.this.f1010g.c();
        }
    }

    public q(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.b
    public boolean a(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        TTRewardVideoAd tTRewardVideoAd = (TTRewardVideoAd) obj;
        this.f1010g.g();
        tTRewardVideoAd.setRewardAdInteractionListener(new r(this, tTRewardVideoAd, str));
        tTRewardVideoAd.setDownloadListener(new a.a.a.a.r.b.a.a(null));
        tTRewardVideoAd.showRewardVideoAd(activity);
        return true;
    }

    @Override // a.a.a.a.b
    public void b(Context context, FunAdSlot funAdSlot) {
        if (this.m == null) {
            this.m = TTAdSdk.getAdManager().createAdNative(context);
        }
        AdSlot build = new AdSlot.Builder().setCodeId(this.f1011h.f1320c).setSupportDeepLink(true).setRewardName("Coin").setRewardAmount(1).setUserID(null).setOrientation(this.f1011h.j ? 2 : 1).setMediaExtra("media_extra").build();
        this.f1010g.a(funAdSlot, this.f1011h);
        this.m.loadRewardVideoAd(build, new a(funAdSlot));
        g();
    }

    @Override // a.a.a.a.b
    public void b(Object obj) {
        TTRewardVideoAd tTRewardVideoAd = (TTRewardVideoAd) obj;
    }
}
