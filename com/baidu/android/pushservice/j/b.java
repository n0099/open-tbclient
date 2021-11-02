package com.baidu.android.pushservice.j;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Map<Long, c> f35702a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65536, null, j) == null) {
            synchronized (b.class) {
                if (f35702a.containsKey(Long.valueOf(j))) {
                    f35702a.remove(f35702a.get(Long.valueOf(j)));
                }
            }
        }
    }

    public static void a(Intent intent) {
        Map<Long, c> map;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, intent) == null) && intent.hasExtra("bd.cross.request.COMMAND_TYPE") && TextUtils.equals(intent.getStringExtra("bd.cross.request.COMMAND_TYPE"), "bd.cross.command.MESSAGE_ACK")) {
            long longExtra = intent.getLongExtra("bd.cross.request.ID", 0L);
            if (longExtra == 0 || (map = f35702a) == null || !map.containsKey(Long.valueOf(longExtra))) {
                return;
            }
            f35702a.get(Long.valueOf(longExtra)).a(intent);
            Map<Long, c> map2 = f35702a;
            map2.remove(map2.get(Long.valueOf(longExtra)));
        }
    }

    public static synchronized void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, cVar) == null) {
            synchronized (b.class) {
                if (f35702a == null) {
                    f35702a = Collections.synchronizedMap(new HashMap());
                }
                if (f35702a.containsKey(Long.valueOf(cVar.a()))) {
                    f35702a.remove(cVar).a();
                }
                f35702a.put(Long.valueOf(cVar.a()), cVar);
            }
        }
    }
}
