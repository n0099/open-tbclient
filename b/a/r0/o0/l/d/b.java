package b.a.r0.o0.l.d;

import b.a.e.m.e.n;
import b.a.q0.s.q.r1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public r1 f23299a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<n> f23300b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f23301c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f23302d;

    /* renamed from: e  reason: collision with root package name */
    public int f23303e;

    /* renamed from: f  reason: collision with root package name */
    public int f23304f;

    /* renamed from: g  reason: collision with root package name */
    public c f23305g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f23306h;

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
        this.f23301c = true;
        this.f23302d = true;
        this.f23303e = 0;
        this.f23304f = 0;
        this.f23306h = true;
        this.f23300b = new ArrayList<>();
        this.f23299a = new r1();
    }
}
