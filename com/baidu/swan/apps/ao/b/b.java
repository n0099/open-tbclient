package com.baidu.swan.apps.ao.b;

import androidx.annotation.Nullable;
import com.baidu.swan.c.d;
import java.nio.channels.Channel;
/* loaded from: classes9.dex */
public final class b {
    public static void a(@Nullable Channel channel) {
        if (channel != null && channel.isOpen()) {
            d.closeSafely(channel);
        }
    }
}
