package com.baidu.d.c;

import android.content.Context;
import android.content.pm.PackageManager;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.util.Base64Encoder;
/* loaded from: classes9.dex */
public class g {
    private String anA;
    private String anz;
    private String mVersionName;

    public g() {
        init();
    }

    private void init() {
        Context appContext = AppRuntime.getAppContext();
        this.mVersionName = getVersionName(appContext);
        this.anz = getUA(appContext);
        this.anA = new String(Base64Encoder.B64Encode(this.anz.getBytes()));
    }

    private String getUA(Context context) {
        int displayWidth = DeviceUtil.ScreenInfo.getDisplayWidth(context);
        int displayHeight = DeviceUtil.ScreenInfo.getDisplayHeight(context);
        int densityDpi = DeviceUtil.ScreenInfo.getDensityDpi(context);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(displayWidth);
        stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        stringBuffer.append(displayHeight);
        stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        stringBuffer.append("android");
        stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        stringBuffer.append(this.mVersionName);
        stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        stringBuffer.append(densityDpi);
        return stringBuffer.toString();
    }

    public String vd() {
        return this.anz;
    }

    public String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "0.8";
        }
    }
}
