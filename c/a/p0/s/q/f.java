package c.a.p0.s.q;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f14218a;

    /* renamed from: b  reason: collision with root package name */
    public int f14219b;

    /* renamed from: c  reason: collision with root package name */
    public int f14220c;

    /* renamed from: d  reason: collision with root package name */
    public int f14221d;

    /* renamed from: e  reason: collision with root package name */
    public int f14222e;

    /* renamed from: f  reason: collision with root package name */
    public int f14223f;

    /* renamed from: g  reason: collision with root package name */
    public int f14224g;

    /* renamed from: h  reason: collision with root package name */
    public int f14225h;

    /* renamed from: i  reason: collision with root package name */
    public int f14226i;

    /* renamed from: j  reason: collision with root package name */
    public String f14227j;

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
        this.f14218a = 0;
        this.f14219b = 0;
        this.f14220c = 1;
        this.f14221d = 1;
        this.f14222e = 0;
        this.f14223f = 0;
        this.f14224g = 1;
        this.f14225h = 0;
        this.f14226i = 0;
    }
}
