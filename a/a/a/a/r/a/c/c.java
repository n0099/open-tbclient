package a.a.a.a.r.a.c;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.TTAdDislike;
/* loaded from: classes.dex */
public class c implements TTAdDislike.DislikeInteractionCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f1099a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f1100b;

    public c(a aVar, View view) {
        this.f1100b = aVar;
        this.f1099a = view;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onCancel() {
        a.a.a.a.v.d.a("CSJBannerExpressAd dislike callback onCancel", new Object[0]);
        a.a.a.a.v.f.g.c.a(this.f1100b.f1010g.f1391a, "unlike_canceled", new Object[0]);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onRefuse() {
        a.a.a.a.v.d.a("onRefuse", new Object[0]);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onSelected(int i, String str) {
        a.a.a.a.v.d.a("dislike callback onSelected position: " + i + ", message: " + str, new Object[0]);
        this.f1100b.f1010g.h();
        if (this.f1099a.getParent() != null) {
            ((ViewGroup) this.f1099a.getParent()).removeView(this.f1099a);
        }
        this.f1100b.f();
    }
}
