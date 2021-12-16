package c.a.u0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.HashSet;
/* loaded from: classes9.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public m a;

    /* renamed from: b  reason: collision with root package name */
    public HashSet<String> f26725b;

    /* renamed from: c  reason: collision with root package name */
    public HashSet<String> f26726c;

    /* renamed from: d  reason: collision with root package name */
    public HashSet<String> f26727d;

    /* renamed from: e  reason: collision with root package name */
    public HashSet<String> f26728e;

    /* renamed from: f  reason: collision with root package name */
    public HashSet<String> f26729f;

    /* renamed from: g  reason: collision with root package name */
    public HashSet<String> f26730g;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<String, Integer> f26731h;

    /* renamed from: i  reason: collision with root package name */
    public HashMap<String, String> f26732i;

    /* renamed from: j  reason: collision with root package name */
    public HashMap<String, l> f26733j;

    /* renamed from: k  reason: collision with root package name */
    public HashSet<String> f26734k;
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
        this.a = new m();
        this.f26725b = new HashSet<>();
        this.f26726c = new HashSet<>();
        this.f26727d = new HashSet<>();
        this.f26728e = new HashSet<>();
        this.f26729f = new HashSet<>();
        this.f26730g = new HashSet<>();
        this.f26731h = new HashMap<>();
        this.f26732i = new HashMap<>();
        this.f26733j = new HashMap<>();
        this.f26734k = new HashSet<>();
        this.l = new HashSet<>();
        this.m = new HashMap<>();
        this.n = new HashMap<>();
        this.o = new HashMap<>();
    }
}
