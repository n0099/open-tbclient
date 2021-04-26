package a.a.a.a.t.a.b;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeAd;
/* loaded from: classes.dex */
public class e implements TTNativeAd.AdInteractionListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1110a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1111b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TTNativeAd f1112c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1113d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ d f1114e;

    public e(d dVar, TTNativeAd tTNativeAd, String str) {
        this.f1114e = dVar;
        this.f1112c = tTNativeAd;
        this.f1113d = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdClicked(View view, TTNativeAd tTNativeAd) {
        a.a.a.a.x.d.a();
        this.f1114e.f1013g.a(this.f1111b);
        this.f1111b = true;
        this.f1114e.e();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
        a.a.a.a.x.d.a();
        this.f1114e.f1013g.a(this.f1111b);
        this.f1111b = true;
        this.f1114e.e();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdShow(TTNativeAd tTNativeAd) {
        a.a.a.a.x.d.a();
        this.f1114e.f1013g.b(this.f1110a);
        this.f1110a = true;
        this.f1114e.a((d) this.f1112c, this.f1113d);
    }
}
