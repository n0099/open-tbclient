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
    public long f2664b;

    /* renamed from: c  reason: collision with root package name */
    public long f2665c;

    /* renamed from: d  reason: collision with root package name */
    public long f2666d;

    /* renamed from: e  reason: collision with root package name */
    public long f2667e;

    /* renamed from: f  reason: collision with root package name */
    public long f2668f;

    /* renamed from: g  reason: collision with root package name */
    public long f2669g;

    /* renamed from: h  reason: collision with root package name */
    public long f2670h;

    /* renamed from: i  reason: collision with root package name */
    public int f2671i;

    /* renamed from: j  reason: collision with root package name */
    public long f2672j;

    /* renamed from: k  reason: collision with root package name */
    public long f2673k;
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
        this.f2664b = 0L;
        this.f2665c = 0L;
        this.f2666d = 0L;
        this.f2667e = 0L;
        this.f2668f = 0L;
        this.f2669g = 0L;
        this.f2670h = 0L;
        this.f2671i = 0;
        this.f2672j = 0L;
        this.f2673k = 0L;
        this.l = 0L;
    }
}
