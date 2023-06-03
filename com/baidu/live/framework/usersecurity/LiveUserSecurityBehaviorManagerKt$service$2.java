package com.baidu.live.framework.usersecurity;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.service.LiveUserSecurityBehaviorService;
import com.baidu.searchbox.net.listener.DiaoqiJsonListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/live/interfaces/service/LiveUserSecurityBehaviorService;", "kotlin.jvm.PlatformType", DiaoqiJsonListener.SCHEME_FORBID_WHITE_LIST}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class LiveUserSecurityBehaviorManagerKt$service$2 extends Lambda implements Function0<LiveUserSecurityBehaviorService> {
    public static final LiveUserSecurityBehaviorManagerKt$service$2 INSTANCE = new LiveUserSecurityBehaviorManagerKt$service$2();

    public LiveUserSecurityBehaviorManagerKt$service$2() {
        super(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final LiveUserSecurityBehaviorService invoke() {
        return (LiveUserSecurityBehaviorService) ServiceManager.getService(LiveUserSecurityBehaviorService.Companion.getSERVICE_REFERENCE());
    }
}
