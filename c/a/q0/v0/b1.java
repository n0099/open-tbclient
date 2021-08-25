package c.a.q0.v0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class b1 extends y0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f25868e;

    /* renamed from: f  reason: collision with root package name */
    public String f25869f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f25870g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f25871h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f25872i;

    public b1() {
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
        this.f25870g = true;
        this.f25872i = true;
    }
}
