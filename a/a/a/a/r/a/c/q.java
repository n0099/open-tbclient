package a.a.a.a.r.a.c;

import a.a.a.a.a.e;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.fun.ad.sdk.FunAdSlot;
/* loaded from: classes4.dex */
public class q extends e<TTRewardVideoAd> {

    /* loaded from: classes4.dex */
    public class a implements TTAdNative.RewardVideoAdListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f980a;
        public final /* synthetic */ FunAdSlot zK;

        public a(FunAdSlot funAdSlot) {
            this.zK = funAdSlot;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener, com.bytedance.sdk.openadsdk.a.b
        public void onError(int i, String str) {
            a.a.a.a.v.d.b("CSJRewardVideoAd onError code: " + i + ", message: " + str, new Object[0]);
            q.this.zk.a(Integer.valueOf(i));
            if (this.f980a) {
                return;
            }
            q.this.b(i, str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd) {
            this.f980a = true;
            a.a.a.a.v.d.a();
            q.this.zk.b();
            q qVar = q.this;
            qVar.a((q) tTRewardVideoAd);
            qVar.h();
            q.this.zm.b(tTRewardVideoAd, this.zK.getSid());
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoCached() {
            a.a.a.a.v.d.a();
            q.this.zk.c();
        }
    }

    public q(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.c
    public void a(Context context, FunAdSlot funAdSlot) {
        if (this.Ae == null) {
            this.Ae = TTAdSdk.getAdManager().createAdNative(context);
        }
        AdSlot build = new AdSlot.Builder().setCodeId(this.zl.c).setSupportDeepLink(true).setRewardName("Coin").setRewardAmount(1).setUserID(null).setOrientation(this.zl.j ? 2 : 1).setMediaExtra("media_extra").build();
        this.zk.a(funAdSlot, this.zl);
        this.Ae.loadRewardVideoAd(build, new a(funAdSlot));
        g();
    }

    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        TTRewardVideoAd tTRewardVideoAd = (TTRewardVideoAd) obj;
        this.zk.g();
        tTRewardVideoAd.setRewardAdInteractionListener(new r(this, tTRewardVideoAd, str));
        tTRewardVideoAd.setDownloadListener(new a.a.a.a.r.b.b.a(null));
        tTRewardVideoAd.showRewardVideoAd(activity);
        return true;
    }

    @Override // a.a.a.a.c
    public void b(Object obj) {
        TTRewardVideoAd tTRewardVideoAd = (TTRewardVideoAd) obj;
    }
}
