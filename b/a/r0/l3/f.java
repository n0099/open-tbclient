package b.a.r0.l3;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f20550a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f20551b;

    /* renamed from: c  reason: collision with root package name */
    public int f20552c;

    /* renamed from: d  reason: collision with root package name */
    public String f20553d;

    /* renamed from: e  reason: collision with root package name */
    public long f20554e;

    public f() {
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
        this.f20550a = false;
        this.f20551b = false;
        this.f20552c = 0;
        this.f20553d = "";
        this.f20554e = 0L;
    }
}
