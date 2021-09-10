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
    public byte[] f30184a;

    /* renamed from: b  reason: collision with root package name */
    public long f30185b;

    /* renamed from: c  reason: collision with root package name */
    public int f30186c;

    /* renamed from: d  reason: collision with root package name */
    public String f30187d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30188e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f30189f;

    /* renamed from: g  reason: collision with root package name */
    public long f30190g;

    /* renamed from: h  reason: collision with root package name */
    public long f30191h;

    /* renamed from: i  reason: collision with root package name */
    public long f30192i;

    /* renamed from: j  reason: collision with root package name */
    public int f30193j;
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
        this.f30184a = new byte[0];
        this.f30185b = 15000L;
        this.f30186c = -1;
        this.f30187d = "";
        this.f30188e = false;
        this.f30189f = new byte[0];
        this.f30190g = 60000L;
        this.f30191h = -1L;
        this.f30192i = -1L;
        this.f30193j = -1;
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
                return "Request correlationId :" + this.n + ", serviceId :" + this.f30191h + ", methodId :" + this.f30192i + ", connectState :" + this.f30193j + ", isNotify :" + this.f30188e + ", bodySize :" + this.f30184a.length;
            }
            return "Response correlationId " + this.n + ", serviceId :" + this.f30191h + ", methodId :" + this.f30192i + ", errorCode :" + this.f30186c + ", errorMsg :" + this.f30187d + ", intervalMs :" + this.f30190g + ", isNotify :" + this.f30188e + ", bodySize :" + this.f30189f.length;
        }
        return (String) invokeV.objValue;
    }
}
