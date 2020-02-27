package com.baidu.swan.apps.as.b;

import android.support.annotation.Nullable;
import com.baidu.swan.d.c;
import java.nio.channels.Channel;
/* loaded from: classes11.dex */
public final class b {
    public static void a(@Nullable Channel channel) {
        if (channel != null && channel.isOpen()) {
            c.closeSafely(channel);
        }
    }
}
