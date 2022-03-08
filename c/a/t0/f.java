package c.a.t0;

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
    public HashSet<String> f25995b;

    /* renamed from: c  reason: collision with root package name */
    public HashSet<String> f25996c;

    /* renamed from: d  reason: collision with root package name */
    public HashSet<String> f25997d;

    /* renamed from: e  reason: collision with root package name */
    public HashSet<String> f25998e;

    /* renamed from: f  reason: collision with root package name */
    public HashSet<String> f25999f;

    /* renamed from: g  reason: collision with root package name */
    public HashSet<String> f26000g;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<String, Integer> f26001h;

    /* renamed from: i  reason: collision with root package name */
    public HashMap<String, String> f26002i;

    /* renamed from: j  reason: collision with root package name */
    public HashMap<String, l> f26003j;
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
        this.f25995b = new HashSet<>();
        this.f25996c = new HashSet<>();
        this.f25997d = new HashSet<>();
        this.f25998e = new HashSet<>();
        this.f25999f = new HashSet<>();
        this.f26000g = new HashSet<>();
        this.f26001h = new HashMap<>();
        this.f26002i = new HashMap<>();
        this.f26003j = new HashMap<>();
        this.k = new HashSet<>();
        this.l = new HashSet<>();
        this.m = new HashMap<>();
        this.n = new HashMap<>();
        this.o = new HashMap<>();
    }
}
