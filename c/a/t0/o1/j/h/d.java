package c.a.t0.o1.j.h;

import c.a.d.n.e.n;
import c.a.s0.s.q.l0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<n> a;

    /* renamed from: b  reason: collision with root package name */
    public int f21203b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f21204c;

    /* renamed from: d  reason: collision with root package name */
    public int f21205d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.s0.s.q.n f21206e;

    /* renamed from: f  reason: collision with root package name */
    public l0 f21207f;

    public d() {
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
        this.f21203b = 0;
        this.f21204c = true;
        this.f21205d = 1;
    }
}
