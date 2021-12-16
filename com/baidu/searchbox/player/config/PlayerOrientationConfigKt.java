package com.baidu.searchbox.player.config;

import com.baidu.searchbox.player.config.DefaultScope;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0005\u001a\u00020\u0004*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001b\u0010\b\u001a\u00020\u0004*\u0004\u0018\u00010\u00002\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\t\"\u0016\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/player/config/PlayerPropertyConfig;", "Lcom/baidu/searchbox/player/config/PlayerOrientationConfig;", "getLockConfig", "(Lcom/baidu/searchbox/player/config/PlayerPropertyConfig;)Lcom/baidu/searchbox/player/config/PlayerOrientationConfig;", "", "isLockConfigGlobal", "(Lcom/baidu/searchbox/player/config/PlayerPropertyConfig;)Z", "currentLockState", "needSyncLockState", "(Lcom/baidu/searchbox/player/config/PlayerPropertyConfig;Z)Z", "", "CONFIG_ORIENTATION_LOCK", "Ljava/lang/String;", "bdvideoplayer-core"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class PlayerOrientationConfigKt {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CONFIG_ORIENTATION_LOCK = "orientationLock";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.searchbox.player.config.Config */
    /* JADX WARN: Multi-variable type inference failed */
    public static final PlayerOrientationConfig getLockConfig(PlayerPropertyConfig playerPropertyConfig) {
        InterceptResult invokeL;
        List<Config> configurations;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, playerPropertyConfig)) == null) {
            if (playerPropertyConfig != null && (configurations = playerPropertyConfig.getConfigurations()) != null) {
                Iterator<T> it = configurations.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Config config = (Config) it.next();
                    if (Intrinsics.areEqual(config.getKey(), CONFIG_ORIENTATION_LOCK)) {
                        r0 = config instanceof PlayerOrientationConfig ? config : null;
                    }
                }
            }
            return r0 != null ? r0 : new PlayerOrientationConfig();
        }
        return (PlayerOrientationConfig) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean isLockConfigGlobal(PlayerPropertyConfig playerPropertyConfig) {
        InterceptResult invokeL;
        PlayerOrientationConfig playerOrientationConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, playerPropertyConfig)) == null) {
            if (playerPropertyConfig != null) {
                List<Config> configurations = playerPropertyConfig.getConfigurations();
                if (configurations != null) {
                    for (Config config : configurations) {
                        if (Intrinsics.areEqual(config.getKey(), CONFIG_ORIENTATION_LOCK)) {
                            if (!(config instanceof PlayerOrientationConfig)) {
                                config = null;
                            }
                            playerOrientationConfig = (PlayerOrientationConfig) config;
                            return Intrinsics.areEqual(playerOrientationConfig != null ? playerOrientationConfig.getScope() : null, DefaultScope.Global.INSTANCE);
                        }
                    }
                }
                playerOrientationConfig = null;
                return Intrinsics.areEqual(playerOrientationConfig != null ? playerOrientationConfig.getScope() : null, DefaultScope.Global.INSTANCE);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static final boolean needSyncLockState(PlayerPropertyConfig playerPropertyConfig, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, playerPropertyConfig, z)) == null) ? isLockConfigGlobal(playerPropertyConfig) && z != PlayerPropertyKt.globalOrientationLockState : invokeLZ.booleanValue;
    }
}
