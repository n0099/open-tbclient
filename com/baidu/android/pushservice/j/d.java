package com.baidu.android.pushservice.j;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class d {
    private static Map<Long, e> a;

    public static synchronized void a(long j) {
        synchronized (d.class) {
            if (a.containsKey(Long.valueOf(j))) {
                a.remove(a.get(Long.valueOf(j)));
            }
        }
    }

    public static void a(Context context, Intent intent) {
        if (intent.hasExtra("bd.cross.request.COMMAND_TYPE")) {
            String stringExtra = intent.getStringExtra("bd.cross.request.COMMAND_TYPE");
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            if (stringExtra.equals("bd.cross.command.MESSAGE_ACK") || stringExtra.equals("bd.cross.command.ULTRON_ACK")) {
                long longExtra = intent.getLongExtra("bd.cross.request.ID", 0L);
                if (longExtra == 0 || a == null || !a.containsKey(Long.valueOf(longExtra))) {
                    return;
                }
                a.get(Long.valueOf(longExtra)).a(intent);
                a.remove(a.get(Long.valueOf(longExtra)));
            } else if (stringExtra.equals("bd.cross.command.ULTRON_DELIVER")) {
                intent.getLongExtra("bd.cross.request.ID", 0L);
                String stringExtra2 = intent.getStringExtra("bd.cross.request.SOURCE_SERVICE");
                String stringExtra3 = intent.getStringExtra("bd.cross.request.SOURCE_PACKAGE");
                if (TextUtils.isEmpty(stringExtra2) || TextUtils.isEmpty(stringExtra3)) {
                    return;
                }
                intent.setPackage(stringExtra3);
                intent.setClassName(stringExtra3, stringExtra2);
                intent.setAction("com.baidu.android.pushservice.action.CROSS_REQUEST");
                intent.putExtra("bd.cross.request.SENDING", false);
                intent.putExtra("bd.cross.request.RESULT_CODE", (short) 10);
                intent.putExtra("bd.cross.request.RESULT_DATA", "{DATA:\"OK\"}");
                intent.putExtra("bd.cross.request.COMMAND_TYPE", "bd.cross.command.ULTRON_ACK");
                try {
                    context.startService(intent);
                } catch (Exception e) {
                }
            }
        }
    }

    public static synchronized void a(e eVar) {
        synchronized (d.class) {
            if (a == null) {
                a = Collections.synchronizedMap(new HashMap());
            }
            if (a.containsKey(Long.valueOf(eVar.a()))) {
                a.remove(eVar).a();
            }
            a.put(Long.valueOf(eVar.a()), eVar);
        }
    }
}
