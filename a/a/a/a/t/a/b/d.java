package a.a.a.a.t.a.b;

import a.a.a.a.u.e;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAdInflater;
import com.fun.ad.sdk.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d extends g<TTNativeAd> {
    public final a.a.a.a.k<TTNativeAd, TTNativeAd.AdInteractionListener> n;

    /* loaded from: classes.dex */
    public class a implements TTAdNative.NativeAdListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f1108a;

        public a(String str) {
            this.f1108a = str;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener, com.bytedance.sdk.openadsdk.a.b
        public void onError(int i2, String str) {
            a.a.a.a.x.d.b("onError code: " + i2 + ", message: " + str, new Object[0]);
            d.this.f1013g.a(Integer.valueOf(i2));
            d.this.b(i2, str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener
        public void onNativeAdLoad(List<TTNativeAd> list) {
            a.a.a.a.x.d.a("onNativeAdLoad", new Object[0]);
            if (list != null && !list.isEmpty()) {
                d.this.f1013g.b();
                TTNativeAd tTNativeAd = list.get(0);
                d dVar = d.this;
                dVar.a((d) tTNativeAd);
                dVar.h();
                d.this.k.b(tTNativeAd, this.f1108a);
                return;
            }
            a.a.a.a.x.d.b("onNativeAdLoad error: list is null or empty", new Object[0]);
            d.this.f1013g.a("NoFill");
            onError(0, "NoFill");
        }
    }

    public d(e.a aVar) {
        super(aVar, true);
        this.n = new a.a.a.a.k<>(this);
    }

    @Override // a.a.a.a.c
    public FunNativeAd a(Context context, String str, Object obj) {
        return new a.a.a.a.t.b.a.c((TTNativeAd) obj, str, this);
    }

    public void a(String str) {
        AdSlot.Builder supportDeepLink = new AdSlot.Builder().setCodeId(this.f1014h.f1334c).setSupportDeepLink(true);
        e.a aVar = this.f1014h;
        this.m.loadNativeAd(supportDeepLink.setImageAcceptedSize(aVar.f1338g, aVar.f1339h).setNativeAdType(1).setAdCount(1).build(), new a(str));
    }

    @Override // a.a.a.a.c
    public void b(Object obj) {
        this.n.a((TTNativeAd) obj);
    }

    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        int i2;
        TTNativeAd tTNativeAd = (TTNativeAd) obj;
        this.f1013g.g();
        int imageMode = tTNativeAd.getImageMode();
        if (imageMode == 15) {
            i2 = R.layout.csj_ad_native_vertical_video_view;
        } else if (imageMode == 16) {
            i2 = R.layout.csj_ad_native_vertical_img_view;
        } else if (imageMode == 2) {
            i2 = R.layout.csj_ad_native_small_img_view;
        } else if (imageMode == 3) {
            i2 = R.layout.csj_ad_native_large_img_view;
        } else if (imageMode == 4) {
            i2 = R.layout.csj_ad_native_group_img_view;
        } else if (imageMode != 5) {
            return false;
        } else {
            i2 = R.layout.csj_ad_native_large_video_view;
        }
        a.a.a.a.t.b.a.b bVar = (a.a.a.a.t.b.a.b) LayoutInflater.from(activity).inflate(i2, viewGroup, false);
        viewGroup.removeAllViews();
        viewGroup.addView(bVar);
        tTNativeAd.setActivityForDownloadApp(activity);
        bVar.a(activity, tTNativeAd, new e(this, tTNativeAd, str));
        return true;
    }

    @Override // a.a.a.a.c
    public void b(Context context, FunAdSlot funAdSlot) {
        if (this.m == null) {
            this.m = TTAdSdk.getAdManager().createAdNative(context);
        }
        this.f1013g.a(funAdSlot, this.f1014h);
        a(funAdSlot.getSid());
        g();
    }

    @Override // a.a.a.a.c
    public boolean a(Activity activity, String str, FunNativeAdInflater funNativeAdInflater, Object obj) {
        TTNativeAd tTNativeAd = (TTNativeAd) obj;
        this.f1013g.g();
        ViewGroup adContainer = funNativeAdInflater.getAdContainer(new a.a.a.a.t.b.a.c(tTNativeAd, str, this));
        List<View> clickViews = funNativeAdInflater.getClickViews();
        if (clickViews == null) {
            clickViews = new ArrayList<>();
        }
        List<View> creativeViews = funNativeAdInflater.getCreativeViews();
        if (creativeViews == null) {
            creativeViews = new ArrayList<>();
        }
        tTNativeAd.setActivityForDownloadApp(activity);
        tTNativeAd.registerViewForInteraction(adContainer, clickViews, creativeViews, new e(this, tTNativeAd, str));
        return true;
    }
}
