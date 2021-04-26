package a.a.a.a.t.a.b;

import a.a.a.a.u.e;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.fun.ad.sdk.FunAdSlot;
/* loaded from: classes.dex */
public class k extends g<TTFullScreenVideoAd> {

    /* loaded from: classes.dex */
    public class a implements TTAdNative.FullScreenVideoAdListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1131a;

        public a(FunAdSlot funAdSlot) {
            this.f1131a = funAdSlot;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener, com.bytedance.sdk.openadsdk.a.b
        public void onError(int i2, String str) {
            a.a.a.a.x.d.b("onError code: " + i2 + ", message: " + str, new Object[0]);
            k.this.f1013g.a(Integer.valueOf(i2));
            k.this.b(i2, str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd) {
            a.a.a.a.x.d.a();
            k.this.f1013g.b();
            k kVar = k.this;
            kVar.a((k) tTFullScreenVideoAd);
            kVar.h();
            k.this.k.b(tTFullScreenVideoAd, this.f1131a.getSid());
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoCached() {
            a.a.a.a.x.d.a();
            k.this.f1013g.c();
        }
    }

    public k(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        TTFullScreenVideoAd tTFullScreenVideoAd = (TTFullScreenVideoAd) obj;
        this.f1013g.g();
        tTFullScreenVideoAd.setFullScreenVideoAdInteractionListener(new l(this, tTFullScreenVideoAd, str));
        tTFullScreenVideoAd.setDownloadListener(new a.a.a.a.t.b.a.a(null));
        tTFullScreenVideoAd.showFullScreenVideoAd(activity);
        return true;
    }

    @Override // a.a.a.a.c
    public void b(Context context, FunAdSlot funAdSlot) {
        if (this.m == null) {
            this.m = TTAdSdk.getAdManager().createAdNative(context);
        }
        AdSlot build = new AdSlot.Builder().setCodeId(this.f1014h.f1334c).setSupportDeepLink(true).setOrientation(this.f1014h.j ? 2 : 1).build();
        this.f1013g.a(funAdSlot, this.f1014h);
        this.m.loadFullScreenVideoAd(build, new a(funAdSlot));
        g();
    }

    @Override // a.a.a.a.c
    public void b(Object obj) {
        TTFullScreenVideoAd tTFullScreenVideoAd = (TTFullScreenVideoAd) obj;
    }
}
