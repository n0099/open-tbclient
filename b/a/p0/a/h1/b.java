package b.a.p0.a.h1;

import b.a.p0.a.o2.h.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.dxmpay.Config;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f6211b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final c f6212a;

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
                return;
            }
        }
        this.f6212a = new c("swan_local_ab_data");
        if (ProcessUtils.isMainProcess()) {
            this.f6212a.clear();
        }
        c();
    }

    public static b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f6211b == null) {
                synchronized (b.class) {
                    if (f6211b == null) {
                        f6211b = new b();
                    }
                }
            }
            return f6211b;
        }
        return (b) invokeV.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f6212a.getString(Config.SID, "") : (String) invokeV.objValue;
    }

    public final void c() {
        Object e2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && ProcessUtils.isMainProcess()) {
            List<b.a.p0.a.h1.c.a> c2 = new a().c();
            for (b.a.p0.a.h1.c.a aVar : c2) {
                b.a.p0.a.h1.c.b b2 = aVar.b();
                b.a.p0.a.h1.c.c c3 = aVar.c();
                if (b2 == null) {
                    e2 = c3.d();
                } else {
                    e2 = b2.e();
                }
                if (e2 instanceof Boolean) {
                    this.f6212a.writeBool(c3.e(), ((Boolean) e2).booleanValue());
                } else if (e2 instanceof Double) {
                    this.f6212a.writeDouble(c3.e(), ((Double) e2).doubleValue());
                } else if (e2 instanceof Integer) {
                    this.f6212a.writeInt(c3.e(), ((Integer) e2).intValue());
                } else if (e2 instanceof Long) {
                    this.f6212a.writeLong(c3.e(), ((Long) e2).longValue());
                } else if (e2 instanceof String) {
                    this.f6212a.writeString(c3.e(), (String) e2);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (b.a.p0.a.h1.c.a aVar2 : c2) {
                b.a.p0.a.h1.c.b b3 = aVar2.b();
                if (b3 != null) {
                    sb.append(b3.d());
                    sb.append("-");
                }
            }
            this.f6212a.writeString(Config.SID, sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1));
        }
    }
}
