package a.a.a.a.t.a.b;

import a.a.a.a.u.e;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.fun.ad.sdk.FunAdSlot;
/* loaded from: classes.dex */
public class s extends g<TTRewardVideoAd> {

    /* loaded from: classes.dex */
    public class a implements TTAdNative.RewardVideoAdListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1156a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1157b;

        public a(FunAdSlot funAdSlot) {
            this.f1157b = funAdSlot;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener, com.bytedance.sdk.openadsdk.a.b
        public void onError(int i2, String str) {
            a.a.a.a.x.d.b("CSJRewardVideoAd onError code: " + i2 + ", message: " + str, new Object[0]);
            s.this.f1013g.a(Integer.valueOf(i2));
            if (this.f1156a) {
                return;
            }
            s.this.b(i2, str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd) {
            this.f1156a = true;
            a.a.a.a.x.d.a();
            s.this.f1013g.b();
            s sVar = s.this;
            sVar.a((s) tTRewardVideoAd);
            sVar.h();
            s.this.k.b(tTRewardVideoAd, this.f1157b.getSid());
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoCached() {
            a.a.a.a.x.d.a();
            s.this.f1013g.c();
        }
    }

    public s(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        TTRewardVideoAd tTRewardVideoAd = (TTRewardVideoAd) obj;
        this.f1013g.g();
        tTRewardVideoAd.setRewardAdInteractionListener(new t(this, tTRewardVideoAd, str));
        tTRewardVideoAd.setDownloadListener(new a.a.a.a.t.b.a.a(null));
        tTRewardVideoAd.showRewardVideoAd(activity);
        return true;
    }

    @Override // a.a.a.a.c
    public void b(Context context, FunAdSlot funAdSlot) {
        if (this.m == null) {
            this.m = TTAdSdk.getAdManager().createAdNative(context);
        }
        AdSlot build = new AdSlot.Builder().setCodeId(this.f1014h.f1334c).setSupportDeepLink(true).setRewardName("Coin").setRewardAmount(1).setUserID(null).setOrientation(this.f1014h.j ? 2 : 1).setMediaExtra("media_extra").build();
        this.f1013g.a(funAdSlot, this.f1014h);
        this.m.loadRewardVideoAd(build, new a(funAdSlot));
        g();
    }

    @Override // a.a.a.a.c
    public void b(Object obj) {
        TTRewardVideoAd tTRewardVideoAd = (TTRewardVideoAd) obj;
    }
}
