package b.a.p0.q.i;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f11768a;

    /* renamed from: b  reason: collision with root package name */
    public long f11769b;

    /* renamed from: c  reason: collision with root package name */
    public long f11770c;

    /* renamed from: d  reason: collision with root package name */
    public long f11771d;

    /* renamed from: e  reason: collision with root package name */
    public int f11772e;

    /* renamed from: f  reason: collision with root package name */
    public long f11773f;

    public d() {
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
        this.f11768a = "";
        this.f11769b = 0L;
        this.f11770c = 0L;
        this.f11771d = 0L;
        this.f11772e = 0;
    }
}
