package c.a.s0.s0;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class h extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long A;
    public long B;
    public long C;
    public long D;
    public HashMap<String, String> E;

    /* renamed from: b  reason: collision with root package name */
    public boolean f13742b;

    /* renamed from: c  reason: collision with root package name */
    public long f13743c;

    /* renamed from: d  reason: collision with root package name */
    public long f13744d;

    /* renamed from: e  reason: collision with root package name */
    public long f13745e;

    /* renamed from: f  reason: collision with root package name */
    public long f13746f;

    /* renamed from: g  reason: collision with root package name */
    public long f13747g;

    /* renamed from: h  reason: collision with root package name */
    public long f13748h;

    /* renamed from: i  reason: collision with root package name */
    public long f13749i;

    /* renamed from: j  reason: collision with root package name */
    public long f13750j;
    public long k;
    public long l;
    public long m;
    public long n;
    public long o;
    public long p;
    public long q;
    public long r;
    public boolean s;
    public int t;
    public long u;
    public int v;
    public long w;
    public long x;
    public boolean y;
    public long z;

    public h() {
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
        this.f13749i = 0L;
        this.f13750j = 0L;
        this.n = 0L;
        this.p = 0L;
        this.q = 0L;
        this.r = 0L;
        this.w = 0L;
        this.x = 0L;
        this.y = false;
        this.E = new HashMap<>();
    }

    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || c.a.d.f.p.m.isEmpty(str) || c.a.d.f.p.m.isEmpty(str2)) {
            return;
        }
        this.E.put(str, str2);
    }

    public void c() {
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (mVar = (m) k.d().e(this.a)) == null) {
            return;
        }
        mVar.b(this);
    }

    public void d(int i2) {
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || (mVar = (m) k.d().e(this.a)) == null) {
            return;
        }
        mVar.c(this, i2);
    }

    public void e(boolean z) {
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (mVar = (m) k.d().e(this.a)) == null) {
            return;
        }
        mVar.d(this, z);
    }

    public h(int i2, boolean z, ResponsedMessage<?> responsedMessage, long j2, long j3, long j4, boolean z2, long j5, long j6, long j7) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Boolean.valueOf(z), responsedMessage, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Boolean.valueOf(z2), Long.valueOf(j5), Long.valueOf(j6), Long.valueOf(j7)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f13749i = 0L;
        this.f13750j = 0L;
        this.n = 0L;
        this.p = 0L;
        this.q = 0L;
        this.r = 0L;
        this.w = 0L;
        this.x = 0L;
        this.y = false;
        this.E = new HashMap<>();
        if (responsedMessage == null) {
            return;
        }
        this.a = i2;
        this.s = z;
        if (z) {
            this.r = responsedMessage.getDownSize();
            this.A = responsedMessage.getOrginalMessage().getClientLogID();
            this.z = responsedMessage.getOrginalMessage().getSquencedId();
            c.a.d.c.i.a aVar = responsedMessage.performanceData;
            this.w = aVar.k;
            this.x = aVar.l;
            this.t = aVar.f2653i;
            this.u = aVar.f2654j;
        } else {
            this.q = responsedMessage.getDownSize();
            this.z = responsedMessage.getOrginalMessage().getSquencedId();
        }
        this.f13743c = j2;
        this.f13744d = j5;
        this.f13745e = j3;
        this.o = j4;
        this.m = j6;
        this.f13742b = !responsedMessage.hasError();
        c.a.d.c.i.a aVar2 = responsedMessage.performanceData;
        this.f13746f = aVar2.a;
        this.f13747g = aVar2.f2646b;
        this.f13748h = aVar2.f2647c;
        this.f13749i = aVar2.f2648d;
        this.f13750j = aVar2.f2649e;
        this.k = aVar2.f2650f;
        this.l = aVar2.f2651g;
        long j8 = aVar2.f2652h;
        this.n = j8;
        this.n = j8 + (responsedMessage.getProcessTime() - responsedMessage.getStartTime());
        this.v = responsedMessage.getError();
        this.y = z2;
        this.p = j7;
    }
}
