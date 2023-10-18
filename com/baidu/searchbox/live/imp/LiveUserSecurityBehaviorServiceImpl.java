package com.baidu.searchbox.live.imp;

import com.baidu.behavior.record.api.IBehaviorApi;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.service.LiveUserSecurityBehaviorService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/live/imp/LiveUserSecurityBehaviorServiceImpl;", "Lcom/baidu/searchbox/live/interfaces/service/LiveUserSecurityBehaviorService;", "()V", "addBehavior", "", "collectType", "", "infoName", "", "Companion", "alaLiveSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LiveUserSecurityBehaviorServiceImpl implements LiveUserSecurityBehaviorService {
    public static final Companion Companion = new Companion(null);
    public static final String purpose = "";
    public static final String scene = "live";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/live/imp/LiveUserSecurityBehaviorServiceImpl$Companion;", "", "()V", "purpose", "", "scene", "alaLiveSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveUserSecurityBehaviorService
    public void addBehavior(int i, String infoName) {
        Intrinsics.checkNotNullParameter(infoName, "infoName");
        IBehaviorApi iBehaviorApi = (IBehaviorApi) ServiceManager.getService(IBehaviorApi.SERVICE_REFERENCE);
        if (iBehaviorApi != null) {
            iBehaviorApi.addBehavior(i, infoName, "", "live");
        }
    }
}
