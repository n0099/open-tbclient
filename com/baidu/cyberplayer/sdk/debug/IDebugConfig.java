package com.baidu.cyberplayer.sdk.debug;

import android.content.Context;
import android.view.View;
import com.baidu.cyberplayer.sdk.CyberPlayer;
import com.baidu.cyberplayer.sdk.Keep;
import java.util.Map;
@Keep
/* loaded from: classes3.dex */
public interface IDebugConfig {
    Map<String, String> parseConfig(Context context);

    void showPlayerConfigOptions(View view2, Context context, CyberPlayer cyberPlayer);
}
