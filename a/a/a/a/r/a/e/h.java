package a.a.a.a.r.a.e;

import a.a.a.a.s.e;
import a.a.a.a.u.l;
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
public class h extends a.a.a.a.b<KsRewardVideoAd> {

    /* loaded from: classes.dex */
    public class a implements KsLoadManager.RewardVideoAdListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1246a;

        public a(FunAdSlot funAdSlot) {
            this.f1246a = funAdSlot;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public void onError(int i, String str) {
            a.a.a.a.v.d.b("onError code: " + i + ", message: " + str, new Object[0]);
            h.this.f1010g.a(Integer.valueOf(i));
            h.this.b(i, str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public void onRewardVideoAdLoad(@Nullable List<KsRewardVideoAd> list) {
            a.a.a.a.v.d.a();
            if (list != null && !list.isEmpty()) {
                h.this.f1010g.b();
                KsRewardVideoAd ksRewardVideoAd = list.get(0);
                h hVar = h.this;
                hVar.a((h) ksRewardVideoAd);
                hVar.h();
                h.this.k.b(ksRewardVideoAd, this.f1246a.getSid());
                return;
            }
            a.a.a.a.v.d.b("onNativeAdLoad error: adList is null or empty", new Object[0]);
            h.this.f1010g.a("NoFill");
            onError(0, "No Fill");
        }
    }

    public h(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.b
    public a.a.a.a.u.a a(e.a aVar) {
        return new l(aVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.b
    public boolean a(Activity activity, ViewGroup viewGroup, String str, KsRewardVideoAd ksRewardVideoAd) {
        KsRewardVideoAd ksRewardVideoAd2 = ksRewardVideoAd;
        if (!ksRewardVideoAd2.isAdEnable()) {
            a.a.a.a.v.d.b("Ad isn't ready now", new Object[0]);
            a(0, "F:ad disable");
            return false;
        }
        this.f1010g.g();
        ksRewardVideoAd2.setRewardAdInteractionListener(new i(this, ksRewardVideoAd2, str));
        ksRewardVideoAd2.showRewardVideoAd(activity, this.f1011h.j ? new KsVideoPlayConfig.Builder().showLandscape(true).build() : null);
        return true;
    }

    @Override // a.a.a.a.b
    public void b(Context context, FunAdSlot funAdSlot) {
        KsScene build = new KsScene.Builder(Long.parseLong(this.f1011h.f1320c)).adNum(1).build();
        this.f1010g.a(funAdSlot, this.f1011h);
        KsAdSDK.getLoadManager().loadRewardVideoAd(build, new a(funAdSlot));
        g();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.b
    public void b(KsRewardVideoAd ksRewardVideoAd) {
    }
}
