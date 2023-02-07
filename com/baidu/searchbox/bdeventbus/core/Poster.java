package com.baidu.searchbox.bdeventbus.core;

import kotlin.Metadata;
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/bdeventbus/core/Poster;", "", "enqueue", "", "event", "subscriptionInfo", "Lcom/baidu/searchbox/bdeventbus/core/SubscriptionInfo;", "lib-bd-event-bus_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface Poster {
    void enqueue(Object obj, SubscriptionInfo subscriptionInfo);
}
