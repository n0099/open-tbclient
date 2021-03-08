package a.a.a.a.r.a.c;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.TTAdDislike;
/* loaded from: classes4.dex */
public class o implements TTAdDislike.DislikeInteractionCallback {
    public final /* synthetic */ m Ap;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f978a;

    public o(m mVar, View view) {
        this.Ap = mVar;
        this.f978a = view;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onCancel() {
        a.a.a.a.v.d.b("CSJNativeExpressAd dislike callback onCancel", new Object[0]);
        a.a.a.a.v.f.g.c.a(this.Ap.zk.BU, "unlike_canceled", new Object[0]);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onRefuse() {
        a.a.a.a.v.d.a("onRefuse", new Object[0]);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onSelected(int i, String str) {
        a.a.a.a.v.d.b("CSJNativeExpressAd dislike callback onSelected position: " + i + ", message: " + str, new Object[0]);
        this.Ap.zk.h();
        View view = this.f978a;
        if (view != null && view.getParent() != null) {
            ((ViewGroup) this.f978a.getParent()).removeView(this.f978a);
        }
        this.Ap.f();
    }
}
