package b.a.r0.v.b.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f24144a;

    /* renamed from: b  reason: collision with root package name */
    public String f24145b;

    /* renamed from: c  reason: collision with root package name */
    public String f24146c;

    /* renamed from: d  reason: collision with root package name */
    public String f24147d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, String> f24148e;

    /* renamed from: f  reason: collision with root package name */
    public String f24149f;

    /* renamed from: g  reason: collision with root package name */
    public String f24150g;

    /* renamed from: h  reason: collision with root package name */
    public String f24151h;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
