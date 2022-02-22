package c.a.u0.z3.m0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public String f26279b;

    /* renamed from: c  reason: collision with root package name */
    public String f26280c;

    /* renamed from: d  reason: collision with root package name */
    public d f26281d;

    /* renamed from: e  reason: collision with root package name */
    public d f26282e;

    /* renamed from: f  reason: collision with root package name */
    public d f26283f;

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
        this.f26279b = null;
        this.f26280c = null;
        this.f26281d = new d();
        this.f26282e = new d();
        this.f26283f = new d();
        this.f26280c = str;
        this.f26279b = str2;
        this.a = z;
    }
}
