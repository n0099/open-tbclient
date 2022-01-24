package c.a.r0.a.a3.d;

import c.a.r0.a.k;
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
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f5329b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5330c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f5331d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5332e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f5333f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f5334g;

    /* renamed from: c.a.r0.a.a3.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0274a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f5335b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f5336c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f5337d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f5338e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f5339f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f5340g;

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
            this.f5336c = true;
            this.f5337d = true;
            this.f5338e = true;
            this.f5339f = false;
            this.f5340g = true;
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
                aVar.f5329b = this.f5335b;
                aVar.f5330c = this.f5336c;
                aVar.f5332e = this.f5338e;
                aVar.f5331d = this.f5337d;
                aVar.a = this.a;
                aVar.f5333f = this.f5339f;
                aVar.f5334g = this.f5340g;
                return aVar;
            }
            return (a) invokeV.objValue;
        }

        public b c(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                this.f5339f = z;
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public b d(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.f5340g = z;
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public b e(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                this.f5335b = i2;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b f(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                this.a = i2;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b g(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
                this.f5336c = z;
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public b h(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                this.f5338e = z;
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public b i(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
                this.f5337d = z;
                return this;
            }
            return (b) invokeZ.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-486726295, "Lc/a/r0/a/a3/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-486726295, "Lc/a/r0/a/a3/d/a;");
                return;
            }
        }
        boolean z = k.a;
    }

    public /* synthetic */ a(C0274a c0274a) {
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
        this.f5334g = true;
    }
}
