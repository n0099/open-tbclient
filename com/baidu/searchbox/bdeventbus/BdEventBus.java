package com.baidu.searchbox.bdeventbus;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.bdeventbus.core.BdEventBusCore;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0002\u0015\u0016B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J>\u0010\u0007\u001a\u00020\b\"\b\b\u0000\u0010\t*\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\t0\u0010H\u0007J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0001H\u0007J2\u0010\u0013\u001a\u00020\b\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\t0\u0010H\u0007J>\u0010\u0013\u001a\u00020\b\"\b\b\u0000\u0010\t*\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\t0\u0010H\u0007J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0001H\u0007R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/bdeventbus/BdEventBus;", "", "bdEventBusCore", "Lcom/baidu/searchbox/bdeventbus/core/BdEventBusCore;", "(Lcom/baidu/searchbox/bdeventbus/core/BdEventBusCore;)V", "TAG", "", "lazyRegister", "", ExifInterface.GPS_DIRECTION_TRUE, "subscriber", "eventType", "Ljava/lang/Class;", "threadMode", "", "action", "Lcom/baidu/searchbox/bdeventbus/Action;", CommandUBCHelper.COMMAND_UBC_SOURCE_SEND, "event", "register", "unregister", "Companion", "SingletonHolder", "lib-bd-event-bus_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BdEventBus {
    public static final String BDEVENTBUS_ENABLE = "bdeventbus_enable";
    public static final boolean DEFAULT_VALUE = false;
    public final String TAG;
    public final BdEventBusCore bdEventBusCore;
    public static final Companion Companion = new Companion(null);
    public static final BdEventBus defaultInstance = SingletonHolder.INSTANCE.getHolder();

    public /* synthetic */ BdEventBus(BdEventBusCore bdEventBusCore, DefaultConstructorMarker defaultConstructorMarker) {
        this(bdEventBusCore);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/bdeventbus/BdEventBus$Companion;", "", "()V", "BDEVENTBUS_ENABLE", "", "DEFAULT_VALUE", "", "defaultInstance", "Lcom/baidu/searchbox/bdeventbus/BdEventBus;", "getDefault", "lib-bd-event-bus_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }

        public final BdEventBus getDefault() {
            return BdEventBus.defaultInstance;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/bdeventbus/BdEventBus$SingletonHolder;", "", "()V", "holder", "Lcom/baidu/searchbox/bdeventbus/BdEventBus;", "getHolder", "()Lcom/baidu/searchbox/bdeventbus/BdEventBus;", "lib-bd-event-bus_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class SingletonHolder {
        public static final SingletonHolder INSTANCE = new SingletonHolder();
        public static final BdEventBus holder = new BdEventBus(new BdEventBusCore(), null);

        public final BdEventBus getHolder() {
            return holder;
        }
    }

    public BdEventBus(BdEventBusCore bdEventBusCore) {
        this.bdEventBusCore = bdEventBusCore;
        this.TAG = "BdEventBus";
    }

    public final void post(Object event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.bdEventBusCore.post$lib_bd_event_bus_release(event);
    }

    public final synchronized void unregister(Object subscriber) {
        Intrinsics.checkNotNullParameter(subscriber, "subscriber");
        this.bdEventBusCore.unregister(subscriber);
    }

    @Deprecated(message = "请直接调用register方法")
    public final <T> void lazyRegister(Object subscriber, Class<T> eventType, int i, Action<T> action) {
        Intrinsics.checkNotNullParameter(subscriber, "subscriber");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(action, "action");
        this.bdEventBusCore.subscribe$lib_bd_event_bus_release(subscriber, eventType, i, action);
    }

    public final <T> void register(Object subscriber, Class<T> eventType, int i, Action<T> action) {
        Intrinsics.checkNotNullParameter(subscriber, "subscriber");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(action, "action");
        this.bdEventBusCore.subscribe$lib_bd_event_bus_release(subscriber, eventType, i, action);
    }

    public final <T> void register(Object subscriber, Class<T> eventType, Action<T> action) {
        Intrinsics.checkNotNullParameter(subscriber, "subscriber");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(action, "action");
        this.bdEventBusCore.subscribe$lib_bd_event_bus_release(subscriber, eventType, 0, action);
    }
}
