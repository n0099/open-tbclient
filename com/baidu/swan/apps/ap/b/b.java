package com.baidu.swan.apps.ap.b;

import android.support.annotation.Nullable;
import com.baidu.swan.c.d;
import java.nio.channels.Channel;
/* loaded from: classes8.dex */
public final class b {
    public static void a(@Nullable Channel channel) {
        if (channel != null && channel.isOpen()) {
            d.closeSafely(channel);
        }
    }
}
