package c.a.r0.u.b.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f25110a;

    /* renamed from: b  reason: collision with root package name */
    public String f25111b;

    /* renamed from: c  reason: collision with root package name */
    public String f25112c;

    /* renamed from: d  reason: collision with root package name */
    public String f25113d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, String> f25114e;

    /* renamed from: f  reason: collision with root package name */
    public String f25115f;

    /* renamed from: g  reason: collision with root package name */
    public String f25116g;

    /* renamed from: h  reason: collision with root package name */
    public String f25117h;

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
