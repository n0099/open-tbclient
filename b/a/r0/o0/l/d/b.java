package b.a.r0.o0.l.d;

import b.a.e.l.e.n;
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
    public r1 f21800a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<n> f21801b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f21802c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f21803d;

    /* renamed from: e  reason: collision with root package name */
    public int f21804e;

    /* renamed from: f  reason: collision with root package name */
    public int f21805f;

    /* renamed from: g  reason: collision with root package name */
    public c f21806g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f21807h;

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
        this.f21802c = true;
        this.f21803d = true;
        this.f21804e = 0;
        this.f21805f = 0;
        this.f21807h = true;
        this.f21801b = new ArrayList<>();
        this.f21800a = new r1();
    }
}
