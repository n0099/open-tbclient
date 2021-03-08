package a.a.a.a.r.b.c;

import a.a.a.a.r.a.d.g;
import a.a.a.a.r.a.d.k;
import a.a.a.a.v.d;
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
/* loaded from: classes4.dex */
public class a implements FunNativeAd {
    public final MediaView BA;
    public final g BB;
    public final ChannelNativeAds_5 Bz;

    /* renamed from: a  reason: collision with root package name */
    public final NativeUnifiedADData f1002a;
    public final String d;

    public a(NativeUnifiedADData nativeUnifiedADData, MediaView mediaView, String str, g gVar) {
        this.f1002a = nativeUnifiedADData;
        this.BA = mediaView;
        this.Bz = ChannelNativeAds_5.create(nativeUnifiedADData);
        this.d = str;
        this.BB = gVar;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public ChannelNativeAds_5 getChannelNativeAds_5() {
        return this.Bz;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getDescription() {
        return this.f1002a.getDesc();
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getIconUrl() {
        return this.f1002a.getIconUrl();
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public List<String> getImageUrls() {
        String imgUrl;
        List<String> imgList = this.f1002a.getImgList();
        if (imgList == null) {
            imgList = new ArrayList<>();
        }
        if (imgList.isEmpty() && (imgUrl = this.f1002a.getImgUrl()) != null) {
            imgList.add(imgUrl);
        }
        return imgList;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public FunNativeAd.InteractionType getInteractionType() {
        if (this.f1002a.isAppAd()) {
            int appStatus = this.f1002a.getAppStatus();
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
        return this.f1002a.getTitle();
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public View getVideoView() {
        return this.BA;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public void show(Context context, ViewGroup viewGroup, List<View> list, List<View> list2, FunAdInteractionListener funAdInteractionListener) {
        if (context == null || viewGroup == null || list == null) {
            throw new IllegalArgumentException();
        }
        if (!(viewGroup instanceof NativeAdContainer)) {
            d.b("adContainer must derive from com.qq.e.ads.nativ.widgetNativeAdContainer", new Object[0]);
            if (FunAdSdk.isLogEnabled()) {
                throw new IllegalArgumentException("adContainer must derive from com.qq.e.ads.nativ.widgetNativeAdContainer");
            }
            return;
        }
        g gVar = this.BB;
        NativeUnifiedADData nativeUnifiedADData = this.f1002a;
        String str = this.d;
        NativeAdContainer nativeAdContainer = (NativeAdContainer) viewGroup;
        MediaView mediaView = this.BA;
        ChannelNativeAds_5.GdtADStatusChangeListener gdtADStatusChangeListener = this.Bz.getGdtADStatusChangeListener();
        gVar.zk.g();
        nativeUnifiedADData.setNativeAdEventListener(gVar.a(nativeUnifiedADData, str, funAdInteractionListener, new k(gVar, gdtADStatusChangeListener, nativeUnifiedADData)));
        nativeUnifiedADData.bindAdToView(nativeAdContainer.getContext(), nativeAdContainer, null, list);
        if (mediaView != null) {
            nativeUnifiedADData.bindMediaView(mediaView, new VideoOption.Builder().setAutoPlayPolicy(FunAdSdk.getFunAdConfig().isVideoDataFlowAutoStart ? 1 : 0).setAutoPlayMuted(!FunAdSdk.getFunAdConfig().isVideoSoundEnable).setDetailPageMuted(false).setNeedCoverImage(true).setNeedProgressBar(true).setEnableDetailPage(false).setEnableUserControl(false).build(), new g.b());
        }
    }
}
