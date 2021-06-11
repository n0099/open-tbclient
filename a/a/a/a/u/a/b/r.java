package a.a.a.a.u.a.b;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.TTAdDislike;
/* loaded from: classes.dex */
public class r implements TTAdDislike.DislikeInteractionCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f1155a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p f1156b;

    public r(p pVar, View view) {
        this.f1156b = pVar;
        this.f1155a = view;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onCancel() {
        a.a.a.a.y.d.b("CSJNativeExpressAd dislike callback onCancel", new Object[0]);
        a.a.a.a.y.f.g.c.a(this.f1156b.f1014h.f1406a, "unlike_canceled", new Object[0]);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onRefuse() {
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onSelected(int i2, String str) {
        a.a.a.a.y.d.b("CSJNativeExpressAd dislike callback onSelected position: " + i2 + ", message: " + str, new Object[0]);
        this.f1156b.f1014h.i();
        View view = this.f1155a;
        if (view != null && view.getParent() != null) {
            ((ViewGroup) this.f1155a.getParent()).removeView(this.f1155a);
        }
        this.f1156b.f();
    }
}
