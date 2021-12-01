package c.a.p0.q.j.l;

import c.a.p0.q.i.g;
import c.a.p0.q.i.h;
import c.a.p0.q.i.i;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public g a;

    /* renamed from: b  reason: collision with root package name */
    public List<h> f10783b;

    /* renamed from: c  reason: collision with root package name */
    public List<i> f10784c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.q.i.e f10785d;

    /* renamed from: e  reason: collision with root package name */
    public PMSAppInfo f10786e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.q.i.c f10787f;

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
