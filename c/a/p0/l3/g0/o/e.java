package c.a.p0.l3.g0.o;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f16197b;

    /* renamed from: c  reason: collision with root package name */
    public long f16198c;

    /* renamed from: d  reason: collision with root package name */
    public long f16199d;

    /* renamed from: e  reason: collision with root package name */
    public long f16200e;

    /* renamed from: f  reason: collision with root package name */
    public String f16201f;

    /* renamed from: g  reason: collision with root package name */
    public int f16202g;

    /* renamed from: h  reason: collision with root package name */
    public int f16203h;
    public String i;
    public String j;
    public String k;
    public String l;

    public e() {
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
        this.f16197b = -1L;
        this.f16200e = -1L;
        this.f16201f = "";
        this.i = null;
    }
}
