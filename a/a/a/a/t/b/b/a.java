package a.a.a.a.t.b.b;

import a.a.a.a.t.a.c.g;
import a.a.a.a.t.a.c.k;
import a.a.a.a.x.f.g.d;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.fun.ad.sdk.ChannelNativeAds_6;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunNativeAd;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends a.a.a.a.b {

    /* renamed from: c  reason: collision with root package name */
    public final NativeUnifiedADData f1289c;

    /* renamed from: d  reason: collision with root package name */
    public final ChannelNativeAds_6 f1290d;

    /* renamed from: e  reason: collision with root package name */
    public final MediaView f1291e;

    /* renamed from: f  reason: collision with root package name */
    public final g f1292f;

    /* renamed from: g  reason: collision with root package name */
    public final d f1293g;

    public a(NativeUnifiedADData nativeUnifiedADData, MediaView mediaView, String str, g gVar) {
        super(str);
        this.f1289c = nativeUnifiedADData;
        this.f1291e = mediaView;
        this.f1290d = ChannelNativeAds_6.create(nativeUnifiedADData);
        this.f1292f = gVar;
        this.f1293g = new d.b(this.f1004a);
    }

    @Override // a.a.a.a.b
    public void a(Context context, ViewGroup viewGroup, List<View> list, List<View> list2, FunAdInteractionListener funAdInteractionListener) {
        if (!(viewGroup instanceof NativeAdContainer)) {
            a.a.a.a.x.d.b("adContainer must derive from com.qq.e.ads.nativ.widgetNativeAdContainer", new Object[0]);
            if (FunAdSdk.isLogEnabled()) {
                throw new IllegalArgumentException("adContainer must derive from com.qq.e.ads.nativ.widgetNativeAdContainer");
            }
            return;
        }
        this.f1293g.c();
        g gVar = this.f1292f;
        NativeUnifiedADData nativeUnifiedADData = this.f1289c;
        String str = this.f1004a;
        NativeAdContainer nativeAdContainer = (NativeAdContainer) viewGroup;
        MediaView mediaView = this.f1291e;
        k kVar = new k(gVar, nativeUnifiedADData, str, this.f1290d.getGdtADStatusChangeListener());
        gVar.m.a(nativeUnifiedADData, str, kVar, funAdInteractionListener);
        nativeUnifiedADData.setNativeAdEventListener(kVar);
        nativeUnifiedADData.bindAdToView(nativeAdContainer.getContext(), nativeAdContainer, null, list);
        if (mediaView != null) {
            nativeUnifiedADData.bindMediaView(mediaView, new VideoOption.Builder().setAutoPlayPolicy(FunAdSdk.getFunAdConfig().isVideoDataFlowAutoStart ? 1 : 0).setAutoPlayMuted(!FunAdSdk.getFunAdConfig().isVideoSoundEnable).setDetailPageMuted(false).setNeedCoverImage(true).setNeedProgressBar(true).setEnableDetailPage(false).setEnableUserControl(false).build(), new g.b());
        }
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public ChannelNativeAds_6 getChannelNativeAds_6() {
        return this.f1290d;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getDescription() {
        return this.f1289c.getDesc();
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getIconUrl() {
        return this.f1289c.getIconUrl();
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public List<String> getImageUrls() {
        String imgUrl;
        List<String> imgList = this.f1289c.getImgList();
        if (imgList == null) {
            imgList = new ArrayList<>();
        }
        if (imgList.isEmpty() && (imgUrl = this.f1289c.getImgUrl()) != null) {
            imgList.add(imgUrl);
        }
        return imgList;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public FunNativeAd.InteractionType getInteractionType() {
        if (this.f1289c.isAppAd()) {
            int appStatus = this.f1289c.getAppStatus();
            if (appStatus != 0) {
                if (appStatus != 1) {
                    if (appStatus != 2 && appStatus != 4) {
                        if (appStatus != 8) {
                            if (appStatus != 16) {
                                return FunNativeAd.InteractionType.TYPE_UNKNOW;
                            }
                        }
                    }
                }
                return FunNativeAd.InteractionType.TYPE_BROWSE;
            }
            return FunNativeAd.InteractionType.TYPE_DOWNLOAD;
        }
        return FunNativeAd.InteractionType.TYPE_BROWSE;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getTitle() {
        return this.f1289c.getTitle();
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public View getVideoView() {
        return this.f1291e;
    }
}
