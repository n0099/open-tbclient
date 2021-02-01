package cn.com.chinatelecom.account.api;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import cn.com.chinatelecom.account.api.a.b;
import cn.com.chinatelecom.account.api.c.d;
import cn.com.chinatelecom.account.api.c.e;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.security.interfaces.RSAPublicKey;
/* loaded from: classes3.dex */
public final class ClientUtils {
    private static final String TAG = ClientUtils.class.getSimpleName();

    public static String enrdata(String str, String str2) {
        try {
            return b.a(str, (RSAPublicKey) b.a(str2));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getApiVersion() {
        return "v1.46";
    }

    public static String getCurrentNetworkType(Context context) {
        return e.g(context);
    }

    public static String getMobileBrand() {
        return Build.BRAND;
    }

    public static String getModel() {
        return Build.MODEL;
    }

    public static String getOnlineType(Context context) {
        return e.f(context);
    }

    public static String getOperatorType(Context context) {
        return d.d(context);
    }

    public static String getOs() {
        return getMobileBrand() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + getModel() + "-A:" + Build.VERSION.RELEASE;
    }

    public static String getPID() {
        String str = "";
        try {
            String str2 = Thread.currentThread().getId() + "" + Process.myPid();
            if (str2.length() > 6) {
                str = str2.substring(0, 6);
                return str;
            }
            return "ctacco";
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String getSdkVersion() {
        return "SDK-API-v1.5.1";
    }

    public static String getTopActivity(Context context) {
        try {
            return ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(1).get(0).topActivity.getClassName();
        } catch (Throwable th) {
            th.printStackTrace();
            return BdStatsConstant.StatsType.ERROR;
        }
    }

    public static long getTp() {
        return System.currentTimeMillis();
    }

    public static boolean isAT(Context context, String str) {
        try {
            return ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(1).get(0).topActivity.getClassName().equals(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
