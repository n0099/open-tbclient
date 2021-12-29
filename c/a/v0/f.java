package c.a.v0;

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
    public HashSet<String> f27223b;

    /* renamed from: c  reason: collision with root package name */
    public HashSet<String> f27224c;

    /* renamed from: d  reason: collision with root package name */
    public HashSet<String> f27225d;

    /* renamed from: e  reason: collision with root package name */
    public HashSet<String> f27226e;

    /* renamed from: f  reason: collision with root package name */
    public HashSet<String> f27227f;

    /* renamed from: g  reason: collision with root package name */
    public HashSet<String> f27228g;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<String, Integer> f27229h;

    /* renamed from: i  reason: collision with root package name */
    public HashMap<String, String> f27230i;

    /* renamed from: j  reason: collision with root package name */
    public HashMap<String, l> f27231j;

    /* renamed from: k  reason: collision with root package name */
    public HashSet<String> f27232k;
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
        this.f27223b = new HashSet<>();
        this.f27224c = new HashSet<>();
        this.f27225d = new HashSet<>();
        this.f27226e = new HashSet<>();
        this.f27227f = new HashSet<>();
        this.f27228g = new HashSet<>();
        this.f27229h = new HashMap<>();
        this.f27230i = new HashMap<>();
        this.f27231j = new HashMap<>();
        this.f27232k = new HashSet<>();
        this.l = new HashSet<>();
        this.m = new HashMap<>();
        this.n = new HashMap<>();
        this.o = new HashMap<>();
    }
}
