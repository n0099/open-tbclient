package c.a.m0.g;

import android.content.Context;
import android.text.TextUtils;
import c.a.m0.l.c;
import c.a.m0.l.d;
import c.a.m0.l.k;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f4217a;

    /* renamed from: b  reason: collision with root package name */
    public static String f4218b;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) ? d.a(context) : (String) invokeL.objValue;
    }

    public static String b(Context context, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (!c.a.m0.b.a.h(context).e()) {
                return k.c(String.valueOf(-1000), z2);
            }
            if (z && !TextUtils.isEmpty(f4218b)) {
                return f4218b;
            }
            if (c.a.m0.b.a.h(context).c()) {
                str = c.a.m0.d.a.b(context);
            } else if (c.o(context)) {
                str = c.a.m0.d.a.b(context);
            } else if (!z) {
                return k.c(String.valueOf(-1002), z2);
            } else {
                str = "";
            }
            if (!TextUtils.isEmpty(str)) {
                c.a.m0.b.a.h(context).m(str);
            } else if (z) {
                str = c.a.m0.b.a.h(context).O();
            } else {
                return k.c(String.valueOf(-1003), z2);
            }
            if (TextUtils.isEmpty(str)) {
                return k.c(String.valueOf(-1003), z2);
            }
            f4218b = str;
            return str;
        }
        return (String) invokeCommon.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? d.h(context) : (String) invokeL.objValue;
    }

    public static String d(Context context, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{context, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (!c.a.m0.b.a.h(context).e()) {
                return k.c(String.valueOf(-1000), z2);
            }
            if (z && !TextUtils.isEmpty(f4217a)) {
                return f4217a;
            }
            if (!c.o(context)) {
                return k.c(String.valueOf(-1002), z2);
            }
            String a2 = c.a.m0.m.a.b().a();
            if (TextUtils.isEmpty(a2)) {
                return k.c(String.valueOf(-1003), z2);
            }
            f4217a = a2;
            return a2;
        }
        return (String) invokeCommon.objValue;
    }
}
