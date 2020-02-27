package com.baidu.android.pushservice.i;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class c {
    private static Map<Long, d> a;

    public static synchronized void a(long j) {
        synchronized (c.class) {
            if (a.containsKey(Long.valueOf(j))) {
                a.remove(a.get(Long.valueOf(j)));
            }
        }
    }

    public static void a(Context context, Intent intent) {
        if (intent.hasExtra("bd.cross.request.COMMAND_TYPE")) {
            String stringExtra = intent.getStringExtra("bd.cross.request.COMMAND_TYPE");
            if (TextUtils.isEmpty(stringExtra) || !stringExtra.equals("bd.cross.command.MESSAGE_ACK")) {
                return;
            }
            long longExtra = intent.getLongExtra("bd.cross.request.ID", 0L);
            if (longExtra == 0 || a == null || !a.containsKey(Long.valueOf(longExtra))) {
                return;
            }
            a.get(Long.valueOf(longExtra)).a(intent);
            a.remove(a.get(Long.valueOf(longExtra)));
        }
    }

    public static synchronized void a(d dVar) {
        synchronized (c.class) {
            if (a == null) {
                a = Collections.synchronizedMap(new HashMap());
            }
            if (a.containsKey(Long.valueOf(dVar.a()))) {
                a.remove(dVar).a();
            }
            a.put(Long.valueOf(dVar.a()), dVar);
        }
    }
}
