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
    public r1 f22747a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<n> f22748b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f22749c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f22750d;

    /* renamed from: e  reason: collision with root package name */
    public int f22751e;

    /* renamed from: f  reason: collision with root package name */
    public int f22752f;

    /* renamed from: g  reason: collision with root package name */
    public c f22753g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f22754h;

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
        this.f22749c = true;
        this.f22750d = true;
        this.f22751e = 0;
        this.f22752f = 0;
        this.f22754h = true;
        this.f22748b = new ArrayList<>();
        this.f22747a = new r1();
    }
}
