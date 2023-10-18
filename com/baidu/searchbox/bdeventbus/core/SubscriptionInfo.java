package com.baidu.searchbox.bdeventbus.core;

import com.baidu.searchbox.bdeventbus.Action;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\u0010\tJ\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001d\u001a\u00020\u0006H\u0016R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R \u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/baidu/searchbox/bdeventbus/core/SubscriptionInfo;", "", "subscriber", "eventType", "Ljava/lang/Class;", "threadMode", "", "action", "Lcom/baidu/searchbox/bdeventbus/Action;", "(Ljava/lang/Object;Ljava/lang/Class;ILcom/baidu/searchbox/bdeventbus/Action;)V", "getAction", "()Lcom/baidu/searchbox/bdeventbus/Action;", "setAction", "(Lcom/baidu/searchbox/bdeventbus/Action;)V", "getEventType", "()Ljava/lang/Class;", "setEventType", "(Ljava/lang/Class;)V", "getSubscriber", "()Ljava/lang/Object;", "getThreadMode$annotations", "()V", "getThreadMode", "()I", "setThreadMode", "(I)V", "equals", "", "other", "hashCode", "lib-bd-event-bus_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SubscriptionInfo {
    public Action<Object> action;
    public Class<?> eventType;
    public final Object subscriber;
    public int threadMode;

    public static /* synthetic */ void getThreadMode$annotations() {
    }

    public SubscriptionInfo(Object subscriber, Class<?> eventType, int i, Action<Object> action) {
        Intrinsics.checkNotNullParameter(subscriber, "subscriber");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(action, "action");
        this.subscriber = subscriber;
        this.eventType = eventType;
        this.threadMode = i;
        this.action = action;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SubscriptionInfo)) {
            return false;
        }
        SubscriptionInfo subscriptionInfo = (SubscriptionInfo) obj;
        if (!Intrinsics.areEqual(this.subscriber, subscriptionInfo.subscriber) || !Intrinsics.areEqual(this.eventType.getClass(), subscriptionInfo.eventType.getClass())) {
            return false;
        }
        return true;
    }

    public final void setAction(Action<Object> action) {
        Intrinsics.checkNotNullParameter(action, "<set-?>");
        this.action = action;
    }

    public final void setEventType(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<set-?>");
        this.eventType = cls;
    }

    public final void setThreadMode(int i) {
        this.threadMode = i;
    }

    public final Action<Object> getAction() {
        return this.action;
    }

    public final Class<?> getEventType() {
        return this.eventType;
    }

    public final Object getSubscriber() {
        return this.subscriber;
    }

    public final int getThreadMode() {
        return this.threadMode;
    }

    public int hashCode() {
        return this.subscriber.hashCode() + this.eventType.getClass().hashCode();
    }
}
