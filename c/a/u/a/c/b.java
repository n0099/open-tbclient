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
    public byte[] f30205a;

    /* renamed from: b  reason: collision with root package name */
    public long f30206b;

    /* renamed from: c  reason: collision with root package name */
    public int f30207c;

    /* renamed from: d  reason: collision with root package name */
    public String f30208d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30209e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f30210f;

    /* renamed from: g  reason: collision with root package name */
    public long f30211g;

    /* renamed from: h  reason: collision with root package name */
    public long f30212h;

    /* renamed from: i  reason: collision with root package name */
    public long f30213i;

    /* renamed from: j  reason: collision with root package name */
    public int f30214j;
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
        this.f30205a = new byte[0];
        this.f30206b = 15000L;
        this.f30207c = -1;
        this.f30208d = "";
        this.f30209e = false;
        this.f30210f = new byte[0];
        this.f30211g = 60000L;
        this.f30212h = -1L;
        this.f30213i = -1L;
        this.f30214j = -1;
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
                return "Request correlationId :" + this.n + ", serviceId :" + this.f30212h + ", methodId :" + this.f30213i + ", connectState :" + this.f30214j + ", isNotify :" + this.f30209e + ", bodySize :" + this.f30205a.length;
            }
            return "Response correlationId " + this.n + ", serviceId :" + this.f30212h + ", methodId :" + this.f30213i + ", errorCode :" + this.f30207c + ", errorMsg :" + this.f30208d + ", intervalMs :" + this.f30211g + ", isNotify :" + this.f30209e + ", bodySize :" + this.f30210f.length;
        }
        return (String) invokeV.objValue;
    }
}
