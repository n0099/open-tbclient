package com.baidu.sofire.b;

import android.app.Activity;
import android.content.Context;
import android.view.SurfaceHolder;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.ac.FaceCompareInfo;
import com.baidu.sofire.ac.FaceProcessCallback;
import com.baidu.sofire.ac.FaceVerifyInfo;
import com.baidu.sofire.ac.IVideoRecordProcess;
import com.baidu.sofire.ac.RecordCallback;
import com.baidu.sofire.utility.v;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static String f45195d;

    /* renamed from: e  reason: collision with root package name */
    public static b f45196e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f45197a;

    /* renamed from: b  reason: collision with root package name */
    public a f45198b;

    /* renamed from: c  reason: collision with root package name */
    public c f45199c;

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
        this.f45197a = context;
    }

    public static synchronized b a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (b.class) {
                if (context == null) {
                    return f45196e;
                }
                if (f45196e == null) {
                    f45196e = new b(context);
                }
                return f45196e;
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
                bVar = f45196e;
            }
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    public final synchronized boolean a(Activity activity, SurfaceHolder surfaceHolder, FaceProcessCallback faceProcessCallback, int i2, FaceVerifyInfo faceVerifyInfo, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, surfaceHolder, faceProcessCallback, Integer.valueOf(i2), faceVerifyInfo, Boolean.valueOf(z)})) == null) {
            synchronized (this) {
                if (com.baidu.sofire.core.c.a() != null && com.baidu.sofire.core.c.f45252b != null) {
                    if (!v.a(com.baidu.sofire.core.c.f45252b)) {
                        a(activity, faceProcessCallback, -14);
                        return false;
                    } else if (this.f45198b != null) {
                        a(activity, faceProcessCallback, -1);
                        return false;
                    } else {
                        a aVar = new a(this, activity, surfaceHolder, faceProcessCallback, i2, faceVerifyInfo, 1, z);
                        this.f45198b = aVar;
                        aVar.a();
                        return true;
                    }
                }
                a(activity, faceProcessCallback, -13);
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public final synchronized boolean a(Activity activity, SurfaceHolder surfaceHolder, FaceProcessCallback faceProcessCallback, int i2, FaceCompareInfo faceCompareInfo, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{activity, surfaceHolder, faceProcessCallback, Integer.valueOf(i2), faceCompareInfo, Boolean.valueOf(z)})) == null) {
            synchronized (this) {
                if (this.f45198b != null) {
                    a(activity, faceProcessCallback, -1);
                    return false;
                }
                a aVar = new a(this, activity, surfaceHolder, faceProcessCallback, i2, faceCompareInfo, 2, z);
                this.f45198b = aVar;
                aVar.a();
                return true;
            }
        }
        return invokeCommon.booleanValue;
    }

    private void a(Activity activity, FaceProcessCallback faceProcessCallback, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65539, this, activity, faceProcessCallback, i2) == null) || activity == null || faceProcessCallback == null) {
            return;
        }
        activity.runOnUiThread(new Runnable(this, faceProcessCallback, i2) { // from class: com.baidu.sofire.b.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ FaceProcessCallback f45200a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ int f45201b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b f45202c;

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
                this.f45202c = this;
                this.f45200a = faceProcessCallback;
                this.f45201b = i2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f45200a.onEnd(this.f45201b, null);
                }
            }
        });
    }

    private void a(Activity activity, RecordCallback recordCallback, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(InputDeviceCompat.SOURCE_TRACKBALL, this, activity, recordCallback, i2) == null) || activity == null || recordCallback == null) {
            return;
        }
        activity.runOnUiThread(new Runnable(this, recordCallback, i2) { // from class: com.baidu.sofire.b.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ RecordCallback f45203a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ int f45204b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b f45205c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, recordCallback, Integer.valueOf(i2)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f45205c = this;
                this.f45203a = recordCallback;
                this.f45204b = i2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f45203a.onEnd(this.f45204b, null);
                }
            }
        });
    }

    public final synchronized IVideoRecordProcess a(Activity activity, SurfaceHolder surfaceHolder, RecordCallback recordCallback, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048576, this, activity, surfaceHolder, recordCallback, i2)) == null) {
            synchronized (this) {
                if (com.baidu.sofire.core.c.a() != null && com.baidu.sofire.core.c.f45252b != null) {
                    if (!v.a(com.baidu.sofire.core.c.f45252b)) {
                        a(activity, recordCallback, -14);
                        return null;
                    } else if (this.f45199c != null) {
                        a(activity, recordCallback, -1);
                        return null;
                    } else {
                        c cVar = new c(this, activity, surfaceHolder, recordCallback, i2);
                        this.f45199c = cVar;
                        return cVar;
                    }
                }
                a(activity, recordCallback, -13);
                return null;
            }
        }
        return (IVideoRecordProcess) invokeLLLI.objValue;
    }
}
