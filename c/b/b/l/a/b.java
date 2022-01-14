package c.b.b.l.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f27012b;

    /* renamed from: c  reason: collision with root package name */
    public int f27013c;

    /* renamed from: d  reason: collision with root package name */
    public int f27014d;

    /* renamed from: e  reason: collision with root package name */
    public int f27015e;

    /* renamed from: f  reason: collision with root package name */
    public int f27016f;

    /* renamed from: g  reason: collision with root package name */
    public int f27017g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f27018h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f27019i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f27020j;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 8;
        this.f27012b = 8;
        this.f27013c = 8;
        this.f27014d = 0;
        this.f27015e = 16;
        this.f27016f = 0;
        this.f27017g = 0;
        this.f27018h = true;
        this.f27019i = false;
        this.f27020j = true;
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
