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
    public long f2270b;

    /* renamed from: c  reason: collision with root package name */
    public long f2271c;

    /* renamed from: d  reason: collision with root package name */
    public long f2272d;

    /* renamed from: e  reason: collision with root package name */
    public long f2273e;

    /* renamed from: f  reason: collision with root package name */
    public long f2274f;

    /* renamed from: g  reason: collision with root package name */
    public long f2275g;

    /* renamed from: h  reason: collision with root package name */
    public long f2276h;

    /* renamed from: i  reason: collision with root package name */
    public int f2277i;

    /* renamed from: j  reason: collision with root package name */
    public long f2278j;

    /* renamed from: k  reason: collision with root package name */
    public long f2279k;
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
        this.f2270b = 0L;
        this.f2271c = 0L;
        this.f2272d = 0L;
        this.f2273e = 0L;
        this.f2274f = 0L;
        this.f2275g = 0L;
        this.f2276h = 0L;
        this.f2277i = 0;
        this.f2278j = 0L;
        this.f2279k = 0L;
        this.l = 0L;
    }
}
