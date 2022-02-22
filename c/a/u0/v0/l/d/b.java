package c.a.u0.v0.l.d;

import c.a.d.o.e.n;
import c.a.t0.s.r.r1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public r1 a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<n> f24620b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f24621c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f24622d;

    /* renamed from: e  reason: collision with root package name */
    public int f24623e;

    /* renamed from: f  reason: collision with root package name */
    public int f24624f;

    /* renamed from: g  reason: collision with root package name */
    public c f24625g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f24626h;

    public b() {
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
        this.f24621c = true;
        this.f24622d = true;
        this.f24623e = 0;
        this.f24624f = 0;
        this.f24626h = true;
        this.f24620b = new ArrayList<>();
        this.a = new r1();
    }
}
