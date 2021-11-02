package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
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

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0085 -> B:45:0x0085). Please submit an issue!!! */
    public static void loadMetaDataConfig(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            SendStrategyEnum sendStrategyEnum = SendStrategyEnum.APP_START;
            try {
                String a2 = bw.a(context, "BaiduMobAd_EXCEPTION_LOG");
                if (!TextUtils.isEmpty(a2) && "true".equals(a2)) {
                    ExceptionAnalysis.getInstance().openExceptionAnalysis(context, false);
                }
            } catch (Exception unused) {
            }
            try {
                String a3 = bw.a(context, "BaiduMobAd_SEND_STRATEGY");
                if (!TextUtils.isEmpty(a3)) {
                    if (a3.equals(SendStrategyEnum.APP_START.name())) {
                        sendStrategyEnum = SendStrategyEnum.APP_START;
                        bq.a().a(context, sendStrategyEnum.ordinal());
                    } else if (a3.equals(SendStrategyEnum.ONCE_A_DAY.name())) {
                        sendStrategyEnum = SendStrategyEnum.ONCE_A_DAY;
                        bq.a().a(context, sendStrategyEnum.ordinal());
                        bq.a().b(context, 24);
                    } else if (a3.equals(SendStrategyEnum.SET_TIME_INTERVAL.name())) {
                        sendStrategyEnum = SendStrategyEnum.SET_TIME_INTERVAL;
                        bq.a().a(context, sendStrategyEnum.ordinal());
                    }
                }
            } catch (Exception unused2) {
            }
            try {
                String a4 = bw.a(context, "BaiduMobAd_TIME_INTERVAL");
                if (!TextUtils.isEmpty(a4)) {
                    int parseInt = Integer.parseInt(a4);
                    if (sendStrategyEnum.ordinal() == SendStrategyEnum.SET_TIME_INTERVAL.ordinal() && parseInt > 0 && parseInt <= 24) {
                        bq.a().b(context, parseInt);
                    }
                }
            } catch (Exception unused3) {
            }
            try {
                String a5 = bw.a(context, "BaiduMobAd_ONLY_WIFI");
                if (TextUtils.isEmpty(a5)) {
                    return;
                }
                if ("true".equals(a5)) {
                    bq.a().a(context, true);
                } else if ("false".equals(a5)) {
                    bq.a().a(context, false);
                }
            } catch (Exception unused4) {
            }
        }
    }

    public static void setAppChannel(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            if (str == null || str.equals("")) {
                bc.c().c("[WARNING] The channel you have set is empty");
            }
            CooperService.instance().getHeadObject().l = str;
        }
    }

    public static void setAppKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) {
            CooperService.instance().getHeadObject().f40866e = str;
        }
    }

    public static void setAppChannel(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65539, null, context, str, z) == null) {
            if (str == null || str.equals("")) {
                bc.c().c("[WARNING] The channel you have set is empty");
            }
            CooperService.instance().getHeadObject().l = str;
            if (z && str != null && !str.equals("")) {
                bq.a().d(context, str);
                bq.a().b(context, true);
            }
            if (z) {
                return;
            }
            bq.a().d(context, "");
            bq.a().b(context, false);
        }
    }
}
