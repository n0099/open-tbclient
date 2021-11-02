package b.a.r0.l3.l0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f20690a;

    /* renamed from: b  reason: collision with root package name */
    public String f20691b;

    /* renamed from: c  reason: collision with root package name */
    public String f20692c;

    /* renamed from: d  reason: collision with root package name */
    public d f20693d;

    /* renamed from: e  reason: collision with root package name */
    public d f20694e;

    /* renamed from: f  reason: collision with root package name */
    public d f20695f;

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
        this.f20690a = false;
        this.f20691b = null;
        this.f20692c = null;
        this.f20693d = new d();
        this.f20694e = new d();
        this.f20695f = new d();
        this.f20692c = str;
        this.f20691b = str2;
        this.f20690a = z;
    }
}
