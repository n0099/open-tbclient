package a.a.a.a.r.b.e;

import a.a.a.a.r.a.f.g;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.fun.ad.sdk.ChannelNativeAds_5;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunNativeAd;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements FunNativeAd {
    public final KsNativeAd BE;
    public final g BF;

    /* renamed from: a  reason: collision with root package name */
    public final Context f1004a;
    public final String c;

    public a(Context context, KsNativeAd ksNativeAd, String str, g gVar) {
        this.f1004a = context;
        this.BE = ksNativeAd;
        this.c = str;
        this.BF = gVar;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public ChannelNativeAds_5 getChannelNativeAds_5() {
        return ChannelNativeAds_5.create(this.BE);
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getDescription() {
        return this.BE.getAdDescription();
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getIconUrl() {
        return this.BE.getAppIconUrl();
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public List<String> getImageUrls() {
        List<KsImage> imageList = this.BE.getImageList();
        if (imageList == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (KsImage ksImage : imageList) {
            arrayList.add(ksImage.getImageUrl());
        }
        return arrayList;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public FunNativeAd.InteractionType getInteractionType() {
        int interactionType = this.BE.getInteractionType();
        return interactionType != 1 ? interactionType != 2 ? FunNativeAd.InteractionType.TYPE_UNKNOW : FunNativeAd.InteractionType.TYPE_BROWSE : FunNativeAd.InteractionType.TYPE_DOWNLOAD;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getTitle() {
        return this.BE.getAppName();
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public View getVideoView() {
        return this.BE.getVideoView(this.f1004a, new KsAdVideoPlayConfig.Builder().videoSoundEnable(FunAdSdk.getFunAdConfig().isVideoSoundEnable).dataFlowAutoStart(FunAdSdk.getFunAdConfig().isVideoDataFlowAutoStart).build());
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public void show(Context context, ViewGroup viewGroup, List<View> list, List<View> list2, FunAdInteractionListener funAdInteractionListener) {
        if (context != null && viewGroup != null && list != null) {
            g gVar = this.BF;
            KsNativeAd ksNativeAd = this.BE;
            String str = this.c;
            gVar.zk.g();
            ksNativeAd.registerViewForInteraction(viewGroup, list, gVar.a(ksNativeAd, str, funAdInteractionListener));
            return;
        }
        throw new IllegalArgumentException();
    }
}
