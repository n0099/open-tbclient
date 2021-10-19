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
    public m f30055a;

    /* renamed from: b  reason: collision with root package name */
    public HashSet<String> f30056b;

    /* renamed from: c  reason: collision with root package name */
    public HashSet<String> f30057c;

    /* renamed from: d  reason: collision with root package name */
    public HashSet<String> f30058d;

    /* renamed from: e  reason: collision with root package name */
    public HashSet<String> f30059e;

    /* renamed from: f  reason: collision with root package name */
    public HashSet<String> f30060f;

    /* renamed from: g  reason: collision with root package name */
    public HashSet<String> f30061g;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<String, Integer> f30062h;

    /* renamed from: i  reason: collision with root package name */
    public HashMap<String, String> f30063i;

    /* renamed from: j  reason: collision with root package name */
    public HashMap<String, l> f30064j;
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
        this.f30055a = new m();
        this.f30056b = new HashSet<>();
        this.f30057c = new HashSet<>();
        this.f30058d = new HashSet<>();
        this.f30059e = new HashSet<>();
        this.f30060f = new HashSet<>();
        this.f30061g = new HashSet<>();
        this.f30062h = new HashMap<>();
        this.f30063i = new HashMap<>();
        this.f30064j = new HashMap<>();
        this.k = new HashSet<>();
        this.l = new HashSet<>();
        this.m = new HashMap<>();
        this.n = new HashMap<>();
        this.o = new HashMap<>();
    }
}
