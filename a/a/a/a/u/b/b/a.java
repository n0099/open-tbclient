package a.a.a.a.u.b.b;

import a.a.a.a.u.a.c.g;
import a.a.a.a.u.a.c.k;
import a.a.a.a.y.f.g.d;
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
    public final NativeUnifiedADData f1297c;

    /* renamed from: d  reason: collision with root package name */
    public final ChannelNativeAds_6 f1298d;

    /* renamed from: e  reason: collision with root package name */
    public final MediaView f1299e;

    /* renamed from: f  reason: collision with root package name */
    public final g f1300f;

    /* renamed from: g  reason: collision with root package name */
    public final d f1301g;

    public a(NativeUnifiedADData nativeUnifiedADData, MediaView mediaView, String str, g gVar) {
        super(str);
        this.f1297c = nativeUnifiedADData;
        this.f1299e = mediaView;
        this.f1298d = ChannelNativeAds_6.create(nativeUnifiedADData);
        this.f1300f = gVar;
        this.f1301g = new d.b(this.f1004a);
    }

    @Override // a.a.a.a.b
    public void a(Context context, ViewGroup viewGroup, List<View> list, List<View> list2, FunAdInteractionListener funAdInteractionListener) {
        if (!(viewGroup instanceof NativeAdContainer)) {
            a.a.a.a.y.d.b("adContainer must derive from com.qq.e.ads.nativ.widgetNativeAdContainer", new Object[0]);
            if (FunAdSdk.isLogEnabled()) {
                throw new IllegalArgumentException("adContainer must derive from com.qq.e.ads.nativ.widgetNativeAdContainer");
            }
            return;
        }
        this.f1301g.c();
        g gVar = this.f1300f;
        NativeUnifiedADData nativeUnifiedADData = this.f1297c;
        String str = this.f1004a;
        NativeAdContainer nativeAdContainer = (NativeAdContainer) viewGroup;
        MediaView mediaView = this.f1299e;
        k kVar = new k(gVar, nativeUnifiedADData, str, this.f1298d.getGdtADStatusChangeListener());
        gVar.n.a(nativeUnifiedADData, str, kVar, funAdInteractionListener);
        nativeUnifiedADData.setNativeAdEventListener(kVar);
        nativeUnifiedADData.bindAdToView(nativeAdContainer.getContext(), nativeAdContainer, null, list);
        if (mediaView != null) {
            nativeUnifiedADData.bindMediaView(mediaView, new VideoOption.Builder().setAutoPlayPolicy(FunAdSdk.getFunAdConfig().isVideoDataFlowAutoStart ? 1 : 0).setAutoPlayMuted(!FunAdSdk.getFunAdConfig().isVideoSoundEnable).setDetailPageMuted(false).setNeedCoverImage(true).setNeedProgressBar(true).setEnableDetailPage(false).setEnableUserControl(false).build(), new g.b());
        }
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public ChannelNativeAds_6 getChannelNativeAds_6() {
        return this.f1298d;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getDescription() {
        return this.f1297c.getDesc();
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getIconUrl() {
        return this.f1297c.getIconUrl();
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public List<String> getImageUrls() {
        String imgUrl;
        List<String> imgList = this.f1297c.getImgList();
        if (imgList == null) {
            imgList = new ArrayList<>();
        }
        if (imgList.isEmpty() && (imgUrl = this.f1297c.getImgUrl()) != null) {
            imgList.add(imgUrl);
        }
        return imgList;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public FunNativeAd.InteractionType getInteractionType() {
        if (this.f1297c.isAppAd()) {
            int appStatus = this.f1297c.getAppStatus();
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
        return this.f1297c.getTitle();
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public View getVideoView() {
        return this.f1299e;
    }
}
