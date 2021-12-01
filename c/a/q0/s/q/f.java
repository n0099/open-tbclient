package c.a.q0.s.q;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f12929b;

    /* renamed from: c  reason: collision with root package name */
    public int f12930c;

    /* renamed from: d  reason: collision with root package name */
    public int f12931d;

    /* renamed from: e  reason: collision with root package name */
    public int f12932e;

    /* renamed from: f  reason: collision with root package name */
    public int f12933f;

    /* renamed from: g  reason: collision with root package name */
    public int f12934g;

    /* renamed from: h  reason: collision with root package name */
    public int f12935h;

    /* renamed from: i  reason: collision with root package name */
    public int f12936i;

    /* renamed from: j  reason: collision with root package name */
    public String f12937j;

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
        this.f12929b = 0;
        this.f12930c = 1;
        this.f12931d = 1;
        this.f12932e = 0;
        this.f12933f = 0;
        this.f12934g = 1;
        this.f12935h = 0;
        this.f12936i = 0;
    }
}
