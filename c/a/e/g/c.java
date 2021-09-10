package c.a.e.g;

import android.app.Application;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.nps.main.manager.Configurations;
import com.baidu.nps.main.manager.NPSManager;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.manager.NPSPackageManager;
import com.baidu.nps.utils.SourceData;
import com.baidu.searchbox.live.nps.LiveNPSPluginManager;
import com.baidu.searchbox.pms.init.RequestParams;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f2733b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f2734c;

    /* renamed from: d  reason: collision with root package name */
    public static c f2735d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile c.a.e.i.a f2736a;

    /* loaded from: classes.dex */
    public static class a implements c.a.b0.d.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // c.a.b0.d.a.a
        public void onProgress(long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            }
        }

        @Override // c.a.b0.d.a.a
        public void onResult(int i2, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) && BdBaseApplication.getInst().isDebugMode()) {
                BdLog.e("Plug-in predownload status{\"code\": " + i2 + ", \"msg\": " + str + "}");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1500354256, "Lc/a/e/g/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1500354256, "Lc/a/e/g/c;");
                return;
            }
        }
        f2735d = new c();
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

    public static void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && !f2734c && c.a.e.i.a.m()) {
            f2734c = true;
            NPSPackageManager.getInstance().downloadAllBundles();
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, null) == null) || f2733b) {
            return;
        }
        f2733b = true;
        NPSPackageManager.getInstance().fetchBundleInfo();
    }

    public static c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f2735d : (c) invokeV.objValue;
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            a();
        }
    }

    public static void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str) == null) {
            if (str != null && str.trim().length() != 0) {
                SourceData sourceData = new SourceData();
                sourceData.source = "";
                NPSPackageManager.getInstance().preDownload(str, new a(), 1, sourceData);
            } else if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.e("PackageName of Plug-in is null.");
            }
        }
    }

    public RequestParams.Channel c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            i();
            return this.f2736a.l();
        }
        return (RequestParams.Channel) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? g(LiveNPSPluginManager.NPS_PLUGIN_PKG_NAME) : (String) invokeV.objValue;
    }

    public c.a.e.i.a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            i();
            return this.f2736a;
        }
        return (c.a.e.i.a) invokeV.objValue;
    }

    public String g(String str) {
        InterceptResult invokeL;
        BundleInfo bundleInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            try {
                return (NPSPackageManager.getInstance().getBundleStatus(str) == 43 && (bundleInfo = NPSPackageManager.getInstance().getBundleInfo(str)) != null) ? String.valueOf(bundleInfo.getVersionCode()) : "0";
            } catch (Throwable unused) {
                return "0";
            }
        }
        return (String) invokeL.objValue;
    }

    public void h(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, application) == null) {
            i();
            Configurations.Builder builder = new Configurations.Builder();
            builder.debug(false);
            NPSManager.getInstance().init(application, builder.build(), false);
        }
    }

    public final synchronized void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                if (this.f2736a == null) {
                    this.f2736a = new c.a.e.i.a();
                }
            }
        }
    }
}
