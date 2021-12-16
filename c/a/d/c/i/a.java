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
    public long f2237b;

    /* renamed from: c  reason: collision with root package name */
    public long f2238c;

    /* renamed from: d  reason: collision with root package name */
    public long f2239d;

    /* renamed from: e  reason: collision with root package name */
    public long f2240e;

    /* renamed from: f  reason: collision with root package name */
    public long f2241f;

    /* renamed from: g  reason: collision with root package name */
    public long f2242g;

    /* renamed from: h  reason: collision with root package name */
    public long f2243h;

    /* renamed from: i  reason: collision with root package name */
    public int f2244i;

    /* renamed from: j  reason: collision with root package name */
    public long f2245j;

    /* renamed from: k  reason: collision with root package name */
    public long f2246k;
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
        this.f2237b = 0L;
        this.f2238c = 0L;
        this.f2239d = 0L;
        this.f2240e = 0L;
        this.f2241f = 0L;
        this.f2242g = 0L;
        this.f2243h = 0L;
        this.f2244i = 0;
        this.f2245j = 0L;
        this.f2246k = 0L;
        this.l = 0L;
    }
}
