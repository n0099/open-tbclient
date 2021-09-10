package c.a.r0.w0.k2;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f26939a;

    /* renamed from: b  reason: collision with root package name */
    public int f26940b;

    /* renamed from: c  reason: collision with root package name */
    public String f26941c;

    /* renamed from: d  reason: collision with root package name */
    public int f26942d;

    /* renamed from: e  reason: collision with root package name */
    public int f26943e;

    /* renamed from: f  reason: collision with root package name */
    public int f26944f;

    /* renamed from: g  reason: collision with root package name */
    public int f26945g;

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
        this.f26939a = false;
        this.f26940b = 0;
        this.f26941c = null;
        this.f26942d = -1;
        this.f26943e = -1;
        this.f26944f = -1;
        this.f26945g = -1;
    }
}
