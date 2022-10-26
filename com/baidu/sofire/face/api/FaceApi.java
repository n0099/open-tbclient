package com.baidu.sofire.face.api;

import android.app.Activity;
import android.content.Context;
import android.view.SurfaceHolder;
import android.view.TextureView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.sofire.ac.F;
import com.baidu.sofire.ac.FH;
import com.baidu.sofire.face.a.a;
import com.baidu.sofire.face.a.b;
import com.baidu.sofire.face.a.e;
import com.baidu.sofire.face.a.f;
import com.baidu.sofire.face.a.j;
import com.baidu.sofire.face.a.m;
import com.baidu.sofire.face.a.q;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class FaceApi {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String getVersion(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? "3.5.9.6" : (String) invokeL.objValue;
    }

    public FaceApi() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void cancelFaceProcess() {
        e eVar;
        j jVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            synchronized (e.class) {
                eVar = e.c;
            }
            if (eVar != null && (jVar = eVar.a) != null) {
                jVar.a();
                eVar.a = null;
            }
        }
    }

    public static IVideoRecordProcess getVideoRecordProcess(Activity activity, SurfaceHolder surfaceHolder, RecordCallback recordCallback, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65539, null, activity, surfaceHolder, recordCallback, i)) == null) {
            e a = e.a(activity.getApplicationContext());
            if (a == null) {
                return null;
            }
            synchronized (a) {
                if (!"3.5.9.6".equals(FH.getVersion(activity.getApplicationContext()))) {
                    a.a(activity, recordCallback, -21);
                } else if (F.getInstance().gct() == null) {
                    a.a(activity, recordCallback, -13);
                } else if (!F.getInstance().cp(activity.getApplicationContext())) {
                    a.a(activity, recordCallback, -14);
                } else if (a.b != null) {
                    a.a(activity, recordCallback, -1);
                } else {
                    m mVar = new m(a, activity, surfaceHolder, recordCallback, i);
                    a.b = mVar;
                    return mVar;
                }
                return null;
            }
        }
        return (IVideoRecordProcess) invokeLLLI.objValue;
    }

    public static IVideoRecordProcess getVideoRecordTextureProcess(Activity activity, TextureView textureView, RecordCallback recordCallback, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, textureView, recordCallback, i)) == null) {
            e a = e.a(activity.getApplicationContext());
            if (a == null) {
                return null;
            }
            synchronized (a) {
                if (!"3.5.9.6".equals(FH.getVersion(activity.getApplicationContext()))) {
                    a.a(activity, recordCallback, -21);
                } else if (F.getInstance().gct() == null) {
                    a.a(activity, recordCallback, -13);
                } else if (!F.getInstance().cp(activity.getApplicationContext())) {
                    a.a(activity, recordCallback, -14);
                } else if (a.b != null) {
                    a.a(activity, recordCallback, -1);
                } else {
                    q qVar = new q(a, activity, textureView, recordCallback, i);
                    a.b = qVar;
                    return qVar;
                }
                return null;
            }
        }
        return (IVideoRecordProcess) invokeLLLI.objValue;
    }

    public static void setFaceLicenseId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            e.d = str;
        }
    }

    public static void setSoundEnable(boolean z) {
        e eVar;
        j jVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65542, null, z) == null) {
            synchronized (e.class) {
                eVar = e.c;
            }
            if (eVar != null && (jVar = eVar.a) != null) {
                jVar.a(z);
            }
        }
    }

    public static boolean startFaceSurfaceLiveness(Activity activity, SurfaceHolder surfaceHolder, FaceProcessCallback faceProcessCallback, int i, IFaceProcessInfo iFaceProcessInfo, boolean z, int i2) {
        InterceptResult invokeCommon;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{activity, surfaceHolder, faceProcessCallback, Integer.valueOf(i), iFaceProcessInfo, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            e a = e.a(activity.getApplicationContext());
            synchronized (a) {
                if (!"3.5.9.6".equals(FH.getVersion(activity.getApplicationContext()))) {
                    a.a(activity, faceProcessCallback, -21);
                } else if (!a.a(activity.getApplicationContext())) {
                    a.a(activity, faceProcessCallback, -19);
                } else if (F.getInstance().gct() == null) {
                    a.a(activity, faceProcessCallback, -13);
                } else if (!F.getInstance().cp(activity.getApplicationContext())) {
                    a.a(activity, faceProcessCallback, -14);
                } else if (!a.a()) {
                    a.a(activity, faceProcessCallback, -20);
                } else if (a.a != null) {
                    a.a(activity, faceProcessCallback, -1);
                } else {
                    b bVar = new b(a, activity, surfaceHolder, faceProcessCallback, i, iFaceProcessInfo, z, i2);
                    a.a = bVar;
                    bVar.d();
                    z2 = true;
                }
                z2 = false;
            }
            return z2;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean startFaceTextureLiveness(Activity activity, TextureView textureView, FaceProcessCallback faceProcessCallback, int i, IFaceProcessInfo iFaceProcessInfo, boolean z, int i2) {
        InterceptResult invokeCommon;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{activity, textureView, faceProcessCallback, Integer.valueOf(i), iFaceProcessInfo, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            e a = e.a(activity.getApplicationContext());
            synchronized (a) {
                if (!"3.5.9.6".equals(FH.getVersion(activity.getApplicationContext()))) {
                    a.a(activity, faceProcessCallback, -21);
                } else if (!a.a(activity.getApplicationContext())) {
                    a.a(activity, faceProcessCallback, -19);
                } else if (F.getInstance().gct() == null) {
                    a.a(activity, faceProcessCallback, -13);
                } else if (!F.getInstance().cp(activity.getApplicationContext())) {
                    a.a(activity, faceProcessCallback, -14);
                } else if (!a.a()) {
                    a.a(activity, faceProcessCallback, -20);
                } else if (a.a != null) {
                    a.a(activity, faceProcessCallback, -1);
                } else {
                    f fVar = new f(a, activity, textureView, faceProcessCallback, i, iFaceProcessInfo, true, z, i2);
                    a.a = fVar;
                    fVar.d();
                    z2 = true;
                }
                z2 = false;
            }
            return z2;
        }
        return invokeCommon.booleanValue;
    }
}
