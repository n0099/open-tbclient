package c.p.a.e.b.l;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f35291a;

    /* renamed from: b  reason: collision with root package name */
    public b f35292b;

    /* renamed from: c  reason: collision with root package name */
    public int f35293c;

    /* renamed from: d  reason: collision with root package name */
    public int f35294d;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f35295a;

        /* renamed from: b  reason: collision with root package name */
        public long f35296b;

        /* renamed from: c  reason: collision with root package name */
        public b f35297c;

        /* renamed from: d  reason: collision with root package name */
        public b f35298d;

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
                }
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public e() {
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
        this.f35294d = 10;
    }

    public final b a() {
        InterceptResult invokeV;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f35293c >= this.f35294d && (bVar = this.f35292b) != null) {
                b bVar2 = bVar.f35298d;
                bVar.f35298d = null;
                this.f35292b = bVar2;
                if (bVar2 != null) {
                    bVar2.f35297c = null;
                }
                return bVar;
            }
            this.f35293c++;
            return new b(null);
        }
        return (b) invokeV.objValue;
    }

    public final b b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            b bVar = this.f35291a;
            b bVar2 = null;
            while (bVar != null && bVar.f35296b > j2) {
                bVar2 = bVar;
                bVar = bVar.f35297c;
            }
            return (bVar == null || bVar2 == null || bVar == bVar2 || j2 - bVar.f35296b >= bVar2.f35296b - j2) ? bVar2 : bVar;
        }
        return (b) invokeJ.objValue;
    }

    public boolean c(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            synchronized (this) {
                b bVar = this.f35291a;
                if (bVar != null) {
                    if (j2 >= bVar.f35295a && j3 >= bVar.f35296b) {
                        b bVar2 = bVar.f35297c;
                        if (bVar2 != null && j3 - bVar2.f35296b < 1000) {
                            bVar.f35295a = j2;
                            bVar.f35296b = j3;
                            return true;
                        }
                    }
                    return false;
                }
                b a2 = a();
                a2.f35295a = j2;
                a2.f35296b = j3;
                if (bVar != null) {
                    a2.f35297c = bVar;
                    bVar.f35298d = a2;
                }
                this.f35291a = a2;
                return true;
            }
        }
        return invokeCommon.booleanValue;
    }

    public long d(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            synchronized (this) {
                b bVar = this.f35291a;
                if (bVar == null) {
                    return -1L;
                }
                b b2 = b(j2);
                if (b2 == null) {
                    return -1L;
                }
                long j4 = bVar.f35295a - b2.f35295a;
                long j5 = j3 - b2.f35296b;
                if (j4 < 0 || j5 <= 0) {
                    return -1L;
                }
                return j4 / j5;
            }
        }
        return invokeCommon.longValue;
    }
}
