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
    public m f28760a;

    /* renamed from: b  reason: collision with root package name */
    public HashSet<String> f28761b;

    /* renamed from: c  reason: collision with root package name */
    public HashSet<String> f28762c;

    /* renamed from: d  reason: collision with root package name */
    public HashSet<String> f28763d;

    /* renamed from: e  reason: collision with root package name */
    public HashSet<String> f28764e;

    /* renamed from: f  reason: collision with root package name */
    public HashSet<String> f28765f;

    /* renamed from: g  reason: collision with root package name */
    public HashSet<String> f28766g;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<String, Integer> f28767h;

    /* renamed from: i  reason: collision with root package name */
    public HashMap<String, String> f28768i;
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
        this.f28760a = new m();
        this.f28761b = new HashSet<>();
        this.f28762c = new HashSet<>();
        this.f28763d = new HashSet<>();
        this.f28764e = new HashSet<>();
        this.f28765f = new HashSet<>();
        this.f28766g = new HashSet<>();
        this.f28767h = new HashMap<>();
        this.f28768i = new HashMap<>();
        this.j = new HashMap<>();
        this.k = new HashSet<>();
        this.l = new HashSet<>();
        this.m = new HashMap<>();
        this.n = new HashMap<>();
        this.o = new HashMap<>();
    }
}
