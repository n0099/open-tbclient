package com.baidu.searchbox.player.config;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a(\u0010\u0004\u001a\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\b¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"T", "Lcom/baidu/searchbox/player/config/PlayerPropertyConfig;", "", "key", "getConfig", "(Lcom/baidu/searchbox/player/config/PlayerPropertyConfig;Ljava/lang/String;)Ljava/lang/Object;", "bdvideoplayer-core"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class PlayerPropertyConfigKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.searchbox.player.config.Config, T] */
    public static final /* synthetic */ <T> T getConfig(PlayerPropertyConfig playerPropertyConfig, String key) {
        List<Config> configurations;
        Intrinsics.checkNotNullParameter(key, "key");
        if (playerPropertyConfig == null || (configurations = playerPropertyConfig.getConfigurations()) == null) {
            return null;
        }
        for (Config config : configurations) {
            ?? r0 = (T) config;
            if (Intrinsics.areEqual(r0.getKey(), key)) {
                Intrinsics.reifiedOperationMarker(2, "T?");
                return r0;
            }
        }
        return null;
    }
}
