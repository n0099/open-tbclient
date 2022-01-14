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
    public HashSet<String> f26414b;

    /* renamed from: c  reason: collision with root package name */
    public HashSet<String> f26415c;

    /* renamed from: d  reason: collision with root package name */
    public HashSet<String> f26416d;

    /* renamed from: e  reason: collision with root package name */
    public HashSet<String> f26417e;

    /* renamed from: f  reason: collision with root package name */
    public HashSet<String> f26418f;

    /* renamed from: g  reason: collision with root package name */
    public HashSet<String> f26419g;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<String, Integer> f26420h;

    /* renamed from: i  reason: collision with root package name */
    public HashMap<String, String> f26421i;

    /* renamed from: j  reason: collision with root package name */
    public HashMap<String, l> f26422j;
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
        this.f26414b = new HashSet<>();
        this.f26415c = new HashSet<>();
        this.f26416d = new HashSet<>();
        this.f26417e = new HashSet<>();
        this.f26418f = new HashSet<>();
        this.f26419g = new HashSet<>();
        this.f26420h = new HashMap<>();
        this.f26421i = new HashMap<>();
        this.f26422j = new HashMap<>();
        this.k = new HashSet<>();
        this.l = new HashSet<>();
        this.m = new HashMap<>();
        this.n = new HashMap<>();
        this.o = new HashMap<>();
    }
}
