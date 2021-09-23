package c.a.v0.a;

import android.content.Context;
import c.a.v0.a.f.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f30288a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f30289b;

    /* renamed from: c  reason: collision with root package name */
    public long f30290c;

    /* renamed from: d  reason: collision with root package name */
    public long f30291d;

    /* renamed from: e  reason: collision with root package name */
    public long f30292e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f30293f;

    /* renamed from: g  reason: collision with root package name */
    public int f30294g;

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Context f30295a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f30296b;

        /* renamed from: c  reason: collision with root package name */
        public long f30297c;

        /* renamed from: d  reason: collision with root package name */
        public long f30298d;

        /* renamed from: e  reason: collision with root package name */
        public long f30299e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f30300f;

        /* renamed from: g  reason: collision with root package name */
        public int f30301g;

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
                    return;
                }
            }
            this.f30296b = true;
            this.f30297c = 30000L;
            this.f30298d = 60000L;
            this.f30299e = 10000L;
            this.f30300f = false;
            this.f30301g = 1000;
        }

        public b c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f30295a == null) {
                    i.b("Context must be not empty!");
                    return null;
                }
                return new b(this, (byte) 0);
            }
            return (b) invokeV.objValue;
        }

        public a e(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                this.f30295a = context;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a j(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.f30296b = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a k(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                if (i2 <= 0) {
                    i2 = 0;
                }
                if (i2 >= 1000) {
                    i2 = 1000;
                }
                this.f30301g = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a l(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.f30300f = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a m(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
                this.f30298d = i2 * 60 * 1000;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a n(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j2)) == null) {
                this.f30297c = j2 * 1000;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a o(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j2)) == null) {
                this.f30299e = j2 * 1000;
                return this;
            }
            return (a) invokeJ.objValue;
        }
    }

    public /* synthetic */ b(a aVar, byte b2) {
        this(aVar);
    }

    public final Context a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f30288a : (Context) invokeV.objValue;
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f30289b : invokeV.booleanValue;
    }

    public final long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f30290c : invokeV.longValue;
    }

    public final long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f30291d : invokeV.longValue;
    }

    public final long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f30292e : invokeV.longValue;
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f30293f : invokeV.booleanValue;
    }

    public final int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f30294g : invokeV.intValue;
    }

    public b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30288a = aVar.f30295a;
        this.f30289b = aVar.f30296b;
        this.f30290c = aVar.f30297c;
        this.f30291d = aVar.f30298d;
        this.f30293f = aVar.f30300f;
        this.f30292e = aVar.f30299e;
        this.f30294g = aVar.f30301g;
    }
}
