package c.a.q0.v0.j2;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f26273a;

    /* renamed from: b  reason: collision with root package name */
    public int f26274b;

    /* renamed from: c  reason: collision with root package name */
    public String f26275c;

    /* renamed from: d  reason: collision with root package name */
    public int f26276d;

    /* renamed from: e  reason: collision with root package name */
    public int f26277e;

    /* renamed from: f  reason: collision with root package name */
    public int f26278f;

    /* renamed from: g  reason: collision with root package name */
    public int f26279g;

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
        this.f26273a = false;
        this.f26274b = 0;
        this.f26275c = null;
        this.f26276d = -1;
        this.f26277e = -1;
        this.f26278f = -1;
        this.f26279g = -1;
    }
}
