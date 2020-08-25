package com.baidu.d.b;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.util.Base64Encoder;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes5.dex */
public class c {
    private String amf;
    private String amg;
    private String amh;
    private String ami;
    private String amj;

    public c() {
        init();
    }

    private void init() {
        this.amf = Build.MODEL;
        if (TextUtils.isEmpty(this.amf)) {
            this.amf = "NUL";
        } else {
            this.amf = this.amf.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.amg = Build.MANUFACTURER;
        if (TextUtils.isEmpty(this.amg)) {
            this.amg = "NUL";
        } else {
            this.amg = this.amg.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.amh = Build.VERSION.RELEASE;
        if (TextUtils.isEmpty(this.amh)) {
            this.amh = "0.0";
        } else {
            this.amh = this.amh.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.ami = uz();
        this.amj = new String(Base64Encoder.B64Encode(this.ami.getBytes()));
    }

    private String uz() {
        String str = this.amf;
        String str2 = this.amh;
        int i = Build.VERSION.SDK_INT;
        return str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.amg;
    }

    public String getDeviceInfo() {
        return this.ami;
    }
}
