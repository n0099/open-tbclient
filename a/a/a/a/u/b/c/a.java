package a.a.a.a.u.b.c;

import a.a.a.a.b;
import a.a.a.a.u.a.d.b;
import a.a.a.a.y.f.g.c;
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
    public final PBNative f1305c;

    /* renamed from: d  reason: collision with root package name */
    public final a.a.a.a.u.a.d.b f1306d;

    public a(PBNative pBNative, String str, a.a.a.a.u.a.d.b bVar) {
        super(str);
        this.f1305c = pBNative;
        this.f1306d = bVar;
    }

    @Override // a.a.a.a.b
    public void a(Context context, ViewGroup viewGroup, List<View> list, List<View> list2, FunAdInteractionListener funAdInteractionListener) {
        a.a.a.a.u.a.d.b bVar = this.f1306d;
        PBNative pBNative = this.f1305c;
        String str = this.f1004a;
        synchronized (bVar.n) {
            b.C0002b c0002b = bVar.n.get(pBNative);
            if (c0002b == null) {
                c0002b = new b.C0002b(str);
                bVar.n.put(pBNative, c0002b);
            }
            c.a(c0002b.f1232b, bVar.f1014h.f1406a, "sh_start", new Object[0]);
            c0002b.f1232b = true;
            c0002b.f1233c = funAdInteractionListener;
        }
        pBNative.registerViewForInteraction(viewGroup, null, list);
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public ChannelNativeAds_6 getChannelNativeAds_6() {
        return ChannelNativeAds_6.create(this.f1305c);
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getDescription() {
        return this.f1305c.getBody();
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getIconUrl() {
        return this.f1305c.getIcon();
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public List<String> getImageUrls() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f1305c.getIM());
        return arrayList;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public FunNativeAd.InteractionType getInteractionType() {
        return this.f1305c.isD() ? FunNativeAd.InteractionType.TYPE_DOWNLOAD : FunNativeAd.InteractionType.TYPE_BROWSE;
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public String getTitle() {
        return this.f1305c.getHeadline();
    }

    @Override // com.fun.ad.sdk.FunNativeAd
    public View getVideoView() {
        return null;
    }
}
