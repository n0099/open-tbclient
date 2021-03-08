package a.a.a.a.r.a.d;

import a.a.a.a.a.e;
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
/* loaded from: classes4.dex */
public class g extends a.a.a.a.c<NativeUnifiedADData> {
    public final HashMap<NativeUnifiedADData, c> m;

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class c implements NativeADEventListener {
        public d AG;
        public final FunAdInteractionListener Aa;

        /* renamed from: a  reason: collision with root package name */
        public final NativeUnifiedADData f985a;
        public final String b;
        public boolean d;
        public boolean e;

        public c(NativeUnifiedADData nativeUnifiedADData, String str, FunAdInteractionListener funAdInteractionListener) {
            this.f985a = nativeUnifiedADData;
            this.b = str;
            this.Aa = funAdInteractionListener;
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADClicked() {
            a.a.a.a.v.d.a();
            g.this.zk.a(this.e);
            this.e = true;
            g.this.e();
            FunAdInteractionListener funAdInteractionListener = this.Aa;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdClicked(this.b);
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADError(AdError adError) {
            a.a.a.a.v.d.a();
            g.this.zk.b(Integer.valueOf(adError.getErrorCode()));
            g.this.a(adError.getErrorCode(), adError.getErrorMsg());
            FunAdInteractionListener funAdInteractionListener = this.Aa;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdError(this.b);
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADExposed() {
            a.a.a.a.v.d.a();
            g.this.zk.b(this.d);
            this.d = true;
            g.this.a((g) this.f985a, this.b);
            FunAdInteractionListener funAdInteractionListener = this.Aa;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdShow(this.b);
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADStatusChanged() {
            a.a.a.a.v.d.a();
            d dVar = this.AG;
            if (dVar != null) {
                dVar.onADStatusChanged();
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void onADStatusChanged();
    }

    public g(e.a aVar) {
        super(aVar, true, true);
        this.m = new HashMap<>();
    }

    @Override // a.a.a.a.c
    public a.a.a.a.c.a a(e.a aVar) {
        return new a.a.a.a.c.h(aVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public FunNativeAd a(Context context, String str, NativeUnifiedADData nativeUnifiedADData) {
        NativeUnifiedADData nativeUnifiedADData2 = nativeUnifiedADData;
        return new a.a.a.a.r.b.c.a(nativeUnifiedADData2, nativeUnifiedADData2.getAdPatternType() == 2 ? new MediaView(context) : null, str, this);
    }

    public final NativeADEventListener a(NativeUnifiedADData nativeUnifiedADData, String str, FunAdInteractionListener funAdInteractionListener, d dVar) {
        c cVar;
        synchronized (this.m) {
            cVar = this.m.get(nativeUnifiedADData);
            if (cVar != null) {
                cVar.AG = dVar;
            } else {
                cVar = new c(nativeUnifiedADData, str, funAdInteractionListener);
                cVar.AG = dVar;
                this.m.put(nativeUnifiedADData, cVar);
            }
        }
        return cVar;
    }

    @Override // a.a.a.a.c
    public void a(Context context, FunAdSlot funAdSlot) {
        a aVar = new a(funAdSlot);
        this.zk.a(funAdSlot, this.zl);
        NativeUnifiedAD nativeUnifiedAD = new NativeUnifiedAD(context.getApplicationContext(), this.zl.c, aVar);
        nativeUnifiedAD.setMinVideoDuration(0);
        nativeUnifiedAD.setMaxVideoDuration(0);
        nativeUnifiedAD.setVideoPlayPolicy(1);
        nativeUnifiedAD.setVideoADContainerRender(1);
        nativeUnifiedAD.loadData(1);
        g();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.c
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
    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, NativeUnifiedADData nativeUnifiedADData) {
        int i;
        NativeUnifiedADData nativeUnifiedADData2 = nativeUnifiedADData;
        switch (nativeUnifiedADData2.getAdPatternType()) {
            case 1:
                i = R.layout.gdt_ad_native_unified_img2_view;
                break;
            case 2:
                i = R.layout.gdt_ad_native_unified_video_view;
                break;
            case 3:
                if (nativeUnifiedADData2.getImgList().size() == 3) {
                    i = R.layout.gdt_ad_native_unified_img3_view;
                    break;
                }
            case 4:
                i = R.layout.gdt_ad_native_unified_img_view;
                break;
            default:
                return false;
        }
        this.zk.g();
        a.a.a.a.r.b.c.b bVar = (a.a.a.a.r.b.c.b) LayoutInflater.from(activity).inflate(i, viewGroup, false);
        if (bVar instanceof GDTNativeUnifiedVideoView) {
            ((GDTNativeUnifiedVideoView) bVar).setVideoOnClickListener(new h(this));
        }
        viewGroup.removeAllViews();
        viewGroup.addView(bVar);
        nativeUnifiedADData2.setNativeAdEventListener(a(nativeUnifiedADData2, str, (FunAdInteractionListener) null, new i(this, bVar, nativeUnifiedADData2)));
        bVar.a(activity, nativeUnifiedADData2);
        return true;
    }

    /* loaded from: classes4.dex */
    public class a implements NativeADUnifiedListener {
        public final /* synthetic */ FunAdSlot zR;

        public a(FunAdSlot funAdSlot) {
            this.zR = funAdSlot;
        }

        @Override // com.qq.e.ads.AbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            a.a.a.a.v.d.b("onError code: " + adError.getErrorCode() + ", message: " + adError.getErrorMsg(), new Object[0]);
            g.this.zk.a(Integer.valueOf(adError.getErrorCode()));
            g.this.b(adError.getErrorCode(), adError.getErrorMsg());
        }

        @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
        public void onADLoaded(List<NativeUnifiedADData> list) {
            a.a.a.a.v.d.a();
            if (list != null && !list.isEmpty()) {
                g.this.zk.b();
                NativeUnifiedADData nativeUnifiedADData = list.get(0);
                g gVar = g.this;
                gVar.a((g) nativeUnifiedADData);
                gVar.h();
                g.this.zm.b(nativeUnifiedADData, this.zR.getSid());
                return;
            }
            a.a.a.a.v.d.b("onADLoaded error: adList is null or empty", new Object[0]);
            g.this.zk.a("NoFill");
            g.this.b(0, "NoFill");
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, java.lang.String, com.fun.ad.sdk.FunNativeAdInflater, java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean a(Activity activity, String str, FunNativeAdInflater funNativeAdInflater, NativeUnifiedADData nativeUnifiedADData) {
        NativeUnifiedADData nativeUnifiedADData2 = nativeUnifiedADData;
        MediaView mediaView = nativeUnifiedADData2.getAdPatternType() == 2 ? new MediaView(activity) : null;
        a.a.a.a.r.b.c.a aVar = new a.a.a.a.r.b.c.a(nativeUnifiedADData2, mediaView, str, this);
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
