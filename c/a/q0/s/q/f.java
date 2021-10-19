package c.a.q0.s.q;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f14189a;

    /* renamed from: b  reason: collision with root package name */
    public int f14190b;

    /* renamed from: c  reason: collision with root package name */
    public int f14191c;

    /* renamed from: d  reason: collision with root package name */
    public int f14192d;

    /* renamed from: e  reason: collision with root package name */
    public int f14193e;

    /* renamed from: f  reason: collision with root package name */
    public int f14194f;

    /* renamed from: g  reason: collision with root package name */
    public int f14195g;

    /* renamed from: h  reason: collision with root package name */
    public int f14196h;

    /* renamed from: i  reason: collision with root package name */
    public int f14197i;

    /* renamed from: j  reason: collision with root package name */
    public String f14198j;

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
        this.f14189a = 0;
        this.f14190b = 0;
        this.f14191c = 1;
        this.f14192d = 1;
        this.f14193e = 0;
        this.f14194f = 0;
        this.f14195g = 1;
        this.f14196h = 0;
        this.f14197i = 0;
    }
}
