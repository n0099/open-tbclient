package a.a.a.a.r.a.b;

import a.a.a.a.s.e;
import android.app.Activity;
import android.content.Context;
import android.support.v4.media.session.MediaSessionCompat;
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
public class f extends e<TTNativeExpressAd> {
    public final HashMap<TTNativeExpressAd, String> n;

    /* loaded from: classes.dex */
    public class a implements TTAdNative.NativeExpressAdListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1101a;

        public a(FunAdSlot funAdSlot) {
            this.f1101a = funAdSlot;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.a.b
        public void onError(int i, String str) {
            a.a.a.a.v.d.b("onError code: " + i + ", message: " + str, new Object[0]);
            f.this.f1010g.a(Integer.valueOf(i));
            f.this.b(i, str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
            a.a.a.a.v.d.a();
            if (list != null && !list.isEmpty()) {
                f.this.f1010g.b();
                for (TTNativeExpressAd tTNativeExpressAd : list) {
                    f.this.k.b(tTNativeExpressAd, this.f1101a.getSid());
                }
                f fVar = f.this;
                String sid = this.f1101a.getSid();
                if (fVar == null) {
                    throw null;
                }
                b bVar = new b(list.size());
                for (TTNativeExpressAd tTNativeExpressAd2 : list) {
                    tTNativeExpressAd2.setExpressInteractionListener(new g(fVar, tTNativeExpressAd2, bVar, sid));
                    tTNativeExpressAd2.render();
                }
                return;
            }
            onError(0, "NoFill");
        }
    }

    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public int f1103a;

        /* renamed from: b  reason: collision with root package name */
        public final int f1104b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f1105c = false;

        public b(int i) {
            this.f1104b = i;
        }
    }

    public f(e.a aVar) {
        super(aVar);
        this.n = new HashMap<>();
    }

    @Override // a.a.a.a.b
    public boolean a(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        TTNativeExpressAd tTNativeExpressAd = (TTNativeExpressAd) obj;
        this.f1010g.g();
        this.n.put(tTNativeExpressAd, str);
        tTNativeExpressAd.setCanInterruptVideoPlay(true);
        tTNativeExpressAd.setVideoAdListener(new h(this));
        View expressAdView = tTNativeExpressAd.getExpressAdView();
        if (expressAdView.getParent() != null) {
            ((ViewGroup) expressAdView.getParent()).removeView(expressAdView);
        }
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
        AdSlot.Builder adCount = new AdSlot.Builder().setCodeId(this.f1011h.f1320c).setSupportDeepLink(true).setExpressViewAcceptedSize(expressWidth, expressHeight).setImageAcceptedSize(640, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP).setAdCount(3);
        TTAdNative createAdNative = TTAdSdk.getAdManager().createAdNative(context);
        this.f1010g.a(funAdSlot, this.f1011h);
        createAdNative.loadExpressDrawFeedAd(adCount.build(), new a(funAdSlot));
        g();
    }
}
