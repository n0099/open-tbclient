package c.a.r0.o0.l.d;

import c.a.e.l.e.n;
import c.a.q0.s.q.r1;
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
    public r1 f22931a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<n> f22932b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f22933c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f22934d;

    /* renamed from: e  reason: collision with root package name */
    public int f22935e;

    /* renamed from: f  reason: collision with root package name */
    public int f22936f;

    /* renamed from: g  reason: collision with root package name */
    public c f22937g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f22938h;

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
        this.f22933c = true;
        this.f22934d = true;
        this.f22935e = 0;
        this.f22936f = 0;
        this.f22938h = true;
        this.f22932b = new ArrayList<>();
        this.f22931a = new r1();
    }
}
