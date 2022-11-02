package com.baidu.platform.comapi.map;

import android.content.Context;
import android.view.SurfaceView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class ai {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public static final a b;
        public static final a c;
        public static final /* synthetic */ a[] d;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-302014277, "Lcom/baidu/platform/comapi/map/ai$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-302014277, "Lcom/baidu/platform/comapi/map/ai$a;");
                    return;
                }
            }
            a = new a("OPENGL_ES", 0);
            b = new a("VULKAN", 1);
            a aVar = new a("AUTO", 2);
            c = aVar;
            d = new a[]{a, b, aVar};
        }

        public a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static a valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (a) Enum.valueOf(a.class, str);
            }
            return (a) invokeL.objValue;
        }

        public static a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (a[]) d.clone();
            }
            return (a[]) invokeV.objValue;
        }
    }

    public static ah a(SurfaceView surfaceView, a aVar, boolean z, Context context) {
        InterceptResult invokeCommon;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{surfaceView, aVar, Boolean.valueOf(z), context})) == null) {
            f fVar = new f(surfaceView);
            fVar.c(2);
            if (!z) {
                i = 0;
                i2 = 0;
            } else {
                i = 1;
                i2 = 4;
            }
            try {
                if (com.baidu.platform.comapi.util.h.a(8, 8, 8, 8, 24, 8)) {
                    fVar.a(8, 8, 8, 8, 24, 8, i, i2);
                } else {
                    fVar.b(true);
                }
            } catch (IllegalArgumentException unused) {
                fVar.b(true);
            }
            fVar.a(true);
            return fVar;
        }
        return (ah) invokeCommon.objValue;
    }
}
