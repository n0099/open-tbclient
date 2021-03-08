package a.a.a.a.r.b.b;

import a.a.a.a.r.a.c.d;
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
/* loaded from: classes4.dex */
public class c implements FunNativeAd {
    public final TTNativeAd Bx;
    public final d By;
    public final String b;

    public c(TTNativeAd tTNativeAd, String str, d dVar) {
        this.Bx = tTNativeAd;
        this.b = str;
        this.By = dVar;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public ChannelNativeAds_5 getChannelNativeAds_5() {
        return ChannelNativeAds_5.create(this.Bx);
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getDescription() {
        return this.Bx.getDescription();
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getIconUrl() {
        TTImage icon = this.Bx.getIcon();
        if (icon == null) {
            return null;
        }
        return icon.getImageUrl();
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public List<String> getImageUrls() {
        List<TTImage> imageList = this.Bx.getImageList();
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
        switch (this.Bx.getInteractionType()) {
            case 2:
            case 3:
                return FunNativeAd.InteractionType.TYPE_BROWSE;
            case 4:
                return FunNativeAd.InteractionType.TYPE_DOWNLOAD;
            case 5:
                return FunNativeAd.InteractionType.TYPE_DIAL;
            default:
                return FunNativeAd.InteractionType.TYPE_UNKNOW;
        }
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getTitle() {
        String source = this.Bx.getSource();
        return TextUtils.isEmpty(source) ? this.Bx.getTitle() : source;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public View getVideoView() {
        return this.Bx.getAdView();
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public void show(Context context, ViewGroup viewGroup, List<View> list, List<View> list2, FunAdInteractionListener funAdInteractionListener) {
        if (context != null && viewGroup != null && list != null) {
            d dVar = this.By;
            TTNativeAd tTNativeAd = this.Bx;
            String str = this.b;
            dVar.zk.g();
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
