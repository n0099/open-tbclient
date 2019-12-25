package com.baidu.b.b;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.util.Base64Encoder;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes9.dex */
public class c {
    private String OP;
    private String OQ;
    private String OR;
    private String OT;
    private String OU;

    public c() {
        init();
    }

    private void init() {
        this.OP = Build.MODEL;
        if (TextUtils.isEmpty(this.OP)) {
            this.OP = "NUL";
        } else {
            this.OP = this.OP.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.OQ = Build.MANUFACTURER;
        if (TextUtils.isEmpty(this.OQ)) {
            this.OQ = "NUL";
        } else {
            this.OQ = this.OQ.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.OR = Build.VERSION.RELEASE;
        if (TextUtils.isEmpty(this.OR)) {
            this.OR = "0.0";
        } else {
            this.OR = this.OR.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.OT = nk();
        this.OU = new String(Base64Encoder.B64Encode(this.OT.getBytes()));
    }

    private String nk() {
        String str = this.OP;
        String str2 = this.OR;
        int i = Build.VERSION.SDK_INT;
        return str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.OQ;
    }

    public String getDeviceInfo() {
        return this.OT;
    }
}
