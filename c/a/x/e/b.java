package c.a.x.e;

import androidx.core.view.InputDeviceCompat;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes9.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public static final ConcurrentHashMap<String, List<a>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-956460000, "Lc/a/x/e/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-956460000, "Lc/a/x/e/b;");
                return;
            }
        }
        a = new ConcurrentHashMap<>();
    }

    @JvmStatic
    @JvmOverloads
    public static final a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? c(null, str, 1, null) : (a) invokeL.objValue;
    }

    @JvmStatic
    @JvmOverloads
    public static final a b(String str, String pageId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, pageId)) == null) {
            Intrinsics.checkNotNullParameter(pageId, "pageId");
            LiveFeedPageSdk.n("LiveFeedPlayerPool", "getPlayer pageId= " + pageId + ' ' + a.size());
            List<a> list = a.get(pageId);
            if (list == null) {
                list = new ArrayList<>();
            }
            if (!list.isEmpty() && list.size() >= 2) {
                a aVar = list.get(0);
                Collections.swap(list, 0, 1);
                if (aVar.isPlaying()) {
                    aVar.detachFromContainer();
                    aVar.stop();
                }
                LiveFeedPageSdk.n("LiveFeedPlayerPool", "getPlayer " + aVar);
                return aVar;
            }
            a aVar2 = new a(new c.a.x.e.c.a(str, 0, null, null, 14, null));
            list.add(aVar2);
            a.put(pageId, list);
            return aVar2;
        }
        return (a) invokeLL.objValue;
    }

    public static /* synthetic */ a c(String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "";
        }
        return b(str, str2);
    }

    @JvmStatic
    public static final void d(String pageId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, pageId) == null) {
            Intrinsics.checkNotNullParameter(pageId, "pageId");
            LiveFeedPageSdk.n("LiveFeedPlayerPool", "release playerMap= " + a.size());
            List<a> list = a.get(pageId);
            if (list == null || list.isEmpty()) {
                return;
            }
            for (a aVar : list) {
                aVar.detachFromContainer();
                aVar.release();
            }
            list.clear();
            a.remove(pageId);
        }
    }
}
