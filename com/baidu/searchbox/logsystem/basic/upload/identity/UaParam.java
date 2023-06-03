package com.baidu.searchbox.logsystem.basic.upload.identity;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.aperf.param.CommonUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.util.Base64Encoder;
/* loaded from: classes4.dex */
public class UaParam {
    public String mEnUa;
    public String mUa;
    public String mVersionName;

    public UaParam() {
        init();
    }

    private void init() {
        Context appContext = AppRuntime.getAppContext();
        this.mVersionName = CommonUtils.getAppVersion();
        this.mUa = getUA(appContext);
    }

    private void initEnUA() {
        this.mEnUa = new String(Base64Encoder.B64Encode(this.mUa.getBytes()));
    }

    public String getEnUA() {
        if (TextUtils.isEmpty(this.mEnUa)) {
            initEnUA();
        }
        return this.mEnUa;
    }

    public String getUA() {
        return this.mUa;
    }

    private String getUA(Context context) {
        int displayWidth = DeviceUtil.ScreenInfo.getDisplayWidth(context);
        int displayHeight = DeviceUtil.ScreenInfo.getDisplayHeight(context);
        int densityDpi = DeviceUtil.ScreenInfo.getDensityDpi(context);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(displayWidth);
        stringBuffer.append("_");
        stringBuffer.append(displayHeight);
        stringBuffer.append("_");
        stringBuffer.append("android");
        stringBuffer.append("_");
        stringBuffer.append(this.mVersionName);
        stringBuffer.append("_");
        stringBuffer.append(densityDpi);
        return stringBuffer.toString();
    }
}
