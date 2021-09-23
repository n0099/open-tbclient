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
    public m f30008a;

    /* renamed from: b  reason: collision with root package name */
    public HashSet<String> f30009b;

    /* renamed from: c  reason: collision with root package name */
    public HashSet<String> f30010c;

    /* renamed from: d  reason: collision with root package name */
    public HashSet<String> f30011d;

    /* renamed from: e  reason: collision with root package name */
    public HashSet<String> f30012e;

    /* renamed from: f  reason: collision with root package name */
    public HashSet<String> f30013f;

    /* renamed from: g  reason: collision with root package name */
    public HashSet<String> f30014g;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<String, Integer> f30015h;

    /* renamed from: i  reason: collision with root package name */
    public HashMap<String, String> f30016i;

    /* renamed from: j  reason: collision with root package name */
    public HashMap<String, l> f30017j;
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
        this.f30008a = new m();
        this.f30009b = new HashSet<>();
        this.f30010c = new HashSet<>();
        this.f30011d = new HashSet<>();
        this.f30012e = new HashSet<>();
        this.f30013f = new HashSet<>();
        this.f30014g = new HashSet<>();
        this.f30015h = new HashMap<>();
        this.f30016i = new HashMap<>();
        this.f30017j = new HashMap<>();
        this.k = new HashSet<>();
        this.l = new HashSet<>();
        this.m = new HashMap<>();
        this.n = new HashMap<>();
        this.o = new HashMap<>();
    }
}
