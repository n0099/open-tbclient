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
    public int f13557b;

    /* renamed from: c  reason: collision with root package name */
    public int f13558c;

    /* renamed from: d  reason: collision with root package name */
    public int f13559d;

    /* renamed from: e  reason: collision with root package name */
    public int f13560e;

    /* renamed from: f  reason: collision with root package name */
    public int f13561f;

    /* renamed from: g  reason: collision with root package name */
    public int f13562g;

    /* renamed from: h  reason: collision with root package name */
    public int f13563h;

    /* renamed from: i  reason: collision with root package name */
    public int f13564i;

    /* renamed from: j  reason: collision with root package name */
    public String f13565j;

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
        this.f13557b = 0;
        this.f13558c = 1;
        this.f13559d = 1;
        this.f13560e = 0;
        this.f13561f = 0;
        this.f13562g = 1;
        this.f13563h = 0;
        this.f13564i = 0;
    }
}
