package c.a.q0.m0.l.d;

import c.a.e.l.e.n;
import c.a.p0.s.q.q1;
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
    public q1 f22163a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<n> f22164b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f22165c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f22166d;

    /* renamed from: e  reason: collision with root package name */
    public int f22167e;

    /* renamed from: f  reason: collision with root package name */
    public int f22168f;

    /* renamed from: g  reason: collision with root package name */
    public c f22169g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f22170h;

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
        this.f22165c = true;
        this.f22166d = true;
        this.f22167e = 0;
        this.f22168f = 0;
        this.f22170h = true;
        this.f22164b = new ArrayList<>();
        this.f22163a = new q1();
    }
}
