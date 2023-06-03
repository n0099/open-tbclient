package com.baidu.searchbox.player.property;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.model.StringArrayBundle;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.heytap.msp.push.mode.MessageStat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a5\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0005*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\b2\u0006\u0010\t\u001a\u0002H\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\u0010\f\u001a\n\u0010\r\u001a\u00020\u000b*\u00020\u0006\u001a\n\u0010\u000e\u001a\u00020\u000b*\u00020\u0006\u001a3\u0010\u000f\u001a\u0002H\u0005\"\u000e\b\u0000\u0010\u0005\u0018\u0001*\u0006\u0012\u0002\b\u00030\b*\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0011H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a\u0016\u0010\u0013\u001a\u00020\u000b*\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u001a\u0018\u0010\u0016\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\u0017\u001a\u00020\u0006H\u0000\u001a\u0014\u0010\u0018\u001a\u00020\u0004*\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001aH\u0000\u001a\u001a\u0010\u001b\u001a\u00020\u0004*\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b\u001a\u001a\u0010\u001d\u001a\u00020\u0004*\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b\u001a\u001a\u0010\u001f\u001a\u00020\u0004*\u00020\u00062\u0006\u0010 \u001a\u00020!2\u0006\u0010\n\u001a\u00020\u000b\u001a$\u0010\"\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00050\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006#"}, d2 = {"SCOPE_GLOBAL", "", "SCOPE_SINGLE", "changePropertyValue", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/baidu/searchbox/player/BDVideoPlayer;", MessageStat.PROPERTY, "Lcom/baidu/searchbox/player/property/Property;", "value", "isNotify", "", "(Lcom/baidu/searchbox/player/BDVideoPlayer;Lcom/baidu/searchbox/player/property/Property;Ljava/lang/Object;Z)V", "getLockState", "getMuteState", "getProperty", "initializer", "Lkotlin/Function0;", "(Lcom/baidu/searchbox/player/BDVideoPlayer;Lkotlin/jvm/functions/Function0;)Lcom/baidu/searchbox/player/property/Property;", "isMatch", "Lcom/baidu/searchbox/player/property/Scope;", "target", "notifyChanged", DI.LIVE_PLAYER, "processPropertyChanged", "event", "Lcom/baidu/searchbox/player/event/VideoEvent;", "setLockState", "isLock", "setMuteState", "isMute", "setSpeedState", "speed", "", "syncFrom", "bdvideoplayer-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
@JvmName(name = "PlayerPropertyKit")
/* loaded from: classes4.dex */
public final class PlayerPropertyKit {
    public static final String SCOPE_GLOBAL = "scope_global";
    public static final String SCOPE_SINGLE = "scope_single";

    public static final <T> void changePropertyValue(final BDVideoPlayer bDVideoPlayer, final Property<T> property, T t, boolean z) {
        Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(bDVideoPlayer, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        if (Intrinsics.areEqual(property.getState(), t)) {
            return;
        }
        if (z) {
            function0 = new Function0<Unit>() { // from class: com.baidu.searchbox.player.property.PlayerPropertyKit$changePropertyValue$notifyDelegate$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    PlayerPropertyKit.notifyChanged(property, bDVideoPlayer);
                }
            };
        } else {
            function0 = null;
        }
        property.setState(t, function0);
    }

    public static final boolean getLockState(BDVideoPlayer bDVideoPlayer) {
        Intrinsics.checkNotNullParameter(bDVideoPlayer, "<this>");
        return bDVideoPlayer.getProperties().getLock().getState().booleanValue();
    }

    public static final boolean getMuteState(BDVideoPlayer bDVideoPlayer) {
        Intrinsics.checkNotNullParameter(bDVideoPlayer, "<this>");
        return bDVideoPlayer.getProperties().getMute().getState().booleanValue();
    }

    public static final /* synthetic */ <T extends Property<?>> T getProperty(BDVideoPlayer bDVideoPlayer, Function0<? extends T> initializer) {
        Intrinsics.checkNotNullParameter(bDVideoPlayer, "<this>");
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        StringArrayBundle extraProperty = bDVideoPlayer.getProperties().getExtraProperty();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        String name = Property.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "T::class.java.name");
        Object extra = extraProperty.getExtra(name);
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        T t = (T) extra;
        if (t == null) {
            T invoke = initializer.invoke();
            StringArrayBundle extraProperty2 = bDVideoPlayer.getProperties().getExtraProperty();
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            extraProperty2.put(Property.class.getName(), invoke);
            return invoke;
        }
        return t;
    }

    public static final boolean isMatch(Scope scope, Scope scope2) {
        String str;
        if (scope == null) {
            return false;
        }
        String name = scope.getName();
        if (scope2 != null) {
            str = scope2.getName();
        } else {
            str = null;
        }
        return Intrinsics.areEqual(name, str);
    }

    public static final void notifyChanged(Property<?> property, BDVideoPlayer player) {
        Intrinsics.checkNotNullParameter(property, "<this>");
        Intrinsics.checkNotNullParameter(player, "player");
        if (Intrinsics.areEqual(property.getScope(), SingleScope.INSTANCE)) {
            return;
        }
        PropertyManager.INSTANCE.notifyPropertyChanged(property, Integer.valueOf(player.hashCode()));
    }

    public static final <T> void syncFrom(Property<T> property, Property<T> property2) {
        Intrinsics.checkNotNullParameter(property, "<this>");
        Intrinsics.checkNotNullParameter(property2, "property");
        if (Intrinsics.areEqual(property.getClass().getName(), property2.getClass().getName())) {
            Property.setState$default(property, property2.getState(), null, 2, null);
            property.setScope(property2.getScope());
        }
    }

    public static final void processPropertyChanged(BDVideoPlayer bDVideoPlayer, VideoEvent event) {
        Intrinsics.checkNotNullParameter(bDVideoPlayer, "<this>");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getType() == 1 && !Intrinsics.areEqual(event.getSender(), Integer.valueOf(bDVideoPlayer.hashCode()))) {
            String stringExtra = event.getStringExtra(1);
            Object extra = event.getExtra(3);
            if (!(extra instanceof Scope)) {
                extra = null;
            }
            Scope scope = (Scope) extra;
            if (Intrinsics.areEqual(stringExtra, MuteProperty.class.getName())) {
                if (isMatch(scope, bDVideoPlayer.getProperties().getMute().getScope())) {
                    bDVideoPlayer.setMuteMode(event.getBooleanExtra(2), false);
                }
            } else if (Intrinsics.areEqual(stringExtra, SpeedProperty.class.getName()) && isMatch(scope, bDVideoPlayer.getProperties().getSpeed().getScope())) {
                bDVideoPlayer.setSpeed(event.getFloatExtra(2), false);
            }
        }
    }

    public static final void setLockState(BDVideoPlayer bDVideoPlayer, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(bDVideoPlayer, "<this>");
        changePropertyValue(bDVideoPlayer, bDVideoPlayer.getProperties().getLock(), Boolean.valueOf(z), z2);
    }

    public static final void setSpeedState(BDVideoPlayer bDVideoPlayer, float f, boolean z) {
        Intrinsics.checkNotNullParameter(bDVideoPlayer, "<this>");
        changePropertyValue(bDVideoPlayer, bDVideoPlayer.getProperties().getSpeed(), Float.valueOf(f), z);
    }

    public static final void setMuteState(BDVideoPlayer bDVideoPlayer, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(bDVideoPlayer, "<this>");
        BdVideoLog.i(bDVideoPlayer.wrapMessage("setMuteMode(" + z + "), isNotify = " + z2 + ", scope = " + bDVideoPlayer.getProperties().getMute().getScope()));
        changePropertyValue(bDVideoPlayer, bDVideoPlayer.getProperties().getMute(), Boolean.valueOf(z), z2);
    }
}
