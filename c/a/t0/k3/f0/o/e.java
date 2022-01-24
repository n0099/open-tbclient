package c.a.t0.k3.f0.o;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f18830b;

    /* renamed from: c  reason: collision with root package name */
    public long f18831c;

    /* renamed from: d  reason: collision with root package name */
    public long f18832d;

    /* renamed from: e  reason: collision with root package name */
    public long f18833e;

    /* renamed from: f  reason: collision with root package name */
    public String f18834f;

    /* renamed from: g  reason: collision with root package name */
    public int f18835g;

    /* renamed from: h  reason: collision with root package name */
    public int f18836h;

    /* renamed from: i  reason: collision with root package name */
    public String f18837i;

    /* renamed from: j  reason: collision with root package name */
    public String f18838j;
    public String k;
    public String l;

    public e() {
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
        this.f18830b = -1L;
        this.f18833e = -1L;
        this.f18834f = "";
        this.f18837i = null;
    }
}
