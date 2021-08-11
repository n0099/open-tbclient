package c.a.u.a.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f29828a;

    /* renamed from: b  reason: collision with root package name */
    public long f29829b;

    /* renamed from: c  reason: collision with root package name */
    public int f29830c;

    /* renamed from: d  reason: collision with root package name */
    public String f29831d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f29832e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f29833f;

    /* renamed from: g  reason: collision with root package name */
    public long f29834g;

    /* renamed from: h  reason: collision with root package name */
    public long f29835h;

    /* renamed from: i  reason: collision with root package name */
    public long f29836i;

    /* renamed from: j  reason: collision with root package name */
    public int f29837j;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f29828a = new byte[0];
        this.f29829b = 15000L;
        this.f29830c = -1;
        this.f29831d = "";
        this.f29832e = false;
        this.f29833f = new byte[0];
        this.f29834g = 60000L;
        this.f29835h = -1L;
        this.f29836i = -1L;
        this.f29837j = -1;
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
                return "Request correlationId :" + this.n + ", serviceId :" + this.f29835h + ", methodId :" + this.f29836i + ", connectState :" + this.f29837j + ", isNotify :" + this.f29832e + ", bodySize :" + this.f29828a.length;
            }
            return "Response correlationId " + this.n + ", serviceId :" + this.f29835h + ", methodId :" + this.f29836i + ", errorCode :" + this.f29830c + ", errorMsg :" + this.f29831d + ", intervalMs :" + this.f29834g + ", isNotify :" + this.f29832e + ", bodySize :" + this.f29833f.length;
        }
        return (String) invokeV.objValue;
    }
}
