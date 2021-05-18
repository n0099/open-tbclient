package com.baidu.searchbox.bdeventbus.core;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/bdeventbus/core/MainHandlerPoster;", "invoke"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class BdEventBusCore$mainHandlerPoster$2 extends Lambda implements Function0<MainHandlerPoster> {
    public static final BdEventBusCore$mainHandlerPoster$2 INSTANCE = new BdEventBusCore$mainHandlerPoster$2();

    public BdEventBusCore$mainHandlerPoster$2() {
        super(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final MainHandlerPoster invoke() {
        return new MainHandlerPoster();
    }
}
