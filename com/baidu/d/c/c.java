package com.baidu.d.c;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes4.dex */
public class c {
    private String mDeviceInfo;
    private String mManufacturer;
    private String mModel;
    private String mOSVersion;

    public c() {
        init();
    }

    private void init() {
        this.mModel = Build.MODEL;
        if (TextUtils.isEmpty(this.mModel)) {
            this.mModel = "NUL";
        } else {
            this.mModel = this.mModel.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.mManufacturer = Build.MANUFACTURER;
        if (TextUtils.isEmpty(this.mManufacturer)) {
            this.mManufacturer = "NUL";
        } else {
            this.mManufacturer = this.mManufacturer.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.mOSVersion = Build.VERSION.RELEASE;
        if (TextUtils.isEmpty(this.mOSVersion)) {
            this.mOSVersion = "0.0";
        } else {
            this.mOSVersion = this.mOSVersion.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.mDeviceInfo = initDeviceInfo();
    }

    private String initDeviceInfo() {
        String str = this.mModel;
        String str2 = this.mOSVersion;
        int i = Build.VERSION.SDK_INT;
        return str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.mManufacturer;
    }

    public String getDeviceInfo() {
        return this.mDeviceInfo;
    }
}
