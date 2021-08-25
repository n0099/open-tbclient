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
    public byte[] f30079a;

    /* renamed from: b  reason: collision with root package name */
    public long f30080b;

    /* renamed from: c  reason: collision with root package name */
    public int f30081c;

    /* renamed from: d  reason: collision with root package name */
    public String f30082d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30083e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f30084f;

    /* renamed from: g  reason: collision with root package name */
    public long f30085g;

    /* renamed from: h  reason: collision with root package name */
    public long f30086h;

    /* renamed from: i  reason: collision with root package name */
    public long f30087i;

    /* renamed from: j  reason: collision with root package name */
    public int f30088j;
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
        this.f30079a = new byte[0];
        this.f30080b = 15000L;
        this.f30081c = -1;
        this.f30082d = "";
        this.f30083e = false;
        this.f30084f = new byte[0];
        this.f30085g = 60000L;
        this.f30086h = -1L;
        this.f30087i = -1L;
        this.f30088j = -1;
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
                return "Request correlationId :" + this.n + ", serviceId :" + this.f30086h + ", methodId :" + this.f30087i + ", connectState :" + this.f30088j + ", isNotify :" + this.f30083e + ", bodySize :" + this.f30079a.length;
            }
            return "Response correlationId " + this.n + ", serviceId :" + this.f30086h + ", methodId :" + this.f30087i + ", errorCode :" + this.f30081c + ", errorMsg :" + this.f30082d + ", intervalMs :" + this.f30085g + ", isNotify :" + this.f30083e + ", bodySize :" + this.f30084f.length;
        }
        return (String) invokeV.objValue;
    }
}
