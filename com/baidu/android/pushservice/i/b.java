package com.baidu.android.pushservice.i;

import android.content.Intent;
import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes14.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static Map<Long, c> f1421a;

    public static synchronized void a(long j) {
        synchronized (b.class) {
            if (f1421a.containsKey(Long.valueOf(j))) {
                f1421a.remove(f1421a.get(Long.valueOf(j)));
            }
        }
    }

    public static void a(Intent intent) {
        if (intent.hasExtra("bd.cross.request.COMMAND_TYPE") && TextUtils.equals(intent.getStringExtra("bd.cross.request.COMMAND_TYPE"), "bd.cross.command.MESSAGE_ACK")) {
            long longExtra = intent.getLongExtra("bd.cross.request.ID", 0L);
            if (longExtra == 0 || f1421a == null || !f1421a.containsKey(Long.valueOf(longExtra))) {
                return;
            }
            f1421a.get(Long.valueOf(longExtra)).a(intent);
            f1421a.remove(f1421a.get(Long.valueOf(longExtra)));
        }
    }

    public static synchronized void a(c cVar) {
        synchronized (b.class) {
            if (f1421a == null) {
                f1421a = Collections.synchronizedMap(new HashMap());
            }
            if (f1421a.containsKey(Long.valueOf(cVar.a()))) {
                f1421a.remove(cVar).a();
            }
            f1421a.put(Long.valueOf(cVar.a()), cVar);
        }
    }
}
