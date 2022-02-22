package com.baidu.mobstat.dxmpay;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class PrefOperate {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PrefOperate() {
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

    public static String getAppKey(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) ? CooperService.instance().getAppKey(context) : (String) invokeL.objValue;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0084 -> B:45:0x0084). Please submit an issue!!! */
    public static void loadMetaDataConfig(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            SendStrategyEnum sendStrategyEnum = SendStrategyEnum.APP_START;
            try {
                String a = w.a(context, "BaiduMobAd_EXCEPTION_LOG");
                if (!TextUtils.isEmpty(a) && "true".equals(a)) {
                    ExceptionAnalysis.getInstance().openExceptionAnalysis(context, false);
                }
            } catch (Exception unused) {
            }
            try {
                String a2 = w.a(context, "BaiduMobAd_SEND_STRATEGY");
                if (!TextUtils.isEmpty(a2)) {
                    if (a2.equals(SendStrategyEnum.APP_START.name())) {
                        sendStrategyEnum = SendStrategyEnum.APP_START;
                        q.a().a(context, sendStrategyEnum.ordinal());
                    } else if (a2.equals(SendStrategyEnum.ONCE_A_DAY.name())) {
                        sendStrategyEnum = SendStrategyEnum.ONCE_A_DAY;
                        q.a().a(context, sendStrategyEnum.ordinal());
                        q.a().b(context, 24);
                    } else if (a2.equals(SendStrategyEnum.SET_TIME_INTERVAL.name())) {
                        sendStrategyEnum = SendStrategyEnum.SET_TIME_INTERVAL;
                        q.a().a(context, sendStrategyEnum.ordinal());
                    }
                }
            } catch (Exception unused2) {
            }
            try {
                String a3 = w.a(context, "BaiduMobAd_TIME_INTERVAL");
                if (!TextUtils.isEmpty(a3)) {
                    int parseInt = Integer.parseInt(a3);
                    if (sendStrategyEnum.ordinal() == SendStrategyEnum.SET_TIME_INTERVAL.ordinal() && parseInt > 0 && parseInt <= 24) {
                        q.a().b(context, parseInt);
                    }
                }
            } catch (Exception unused3) {
            }
            try {
                String a4 = w.a(context, "BaiduMobAd_ONLY_WIFI");
                if (TextUtils.isEmpty(a4)) {
                    return;
                }
                if ("true".equals(a4)) {
                    q.a().a(context, true);
                } else if ("false".equals(a4)) {
                    q.a().a(context, false);
                }
            } catch (Exception unused4) {
            }
        }
    }

    public static void setAppChannel(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            if (str == null || str.equals("")) {
                h.c().c("[WARNING] The channel you have set is empty");
            }
            CooperService.instance().getHeadObject().m = str;
        }
    }

    public static void setAppKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            CooperService.instance().getHeadObject().f37013f = str;
        }
    }

    public static void setAppChannel(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65539, null, context, str, z) == null) {
            if (str == null || str.equals("")) {
                h.c().c("[WARNING] The channel you have set is empty");
            }
            CooperService.instance().getHeadObject().m = str;
            if (z && str != null && !str.equals("")) {
                q.a().c(context, str);
                q.a().b(context, true);
            }
            if (z) {
                return;
            }
            q.a().c(context, "");
            q.a().b(context, false);
        }
    }
}
