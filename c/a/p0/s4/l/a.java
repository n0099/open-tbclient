package c.a.p0.s4.l;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public String f18384b;

    /* renamed from: c  reason: collision with root package name */
    public String f18385c;

    /* renamed from: d  reason: collision with root package name */
    public int f18386d;

    /* renamed from: e  reason: collision with root package name */
    public String f18387e;

    /* renamed from: f  reason: collision with root package name */
    public String f18388f;

    /* renamed from: g  reason: collision with root package name */
    public String f18389g;

    /* renamed from: h  reason: collision with root package name */
    public String f18390h;
    public String i;
    public String j;
    public long k;
    public int l;
    public String m;
    public int n;
    public int o;
    public int p;
    public String q;
    public int r;
    public int s;
    public int t;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
