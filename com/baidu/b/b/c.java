package com.baidu.b.b;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.util.Base64Encoder;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes10.dex */
public class c {
    private String OU;
    private String OV;
    private String OW;
    private String OX;
    private String OY;

    public c() {
        init();
    }

    private void init() {
        this.OU = Build.MODEL;
        if (TextUtils.isEmpty(this.OU)) {
            this.OU = "NUL";
        } else {
            this.OU = this.OU.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.OV = Build.MANUFACTURER;
        if (TextUtils.isEmpty(this.OV)) {
            this.OV = "NUL";
        } else {
            this.OV = this.OV.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.OW = Build.VERSION.RELEASE;
        if (TextUtils.isEmpty(this.OW)) {
            this.OW = "0.0";
        } else {
            this.OW = this.OW.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.OX = nl();
        this.OY = new String(Base64Encoder.B64Encode(this.OX.getBytes()));
    }

    private String nl() {
        String str = this.OU;
        String str2 = this.OW;
        int i = Build.VERSION.SDK_INT;
        return str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.OV;
    }

    public String getDeviceInfo() {
        return this.OX;
    }
}
