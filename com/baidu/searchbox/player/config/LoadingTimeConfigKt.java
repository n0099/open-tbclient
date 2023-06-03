package com.baidu.searchbox.player.config;

import com.baidu.searchbox.player.model.StringArrayBundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0003*\u0004\u0018\u00010\u0004\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"PLAYER_LOADING_DELAY_TIME", "", "getLoadingTime", "Lcom/baidu/searchbox/player/config/LoadingTimeConfig;", "Lcom/baidu/searchbox/player/config/PlayerConfig;", "setLoadingTime", "", "config", "bdvideoplayer-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LoadingTimeConfigKt {
    public static final String PLAYER_LOADING_DELAY_TIME = "player_loading_delay_time";

    public static final LoadingTimeConfig getLoadingTime(PlayerConfig playerConfig) {
        Object obj;
        StringArrayBundle extBundle;
        LoadingTimeConfig loadingTimeConfig = null;
        if (playerConfig != null && (extBundle = playerConfig.getExtBundle()) != null) {
            obj = extBundle.getExtra(PLAYER_LOADING_DELAY_TIME);
        } else {
            obj = null;
        }
        if (obj instanceof LoadingTimeConfig) {
            loadingTimeConfig = (LoadingTimeConfig) obj;
        }
        if (loadingTimeConfig == null) {
            return new LoadingTimeConfig(0, 0, false, 7, null);
        }
        return loadingTimeConfig;
    }

    public static final void setLoadingTime(PlayerConfig playerConfig, LoadingTimeConfig config) {
        StringArrayBundle extBundle;
        Intrinsics.checkNotNullParameter(config, "config");
        if (playerConfig != null && (extBundle = playerConfig.getExtBundle()) != null) {
            extBundle.putExtra(PLAYER_LOADING_DELAY_TIME, config);
        }
    }
}
