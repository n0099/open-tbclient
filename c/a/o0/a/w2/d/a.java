package c.a.o0.a.w2.d;

import c.a.o0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f9554a;

    /* renamed from: b  reason: collision with root package name */
    public int f9555b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f9556c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f9557d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f9558e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f9559f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f9560g;

    /* renamed from: c.a.o0.a.w2.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0446a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f9561a;

        /* renamed from: b  reason: collision with root package name */
        public int f9562b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f9563c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f9564d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f9565e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f9566f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f9567g;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9563c = true;
            this.f9564d = true;
            this.f9565e = true;
            this.f9566f = false;
            this.f9567g = true;
        }

        public static b b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new b() : (b) invokeV.objValue;
        }

        public a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                a aVar = new a(null);
                aVar.f9555b = this.f9562b;
                aVar.f9556c = this.f9563c;
                aVar.f9558e = this.f9565e;
                aVar.f9557d = this.f9564d;
                aVar.f9554a = this.f9561a;
                aVar.f9559f = this.f9566f;
                aVar.f9560g = this.f9567g;
                return aVar;
            }
            return (a) invokeV.objValue;
        }

        public b c(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                this.f9566f = z;
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public b d(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.f9567g = z;
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public b e(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                this.f9562b = i2;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b f(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                this.f9561a = i2;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b g(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
                this.f9563c = z;
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public b h(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                this.f9565e = z;
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public b i(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
                this.f9564d = z;
                return this;
            }
            return (b) invokeZ.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1442608195, "Lc/a/o0/a/w2/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1442608195, "Lc/a/o0/a/w2/d/a;");
                return;
            }
        }
        boolean z = k.f7049a;
    }

    public /* synthetic */ a(C0446a c0446a) {
        this();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f9560g = true;
    }
}
