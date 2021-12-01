package c.b.b.l.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f27398b;

    /* renamed from: c  reason: collision with root package name */
    public int f27399c;

    /* renamed from: d  reason: collision with root package name */
    public int f27400d;

    /* renamed from: e  reason: collision with root package name */
    public int f27401e;

    /* renamed from: f  reason: collision with root package name */
    public int f27402f;

    /* renamed from: g  reason: collision with root package name */
    public int f27403g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f27404h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f27405i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f27406j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f27407k;
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
        this.f27398b = 8;
        this.f27399c = 8;
        this.f27400d = 0;
        this.f27401e = 16;
        this.f27402f = 0;
        this.f27403g = 0;
        this.f27404h = true;
        this.f27405i = false;
        this.f27406j = true;
        this.f27407k = false;
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
