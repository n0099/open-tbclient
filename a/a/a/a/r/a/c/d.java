package a.a.a.a.r.a.c;

import a.a.a.a.s.e;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAdInflater;
import com.fun.ad.sdk.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class d extends e<TTNativeAd> {
    public final HashMap<TTNativeAd, TTNativeAd.AdInteractionListener> n;

    /* loaded from: classes.dex */
    public class a implements TTAdNative.NativeAdListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f1101a;

        public a(String str) {
            this.f1101a = str;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener, com.bytedance.sdk.openadsdk.a.b
        public void onError(int i, String str) {
            a.a.a.a.v.d.b("onError code: " + i + ", message: " + str, new Object[0]);
            d.this.f1010g.a(Integer.valueOf(i));
            d.this.b(i, str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener
        public void onNativeAdLoad(List<TTNativeAd> list) {
            a.a.a.a.v.d.a("onNativeAdLoad", new Object[0]);
            if (list != null && !list.isEmpty()) {
                d.this.f1010g.b();
                TTNativeAd tTNativeAd = list.get(0);
                d dVar = d.this;
                dVar.a((d) tTNativeAd);
                dVar.h();
                d.this.k.b(tTNativeAd, this.f1101a);
                return;
            }
            a.a.a.a.v.d.b("onNativeAdLoad error: list is null or empty", new Object[0]);
            d.this.f1010g.a("NoFill");
            onError(0, "NoFill");
        }
    }

    /* loaded from: classes.dex */
    public class b implements TTNativeAd.AdInteractionListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1103a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1104b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FunAdInteractionListener f1105c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f1106d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TTNativeAd f1107e;

        public b(FunAdInteractionListener funAdInteractionListener, String str, TTNativeAd tTNativeAd) {
            this.f1105c = funAdInteractionListener;
            this.f1106d = str;
            this.f1107e = tTNativeAd;
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdClicked(View view, TTNativeAd tTNativeAd) {
            a.a.a.a.v.d.a();
            d.this.f1010g.a(this.f1104b);
            this.f1104b = true;
            d.this.e();
            FunAdInteractionListener funAdInteractionListener = this.f1105c;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdClicked(this.f1106d);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
            a.a.a.a.v.d.a();
            d.this.f1010g.a(this.f1104b);
            this.f1104b = true;
            d.this.e();
            FunAdInteractionListener funAdInteractionListener = this.f1105c;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdClicked(this.f1106d);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdShow(TTNativeAd tTNativeAd) {
            a.a.a.a.v.d.a();
            d.this.f1010g.b(this.f1103a);
            this.f1103a = true;
            d.this.a((d) this.f1107e, this.f1106d);
            FunAdInteractionListener funAdInteractionListener = this.f1105c;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdShow(this.f1106d);
            }
        }
    }

    public d(e.a aVar) {
        super(aVar, true);
        this.n = new HashMap<>();
    }

    public final TTNativeAd.AdInteractionListener a(TTNativeAd tTNativeAd, String str, FunAdInteractionListener funAdInteractionListener) {
        synchronized (this.n) {
            TTNativeAd.AdInteractionListener adInteractionListener = this.n.get(tTNativeAd);
            if (adInteractionListener != null) {
                return adInteractionListener;
            }
            b bVar = new b(funAdInteractionListener, str, tTNativeAd);
            synchronized (this.n) {
                this.n.put(tTNativeAd, bVar);
            }
            return bVar;
        }
    }

    @Override // a.a.a.a.b
    public FunNativeAd a(Context context, String str, Object obj) {
        return new a.a.a.a.r.b.b.c((TTNativeAd) obj, str, this);
    }

    public void a(String str) {
        AdSlot.Builder supportDeepLink = new AdSlot.Builder().setCodeId(this.f1011h.f1334c).setSupportDeepLink(true);
        e.a aVar = this.f1011h;
        this.m.loadNativeAd(supportDeepLink.setImageAcceptedSize(aVar.f1338g, aVar.f1339h).setNativeAdType(1).setAdCount(1).build(), new a(str));
    }

    @Override // a.a.a.a.b
    public void b(Object obj) {
        TTNativeAd tTNativeAd = (TTNativeAd) obj;
        if (tTNativeAd != null) {
            synchronized (this.n) {
                this.n.remove(tTNativeAd);
            }
        }
    }

    @Override // a.a.a.a.b
    public boolean a(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        int i;
        TTNativeAd tTNativeAd = (TTNativeAd) obj;
        this.f1010g.g();
        int imageMode = tTNativeAd.getImageMode();
        if (imageMode == 15) {
            i = R.layout.csj_ad_native_vertical_video_view;
        } else if (imageMode == 16) {
            i = R.layout.csj_ad_native_vertical_img_view;
        } else if (imageMode == 2) {
            i = R.layout.csj_ad_native_small_img_view;
        } else if (imageMode == 3) {
            i = R.layout.csj_ad_native_large_img_view;
        } else if (imageMode == 4) {
            i = R.layout.csj_ad_native_group_img_view;
        } else if (imageMode != 5) {
            return false;
        } else {
            i = R.layout.csj_ad_native_large_video_view;
        }
        a.a.a.a.r.b.b.b bVar = (a.a.a.a.r.b.b.b) LayoutInflater.from(activity).inflate(i, viewGroup, false);
        viewGroup.removeAllViews();
        viewGroup.addView(bVar);
        tTNativeAd.setActivityForDownloadApp(activity);
        bVar.a(activity, tTNativeAd, a(tTNativeAd, str, (FunAdInteractionListener) null));
        return true;
    }

    @Override // a.a.a.a.b
    public void b(Context context, FunAdSlot funAdSlot) {
        if (this.m == null) {
            this.m = TTAdSdk.getAdManager().createAdNative(context);
        }
        this.f1010g.a(funAdSlot, this.f1011h);
        a(funAdSlot.getSid());
        g();
    }

    @Override // a.a.a.a.b
    public boolean a(Activity activity, String str, FunNativeAdInflater funNativeAdInflater, Object obj) {
        TTNativeAd tTNativeAd = (TTNativeAd) obj;
        this.f1010g.g();
        ViewGroup adContainer = funNativeAdInflater.getAdContainer(new a.a.a.a.r.b.b.c(tTNativeAd, str, this));
        List<View> clickViews = funNativeAdInflater.getClickViews();
        if (clickViews == null) {
            clickViews = new ArrayList<>();
        }
        List<View> creativeViews = funNativeAdInflater.getCreativeViews();
        if (creativeViews == null) {
            creativeViews = new ArrayList<>();
        }
        tTNativeAd.setActivityForDownloadApp(activity);
        tTNativeAd.registerViewForInteraction(adContainer, clickViews, creativeViews, a(tTNativeAd, str, (FunAdInteractionListener) null));
        return true;
    }
}
