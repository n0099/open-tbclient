package com.baidu.cyberplayer.sdk.debug;

import android.content.Context;
import android.view.View;
import com.baidu.cyberplayer.sdk.CyberPlayer;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import java.util.Map;
@Keep
@Autowired
/* loaded from: classes3.dex */
public class DebugRuntime {
    public static IDebugConfig defaultConfig = new DefaultDebugConfigImpl();

    /* loaded from: classes3.dex */
    public static class DefaultDebugConfigImpl implements IDebugConfig {
        @Override // com.baidu.cyberplayer.sdk.debug.IDebugConfig
        public Map<String, String> parseConfig(Context context) {
            return null;
        }

        @Override // com.baidu.cyberplayer.sdk.debug.IDebugConfig
        public void showPlayerConfigOptions(View view2, Context context, CyberPlayer cyberPlayer) {
        }
    }

    @Inject(force = false)
    public static IDebugConfig getDebugConfig() {
        return defaultConfig;
    }
}
