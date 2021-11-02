package b.a.u.a.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f28980a;

    /* renamed from: b  reason: collision with root package name */
    public long f28981b;

    /* renamed from: c  reason: collision with root package name */
    public int f28982c;

    /* renamed from: d  reason: collision with root package name */
    public String f28983d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f28984e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f28985f;

    /* renamed from: g  reason: collision with root package name */
    public long f28986g;

    /* renamed from: h  reason: collision with root package name */
    public long f28987h;

    /* renamed from: i  reason: collision with root package name */
    public long f28988i;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28980a = new byte[0];
        this.f28981b = 15000L;
        this.f28982c = -1;
        this.f28983d = "";
        this.f28984e = false;
        this.f28985f = new byte[0];
        this.f28986g = 60000L;
        this.f28987h = -1L;
        this.f28988i = -1L;
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
                return "Request correlationId :" + this.n + ", serviceId :" + this.f28987h + ", methodId :" + this.f28988i + ", connectState :" + this.j + ", isNotify :" + this.f28984e + ", bodySize :" + this.f28980a.length;
            }
            return "Response correlationId " + this.n + ", serviceId :" + this.f28987h + ", methodId :" + this.f28988i + ", errorCode :" + this.f28982c + ", errorMsg :" + this.f28983d + ", intervalMs :" + this.f28986g + ", isNotify :" + this.f28984e + ", bodySize :" + this.f28985f.length;
        }
        return (String) invokeV.objValue;
    }
}
