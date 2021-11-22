package b.a.p0.a.w1.g;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f9250e;

    /* renamed from: f  reason: collision with root package name */
    public String f9251f;

    /* renamed from: g  reason: collision with root package name */
    public long f9252g;

    /* renamed from: h  reason: collision with root package name */
    public int f9253h;

    /* renamed from: i  reason: collision with root package name */
    public String f9254i;
    public String j;

    public b() {
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
        this.f9250e = null;
        this.f9251f = null;
        this.f9252g = -1L;
        this.f9253h = -1;
        this.f9254i = null;
        this.j = null;
    }
}
