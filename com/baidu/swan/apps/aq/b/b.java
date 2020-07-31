package com.baidu.swan.apps.aq.b;

import android.support.annotation.Nullable;
import com.baidu.swan.d.d;
import java.nio.channels.Channel;
/* loaded from: classes7.dex */
public final class b {
    public static void a(@Nullable Channel channel) {
        if (channel != null && channel.isOpen()) {
            d.closeSafely(channel);
        }
    }
}
