package c.a.v.a.c;

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
    public long f26480b;

    /* renamed from: c  reason: collision with root package name */
    public int f26481c;

    /* renamed from: d  reason: collision with root package name */
    public String f26482d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f26483e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f26484f;

    /* renamed from: g  reason: collision with root package name */
    public long f26485g;

    /* renamed from: h  reason: collision with root package name */
    public long f26486h;

    /* renamed from: i  reason: collision with root package name */
    public long f26487i;

    /* renamed from: j  reason: collision with root package name */
    public int f26488j;
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
        this.f26480b = 15000L;
        this.f26481c = -1;
        this.f26482d = "";
        this.f26483e = false;
        this.f26484f = new byte[0];
        this.f26485g = 60000L;
        this.f26486h = -1L;
        this.f26487i = -1L;
        this.f26488j = -1;
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
                return "Request correlationId :" + this.n + ", serviceId :" + this.f26486h + ", methodId :" + this.f26487i + ", connectState :" + this.f26488j + ", isNotify :" + this.f26483e + ", bodySize :" + this.a.length;
            }
            return "Response correlationId " + this.n + ", serviceId :" + this.f26486h + ", methodId :" + this.f26487i + ", errorCode :" + this.f26481c + ", errorMsg :" + this.f26482d + ", intervalMs :" + this.f26485g + ", isNotify :" + this.f26483e + ", bodySize :" + this.f26484f.length;
        }
        return (String) invokeV.objValue;
    }
}
