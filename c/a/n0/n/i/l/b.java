package c.a.n0.n.i.l;

import c.a.n0.n.h.f;
import c.a.n0.n.h.g;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public f f11689a;

    /* renamed from: b  reason: collision with root package name */
    public List<g> f11690b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.n0.n.h.d f11691c;

    /* renamed from: d  reason: collision with root package name */
    public PMSAppInfo f11692d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.n0.n.h.b f11693e;

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
