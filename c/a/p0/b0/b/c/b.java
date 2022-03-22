package c.a.p0.b0.b.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f12431b;

    /* renamed from: c  reason: collision with root package name */
    public String f12432c;

    /* renamed from: d  reason: collision with root package name */
    public String f12433d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, String> f12434e;

    /* renamed from: f  reason: collision with root package name */
    public String f12435f;

    /* renamed from: g  reason: collision with root package name */
    public String f12436g;

    /* renamed from: h  reason: collision with root package name */
    public String f12437h;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
