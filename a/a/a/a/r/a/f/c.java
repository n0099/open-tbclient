package a.a.a.a.r.a.f;

import a.a.a.a.a.e;
import a.a.a.a.c.m;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.fun.ad.sdk.FunAdSlot;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends a.a.a.a.c<KsFullScreenVideoAd> {
    public c(e.a aVar) {
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
        KsAdSDK.getLoadManager().loadFullScreenVideoAd(build, new a(funAdSlot));
        g();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, KsFullScreenVideoAd ksFullScreenVideoAd) {
        KsFullScreenVideoAd ksFullScreenVideoAd2 = ksFullScreenVideoAd;
        if (!ksFullScreenVideoAd2.isAdEnable()) {
            a.a.a.a.v.d.b("Ad isn't ready now.", new Object[0]);
            return false;
        }
        this.zk.g();
        ksFullScreenVideoAd2.setFullScreenVideoAdInteractionListener(new d(this, ksFullScreenVideoAd2, str));
        ksFullScreenVideoAd2.showFullScreenVideoAd(activity, this.zl.j ? new KsVideoPlayConfig.Builder().showLandscape(true).build() : null);
        return true;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.c
    public void b(KsFullScreenVideoAd ksFullScreenVideoAd) {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean c(KsFullScreenVideoAd ksFullScreenVideoAd) {
        KsFullScreenVideoAd ksFullScreenVideoAd2 = ksFullScreenVideoAd;
        return ksFullScreenVideoAd2 != null && ksFullScreenVideoAd2.isAdEnable();
    }

    /* loaded from: classes4.dex */
    public class a implements KsLoadManager.FullScreenVideoAdListener {
        public final /* synthetic */ FunAdSlot zR;

        public a(FunAdSlot funAdSlot) {
            this.zR = funAdSlot;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
        public void onError(int i, String str) {
            a.a.a.a.v.d.b("onError code: " + i + ", message: " + str, new Object[0]);
            c.this.zk.a(Integer.valueOf(i));
            c.this.b(i, str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
        public void onFullScreenVideoAdLoad(@Nullable List<KsFullScreenVideoAd> list) {
            a.a.a.a.v.d.a();
            if (list != null && !list.isEmpty()) {
                c.this.zk.b();
                KsFullScreenVideoAd ksFullScreenVideoAd = list.get(0);
                c cVar = c.this;
                cVar.a((c) ksFullScreenVideoAd);
                cVar.h();
                c.this.zm.b(ksFullScreenVideoAd, this.zR.getSid());
                return;
            }
            a.a.a.a.v.d.b("onNativeAdLoad error: adList is null or empty", new Object[0]);
            c.this.zk.a("NoFill");
            c.this.b(0, "NoFill");
        }
    }
}
