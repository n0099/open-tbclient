package c.a.p0.a.w1.g;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f8713e;

    /* renamed from: f  reason: collision with root package name */
    public String f8714f;

    /* renamed from: g  reason: collision with root package name */
    public long f8715g;

    /* renamed from: h  reason: collision with root package name */
    public int f8716h;

    /* renamed from: i  reason: collision with root package name */
    public String f8717i;

    /* renamed from: j  reason: collision with root package name */
    public String f8718j;

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
        this.f8713e = null;
        this.f8714f = null;
        this.f8715g = -1L;
        this.f8716h = -1;
        this.f8717i = null;
        this.f8718j = null;
    }
}
