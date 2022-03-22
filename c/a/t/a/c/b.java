package c.a.t.a.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] a;

    /* renamed from: b  reason: collision with root package name */
    public long f21278b;

    /* renamed from: c  reason: collision with root package name */
    public int f21279c;

    /* renamed from: d  reason: collision with root package name */
    public String f21280d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f21281e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f21282f;

    /* renamed from: g  reason: collision with root package name */
    public long f21283g;

    /* renamed from: h  reason: collision with root package name */
    public long f21284h;
    public long i;
    public int j;
    public boolean k;
    public boolean l;
    public boolean m;
    public long n;
    public boolean o;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new byte[0];
        this.f21278b = 15000L;
        this.f21279c = -1;
        this.f21280d = "";
        this.f21281e = false;
        this.f21282f = new byte[0];
        this.f21283g = 60000L;
        this.f21284h = -1L;
        this.i = -1L;
        this.j = -1;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = -1L;
        this.o = false;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.m) {
                return "Request correlationId :" + this.n + ", serviceId :" + this.f21284h + ", methodId :" + this.i + ", connectState :" + this.j + ", isNotify :" + this.f21281e + ", bodySize :" + this.a.length;
            }
            return "Response correlationId " + this.n + ", serviceId :" + this.f21284h + ", methodId :" + this.i + ", errorCode :" + this.f21279c + ", errorMsg :" + this.f21280d + ", intervalMs :" + this.f21283g + ", isNotify :" + this.f21281e + ", bodySize :" + this.f21282f.length;
        }
        return (String) invokeV.objValue;
    }
}
