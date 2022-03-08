package c.a.p0.a.m1.g;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f6515e;

    /* renamed from: f  reason: collision with root package name */
    public String f6516f;

    /* renamed from: g  reason: collision with root package name */
    public long f6517g;

    /* renamed from: h  reason: collision with root package name */
    public int f6518h;

    /* renamed from: i  reason: collision with root package name */
    public String f6519i;

    /* renamed from: j  reason: collision with root package name */
    public String f6520j;

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
        this.f6515e = null;
        this.f6516f = null;
        this.f6517g = -1L;
        this.f6518h = -1;
        this.f6519i = null;
        this.f6520j = null;
    }
}
