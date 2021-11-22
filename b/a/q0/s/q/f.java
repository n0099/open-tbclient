package b.a.q0.s.q;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f14079a;

    /* renamed from: b  reason: collision with root package name */
    public int f14080b;

    /* renamed from: c  reason: collision with root package name */
    public int f14081c;

    /* renamed from: d  reason: collision with root package name */
    public int f14082d;

    /* renamed from: e  reason: collision with root package name */
    public int f14083e;

    /* renamed from: f  reason: collision with root package name */
    public int f14084f;

    /* renamed from: g  reason: collision with root package name */
    public int f14085g;

    /* renamed from: h  reason: collision with root package name */
    public int f14086h;

    /* renamed from: i  reason: collision with root package name */
    public int f14087i;
    public String j;

    public f() {
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
        this.f14079a = 0;
        this.f14080b = 0;
        this.f14081c = 1;
        this.f14082d = 1;
        this.f14083e = 0;
        this.f14084f = 0;
        this.f14085g = 1;
        this.f14086h = 0;
        this.f14087i = 0;
    }
}
