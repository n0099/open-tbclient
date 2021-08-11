package c.a.n0.b.l;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import c.a.n0.a.u.e.a.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Service
/* loaded from: classes.dex */
public class u implements c.a.n0.a.p.d.q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public class b implements c.a.n0.a.p.d.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(u uVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.n0.a.p.d.j
        @NonNull
        public c.a.n0.a.e2.c.j.a a(Activity activity, boolean z, String str, String str2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{activity, Boolean.valueOf(z), str, str2})) == null) ? new n(activity, z, str, str2) : (c.a.n0.a.e2.c.j.a) invokeCommon.objValue;
        }

        @Override // c.a.n0.a.p.d.j
        @NonNull
        public c.a.n0.a.e2.c.j.f b(Activity activity, c.C0374c c0374c, Bundle bundle) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, c0374c, bundle)) == null) ? new s(activity, c0374c, bundle) : (c.a.n0.a.e2.c.j.f) invokeLLL.objValue;
        }

        @Override // c.a.n0.a.p.d.j
        @NonNull
        public c.a.n0.a.e2.c.j.g c(Activity activity, String str, String str2, boolean z, boolean z2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? new t(activity, str, str2, z, z2) : (c.a.n0.a.e2.c.j.g) invokeCommon.objValue;
        }

        @Override // c.a.n0.a.p.d.j
        @NonNull
        public c.a.n0.a.e2.c.j.b d(Context context, boolean z, boolean z2, String[] strArr, String str, boolean z3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{context, Boolean.valueOf(z), Boolean.valueOf(z2), strArr, str, Boolean.valueOf(z3)})) == null) ? new o(context, z, z2, strArr, str, z3) : (c.a.n0.a.e2.c.j.b) invokeCommon.objValue;
        }

        @Override // c.a.n0.a.p.d.j
        @NonNull
        public c.a.n0.a.e2.c.j.e e(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) ? new r(context) : (c.a.n0.a.e2.c.j.e) invokeL.objValue;
        }

        @Override // c.a.n0.a.p.d.j
        @NonNull
        public c.a.n0.a.e2.c.j.d f(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) ? new q(context) : (c.a.n0.a.e2.c.j.d) invokeL.objValue;
        }

        @Override // c.a.n0.a.p.d.j
        @NonNull
        public c.a.n0.a.e2.c.j.c g(Context context, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, context, str)) == null) ? new p(context, str) : (c.a.n0.a.e2.c.j.c) invokeLL.objValue;
        }

        public /* synthetic */ b(u uVar, a aVar) {
            this(uVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2010362627, "Lc/a/n0/b/l/u;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2010362627, "Lc/a/n0/b/l/u;");
                return;
            }
        }
        boolean z = c.a.n0.a.k.f6803a;
    }

    public u() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // c.a.n0.a.p.d.q
    public c.a.n0.a.p.d.b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new m() : (c.a.n0.a.p.d.b) invokeV.objValue;
    }

    @Override // c.a.n0.a.p.d.q
    public c.a.n0.a.p.d.j b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new b(this, null) : (c.a.n0.a.p.d.j) invokeV.objValue;
    }
}
