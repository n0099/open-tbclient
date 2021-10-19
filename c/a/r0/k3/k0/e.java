package c.a.r0.k3.k0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f21119a;

    /* renamed from: b  reason: collision with root package name */
    public String f21120b;

    /* renamed from: c  reason: collision with root package name */
    public String f21121c;

    /* renamed from: d  reason: collision with root package name */
    public d f21122d;

    /* renamed from: e  reason: collision with root package name */
    public d f21123e;

    /* renamed from: f  reason: collision with root package name */
    public d f21124f;

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
        this.f21119a = false;
        this.f21120b = null;
        this.f21121c = null;
        this.f21122d = new d();
        this.f21123e = new d();
        this.f21124f = new d();
        this.f21121c = str;
        this.f21120b = str2;
        this.f21119a = z;
    }
}
