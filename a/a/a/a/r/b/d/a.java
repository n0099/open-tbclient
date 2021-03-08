package a.a.a.a.r.b.d;

import a.a.a.a.r.a.e.b;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.fun.ad.sdk.ChannelNativeAds_5;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunNativeAd;
import com.win.opensdk.PBNative;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements FunNativeAd {
    public final PBNative BC;
    public final b BD;
    public final String b;

    public a(PBNative pBNative, String str, b bVar) {
        this.BC = pBNative;
        this.b = str;
        this.BD = bVar;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public ChannelNativeAds_5 getChannelNativeAds_5() {
        return ChannelNativeAds_5.create(this.BC);
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getDescription() {
        return this.BC.getBody();
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getIconUrl() {
        return this.BC.getIcon();
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public List<String> getImageUrls() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.BC.getIM());
        return arrayList;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public FunNativeAd.InteractionType getInteractionType() {
        return this.BC.isD() ? FunNativeAd.InteractionType.TYPE_DOWNLOAD : FunNativeAd.InteractionType.TYPE_BROWSE;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getTitle() {
        return this.BC.getHeadline();
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public View getVideoView() {
        return null;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public void show(Context context, ViewGroup viewGroup, List<View> list, List<View> list2, FunAdInteractionListener funAdInteractionListener) {
        if (context != null && viewGroup != null && list != null) {
            b bVar = this.BD;
            PBNative pBNative = this.BC;
            String str = this.b;
            bVar.zk.g();
            pBNative.registerViewForInteraction(viewGroup, null, list);
            synchronized (bVar.m) {
                bVar.m.put(pBNative, new b.C0003b(str, funAdInteractionListener));
            }
            return;
        }
        throw new IllegalArgumentException();
    }
}
