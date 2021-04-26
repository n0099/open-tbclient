package a.a.a.a.t.b.c;

import a.a.a.a.b;
import a.a.a.a.t.a.d.b;
import a.a.a.a.x.f.g.c;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.fun.ad.sdk.ChannelNativeAds_6;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunNativeAd;
import com.win.opensdk.PBNative;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends b {

    /* renamed from: c  reason: collision with root package name */
    public final PBNative f1297c;

    /* renamed from: d  reason: collision with root package name */
    public final a.a.a.a.t.a.d.b f1298d;

    public a(PBNative pBNative, String str, a.a.a.a.t.a.d.b bVar) {
        super(str);
        this.f1297c = pBNative;
        this.f1298d = bVar;
    }

    @Override // a.a.a.a.b
    public void a(Context context, ViewGroup viewGroup, List<View> list, List<View> list2, FunAdInteractionListener funAdInteractionListener) {
        a.a.a.a.t.a.d.b bVar = this.f1298d;
        PBNative pBNative = this.f1297c;
        String str = this.f1004a;
        synchronized (bVar.m) {
            b.C0002b c0002b = bVar.m.get(pBNative);
            if (c0002b == null) {
                c0002b = new b.C0002b(str);
                bVar.m.put(pBNative, c0002b);
            }
            c cVar = bVar.f1013g;
            c.a("ad", cVar.f1393a, "sh_start", c0002b.f1229b, new Object[0]);
            c0002b.f1229b = true;
            c0002b.f1230c = funAdInteractionListener;
        }
        pBNative.registerViewForInteraction(viewGroup, null, list);
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public ChannelNativeAds_6 getChannelNativeAds_6() {
        return ChannelNativeAds_6.create(this.f1297c);
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getDescription() {
        return this.f1297c.getBody();
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getIconUrl() {
        return this.f1297c.getIcon();
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public List<String> getImageUrls() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f1297c.getIM());
        return arrayList;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public FunNativeAd.InteractionType getInteractionType() {
        return this.f1297c.isD() ? FunNativeAd.InteractionType.TYPE_DOWNLOAD : FunNativeAd.InteractionType.TYPE_BROWSE;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getTitle() {
        return this.f1297c.getHeadline();
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public View getVideoView() {
        return null;
    }
}
