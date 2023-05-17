package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
/* loaded from: classes3.dex */
public class PrefOperate {
    public static String getAppKey(Context context) {
        return CooperService.instance().getAppKey(context);
    }

    public static void setAppChannel(String str) {
        if (str == null || str.equals("")) {
            bb.c().c("[WARNING] The channel you have set is empty");
        }
        CooperService.instance().getHeadObject().l = str;
    }

    public static void setAppKey(String str) {
        CooperService.instance().getHeadObject().e = str;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0081 -> B:42:0x0081). Please submit an issue!!! */
    public static void loadMetaDataConfig(Context context) {
        SendStrategyEnum sendStrategyEnum = SendStrategyEnum.APP_START;
        try {
            String a = bw.a(context, Config.EXCEPTION_LOG_META_NAME);
            if (!TextUtils.isEmpty(a) && "true".equals(a)) {
                ExceptionAnalysis.getInstance().openExceptionAnalysis(context, false);
            }
        } catch (Exception unused) {
        }
        try {
            String a2 = bw.a(context, Config.SEND_STRATEGY_META_NAME);
            if (!TextUtils.isEmpty(a2)) {
                if (a2.equals(SendStrategyEnum.APP_START.name())) {
                    sendStrategyEnum = SendStrategyEnum.APP_START;
                    bp.a().a(context, sendStrategyEnum.ordinal());
                } else if (a2.equals(SendStrategyEnum.ONCE_A_DAY.name())) {
                    sendStrategyEnum = SendStrategyEnum.ONCE_A_DAY;
                    bp.a().a(context, sendStrategyEnum.ordinal());
                    bp.a().b(context, 24);
                } else if (a2.equals(SendStrategyEnum.SET_TIME_INTERVAL.name())) {
                    sendStrategyEnum = SendStrategyEnum.SET_TIME_INTERVAL;
                    bp.a().a(context, sendStrategyEnum.ordinal());
                }
            }
        } catch (Exception unused2) {
        }
        try {
            String a3 = bw.a(context, Config.TIME_INTERVAL_META_NAME);
            if (!TextUtils.isEmpty(a3)) {
                int parseInt = Integer.parseInt(a3);
                if (sendStrategyEnum.ordinal() == SendStrategyEnum.SET_TIME_INTERVAL.ordinal() && parseInt > 0 && parseInt <= 24) {
                    bp.a().b(context, parseInt);
                }
            }
        } catch (Exception unused3) {
        }
        try {
            String a4 = bw.a(context, Config.ONLY_WIFI_META_NAME);
            if (!TextUtils.isEmpty(a4)) {
                if ("true".equals(a4)) {
                    bp.a().a(context, true);
                } else if (CommandUBCHelper.COMMAND_UBC_VALUE_FALSE.equals(a4)) {
                    bp.a().a(context, false);
                }
            }
        } catch (Exception unused4) {
        }
    }

    public static void setAppChannel(Context context, String str, boolean z) {
        if (str == null || str.equals("")) {
            bb.c().c("[WARNING] The channel you have set is empty");
        }
        CooperService.instance().getHeadObject().l = str;
        if (z && str != null && !str.equals("")) {
            bp.a().d(context, str);
            bp.a().b(context, true);
        }
        if (!z) {
            bp.a().d(context, "");
            bp.a().b(context, false);
        }
    }
}
