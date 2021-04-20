package com.baidu.mobads.container.feeds;

import android.content.Context;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.AdURIUtils;
import com.baidu.mobads.container.util.Base64;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.mobads.container.util.EncryptUtils;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.searchbox.pms.db.PackageTable;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ThirdMonitorTracker {
    public static final String AD_ID = "crid";
    public static final String REGULAR_EXPRESSION = "\\{@([()\\w]+)\\}";
    public static ThirdMonitorTracker mThirdMonitorTracker;

    private String convertString(String str, String str2) {
        if (AdURIUtils.isStringAvailable(str) && AdURIUtils.isStringAvailable(str2)) {
            if (PackageTable.MD5.equals(str)) {
                return EncryptUtils.getMD5(str2);
            }
            if ("toUpper".equals(str)) {
                return str2.toUpperCase(Locale.getDefault());
            }
            if ("toLower".equals(str)) {
                return str2.toLowerCase(Locale.getDefault());
            }
            if ("clearColon".equals(str)) {
                return str2.replace(":", "");
            }
            if ("clearLine".equals(str)) {
                return str2.replace("-", "");
            }
        }
        return "";
    }

    private String executeMethod(Context context, String str, String str2, JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has(str)) {
            return jSONObject.optString(str);
        }
        String info = getInfo(context, str, jSONObject);
        return AdURIUtils.isStringAvailable(info) ? info : convertString(str, str2);
    }

    private String getInfo(Context context, String str, JSONObject jSONObject) {
        String appId = DeviceUtils.getInstance().getAppId(context);
        if (jSONObject != null) {
            appId = jSONObject.optString("appsid");
        }
        if ("uid".equals(str)) {
            return Base64.encode(DeviceUtils.getInstance().getDeviceId(context));
        }
        if ("uidtype".equals(str)) {
            return "2";
        }
        if (IAdRequestParam.CHID.equals(str)) {
            return "";
        }
        if (!"ts".equals(str)) {
            return "pid".equals(str) ? appId : IAdRequestParam.CELL_ID.equals(str) ? "mobads" : "";
        }
        return "" + System.currentTimeMillis();
    }

    public static ThirdMonitorTracker getInstance() {
        if (mThirdMonitorTracker == null) {
            synchronized (ThirdMonitorTracker.class) {
                if (mThirdMonitorTracker == null) {
                    mThirdMonitorTracker = new ThirdMonitorTracker();
                }
            }
        }
        return mThirdMonitorTracker;
    }

    private String handler(Context context, String str, JSONObject jSONObject) {
        String str2 = "";
        if (AdURIUtils.isStringAvailable(str)) {
            String[] split = str.replaceAll("\\)*$", "").split("\\(");
            for (int length = split.length - 1; length >= 0; length--) {
                if (AdURIUtils.isStringAvailable(split[length])) {
                    str2 = executeMethod(context, split[length], str2, jSONObject);
                }
            }
            return str2;
        }
        return "";
    }

    public String build3rdLogUrl(Context context, String str, JSONObject jSONObject) {
        if (context == null || !AdURIUtils.isStringAvailable(str)) {
            return "";
        }
        Matcher matcher = Pattern.compile(REGULAR_EXPRESSION).matcher(str);
        while (matcher.find()) {
            try {
                str = str.replaceFirst(REGULAR_EXPRESSION, handler(context, matcher.group(1), jSONObject));
            } catch (Throwable th) {
                RemoteXAdLogger.getInstance().d(th);
            }
        }
        return str;
    }
}
