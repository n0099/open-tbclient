package a.a.a.a.r.a.c;

import a.a.a.a.a.e;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.sina.weibo.sdk.constant.WBConstants;
/* loaded from: classes4.dex */
public class s extends t {
    public s(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.r.a.c.t
    public AdSlot hs() {
        return new AdSlot.Builder().setCodeId(this.zl.c).setSupportDeepLink(true).setImageAcceptedSize(1080, WBConstants.SDK_NEW_PAY_VERSION).setExpressViewAcceptedSize(360.0f, 640.0f).build();
    }
}
