package c.a.r0.j3.g0.o;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f18419b;

    /* renamed from: c  reason: collision with root package name */
    public long f18420c;

    /* renamed from: d  reason: collision with root package name */
    public long f18421d;

    /* renamed from: e  reason: collision with root package name */
    public long f18422e;

    /* renamed from: f  reason: collision with root package name */
    public String f18423f;

    /* renamed from: g  reason: collision with root package name */
    public int f18424g;

    /* renamed from: h  reason: collision with root package name */
    public int f18425h;

    /* renamed from: i  reason: collision with root package name */
    public String f18426i;

    /* renamed from: j  reason: collision with root package name */
    public String f18427j;
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
        this.f18419b = -1L;
        this.f18422e = -1L;
        this.f18423f = "";
        this.f18426i = null;
    }
}
