package a.a.a.a.u.a.b;

import a.a.a.a.v.e;
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
public class a extends g<TTNativeExpressAd> {
    public final HashMap<TTNativeExpressAd, String> o;

    /* renamed from: a.a.a.a.u.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0000a implements TTAdNative.NativeExpressAdListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1102a;

        public C0000a(FunAdSlot funAdSlot) {
            this.f1102a = funAdSlot;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.a.b
        public void onError(int i2, String str) {
            a.this.f1014h.a(Integer.valueOf(i2));
            a.a.a.a.y.d.b("onError code: " + i2 + ", message: " + str, new Object[0]);
            a.this.b(i2, str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
            a.a.a.a.y.d.b("CSJBannerExpressAd onNativeExpressAdLoad", new Object[0]);
            if (list != null && !list.isEmpty()) {
                a.this.f1014h.b();
                TTNativeExpressAd tTNativeExpressAd = list.get(0);
                a.this.l.b(tTNativeExpressAd, this.f1102a.getSid());
                a aVar = a.this;
                String sid = this.f1102a.getSid();
                if (aVar == null) {
                    throw null;
                }
                tTNativeExpressAd.setExpressInteractionListener(new b(aVar, tTNativeExpressAd, sid));
                tTNativeExpressAd.render();
                return;
            }
            a.a.a.a.y.d.b("CSJBannerExpressAd onError: adList is null or empty", new Object[0]);
            a.this.f1014h.a("NoFill");
            a.this.b(0, "NoFill");
        }
    }

    public a(e.a aVar) {
        super(aVar);
        this.o = new HashMap<>();
    }

    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        TTNativeExpressAd tTNativeExpressAd = (TTNativeExpressAd) obj;
        this.f1014h.g();
        tTNativeExpressAd.setSlideIntervalTime(this.f1015i.f1348i);
        this.o.put(tTNativeExpressAd, str);
        View expressAdView = tTNativeExpressAd.getExpressAdView();
        if (expressAdView.getParent() != null) {
            ((ViewGroup) expressAdView.getParent()).removeView(expressAdView);
        }
        tTNativeExpressAd.setDislikeCallback(activity, new c(this, expressAdView));
        tTNativeExpressAd.setDownloadListener(new a.a.a.a.u.b.a.a(null));
        viewGroup.removeAllViews();
        viewGroup.addView(expressAdView);
        return true;
    }

    @Override // a.a.a.a.c
    public void b(Object obj) {
        TTNativeExpressAd tTNativeExpressAd = (TTNativeExpressAd) obj;
        this.o.remove(tTNativeExpressAd);
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.destroy();
        }
    }

    @Override // a.a.a.a.c
    public void b(Context context, FunAdSlot funAdSlot) {
        if (this.n == null) {
            this.n = TTAdSdk.getAdManager().createAdNative(context);
        }
        int expressWidth = funAdSlot.getExpressWidth();
        int expressHeight = funAdSlot.getExpressHeight();
        if (expressWidth == 0 && expressHeight == 0 && FunAdSdk.isLogEnabled()) {
            throw new RuntimeException("Invalid expressWidth and expressHeight.");
        }
        AdSlot build = new AdSlot.Builder().setCodeId(this.f1015i.f1342c).setSupportDeepLink(true).setAdCount(1).setExpressViewAcceptedSize(expressWidth, expressHeight).build();
        this.f1014h.a(funAdSlot, this.f1015i);
        this.n.loadBannerExpressAd(build, new C0000a(funAdSlot));
        g();
    }
}
