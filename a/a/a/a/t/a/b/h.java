package a.a.a.a.t.a.b;

import a.a.a.a.u.e;
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
public class h extends g<TTNativeExpressAd> {
    public final HashMap<TTNativeExpressAd, String> n;

    /* loaded from: classes.dex */
    public class a implements TTAdNative.NativeExpressAdListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1118a;

        public a(FunAdSlot funAdSlot) {
            this.f1118a = funAdSlot;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.a.b
        public void onError(int i2, String str) {
            a.a.a.a.x.d.b("onError code: " + i2 + ", message: " + str, new Object[0]);
            h.this.f1013g.a(Integer.valueOf(i2));
            h.this.b(i2, str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
            a.a.a.a.x.d.a();
            if (list != null && !list.isEmpty()) {
                h.this.f1013g.b();
                for (TTNativeExpressAd tTNativeExpressAd : list) {
                    h.this.k.b(tTNativeExpressAd, this.f1118a.getSid());
                }
                h hVar = h.this;
                String sid = this.f1118a.getSid();
                if (hVar == null) {
                    throw null;
                }
                b bVar = new b(list.size());
                for (TTNativeExpressAd tTNativeExpressAd2 : list) {
                    tTNativeExpressAd2.setExpressInteractionListener(new i(hVar, tTNativeExpressAd2, bVar, sid));
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
        public int f1120a;

        /* renamed from: b  reason: collision with root package name */
        public final int f1121b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f1122c = false;

        public b(int i2) {
            this.f1121b = i2;
        }
    }

    public h(e.a aVar) {
        super(aVar);
        this.n = new HashMap<>();
    }

    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        TTNativeExpressAd tTNativeExpressAd = (TTNativeExpressAd) obj;
        this.f1013g.g();
        this.n.put(tTNativeExpressAd, str);
        tTNativeExpressAd.setCanInterruptVideoPlay(true);
        tTNativeExpressAd.setVideoAdListener(new j(this));
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
    public void b(Context context, FunAdSlot funAdSlot) {
        if (this.m == null) {
            this.m = TTAdSdk.getAdManager().createAdNative(context);
        }
        int expressWidth = funAdSlot.getExpressWidth();
        int expressHeight = funAdSlot.getExpressHeight();
        if (expressWidth == 0 && expressHeight == 0 && FunAdSdk.isLogEnabled()) {
            throw new RuntimeException("Invalid expressWidth and expressHeight.");
        }
        AdSlot.Builder adCount = new AdSlot.Builder().setCodeId(this.f1014h.f1334c).setSupportDeepLink(true).setExpressViewAcceptedSize(expressWidth, expressHeight).setImageAcceptedSize(640, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP).setAdCount(3);
        TTAdNative createAdNative = TTAdSdk.getAdManager().createAdNative(context);
        this.f1013g.a(funAdSlot, this.f1014h);
        createAdNative.loadExpressDrawFeedAd(adCount.build(), new a(funAdSlot));
        g();
    }
}
