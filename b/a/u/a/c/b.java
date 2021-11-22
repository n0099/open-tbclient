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
    public byte[] f29849a;

    /* renamed from: b  reason: collision with root package name */
    public long f29850b;

    /* renamed from: c  reason: collision with root package name */
    public int f29851c;

    /* renamed from: d  reason: collision with root package name */
    public String f29852d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f29853e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f29854f;

    /* renamed from: g  reason: collision with root package name */
    public long f29855g;

    /* renamed from: h  reason: collision with root package name */
    public long f29856h;

    /* renamed from: i  reason: collision with root package name */
    public long f29857i;
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
        this.f29849a = new byte[0];
        this.f29850b = 15000L;
        this.f29851c = -1;
        this.f29852d = "";
        this.f29853e = false;
        this.f29854f = new byte[0];
        this.f29855g = 60000L;
        this.f29856h = -1L;
        this.f29857i = -1L;
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
                return "Request correlationId :" + this.n + ", serviceId :" + this.f29856h + ", methodId :" + this.f29857i + ", connectState :" + this.j + ", isNotify :" + this.f29853e + ", bodySize :" + this.f29849a.length;
            }
            return "Response correlationId " + this.n + ", serviceId :" + this.f29856h + ", methodId :" + this.f29857i + ", errorCode :" + this.f29851c + ", errorMsg :" + this.f29852d + ", intervalMs :" + this.f29855g + ", isNotify :" + this.f29853e + ", bodySize :" + this.f29854f.length;
        }
        return (String) invokeV.objValue;
    }
}
