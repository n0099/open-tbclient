package c.a.h0.b.b;

import androidx.core.view.InputDeviceCompat;
import c.a.r0.e;
import c.a.r0.x1.p.h;
import c.a.t0.d0;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.YYPluginManageServiceFetcher;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ubc.UBC;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final ConcurrentHashMap<ServiceReference, b<?>> f3480a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(244131091, "Lc/a/h0/b/b/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(244131091, "Lc/a/h0/b/b/c;");
                return;
            }
        }
        f3480a = new ConcurrentHashMap<>();
        d();
    }

    public static <T> T a(ServiceReference serviceReference) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, serviceReference)) == null) {
            b<?> bVar = f3480a.get(serviceReference);
            if (bVar != null) {
                return (T) bVar.getService();
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public static <T> void b(ServiceReference serviceReference, b<T> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, serviceReference, bVar) == null) {
            f3480a.put(serviceReference, bVar);
        }
    }

    public static <T> void c(String str, String str2, Class<? extends b<T>> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, str, str2, cls) == null) {
            try {
                b(new ServiceReference(str, str2), cls.newInstance());
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InstantiationException e3) {
                e3.printStackTrace();
            }
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            c("HotTopic", "HotTopicRequest", e.class);
            c("live", "ab", c.a.r0.x1.g.a.class);
            c("live", "account", c.a.r0.x1.b.a.class);
            c("live", DI.APP_INFO_NAME, c.a.r0.x1.c.a.class);
            c("live", DI.EXT.EXT_LIVE_JUMP_PAGE, c.a.r0.x1.j.a.class);
            c("live", DI.EXT.EXT_LIVE_LOG, c.a.r0.x1.m.a.class);
            c("live", DI.FOLLOW_STATUS, c.a.r0.x1.i.a.class);
            c("live", DI.LIGHTBROWSER_VIEW, c.a.r0.x1.e.b.class);
            c("live", DI.LIVE_CUSTOM_SETTINGS, c.a.r0.x1.r.a.class);
            c("live", DI.LIVE_EVENT_DISPATCHER, c.a.r0.x1.h.a.class);
            c("live", DI.LIVE_LIKE, c.a.r0.x1.k.a.class);
            c("live", DI.LIVE_LOCATION, c.a.r0.x1.l.a.class);
            c("live", DI.LIVE_REAL_AUTH, c.a.r0.x1.d.a.class);
            c("live", DI.LIVE_SHOW_VIDEO_PLAYER, c.a.r0.x1.p.a.class);
            c("live", "net", c.a.r0.x1.n.a.class);
            c("live", DI.PAY_CHANNEL, c.a.r0.x1.f.a.class);
            c("live", DI.LIVE_PLAYER, h.class);
            c("live", DI.ROUTER_NAME, c.a.r0.x1.q.a.class);
            c("live", "share", c.a.r0.x1.s.c.class);
            c("live", DI.TB.SHARE_CHANNEL, c.a.r0.x1.s.a.class);
            c("live", DI.THIRD_PART_ACCOUNT, c.a.r0.x1.t.a.class);
            c("live", DI.YY.THIRD_PART_ALI_RECHARGE, c.a.r0.x1.u.a.a.class);
            c("live", DI.YY.THIRD_PART_WX_RECHARGE, c.a.r0.x1.u.b.a.class);
            c("live", "toast", c.a.r0.x1.v.a.class);
            c("live", DI.YYPAY.YY_PAY, c.a.r0.x1.o.a.class);
            c("live", DI.YY.YY_PLUGIN, YYPluginManageServiceFetcher.class);
            c(UBCCloudControlProcessor.UBC_KEY, UBC.TAG, d0.class);
        }
    }
}
