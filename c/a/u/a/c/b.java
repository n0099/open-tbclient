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
    public long f26247b;

    /* renamed from: c  reason: collision with root package name */
    public int f26248c;

    /* renamed from: d  reason: collision with root package name */
    public String f26249d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f26250e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f26251f;

    /* renamed from: g  reason: collision with root package name */
    public long f26252g;

    /* renamed from: h  reason: collision with root package name */
    public long f26253h;

    /* renamed from: i  reason: collision with root package name */
    public long f26254i;

    /* renamed from: j  reason: collision with root package name */
    public int f26255j;
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
        this.f26247b = 15000L;
        this.f26248c = -1;
        this.f26249d = "";
        this.f26250e = false;
        this.f26251f = new byte[0];
        this.f26252g = 60000L;
        this.f26253h = -1L;
        this.f26254i = -1L;
        this.f26255j = -1;
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
                return "Request correlationId :" + this.n + ", serviceId :" + this.f26253h + ", methodId :" + this.f26254i + ", connectState :" + this.f26255j + ", isNotify :" + this.f26250e + ", bodySize :" + this.a.length;
            }
            return "Response correlationId " + this.n + ", serviceId :" + this.f26253h + ", methodId :" + this.f26254i + ", errorCode :" + this.f26248c + ", errorMsg :" + this.f26249d + ", intervalMs :" + this.f26252g + ", isNotify :" + this.f26250e + ", bodySize :" + this.f26251f.length;
        }
        return (String) invokeV.objValue;
    }
}
