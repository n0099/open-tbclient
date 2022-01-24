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
    public long f2748b;

    /* renamed from: c  reason: collision with root package name */
    public long f2749c;

    /* renamed from: d  reason: collision with root package name */
    public long f2750d;

    /* renamed from: e  reason: collision with root package name */
    public long f2751e;

    /* renamed from: f  reason: collision with root package name */
    public long f2752f;

    /* renamed from: g  reason: collision with root package name */
    public long f2753g;

    /* renamed from: h  reason: collision with root package name */
    public long f2754h;

    /* renamed from: i  reason: collision with root package name */
    public int f2755i;

    /* renamed from: j  reason: collision with root package name */
    public long f2756j;
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
        this.f2748b = 0L;
        this.f2749c = 0L;
        this.f2750d = 0L;
        this.f2751e = 0L;
        this.f2752f = 0L;
        this.f2753g = 0L;
        this.f2754h = 0L;
        this.f2755i = 0;
        this.f2756j = 0L;
        this.k = 0L;
        this.l = 0L;
    }
}
