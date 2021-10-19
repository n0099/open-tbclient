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
    public byte[] f30252a;

    /* renamed from: b  reason: collision with root package name */
    public long f30253b;

    /* renamed from: c  reason: collision with root package name */
    public int f30254c;

    /* renamed from: d  reason: collision with root package name */
    public String f30255d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30256e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f30257f;

    /* renamed from: g  reason: collision with root package name */
    public long f30258g;

    /* renamed from: h  reason: collision with root package name */
    public long f30259h;

    /* renamed from: i  reason: collision with root package name */
    public long f30260i;

    /* renamed from: j  reason: collision with root package name */
    public int f30261j;
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
        this.f30252a = new byte[0];
        this.f30253b = 15000L;
        this.f30254c = -1;
        this.f30255d = "";
        this.f30256e = false;
        this.f30257f = new byte[0];
        this.f30258g = 60000L;
        this.f30259h = -1L;
        this.f30260i = -1L;
        this.f30261j = -1;
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
                return "Request correlationId :" + this.n + ", serviceId :" + this.f30259h + ", methodId :" + this.f30260i + ", connectState :" + this.f30261j + ", isNotify :" + this.f30256e + ", bodySize :" + this.f30252a.length;
            }
            return "Response correlationId " + this.n + ", serviceId :" + this.f30259h + ", methodId :" + this.f30260i + ", errorCode :" + this.f30254c + ", errorMsg :" + this.f30255d + ", intervalMs :" + this.f30258g + ", isNotify :" + this.f30256e + ", bodySize :" + this.f30257f.length;
        }
        return (String) invokeV.objValue;
    }
}
