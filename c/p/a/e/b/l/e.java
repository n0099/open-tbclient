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
    public b f35053a;

    /* renamed from: b  reason: collision with root package name */
    public b f35054b;

    /* renamed from: c  reason: collision with root package name */
    public int f35055c;

    /* renamed from: d  reason: collision with root package name */
    public int f35056d;

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
        public long f35057a;

        /* renamed from: b  reason: collision with root package name */
        public long f35058b;

        /* renamed from: c  reason: collision with root package name */
        public b f35059c;

        /* renamed from: d  reason: collision with root package name */
        public b f35060d;

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
        this.f35056d = 10;
    }

    public final b a() {
        InterceptResult invokeV;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f35055c >= this.f35056d && (bVar = this.f35054b) != null) {
                b bVar2 = bVar.f35060d;
                bVar.f35060d = null;
                this.f35054b = bVar2;
                if (bVar2 != null) {
                    bVar2.f35059c = null;
                }
                return bVar;
            }
            this.f35055c++;
            return new b(null);
        }
        return (b) invokeV.objValue;
    }

    public final b b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            b bVar = this.f35053a;
            b bVar2 = null;
            while (bVar != null && bVar.f35058b > j2) {
                bVar2 = bVar;
                bVar = bVar.f35059c;
            }
            return (bVar == null || bVar2 == null || bVar == bVar2 || j2 - bVar.f35058b >= bVar2.f35058b - j2) ? bVar2 : bVar;
        }
        return (b) invokeJ.objValue;
    }

    public boolean c(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            synchronized (this) {
                b bVar = this.f35053a;
                if (bVar != null) {
                    if (j2 >= bVar.f35057a && j3 >= bVar.f35058b) {
                        b bVar2 = bVar.f35059c;
                        if (bVar2 != null && j3 - bVar2.f35058b < 1000) {
                            bVar.f35057a = j2;
                            bVar.f35058b = j3;
                            return true;
                        }
                    }
                    return false;
                }
                b a2 = a();
                a2.f35057a = j2;
                a2.f35058b = j3;
                if (bVar != null) {
                    a2.f35059c = bVar;
                    bVar.f35060d = a2;
                }
                this.f35053a = a2;
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
                b bVar = this.f35053a;
                if (bVar == null) {
                    return -1L;
                }
                b b2 = b(j2);
                if (b2 == null) {
                    return -1L;
                }
                long j4 = bVar.f35057a - b2.f35057a;
                long j5 = j3 - b2.f35058b;
                if (j4 < 0 || j5 <= 0) {
                    return -1L;
                }
                return j4 / j5;
            }
        }
        return invokeCommon.longValue;
    }
}
