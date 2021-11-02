package com.baidu.cyberplayer.sdk.statistics;

import android.content.Context;
import android.content.pm.PackageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.CyberVersion;
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static a f37236a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public c f37237b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37238c;

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
                return;
            }
        }
        this.f37238c = false;
        this.f37237b = new c(DpStatConstants.SESSION_TYPE_KERNEL);
    }

    public static synchronized a a() {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (a.class) {
                if (f37236a == null) {
                    f37236a = new a();
                }
                aVar = f37236a;
            }
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public JSONObject a(JSONObject jSONObject) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) ? this.f37237b.a(jSONObject) : (JSONObject) invokeL.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f37238c) {
            return;
        }
        this.f37238c = true;
        Context applicationContext = CyberPlayerManager.getApplicationContext();
        PackageManager packageManager = applicationContext.getPackageManager();
        String packageName = applicationContext.getPackageName();
        String str = XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT;
        if (packageManager != null) {
            try {
                str = packageManager.getPackageInfo(packageName, 0).versionName;
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            }
        }
        String networkStatisticsData = DpNetworkUtils.getNetworkStatisticsData(applicationContext);
        this.f37237b.a(new e((int) DpStatConstants.SESSION_TYPE_KERNEL, "app_name", packageName));
        this.f37237b.a(new e((int) DpStatConstants.SESSION_TYPE_KERNEL, "app_version", str));
        this.f37237b.a(new e((int) DpStatConstants.SESSION_TYPE_KERNEL, DpStatConstants.KEY_SDK_VERSION, CyberVersion.getSDKVersionInternal()));
        this.f37237b.a(new e((int) DpStatConstants.SESSION_TYPE_KERNEL, "cuid", CyberPlayerManager.getClientID()));
        this.f37237b.a(new e((int) DpStatConstants.SESSION_TYPE_KERNEL, "network", networkStatisticsData));
        this.f37237b.a(new e((int) DpStatConstants.SESSION_TYPE_KERNEL, DpStatConstants.KEY_KERNEL_SESSION_ID, System.currentTimeMillis()));
        this.f37237b.a(new e((int) DpStatConstants.SESSION_TYPE_KERNEL, DpStatConstants.KEY_SERVER_TYPE, DpStatConstants.SERVER_TYPE_DUPLAYER_INIT));
        String str2 = CyberPlayerManager.getInstallOpts().get("abtest_sid");
        if (str2 != null) {
            this.f37237b.a(new e((int) DpStatConstants.SESSION_TYPE_KERNEL, "abtest_sid", str2));
        }
    }
}
