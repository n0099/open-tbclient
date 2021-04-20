package a.a.a.a.r.a.b;

import a.a.a.a.s.e;
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
/* loaded from: classes.dex */
public class a extends e<TTNativeExpressAd> {
    public final HashMap<TTNativeExpressAd, String> n;

    /* renamed from: a.a.a.a.r.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0000a implements TTAdNative.NativeExpressAdListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1084a;

        public C0000a(FunAdSlot funAdSlot) {
            this.f1084a = funAdSlot;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.a.b
        public void onError(int i, String str) {
            a.this.f1010g.a(Integer.valueOf(i));
            a.a.a.a.v.d.b("onError code: " + i + ", message: " + str, new Object[0]);
            a.this.b(i, str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
            a.a.a.a.v.d.b("CSJBannerExpressAd onNativeExpressAdLoad", new Object[0]);
            if (list != null && !list.isEmpty()) {
                a.this.f1010g.b();
                TTNativeExpressAd tTNativeExpressAd = list.get(0);
                a.this.k.b(tTNativeExpressAd, this.f1084a.getSid());
                a aVar = a.this;
                String sid = this.f1084a.getSid();
                if (aVar == null) {
                    throw null;
                }
                tTNativeExpressAd.setExpressInteractionListener(new b(aVar, tTNativeExpressAd, sid));
                tTNativeExpressAd.render();
                return;
            }
            a.a.a.a.v.d.b("CSJBannerExpressAd onError: adList is null or empty", new Object[0]);
            a.this.f1010g.a("NoFill");
            a.this.b(0, "NoFill");
        }
    }

    public a(e.a aVar) {
        super(aVar);
        this.n = new HashMap<>();
    }

    @Override // a.a.a.a.b
    public boolean a(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        TTNativeExpressAd tTNativeExpressAd = (TTNativeExpressAd) obj;
        this.f1010g.g();
        tTNativeExpressAd.setSlideIntervalTime(this.f1011h.i);
        this.n.put(tTNativeExpressAd, str);
        View expressAdView = tTNativeExpressAd.getExpressAdView();
        if (expressAdView.getParent() != null) {
            ((ViewGroup) expressAdView.getParent()).removeView(expressAdView);
        }
        tTNativeExpressAd.setDislikeCallback(activity, new c(this, expressAdView));
        tTNativeExpressAd.setDownloadListener(new a.a.a.a.r.b.a.a(null));
        viewGroup.removeAllViews();
        viewGroup.addView(expressAdView);
        return true;
    }

    @Override // a.a.a.a.b
    public void b(Object obj) {
        TTNativeExpressAd tTNativeExpressAd = (TTNativeExpressAd) obj;
        this.n.remove(tTNativeExpressAd);
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.destroy();
        }
    }

    @Override // a.a.a.a.b
    public void b(Context context, FunAdSlot funAdSlot) {
        if (this.m == null) {
            this.m = TTAdSdk.getAdManager().createAdNative(context);
        }
        int expressWidth = funAdSlot.getExpressWidth();
        int expressHeight = funAdSlot.getExpressHeight();
        if (expressWidth == 0 && expressHeight == 0 && FunAdSdk.isLogEnabled()) {
            throw new RuntimeException("Invalid expressWidth and expressHeight.");
        }
        AdSlot build = new AdSlot.Builder().setCodeId(this.f1011h.f1320c).setSupportDeepLink(true).setAdCount(1).setExpressViewAcceptedSize(expressWidth, expressHeight).build();
        this.f1010g.a(funAdSlot, this.f1011h);
        this.m.loadBannerExpressAd(build, new C0000a(funAdSlot));
        g();
    }
}
