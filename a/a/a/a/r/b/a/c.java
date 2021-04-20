package a.a.a.a.r.b.a;

import a.a.a.a.r.a.b.d;
import a.a.a.a.v.f.g.d;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.ChannelNativeAds_5;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunNativeAd;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c implements FunNativeAd {

    /* renamed from: a  reason: collision with root package name */
    public final TTNativeAd f1266a;

    /* renamed from: b  reason: collision with root package name */
    public final String f1267b;

    /* renamed from: c  reason: collision with root package name */
    public final d f1268c;

    /* renamed from: d  reason: collision with root package name */
    public final a.a.a.a.v.f.g.d f1269d;

    public c(TTNativeAd tTNativeAd, String str, d dVar) {
        this.f1266a = tTNativeAd;
        this.f1267b = str;
        this.f1268c = dVar;
        this.f1269d = new d.b(str);
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public ChannelNativeAds_5 getChannelNativeAds_5() {
        return ChannelNativeAds_5.create(this.f1266a);
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getDescription() {
        return this.f1266a.getDescription();
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getIconUrl() {
        TTImage icon = this.f1266a.getIcon();
        if (icon == null) {
            return null;
        }
        return icon.getImageUrl();
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public List<String> getImageUrls() {
        List<TTImage> imageList = this.f1266a.getImageList();
        if (imageList == null || imageList.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (TTImage tTImage : imageList) {
            arrayList.add(tTImage.getImageUrl());
        }
        return arrayList;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public FunNativeAd.InteractionType getInteractionType() {
        int interactionType = this.f1266a.getInteractionType();
        return (interactionType == 2 || interactionType == 3) ? FunNativeAd.InteractionType.TYPE_BROWSE : interactionType != 4 ? interactionType != 5 ? FunNativeAd.InteractionType.TYPE_UNKNOW : FunNativeAd.InteractionType.TYPE_DIAL : FunNativeAd.InteractionType.TYPE_DOWNLOAD;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getTitle() {
        String source = this.f1266a.getSource();
        return TextUtils.isEmpty(source) ? this.f1266a.getTitle() : source;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public View getVideoView() {
        return this.f1266a.getAdView();
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public void show(Context context, ViewGroup viewGroup, List<View> list, List<View> list2, FunAdInteractionListener funAdInteractionListener) {
        if (context != null && viewGroup != null && list != null) {
            this.f1269d.a("ldr_sh_start");
            a.a.a.a.r.a.b.d dVar = this.f1268c;
            TTNativeAd tTNativeAd = this.f1266a;
            String str = this.f1267b;
            dVar.f1010g.g();
            if (context instanceof Activity) {
                tTNativeAd.setActivityForDownloadApp((Activity) context);
            }
            if (list2 == null) {
                list2 = new ArrayList<>();
            }
            tTNativeAd.registerViewForInteraction(viewGroup, list, list2, dVar.a(tTNativeAd, str, funAdInteractionListener));
            return;
        }
        throw new IllegalArgumentException();
    }
}
