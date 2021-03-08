package a.a.a.a.r.a.f;

import a.a.a.a.a.e;
import a.a.a.a.c.m;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAdInflater;
import com.fun.ad.sdk.R;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsScene;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class g extends a.a.a.a.c<KsNativeAd> {
    public final HashMap<KsNativeAd, KsNativeAd.AdInteractionListener> m;

    /* loaded from: classes4.dex */
    public class b implements KsNativeAd.AdInteractionListener {
        public final /* synthetic */ FunAdInteractionListener Aa;
        public final /* synthetic */ KsNativeAd Bo;

        /* renamed from: a  reason: collision with root package name */
        public boolean f997a;
        public boolean b;
        public final /* synthetic */ String d;

        public b(FunAdInteractionListener funAdInteractionListener, String str, KsNativeAd ksNativeAd) {
            this.Aa = funAdInteractionListener;
            this.d = str;
            this.Bo = ksNativeAd;
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onAdClicked(View view, KsNativeAd ksNativeAd) {
            a.a.a.a.v.d.a();
            g.this.zk.a(this.b);
            this.b = true;
            g.this.e();
            FunAdInteractionListener funAdInteractionListener = this.Aa;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdClicked(this.d);
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onAdShow(KsNativeAd ksNativeAd) {
            a.a.a.a.v.d.a();
            g.this.zk.b(this.f997a);
            this.f997a = true;
            g.this.a((g) this.Bo, this.d);
            FunAdInteractionListener funAdInteractionListener = this.Aa;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdShow(this.d);
            }
        }
    }

    public g(e.a aVar) {
        super(aVar, true, true);
        this.m = new HashMap<>();
    }

    @Override // a.a.a.a.c
    public a.a.a.a.c.a a(e.a aVar) {
        return new m(aVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public FunNativeAd a(Context context, String str, KsNativeAd ksNativeAd) {
        return new a.a.a.a.r.b.e.a(context, ksNativeAd, str, this);
    }

    public final KsNativeAd.AdInteractionListener a(KsNativeAd ksNativeAd, String str, FunAdInteractionListener funAdInteractionListener) {
        KsNativeAd.AdInteractionListener adInteractionListener;
        synchronized (this.m) {
            adInteractionListener = this.m.get(ksNativeAd);
            if (adInteractionListener == null) {
                adInteractionListener = new b(funAdInteractionListener, str, ksNativeAd);
                this.m.put(ksNativeAd, adInteractionListener);
            }
        }
        return adInteractionListener;
    }

    @Override // a.a.a.a.c
    public void a(Context context, FunAdSlot funAdSlot) {
        KsScene build = new KsScene.Builder(Long.parseLong(this.zl.c)).adNum(1).build();
        this.zk.a(funAdSlot, this.zl);
        KsAdSDK.getLoadManager().loadNativeAd(build, new a(funAdSlot));
        g();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.c
    public void b(KsNativeAd ksNativeAd) {
        KsNativeAd ksNativeAd2 = ksNativeAd;
        if (ksNativeAd2 != null) {
            synchronized (this.m) {
                this.m.remove(ksNativeAd2);
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, KsNativeAd ksNativeAd) {
        int i;
        KsNativeAd ksNativeAd2 = ksNativeAd;
        this.zk.g();
        switch (ksNativeAd2.getMaterialType()) {
            case 0:
                i = 0;
                break;
            case 1:
                int interactionType = ksNativeAd2.getInteractionType();
                if (interactionType == 1) {
                    i = R.layout.ks_ad_native_video_app_download_view;
                    break;
                } else if (interactionType == 2) {
                    i = R.layout.ks_ad_native_video_h5_open_view;
                    break;
                } else {
                    i = 0;
                    break;
                }
            case 2:
                int interactionType2 = ksNativeAd2.getInteractionType();
                if (interactionType2 == 1) {
                    i = R.layout.ks_ad_native_single_img_app_download_view;
                    break;
                } else if (interactionType2 == 2) {
                    i = R.layout.ks_ad_native_single_img_h5_open_view;
                    break;
                } else {
                    i = 0;
                    break;
                }
            case 3:
                int interactionType3 = ksNativeAd2.getInteractionType();
                if (interactionType3 == 1) {
                    i = R.layout.ks_ad_native_group_img_app_download_view;
                    break;
                } else if (interactionType3 == 2) {
                    i = R.layout.ks_ad_native_group_img_h5_open_view;
                    break;
                } else {
                    i = 0;
                    break;
                }
            default:
                return false;
        }
        if (i != 0) {
            a.a.a.a.r.b.e.c cVar = (a.a.a.a.r.b.e.c) LayoutInflater.from(activity).inflate(i, viewGroup, false);
            viewGroup.removeAllViews();
            viewGroup.addView(cVar);
            cVar.a(activity, ksNativeAd2, a(ksNativeAd2, str, (FunAdInteractionListener) null));
            return true;
        }
        return false;
    }

    /* loaded from: classes4.dex */
    public class a implements KsLoadManager.NativeAdListener {
        public final /* synthetic */ FunAdSlot zR;

        public a(FunAdSlot funAdSlot) {
            this.zR = funAdSlot;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public void onError(int i, String str) {
            a.a.a.a.v.d.b("onError code: " + i + ", message: " + str, new Object[0]);
            g.this.zk.a(Integer.valueOf(i));
            g.this.b(i, str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public void onNativeAdLoad(@Nullable List<KsNativeAd> list) {
            a.a.a.a.v.d.a();
            if (list != null && !list.isEmpty()) {
                g.this.zk.b();
                KsNativeAd ksNativeAd = list.get(0);
                g gVar = g.this;
                gVar.a((g) ksNativeAd);
                gVar.h();
                g.this.zm.b(ksNativeAd, this.zR.getSid());
                return;
            }
            a.a.a.a.v.d.b("error: adList is null or empty", new Object[0]);
            g.this.zk.a("NoFill");
            g.this.b(0, "NoFill");
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, java.lang.String, com.fun.ad.sdk.FunNativeAdInflater, java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean a(Activity activity, String str, FunNativeAdInflater funNativeAdInflater, KsNativeAd ksNativeAd) {
        KsNativeAd ksNativeAd2 = ksNativeAd;
        this.zk.g();
        ViewGroup adContainer = funNativeAdInflater.getAdContainer(new a.a.a.a.r.b.e.a(activity, ksNativeAd2, str, this));
        List<View> clickViews = funNativeAdInflater.getClickViews();
        if (clickViews == null) {
            clickViews = new ArrayList<>();
        }
        ksNativeAd2.registerViewForInteraction(adContainer, clickViews, a(ksNativeAd2, str, (FunAdInteractionListener) null));
        return true;
    }
}
