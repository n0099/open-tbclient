package com.baidu.sofire.b;

import android.content.Context;
import android.util.Pair;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes4.dex */
public final class e extends TimerTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;
    public final /* synthetic */ String d;
    public final /* synthetic */ long e;

    public e(Context context, String str, int i, String str2, long j) {
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
                Pair<Integer, String> a = c.a(this.a);
                if (a != null && ((Integer) a.first).intValue() == 1) {
                    c.a(((Integer) a.first).intValue(), c.a(this.a, this.b, this.c, this.d), "");
                    String str = c.a;
                    synchronized (c.h) {
                        Timer timer = c.g;
                        if (timer != null) {
                            timer.cancel();
                            c.g = null;
                        }
                    }
                } else if (System.currentTimeMillis() > this.e) {
                    String a2 = c.a(this.a, this.b, this.c, this.d);
                    if (a != null) {
                        c.a(((Integer) a.first).intValue(), a2, (String) a.second);
                    } else {
                        c.a(-1, a2, "");
                    }
                    String str2 = c.a;
                    synchronized (c.h) {
                        Timer timer2 = c.g;
                        if (timer2 != null) {
                            timer2.cancel();
                            c.g = null;
                        }
                    }
                }
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
            }
        }
    }
}
