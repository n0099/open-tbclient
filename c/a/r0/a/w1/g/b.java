package c.a.r0.a.w1.g;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f9757e;

    /* renamed from: f  reason: collision with root package name */
    public String f9758f;

    /* renamed from: g  reason: collision with root package name */
    public long f9759g;

    /* renamed from: h  reason: collision with root package name */
    public int f9760h;

    /* renamed from: i  reason: collision with root package name */
    public String f9761i;

    /* renamed from: j  reason: collision with root package name */
    public String f9762j;

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
        this.f9757e = null;
        this.f9758f = null;
        this.f9759g = -1L;
        this.f9760h = -1;
        this.f9761i = null;
        this.f9762j = null;
    }
}
