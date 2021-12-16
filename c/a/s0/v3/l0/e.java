package c.a.s0.v3.l0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public String f24968b;

    /* renamed from: c  reason: collision with root package name */
    public String f24969c;

    /* renamed from: d  reason: collision with root package name */
    public d f24970d;

    /* renamed from: e  reason: collision with root package name */
    public d f24971e;

    /* renamed from: f  reason: collision with root package name */
    public d f24972f;

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
        this.f24968b = null;
        this.f24969c = null;
        this.f24970d = new d();
        this.f24971e = new d();
        this.f24972f = new d();
        this.f24969c = str;
        this.f24968b = str2;
        this.a = z;
    }
}
