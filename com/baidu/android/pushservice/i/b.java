package com.baidu.android.pushservice.i;

import android.content.Intent;
import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static Map<Long, c> f1147a;

    public static synchronized void a(long j) {
        synchronized (b.class) {
            if (f1147a.containsKey(Long.valueOf(j))) {
                f1147a.remove(f1147a.get(Long.valueOf(j)));
            }
        }
    }

    public static void a(Intent intent) {
        if (intent.hasExtra("bd.cross.request.COMMAND_TYPE") && TextUtils.equals(intent.getStringExtra("bd.cross.request.COMMAND_TYPE"), "bd.cross.command.MESSAGE_ACK")) {
            long longExtra = intent.getLongExtra("bd.cross.request.ID", 0L);
            if (longExtra == 0 || f1147a == null || !f1147a.containsKey(Long.valueOf(longExtra))) {
                return;
            }
            f1147a.get(Long.valueOf(longExtra)).a(intent);
            f1147a.remove(f1147a.get(Long.valueOf(longExtra)));
        }
    }

    public static synchronized void a(c cVar) {
        synchronized (b.class) {
            if (f1147a == null) {
                f1147a = Collections.synchronizedMap(new HashMap());
            }
            if (f1147a.containsKey(Long.valueOf(cVar.a()))) {
                f1147a.remove(cVar).a();
            }
            f1147a.put(Long.valueOf(cVar.a()), cVar);
        }
    }
}
