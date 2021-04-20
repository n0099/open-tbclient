package a.a.a.a.r.a.b;

import a.a.a.a.s.e;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.fun.ad.sdk.FunAdSlot;
/* loaded from: classes.dex */
public class i extends e<TTFullScreenVideoAd> {

    /* loaded from: classes.dex */
    public class a implements TTAdNative.FullScreenVideoAdListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1114a;

        public a(FunAdSlot funAdSlot) {
            this.f1114a = funAdSlot;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener, com.bytedance.sdk.openadsdk.a.b
        public void onError(int i, String str) {
            a.a.a.a.v.d.b("onError code: " + i + ", message: " + str, new Object[0]);
            i.this.f1010g.a(Integer.valueOf(i));
            i.this.b(i, str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd) {
            a.a.a.a.v.d.a();
            i.this.f1010g.b();
            i iVar = i.this;
            iVar.a((i) tTFullScreenVideoAd);
            iVar.h();
            i.this.k.b(tTFullScreenVideoAd, this.f1114a.getSid());
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoCached() {
            a.a.a.a.v.d.a();
            i.this.f1010g.c();
        }
    }

    public i(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.b
    public boolean a(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        TTFullScreenVideoAd tTFullScreenVideoAd = (TTFullScreenVideoAd) obj;
        this.f1010g.g();
        tTFullScreenVideoAd.setFullScreenVideoAdInteractionListener(new j(this, tTFullScreenVideoAd, str));
        tTFullScreenVideoAd.setDownloadListener(new a.a.a.a.r.b.a.a(null));
        tTFullScreenVideoAd.showFullScreenVideoAd(activity);
        return true;
    }

    @Override // a.a.a.a.b
    public void b(Context context, FunAdSlot funAdSlot) {
        if (this.m == null) {
            this.m = TTAdSdk.getAdManager().createAdNative(context);
        }
        AdSlot build = new AdSlot.Builder().setCodeId(this.f1011h.f1320c).setSupportDeepLink(true).setOrientation(this.f1011h.j ? 2 : 1).build();
        this.f1010g.a(funAdSlot, this.f1011h);
        this.m.loadFullScreenVideoAd(build, new a(funAdSlot));
        g();
    }

    @Override // a.a.a.a.b
    public void b(Object obj) {
        TTFullScreenVideoAd tTFullScreenVideoAd = (TTFullScreenVideoAd) obj;
    }
}
