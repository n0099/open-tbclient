package a.a.a.a.r.a.c;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.TTAdDislike;
/* loaded from: classes4.dex */
public class c implements TTAdDislike.DislikeInteractionCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f970a;
    public final /* synthetic */ a zW;

    public c(a aVar, View view) {
        this.zW = aVar;
        this.f970a = view;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onCancel() {
        a.a.a.a.v.d.a("CSJBannerExpressAd dislike callback onCancel", new Object[0]);
        a.a.a.a.v.f.g.c.a(this.zW.zk.BU, "unlike_canceled", new Object[0]);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onRefuse() {
        a.a.a.a.v.d.a("onRefuse", new Object[0]);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onSelected(int i, String str) {
        a.a.a.a.v.d.a("dislike callback onSelected position: " + i + ", message: " + str, new Object[0]);
        this.zW.zk.h();
        if (this.f970a.getParent() != null) {
            ((ViewGroup) this.f970a.getParent()).removeView(this.f970a);
        }
        this.zW.f();
    }
}
