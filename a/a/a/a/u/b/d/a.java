package a.a.a.a.u.b.d;

import a.a.a.a.u.a.e.g;
import a.a.a.a.u.a.e.i;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.fun.ad.sdk.ChannelNativeAds_6;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunNativeAd;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends a.a.a.a.b {

    /* renamed from: c  reason: collision with root package name */
    public final Context f1307c;

    /* renamed from: d  reason: collision with root package name */
    public final KsNativeAd f1308d;

    /* renamed from: e  reason: collision with root package name */
    public final g f1309e;

    public a(Context context, KsNativeAd ksNativeAd, String str, g gVar) {
        super(str);
        this.f1307c = context;
        this.f1308d = ksNativeAd;
        this.f1309e = gVar;
    }

    @Override // a.a.a.a.b
    public void a(Context context, ViewGroup viewGroup, List<View> list, List<View> list2, FunAdInteractionListener funAdInteractionListener) {
        g gVar = this.f1309e;
        KsNativeAd ksNativeAd = this.f1308d;
        String str = this.f1004a;
        i iVar = new i(gVar, ksNativeAd, str);
        gVar.n.a(ksNativeAd, str, iVar, funAdInteractionListener);
        ksNativeAd.registerViewForInteraction(viewGroup, list, iVar);
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public ChannelNativeAds_6 getChannelNativeAds_6() {
        return ChannelNativeAds_6.create(this.f1308d);
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getDescription() {
        return this.f1308d.getAdDescription();
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getIconUrl() {
        return this.f1308d.getAppIconUrl();
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public List<String> getImageUrls() {
        List<KsImage> imageList = this.f1308d.getImageList();
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
        int interactionType = this.f1308d.getInteractionType();
        return interactionType != 1 ? interactionType != 2 ? FunNativeAd.InteractionType.TYPE_UNKNOW : FunNativeAd.InteractionType.TYPE_BROWSE : FunNativeAd.InteractionType.TYPE_DOWNLOAD;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getTitle() {
        return this.f1308d.getAppName();
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public View getVideoView() {
        return this.f1308d.getVideoView(this.f1307c, new KsAdVideoPlayConfig.Builder().videoSoundEnable(FunAdSdk.getFunAdConfig().isVideoSoundEnable).dataFlowAutoStart(FunAdSdk.getFunAdConfig().isVideoDataFlowAutoStart).build());
    }
}
