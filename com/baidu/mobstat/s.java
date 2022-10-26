package com.baidu.mobstat;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public abstract class s {
    public static /* synthetic */ Interceptable $ic;
    public static final s a;
    public static final s b;
    public static final s c;
    public static final s d;
    public static final /* synthetic */ s[] f;
    public transient /* synthetic */ FieldHolder $fh;
    public int e;

    public abstract void a(Context context);

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1366709679, "Lcom/baidu/mobstat/s;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1366709679, "Lcom/baidu/mobstat/s;");
                return;
            }
        }
        a = new s("SERVICE", 0, 1) { // from class: com.baidu.mobstat.s.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r10, r11, r12);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r10, Integer.valueOf(r11), Integer.valueOf(r12)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.baidu.mobstat.s
            public void a(Context context) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 != null && interceptable2.invokeL(1048576, this, context) != null) || !t.a(context).b(context)) {
                    return;
                }
                try {
                    Intent intent = new Intent(context, Class.forName("com.baidu.bottom.service.BottomService"));
                    intent.putExtra("SDK_PRODUCT_LY", "MS");
                    context.startService(intent);
                } catch (Throwable th) {
                    ba.c().b(th);
                }
            }
        };
        b = new s("NO_SERVICE", 1, 2) { // from class: com.baidu.mobstat.s.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r10, r11, r12);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r10, Integer.valueOf(r11), Integer.valueOf(r12)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.baidu.mobstat.s
            public void a(Context context) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, context) == null) {
                    Context applicationContext = context.getApplicationContext();
                    a a2 = t.a(context);
                    aa aaVar = new aa();
                    aaVar.a = false;
                    aaVar.b = "M";
                    aaVar.c = false;
                    a2.a(applicationContext, aaVar.a());
                }
            }
        };
        c = new s("RECEIVER", 2, 3) { // from class: com.baidu.mobstat.s.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r10, r11, r12);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r10, Integer.valueOf(r11), Integer.valueOf(r12)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.baidu.mobstat.s
            public void a(Context context) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, context) == null) {
                    Context applicationContext = context.getApplicationContext();
                    a a2 = t.a(context);
                    aa aaVar = new aa();
                    aaVar.a = false;
                    aaVar.b = "R";
                    aaVar.c = false;
                    a2.a(applicationContext, aaVar.a());
                }
            }
        };
        s sVar = new s("ERISED", 3, 4) { // from class: com.baidu.mobstat.s.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r10, r11, r12);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r10, Integer.valueOf(r11), Integer.valueOf(r12)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.baidu.mobstat.s
            public void a(Context context) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, context) == null) {
                    Context applicationContext = context.getApplicationContext();
                    a a2 = t.a(context);
                    aa aaVar = new aa();
                    aaVar.a = false;
                    aaVar.b = ExifInterface.LONGITUDE_EAST;
                    aaVar.c = false;
                    a2.a(applicationContext, aaVar.a());
                }
            }
        };
        d = sVar;
        f = new s[]{a, b, c, sVar};
    }

    public s(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = i2;
    }

    public static s a(int i) {
        InterceptResult invokeI;
        s[] values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            for (s sVar : values()) {
                if (sVar.e == i) {
                    return sVar;
                }
            }
            return b;
        }
        return (s) invokeI.objValue;
    }

    public static s valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            return (s) Enum.valueOf(s.class, str);
        }
        return (s) invokeL.objValue;
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null) {
                try {
                    List<ActivityManager.RunningServiceInfo> runningServices = activityManager.getRunningServices(Integer.MAX_VALUE);
                    int i = 0;
                    while (runningServices != null) {
                        if (i >= runningServices.size()) {
                            break;
                        } else if ("com.baidu.bottom.service.BottomService".equals(runningServices.get(i).service.getClassName())) {
                            return true;
                        } else {
                            i++;
                        }
                    }
                } catch (Exception e) {
                    ba.c().a(e);
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static s[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return (s[]) f.clone();
        }
        return (s[]) invokeV.objValue;
    }

    @Override // java.lang.Enum
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return String.valueOf(this.e);
        }
        return (String) invokeV.objValue;
    }
}
