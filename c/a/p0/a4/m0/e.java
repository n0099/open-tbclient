package c.a.p0.a4.m0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public String f12295b;

    /* renamed from: c  reason: collision with root package name */
    public String f12296c;

    /* renamed from: d  reason: collision with root package name */
    public d f12297d;

    /* renamed from: e  reason: collision with root package name */
    public d f12298e;

    /* renamed from: f  reason: collision with root package name */
    public d f12299f;

    public e(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.f12295b = null;
        this.f12296c = null;
        this.f12297d = new d();
        this.f12298e = new d();
        this.f12299f = new d();
        this.f12296c = str;
        this.f12295b = str2;
        this.a = z;
    }
}
