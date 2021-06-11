package a.a.a.a.u.a.b;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeAd;
/* loaded from: classes.dex */
public class e implements TTNativeAd.AdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1113a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1114b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TTNativeAd f1115c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1116d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ d f1117e;

    public e(d dVar, TTNativeAd tTNativeAd, String str) {
        this.f1117e = dVar;
        this.f1115c = tTNativeAd;
        this.f1116d = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdClicked(View view, TTNativeAd tTNativeAd) {
        a.a.a.a.y.d.a();
        this.f1117e.f1014h.a(this.f1114b);
        this.f1114b = true;
        this.f1117e.e();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
        a.a.a.a.y.d.a();
        this.f1117e.f1014h.a(this.f1114b);
        this.f1114b = true;
        this.f1117e.e();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdShow(TTNativeAd tTNativeAd) {
        a.a.a.a.y.d.a();
        this.f1117e.f1014h.b(this.f1113a);
        this.f1113a = true;
        this.f1117e.a((d) this.f1115c, this.f1116d);
    }
}
