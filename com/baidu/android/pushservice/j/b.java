package com.baidu.android.pushservice.j;

import android.content.Intent;
import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static Map<Long, c> f3378a;

    public static synchronized void a(long j) {
        synchronized (b.class) {
            if (f3378a.containsKey(Long.valueOf(j))) {
                f3378a.remove(f3378a.get(Long.valueOf(j)));
            }
        }
    }

    public static void a(Intent intent) {
        Map<Long, c> map;
        if (intent.hasExtra("bd.cross.request.COMMAND_TYPE") && TextUtils.equals(intent.getStringExtra("bd.cross.request.COMMAND_TYPE"), "bd.cross.command.MESSAGE_ACK")) {
            long longExtra = intent.getLongExtra("bd.cross.request.ID", 0L);
            if (longExtra == 0 || (map = f3378a) == null || !map.containsKey(Long.valueOf(longExtra))) {
                return;
            }
            f3378a.get(Long.valueOf(longExtra)).a(intent);
            Map<Long, c> map2 = f3378a;
            map2.remove(map2.get(Long.valueOf(longExtra)));
        }
    }

    public static synchronized void a(c cVar) {
        synchronized (b.class) {
            if (f3378a == null) {
                f3378a = Collections.synchronizedMap(new HashMap());
            }
            if (f3378a.containsKey(Long.valueOf(cVar.a()))) {
                f3378a.remove(cVar).a();
            }
            f3378a.put(Long.valueOf(cVar.a()), cVar);
        }
    }
}
