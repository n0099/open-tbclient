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
public class m extends e<TTNativeExpressAd> {
    public final HashMap<TTNativeExpressAd, String> n;

    /* loaded from: classes.dex */
    public class a implements TTAdNative.NativeExpressAdListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1128a;

        public a(FunAdSlot funAdSlot) {
            this.f1128a = funAdSlot;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.a.b
        public void onError(int i, String str) {
            a.a.a.a.v.d.b("CSJNativeExpressAd onError code: " + i + ", message: " + str, new Object[0]);
            m.this.f1010g.a(Integer.valueOf(i));
            m.this.b(i, str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
            a.a.a.a.v.d.b("CSJNativeExpressAd onNativeExpressAdLoad", new Object[0]);
            if (list != null && !list.isEmpty()) {
                m.this.f1010g.b();
                TTNativeExpressAd tTNativeExpressAd = list.get(0);
                m.this.k.b(tTNativeExpressAd, this.f1128a.getSid());
                m mVar = m.this;
                String sid = this.f1128a.getSid();
                if (mVar == null) {
                    throw null;
                }
                tTNativeExpressAd.setExpressInteractionListener(new n(mVar, tTNativeExpressAd, sid));
                tTNativeExpressAd.setCanInterruptVideoPlay(true);
                tTNativeExpressAd.render();
                return;
            }
            a.a.a.a.v.d.b("CSJNativeExpressAd onNativeExpressAdLoad error: adList is null or empty", new Object[0]);
            m.this.f1010g.a("NoFill");
        }
    }

    public m(e.a aVar) {
        super(aVar);
        this.n = new HashMap<>();
    }

    @Override // a.a.a.a.b
    public boolean a(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        TTNativeExpressAd tTNativeExpressAd = (TTNativeExpressAd) obj;
        View expressAdView = tTNativeExpressAd.getExpressAdView();
        if (expressAdView != null && expressAdView.getParent() != null) {
            ((ViewGroup) expressAdView.getParent()).removeView(expressAdView);
        }
        this.n.put(tTNativeExpressAd, str);
        this.f1010g.g();
        tTNativeExpressAd.setDislikeCallback(activity, new o(this, expressAdView));
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
        this.m.loadNativeExpressAd(build, new a(funAdSlot));
        g();
    }
}
