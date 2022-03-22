package c.a.r0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.HashSet;
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public m a;

    /* renamed from: b  reason: collision with root package name */
    public HashSet<String> f21123b;

    /* renamed from: c  reason: collision with root package name */
    public HashSet<String> f21124c;

    /* renamed from: d  reason: collision with root package name */
    public HashSet<String> f21125d;

    /* renamed from: e  reason: collision with root package name */
    public HashSet<String> f21126e;

    /* renamed from: f  reason: collision with root package name */
    public HashSet<String> f21127f;

    /* renamed from: g  reason: collision with root package name */
    public HashSet<String> f21128g;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<String, Integer> f21129h;
    public HashMap<String, String> i;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new m();
        this.f21123b = new HashSet<>();
        this.f21124c = new HashSet<>();
        this.f21125d = new HashSet<>();
        this.f21126e = new HashSet<>();
        this.f21127f = new HashSet<>();
        this.f21128g = new HashSet<>();
        this.f21129h = new HashMap<>();
        this.i = new HashMap<>();
        this.j = new HashMap<>();
        this.k = new HashSet<>();
        this.l = new HashSet<>();
        this.m = new HashMap<>();
        this.n = new HashMap<>();
        this.o = new HashMap<>();
    }
}
