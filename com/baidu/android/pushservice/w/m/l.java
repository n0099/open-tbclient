package com.baidu.android.pushservice.w.m;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class l {
    public static /* synthetic */ Interceptable $ic;
    public static final l b;
    public static final l c;
    public static final l d;
    public static final l e;
    public static final l f;
    public static final l g;
    public static final l h;
    public static final l i;
    public static final l j;
    public static final l k;
    public static final l l;
    public static final l m;
    public static final /* synthetic */ l[] n;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1559709653, "Lcom/baidu/android/pushservice/w/m/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1559709653, "Lcom/baidu/android/pushservice/w/m/l;");
                return;
            }
        }
        b = new l("MSG_TYPE_INVALID", 0, -1);
        c = new l("MSG_TYPE_SINGLE_PRIVATE", 1, 0);
        d = new l("MSG_TYPE_MULTI_PRIVATE", 2, 1);
        e = new l("MSG_TYPE_SINGLE_PUBLIC", 3, 2);
        f = new l("MSG_TYPE_MULTI_PUBLIC", 4, 3);
        g = new l("MSG_TYPE_MULTI_PRIVATE_NOTIFICATION", 5, 5);
        h = new l("MSG_TYPE_PRIVATE_MESSAGE", 6, 6);
        i = new l("MSG_TYPE_CLEAR_MESSAGE", 7, 8);
        j = new l("MSG_TYPE_APP_PRIORITY", 8, 30);
        k = new l("MSG_TYPE_LOCAL_PUSH_MESSAGE", 9, 31);
        l = new l("MSG_TYPE_INNERBIND", 10, 101);
        l lVar = new l("MSG_TYPE_APPSTAT_COMMAND", 11, 104);
        m = lVar;
        n = new l[]{b, c, d, e, f, g, h, i, j, k, l, lVar};
    }

    public l(String str, int i2, int i3) {
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
        this.a = i3;
    }

    public static l a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? i2 != 5 ? i2 != 6 ? i2 != 8 ? i2 != 101 ? i2 != 104 ? i2 != 30 ? i2 != 31 ? i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? b : f : e : d : c : k : j : m : l : i : h : g : (l) invokeI.objValue;
    }

    public static l valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (l) Enum.valueOf(l.class, str) : (l) invokeL.objValue;
    }

    public static l[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (l[]) n.clone() : (l[]) invokeV.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.intValue;
    }
}
