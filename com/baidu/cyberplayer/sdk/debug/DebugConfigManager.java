package com.baidu.cyberplayer.sdk.debug;

import android.content.Context;
import android.view.View;
import com.baidu.cyberplayer.sdk.CyberPlayer;
import com.baidu.cyberplayer.sdk.Keep;
import java.util.Map;
@Keep
/* loaded from: classes3.dex */
public class DebugConfigManager {
    public static Map<String, String> loadDebugConfig(Context context) {
        return DebugRuntime.getDebugConfig().parseConfig(context);
    }

    public static void showPlayerConfigOptions(View view2, Context context, CyberPlayer cyberPlayer) {
        DebugRuntime.getDebugConfig().showPlayerConfigOptions(view2, context, cyberPlayer);
    }
}
