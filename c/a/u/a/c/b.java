package c.a.u.a.c;

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
    public long f26179b;

    /* renamed from: c  reason: collision with root package name */
    public int f26180c;

    /* renamed from: d  reason: collision with root package name */
    public String f26181d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f26182e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f26183f;

    /* renamed from: g  reason: collision with root package name */
    public long f26184g;

    /* renamed from: h  reason: collision with root package name */
    public long f26185h;

    /* renamed from: i  reason: collision with root package name */
    public long f26186i;

    /* renamed from: j  reason: collision with root package name */
    public int f26187j;
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
        this.f26179b = 15000L;
        this.f26180c = -1;
        this.f26181d = "";
        this.f26182e = false;
        this.f26183f = new byte[0];
        this.f26184g = 60000L;
        this.f26185h = -1L;
        this.f26186i = -1L;
        this.f26187j = -1;
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
                return "Request correlationId :" + this.n + ", serviceId :" + this.f26185h + ", methodId :" + this.f26186i + ", connectState :" + this.f26187j + ", isNotify :" + this.f26182e + ", bodySize :" + this.a.length;
            }
            return "Response correlationId " + this.n + ", serviceId :" + this.f26185h + ", methodId :" + this.f26186i + ", errorCode :" + this.f26180c + ", errorMsg :" + this.f26181d + ", intervalMs :" + this.f26184g + ", isNotify :" + this.f26182e + ", bodySize :" + this.f26183f.length;
        }
        return (String) invokeV.objValue;
    }
}
