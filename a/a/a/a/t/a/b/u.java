package a.a.a.a.t.a.b;

import a.a.a.a.u.e;
import com.baidu.sapi2.activity.IdCardOcrCameraActivity;
import com.bytedance.sdk.openadsdk.AdSlot;
/* loaded from: classes.dex */
public class u extends v {
    public u(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.t.a.b.v
    public AdSlot j() {
        return new AdSlot.Builder().setCodeId(this.f1014h.f1334c).setSupportDeepLink(true).setImageAcceptedSize(IdCardOcrCameraActivity.G, 1920).setExpressViewAcceptedSize(360.0f, 640.0f).build();
    }
}
