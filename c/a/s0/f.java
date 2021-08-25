package c.a.s0;

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
    public m f29870a;

    /* renamed from: b  reason: collision with root package name */
    public HashSet<String> f29871b;

    /* renamed from: c  reason: collision with root package name */
    public HashSet<String> f29872c;

    /* renamed from: d  reason: collision with root package name */
    public HashSet<String> f29873d;

    /* renamed from: e  reason: collision with root package name */
    public HashSet<String> f29874e;

    /* renamed from: f  reason: collision with root package name */
    public HashSet<String> f29875f;

    /* renamed from: g  reason: collision with root package name */
    public HashSet<String> f29876g;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<String, Integer> f29877h;

    /* renamed from: i  reason: collision with root package name */
    public HashMap<String, String> f29878i;

    /* renamed from: j  reason: collision with root package name */
    public HashMap<String, l> f29879j;
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
        this.f29870a = new m();
        this.f29871b = new HashSet<>();
        this.f29872c = new HashSet<>();
        this.f29873d = new HashSet<>();
        this.f29874e = new HashSet<>();
        this.f29875f = new HashSet<>();
        this.f29876g = new HashSet<>();
        this.f29877h = new HashMap<>();
        this.f29878i = new HashMap<>();
        this.f29879j = new HashMap<>();
        this.k = new HashSet<>();
        this.l = new HashSet<>();
        this.m = new HashMap<>();
        this.n = new HashMap<>();
        this.o = new HashMap<>();
    }
}
