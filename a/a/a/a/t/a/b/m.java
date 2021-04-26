package a.a.a.a.t.a.b;

import a.a.a.a.u.e;
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
    public final HashMap<TTNativeExpressAd, String> n;

    /* loaded from: classes.dex */
    public class a implements TTAdNative.NativeExpressAdListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1138a;

        public a(FunAdSlot funAdSlot) {
            this.f1138a = funAdSlot;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.a.b
        public void onError(int i2, String str) {
            a.a.a.a.x.d.b("onError code: " + i2 + ", message: " + str, new Object[0]);
            m.this.f1013g.a(Integer.valueOf(i2));
            m.this.b(i2, str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
            a.a.a.a.x.d.a();
            if (list != null && !list.isEmpty()) {
                m.this.f1013g.b();
                TTNativeExpressAd tTNativeExpressAd = list.get(0);
                m.this.k.b(tTNativeExpressAd, this.f1138a.getSid());
                m mVar = m.this;
                String sid = this.f1138a.getSid();
                if (mVar == null) {
                    throw null;
                }
                tTNativeExpressAd.setExpressInteractionListener((TTNativeExpressAd.AdInteractionListener) new n(mVar, tTNativeExpressAd, sid));
                tTNativeExpressAd.render();
                return;
            }
            a.a.a.a.x.d.b("onNativeExpressAdLoad error: adList is null or empty", new Object[0]);
            m.this.f1013g.a("NoFill");
            m.this.b(0, "NoFill");
        }
    }

    public m(e.a aVar) {
        super(aVar);
        this.n = new HashMap<>();
    }

    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        TTNativeExpressAd tTNativeExpressAd = (TTNativeExpressAd) obj;
        this.f1013g.g();
        this.n.put(tTNativeExpressAd, str);
        tTNativeExpressAd.setDownloadListener(new a.a.a.a.t.b.a.a(null));
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
    public void b(Context context, FunAdSlot funAdSlot) {
        if (this.m == null) {
            this.m = TTAdSdk.getAdManager().createAdNative(context);
        }
        int expressWidth = funAdSlot.getExpressWidth();
        int expressHeight = funAdSlot.getExpressHeight();
        if (expressWidth == 0 && expressHeight == 0 && FunAdSdk.isLogEnabled()) {
            throw new RuntimeException("Invalid expressWidth and expressHeight.");
        }
        AdSlot build = new AdSlot.Builder().setCodeId(this.f1014h.f1334c).setSupportDeepLink(true).setAdCount(1).setExpressViewAcceptedSize(expressWidth, expressHeight).build();
        this.f1013g.a(funAdSlot, this.f1014h);
        this.m.loadInteractionExpressAd(build, new a(funAdSlot));
        g();
    }
}
