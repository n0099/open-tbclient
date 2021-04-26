package a.a.a.a.t.a.b;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.TTAdDislike;
/* loaded from: classes.dex */
public class c implements TTAdDislike.DislikeInteractionCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f1106a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f1107b;

    public c(a aVar, View view) {
        this.f1107b = aVar;
        this.f1106a = view;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onCancel() {
        a.a.a.a.x.d.a("CSJBannerExpressAd dislike callback onCancel", new Object[0]);
        a.a.a.a.x.f.g.c.a(this.f1107b.f1013g.f1393a, "unlike_canceled", new Object[0]);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onRefuse() {
        a.a.a.a.x.d.a("onRefuse", new Object[0]);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onSelected(int i2, String str) {
        a.a.a.a.x.d.a("dislike callback onSelected position: " + i2 + ", message: " + str, new Object[0]);
        this.f1107b.f1013g.h();
        if (this.f1106a.getParent() != null) {
            ((ViewGroup) this.f1106a.getParent()).removeView(this.f1106a);
        }
        this.f1107b.f();
    }
}
