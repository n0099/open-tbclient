package c.a.r0.y3.m0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public String f25099b;

    /* renamed from: c  reason: collision with root package name */
    public String f25100c;

    /* renamed from: d  reason: collision with root package name */
    public d f25101d;

    /* renamed from: e  reason: collision with root package name */
    public d f25102e;

    /* renamed from: f  reason: collision with root package name */
    public d f25103f;

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
        this.f25099b = null;
        this.f25100c = null;
        this.f25101d = new d();
        this.f25102e = new d();
        this.f25103f = new d();
        this.f25100c = str;
        this.f25099b = str2;
        this.a = z;
    }
}
