package c.a.i0.b.b;

import androidx.core.view.InputDeviceCompat;
import c.a.b0.k.d;
import c.a.b0.l.g;
import c.a.b0.v.h0.o;
import c.a.r0.d1.y;
import c.a.r0.e;
import c.a.r0.g2.p.i;
import c.a.r0.y.a.f.f;
import c.a.t0.g0;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.devicescore.DeviceScoreCollectFetcher;
import com.baidu.searchbox.devicescore.DeviceScoreConfigFetcher;
import com.baidu.searchbox.devicescore.DeviceScoreFetcher;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.YYPluginManageServiceFetcher;
import com.baidu.searchbox.logsystem.exceptionhandler.impl.ExceptionHandlerServiceFetcher;
import com.baidu.searchbox.performance.speed.SpeedRuntimeProvider;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.searchbox.updateprocessor.UpdateCloudControlProcessor;
import com.baidu.tbadk.abtest.helper.NetExperimentFetcher;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBC;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static final ConcurrentHashMap<ServiceReference, b<?>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1563323372, "Lc/a/i0/b/b/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1563323372, "Lc/a/i0/b/b/c;");
                return;
            }
        }
        a = new ConcurrentHashMap<>();
        d();
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static <T> T a(ServiceReference serviceReference) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, serviceReference)) == null) {
            b<?> bVar = a.get(serviceReference);
            if (bVar != null) {
                return (T) bVar.getService();
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public static <T> void b(ServiceReference serviceReference, b<T> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, serviceReference, bVar) == null) {
            a.put(serviceReference, bVar);
        }
    }

    public static <T> void c(String str, String str2, Class<? extends b<T>> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, cls) == null) {
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
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            c("Frs", "FrsService", y.class);
            c("HotTopic", "HotTopicRequest", e.class);
            c("device_score", "DEVICE_SCORE", DeviceScoreFetcher.class);
            c("device_score", "DEVICE_SCORE_COLLECT", DeviceScoreCollectFetcher.class);
            c("device_score", "DEVICE_SCORE_CONFIG", DeviceScoreConfigFetcher.class);
            c("live", "ab", c.a.r0.g2.g.a.class);
            c("live", "account", c.a.r0.g2.b.a.class);
            c("live", DI.APP_INFO_NAME, c.a.r0.g2.c.a.class);
            c("live", DI.EXT.EXT_LIVE_JUMP_PAGE, c.a.r0.g2.j.a.class);
            c("live", DI.EXT.EXT_LIVE_LOG, c.a.r0.g2.m.a.class);
            c("live", DI.FOLLOW_STATUS, c.a.r0.g2.i.a.class);
            c("live", DI.LIGHTBROWSER_VIEW, c.a.r0.g2.e.b.class);
            c("live", DI.LIVE_CUSTOM_SETTINGS, c.a.r0.g2.r.a.class);
            c("live", DI.LIVE_EVENT_DISPATCHER, c.a.r0.g2.h.a.class);
            c("live", DI.LIVE_LIKE, c.a.r0.g2.k.a.class);
            c("live", DI.LIVE_LOCATION, c.a.r0.g2.l.a.class);
            c("live", DI.LIVE_REAL_AUTH, c.a.r0.g2.d.a.class);
            c("live", DI.LIVE_SHOW_VIDEO_PLAYER, c.a.r0.g2.p.b.class);
            c("live", "net", c.a.r0.g2.n.a.class);
            c("live", DI.PAY_CHANNEL, c.a.r0.g2.f.a.class);
            c("live", DI.LIVE_PLAYER, i.class);
            c("live", DI.ROUTER_NAME, c.a.r0.g2.q.a.class);
            c("live", "share", c.a.r0.g2.s.c.class);
            c("live", DI.TB.SHARE_CHANNEL, c.a.r0.g2.s.a.class);
            c("live", DI.THIRD_PART_ACCOUNT, c.a.r0.g2.t.a.class);
            c("live", DI.YY.THIRD_PART_ALI_RECHARGE, c.a.r0.g2.u.a.a.class);
            c("live", DI.YY.THIRD_PART_WX_RECHARGE, c.a.r0.g2.u.b.a.class);
            c("live", "toast", c.a.r0.g2.v.a.class);
            c("live", DI.YYPAY.YY_PAY, c.a.r0.g2.o.a.class);
            c("live", DI.YY.YY_PLUGIN, YYPluginManageServiceFetcher.class);
            c("logsystem", "exceptionhandler", ExceptionHandlerServiceFetcher.class);
            c("nad.core", "adRequester", c.a.b0.w.b.class);
            c("nad.core", "browserDownload", c.a.b0.j.c.b.class);
            c("nad.core", "cmd", c.a.r0.y.a.f.a.class);
            c("nad.core", UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME, c.a.r0.y.a.f.b.class);
            c("nad.core", "deviceInfoInner", c.a.b0.d.d.a.class);
            c("nad.core", "eventbus", d.class);
            c("nad.core", "exp", g.class);
            c("nad.core", "ipdx", c.a.b0.d.f.a.class);
            c("nad.core", "loadImage", c.a.b0.c.a.class);
            c("nad.core", "navBarTool", c.a.r0.y.a.f.d.class);
            c("nad.core", "splash.config", c.a.r0.y.a.f.e.class);
            c("nad.core", "splash.host", f.class);
            c("nad.core", "sysLoadVideo", o.class);
            c("speed", "runtime", SpeedRuntimeProvider.class);
            c("tbadkcore", "INetExperiment", NetExperimentFetcher.class);
            c("tbadkcore", "ISoProcess", c.a.q0.j0.x.a.class);
            c(UBCCloudControlProcessor.UBC_KEY, UBC.TAG, g0.class);
            c("voyager", StatConstants.VALUE_TYPE_UPLOAD, c.a.a1.a.g.c.class);
            c("yaLog", "yaLogConfig", c.a.b1.i.a.class);
        }
    }
}
