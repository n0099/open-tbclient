package a.a.a.a.r.a.c;

import a.a.a.a.a.e;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.fun.ad.sdk.FunAdSlot;
/* loaded from: classes4.dex */
public class i extends e<TTFullScreenVideoAd> {

    /* loaded from: classes4.dex */
    public class a implements TTAdNative.FullScreenVideoAdListener {
        public final /* synthetic */ FunAdSlot zR;

        public a(FunAdSlot funAdSlot) {
            this.zR = funAdSlot;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener, com.bytedance.sdk.openadsdk.a.b
        public void onError(int i, String str) {
            a.a.a.a.v.d.b("onError code: " + i + ", message: " + str, new Object[0]);
            i.this.zk.a(Integer.valueOf(i));
            i.this.b(i, str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd) {
            a.a.a.a.v.d.a();
            i.this.zk.b();
            i iVar = i.this;
            iVar.a((i) tTFullScreenVideoAd);
            iVar.h();
            i.this.zm.b(tTFullScreenVideoAd, this.zR.getSid());
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoCached() {
            a.a.a.a.v.d.a();
            i.this.zk.c();
        }
    }

    public i(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.c
    public void a(Context context, FunAdSlot funAdSlot) {
        if (this.Ae == null) {
            this.Ae = TTAdSdk.getAdManager().createAdNative(context);
        }
        AdSlot build = new AdSlot.Builder().setCodeId(this.zl.c).setSupportDeepLink(true).setOrientation(this.zl.j ? 2 : 1).build();
        this.zk.a(funAdSlot, this.zl);
        this.Ae.loadFullScreenVideoAd(build, new a(funAdSlot));
        g();
    }

    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        TTFullScreenVideoAd tTFullScreenVideoAd = (TTFullScreenVideoAd) obj;
        this.zk.g();
        tTFullScreenVideoAd.setFullScreenVideoAdInteractionListener(new j(this, tTFullScreenVideoAd, str));
        tTFullScreenVideoAd.setDownloadListener(new a.a.a.a.r.b.b.a(null));
        tTFullScreenVideoAd.showFullScreenVideoAd(activity);
        return true;
    }

    @Override // a.a.a.a.c
    public void b(Object obj) {
        TTFullScreenVideoAd tTFullScreenVideoAd = (TTFullScreenVideoAd) obj;
    }
}
