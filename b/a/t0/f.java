package b.a.t0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.HashSet;
/* loaded from: classes6.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public m f29629a;

    /* renamed from: b  reason: collision with root package name */
    public HashSet<String> f29630b;

    /* renamed from: c  reason: collision with root package name */
    public HashSet<String> f29631c;

    /* renamed from: d  reason: collision with root package name */
    public HashSet<String> f29632d;

    /* renamed from: e  reason: collision with root package name */
    public HashSet<String> f29633e;

    /* renamed from: f  reason: collision with root package name */
    public HashSet<String> f29634f;

    /* renamed from: g  reason: collision with root package name */
    public HashSet<String> f29635g;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<String, Integer> f29636h;

    /* renamed from: i  reason: collision with root package name */
    public HashMap<String, String> f29637i;
    public HashMap<String, l> j;
    public HashSet<String> k;
    public HashSet<String> l;
    public HashMap<String, Integer> m;
    public HashMap<String, Integer> n;
    public HashMap<String, Integer> o;

    public f() {
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
        this.f29629a = new m();
        this.f29630b = new HashSet<>();
        this.f29631c = new HashSet<>();
        this.f29632d = new HashSet<>();
        this.f29633e = new HashSet<>();
        this.f29634f = new HashSet<>();
        this.f29635g = new HashSet<>();
        this.f29636h = new HashMap<>();
        this.f29637i = new HashMap<>();
        this.j = new HashMap<>();
        this.k = new HashSet<>();
        this.l = new HashSet<>();
        this.m = new HashMap<>();
        this.n = new HashMap<>();
        this.o = new HashMap<>();
    }
}
