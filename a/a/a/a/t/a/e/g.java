package a.a.a.a.t.a.e;

import a.a.a.a.u.e;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAdInflater;
import com.fun.ad.sdk.R;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsScene;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends a.a.a.a.c<KsNativeAd> {
    public final a.a.a.a.k<KsNativeAd, KsNativeAd.AdInteractionListener> m;

    /* loaded from: classes.dex */
    public class a implements KsLoadManager.NativeAdListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1257a;

        public a(FunAdSlot funAdSlot) {
            this.f1257a = funAdSlot;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public void onError(int i2, String str) {
            a.a.a.a.x.d.b("onError code: " + i2 + ", message: " + str, new Object[0]);
            g.this.f1013g.a(Integer.valueOf(i2));
            g.this.b(i2, str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public void onNativeAdLoad(@Nullable List<KsNativeAd> list) {
            a.a.a.a.x.d.a();
            if (list != null && !list.isEmpty()) {
                g.this.f1013g.b();
                KsNativeAd ksNativeAd = list.get(0);
                g gVar = g.this;
                gVar.a((g) ksNativeAd);
                gVar.h();
                g.this.k.b(ksNativeAd, this.f1257a.getSid());
                return;
            }
            a.a.a.a.x.d.b("error: adList is null or empty", new Object[0]);
            g.this.f1013g.a("NoFill");
            g.this.b(0, "NoFill");
        }
    }

    public g(e.a aVar) {
        super(aVar, true, true);
        this.m = new a.a.a.a.k<>(this);
    }

    @Override // a.a.a.a.c
    public a.a.a.a.w.a a(e.a aVar) {
        return new a.a.a.a.w.m(aVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public FunNativeAd a(Context context, String str, KsNativeAd ksNativeAd) {
        return new a.a.a.a.t.b.d.a(context, ksNativeAd, str, this);
    }

    @Override // a.a.a.a.c
    public void b(Context context, FunAdSlot funAdSlot) {
        KsScene build = new KsScene.Builder(Long.parseLong(this.f1014h.f1334c)).adNum(1).build();
        this.f1013g.a(funAdSlot, this.f1014h);
        KsAdSDK.getLoadManager().loadNativeAd(build, new a(funAdSlot));
        g();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.c
    public void b(KsNativeAd ksNativeAd) {
        KsNativeAd ksNativeAd2 = ksNativeAd;
        if (ksNativeAd2 != null) {
            this.m.a(ksNativeAd2);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    @Override // a.a.a.a.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(Activity activity, ViewGroup viewGroup, String str, KsNativeAd ksNativeAd) {
        int i2;
        KsNativeAd ksNativeAd2 = ksNativeAd;
        this.f1013g.g();
        int materialType = ksNativeAd2.getMaterialType();
        if (materialType != 0) {
            if (materialType == 1) {
                int interactionType = ksNativeAd2.getInteractionType();
                if (interactionType == 1) {
                    i2 = R.layout.ks_ad_native_video_app_download_view;
                } else if (interactionType == 2) {
                    i2 = R.layout.ks_ad_native_video_h5_open_view;
                }
            } else if (materialType == 2) {
                int interactionType2 = ksNativeAd2.getInteractionType();
                if (interactionType2 == 1) {
                    i2 = R.layout.ks_ad_native_single_img_app_download_view;
                } else if (interactionType2 == 2) {
                    i2 = R.layout.ks_ad_native_single_img_h5_open_view;
                }
            } else if (materialType != 3) {
                return false;
            } else {
                int interactionType3 = ksNativeAd2.getInteractionType();
                if (interactionType3 == 1) {
                    i2 = R.layout.ks_ad_native_group_img_app_download_view;
                } else if (interactionType3 == 2) {
                    i2 = R.layout.ks_ad_native_group_img_h5_open_view;
                }
            }
            if (i2 != 0) {
                return false;
            }
            a.a.a.a.t.b.d.c cVar = (a.a.a.a.t.b.d.c) LayoutInflater.from(activity).inflate(i2, viewGroup, false);
            viewGroup.removeAllViews();
            viewGroup.addView(cVar);
            cVar.a(activity, ksNativeAd2, new h(this, ksNativeAd2, str));
            return true;
        }
        i2 = 0;
        if (i2 != 0) {
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, java.lang.String, com.fun.ad.sdk.FunNativeAdInflater, java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean a(Activity activity, String str, FunNativeAdInflater funNativeAdInflater, KsNativeAd ksNativeAd) {
        KsNativeAd ksNativeAd2 = ksNativeAd;
        this.f1013g.g();
        ViewGroup adContainer = funNativeAdInflater.getAdContainer(new a.a.a.a.t.b.d.a(activity, ksNativeAd2, str, this));
        List<View> clickViews = funNativeAdInflater.getClickViews();
        if (clickViews == null) {
            clickViews = new ArrayList<>();
        }
        ksNativeAd2.registerViewForInteraction(adContainer, clickViews, new h(this, ksNativeAd2, str));
        return true;
    }
}
