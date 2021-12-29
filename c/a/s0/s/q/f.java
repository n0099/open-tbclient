package c.a.s0.s.q;

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
    public int f13685b;

    /* renamed from: c  reason: collision with root package name */
    public int f13686c;

    /* renamed from: d  reason: collision with root package name */
    public int f13687d;

    /* renamed from: e  reason: collision with root package name */
    public int f13688e;

    /* renamed from: f  reason: collision with root package name */
    public int f13689f;

    /* renamed from: g  reason: collision with root package name */
    public int f13690g;

    /* renamed from: h  reason: collision with root package name */
    public int f13691h;

    /* renamed from: i  reason: collision with root package name */
    public int f13692i;

    /* renamed from: j  reason: collision with root package name */
    public String f13693j;

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
        this.f13685b = 0;
        this.f13686c = 1;
        this.f13687d = 1;
        this.f13688e = 0;
        this.f13689f = 0;
        this.f13690g = 1;
        this.f13691h = 0;
        this.f13692i = 0;
    }
}
