package c.a.n0.q.i.l;

import c.a.n0.q.h.g;
import c.a.n0.q.h.h;
import c.a.n0.q.h.i;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public g a;

    /* renamed from: b  reason: collision with root package name */
    public List<h> f9202b;

    /* renamed from: c  reason: collision with root package name */
    public List<i> f9203c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.n0.q.h.e f9204d;

    /* renamed from: e  reason: collision with root package name */
    public PMSAppInfo f9205e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.n0.q.h.c f9206f;

    public c() {
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
