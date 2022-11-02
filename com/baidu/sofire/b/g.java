package com.baidu.sofire.b;

import android.content.Context;
import android.util.Pair;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.TimerTask;
/* loaded from: classes2.dex */
public final class g extends TimerTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;
    public final /* synthetic */ String d;
    public final /* synthetic */ long e;

    public g(Context context, String str, int i, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Integer.valueOf(i), str2, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.b = str;
        this.c = i;
        this.d = str2;
        this.e = j;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                Pair<Integer, String> a = e.a(this.a);
                if (a != null && ((Integer) a.first).intValue() == 1) {
                    e.a(((Integer) a.first).intValue(), e.a(this.a, this.b, this.c, this.d), "");
                    String str = e.a;
                    synchronized (e.h) {
                        e.g.cancel();
                        e.g = null;
                    }
                } else if (System.currentTimeMillis() > this.e) {
                    String a2 = e.a(this.a, this.b, this.c, this.d);
                    if (a != null) {
                        e.a(((Integer) a.first).intValue(), a2, (String) a.second);
                    } else {
                        e.a(-1, a2, "");
                    }
                    String str2 = e.a;
                    synchronized (e.h) {
                        e.g.cancel();
                        e.g = null;
                    }
                }
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
            }
        }
    }
}
