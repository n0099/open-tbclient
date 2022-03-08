package c.a.q0.r.r;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f13257b;

    /* renamed from: c  reason: collision with root package name */
    public int f13258c;

    /* renamed from: d  reason: collision with root package name */
    public int f13259d;

    /* renamed from: e  reason: collision with root package name */
    public int f13260e;

    /* renamed from: f  reason: collision with root package name */
    public int f13261f;

    /* renamed from: g  reason: collision with root package name */
    public int f13262g;

    /* renamed from: h  reason: collision with root package name */
    public int f13263h;

    /* renamed from: i  reason: collision with root package name */
    public int f13264i;

    /* renamed from: j  reason: collision with root package name */
    public String f13265j;

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
        this.f13257b = 0;
        this.f13258c = 1;
        this.f13259d = 1;
        this.f13260e = 0;
        this.f13261f = 0;
        this.f13262g = 1;
        this.f13263h = 0;
        this.f13264i = 0;
    }
}
