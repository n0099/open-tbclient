package c.a.t0.u0.l.d;

import c.a.d.n.e.n;
import c.a.s0.s.q.r1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public r1 a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<n> f24149b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f24150c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f24151d;

    /* renamed from: e  reason: collision with root package name */
    public int f24152e;

    /* renamed from: f  reason: collision with root package name */
    public int f24153f;

    /* renamed from: g  reason: collision with root package name */
    public c f24154g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f24155h;

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
        this.f24150c = true;
        this.f24151d = true;
        this.f24152e = 0;
        this.f24153f = 0;
        this.f24155h = true;
        this.f24149b = new ArrayList<>();
        this.a = new r1();
    }
}
