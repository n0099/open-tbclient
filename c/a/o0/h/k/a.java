package c.a.o0.h.k;

import android.text.TextUtils;
import c.a.o0.a.l0.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Service
/* loaded from: classes3.dex */
public class a implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.o0.h.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0572a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static String f11254a;
        public transient /* synthetic */ FieldHolder $fh;

        public static String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
                if (TextUtils.isEmpty(f11254a)) {
                    f11254a = c.a.o0.a.s2.b.c();
                }
                return f11254a;
            }
            return (String) invokeV.objValue;
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.o0.a.l0.h
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? C0572a.a() : (String) invokeV.objValue;
    }

    @Override // c.a.o0.a.l0.h
    public c.a.o0.a.l0.a b(String str, c.a.o0.a.l0.n.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bVar, v8ThreadDelegatePolicy)) == null) ? new b(str, bVar, v8ThreadDelegatePolicy) : (c.a.o0.a.l0.a) invokeLLL.objValue;
    }
}
