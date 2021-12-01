package c.a.r0.t3.l0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public String f23883b;

    /* renamed from: c  reason: collision with root package name */
    public String f23884c;

    /* renamed from: d  reason: collision with root package name */
    public d f23885d;

    /* renamed from: e  reason: collision with root package name */
    public d f23886e;

    /* renamed from: f  reason: collision with root package name */
    public d f23887f;

    public e(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.f23883b = null;
        this.f23884c = null;
        this.f23885d = new d();
        this.f23886e = new d();
        this.f23887f = new d();
        this.f23884c = str;
        this.f23883b = str2;
        this.a = z;
    }
}
