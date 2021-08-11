package c.a.r0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.HashSet;
/* loaded from: classes4.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public m f29501a;

    /* renamed from: b  reason: collision with root package name */
    public HashSet<String> f29502b;

    /* renamed from: c  reason: collision with root package name */
    public HashSet<String> f29503c;

    /* renamed from: d  reason: collision with root package name */
    public HashSet<String> f29504d;

    /* renamed from: e  reason: collision with root package name */
    public HashSet<String> f29505e;

    /* renamed from: f  reason: collision with root package name */
    public HashSet<String> f29506f;

    /* renamed from: g  reason: collision with root package name */
    public HashSet<String> f29507g;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<String, Integer> f29508h;

    /* renamed from: i  reason: collision with root package name */
    public HashMap<String, String> f29509i;

    /* renamed from: j  reason: collision with root package name */
    public HashMap<String, l> f29510j;
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
        this.f29501a = new m();
        this.f29502b = new HashSet<>();
        this.f29503c = new HashSet<>();
        this.f29504d = new HashSet<>();
        this.f29505e = new HashSet<>();
        this.f29506f = new HashSet<>();
        this.f29507g = new HashSet<>();
        this.f29508h = new HashMap<>();
        this.f29509i = new HashMap<>();
        this.f29510j = new HashMap<>();
        this.k = new HashSet<>();
        this.l = new HashSet<>();
        this.m = new HashMap<>();
        this.n = new HashMap<>();
        this.o = new HashMap<>();
    }
}
