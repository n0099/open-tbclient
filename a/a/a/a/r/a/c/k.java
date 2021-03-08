package a.a.a.a.r.a.c;

import a.a.a.a.a.e;
import android.app.Activity;
import android.content.Context;
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
public class k extends e<TTNativeExpressAd> {
    public final HashMap<TTNativeExpressAd, String> n;

    public k(e.a aVar) {
        super(aVar);
        this.n = new HashMap<>();
    }

    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        TTNativeExpressAd tTNativeExpressAd = (TTNativeExpressAd) obj;
        this.zk.g();
        this.n.put(tTNativeExpressAd, str);
        tTNativeExpressAd.setDownloadListener(new a.a.a.a.r.b.b.a(null));
        tTNativeExpressAd.showInteractionExpressAd(activity);
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
        this.Ae.loadInteractionExpressAd(build, new a(funAdSlot));
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
            a.a.a.a.v.d.b("onError code: " + i + ", message: " + str, new Object[0]);
            k.this.zk.a(Integer.valueOf(i));
            k.this.b(i, str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
            a.a.a.a.v.d.a();
            if (list != null && !list.isEmpty()) {
                k.this.zk.b();
                TTNativeExpressAd tTNativeExpressAd = list.get(0);
                k.this.zm.b(tTNativeExpressAd, this.zR.getSid());
                k kVar = k.this;
                String sid = this.zR.getSid();
                if (kVar == null) {
                    throw null;
                }
                tTNativeExpressAd.setExpressInteractionListener((TTNativeExpressAd.AdInteractionListener) new l(kVar, tTNativeExpressAd, sid));
                tTNativeExpressAd.render();
                return;
            }
            a.a.a.a.v.d.b("onNativeExpressAdLoad error: adList is null or empty", new Object[0]);
            k.this.zk.a("NoFill");
            k.this.b(0, "NoFill");
        }
    }
}
