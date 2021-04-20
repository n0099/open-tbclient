package a.a.a.a.r.a.c;

import a.a.a.a.s.e;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAdInflater;
import com.fun.ad.sdk.R;
import com.fun.ad.sdk.channel.model.gdt.GDTNativeUnifiedVideoView;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class g extends a.a.a.a.b<NativeUnifiedADData> {
    public final HashMap<NativeUnifiedADData, c> m;

    /* loaded from: classes.dex */
    public class a implements NativeADUnifiedListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1166a;

        public a(FunAdSlot funAdSlot) {
            this.f1166a = funAdSlot;
        }

        @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
        public void onADLoaded(List<NativeUnifiedADData> list) {
            a.a.a.a.v.d.a();
            if (list != null && !list.isEmpty()) {
                g.this.f1010g.b();
                NativeUnifiedADData nativeUnifiedADData = list.get(0);
                g gVar = g.this;
                gVar.a((g) nativeUnifiedADData);
                gVar.h();
                g.this.k.b(nativeUnifiedADData, this.f1166a.getSid());
                return;
            }
            a.a.a.a.v.d.b("onADLoaded error: adList is null or empty", new Object[0]);
            g.this.f1010g.a("NoFill");
            g.this.b(0, "NoFill");
        }

        @Override // com.qq.e.ads.AbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            a.a.a.a.v.d.b("onError code: " + adError.getErrorCode() + ", message: " + adError.getErrorMsg(), new Object[0]);
            g.this.f1010g.a(Integer.valueOf(adError.getErrorCode()));
            g.this.b(adError.getErrorCode(), adError.getErrorMsg());
        }
    }

    /* loaded from: classes.dex */
    public static class b implements NativeADMediaListener {
        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoClicked() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoCompleted() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoError(AdError adError) {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoInit() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoLoaded(int i) {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoLoading() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoPause() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoReady() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoResume() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoStart() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoStop() {
        }
    }

    /* loaded from: classes.dex */
    public class c implements NativeADEventListener {

        /* renamed from: a  reason: collision with root package name */
        public final NativeUnifiedADData f1168a;

        /* renamed from: b  reason: collision with root package name */
        public final String f1169b;

        /* renamed from: c  reason: collision with root package name */
        public final FunAdInteractionListener f1170c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f1171d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f1172e;

        /* renamed from: f  reason: collision with root package name */
        public d f1173f;

        public c(NativeUnifiedADData nativeUnifiedADData, String str, FunAdInteractionListener funAdInteractionListener) {
            this.f1168a = nativeUnifiedADData;
            this.f1169b = str;
            this.f1170c = funAdInteractionListener;
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADClicked() {
            a.a.a.a.v.d.a();
            g.this.f1010g.a(this.f1172e);
            this.f1172e = true;
            g.this.e();
            FunAdInteractionListener funAdInteractionListener = this.f1170c;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdClicked(this.f1169b);
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADError(AdError adError) {
            a.a.a.a.v.d.a();
            g.this.f1010g.b(Integer.valueOf(adError.getErrorCode()));
            g.this.a(adError.getErrorCode(), adError.getErrorMsg());
            FunAdInteractionListener funAdInteractionListener = this.f1170c;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdError(this.f1169b);
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADExposed() {
            a.a.a.a.v.d.a();
            g.this.f1010g.b(this.f1171d);
            this.f1171d = true;
            g.this.a((g) this.f1168a, this.f1169b);
            FunAdInteractionListener funAdInteractionListener = this.f1170c;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdShow(this.f1169b);
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADStatusChanged() {
            a.a.a.a.v.d.a();
            d dVar = this.f1173f;
            if (dVar != null) {
                dVar.onADStatusChanged();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void onADStatusChanged();
    }

    public g(e.a aVar) {
        super(aVar, true, true);
        this.m = new HashMap<>();
    }

    @Override // a.a.a.a.b
    public a.a.a.a.u.a a(e.a aVar) {
        return new a.a.a.a.u.g(aVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.b
    public FunNativeAd a(Context context, String str, NativeUnifiedADData nativeUnifiedADData) {
        NativeUnifiedADData nativeUnifiedADData2 = nativeUnifiedADData;
        return new a.a.a.a.r.b.b.a(nativeUnifiedADData2, nativeUnifiedADData2.getAdPatternType() == 2 ? new MediaView(context) : null, str, this);
    }

    public final NativeADEventListener a(NativeUnifiedADData nativeUnifiedADData, String str, FunAdInteractionListener funAdInteractionListener, d dVar) {
        synchronized (this.m) {
            c cVar = this.m.get(nativeUnifiedADData);
            if (cVar != null) {
                cVar.f1173f = dVar;
                return cVar;
            }
            c cVar2 = new c(nativeUnifiedADData, str, funAdInteractionListener);
            cVar2.f1173f = dVar;
            this.m.put(nativeUnifiedADData, cVar2);
            return cVar2;
        }
    }

    @Override // a.a.a.a.b
    public void b(Context context, FunAdSlot funAdSlot) {
        a aVar = new a(funAdSlot);
        this.f1010g.a(funAdSlot, this.f1011h);
        NativeUnifiedAD nativeUnifiedAD = new NativeUnifiedAD(context.getApplicationContext(), this.f1011h.f1320c, aVar);
        nativeUnifiedAD.setMinVideoDuration(0);
        nativeUnifiedAD.setMaxVideoDuration(0);
        nativeUnifiedAD.setVideoPlayPolicy(1);
        nativeUnifiedAD.setVideoADContainerRender(1);
        nativeUnifiedAD.loadData(1);
        g();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.b
    public void b(NativeUnifiedADData nativeUnifiedADData) {
        NativeUnifiedADData nativeUnifiedADData2 = nativeUnifiedADData;
        if (nativeUnifiedADData2 != null) {
            nativeUnifiedADData2.destroy();
            synchronized (this.m) {
                this.m.remove(nativeUnifiedADData2);
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.b
    public boolean a(Activity activity, ViewGroup viewGroup, String str, NativeUnifiedADData nativeUnifiedADData) {
        int i;
        NativeUnifiedADData nativeUnifiedADData2 = nativeUnifiedADData;
        int adPatternType = nativeUnifiedADData2.getAdPatternType();
        if (adPatternType == 1) {
            i = R.layout.gdt_ad_native_unified_img2_view;
        } else if (adPatternType != 2) {
            if (adPatternType != 3) {
                if (adPatternType != 4) {
                    return false;
                }
            } else if (nativeUnifiedADData2.getImgList().size() == 3) {
                i = R.layout.gdt_ad_native_unified_img3_view;
            }
            i = R.layout.gdt_ad_native_unified_img_view;
        } else {
            i = R.layout.gdt_ad_native_unified_video_view;
        }
        this.f1010g.g();
        a.a.a.a.r.b.b.b bVar = (a.a.a.a.r.b.b.b) LayoutInflater.from(activity).inflate(i, viewGroup, false);
        if (bVar instanceof GDTNativeUnifiedVideoView) {
            ((GDTNativeUnifiedVideoView) bVar).setVideoOnClickListener(new h(this));
        }
        viewGroup.removeAllViews();
        viewGroup.addView(bVar);
        nativeUnifiedADData2.setNativeAdEventListener(a(nativeUnifiedADData2, str, (FunAdInteractionListener) null, new i(this, bVar, nativeUnifiedADData2)));
        bVar.a(activity, nativeUnifiedADData2);
        return true;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, java.lang.String, com.fun.ad.sdk.FunNativeAdInflater, java.lang.Object] */
    @Override // a.a.a.a.b
    public boolean a(Activity activity, String str, FunNativeAdInflater funNativeAdInflater, NativeUnifiedADData nativeUnifiedADData) {
        NativeUnifiedADData nativeUnifiedADData2 = nativeUnifiedADData;
        MediaView mediaView = nativeUnifiedADData2.getAdPatternType() == 2 ? new MediaView(activity) : null;
        a.a.a.a.r.b.b.a aVar = new a.a.a.a.r.b.b.a(nativeUnifiedADData2, mediaView, str, this);
        NativeAdContainer gdtAdContainer = funNativeAdInflater.getGdtAdContainer(aVar);
        List<View> clickViews = funNativeAdInflater.getClickViews();
        if (clickViews == null) {
            clickViews = new ArrayList<>();
        }
        nativeUnifiedADData2.setNativeAdEventListener(a(nativeUnifiedADData2, str, (FunAdInteractionListener) null, new j(this, aVar, nativeUnifiedADData2)));
        nativeUnifiedADData2.bindAdToView(gdtAdContainer.getContext(), gdtAdContainer, null, clickViews);
        if (mediaView != null) {
            nativeUnifiedADData2.bindMediaView(mediaView, new VideoOption.Builder().setAutoPlayPolicy(FunAdSdk.getFunAdConfig().isVideoDataFlowAutoStart ? 1 : 0).setAutoPlayMuted(!FunAdSdk.getFunAdConfig().isVideoSoundEnable).setDetailPageMuted(false).setNeedCoverImage(true).setNeedProgressBar(true).setEnableDetailPage(false).setEnableUserControl(false).build(), new b());
        }
        return true;
    }
}
