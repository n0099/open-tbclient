package a.a.a.a.r.b.b;

import a.a.a.a.r.a.c.g;
import a.a.a.a.r.a.c.k;
import a.a.a.a.v.f.g.d;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.fun.ad.sdk.ChannelNativeAds_5;
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
public class a implements FunNativeAd {

    /* renamed from: a  reason: collision with root package name */
    public final NativeUnifiedADData f1270a;

    /* renamed from: b  reason: collision with root package name */
    public final ChannelNativeAds_5 f1271b;

    /* renamed from: c  reason: collision with root package name */
    public final MediaView f1272c;

    /* renamed from: d  reason: collision with root package name */
    public final String f1273d;

    /* renamed from: e  reason: collision with root package name */
    public final g f1274e;

    /* renamed from: f  reason: collision with root package name */
    public final d f1275f;

    public a(NativeUnifiedADData nativeUnifiedADData, MediaView mediaView, String str, g gVar) {
        this.f1270a = nativeUnifiedADData;
        this.f1272c = mediaView;
        this.f1271b = ChannelNativeAds_5.create(nativeUnifiedADData);
        this.f1273d = str;
        this.f1274e = gVar;
        this.f1275f = new d.b(str);
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public ChannelNativeAds_5 getChannelNativeAds_5() {
        return this.f1271b;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getDescription() {
        return this.f1270a.getDesc();
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getIconUrl() {
        return this.f1270a.getIconUrl();
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public List<String> getImageUrls() {
        String imgUrl;
        List<String> imgList = this.f1270a.getImgList();
        if (imgList == null) {
            imgList = new ArrayList<>();
        }
        if (imgList.isEmpty() && (imgUrl = this.f1270a.getImgUrl()) != null) {
            imgList.add(imgUrl);
        }
        return imgList;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public FunNativeAd.InteractionType getInteractionType() {
        if (this.f1270a.isAppAd()) {
            int appStatus = this.f1270a.getAppStatus();
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
        return this.f1270a.getTitle();
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public View getVideoView() {
        return this.f1272c;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public void show(Context context, ViewGroup viewGroup, List<View> list, List<View> list2, FunAdInteractionListener funAdInteractionListener) {
        if (context == null || viewGroup == null || list == null) {
            throw new IllegalArgumentException();
        }
        if (!(viewGroup instanceof NativeAdContainer)) {
            a.a.a.a.v.d.b("adContainer must derive from com.qq.e.ads.nativ.widgetNativeAdContainer", new Object[0]);
            if (FunAdSdk.isLogEnabled()) {
                throw new IllegalArgumentException("adContainer must derive from com.qq.e.ads.nativ.widgetNativeAdContainer");
            }
            return;
        }
        this.f1275f.a("ldr_sh_start");
        g gVar = this.f1274e;
        NativeUnifiedADData nativeUnifiedADData = this.f1270a;
        String str = this.f1273d;
        NativeAdContainer nativeAdContainer = (NativeAdContainer) viewGroup;
        MediaView mediaView = this.f1272c;
        ChannelNativeAds_5.GdtADStatusChangeListener gdtADStatusChangeListener = this.f1271b.getGdtADStatusChangeListener();
        gVar.f1010g.g();
        nativeUnifiedADData.setNativeAdEventListener(gVar.a(nativeUnifiedADData, str, funAdInteractionListener, new k(gVar, gdtADStatusChangeListener, nativeUnifiedADData)));
        nativeUnifiedADData.bindAdToView(nativeAdContainer.getContext(), nativeAdContainer, null, list);
        if (mediaView != null) {
            nativeUnifiedADData.bindMediaView(mediaView, new VideoOption.Builder().setAutoPlayPolicy(FunAdSdk.getFunAdConfig().isVideoDataFlowAutoStart ? 1 : 0).setAutoPlayMuted(!FunAdSdk.getFunAdConfig().isVideoSoundEnable).setDetailPageMuted(false).setNeedCoverImage(true).setNeedProgressBar(true).setEnableDetailPage(false).setEnableUserControl(false).build(), new g.b());
        }
    }
}
