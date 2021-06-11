package a.a.a.a.u.a.b;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.TTAdDislike;
/* loaded from: classes.dex */
public class c implements TTAdDislike.DislikeInteractionCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f1109a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f1110b;

    public c(a aVar, View view) {
        this.f1110b = aVar;
        this.f1109a = view;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onCancel() {
        a.a.a.a.y.d.a("CSJBannerExpressAd dislike callback onCancel", new Object[0]);
        a.a.a.a.y.f.g.c.a(this.f1110b.f1014h.f1406a, "unlike_canceled", new Object[0]);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onRefuse() {
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onSelected(int i2, String str) {
        a.a.a.a.y.d.a("dislike callback onSelected position: " + i2 + ", message: " + str, new Object[0]);
        this.f1110b.f1014h.i();
        if (this.f1109a.getParent() != null) {
            ((ViewGroup) this.f1109a.getParent()).removeView(this.f1109a);
        }
        this.f1110b.f();
    }
}
