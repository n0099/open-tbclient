package a.a.a.a.r.a.e;

import a.a.a.a.s.e;
import a.a.a.a.u.l;
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
/* loaded from: classes.dex */
public class g extends a.a.a.a.b<KsNativeAd> {
    public final HashMap<KsNativeAd, KsNativeAd.AdInteractionListener> m;

    /* loaded from: classes.dex */
    public class a implements KsLoadManager.NativeAdListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1238a;

        public a(FunAdSlot funAdSlot) {
            this.f1238a = funAdSlot;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public void onError(int i, String str) {
            a.a.a.a.v.d.b("onError code: " + i + ", message: " + str, new Object[0]);
            g.this.f1010g.a(Integer.valueOf(i));
            g.this.b(i, str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public void onNativeAdLoad(@Nullable List<KsNativeAd> list) {
            a.a.a.a.v.d.a();
            if (list != null && !list.isEmpty()) {
                g.this.f1010g.b();
                KsNativeAd ksNativeAd = list.get(0);
                g gVar = g.this;
                gVar.a((g) ksNativeAd);
                gVar.h();
                g.this.k.b(ksNativeAd, this.f1238a.getSid());
                return;
            }
            a.a.a.a.v.d.b("error: adList is null or empty", new Object[0]);
            g.this.f1010g.a("NoFill");
            g.this.b(0, "NoFill");
        }
    }

    /* loaded from: classes.dex */
    public class b implements KsNativeAd.AdInteractionListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1240a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1241b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FunAdInteractionListener f1242c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f1243d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ KsNativeAd f1244e;

        public b(FunAdInteractionListener funAdInteractionListener, String str, KsNativeAd ksNativeAd) {
            this.f1242c = funAdInteractionListener;
            this.f1243d = str;
            this.f1244e = ksNativeAd;
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onAdClicked(View view, KsNativeAd ksNativeAd) {
            a.a.a.a.v.d.a();
            g.this.f1010g.a(this.f1241b);
            this.f1241b = true;
            g.this.e();
            FunAdInteractionListener funAdInteractionListener = this.f1242c;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdClicked(this.f1243d);
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onAdShow(KsNativeAd ksNativeAd) {
            a.a.a.a.v.d.a();
            g.this.f1010g.b(this.f1240a);
            this.f1240a = true;
            g.this.a((g) this.f1244e, this.f1243d);
            FunAdInteractionListener funAdInteractionListener = this.f1242c;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdShow(this.f1243d);
            }
        }
    }

    public g(e.a aVar) {
        super(aVar, true, true);
        this.m = new HashMap<>();
    }

    @Override // a.a.a.a.b
    public a.a.a.a.u.a a(e.a aVar) {
        return new l(aVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.b
    public FunNativeAd a(Context context, String str, KsNativeAd ksNativeAd) {
        return new a.a.a.a.r.b.d.a(context, ksNativeAd, str, this);
    }

    public final KsNativeAd.AdInteractionListener a(KsNativeAd ksNativeAd, String str, FunAdInteractionListener funAdInteractionListener) {
        synchronized (this.m) {
            KsNativeAd.AdInteractionListener adInteractionListener = this.m.get(ksNativeAd);
            if (adInteractionListener != null) {
                return adInteractionListener;
            }
            b bVar = new b(funAdInteractionListener, str, ksNativeAd);
            this.m.put(ksNativeAd, bVar);
            return bVar;
        }
    }

    @Override // a.a.a.a.b
    public void b(Context context, FunAdSlot funAdSlot) {
        KsScene build = new KsScene.Builder(Long.parseLong(this.f1011h.f1320c)).adNum(1).build();
        this.f1010g.a(funAdSlot, this.f1011h);
        KsAdSDK.getLoadManager().loadNativeAd(build, new a(funAdSlot));
        g();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.b
    public void b(KsNativeAd ksNativeAd) {
        KsNativeAd ksNativeAd2 = ksNativeAd;
        if (ksNativeAd2 != null) {
            synchronized (this.m) {
                this.m.remove(ksNativeAd2);
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    @Override // a.a.a.a.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(Activity activity, ViewGroup viewGroup, String str, KsNativeAd ksNativeAd) {
        int i;
        KsNativeAd ksNativeAd2 = ksNativeAd;
        this.f1010g.g();
        int materialType = ksNativeAd2.getMaterialType();
        if (materialType != 0) {
            if (materialType == 1) {
                int interactionType = ksNativeAd2.getInteractionType();
                if (interactionType == 1) {
                    i = R.layout.ks_ad_native_video_app_download_view;
                } else if (interactionType == 2) {
                    i = R.layout.ks_ad_native_video_h5_open_view;
                }
            } else if (materialType == 2) {
                int interactionType2 = ksNativeAd2.getInteractionType();
                if (interactionType2 == 1) {
                    i = R.layout.ks_ad_native_single_img_app_download_view;
                } else if (interactionType2 == 2) {
                    i = R.layout.ks_ad_native_single_img_h5_open_view;
                }
            } else if (materialType != 3) {
                return false;
            } else {
                int interactionType3 = ksNativeAd2.getInteractionType();
                if (interactionType3 == 1) {
                    i = R.layout.ks_ad_native_group_img_app_download_view;
                } else if (interactionType3 == 2) {
                    i = R.layout.ks_ad_native_group_img_h5_open_view;
                }
            }
            if (i != 0) {
                return false;
            }
            a.a.a.a.r.b.d.c cVar = (a.a.a.a.r.b.d.c) LayoutInflater.from(activity).inflate(i, viewGroup, false);
            viewGroup.removeAllViews();
            viewGroup.addView(cVar);
            cVar.a(activity, ksNativeAd2, a(ksNativeAd2, str, (FunAdInteractionListener) null));
            return true;
        }
        i = 0;
        if (i != 0) {
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, java.lang.String, com.fun.ad.sdk.FunNativeAdInflater, java.lang.Object] */
    @Override // a.a.a.a.b
    public boolean a(Activity activity, String str, FunNativeAdInflater funNativeAdInflater, KsNativeAd ksNativeAd) {
        KsNativeAd ksNativeAd2 = ksNativeAd;
        this.f1010g.g();
        ViewGroup adContainer = funNativeAdInflater.getAdContainer(new a.a.a.a.r.b.d.a(activity, ksNativeAd2, str, this));
        List<View> clickViews = funNativeAdInflater.getClickViews();
        if (clickViews == null) {
            clickViews = new ArrayList<>();
        }
        ksNativeAd2.registerViewForInteraction(adContainer, clickViews, a(ksNativeAd2, str, (FunAdInteractionListener) null));
        return true;
    }
}
