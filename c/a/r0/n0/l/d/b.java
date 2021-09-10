package c.a.r0.n0.l.d;

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
    public r1 f22731a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<n> f22732b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f22733c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f22734d;

    /* renamed from: e  reason: collision with root package name */
    public int f22735e;

    /* renamed from: f  reason: collision with root package name */
    public int f22736f;

    /* renamed from: g  reason: collision with root package name */
    public c f22737g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f22738h;

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
        this.f22733c = true;
        this.f22734d = true;
        this.f22735e = 0;
        this.f22736f = 0;
        this.f22738h = true;
        this.f22732b = new ArrayList<>();
        this.f22731a = new r1();
    }
}
