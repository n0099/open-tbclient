package com.baidu.platform.comapi.util;

import android.os.Build;
import com.baidu.mapsdkplatform.comapi.util.SyncSysInfo;
import com.baidu.platform.comjni.map.commonmemcache.NACommonMemCache;
import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.vi.VIContext;
import com.fun.ad.sdk.FunAdSdk;
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public static NACommonMemCache a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1576658694, "Lcom/baidu/platform/comapi/util/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1576658694, "Lcom/baidu/platform/comapi/util/f;");
                return;
            }
        }
        a = new NACommonMemCache();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            c();
        }
    }

    public static NACommonMemCache b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return a;
        }
        return (NACommonMemCache) invokeV.objValue;
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            JsonBuilder jsonBuilder = new JsonBuilder();
            String str = Build.MODEL;
            a.a(SyncSysInfo.initPhoneInfo());
            jsonBuilder.object();
            jsonBuilder.putStringValue("pd", "map");
            jsonBuilder.putStringValue("ov", "Android" + Build.VERSION.SDK_INT);
            jsonBuilder.putStringValue("ver", "2");
            jsonBuilder.key(TbConfig.SW_APID).value(SysOSUtil.getInstance().getScreenWidth());
            jsonBuilder.key("sh").value(SysOSUtil.getInstance().getScreenHeight());
            jsonBuilder.putStringValue("channel", "oem");
            jsonBuilder.putStringValue(FunAdSdk.PLATFORM_MB, str);
            jsonBuilder.putStringValue("sv", SyncSysInfo.getSoftWareVer());
            jsonBuilder.putStringValue("os", "android");
            jsonBuilder.putStringValue("cuid", SyncSysInfo.getCid());
            jsonBuilder.putStringValue("path", SysOSUtil.getInstance().getOutputDirPath() + "/udc/");
            jsonBuilder.endObject();
            a.a("logstatistics", jsonBuilder.getJson());
            jsonBuilder.reset();
            jsonBuilder.object();
            jsonBuilder.putStringValue("cuid", SyncSysInfo.getCid());
            jsonBuilder.putStringValue("app", "1");
            jsonBuilder.putStringValue("path", VIContext.getContext().getCacheDir().getAbsolutePath() + "/");
            jsonBuilder.putStringValue("domain", "");
            jsonBuilder.endObject();
            a.a("longlink", jsonBuilder.getJson());
        }
    }
}
