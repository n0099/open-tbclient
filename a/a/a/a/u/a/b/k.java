package a.a.a.a.u.a.b;

import a.a.a.a.v.e;
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
        public final /* synthetic */ FunAdSlot f1134a;

        public a(FunAdSlot funAdSlot) {
            this.f1134a = funAdSlot;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener, com.bytedance.sdk.openadsdk.a.b
        public void onError(int i2, String str) {
            a.a.a.a.y.d.b("onError code: " + i2 + ", message: " + str, new Object[0]);
            k.this.f1014h.a(Integer.valueOf(i2));
            k.this.b(i2, str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd) {
            a.a.a.a.y.d.a();
            k.this.f1014h.b();
            k kVar = k.this;
            kVar.a((k) tTFullScreenVideoAd);
            kVar.h();
            k.this.l.b(tTFullScreenVideoAd, this.f1134a.getSid());
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoCached() {
            a.a.a.a.y.d.a();
            k.this.f1014h.c();
        }
    }

    public k(e.a aVar) {
        super(aVar);
    }

    public AdSlot a(FunAdSlot funAdSlot) {
        return new AdSlot.Builder().setCodeId(this.f1015i.f1342c).setSupportDeepLink(true).setOrientation(this.f1015i.j ? 2 : 1).build();
    }

    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        TTFullScreenVideoAd tTFullScreenVideoAd = (TTFullScreenVideoAd) obj;
        this.f1014h.g();
        tTFullScreenVideoAd.setFullScreenVideoAdInteractionListener(new l(this, tTFullScreenVideoAd, str));
        tTFullScreenVideoAd.setDownloadListener(new a.a.a.a.u.b.a.a(null));
        tTFullScreenVideoAd.showFullScreenVideoAd(activity);
        return true;
    }

    @Override // a.a.a.a.c
    public void b(Context context, FunAdSlot funAdSlot) {
        if (this.n == null) {
            this.n = TTAdSdk.getAdManager().createAdNative(context);
        }
        AdSlot a2 = a(funAdSlot);
        this.f1014h.a(funAdSlot, this.f1015i);
        this.n.loadFullScreenVideoAd(a2, new a(funAdSlot));
        g();
    }

    @Override // a.a.a.a.c
    public void b(Object obj) {
        TTFullScreenVideoAd tTFullScreenVideoAd = (TTFullScreenVideoAd) obj;
    }
}
