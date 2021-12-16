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
    public long f26581b;

    /* renamed from: c  reason: collision with root package name */
    public int f26582c;

    /* renamed from: d  reason: collision with root package name */
    public String f26583d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f26584e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f26585f;

    /* renamed from: g  reason: collision with root package name */
    public long f26586g;

    /* renamed from: h  reason: collision with root package name */
    public long f26587h;

    /* renamed from: i  reason: collision with root package name */
    public long f26588i;

    /* renamed from: j  reason: collision with root package name */
    public int f26589j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f26590k;
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
        this.f26581b = 15000L;
        this.f26582c = -1;
        this.f26583d = "";
        this.f26584e = false;
        this.f26585f = new byte[0];
        this.f26586g = 60000L;
        this.f26587h = -1L;
        this.f26588i = -1L;
        this.f26589j = -1;
        this.f26590k = false;
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
                return "Request correlationId :" + this.n + ", serviceId :" + this.f26587h + ", methodId :" + this.f26588i + ", connectState :" + this.f26589j + ", isNotify :" + this.f26584e + ", bodySize :" + this.a.length;
            }
            return "Response correlationId " + this.n + ", serviceId :" + this.f26587h + ", methodId :" + this.f26588i + ", errorCode :" + this.f26582c + ", errorMsg :" + this.f26583d + ", intervalMs :" + this.f26586g + ", isNotify :" + this.f26584e + ", bodySize :" + this.f26585f.length;
        }
        return (String) invokeV.objValue;
    }
}
