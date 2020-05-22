package com.baidu.swan.apps.aq.b;

import android.support.annotation.Nullable;
import com.baidu.swan.e.d;
import java.nio.channels.Channel;
/* loaded from: classes11.dex */
public final class b {
    public static void a(@Nullable Channel channel) {
        if (channel != null && channel.isOpen()) {
            d.closeSafely(channel);
        }
    }
}
