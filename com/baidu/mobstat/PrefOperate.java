package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes9.dex */
public class PrefOperate {
    public static void loadMetaDataConfig(Context context) {
        SendStrategyEnum sendStrategyEnum = SendStrategyEnum.APP_START;
        try {
            String a = bw.a(context, Config.EXCEPTION_LOG_META_NAME);
            if (!TextUtils.isEmpty(a) && "true".equals(a)) {
                ExceptionAnalysis.getInstance().openExceptionAnalysis(context, false);
            }
        } catch (Exception e) {
        }
        try {
            String a2 = bw.a(context, Config.SEND_STRATEGY_META_NAME);
            if (!TextUtils.isEmpty(a2)) {
                if (a2.equals(SendStrategyEnum.APP_START.name())) {
                    sendStrategyEnum = SendStrategyEnum.APP_START;
                    bq.a().a(context, sendStrategyEnum.ordinal());
                } else if (a2.equals(SendStrategyEnum.ONCE_A_DAY.name())) {
                    sendStrategyEnum = SendStrategyEnum.ONCE_A_DAY;
                    bq.a().a(context, sendStrategyEnum.ordinal());
                    bq.a().b(context, 24);
                } else if (a2.equals(SendStrategyEnum.SET_TIME_INTERVAL.name())) {
                    sendStrategyEnum = SendStrategyEnum.SET_TIME_INTERVAL;
                    bq.a().a(context, sendStrategyEnum.ordinal());
                }
            }
        } catch (Exception e2) {
        }
        try {
            String a3 = bw.a(context, Config.TIME_INTERVAL_META_NAME);
            if (!TextUtils.isEmpty(a3)) {
                int parseInt = Integer.parseInt(a3);
                if (sendStrategyEnum.ordinal() == SendStrategyEnum.SET_TIME_INTERVAL.ordinal() && parseInt > 0 && parseInt <= 24) {
                    bq.a().b(context, parseInt);
                }
            }
        } catch (Exception e3) {
        }
        try {
            String a4 = bw.a(context, Config.ONLY_WIFI_META_NAME);
            if (!TextUtils.isEmpty(a4)) {
                if ("true".equals(a4)) {
                    bq.a().a(context, true);
                } else if ("false".equals(a4)) {
                    bq.a().a(context, false);
                }
            }
        } catch (Exception e4) {
        }
    }

    public static void setAppKey(String str) {
        CooperService.instance().getHeadObject().e = str;
    }

    public static String getAppKey(Context context) {
        return CooperService.instance().getAppKey(context);
    }

    public static void setAppChannel(String str) {
        if (str == null || str.equals("")) {
            bc.c().c("[WARNING] The channel you have set is empty");
        }
        CooperService.instance().getHeadObject().l = str;
    }

    public static void setAppChannel(Context context, String str, boolean z) {
        if (str == null || str.equals("")) {
            bc.c().c("[WARNING] The channel you have set is empty");
        }
        CooperService.instance().getHeadObject().l = str;
        if (z && str != null && !str.equals("")) {
            bq.a().d(context, str);
            bq.a().b(context, true);
        }
        if (!z) {
            bq.a().d(context, "");
            bq.a().b(context, false);
        }
    }
}
