package c.a.o0.w.p;

import android.content.Context;
import c.a.o0.b0.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class c implements c.a.o0.b0.a {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<String, Integer> a;

    /* renamed from: b  reason: collision with root package name */
    public static final ArrayList<Integer> f11515b;

    /* renamed from: c  reason: collision with root package name */
    public static final HashMap<String, Integer> f11516c;

    /* renamed from: d  reason: collision with root package name */
    public static final HashMap<String, String> f11517d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1078480983, "Lc/a/o0/w/p/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1078480983, "Lc/a/o0/w/p/c;");
                return;
            }
        }
        a = new HashMap<>(200);
        f11515b = new ArrayList<>(180);
        f11516c = new HashMap<>(180);
        f11517d = new HashMap<>(180);
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            try {
                Class.forName("c.a.o0.w.p.a");
            } catch (Throwable th) {
                BdLog.e(th);
            }
            try {
                Class.forName("c.a.p0.v0.a");
            } catch (Throwable th2) {
                BdLog.e(th2);
            }
            try {
                Class.forName("c.a.p0.v0.b");
            } catch (Throwable th3) {
                BdLog.e(th3);
            }
        }
    }

    @Override // c.a.o0.b0.a
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            f();
            return f11515b.size();
        }
        return invokeV.intValue;
    }

    @Override // c.a.o0.b0.a
    public String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            f();
            return f11517d.get(str);
        }
        return (String) invokeL.objValue;
    }

    @Override // c.a.o0.b0.a
    public a.C0786a c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str)) == null) {
            return null;
        }
        return (a.C0786a) invokeLL.objValue;
    }

    @Override // c.a.o0.b0.a
    public int d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            f();
            Integer num = a.get(str);
            if ("video_icon".equals(str)) {
                return Integer.valueOf((int) R.drawable.ico_link_video).intValue();
            }
            if (num != null) {
                return num.intValue();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @Override // c.a.o0.b0.a
    public int e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            f();
            Integer num = f11516c.get(str);
            if (num != null) {
                return num.intValue();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && f11517d.isEmpty()) {
            g();
        }
    }
}
