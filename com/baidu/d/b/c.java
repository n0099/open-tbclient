package com.baidu.d.b;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.util.Base64Encoder;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes5.dex */
public class c {
    private String amh;
    private String ami;
    private String amj;
    private String amk;
    private String aml;

    public c() {
        init();
    }

    private void init() {
        this.amh = Build.MODEL;
        if (TextUtils.isEmpty(this.amh)) {
            this.amh = "NUL";
        } else {
            this.amh = this.amh.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.ami = Build.MANUFACTURER;
        if (TextUtils.isEmpty(this.ami)) {
            this.ami = "NUL";
        } else {
            this.ami = this.ami.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.amj = Build.VERSION.RELEASE;
        if (TextUtils.isEmpty(this.amj)) {
            this.amj = "0.0";
        } else {
            this.amj = this.amj.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.amk = uz();
        this.aml = new String(Base64Encoder.B64Encode(this.amk.getBytes()));
    }

    private String uz() {
        String str = this.amh;
        String str2 = this.amj;
        int i = Build.VERSION.SDK_INT;
        return str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.ami;
    }

    public String getDeviceInfo() {
        return this.amk;
    }
}
