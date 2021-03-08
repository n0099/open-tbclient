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
public class m extends e<TTNativeExpressAd> {
    public final HashMap<TTNativeExpressAd, String> n;

    public m(e.a aVar) {
        super(aVar);
        this.n = new HashMap<>();
    }

    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        TTNativeExpressAd tTNativeExpressAd = (TTNativeExpressAd) obj;
        View expressAdView = tTNativeExpressAd.getExpressAdView();
        if (expressAdView != null && expressAdView.getParent() != null) {
            ((ViewGroup) expressAdView.getParent()).removeView(expressAdView);
        }
        this.n.put(tTNativeExpressAd, str);
        this.zk.g();
        tTNativeExpressAd.setDislikeCallback(activity, new o(this, expressAdView));
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
        this.Ae.loadNativeExpressAd(build, new a(funAdSlot));
        g();
    }

    /* loaded from: classes4.dex */
    public class a implements TTAdNative.NativeExpressAdListener {
        public final /* synthetic */ FunAdSlot zR;

        public a(FunAdSlot funAdSlot) {
            this.zR = funAdSlot;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.a.b
        public void onError(int i, String str) {
            a.a.a.a.v.d.b("CSJNativeExpressAd onError code: " + i + ", message: " + str, new Object[0]);
            m.this.zk.a(Integer.valueOf(i));
            m.this.b(i, str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
            a.a.a.a.v.d.b("CSJNativeExpressAd onNativeExpressAdLoad", new Object[0]);
            if (list != null && !list.isEmpty()) {
                m.this.zk.b();
                TTNativeExpressAd tTNativeExpressAd = list.get(0);
                m.this.zm.b(tTNativeExpressAd, this.zR.getSid());
                m mVar = m.this;
                String sid = this.zR.getSid();
                if (mVar == null) {
                    throw null;
                }
                tTNativeExpressAd.setExpressInteractionListener(new n(mVar, tTNativeExpressAd, sid));
                tTNativeExpressAd.setCanInterruptVideoPlay(true);
                tTNativeExpressAd.render();
                return;
            }
            a.a.a.a.v.d.b("CSJNativeExpressAd onNativeExpressAdLoad error: adList is null or empty", new Object[0]);
            m.this.zk.a("NoFill");
        }
    }
}
