package c.a.p0.g.c;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile HashMap<String, List<c.a.p0.g.c.f.b>> f10850a;

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
        this.f10850a = new HashMap<>();
    }

    public synchronized void a(String str, c.a.p0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, bVar) == null) {
            synchronized (this) {
                if (e(str, bVar)) {
                    return;
                }
                List<c.a.p0.g.c.f.b> c2 = c(str);
                if (!c2.contains(bVar)) {
                    c2.add(bVar);
                }
                if (!this.f10850a.containsKey(str)) {
                    this.f10850a.put(str, c2);
                }
            }
        }
    }

    public synchronized void b(String str, c.a.p0.g.c.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bVar) == null) {
            synchronized (this) {
                for (c.a.p0.g.c.f.b bVar2 : new ArrayList(c(str))) {
                    if (bVar2 != null) {
                        bVar2.b(bVar);
                    }
                }
            }
        }
    }

    public final List<c.a.p0.g.c.f.b> c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new ArrayList();
            }
            List<c.a.p0.g.c.f.b> list = this.f10850a.get(str);
            return list == null ? new ArrayList() : list;
        }
        return (List) invokeL.objValue;
    }

    public synchronized boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            synchronized (this) {
                boolean z = false;
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                List<c.a.p0.g.c.f.b> list = this.f10850a.get(str);
                if (list != null) {
                    if (!list.isEmpty()) {
                        z = true;
                    }
                }
                return z;
            }
        }
        return invokeL.booleanValue;
    }

    public final boolean e(String str, c.a.p0.g.c.f.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, bVar)) == null) ? TextUtils.isEmpty(str) || bVar == null : invokeLL.booleanValue;
    }

    public synchronized void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            synchronized (this) {
                g(str, null);
            }
        }
    }

    public synchronized void g(String str, c.a.p0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, bVar) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (bVar == null) {
                    this.f10850a.remove(str);
                    return;
                }
                List<c.a.p0.g.c.f.b> c2 = c(str);
                if (c2.contains(bVar)) {
                    c2.remove(bVar);
                    if (c2.isEmpty()) {
                        this.f10850a.remove(str);
                    }
                }
            }
        }
    }
}
