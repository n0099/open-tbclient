package com.baidu.searchbox.live.interfaces.defaultimpl.service;

import com.baidu.searchbox.live.interfaces.player.internal.LivePlayUrlService;
import com.baidu.tieba.rj1;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/defaultimpl/service/LivePlayUrlServiceFetcher;", "Lcom/baidu/tieba/rj1;", "Lcom/baidu/searchbox/live/interfaces/player/internal/LivePlayUrlService;", "createService", "()Lcom/baidu/searchbox/live/interfaces/player/internal/LivePlayUrlService;", "<init>", "()V", "lib-live-interfaces-impl_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LivePlayUrlServiceFetcher extends rj1<LivePlayUrlService> {
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.rj1
    public LivePlayUrlService createService() {
        return new LivePlayUrlServiceImpl();
    }
}
