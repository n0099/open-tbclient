package c.p.a.a.a.f;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.p.a.a.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1519a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f34467a;

        /* renamed from: b  reason: collision with root package name */
        public String f34468b;

        /* renamed from: c  reason: collision with root package name */
        public String f34469c;

        /* renamed from: d  reason: collision with root package name */
        public String f34470d;

        /* renamed from: e  reason: collision with root package name */
        public String f34471e;

        public C1519a() {
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

        public C1519a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                this.f34467a = str;
                return this;
            }
            return (C1519a) invokeL.objValue;
        }

        public a b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new a(this) : (a) invokeV.objValue;
        }

        public C1519a d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.f34468b = str;
                return this;
            }
            return (C1519a) invokeL.objValue;
        }

        public C1519a f(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f34470d = str;
                return this;
            }
            return (C1519a) invokeL.objValue;
        }

        public C1519a h(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.f34471e = str;
                return this;
            }
            return (C1519a) invokeL.objValue;
        }
    }

    public a(C1519a c1519a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c1519a};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        String unused = c1519a.f34467a;
        String unused2 = c1519a.f34468b;
        String unused3 = c1519a.f34469c;
        String unused4 = c1519a.f34470d;
        String unused5 = c1519a.f34471e;
    }
}
