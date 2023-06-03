package com.baidu.searchbox.player.event;

import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.player.message.IMessenger;
import com.baidu.searchbox.player.property.GlobalScope;
import com.baidu.searchbox.player.property.Property;
import com.baidu.searchbox.player.property.PropertyManagerKt;
import com.baidu.searchbox.player.property.Scope;
import com.baidu.searchbox.player.property.SingleScope;
import com.heytap.msp.push.mode.MessageStat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u0007J\u0006\u0010\u0011\u001a\u00020\rJ\u001a\u0010\u0012\u001a\u00020\r2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000f2\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u000e\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0007R-\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/baidu/searchbox/player/event/PropertyEventTrigger;", "Lcom/baidu/searchbox/player/event/IEventTrigger;", "()V", "subscribers", "", "", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/baidu/searchbox/player/message/IMessenger;", "getSubscribers", "()Ljava/util/Map;", "subscribers$delegate", "Lkotlin/Lazy;", "bindMessenger", "", MessageStat.PROPERTY, "Lcom/baidu/searchbox/player/property/Property;", "messenger", DownloadStatisticConstants.UBC_VALUE_CLEAR, "onPropertyChanged", "sender", "", "triggerEvent", "event", "Lcom/baidu/searchbox/player/event/VideoEvent;", "unbindMessenger", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PropertyEventTrigger implements IEventTrigger {
    public final Lazy subscribers$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Map<String, CopyOnWriteArrayList<IMessenger>>>() { // from class: com.baidu.searchbox.player.event.PropertyEventTrigger$subscribers$2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function0
        public final Map<String, CopyOnWriteArrayList<IMessenger>> invoke() {
            return new LinkedHashMap();
        }
    });

    private final Map<String, CopyOnWriteArrayList<IMessenger>> getSubscribers() {
        return (Map) this.subscribers$delegate.getValue();
    }

    public final void clear() {
        getSubscribers().clear();
    }

    public final void bindMessenger(Property<?> property, IMessenger messenger) {
        Intrinsics.checkNotNullParameter(property, "property");
        Intrinsics.checkNotNullParameter(messenger, "messenger");
        if (Intrinsics.areEqual(property.getScope(), SingleScope.INSTANCE)) {
            return;
        }
        CopyOnWriteArrayList<IMessenger> copyOnWriteArrayList = getSubscribers().get(PropertyManagerKt.forKey(property));
        if (copyOnWriteArrayList != null) {
            if (!copyOnWriteArrayList.contains(messenger)) {
                copyOnWriteArrayList.add(messenger);
                return;
            }
            return;
        }
        CopyOnWriteArrayList<IMessenger> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList2.add(messenger);
        getSubscribers().put(PropertyManagerKt.forKey(property), copyOnWriteArrayList2);
    }

    public final void onPropertyChanged(Property<?> property, Object sender) {
        Intrinsics.checkNotNullParameter(property, "property");
        Intrinsics.checkNotNullParameter(sender, "sender");
        VideoEvent event = VideoEvent.obtain(PropertyEventKt.ACTION_PROPERTY_STATE_CHANGED, 1);
        event.putExtra(1, property.getClass().getName());
        event.putExtra(2, property.getState());
        event.putExtra(3, property.getScope());
        event.setSender(sender);
        Intrinsics.checkNotNullExpressionValue(event, "event");
        triggerEvent(event);
    }

    @Override // com.baidu.searchbox.player.event.IEventTrigger
    public void triggerEvent(VideoEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Object extra = event.getExtra(3);
        String str = null;
        if (!(extra instanceof Scope)) {
            extra = null;
        }
        Scope scope = (Scope) extra;
        boolean z = true;
        Object extra2 = event.getExtra(1);
        if (!(extra2 instanceof String)) {
            extra2 = null;
        }
        String str2 = (String) extra2;
        if (!Intrinsics.areEqual(scope, GlobalScope.INSTANCE)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            if (scope != null) {
                str = scope.getName();
            }
            sb.append(str);
            str2 = sb.toString();
        }
        CopyOnWriteArrayList<IMessenger> copyOnWriteArrayList = getSubscribers().get(str2);
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
            z = false;
        }
        if (z) {
            return;
        }
        int size = copyOnWriteArrayList.size();
        for (int i = 0; i < size; i++) {
            IMessenger iMessenger = copyOnWriteArrayList.get(i);
            Intrinsics.checkNotNullExpressionValue(iMessenger, "subscriber[i]");
            IMessenger iMessenger2 = iMessenger;
            if (i == 0) {
                iMessenger2.notifyEvent(event);
            } else {
                iMessenger2.notifyEvent(VideoEvent.copy(event));
            }
        }
    }

    public final void unbindMessenger(IMessenger messenger) {
        Intrinsics.checkNotNullParameter(messenger, "messenger");
        for (CopyOnWriteArrayList<IMessenger> copyOnWriteArrayList : getSubscribers().values()) {
            copyOnWriteArrayList.remove(messenger);
        }
    }
}
