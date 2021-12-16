package com.baidu.android.pushservice.j;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static Map<Long, c> a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65536, null, j2) == null) {
            synchronized (b.class) {
                if (a.containsKey(Long.valueOf(j2))) {
                    a.remove(a.get(Long.valueOf(j2)));
                }
            }
        }
    }

    public static void a(Intent intent) {
        Map<Long, c> map;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, intent) == null) && intent.hasExtra("bd.cross.request.COMMAND_TYPE") && TextUtils.equals(intent.getStringExtra("bd.cross.request.COMMAND_TYPE"), "bd.cross.command.MESSAGE_ACK")) {
            long longExtra = intent.getLongExtra("bd.cross.request.ID", 0L);
            if (longExtra == 0 || (map = a) == null || !map.containsKey(Long.valueOf(longExtra))) {
                return;
            }
            a.get(Long.valueOf(longExtra)).a(intent);
            Map<Long, c> map2 = a;
            map2.remove(map2.get(Long.valueOf(longExtra)));
        }
    }

    public static synchronized void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, cVar) == null) {
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
}
