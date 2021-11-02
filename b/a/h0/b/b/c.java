package b.a.h0.b.b;

import androidx.core.view.InputDeviceCompat;
import b.a.r0.e;
import b.a.r0.x1.p.h;
import b.a.t0.g0;
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
    public static final ConcurrentHashMap<ServiceReference, b<?>> f2920a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(537534098, "Lb/a/h0/b/b/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(537534098, "Lb/a/h0/b/b/c;");
                return;
            }
        }
        f2920a = new ConcurrentHashMap<>();
        d();
    }

    public static <T> T a(ServiceReference serviceReference) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, serviceReference)) == null) {
            b<?> bVar = f2920a.get(serviceReference);
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
            f2920a.put(serviceReference, bVar);
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
            c("live", "ab", b.a.r0.x1.g.a.class);
            c("live", "account", b.a.r0.x1.b.a.class);
            c("live", DI.APP_INFO_NAME, b.a.r0.x1.c.a.class);
            c("live", DI.EXT.EXT_LIVE_JUMP_PAGE, b.a.r0.x1.j.a.class);
            c("live", DI.EXT.EXT_LIVE_LOG, b.a.r0.x1.m.a.class);
            c("live", DI.FOLLOW_STATUS, b.a.r0.x1.i.a.class);
            c("live", DI.LIGHTBROWSER_VIEW, b.a.r0.x1.e.b.class);
            c("live", DI.LIVE_CUSTOM_SETTINGS, b.a.r0.x1.r.a.class);
            c("live", DI.LIVE_EVENT_DISPATCHER, b.a.r0.x1.h.a.class);
            c("live", DI.LIVE_LIKE, b.a.r0.x1.k.a.class);
            c("live", DI.LIVE_LOCATION, b.a.r0.x1.l.a.class);
            c("live", DI.LIVE_REAL_AUTH, b.a.r0.x1.d.a.class);
            c("live", DI.LIVE_SHOW_VIDEO_PLAYER, b.a.r0.x1.p.a.class);
            c("live", "net", b.a.r0.x1.n.a.class);
            c("live", DI.PAY_CHANNEL, b.a.r0.x1.f.a.class);
            c("live", DI.LIVE_PLAYER, h.class);
            c("live", DI.ROUTER_NAME, b.a.r0.x1.q.a.class);
            c("live", "share", b.a.r0.x1.s.c.class);
            c("live", DI.TB.SHARE_CHANNEL, b.a.r0.x1.s.a.class);
            c("live", DI.THIRD_PART_ACCOUNT, b.a.r0.x1.t.a.class);
            c("live", DI.YY.THIRD_PART_ALI_RECHARGE, b.a.r0.x1.u.a.a.class);
            c("live", DI.YY.THIRD_PART_WX_RECHARGE, b.a.r0.x1.u.b.a.class);
            c("live", "toast", b.a.r0.x1.v.a.class);
            c("live", DI.YYPAY.YY_PAY, b.a.r0.x1.o.a.class);
            c("live", DI.YY.YY_PLUGIN, YYPluginManageServiceFetcher.class);
            c("tbadkcore", "ISoProcess", b.a.q0.j0.w.a.class);
            c(UBCCloudControlProcessor.UBC_KEY, UBC.TAG, g0.class);
        }
    }
}
