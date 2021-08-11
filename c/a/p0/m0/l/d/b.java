package c.a.p0.m0.l.d;

import c.a.e.k.e.n;
import c.a.o0.s.q.q1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public q1 f21833a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<n> f21834b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f21835c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f21836d;

    /* renamed from: e  reason: collision with root package name */
    public int f21837e;

    /* renamed from: f  reason: collision with root package name */
    public int f21838f;

    /* renamed from: g  reason: collision with root package name */
    public c f21839g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f21840h;

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
        this.f21835c = true;
        this.f21836d = true;
        this.f21837e = 0;
        this.f21838f = 0;
        this.f21840h = true;
        this.f21834b = new ArrayList<>();
        this.f21833a = new q1();
    }
}
