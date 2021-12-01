package c.a.t0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.HashSet;
/* loaded from: classes7.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public m a;

    /* renamed from: b  reason: collision with root package name */
    public HashSet<String> f26341b;

    /* renamed from: c  reason: collision with root package name */
    public HashSet<String> f26342c;

    /* renamed from: d  reason: collision with root package name */
    public HashSet<String> f26343d;

    /* renamed from: e  reason: collision with root package name */
    public HashSet<String> f26344e;

    /* renamed from: f  reason: collision with root package name */
    public HashSet<String> f26345f;

    /* renamed from: g  reason: collision with root package name */
    public HashSet<String> f26346g;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<String, Integer> f26347h;

    /* renamed from: i  reason: collision with root package name */
    public HashMap<String, String> f26348i;

    /* renamed from: j  reason: collision with root package name */
    public HashMap<String, l> f26349j;

    /* renamed from: k  reason: collision with root package name */
    public HashSet<String> f26350k;
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
        this.f26341b = new HashSet<>();
        this.f26342c = new HashSet<>();
        this.f26343d = new HashSet<>();
        this.f26344e = new HashSet<>();
        this.f26345f = new HashSet<>();
        this.f26346g = new HashSet<>();
        this.f26347h = new HashMap<>();
        this.f26348i = new HashMap<>();
        this.f26349j = new HashMap<>();
        this.f26350k = new HashSet<>();
        this.l = new HashSet<>();
        this.m = new HashMap<>();
        this.n = new HashMap<>();
        this.o = new HashMap<>();
    }
}
