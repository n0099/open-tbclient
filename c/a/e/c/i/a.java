package c.a.e.c.i;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f2078a;

    /* renamed from: b  reason: collision with root package name */
    public long f2079b;

    /* renamed from: c  reason: collision with root package name */
    public long f2080c;

    /* renamed from: d  reason: collision with root package name */
    public long f2081d;

    /* renamed from: e  reason: collision with root package name */
    public long f2082e;

    /* renamed from: f  reason: collision with root package name */
    public long f2083f;

    /* renamed from: g  reason: collision with root package name */
    public long f2084g;

    /* renamed from: h  reason: collision with root package name */
    public long f2085h;

    /* renamed from: i  reason: collision with root package name */
    public int f2086i;

    /* renamed from: j  reason: collision with root package name */
    public long f2087j;
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
        this.f2078a = 0L;
        this.f2079b = 0L;
        this.f2080c = 0L;
        this.f2081d = 0L;
        this.f2082e = 0L;
        this.f2083f = 0L;
        this.f2084g = 0L;
        this.f2085h = 0L;
        this.f2086i = 0;
        this.f2087j = 0L;
        this.k = 0L;
        this.l = 0L;
    }
}
