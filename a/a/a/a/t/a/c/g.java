package a.a.a.a.t.a.c;

import a.a.a.a.u.e;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import java.util.List;
/* loaded from: classes.dex */
public class g extends a.a.a.a.c<NativeUnifiedADData> {
    public final a.a.a.a.k<NativeUnifiedADData, NativeADEventListener> m;

    /* loaded from: classes.dex */
    public class a implements NativeADUnifiedListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1183a;

        public a(FunAdSlot funAdSlot) {
            this.f1183a = funAdSlot;
        }

        @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
        public void onADLoaded(List<NativeUnifiedADData> list) {
            a.a.a.a.x.d.a();
            if (list != null && !list.isEmpty()) {
                g.this.f1013g.b();
                NativeUnifiedADData nativeUnifiedADData = list.get(0);
                g gVar = g.this;
                gVar.a((g) nativeUnifiedADData);
                gVar.h();
                g.this.k.b(nativeUnifiedADData, this.f1183a.getSid());
                return;
            }
            a.a.a.a.x.d.b("onADLoaded error: adList is null or empty", new Object[0]);
            g.this.f1013g.a("NoFill");
            g.this.b(0, "NoFill");
        }

        @Override // com.qq.e.ads.AbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            a.a.a.a.x.d.b("onError code: " + adError.getErrorCode() + ", message: " + adError.getErrorMsg(), new Object[0]);
            g.this.f1013g.a(Integer.valueOf(adError.getErrorCode()));
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
        public void onVideoLoaded(int i2) {
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
        public final NativeUnifiedADData f1185a;

        /* renamed from: b  reason: collision with root package name */
        public final String f1186b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f1187c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f1188d;

        /* renamed from: e  reason: collision with root package name */
        public d f1189e;

        public c(NativeUnifiedADData nativeUnifiedADData, String str) {
            this.f1185a = nativeUnifiedADData;
            this.f1186b = str;
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADClicked() {
            a.a.a.a.x.d.a();
            g.this.f1013g.a(this.f1188d);
            this.f1188d = true;
            g.this.e();
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADError(AdError adError) {
            a.a.a.a.x.d.a();
            g.this.f1013g.b(Integer.valueOf(adError.getErrorCode()));
            g.this.a(adError.getErrorCode(), adError.getErrorMsg());
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADExposed() {
            a.a.a.a.x.d.a();
            g.this.f1013g.b(this.f1187c);
            this.f1187c = true;
            g.this.a((g) this.f1185a, this.f1186b);
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADStatusChanged() {
            a.a.a.a.x.d.a();
            d dVar = this.f1189e;
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
        this.m = new a.a.a.a.k<>(this);
    }

    @Override // a.a.a.a.c
    public a.a.a.a.w.a a(e.a aVar) {
        return new a.a.a.a.w.h(aVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public FunNativeAd a(Context context, String str, NativeUnifiedADData nativeUnifiedADData) {
        NativeUnifiedADData nativeUnifiedADData2 = nativeUnifiedADData;
        return new a.a.a.a.t.b.b.a(nativeUnifiedADData2, nativeUnifiedADData2.getAdPatternType() == 2 ? new MediaView(context) : null, str, this);
    }

    @Override // a.a.a.a.c
    public void b(Context context, FunAdSlot funAdSlot) {
        a aVar = new a(funAdSlot);
        this.f1013g.a(funAdSlot, this.f1014h);
        NativeUnifiedAD nativeUnifiedAD = new NativeUnifiedAD(context.getApplicationContext(), this.f1014h.f1334c, aVar);
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
            this.m.a(nativeUnifiedADData2);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, NativeUnifiedADData nativeUnifiedADData) {
        int i2;
        NativeUnifiedADData nativeUnifiedADData2 = nativeUnifiedADData;
        int adPatternType = nativeUnifiedADData2.getAdPatternType();
        if (adPatternType == 1) {
            i2 = R.layout.gdt_ad_native_unified_img2_view;
        } else if (adPatternType != 2) {
            if (adPatternType != 3) {
                if (adPatternType != 4) {
                    return false;
                }
            } else if (nativeUnifiedADData2.getImgList().size() == 3) {
                i2 = R.layout.gdt_ad_native_unified_img3_view;
            }
            i2 = R.layout.gdt_ad_native_unified_img_view;
        } else {
            i2 = R.layout.gdt_ad_native_unified_video_view;
        }
        this.f1013g.g();
        a.a.a.a.t.b.b.b bVar = (a.a.a.a.t.b.b.b) LayoutInflater.from(activity).inflate(i2, viewGroup, false);
        if (bVar instanceof GDTNativeUnifiedVideoView) {
            ((GDTNativeUnifiedVideoView) bVar).setVideoOnClickListener(new h(this));
        }
        viewGroup.removeAllViews();
        viewGroup.addView(bVar);
        i iVar = new i(this, bVar, nativeUnifiedADData2);
        c cVar = new c(nativeUnifiedADData2, str);
        cVar.f1189e = iVar;
        nativeUnifiedADData2.setNativeAdEventListener(cVar);
        bVar.a(activity, nativeUnifiedADData2);
        return true;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, java.lang.String, com.fun.ad.sdk.FunNativeAdInflater, java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean a(Activity activity, String str, FunNativeAdInflater funNativeAdInflater, NativeUnifiedADData nativeUnifiedADData) {
        NativeUnifiedADData nativeUnifiedADData2 = nativeUnifiedADData;
        MediaView mediaView = nativeUnifiedADData2.getAdPatternType() == 2 ? new MediaView(activity) : null;
        a.a.a.a.t.b.b.a aVar = new a.a.a.a.t.b.b.a(nativeUnifiedADData2, mediaView, str, this);
        NativeAdContainer gdtAdContainer = funNativeAdInflater.getGdtAdContainer(aVar);
        List<View> clickViews = funNativeAdInflater.getClickViews();
        if (clickViews == null) {
            clickViews = new ArrayList<>();
        }
        j jVar = new j(this, aVar, nativeUnifiedADData2);
        c cVar = new c(nativeUnifiedADData2, str);
        cVar.f1189e = jVar;
        nativeUnifiedADData2.setNativeAdEventListener(cVar);
        nativeUnifiedADData2.bindAdToView(gdtAdContainer.getContext(), gdtAdContainer, null, clickViews);
        if (mediaView != null) {
            nativeUnifiedADData2.bindMediaView(mediaView, new VideoOption.Builder().setAutoPlayPolicy(FunAdSdk.getFunAdConfig().isVideoDataFlowAutoStart ? 1 : 0).setAutoPlayMuted(!FunAdSdk.getFunAdConfig().isVideoSoundEnable).setDetailPageMuted(false).setNeedCoverImage(true).setNeedProgressBar(true).setEnableDetailPage(false).setEnableUserControl(false).build(), new b());
        }
        return true;
    }
}
