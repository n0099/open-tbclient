package com.baidu.searchbox.bdeventbus.core;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/bdeventbus/core/Poster;", "Lkotlin/Any;", "", "event", "Lcom/baidu/searchbox/bdeventbus/core/SubscriptionInfo;", "subscriptionInfo", "", "enqueue", "(Ljava/lang/Object;Lcom/baidu/searchbox/bdeventbus/core/SubscriptionInfo;)V", "lib-bd-event-bus_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public interface Poster {
    void enqueue(Object obj, SubscriptionInfo subscriptionInfo);
}
