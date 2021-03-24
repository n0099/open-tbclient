package a.a.a.a.r.a.c;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.TTAdDislike;
/* loaded from: classes.dex */
public class o implements TTAdDislike.DislikeInteractionCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f1143a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ m f1144b;

    public o(m mVar, View view) {
        this.f1144b = mVar;
        this.f1143a = view;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onCancel() {
        a.a.a.a.v.d.b("CSJNativeExpressAd dislike callback onCancel", new Object[0]);
        a.a.a.a.v.f.g.c.a(this.f1144b.f1010g.f1391a, "unlike_canceled", new Object[0]);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onRefuse() {
        a.a.a.a.v.d.a("onRefuse", new Object[0]);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onSelected(int i, String str) {
        a.a.a.a.v.d.b("CSJNativeExpressAd dislike callback onSelected position: " + i + ", message: " + str, new Object[0]);
        this.f1144b.f1010g.h();
        View view = this.f1143a;
        if (view != null && view.getParent() != null) {
            ((ViewGroup) this.f1143a.getParent()).removeView(this.f1143a);
        }
        this.f1144b.f();
    }
}
