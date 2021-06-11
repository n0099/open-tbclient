package a.a.a.a.u.a.b;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeAd;
/* loaded from: classes.dex */
public class f implements TTNativeAd.AdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TTNativeAd f1118a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f1119b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ d f1120c;

    public f(d dVar, TTNativeAd tTNativeAd, String str) {
        this.f1120c = dVar;
        this.f1118a = tTNativeAd;
        this.f1119b = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdClicked(View view, TTNativeAd tTNativeAd) {
        a.a.a.a.y.d.a();
        this.f1120c.o.b(this.f1118a);
        this.f1120c.e();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
        a.a.a.a.y.d.a();
        this.f1120c.o.b(this.f1118a);
        this.f1120c.e();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdShow(TTNativeAd tTNativeAd) {
        a.a.a.a.y.d.a();
        this.f1120c.o.c(this.f1118a);
        this.f1120c.a((d) this.f1118a, this.f1119b);
    }
}
