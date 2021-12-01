package c.a.r0.u0.l.d;

import c.a.d.m.e.n;
import c.a.q0.s.q.r1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public r1 a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<n> f24304b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f24305c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f24306d;

    /* renamed from: e  reason: collision with root package name */
    public int f24307e;

    /* renamed from: f  reason: collision with root package name */
    public int f24308f;

    /* renamed from: g  reason: collision with root package name */
    public c f24309g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f24310h;

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
        this.f24305c = true;
        this.f24306d = true;
        this.f24307e = 0;
        this.f24308f = 0;
        this.f24310h = true;
        this.f24304b = new ArrayList<>();
        this.a = new r1();
    }
}
