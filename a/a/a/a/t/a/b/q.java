package a.a.a.a.t.a.b;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.TTAdDislike;
/* loaded from: classes.dex */
public class q implements TTAdDislike.DislikeInteractionCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f1152a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ o f1153b;

    public q(o oVar, View view) {
        this.f1153b = oVar;
        this.f1152a = view;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onCancel() {
        a.a.a.a.x.d.b("CSJNativeExpressAd dislike callback onCancel", new Object[0]);
        a.a.a.a.x.f.g.c.a(this.f1153b.f1013g.f1393a, "unlike_canceled", new Object[0]);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onRefuse() {
        a.a.a.a.x.d.a("onRefuse", new Object[0]);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onSelected(int i2, String str) {
        a.a.a.a.x.d.b("CSJNativeExpressAd dislike callback onSelected position: " + i2 + ", message: " + str, new Object[0]);
        this.f1153b.f1013g.h();
        View view = this.f1152a;
        if (view != null && view.getParent() != null) {
            ((ViewGroup) this.f1152a.getParent()).removeView(this.f1152a);
        }
        this.f1153b.f();
    }
}
