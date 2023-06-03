package com.baidu.searchbox.player.utils;

import com.baidu.searchbox.player.config.PlayerConfig;
import com.baidu.searchbox.player.model.StringArrayBundle;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\f\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0003\u001a\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"KEY_CACHE_KEY", "", "getCacheKey", "Lcom/baidu/searchbox/player/config/PlayerConfig;", "setCacheKey", "cacheKey", "bdvideoplayer-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
@JvmName(name = "PlayerConfigUtils")
/* loaded from: classes4.dex */
public final class PlayerConfigUtils {
    public static final String KEY_CACHE_KEY = "key_cache_key";

    public static final String getCacheKey(PlayerConfig playerConfig) {
        StringArrayBundle extBundle;
        String stringExtra$default;
        if (playerConfig == null || (extBundle = playerConfig.getExtBundle()) == null || (stringExtra$default = StringArrayBundle.getStringExtra$default(extBundle, KEY_CACHE_KEY, null, 2, null)) == null) {
            return "";
        }
        return stringExtra$default;
    }

    public static final PlayerConfig setCacheKey(PlayerConfig playerConfig, String str) {
        StringArrayBundle extBundle;
        if (playerConfig != null && (extBundle = playerConfig.getExtBundle()) != null) {
            if (str == null) {
                str = "";
            }
            extBundle.putExtra(KEY_CACHE_KEY, str);
        }
        return playerConfig;
    }
}
