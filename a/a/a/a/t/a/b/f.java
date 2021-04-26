package a.a.a.a.t.a.b;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeAd;
/* loaded from: classes.dex */
public class f implements TTNativeAd.AdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TTNativeAd f1115a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f1116b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ d f1117c;

    public f(d dVar, TTNativeAd tTNativeAd, String str) {
        this.f1117c = dVar;
        this.f1115a = tTNativeAd;
        this.f1116b = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdClicked(View view, TTNativeAd tTNativeAd) {
        a.a.a.a.x.d.a();
        this.f1117c.n.b(this.f1115a);
        this.f1117c.e();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
        a.a.a.a.x.d.a();
        this.f1117c.n.b(this.f1115a);
        this.f1117c.e();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdShow(TTNativeAd tTNativeAd) {
        a.a.a.a.x.d.a();
        this.f1117c.n.c(this.f1115a);
        this.f1117c.a((d) this.f1115a, this.f1116b);
    }
}
