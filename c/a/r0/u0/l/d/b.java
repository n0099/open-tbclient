package c.a.r0.u0.l.d;

import c.a.d.o.e.n;
import c.a.q0.r.r.r1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public r1 a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<n> f22730b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f22731c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f22732d;

    /* renamed from: e  reason: collision with root package name */
    public int f22733e;

    /* renamed from: f  reason: collision with root package name */
    public int f22734f;

    /* renamed from: g  reason: collision with root package name */
    public c f22735g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f22736h;

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
        this.f22731c = true;
        this.f22732d = true;
        this.f22733e = 0;
        this.f22734f = 0;
        this.f22736h = true;
        this.f22730b = new ArrayList<>();
        this.a = new r1();
    }
}
