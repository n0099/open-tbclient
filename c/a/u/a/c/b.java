package c.a.u.a.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] a;

    /* renamed from: b  reason: collision with root package name */
    public long f27020b;

    /* renamed from: c  reason: collision with root package name */
    public int f27021c;

    /* renamed from: d  reason: collision with root package name */
    public String f27022d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f27023e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f27024f;

    /* renamed from: g  reason: collision with root package name */
    public long f27025g;

    /* renamed from: h  reason: collision with root package name */
    public long f27026h;

    /* renamed from: i  reason: collision with root package name */
    public long f27027i;

    /* renamed from: j  reason: collision with root package name */
    public int f27028j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f27029k;
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
        this.a = new byte[0];
        this.f27020b = 15000L;
        this.f27021c = -1;
        this.f27022d = "";
        this.f27023e = false;
        this.f27024f = new byte[0];
        this.f27025g = 60000L;
        this.f27026h = -1L;
        this.f27027i = -1L;
        this.f27028j = -1;
        this.f27029k = false;
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
                return "Request correlationId :" + this.n + ", serviceId :" + this.f27026h + ", methodId :" + this.f27027i + ", connectState :" + this.f27028j + ", isNotify :" + this.f27023e + ", bodySize :" + this.a.length;
            }
            return "Response correlationId " + this.n + ", serviceId :" + this.f27026h + ", methodId :" + this.f27027i + ", errorCode :" + this.f27021c + ", errorMsg :" + this.f27022d + ", intervalMs :" + this.f27025g + ", isNotify :" + this.f27023e + ", bodySize :" + this.f27024f.length;
        }
        return (String) invokeV.objValue;
    }
}
