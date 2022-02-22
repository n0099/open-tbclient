package c.a.t0.s.r;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f13841b;

    /* renamed from: c  reason: collision with root package name */
    public int f13842c;

    /* renamed from: d  reason: collision with root package name */
    public int f13843d;

    /* renamed from: e  reason: collision with root package name */
    public int f13844e;

    /* renamed from: f  reason: collision with root package name */
    public int f13845f;

    /* renamed from: g  reason: collision with root package name */
    public int f13846g;

    /* renamed from: h  reason: collision with root package name */
    public int f13847h;

    /* renamed from: i  reason: collision with root package name */
    public int f13848i;

    /* renamed from: j  reason: collision with root package name */
    public String f13849j;

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
        this.a = 0;
        this.f13841b = 0;
        this.f13842c = 1;
        this.f13843d = 1;
        this.f13844e = 0;
        this.f13845f = 0;
        this.f13846g = 1;
        this.f13847h = 0;
        this.f13848i = 0;
    }
}
