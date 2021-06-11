package a.a.a.a.u.a.e;

import a.a.a.a.v.e;
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
/* loaded from: classes.dex */
public class j extends a.a.a.a.c<KsRewardVideoAd> {

    /* loaded from: classes.dex */
    public class a implements KsLoadManager.RewardVideoAdListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1275a;

        public a(FunAdSlot funAdSlot) {
            this.f1275a = funAdSlot;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public void onError(int i2, String str) {
            a.a.a.a.y.d.b("onError code: " + i2 + ", message: " + str, new Object[0]);
            j.this.f1014h.a(Integer.valueOf(i2));
            j.this.b(i2, str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public void onRewardVideoAdLoad(@Nullable List<KsRewardVideoAd> list) {
            a.a.a.a.y.d.a();
            if (list != null && !list.isEmpty()) {
                j.this.f1014h.b();
                KsRewardVideoAd ksRewardVideoAd = list.get(0);
                j jVar = j.this;
                jVar.a((j) ksRewardVideoAd);
                jVar.h();
                j.this.l.b(ksRewardVideoAd, this.f1275a.getSid());
                return;
            }
            a.a.a.a.y.d.b("onNativeAdLoad error: adList is null or empty", new Object[0]);
            j.this.f1014h.a("NoFill");
            onError(0, "No Fill");
        }
    }

    public j(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.c
    public a.a.a.a.x.a a(e.a aVar) {
        return new a.a.a.a.x.m(aVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, KsRewardVideoAd ksRewardVideoAd) {
        KsRewardVideoAd ksRewardVideoAd2 = ksRewardVideoAd;
        if (!ksRewardVideoAd2.isAdEnable()) {
            a.a.a.a.y.d.b("Ad isn't ready now", new Object[0]);
            a(0, "F:ad disable");
            return false;
        }
        this.f1014h.g();
        ksRewardVideoAd2.setRewardAdInteractionListener(new k(this, ksRewardVideoAd2, str));
        ksRewardVideoAd2.showRewardVideoAd(activity, this.f1015i.j ? new KsVideoPlayConfig.Builder().showLandscape(true).build() : null);
        return true;
    }

    @Override // a.a.a.a.c
    public void b(Context context, FunAdSlot funAdSlot) {
        KsScene build = new KsScene.Builder(Long.parseLong(this.f1015i.f1342c)).adNum(1).build();
        this.f1014h.a(funAdSlot, this.f1015i);
        KsAdSDK.getLoadManager().loadRewardVideoAd(build, new a(funAdSlot));
        g();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.c
    public void b(KsRewardVideoAd ksRewardVideoAd) {
    }
}
