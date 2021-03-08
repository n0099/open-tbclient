package a.a.a.a.r.a.c;

import a.a.a.a.a.e;
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
/* loaded from: classes4.dex */
public class d extends e<TTNativeAd> {
    public final HashMap<TTNativeAd, TTNativeAd.AdInteractionListener> n;

    /* loaded from: classes4.dex */
    public class b implements TTNativeAd.AdInteractionListener {
        public final /* synthetic */ FunAdInteractionListener Aa;
        public final /* synthetic */ TTNativeAd Ab;

        /* renamed from: a  reason: collision with root package name */
        public boolean f972a;
        public boolean b;
        public final /* synthetic */ String d;

        public b(FunAdInteractionListener funAdInteractionListener, String str, TTNativeAd tTNativeAd) {
            this.Aa = funAdInteractionListener;
            this.d = str;
            this.Ab = tTNativeAd;
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdClicked(View view, TTNativeAd tTNativeAd) {
            a.a.a.a.v.d.a();
            d.this.zk.a(this.b);
            this.b = true;
            d.this.e();
            FunAdInteractionListener funAdInteractionListener = this.Aa;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdClicked(this.d);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
            a.a.a.a.v.d.a();
            d.this.zk.a(this.b);
            this.b = true;
            d.this.e();
            FunAdInteractionListener funAdInteractionListener = this.Aa;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdClicked(this.d);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdShow(TTNativeAd tTNativeAd) {
            a.a.a.a.v.d.a();
            d.this.zk.b(this.f972a);
            this.f972a = true;
            d.this.a((d) this.Ab, this.d);
            FunAdInteractionListener funAdInteractionListener = this.Aa;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdShow(this.d);
            }
        }
    }

    public d(e.a aVar) {
        super(aVar, true);
        this.n = new HashMap<>();
    }

    public final TTNativeAd.AdInteractionListener a(TTNativeAd tTNativeAd, String str, FunAdInteractionListener funAdInteractionListener) {
        TTNativeAd.AdInteractionListener adInteractionListener;
        synchronized (this.n) {
            adInteractionListener = this.n.get(tTNativeAd);
            if (adInteractionListener == null) {
                adInteractionListener = new b(funAdInteractionListener, str, tTNativeAd);
                synchronized (this.n) {
                    this.n.put(tTNativeAd, adInteractionListener);
                }
            }
        }
        return adInteractionListener;
    }

    @Override // a.a.a.a.c
    public FunNativeAd a(Context context, String str, Object obj) {
        return new a.a.a.a.r.b.b.c((TTNativeAd) obj, str, this);
    }

    public void a(String str) {
        AdSlot.Builder supportDeepLink = new AdSlot.Builder().setCodeId(this.zl.c).setSupportDeepLink(true);
        e.a aVar = this.zl;
        this.Ae.loadNativeAd(supportDeepLink.setImageAcceptedSize(aVar.g, aVar.h).setNativeAdType(1).setAdCount(1).build(), new a(str));
    }

    @Override // a.a.a.a.c
    public void b(Object obj) {
        TTNativeAd tTNativeAd = (TTNativeAd) obj;
        if (tTNativeAd != null) {
            synchronized (this.n) {
                this.n.remove(tTNativeAd);
            }
        }
    }

    @Override // a.a.a.a.c
    public void a(Context context, FunAdSlot funAdSlot) {
        if (this.Ae == null) {
            this.Ae = TTAdSdk.getAdManager().createAdNative(context);
        }
        this.zk.a(funAdSlot, this.zl);
        a(funAdSlot.getSid());
        g();
    }

    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        int i;
        TTNativeAd tTNativeAd = (TTNativeAd) obj;
        this.zk.g();
        int imageMode = tTNativeAd.getImageMode();
        if (imageMode == 15) {
            i = R.layout.csj_ad_native_vertical_video_view;
        } else if (imageMode != 16) {
            switch (imageMode) {
                case 2:
                    i = R.layout.csj_ad_native_small_img_view;
                    break;
                case 3:
                    i = R.layout.csj_ad_native_large_img_view;
                    break;
                case 4:
                    i = R.layout.csj_ad_native_group_img_view;
                    break;
                case 5:
                    i = R.layout.csj_ad_native_large_video_view;
                    break;
                default:
                    return false;
            }
        } else {
            i = R.layout.csj_ad_native_vertical_img_view;
        }
        a.a.a.a.r.b.b.b bVar = (a.a.a.a.r.b.b.b) LayoutInflater.from(activity).inflate(i, viewGroup, false);
        viewGroup.removeAllViews();
        viewGroup.addView(bVar);
        tTNativeAd.setActivityForDownloadApp(activity);
        bVar.a(activity, tTNativeAd, a(tTNativeAd, str, (FunAdInteractionListener) null));
        return true;
    }

    /* loaded from: classes4.dex */
    public class a implements TTAdNative.NativeAdListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f971a;

        public a(String str) {
            this.f971a = str;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener, com.bytedance.sdk.openadsdk.a.b
        public void onError(int i, String str) {
            a.a.a.a.v.d.b("onError code: " + i + ", message: " + str, new Object[0]);
            d.this.zk.a(Integer.valueOf(i));
            d.this.b(i, str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener
        public void onNativeAdLoad(List<TTNativeAd> list) {
            a.a.a.a.v.d.a("onNativeAdLoad", new Object[0]);
            if (list != null && !list.isEmpty()) {
                d.this.zk.b();
                TTNativeAd tTNativeAd = list.get(0);
                d dVar = d.this;
                dVar.a((d) tTNativeAd);
                dVar.h();
                d.this.zm.b(tTNativeAd, this.f971a);
                return;
            }
            a.a.a.a.v.d.b("onNativeAdLoad error: list is null or empty", new Object[0]);
            d.this.zk.a("NoFill");
            onError(0, "NoFill");
        }
    }

    @Override // a.a.a.a.c
    public boolean a(Activity activity, String str, FunNativeAdInflater funNativeAdInflater, Object obj) {
        TTNativeAd tTNativeAd = (TTNativeAd) obj;
        this.zk.g();
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
