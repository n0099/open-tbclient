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
import com.yy.videoplayer.decoder.VideoConstant;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class f extends e<TTNativeExpressAd> {
    public final HashMap<TTNativeExpressAd, String> n;

    /* loaded from: classes4.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public int f973a;
        public final int b;
        public boolean c = false;

        public b(int i) {
            this.b = i;
        }
    }

    public f(e.a aVar) {
        super(aVar);
        this.n = new HashMap<>();
    }

    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        TTNativeExpressAd tTNativeExpressAd = (TTNativeExpressAd) obj;
        this.zk.g();
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
        AdSlot.Builder adCount = new AdSlot.Builder().setCodeId(this.zl.c).setSupportDeepLink(true).setExpressViewAcceptedSize(expressWidth, expressHeight).setImageAcceptedSize(640, VideoConstant.THUMBNAIL_WIDTH).setAdCount(3);
        TTAdNative createAdNative = TTAdSdk.getAdManager().createAdNative(context);
        this.zk.a(funAdSlot, this.zl);
        createAdNative.loadExpressDrawFeedAd(adCount.build(), new a(funAdSlot));
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
            f.this.zk.a(Integer.valueOf(i));
            f.this.b(i, str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
            a.a.a.a.v.d.a();
            if (list != null && !list.isEmpty()) {
                f.this.zk.b();
                for (TTNativeExpressAd tTNativeExpressAd : list) {
                    f.this.zm.b(tTNativeExpressAd, this.zR.getSid());
                }
                f fVar = f.this;
                String sid = this.zR.getSid();
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
}
