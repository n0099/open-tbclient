package cn.jiguang.d.a;

import android.content.Context;
import java.util.Random;
/* loaded from: classes3.dex */
public final class e {
    private static cn.jiguang.g.b.d li;

    public static synchronized long a() {
        long longValue;
        synchronized (e.class) {
            longValue = ((Long) ag(null).c("next_rid", -1L)).longValue();
            if (longValue != -1) {
                longValue = a(longValue);
                ag(null).d("next_rid", Long.valueOf(longValue));
            }
            if (longValue == -1) {
                longValue = a(Math.abs(new Random().nextInt(32767)));
                ag(null).d("next_rid", Long.valueOf(longValue));
            }
        }
        return longValue;
    }

    private static long a(long j) {
        return (j % 2 == 0 ? 1 + j : j + 2) % 32767;
    }

    private static cn.jiguang.g.b.d ag(Context context) {
        if (li == null) {
            li = cn.jiguang.g.b.d.O(null, "cn.jpush.preferences.v2.rid");
        }
        return li;
    }
}
