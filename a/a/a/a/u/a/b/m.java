package a.a.a.a.u.a.b;

import a.a.a.a.v.e;
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
/* loaded from: classes.dex */
public class m extends g<TTNativeExpressAd> {
    public final HashMap<TTNativeExpressAd, String> o;

    /* loaded from: classes.dex */
    public class a implements TTAdNative.NativeExpressAdListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1141a;

        public a(FunAdSlot funAdSlot) {
            this.f1141a = funAdSlot;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.a.b
        public void onError(int i2, String str) {
            a.a.a.a.y.d.b("onError code: " + i2 + ", message: " + str, new Object[0]);
            m.this.f1014h.a(Integer.valueOf(i2));
            m.this.b(i2, str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
            a.a.a.a.y.d.a();
            if (list != null && !list.isEmpty()) {
                m.this.f1014h.b();
                TTNativeExpressAd tTNativeExpressAd = list.get(0);
                m.this.l.b(tTNativeExpressAd, this.f1141a.getSid());
                m mVar = m.this;
                String sid = this.f1141a.getSid();
                if (mVar == null) {
                    throw null;
                }
                tTNativeExpressAd.setExpressInteractionListener((TTNativeExpressAd.AdInteractionListener) new n(mVar, tTNativeExpressAd, sid));
                tTNativeExpressAd.render();
                return;
            }
            a.a.a.a.y.d.b("onNativeExpressAdLoad error: adList is null or empty", new Object[0]);
            m.this.f1014h.a("NoFill");
            m.this.b(0, "NoFill");
        }
    }

    public m(e.a aVar) {
        super(aVar);
        this.o = new HashMap<>();
    }

    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        TTNativeExpressAd tTNativeExpressAd = (TTNativeExpressAd) obj;
        this.f1014h.g();
        this.o.put(tTNativeExpressAd, str);
        tTNativeExpressAd.setDownloadListener(new a.a.a.a.u.b.a.a(null));
        tTNativeExpressAd.showInteractionExpressAd(activity);
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
        this.n.loadInteractionExpressAd(build, new a(funAdSlot));
        g();
    }
}
