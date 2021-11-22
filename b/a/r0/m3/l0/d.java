package b.a.r0.m3.l0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f22536a;

    /* renamed from: b  reason: collision with root package name */
    public long f22537b;

    /* renamed from: c  reason: collision with root package name */
    public long f22538c;

    /* renamed from: d  reason: collision with root package name */
    public long f22539d;

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
        this.f22536a = 0L;
        this.f22537b = 0L;
        this.f22538c = 0L;
        this.f22539d = 0L;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f22536a = 0L;
            this.f22537b = 0L;
            this.f22538c = 0L;
            this.f22539d = 0L;
        }
    }
}
