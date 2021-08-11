package c.a.d.a.a.a.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f1717a;

    /* renamed from: b  reason: collision with root package name */
    public String f1718b;

    public e() {
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
        c.a.d.a.a.c.a.a aVar = new c.a.d.a.a.c.a.a();
        try {
            this.f1717a = new String(aVar.a(j.e()), "UTF-8");
            this.f1718b = new String(aVar.a(j.f()), "UTF-8");
        } catch (Exception unused) {
            throw new IllegalStateException("");
        }
    }

    public /* synthetic */ e(d dVar) {
        this();
    }
}
