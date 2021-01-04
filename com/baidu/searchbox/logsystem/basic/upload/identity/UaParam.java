package com.baidu.searchbox.logsystem.basic.upload.identity;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.logsystem.util.Common;
import com.baidu.util.Base64Encoder;
/* loaded from: classes6.dex */
public class UaParam {
    private String mEnUa;
    private String mUa;
    private String mVersionName;

    public UaParam() {
        init();
    }

    private void init() {
        Context appContext = AppRuntime.getAppContext();
        this.mVersionName = Common.getVersionInfo().mAppVersion;
        this.mUa = getUA(appContext);
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
        stringBuffer.append(HttpConstants.OS_TYPE_VALUE);
        stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        stringBuffer.append(this.mVersionName);
        stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        stringBuffer.append(densityDpi);
        return stringBuffer.toString();
    }

    public String getUA() {
        return this.mUa;
    }

    public String getEnUA() {
        if (TextUtils.isEmpty(this.mEnUa)) {
            initEnUA();
        }
        return this.mEnUa;
    }

    private void initEnUA() {
        this.mEnUa = new String(Base64Encoder.B64Encode(this.mUa.getBytes()));
    }
}
