package c.b.b.l.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f22405b;

    /* renamed from: c  reason: collision with root package name */
    public int f22406c;

    /* renamed from: d  reason: collision with root package name */
    public int f22407d;

    /* renamed from: e  reason: collision with root package name */
    public int f22408e;

    /* renamed from: f  reason: collision with root package name */
    public int f22409f;

    /* renamed from: g  reason: collision with root package name */
    public int f22410g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f22411h;
    public boolean i;
    public boolean j;
    public boolean k;
    public int l;
    public int m;
    public boolean n;
    public boolean o;
    public boolean p;
    public int q;
    public c.b.b.l.a.b0.c r;
    public boolean s;
    public boolean t;
    @Deprecated
    public boolean u;
    public int v;

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
        this.a = 8;
        this.f22405b = 8;
        this.f22406c = 8;
        this.f22407d = 0;
        this.f22408e = 16;
        this.f22409f = 0;
        this.f22410g = 0;
        this.f22411h = true;
        this.i = false;
        this.j = true;
        this.k = false;
        this.l = 1;
        this.m = 0;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = 16;
        this.r = new c.b.b.l.a.b0.a();
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = Integer.MAX_VALUE;
    }
}
