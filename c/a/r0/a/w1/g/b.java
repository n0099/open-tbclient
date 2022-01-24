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
    public String f9687e;

    /* renamed from: f  reason: collision with root package name */
    public String f9688f;

    /* renamed from: g  reason: collision with root package name */
    public long f9689g;

    /* renamed from: h  reason: collision with root package name */
    public int f9690h;

    /* renamed from: i  reason: collision with root package name */
    public String f9691i;

    /* renamed from: j  reason: collision with root package name */
    public String f9692j;

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
        this.f9687e = null;
        this.f9688f = null;
        this.f9689g = -1L;
        this.f9690h = -1;
        this.f9691i = null;
        this.f9692j = null;
    }
}
