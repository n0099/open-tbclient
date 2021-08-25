package com.baidu.mobstat;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public abstract class t {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final t f43774a;

    /* renamed from: b  reason: collision with root package name */
    public static final t f43775b;

    /* renamed from: c  reason: collision with root package name */
    public static final t f43776c;

    /* renamed from: d  reason: collision with root package name */
    public static final t f43777d;

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ t[] f43778f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f43779e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1366709648, "Lcom/baidu/mobstat/t;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1366709648, "Lcom/baidu/mobstat/t;");
                return;
            }
        }
        f43774a = new t("SERVICE", 0, 1) { // from class: com.baidu.mobstat.t.1
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.baidu.mobstat.t
            public void a(Context context) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, context) == null) && t.d(context) && u.a(context).b(context)) {
                    try {
                        Intent intent = new Intent(context, Class.forName("com.baidu.bottom.service.BottomService"));
                        intent.putExtra("SDK_PRODUCT_LY", "MS");
                        context.startService(intent);
                    } catch (Throwable th) {
                        bb.c().b(th);
                    }
                }
            }
        };
        f43775b = new t("NO_SERVICE", 1, 2) { // from class: com.baidu.mobstat.t.2
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.baidu.mobstat.t
            public void a(Context context) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, context) == null) && t.d(context)) {
                    Context applicationContext = context.getApplicationContext();
                    a a2 = u.a(context);
                    ac acVar = new ac();
                    acVar.f43053a = false;
                    acVar.f43054b = "M";
                    acVar.f43055c = false;
                    a2.a(applicationContext, acVar.a());
                }
            }
        };
        f43776c = new t("RECEIVER", 2, 3) { // from class: com.baidu.mobstat.t.3
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.baidu.mobstat.t
            public void a(Context context) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, context) == null) && t.d(context)) {
                    Context applicationContext = context.getApplicationContext();
                    a a2 = u.a(context);
                    ac acVar = new ac();
                    acVar.f43053a = false;
                    acVar.f43054b = "R";
                    acVar.f43055c = false;
                    a2.a(applicationContext, acVar.a());
                }
            }
        };
        t tVar = new t("ERISED", 3, 4) { // from class: com.baidu.mobstat.t.4
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.baidu.mobstat.t
            public void a(Context context) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, context) == null) && t.d(context)) {
                    Context applicationContext = context.getApplicationContext();
                    a a2 = u.a(context);
                    ac acVar = new ac();
                    acVar.f43053a = false;
                    acVar.f43054b = "E";
                    acVar.f43055c = false;
                    a2.a(applicationContext, acVar.a());
                }
            }
        };
        f43777d = tVar;
        f43778f = new t[]{f43774a, f43775b, f43776c, tVar};
    }

    public static t a(int i2) {
        InterceptResult invokeI;
        t[] values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            for (t tVar : values()) {
                if (tVar.f43779e == i2) {
                    return tVar;
                }
            }
            return f43775b;
        }
        return (t) invokeI.objValue;
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null) {
                try {
                    List<ActivityManager.RunningServiceInfo> runningServices = activityManager.getRunningServices(Integer.MAX_VALUE);
                    int i2 = 0;
                    while (runningServices != null) {
                        if (i2 >= runningServices.size()) {
                            break;
                        } else if ("com.baidu.bottom.service.BottomService".equals(runningServices.get(i2).service.getClassName())) {
                            return true;
                        } else {
                            i2++;
                        }
                    }
                } catch (Exception e2) {
                    bb.c().a(e2);
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) ? bo.e(context, "android.permission.WRITE_EXTERNAL_STORAGE") : invokeL.booleanValue;
    }

    public static t valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? (t) Enum.valueOf(t.class, str) : (t) invokeL.objValue;
    }

    public static t[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? (t[]) f43778f.clone() : (t[]) invokeV.objValue;
    }

    public abstract void a(Context context);

    @Override // java.lang.Enum
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? String.valueOf(this.f43779e) : (String) invokeV.objValue;
    }

    public t(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f43779e = i3;
    }
}
