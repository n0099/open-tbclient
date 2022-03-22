package c.a.p0.f1.o2;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public int f14299b;

    /* renamed from: c  reason: collision with root package name */
    public String f14300c;

    /* renamed from: d  reason: collision with root package name */
    public String f14301d;

    /* renamed from: e  reason: collision with root package name */
    public int f14302e;

    /* renamed from: f  reason: collision with root package name */
    public int f14303f;

    /* renamed from: g  reason: collision with root package name */
    public int f14304g;

    /* renamed from: h  reason: collision with root package name */
    public int f14305h;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.f14299b = 0;
        this.f14300c = null;
        this.f14301d = null;
        this.f14302e = -1;
        this.f14303f = -1;
        this.f14304g = -1;
        this.f14305h = -1;
    }
}
