package a.a.a.a.r.a.f;

import a.a.a.a.a.e;
import a.a.a.a.c.m;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.fun.ad.sdk.FunAdSlot;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import java.util.List;
/* loaded from: classes4.dex */
public class h extends a.a.a.a.c<KsRewardVideoAd> {
    public h(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.c
    public a.a.a.a.c.a a(e.a aVar) {
        return new m(aVar);
    }

    @Override // a.a.a.a.c
    public void a(Context context, FunAdSlot funAdSlot) {
        KsScene build = new KsScene.Builder(Long.parseLong(this.zl.c)).adNum(1).build();
        this.zk.a(funAdSlot, this.zl);
        KsAdSDK.getLoadManager().loadRewardVideoAd(build, new a(funAdSlot));
        g();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, KsRewardVideoAd ksRewardVideoAd) {
        KsRewardVideoAd ksRewardVideoAd2 = ksRewardVideoAd;
        if (!ksRewardVideoAd2.isAdEnable()) {
            a.a.a.a.v.d.b("Ad isn't ready now", new Object[0]);
            a(0, "F:ad disable");
            return false;
        }
        this.zk.g();
        ksRewardVideoAd2.setRewardAdInteractionListener(new i(this, ksRewardVideoAd2, str));
        ksRewardVideoAd2.showRewardVideoAd(activity, this.zl.j ? new KsVideoPlayConfig.Builder().showLandscape(true).build() : null);
        return true;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.c
    public void b(KsRewardVideoAd ksRewardVideoAd) {
    }

    /* loaded from: classes4.dex */
    public class a implements KsLoadManager.RewardVideoAdListener {
        public final /* synthetic */ FunAdSlot zR;

        public a(FunAdSlot funAdSlot) {
            this.zR = funAdSlot;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public void onError(int i, String str) {
            a.a.a.a.v.d.b("onError code: " + i + ", message: " + str, new Object[0]);
            h.this.zk.a(Integer.valueOf(i));
            h.this.b(i, str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public void onRewardVideoAdLoad(@Nullable List<KsRewardVideoAd> list) {
            a.a.a.a.v.d.a();
            if (list != null && !list.isEmpty()) {
                h.this.zk.b();
                KsRewardVideoAd ksRewardVideoAd = list.get(0);
                h hVar = h.this;
                hVar.a((h) ksRewardVideoAd);
                hVar.h();
                h.this.zm.b(ksRewardVideoAd, this.zR.getSid());
                return;
            }
            a.a.a.a.v.d.b("onNativeAdLoad error: adList is null or empty", new Object[0]);
            h.this.zk.a("NoFill");
            onError(0, "No Fill");
        }
    }
}
