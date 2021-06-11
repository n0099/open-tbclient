package a.a.a.a.u.b.a;

import a.a.a.a.u.a.b.d;
import a.a.a.a.u.a.b.f;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.ChannelNativeAds_6;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunNativeAd;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c extends a.a.a.a.b {

    /* renamed from: c  reason: collision with root package name */
    public final TTNativeAd f1295c;

    /* renamed from: d  reason: collision with root package name */
    public final d f1296d;

    public c(TTNativeAd tTNativeAd, String str, d dVar) {
        super(str);
        this.f1295c = tTNativeAd;
        this.f1296d = dVar;
    }

    @Override // a.a.a.a.b
    public void a(Context context, ViewGroup viewGroup, List<View> list, List<View> list2, FunAdInteractionListener funAdInteractionListener) {
        d dVar = this.f1296d;
        TTNativeAd tTNativeAd = this.f1295c;
        String str = this.f1004a;
        f fVar = new f(dVar, tTNativeAd, str);
        dVar.o.a(tTNativeAd, str, fVar, funAdInteractionListener);
        if (context instanceof Activity) {
            tTNativeAd.setActivityForDownloadApp((Activity) context);
        }
        if (list2 == null) {
            list2 = new ArrayList<>();
        }
        tTNativeAd.registerViewForInteraction(viewGroup, list, list2, fVar);
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public ChannelNativeAds_6 getChannelNativeAds_6() {
        return ChannelNativeAds_6.create(this.f1295c);
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getDescription() {
        return this.f1295c.getDescription();
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getIconUrl() {
        TTImage icon = this.f1295c.getIcon();
        if (icon == null) {
            return null;
        }
        return icon.getImageUrl();
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public List<String> getImageUrls() {
        List<TTImage> imageList = this.f1295c.getImageList();
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
        int interactionType = this.f1295c.getInteractionType();
        return (interactionType == 2 || interactionType == 3) ? FunNativeAd.InteractionType.TYPE_BROWSE : interactionType != 4 ? interactionType != 5 ? FunNativeAd.InteractionType.TYPE_UNKNOW : FunNativeAd.InteractionType.TYPE_DIAL : FunNativeAd.InteractionType.TYPE_DOWNLOAD;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getTitle() {
        String source = this.f1295c.getSource();
        return TextUtils.isEmpty(source) ? this.f1295c.getTitle() : source;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public View getVideoView() {
        return this.f1295c.getAdView();
    }
}
