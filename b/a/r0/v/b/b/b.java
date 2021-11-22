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
    public String f25607a;

    /* renamed from: b  reason: collision with root package name */
    public String f25608b;

    /* renamed from: c  reason: collision with root package name */
    public String f25609c;

    /* renamed from: d  reason: collision with root package name */
    public String f25610d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, String> f25611e;

    /* renamed from: f  reason: collision with root package name */
    public String f25612f;

    /* renamed from: g  reason: collision with root package name */
    public String f25613g;

    /* renamed from: h  reason: collision with root package name */
    public String f25614h;

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
