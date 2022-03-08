package c.a.d.c.i;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f2454b;

    /* renamed from: c  reason: collision with root package name */
    public long f2455c;

    /* renamed from: d  reason: collision with root package name */
    public long f2456d;

    /* renamed from: e  reason: collision with root package name */
    public long f2457e;

    /* renamed from: f  reason: collision with root package name */
    public long f2458f;

    /* renamed from: g  reason: collision with root package name */
    public long f2459g;

    /* renamed from: h  reason: collision with root package name */
    public long f2460h;

    /* renamed from: i  reason: collision with root package name */
    public int f2461i;

    /* renamed from: j  reason: collision with root package name */
    public long f2462j;
    public long k;
    public long l;

    public a() {
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
        this.a = 0L;
        this.f2454b = 0L;
        this.f2455c = 0L;
        this.f2456d = 0L;
        this.f2457e = 0L;
        this.f2458f = 0L;
        this.f2459g = 0L;
        this.f2460h = 0L;
        this.f2461i = 0;
        this.f2462j = 0L;
        this.k = 0L;
        this.l = 0L;
    }
}
