package com.baidu.android.pushservice.i;

import android.content.Intent;
import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class b {
    private static Map<Long, c> a;

    public static synchronized void a(long j) {
        synchronized (b.class) {
            if (a.containsKey(Long.valueOf(j))) {
                a.remove(a.get(Long.valueOf(j)));
            }
        }
    }

    public static void a(Intent intent) {
        if (intent.hasExtra("bd.cross.request.COMMAND_TYPE") && TextUtils.equals(intent.getStringExtra("bd.cross.request.COMMAND_TYPE"), "bd.cross.command.MESSAGE_ACK")) {
            long longExtra = intent.getLongExtra("bd.cross.request.ID", 0L);
            if (longExtra == 0 || a == null || !a.containsKey(Long.valueOf(longExtra))) {
                return;
            }
            a.get(Long.valueOf(longExtra)).a(intent);
            a.remove(a.get(Long.valueOf(longExtra)));
        }
    }

    public static synchronized void a(c cVar) {
        synchronized (b.class) {
            if (a == null) {
                a = Collections.synchronizedMap(new HashMap());
            }
            if (a.containsKey(Long.valueOf(cVar.a()))) {
                a.remove(cVar).a();
            }
            a.put(Long.valueOf(cVar.a()), cVar);
        }
    }
}
