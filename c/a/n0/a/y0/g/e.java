package c.a.n0.a.y0.g;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static volatile e f9494b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, c.a.n0.a.y0.g.h.b> f9495a;

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
        this.f9495a = new HashMap();
    }

    public static e a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f9494b == null) {
                synchronized (e.class) {
                    if (f9494b == null) {
                        f9494b = new e();
                    }
                }
            }
            return f9494b;
        }
        return (e) invokeV.objValue;
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            if (f9494b != null) {
                f9494b.b();
            }
            f9494b = null;
        }
    }

    public final synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                c.a.n0.a.e0.d.g("RtcRoomWidgetManager", "release");
                Iterator it = new ArrayList(this.f9495a.values()).iterator();
                while (it.hasNext()) {
                    ((c.a.n0.a.y0.g.h.b) it.next()).onRelease();
                }
                this.f9495a.clear();
            }
        }
    }

    public synchronized void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            synchronized (this) {
                c.a.n0.a.e0.d.g("RtcRoomWidgetManager", "onWebViewDetach slaveId=" + str);
                Iterator it = new ArrayList(this.f9495a.values()).iterator();
                while (it.hasNext()) {
                    c.a.n0.a.y0.g.h.b bVar = (c.a.n0.a.y0.g.h.b) it.next();
                    if (TextUtils.equals(bVar.b(), str)) {
                        bVar.onRelease();
                    }
                }
            }
        }
    }
}
