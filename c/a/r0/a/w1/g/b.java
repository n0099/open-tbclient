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
    public String f9545e;

    /* renamed from: f  reason: collision with root package name */
    public String f9546f;

    /* renamed from: g  reason: collision with root package name */
    public long f9547g;

    /* renamed from: h  reason: collision with root package name */
    public int f9548h;

    /* renamed from: i  reason: collision with root package name */
    public String f9549i;

    /* renamed from: j  reason: collision with root package name */
    public String f9550j;

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
        this.f9545e = null;
        this.f9546f = null;
        this.f9547g = -1L;
        this.f9548h = -1;
        this.f9549i = null;
        this.f9550j = null;
    }
}
