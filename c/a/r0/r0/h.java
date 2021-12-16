package c.a.r0.r0;

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
    public boolean f12845b;

    /* renamed from: c  reason: collision with root package name */
    public long f12846c;

    /* renamed from: d  reason: collision with root package name */
    public long f12847d;

    /* renamed from: e  reason: collision with root package name */
    public long f12848e;

    /* renamed from: f  reason: collision with root package name */
    public long f12849f;

    /* renamed from: g  reason: collision with root package name */
    public long f12850g;

    /* renamed from: h  reason: collision with root package name */
    public long f12851h;

    /* renamed from: i  reason: collision with root package name */
    public long f12852i;

    /* renamed from: j  reason: collision with root package name */
    public long f12853j;

    /* renamed from: k  reason: collision with root package name */
    public long f12854k;
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
        this.f12852i = 0L;
        this.f12853j = 0L;
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
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || c.a.d.f.p.l.isEmpty(str) || c.a.d.f.p.l.isEmpty(str2)) {
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
        this.f12852i = 0L;
        this.f12853j = 0L;
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
            this.w = aVar.f2246k;
            this.x = aVar.l;
            this.t = aVar.f2244i;
            this.u = aVar.f2245j;
        } else {
            this.q = responsedMessage.getDownSize();
            this.z = responsedMessage.getOrginalMessage().getSquencedId();
        }
        this.f12846c = j2;
        this.f12847d = j5;
        this.f12848e = j3;
        this.o = j4;
        this.m = j6;
        this.f12845b = !responsedMessage.hasError();
        c.a.d.c.i.a aVar2 = responsedMessage.performanceData;
        this.f12849f = aVar2.a;
        this.f12850g = aVar2.f2237b;
        this.f12851h = aVar2.f2238c;
        this.f12852i = aVar2.f2239d;
        this.f12853j = aVar2.f2240e;
        this.f12854k = aVar2.f2241f;
        this.l = aVar2.f2242g;
        long j8 = aVar2.f2243h;
        this.n = j8;
        this.n = j8 + (responsedMessage.getProcessTime() - responsedMessage.getStartTime());
        this.v = responsedMessage.getError();
        this.y = z2;
        this.p = j7;
    }
}
