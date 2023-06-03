package com.baidu.searchbox.player.config;

import com.baidu.searchbox.player.model.StringArrayBundle;
import com.baidu.searchbox.player.property.GlobalScope;
import com.baidu.searchbox.player.property.MuteProperty;
import com.baidu.searchbox.player.property.OrientationLockProperty;
import com.baidu.searchbox.player.property.PropertyManager;
import com.baidu.searchbox.player.property.Scope;
import com.baidu.searchbox.player.property.SingleScope;
import com.baidu.searchbox.player.property.SpeedProperty;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\f\u0010\u0003\u001a\u00020\u0004*\u0004\u0018\u00010\u0002\u001a\f\u0010\u0005\u001a\u00020\u0006*\u0004\u0018\u00010\u0002\u001a&\u0010\u0007\u001a\u00020\u0002*\u00020\u00022\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f\u001a&\u0010\r\u001a\u00020\u0002*\u00020\u00022\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f\u001a&\u0010\u000e\u001a\u00020\u0002*\u00020\u00022\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f¨\u0006\u0010"}, d2 = {"getLockConfig", "Lcom/baidu/searchbox/player/property/OrientationLockProperty;", "Lcom/baidu/searchbox/player/config/PlayerConfig;", "getMuteConfig", "Lcom/baidu/searchbox/player/property/MuteProperty;", "getSpeedConfig", "Lcom/baidu/searchbox/player/property/SpeedProperty;", "setLockConfig", "stateInitializer", "Lkotlin/Function0;", "", "scope", "Lcom/baidu/searchbox/player/property/Scope;", "setMuteConfig", "setSpeedConfig", "", "bdvideoplayer-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
@JvmName(name = "PlayerConfigKit")
/* loaded from: classes4.dex */
public final class PlayerConfigKit {
    public static final OrientationLockProperty getLockConfig(PlayerConfig playerConfig) {
        Object obj;
        OrientationLockProperty orientationLockProperty;
        StringArrayBundle extBundle;
        if (playerConfig != null && (extBundle = playerConfig.getExtBundle()) != null) {
            obj = extBundle.get((Object) OrientationLockProperty.class.getName());
        } else {
            obj = null;
        }
        if (obj instanceof OrientationLockProperty) {
            orientationLockProperty = (OrientationLockProperty) obj;
        } else {
            orientationLockProperty = null;
        }
        if (orientationLockProperty == null) {
            return new OrientationLockProperty(false, null, 3, null);
        }
        return orientationLockProperty;
    }

    public static final MuteProperty getMuteConfig(PlayerConfig playerConfig) {
        Object obj;
        MuteProperty muteProperty;
        StringArrayBundle extBundle;
        if (playerConfig != null && (extBundle = playerConfig.getExtBundle()) != null) {
            obj = extBundle.get((Object) MuteProperty.class.getName());
        } else {
            obj = null;
        }
        if (obj instanceof MuteProperty) {
            muteProperty = (MuteProperty) obj;
        } else {
            muteProperty = null;
        }
        if (muteProperty == null) {
            return new MuteProperty(false, null, 3, null);
        }
        return muteProperty;
    }

    public static final SpeedProperty getSpeedConfig(PlayerConfig playerConfig) {
        Object obj;
        SpeedProperty speedProperty;
        StringArrayBundle extBundle;
        if (playerConfig != null && (extBundle = playerConfig.getExtBundle()) != null) {
            obj = extBundle.get((Object) SpeedProperty.class.getName());
        } else {
            obj = null;
        }
        if (obj instanceof SpeedProperty) {
            speedProperty = (SpeedProperty) obj;
        } else {
            speedProperty = null;
        }
        if (speedProperty == null) {
            return new SpeedProperty(0.0f, null, 3, null);
        }
        return speedProperty;
    }

    public static final PlayerConfig setLockConfig(PlayerConfig playerConfig, Function0<Boolean> function0, Scope scope) {
        boolean z;
        Intrinsics.checkNotNullParameter(playerConfig, "<this>");
        Intrinsics.checkNotNullParameter(scope, "scope");
        if (function0 != null) {
            z = function0.invoke().booleanValue();
        } else {
            Boolean bool = (Boolean) PropertyManager.queryScopeState(OrientationLockProperty.class, scope);
            if (bool != null) {
                z = bool.booleanValue();
            } else {
                z = false;
            }
        }
        playerConfig.getExtBundle().put(OrientationLockProperty.class.getName(), new OrientationLockProperty(z, scope));
        return playerConfig;
    }

    public static final PlayerConfig setMuteConfig(PlayerConfig playerConfig, Function0<Boolean> function0, Scope scope) {
        boolean z;
        Intrinsics.checkNotNullParameter(playerConfig, "<this>");
        Intrinsics.checkNotNullParameter(scope, "scope");
        if (function0 != null) {
            z = function0.invoke().booleanValue();
        } else {
            Boolean bool = (Boolean) PropertyManager.queryScopeState(MuteProperty.class, scope);
            if (bool != null) {
                z = bool.booleanValue();
            } else {
                z = false;
            }
        }
        playerConfig.getExtBundle().put(MuteProperty.class.getName(), new MuteProperty(z, scope));
        return playerConfig;
    }

    public static final PlayerConfig setSpeedConfig(PlayerConfig playerConfig, Function0<Float> function0, Scope scope) {
        float f;
        Intrinsics.checkNotNullParameter(playerConfig, "<this>");
        Intrinsics.checkNotNullParameter(scope, "scope");
        if (function0 != null) {
            f = function0.invoke().floatValue();
        } else {
            Float f2 = (Float) PropertyManager.queryScopeState(SpeedProperty.class, scope);
            if (f2 != null) {
                f = f2.floatValue();
            } else {
                f = 1.0f;
            }
        }
        playerConfig.getExtBundle().put(SpeedProperty.class.getName(), new SpeedProperty(f, scope));
        return playerConfig;
    }

    public static /* synthetic */ PlayerConfig setLockConfig$default(PlayerConfig playerConfig, Function0 function0, Scope scope, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        if ((i & 2) != 0) {
            scope = GlobalScope.INSTANCE;
        }
        return setLockConfig(playerConfig, function0, scope);
    }

    public static /* synthetic */ PlayerConfig setMuteConfig$default(PlayerConfig playerConfig, Function0 function0, Scope scope, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        if ((i & 2) != 0) {
            scope = GlobalScope.INSTANCE;
        }
        return setMuteConfig(playerConfig, function0, scope);
    }

    public static /* synthetic */ PlayerConfig setSpeedConfig$default(PlayerConfig playerConfig, Function0 function0, Scope scope, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        if ((i & 2) != 0) {
            scope = SingleScope.INSTANCE;
        }
        return setSpeedConfig(playerConfig, function0, scope);
    }
}
