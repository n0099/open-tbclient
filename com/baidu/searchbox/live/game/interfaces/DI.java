package com.baidu.searchbox.live.game.interfaces;

import com.baidu.pyramid.runtime.service.ServiceReference;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/live/game/interfaces/DI;", "", "name", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getServiceRef", "(Ljava/lang/String;)Lcom/baidu/pyramid/runtime/service/ServiceReference;", "GAME_COMMON", "Ljava/lang/String;", "MODULE_NAME", "<init>", "()V", "lib-game-interface_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class DI {
    public static final String GAME_COMMON = "common";
    public static final DI INSTANCE = new DI();
    public static final String MODULE_NAME = "live_game";

    public final ServiceReference getServiceRef(String str) {
        return new ServiceReference(MODULE_NAME, str);
    }
}
