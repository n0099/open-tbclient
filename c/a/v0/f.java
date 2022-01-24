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
    public HashSet<String> f26442b;

    /* renamed from: c  reason: collision with root package name */
    public HashSet<String> f26443c;

    /* renamed from: d  reason: collision with root package name */
    public HashSet<String> f26444d;

    /* renamed from: e  reason: collision with root package name */
    public HashSet<String> f26445e;

    /* renamed from: f  reason: collision with root package name */
    public HashSet<String> f26446f;

    /* renamed from: g  reason: collision with root package name */
    public HashSet<String> f26447g;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<String, Integer> f26448h;

    /* renamed from: i  reason: collision with root package name */
    public HashMap<String, String> f26449i;

    /* renamed from: j  reason: collision with root package name */
    public HashMap<String, l> f26450j;
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
        this.a = new m();
        this.f26442b = new HashSet<>();
        this.f26443c = new HashSet<>();
        this.f26444d = new HashSet<>();
        this.f26445e = new HashSet<>();
        this.f26446f = new HashSet<>();
        this.f26447g = new HashSet<>();
        this.f26448h = new HashMap<>();
        this.f26449i = new HashMap<>();
        this.f26450j = new HashMap<>();
        this.k = new HashSet<>();
        this.l = new HashSet<>();
        this.m = new HashMap<>();
        this.n = new HashMap<>();
        this.o = new HashMap<>();
    }
}
