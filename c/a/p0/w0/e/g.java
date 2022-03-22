package c.a.p0.w0.e;

import c.a.o0.r.r.x;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class g extends x {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public String f19363d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f19364e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f19365f;

    /* renamed from: g  reason: collision with root package name */
    public int f19366g;

    /* renamed from: h  reason: collision with root package name */
    public int f19367h;
    public int i;
    public int j;

    public g(String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19366g = -1;
        this.f19367h = -1;
        this.i = -1;
        this.j = -1;
        this.f19363d = str;
        this.f19364e = z;
        this.f19365f = z2;
        g(0);
    }
}
