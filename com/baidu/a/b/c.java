package com.baidu.a.b;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.util.Base64Encoder;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes12.dex */
public class c {
    private String ajN;
    private String ajO;
    private String ajP;
    private String ajQ;
    private String ajR;

    public c() {
        init();
    }

    private void init() {
        this.ajN = Build.MODEL;
        if (TextUtils.isEmpty(this.ajN)) {
            this.ajN = "NUL";
        } else {
            this.ajN = this.ajN.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.ajO = Build.MANUFACTURER;
        if (TextUtils.isEmpty(this.ajO)) {
            this.ajO = "NUL";
        } else {
            this.ajO = this.ajO.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.ajP = Build.VERSION.RELEASE;
        if (TextUtils.isEmpty(this.ajP)) {
            this.ajP = "0.0";
        } else {
            this.ajP = this.ajP.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.ajQ = su();
        this.ajR = new String(Base64Encoder.B64Encode(this.ajQ.getBytes()));
    }

    private String su() {
        String str = this.ajN;
        String str2 = this.ajP;
        int i = Build.VERSION.SDK_INT;
        return str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.ajO;
    }

    public String getDeviceInfo() {
        return this.ajQ;
    }
}
