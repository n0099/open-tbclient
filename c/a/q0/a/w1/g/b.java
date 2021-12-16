package c.a.q0.a.w1.g;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f9022e;

    /* renamed from: f  reason: collision with root package name */
    public String f9023f;

    /* renamed from: g  reason: collision with root package name */
    public long f9024g;

    /* renamed from: h  reason: collision with root package name */
    public int f9025h;

    /* renamed from: i  reason: collision with root package name */
    public String f9026i;

    /* renamed from: j  reason: collision with root package name */
    public String f9027j;

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
        this.f9022e = null;
        this.f9023f = null;
        this.f9024g = -1L;
        this.f9025h = -1;
        this.f9026i = null;
        this.f9027j = null;
    }
}
