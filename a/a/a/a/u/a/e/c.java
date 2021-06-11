package a.a.a.a.u.a.e;

import a.a.a.a.v.e;
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
/* loaded from: classes.dex */
public class c extends a.a.a.a.c<KsFullScreenVideoAd> {

    /* loaded from: classes.dex */
    public class a implements KsLoadManager.FullScreenVideoAdListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1250a;

        public a(FunAdSlot funAdSlot) {
            this.f1250a = funAdSlot;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
        public void onError(int i2, String str) {
            a.a.a.a.y.d.b("onError code: " + i2 + ", message: " + str, new Object[0]);
            c.this.f1014h.a(Integer.valueOf(i2));
            c.this.b(i2, str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
        public void onFullScreenVideoAdLoad(@Nullable List<KsFullScreenVideoAd> list) {
            a.a.a.a.y.d.a();
            if (list != null && !list.isEmpty()) {
                c.this.f1014h.b();
                KsFullScreenVideoAd ksFullScreenVideoAd = list.get(0);
                c cVar = c.this;
                cVar.a((c) ksFullScreenVideoAd);
                cVar.h();
                c.this.l.b(ksFullScreenVideoAd, this.f1250a.getSid());
                return;
            }
            a.a.a.a.y.d.b("onNativeAdLoad error: adList is null or empty", new Object[0]);
            c.this.f1014h.a("NoFill");
            c.this.b(0, "NoFill");
        }
    }

    public c(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.c
    public a.a.a.a.x.a a(e.a aVar) {
        return new a.a.a.a.x.m(aVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, KsFullScreenVideoAd ksFullScreenVideoAd) {
        KsFullScreenVideoAd ksFullScreenVideoAd2 = ksFullScreenVideoAd;
        if (!ksFullScreenVideoAd2.isAdEnable()) {
            a.a.a.a.y.d.b("Ad isn't ready now.", new Object[0]);
            return false;
        }
        this.f1014h.g();
        ksFullScreenVideoAd2.setFullScreenVideoAdInteractionListener(new d(this, ksFullScreenVideoAd2, str));
        ksFullScreenVideoAd2.showFullScreenVideoAd(activity, this.f1015i.j ? new KsVideoPlayConfig.Builder().showLandscape(true).build() : null);
        return true;
    }

    @Override // a.a.a.a.c
    public void b(Context context, FunAdSlot funAdSlot) {
        KsScene build = new KsScene.Builder(Long.parseLong(this.f1015i.f1342c)).adNum(1).build();
        this.f1014h.a(funAdSlot, this.f1015i);
        KsAdSDK.getLoadManager().loadFullScreenVideoAd(build, new a(funAdSlot));
        g();
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
}
