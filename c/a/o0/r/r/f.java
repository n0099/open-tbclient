package c.a.o0.r.r;

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
    public int f10852b;

    /* renamed from: c  reason: collision with root package name */
    public int f10853c;

    /* renamed from: d  reason: collision with root package name */
    public int f10854d;

    /* renamed from: e  reason: collision with root package name */
    public int f10855e;

    /* renamed from: f  reason: collision with root package name */
    public int f10856f;

    /* renamed from: g  reason: collision with root package name */
    public int f10857g;

    /* renamed from: h  reason: collision with root package name */
    public int f10858h;
    public int i;
    public String j;

    public f() {
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
        this.a = 0;
        this.f10852b = 0;
        this.f10853c = 1;
        this.f10854d = 1;
        this.f10855e = 0;
        this.f10856f = 0;
        this.f10857g = 1;
        this.f10858h = 0;
        this.i = 0;
    }
}
