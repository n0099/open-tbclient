package a.a.a.a.r.b.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.nativecpu.IBasicCPUData;
import com.fun.ad.sdk.ChannelNativeAds_5;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunNativeAd;
import java.util.List;
/* loaded from: classes4.dex */
public class c implements FunNativeAd {
    public final a.a.a.a.r.a.a.a Bw;
    public final String b;
    public final IBasicCPUData zT;

    public c(IBasicCPUData iBasicCPUData, String str, a.a.a.a.r.a.a.a aVar) {
        this.zT = iBasicCPUData;
        this.b = str;
        this.Bw = aVar;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public ChannelNativeAds_5 getChannelNativeAds_5() {
        return ChannelNativeAds_5.create(this.zT);
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getDescription() {
        return this.zT.getDesc();
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getIconUrl() {
        return this.zT.getIconUrl();
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public List<String> getImageUrls() {
        return this.zT.getImageUrls();
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public FunNativeAd.InteractionType getInteractionType() {
        return this.zT.isDownloadApp() ? FunNativeAd.InteractionType.TYPE_DOWNLOAD : FunNativeAd.InteractionType.TYPE_BROWSE;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getTitle() {
        return this.zT.getBrandName();
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public View getVideoView() {
        return null;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public void show(Context context, ViewGroup viewGroup, List<View> list, List<View> list2, FunAdInteractionListener funAdInteractionListener) {
        if (context != null && viewGroup != null && list != null && funAdInteractionListener != null) {
            a.a.a.a.r.a.a.a aVar = this.Bw;
            IBasicCPUData iBasicCPUData = this.zT;
            String str = this.b;
            aVar.zk.g();
            a.a.a.a.r.a.a.c cVar = new a.a.a.a.r.a.a.c(aVar, iBasicCPUData, funAdInteractionListener, str);
            for (View view : list) {
                view.setOnClickListener(cVar);
            }
            aVar.a((a.a.a.a.r.a.a.a) iBasicCPUData, str);
            iBasicCPUData.onImpression(viewGroup);
            aVar.zk.b(false);
            funAdInteractionListener.onAdShow(str);
            return;
        }
        throw new IllegalArgumentException();
    }
}
