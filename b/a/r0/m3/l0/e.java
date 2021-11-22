package b.a.r0.m3.l0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f22540a;

    /* renamed from: b  reason: collision with root package name */
    public String f22541b;

    /* renamed from: c  reason: collision with root package name */
    public String f22542c;

    /* renamed from: d  reason: collision with root package name */
    public d f22543d;

    /* renamed from: e  reason: collision with root package name */
    public d f22544e;

    /* renamed from: f  reason: collision with root package name */
    public d f22545f;

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
        this.f22540a = false;
        this.f22541b = null;
        this.f22542c = null;
        this.f22543d = new d();
        this.f22544e = new d();
        this.f22545f = new d();
        this.f22542c = str;
        this.f22541b = str2;
        this.f22540a = z;
    }
}
