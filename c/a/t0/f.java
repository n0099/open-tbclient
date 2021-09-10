package c.a.t0;

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
    public m f29987a;

    /* renamed from: b  reason: collision with root package name */
    public HashSet<String> f29988b;

    /* renamed from: c  reason: collision with root package name */
    public HashSet<String> f29989c;

    /* renamed from: d  reason: collision with root package name */
    public HashSet<String> f29990d;

    /* renamed from: e  reason: collision with root package name */
    public HashSet<String> f29991e;

    /* renamed from: f  reason: collision with root package name */
    public HashSet<String> f29992f;

    /* renamed from: g  reason: collision with root package name */
    public HashSet<String> f29993g;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<String, Integer> f29994h;

    /* renamed from: i  reason: collision with root package name */
    public HashMap<String, String> f29995i;

    /* renamed from: j  reason: collision with root package name */
    public HashMap<String, l> f29996j;
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
        this.f29987a = new m();
        this.f29988b = new HashSet<>();
        this.f29989c = new HashSet<>();
        this.f29990d = new HashSet<>();
        this.f29991e = new HashSet<>();
        this.f29992f = new HashSet<>();
        this.f29993g = new HashSet<>();
        this.f29994h = new HashMap<>();
        this.f29995i = new HashMap<>();
        this.f29996j = new HashMap<>();
        this.k = new HashSet<>();
        this.l = new HashSet<>();
        this.m = new HashMap<>();
        this.n = new HashMap<>();
        this.o = new HashMap<>();
    }
}
