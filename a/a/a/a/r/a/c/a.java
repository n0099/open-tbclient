package a.a.a.a.r.a.c;

import a.a.a.a.a.e;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends e<TTNativeExpressAd> {
    public final HashMap<TTNativeExpressAd, String> n;

    public a(e.a aVar) {
        super(aVar);
        this.n = new HashMap<>();
    }

    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        TTNativeExpressAd tTNativeExpressAd = (TTNativeExpressAd) obj;
        this.zk.g();
        tTNativeExpressAd.setSlideIntervalTime(this.zl.i);
        this.n.put(tTNativeExpressAd, str);
        View expressAdView = tTNativeExpressAd.getExpressAdView();
        if (expressAdView.getParent() != null) {
            ((ViewGroup) expressAdView.getParent()).removeView(expressAdView);
        }
        tTNativeExpressAd.setDislikeCallback(activity, new c(this, expressAdView));
        tTNativeExpressAd.setDownloadListener(new a.a.a.a.r.b.b.a(null));
        viewGroup.removeAllViews();
        viewGroup.addView(expressAdView);
        return true;
    }

    @Override // a.a.a.a.c
    public void b(Object obj) {
        TTNativeExpressAd tTNativeExpressAd = (TTNativeExpressAd) obj;
        this.n.remove(tTNativeExpressAd);
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.destroy();
        }
    }

    @Override // a.a.a.a.c
    public void a(Context context, FunAdSlot funAdSlot) {
        if (this.Ae == null) {
            this.Ae = TTAdSdk.getAdManager().createAdNative(context);
        }
        int expressWidth = funAdSlot.getExpressWidth();
        int expressHeight = funAdSlot.getExpressHeight();
        if (expressWidth == 0 && expressHeight == 0 && FunAdSdk.isLogEnabled()) {
            throw new RuntimeException("Invalid expressWidth and expressHeight.");
        }
        AdSlot build = new AdSlot.Builder().setCodeId(this.zl.c).setSupportDeepLink(true).setAdCount(1).setExpressViewAcceptedSize(expressWidth, expressHeight).build();
        this.zk.a(funAdSlot, this.zl);
        this.Ae.loadBannerExpressAd(build, new C0001a(funAdSlot));
        g();
    }

    /* renamed from: a.a.a.a.r.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0001a implements TTAdNative.NativeExpressAdListener {
        public final /* synthetic */ FunAdSlot zR;

        public C0001a(FunAdSlot funAdSlot) {
            this.zR = funAdSlot;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.a.b
        public void onError(int i, String str) {
            a.this.zk.a(Integer.valueOf(i));
            a.a.a.a.v.d.b("onError code: " + i + ", message: " + str, new Object[0]);
            a.this.b(i, str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
            a.a.a.a.v.d.b("CSJBannerExpressAd onNativeExpressAdLoad", new Object[0]);
            if (list != null && !list.isEmpty()) {
                a.this.zk.b();
                TTNativeExpressAd tTNativeExpressAd = list.get(0);
                a.this.zm.b(tTNativeExpressAd, this.zR.getSid());
                a aVar = a.this;
                String sid = this.zR.getSid();
                if (aVar == null) {
                    throw null;
                }
                tTNativeExpressAd.setExpressInteractionListener(new b(aVar, tTNativeExpressAd, sid));
                tTNativeExpressAd.render();
                return;
            }
            a.a.a.a.v.d.b("CSJBannerExpressAd onError: adList is null or empty", new Object[0]);
            a.this.zk.a("NoFill");
            a.this.b(0, "NoFill");
        }
    }
}
