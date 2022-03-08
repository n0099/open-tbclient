package c.a.r0.z.b.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f25264b;

    /* renamed from: c  reason: collision with root package name */
    public String f25265c;

    /* renamed from: d  reason: collision with root package name */
    public String f25266d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, String> f25267e;

    /* renamed from: f  reason: collision with root package name */
    public String f25268f;

    /* renamed from: g  reason: collision with root package name */
    public String f25269g;

    /* renamed from: h  reason: collision with root package name */
    public String f25270h;

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
