package c.a.q0.i3.k0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f20365a;

    /* renamed from: b  reason: collision with root package name */
    public String f20366b;

    /* renamed from: c  reason: collision with root package name */
    public String f20367c;

    /* renamed from: d  reason: collision with root package name */
    public d f20368d;

    /* renamed from: e  reason: collision with root package name */
    public d f20369e;

    /* renamed from: f  reason: collision with root package name */
    public d f20370f;

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
        this.f20365a = false;
        this.f20366b = null;
        this.f20367c = null;
        this.f20368d = new d();
        this.f20369e = new d();
        this.f20370f = new d();
        this.f20367c = str;
        this.f20366b = str2;
        this.f20365a = z;
    }
}
