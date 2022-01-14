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
    public long f26219b;

    /* renamed from: c  reason: collision with root package name */
    public int f26220c;

    /* renamed from: d  reason: collision with root package name */
    public String f26221d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f26222e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f26223f;

    /* renamed from: g  reason: collision with root package name */
    public long f26224g;

    /* renamed from: h  reason: collision with root package name */
    public long f26225h;

    /* renamed from: i  reason: collision with root package name */
    public long f26226i;

    /* renamed from: j  reason: collision with root package name */
    public int f26227j;
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
        this.a = new byte[0];
        this.f26219b = 15000L;
        this.f26220c = -1;
        this.f26221d = "";
        this.f26222e = false;
        this.f26223f = new byte[0];
        this.f26224g = 60000L;
        this.f26225h = -1L;
        this.f26226i = -1L;
        this.f26227j = -1;
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
                return "Request correlationId :" + this.n + ", serviceId :" + this.f26225h + ", methodId :" + this.f26226i + ", connectState :" + this.f26227j + ", isNotify :" + this.f26222e + ", bodySize :" + this.a.length;
            }
            return "Response correlationId " + this.n + ", serviceId :" + this.f26225h + ", methodId :" + this.f26226i + ", errorCode :" + this.f26220c + ", errorMsg :" + this.f26221d + ", intervalMs :" + this.f26224g + ", isNotify :" + this.f26222e + ", bodySize :" + this.f26223f.length;
        }
        return (String) invokeV.objValue;
    }
}
