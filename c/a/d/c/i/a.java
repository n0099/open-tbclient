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
    public long f2014b;

    /* renamed from: c  reason: collision with root package name */
    public long f2015c;

    /* renamed from: d  reason: collision with root package name */
    public long f2016d;

    /* renamed from: e  reason: collision with root package name */
    public long f2017e;

    /* renamed from: f  reason: collision with root package name */
    public long f2018f;

    /* renamed from: g  reason: collision with root package name */
    public long f2019g;

    /* renamed from: h  reason: collision with root package name */
    public long f2020h;
    public int i;
    public long j;
    public long k;
    public long l;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0L;
        this.f2014b = 0L;
        this.f2015c = 0L;
        this.f2016d = 0L;
        this.f2017e = 0L;
        this.f2018f = 0L;
        this.f2019g = 0L;
        this.f2020h = 0L;
        this.i = 0;
        this.j = 0L;
        this.k = 0L;
        this.l = 0L;
    }
}
