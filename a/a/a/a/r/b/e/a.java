package a.a.a.a.r.b.e;

import a.a.a.a.r.a.f.g;
import a.a.a.a.v.f.g.d;
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
/* loaded from: classes.dex */
public class a implements FunNativeAd {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1297a;

    /* renamed from: b  reason: collision with root package name */
    public final KsNativeAd f1298b;

    /* renamed from: c  reason: collision with root package name */
    public final String f1299c;

    /* renamed from: d  reason: collision with root package name */
    public final g f1300d;

    /* renamed from: e  reason: collision with root package name */
    public final d f1301e;

    public a(Context context, KsNativeAd ksNativeAd, String str, g gVar) {
        this.f1297a = context;
        this.f1298b = ksNativeAd;
        this.f1299c = str;
        this.f1300d = gVar;
        this.f1301e = new d.b(str);
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public ChannelNativeAds_5 getChannelNativeAds_5() {
        return ChannelNativeAds_5.create(this.f1298b);
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getDescription() {
        return this.f1298b.getAdDescription();
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getIconUrl() {
        return this.f1298b.getAppIconUrl();
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public List<String> getImageUrls() {
        List<KsImage> imageList = this.f1298b.getImageList();
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
        int interactionType = this.f1298b.getInteractionType();
        return interactionType != 1 ? interactionType != 2 ? FunNativeAd.InteractionType.TYPE_UNKNOW : FunNativeAd.InteractionType.TYPE_BROWSE : FunNativeAd.InteractionType.TYPE_DOWNLOAD;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getTitle() {
        return this.f1298b.getAppName();
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public View getVideoView() {
        return this.f1298b.getVideoView(this.f1297a, new KsAdVideoPlayConfig.Builder().videoSoundEnable(FunAdSdk.getFunAdConfig().isVideoSoundEnable).dataFlowAutoStart(FunAdSdk.getFunAdConfig().isVideoDataFlowAutoStart).build());
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public void show(Context context, ViewGroup viewGroup, List<View> list, List<View> list2, FunAdInteractionListener funAdInteractionListener) {
        if (context != null && viewGroup != null && list != null) {
            this.f1301e.a("ldr_sh_start");
            g gVar = this.f1300d;
            KsNativeAd ksNativeAd = this.f1298b;
            String str = this.f1299c;
            gVar.f1010g.g();
            ksNativeAd.registerViewForInteraction(viewGroup, list, gVar.a(ksNativeAd, str, funAdInteractionListener));
            return;
        }
        throw new IllegalArgumentException();
    }
}
