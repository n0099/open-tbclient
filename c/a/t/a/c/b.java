package c.a.t.a.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] a;

    /* renamed from: b  reason: collision with root package name */
    public long f26197b;

    /* renamed from: c  reason: collision with root package name */
    public int f26198c;

    /* renamed from: d  reason: collision with root package name */
    public String f26199d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f26200e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f26201f;

    /* renamed from: g  reason: collision with root package name */
    public long f26202g;

    /* renamed from: h  reason: collision with root package name */
    public long f26203h;

    /* renamed from: i  reason: collision with root package name */
    public long f26204i;

    /* renamed from: j  reason: collision with root package name */
    public int f26205j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f26206k;
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
        this.f26197b = 15000L;
        this.f26198c = -1;
        this.f26199d = "";
        this.f26200e = false;
        this.f26201f = new byte[0];
        this.f26202g = 60000L;
        this.f26203h = -1L;
        this.f26204i = -1L;
        this.f26205j = -1;
        this.f26206k = false;
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
                return "Request correlationId :" + this.n + ", serviceId :" + this.f26203h + ", methodId :" + this.f26204i + ", connectState :" + this.f26205j + ", isNotify :" + this.f26200e + ", bodySize :" + this.a.length;
            }
            return "Response correlationId " + this.n + ", serviceId :" + this.f26203h + ", methodId :" + this.f26204i + ", errorCode :" + this.f26198c + ", errorMsg :" + this.f26199d + ", intervalMs :" + this.f26202g + ", isNotify :" + this.f26200e + ", bodySize :" + this.f26201f.length;
        }
        return (String) invokeV.objValue;
    }
}
