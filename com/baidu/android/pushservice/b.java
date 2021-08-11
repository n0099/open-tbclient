package com.baidu.android.pushservice;

import android.content.Context;
import android.util.Log;
import com.baidu.adp.framework.cmdRouter.MultiDexHelper;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.android.pushservice.j.m;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.Thread;
/* loaded from: classes4.dex */
public class b implements Thread.UncaughtExceptionHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f36653a;

    /* renamed from: b  reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f36654b;

    public b(Context context, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, uncaughtExceptionHandler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f36653a = context;
        this.f36654b = uncaughtExceptionHandler;
    }

    private void a(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, th) == null) {
            String stackTraceString = Log.getStackTraceString(th);
            if (stackTraceString.contains(MultiDexHelper.PUSH_SDK_PREFIX)) {
                m.a("exception " + stackTraceString + " at Time " + System.currentTimeMillis(), this.f36653a.getApplicationContext());
                new b.c(this.f36653a).a(stackTraceString).a(201002L).a();
            }
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, thread, th) == null) {
            a(th);
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f36654b;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        }
    }
}
