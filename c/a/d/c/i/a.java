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
    public long f1828b;

    /* renamed from: c  reason: collision with root package name */
    public long f1829c;

    /* renamed from: d  reason: collision with root package name */
    public long f1830d;

    /* renamed from: e  reason: collision with root package name */
    public long f1831e;

    /* renamed from: f  reason: collision with root package name */
    public long f1832f;

    /* renamed from: g  reason: collision with root package name */
    public long f1833g;

    /* renamed from: h  reason: collision with root package name */
    public long f1834h;

    /* renamed from: i  reason: collision with root package name */
    public int f1835i;

    /* renamed from: j  reason: collision with root package name */
    public long f1836j;
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
        this.f1828b = 0L;
        this.f1829c = 0L;
        this.f1830d = 0L;
        this.f1831e = 0L;
        this.f1832f = 0L;
        this.f1833g = 0L;
        this.f1834h = 0L;
        this.f1835i = 0;
        this.f1836j = 0L;
        this.k = 0L;
        this.l = 0L;
    }
}
