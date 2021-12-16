package c.a.q0.q.j.l;

import c.a.q0.q.i.g;
import c.a.q0.q.i.h;
import c.a.q0.q.i.i;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public g a;

    /* renamed from: b  reason: collision with root package name */
    public List<h> f11092b;

    /* renamed from: c  reason: collision with root package name */
    public List<i> f11093c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.q0.q.i.e f11094d;

    /* renamed from: e  reason: collision with root package name */
    public PMSAppInfo f11095e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.q0.q.i.c f11096f;

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
            }
        }
    }
}
