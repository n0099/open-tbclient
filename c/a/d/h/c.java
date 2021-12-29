package c.a.d.h;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.main.manager.Configurations;
import com.baidu.nps.main.manager.NPSManager;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.BundleInfoGroup;
import com.baidu.nps.pm.manager.NPSPackageManager;
import com.baidu.nps.utils.SourceData;
import com.baidu.searchbox.pms.init.RequestParams;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f3161b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f3162c;

    /* renamed from: d  reason: collision with root package name */
    public static c f3163d;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile c.a.d.j.a a;

    /* loaded from: classes.dex */
    public static class a implements c.a.d0.d.a.a {
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

        @Override // c.a.d0.d.a.a
        public void onProgress(long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            }
        }

        @Override // c.a.d0.d.a.a
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1528953616, "Lc/a/d/h/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1528953616, "Lc/a/d/h/c;");
                return;
            }
        }
        f3163d = new c();
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
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && !f3162c && c.a.d.j.a.m()) {
            f3162c = true;
            NPSPackageManager.getInstance().downloadAllBundles();
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, null) == null) || f3161b) {
            return;
        }
        f3161b = true;
        NPSPackageManager.getInstance().fetchBundleInfo();
    }

    public static c e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f3163d : (c) invokeV.objValue;
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            a();
        }
    }

    public static void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, str) == null) {
            if (str != null && str.trim().length() != 0) {
                SourceData sourceData = new SourceData();
                sourceData.source = "";
                NPSPackageManager.getInstance().preDownload(str, new a(), 1, sourceData);
            } else if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.e("PackageName of Plug-in is null.");
            }
        }
    }

    @NonNull
    public List<BundleInfo> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, BundleInfoGroup> entry : NPSPackageManager.getInstance().getAllBundleGroup().entrySet()) {
                BundleInfoGroup value = entry.getValue();
                BundleInfo bundleByType = value.getBundleByType(3);
                if (bundleByType == null) {
                    bundleByType = value.getBundleByType(2);
                }
                if (bundleByType != null) {
                    arrayList.add(bundleByType);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public RequestParams.Channel d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            h();
            return this.a.l();
        }
        return (RequestParams.Channel) invokeV.objValue;
    }

    public c.a.d.j.a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            h();
            return this.a;
        }
        return (c.a.d.j.a) invokeV.objValue;
    }

    public void g(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, application) == null) {
            h();
            Configurations.Builder builder = new Configurations.Builder();
            builder.debug(false);
            NPSManager.getInstance().init(application, builder.build(), false);
        }
    }

    public final synchronized void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                if (this.a == null) {
                    this.a = new c.a.d.j.a();
                }
            }
        }
    }
}
