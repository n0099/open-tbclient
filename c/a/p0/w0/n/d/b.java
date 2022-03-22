package c.a.p0.w0.n.d;

import c.a.d.o.e.n;
import c.a.o0.r.r.o1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public o1 a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<n> f19543b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f19544c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f19545d;

    /* renamed from: e  reason: collision with root package name */
    public int f19546e;

    /* renamed from: f  reason: collision with root package name */
    public int f19547f;

    /* renamed from: g  reason: collision with root package name */
    public c f19548g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f19549h;

    public b() {
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
        this.f19544c = true;
        this.f19545d = true;
        this.f19546e = 0;
        this.f19547f = 0;
        this.f19549h = true;
        this.f19543b = new ArrayList<>();
        this.a = new o1();
    }
}
