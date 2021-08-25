package c.a.p0.d;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f13029a;

    /* renamed from: b  reason: collision with root package name */
    public int f13030b;

    /* renamed from: c  reason: collision with root package name */
    public String f13031c;

    /* renamed from: d  reason: collision with root package name */
    public String f13032d;

    /* renamed from: e  reason: collision with root package name */
    public String f13033e;

    /* renamed from: f  reason: collision with root package name */
    public int f13034f;

    public c() {
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
        this.f13029a = -1;
        this.f13030b = -1;
        this.f13034f = -1;
    }
}
