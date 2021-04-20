package a.a.a.a.r.b.c;

import a.a.a.a.r.a.d.b;
import a.a.a.a.v.f.g.d;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.fun.ad.sdk.ChannelNativeAds_5;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunNativeAd;
import com.win.opensdk.PBNative;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a implements FunNativeAd {

    /* renamed from: a  reason: collision with root package name */
    public final PBNative f1279a;

    /* renamed from: b  reason: collision with root package name */
    public final String f1280b;

    /* renamed from: c  reason: collision with root package name */
    public final b f1281c;

    /* renamed from: d  reason: collision with root package name */
    public final d f1282d;

    public a(PBNative pBNative, String str, b bVar) {
        this.f1279a = pBNative;
        this.f1280b = str;
        this.f1281c = bVar;
        this.f1282d = new d.b(str);
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public ChannelNativeAds_5 getChannelNativeAds_5() {
        return ChannelNativeAds_5.create(this.f1279a);
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getDescription() {
        return this.f1279a.getBody();
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getIconUrl() {
        return this.f1279a.getIcon();
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public List<String> getImageUrls() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f1279a.getIM());
        return arrayList;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public FunNativeAd.InteractionType getInteractionType() {
        return this.f1279a.isD() ? FunNativeAd.InteractionType.TYPE_DOWNLOAD : FunNativeAd.InteractionType.TYPE_BROWSE;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getTitle() {
        return this.f1279a.getHeadline();
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public View getVideoView() {
        return null;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public void show(Context context, ViewGroup viewGroup, List<View> list, List<View> list2, FunAdInteractionListener funAdInteractionListener) {
        if (context != null && viewGroup != null && list != null) {
            this.f1282d.a("ldr_sh_start");
            b bVar = this.f1281c;
            PBNative pBNative = this.f1279a;
            String str = this.f1280b;
            bVar.f1010g.g();
            pBNative.registerViewForInteraction(viewGroup, null, list);
            synchronized (bVar.m) {
                bVar.m.put(pBNative, new b.C0002b(str, funAdInteractionListener));
            }
            return;
        }
        throw new IllegalArgumentException();
    }
}
