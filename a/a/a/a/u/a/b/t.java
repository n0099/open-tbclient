package a.a.a.a.u.a.b;

import a.a.a.a.v.e;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.fun.ad.sdk.FunAdSlot;
/* loaded from: classes.dex */
public class t extends g<TTRewardVideoAd> {

    /* loaded from: classes.dex */
    public class a implements TTAdNative.RewardVideoAdListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1159a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1160b;

        public a(FunAdSlot funAdSlot) {
            this.f1160b = funAdSlot;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener, com.bytedance.sdk.openadsdk.a.b
        public void onError(int i2, String str) {
            a.a.a.a.y.d.b("CSJRewardVideoAd onError code: " + i2 + ", message: " + str, new Object[0]);
            t.this.f1014h.a(Integer.valueOf(i2));
            if (this.f1159a) {
                return;
            }
            t.this.b(i2, str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd) {
            this.f1159a = true;
            a.a.a.a.y.d.a();
            t.this.f1014h.b();
            t tVar = t.this;
            tVar.a((t) tTRewardVideoAd);
            tVar.h();
            t.this.l.b(tTRewardVideoAd, this.f1160b.getSid());
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoCached() {
            a.a.a.a.y.d.a();
            t.this.f1014h.c();
        }
    }

    public t(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        TTRewardVideoAd tTRewardVideoAd = (TTRewardVideoAd) obj;
        this.f1014h.g();
        tTRewardVideoAd.setRewardAdInteractionListener(new u(this, tTRewardVideoAd, str));
        tTRewardVideoAd.setDownloadListener(new a.a.a.a.u.b.a.a(null));
        tTRewardVideoAd.showRewardVideoAd(activity);
        return true;
    }

    @Override // a.a.a.a.c
    public void b(Context context, FunAdSlot funAdSlot) {
        if (this.n == null) {
            this.n = TTAdSdk.getAdManager().createAdNative(context);
        }
        AdSlot build = new AdSlot.Builder().setCodeId(this.f1015i.f1342c).setSupportDeepLink(true).setRewardName("Coin").setRewardAmount(1).setUserID(null).setOrientation(this.f1015i.j ? 2 : 1).setMediaExtra("media_extra").build();
        this.f1014h.a(funAdSlot, this.f1015i);
        this.n.loadRewardVideoAd(build, new a(funAdSlot));
        g();
    }

    @Override // a.a.a.a.c
    public void b(Object obj) {
        TTRewardVideoAd tTRewardVideoAd = (TTRewardVideoAd) obj;
    }
}
