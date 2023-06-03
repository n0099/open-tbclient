package com.baidu.searchbox.player.property;

import com.baidu.searchbox.command.CommandUtils;
import com.baidu.searchbox.player.model.StringArrayBundle;
import com.heytap.msp.push.mode.MessageStat;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0015\u001a\u00020\u0000*\u00020\u00002\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0017R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/player/property/PlayerProperties;", "", "()V", "extraProperty", "Lcom/baidu/searchbox/player/model/StringArrayBundle;", "getExtraProperty", "()Lcom/baidu/searchbox/player/model/StringArrayBundle;", "extraProperty$delegate", "Lkotlin/Lazy;", "lock", "Lcom/baidu/searchbox/player/property/OrientationLockProperty;", "getLock", "()Lcom/baidu/searchbox/player/property/OrientationLockProperty;", "mute", "Lcom/baidu/searchbox/player/property/MuteProperty;", "getMute", "()Lcom/baidu/searchbox/player/property/MuteProperty;", "speed", "Lcom/baidu/searchbox/player/property/SpeedProperty;", "getSpeed", "()Lcom/baidu/searchbox/player/property/SpeedProperty;", CommandUtils.PARAM_APPEND, MessageStat.PROPERTY, "Lcom/baidu/searchbox/player/property/Property;", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PlayerProperties {
    public final OrientationLockProperty lock = new OrientationLockProperty(false, null, 3, null);
    public final MuteProperty mute = new MuteProperty(false, null, 3, null);
    public final SpeedProperty speed = new SpeedProperty(0.0f, null, 3, null);
    public final Lazy extraProperty$delegate = LazyKt__LazyJVMKt.lazy(new Function0<StringArrayBundle>() { // from class: com.baidu.searchbox.player.property.PlayerProperties$extraProperty$2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final StringArrayBundle invoke() {
            return new StringArrayBundle(5);
        }
    });

    public final StringArrayBundle getExtraProperty() {
        return (StringArrayBundle) this.extraProperty$delegate.getValue();
    }

    public final OrientationLockProperty getLock() {
        return this.lock;
    }

    public final MuteProperty getMute() {
        return this.mute;
    }

    public final SpeedProperty getSpeed() {
        return this.speed;
    }

    public final PlayerProperties append(PlayerProperties playerProperties, Property<?> property) {
        Intrinsics.checkNotNullParameter(playerProperties, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        playerProperties.getExtraProperty().put(property.getClass().getName(), property);
        return playerProperties;
    }
}
