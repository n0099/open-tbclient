package com.baidu.android.pushservice.i;

import android.content.Intent;
import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static Map<Long, c> f1144a;

    public static synchronized void a(long j) {
        synchronized (b.class) {
            if (f1144a.containsKey(Long.valueOf(j))) {
                f1144a.remove(f1144a.get(Long.valueOf(j)));
            }
        }
    }

    public static void a(Intent intent) {
        if (intent.hasExtra("bd.cross.request.COMMAND_TYPE") && TextUtils.equals(intent.getStringExtra("bd.cross.request.COMMAND_TYPE"), "bd.cross.command.MESSAGE_ACK")) {
            long longExtra = intent.getLongExtra("bd.cross.request.ID", 0L);
            if (longExtra == 0 || f1144a == null || !f1144a.containsKey(Long.valueOf(longExtra))) {
                return;
            }
            f1144a.get(Long.valueOf(longExtra)).a(intent);
            f1144a.remove(f1144a.get(Long.valueOf(longExtra)));
        }
    }

    public static synchronized void a(c cVar) {
        synchronized (b.class) {
            if (f1144a == null) {
                f1144a = Collections.synchronizedMap(new HashMap());
            }
            if (f1144a.containsKey(Long.valueOf(cVar.a()))) {
                f1144a.remove(cVar).a();
            }
            f1144a.put(Long.valueOf(cVar.a()), cVar);
        }
    }
}
