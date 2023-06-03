package com.baidu.searchbox.player.property;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.config.PlayerConfigKit;
import com.baidu.searchbox.player.event.PropertyEventTrigger;
import com.baidu.searchbox.player.message.IMessenger;
import com.baidu.searchbox.player.model.StringArrayBundle;
import com.heytap.msp.push.mode.MessageStat;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\u0016\u0010\u0013\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\u0016\u0010\u0014\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00150\u0011H\u0002J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0014\u0010\u0019\u001a\u00020\u000f2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0002J\u001c\u0010\u001a\u001a\u00020\u000f2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00112\b\b\u0002\u0010\u001b\u001a\u00020\u0001J\u001e\u0010\u001c\u001a\u00020\u00122\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u0012H\u0007J\u001e\u0010 \u001a\u00020\u00122\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u0012H\u0007J1\u0010!\u001a\u0004\u0018\u0001H\"\"\u0004\b\u0000\u0010#\"\u0004\b\u0001\u0010\"2\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H#0%2\u0006\u0010&\u001a\u00020'H\u0007¢\u0006\u0002\u0010(J\u0006\u0010)\u001a\u00020\u000fJ\u0010\u0010*\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0007R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f¨\u0006+"}, d2 = {"Lcom/baidu/searchbox/player/property/PropertyManager;", "", "()V", "propertyCache", "Lcom/baidu/searchbox/player/model/StringArrayBundle;", "getPropertyCache", "()Lcom/baidu/searchbox/player/model/StringArrayBundle;", "propertyCache$delegate", "Lkotlin/Lazy;", "trigger", "Lcom/baidu/searchbox/player/event/PropertyEventTrigger;", "getTrigger", "()Lcom/baidu/searchbox/player/event/PropertyEventTrigger;", "trigger$delegate", "addLockProperty", "", MessageStat.PROPERTY, "Lcom/baidu/searchbox/player/property/Property;", "", "addMuteProperty", "addSpeedProperty", "", "bindPropertyNotify", DI.LIVE_PLAYER, "Lcom/baidu/searchbox/player/BDVideoPlayer;", "changePropertyCache", "notifyPropertyChanged", "sender", "queryLockState", "scopeName", "", "defaultValue", "queryMuteState", "queryScopeState", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.GPS_DIRECTION_TRUE, "propertyClazz", "Ljava/lang/Class;", "scope", "Lcom/baidu/searchbox/player/property/Scope;", "(Ljava/lang/Class;Lcom/baidu/searchbox/player/property/Scope;)Ljava/lang/Object;", "release", "unbindPropertyNotify", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PropertyManager {
    public static final PropertyManager INSTANCE = new PropertyManager();
    public static final Lazy trigger$delegate = LazyKt__LazyJVMKt.lazy(new Function0<PropertyEventTrigger>() { // from class: com.baidu.searchbox.player.property.PropertyManager$trigger$2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PropertyEventTrigger invoke() {
            return new PropertyEventTrigger();
        }
    });
    public static final Lazy propertyCache$delegate = LazyKt__LazyJVMKt.lazy(new Function0<StringArrayBundle>() { // from class: com.baidu.searchbox.player.property.PropertyManager$propertyCache$2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final StringArrayBundle invoke() {
            return new StringArrayBundle(0, 1, null);
        }
    });

    @JvmStatic
    @JvmOverloads
    public static final boolean queryLockState() {
        return queryLockState$default(null, false, 3, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final boolean queryLockState(String str) {
        return queryLockState$default(str, false, 2, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final boolean queryMuteState() {
        return queryMuteState$default(null, false, 3, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final boolean queryMuteState(String str) {
        return queryMuteState$default(str, false, 2, null);
    }

    private final StringArrayBundle getPropertyCache() {
        return (StringArrayBundle) propertyCache$delegate.getValue();
    }

    private final PropertyEventTrigger getTrigger() {
        return (PropertyEventTrigger) trigger$delegate.getValue();
    }

    public final void release() {
        getTrigger().clear();
    }

    private final void addLockProperty(Property<Boolean> property) {
        getPropertyCache().put(PropertyManagerKt.forKey(property), new OrientationLockProperty(property.getState().booleanValue(), property.getScope()));
    }

    private final void addMuteProperty(Property<Boolean> property) {
        getPropertyCache().put(PropertyManagerKt.forKey(property), new MuteProperty(property.getState().booleanValue(), property.getScope()));
    }

    private final void addSpeedProperty(Property<Float> property) {
        getPropertyCache().put(PropertyManagerKt.forKey(property), new SpeedProperty(property.getState().floatValue(), property.getScope()));
    }

    private final void changePropertyCache(Property<?> property) {
        Property property2;
        Object obj = getPropertyCache().get((Object) PropertyManagerKt.forKey(property));
        if (obj instanceof Property) {
            property2 = (Property) obj;
        } else {
            property2 = null;
        }
        if (property2 != null) {
            Property.setState$default(property2, property.getState(), null, 2, null);
        }
    }

    @JvmStatic
    public static final void unbindPropertyNotify(BDVideoPlayer player) {
        Intrinsics.checkNotNullParameter(player, "player");
        PropertyEventTrigger trigger = INSTANCE.getTrigger();
        IMessenger messenger = player.getMessenger();
        Intrinsics.checkNotNullExpressionValue(messenger, "player.messenger");
        trigger.unbindMessenger(messenger);
    }

    @JvmStatic
    public static final void bindPropertyNotify(BDVideoPlayer player) {
        Intrinsics.checkNotNullParameter(player, "player");
        PropertyEventTrigger trigger = INSTANCE.getTrigger();
        OrientationLockProperty lockConfig = PlayerConfigKit.getLockConfig(player.getConfig());
        IMessenger messenger = player.getMessenger();
        Intrinsics.checkNotNullExpressionValue(messenger, "player.messenger");
        trigger.bindMessenger(lockConfig, messenger);
        PropertyEventTrigger trigger2 = INSTANCE.getTrigger();
        MuteProperty muteConfig = PlayerConfigKit.getMuteConfig(player.getConfig());
        IMessenger messenger2 = player.getMessenger();
        Intrinsics.checkNotNullExpressionValue(messenger2, "player.messenger");
        trigger2.bindMessenger(muteConfig, messenger2);
        PropertyEventTrigger trigger3 = INSTANCE.getTrigger();
        SpeedProperty speedConfig = PlayerConfigKit.getSpeedConfig(player.getConfig());
        IMessenger messenger3 = player.getMessenger();
        Intrinsics.checkNotNullExpressionValue(messenger3, "player.messenger");
        trigger3.bindMessenger(speedConfig, messenger3);
        INSTANCE.addLockProperty(PlayerConfigKit.getLockConfig(player.getConfig()));
        INSTANCE.addMuteProperty(PlayerConfigKit.getMuteConfig(player.getConfig()));
        INSTANCE.addSpeedProperty(PlayerConfigKit.getSpeedConfig(player.getConfig()));
    }

    public static /* synthetic */ void notifyPropertyChanged$default(PropertyManager propertyManager, Property property, Object obj, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = propertyManager;
        }
        propertyManager.notifyPropertyChanged(property, obj);
    }

    @JvmStatic
    @JvmOverloads
    public static final boolean queryLockState(String str, boolean z) {
        boolean z2;
        Scope groupScope;
        if (str != null && !StringsKt__StringsJVMKt.isBlank(str)) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            groupScope = GlobalScope.INSTANCE;
        } else {
            groupScope = new GroupScope(str);
        }
        Boolean bool = (Boolean) queryScopeState(OrientationLockProperty.class, groupScope);
        if (bool != null) {
            return bool.booleanValue();
        }
        return z;
    }

    @JvmStatic
    @JvmOverloads
    public static final boolean queryMuteState(String str, boolean z) {
        boolean z2;
        Scope groupScope;
        if (str != null && !StringsKt__StringsJVMKt.isBlank(str)) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            groupScope = GlobalScope.INSTANCE;
        } else {
            groupScope = new GroupScope(str);
        }
        Boolean bool = (Boolean) queryScopeState(MuteProperty.class, groupScope);
        if (bool != null) {
            return bool.booleanValue();
        }
        return z;
    }

    public final void notifyPropertyChanged(Property<?> property, Object sender) {
        Intrinsics.checkNotNullParameter(property, "property");
        Intrinsics.checkNotNullParameter(sender, "sender");
        changePropertyCache(property);
        getTrigger().onPropertyChanged(property, sender);
    }

    public static /* synthetic */ boolean queryLockState$default(String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return queryLockState(str, z);
    }

    public static /* synthetic */ boolean queryMuteState$default(String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return queryMuteState(str, z);
    }

    @JvmStatic
    public static final <T, V> V queryScopeState(Class<T> propertyClazz, Scope scope) {
        String forKey;
        Property property;
        Intrinsics.checkNotNullParameter(propertyClazz, "propertyClazz");
        Intrinsics.checkNotNullParameter(scope, "scope");
        String name = propertyClazz.getName();
        Intrinsics.checkNotNullExpressionValue(name, "propertyClazz.name");
        forKey = PropertyManagerKt.forKey(name, scope);
        Object obj = INSTANCE.getPropertyCache().get((Object) forKey);
        if (obj instanceof Property) {
            property = (Property) obj;
        } else {
            property = null;
        }
        if (property == null) {
            return null;
        }
        return (V) property.getState();
    }
}
