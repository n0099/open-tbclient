package com.baidu.sofire.b;

import android.app.Activity;
import android.content.Context;
import com.baidu.sofire.ac.FaceProcessCallback;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static String f10294c;

    /* renamed from: d  reason: collision with root package name */
    public static b f10295d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f10296a;

    /* renamed from: b  reason: collision with root package name */
    public a f10297b;

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f10296a = context;
    }

    public static synchronized b a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (b.class) {
                if (context == null) {
                    return f10295d;
                }
                if (f10295d == null) {
                    f10295d = new b(context);
                }
                return f10295d;
            }
        }
        return (b) invokeL.objValue;
    }

    public static synchronized b a() {
        InterceptResult invokeV;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (b.class) {
                bVar = f10295d;
            }
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    public final void a(Activity activity, FaceProcessCallback faceProcessCallback, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048576, this, activity, faceProcessCallback, i2) == null) || activity == null || faceProcessCallback == null) {
            return;
        }
        activity.runOnUiThread(new Runnable(this, faceProcessCallback, i2) { // from class: com.baidu.sofire.b.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ FaceProcessCallback f10298a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ int f10299b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b f10300c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, faceProcessCallback, Integer.valueOf(i2)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f10300c = this;
                this.f10298a = faceProcessCallback;
                this.f10299b = i2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f10298a.onEnd(this.f10299b, null);
                }
            }
        });
    }
}
