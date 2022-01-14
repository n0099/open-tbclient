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
    public long f2646b;

    /* renamed from: c  reason: collision with root package name */
    public long f2647c;

    /* renamed from: d  reason: collision with root package name */
    public long f2648d;

    /* renamed from: e  reason: collision with root package name */
    public long f2649e;

    /* renamed from: f  reason: collision with root package name */
    public long f2650f;

    /* renamed from: g  reason: collision with root package name */
    public long f2651g;

    /* renamed from: h  reason: collision with root package name */
    public long f2652h;

    /* renamed from: i  reason: collision with root package name */
    public int f2653i;

    /* renamed from: j  reason: collision with root package name */
    public long f2654j;
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
        this.f2646b = 0L;
        this.f2647c = 0L;
        this.f2648d = 0L;
        this.f2649e = 0L;
        this.f2650f = 0L;
        this.f2651g = 0L;
        this.f2652h = 0L;
        this.f2653i = 0;
        this.f2654j = 0L;
        this.k = 0L;
        this.l = 0L;
    }
}
