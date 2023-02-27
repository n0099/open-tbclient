package com.baidu.android.pushservice.ach;

import android.content.Context;
import android.content.Intent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.pushservice.ach.service.AppMarketService;
import com.baidu.android.pushservice.ach.service.CloudSettingsService;
import com.baidu.android.pushservice.ach.service.CodebookSyncService;
import com.baidu.android.pushservice.ach.service.DistributedDataStartService;
import com.baidu.android.pushservice.ach.service.GMSService;
import com.baidu.android.pushservice.ach.service.IUHostManagerService;
import com.baidu.android.pushservice.ach.service.KvStartService;
import com.baidu.android.pushservice.ach.service.MediaBrowserService;
import com.baidu.android.pushservice.ach.service.MediaService;
import com.baidu.android.pushservice.ach.service.OppoCycleService;
import com.baidu.android.pushservice.ach.service.ProfileStartService;
import com.baidu.android.pushservice.ach.service.PushPriorityService;
import com.baidu.android.pushservice.ach.service.RebootService;
import com.baidu.android.pushservice.ach.service.ReservedService;
import com.baidu.android.pushservice.ach.service.SearchStartService;
import com.baidu.android.pushservice.ach.service.SfcService;
import com.baidu.android.pushservice.ach.service.VanishingArtService;
import com.baidu.android.pushservice.ach.service.WallPaperService;
import com.baidu.protect.sdk.Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2141677179, "Lcom/baidu/android/pushservice/ach/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2141677179, "Lcom/baidu/android/pushservice/ach/a;");
                return;
            }
        }
        a = new String[]{OppoCycleService.class.getName(), MediaBrowserService.class.getName(), RebootService.class.getName(), VanishingArtService.class.getName(), AppMarketService.class.getName(), IUHostManagerService.class.getName(), ProfileStartService.class.getName(), KvStartService.class.getName(), SearchStartService.class.getName(), DistributedDataStartService.class.getName(), GMSService.class.getName(), ReservedService.class.getName(), CloudSettingsService.class.getName(), MediaService.class.getName(), WallPaperService.class.getName(), SfcService.class.getName(), CodebookSyncService.class.getName(), PushPriorityService.class.getName(), PushPriorityService.PushPriorityInnerService.class.getName()};
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? (String) Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15932, null, str) : (String) invokeL.objValue;
    }

    public static void a(Context context, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65538, null, context, str, i) == null) {
            Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15931, null, context, str, Integer.valueOf(i));
        }
    }

    public static void a(Context context, String str, String str2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, null, context, str, str2, intent) == null) {
            Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15926, null, context, str, str2, intent);
        }
    }

    public static void a(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, jSONObject) == null) {
            Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15925, null, context, jSONObject);
        }
    }

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, str)) == null) ? Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.z(-15928, null, context, str) : invokeLL.booleanValue;
    }
}
