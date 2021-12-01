package c.a.r0.d1;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class m1 extends z0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f15661e;

    /* renamed from: f  reason: collision with root package name */
    public String f15662f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f15663g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f15664h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f15665i;

    public m1() {
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
        this.f15663g = true;
        this.f15665i = true;
    }
}
