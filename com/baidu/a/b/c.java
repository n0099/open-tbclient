package com.baidu.a.b;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.util.Base64Encoder;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes12.dex */
public class c {
    private String ajj;
    private String ajk;
    private String ajl;
    private String ajm;
    private String ajn;

    public c() {
        init();
    }

    private void init() {
        this.ajj = Build.MODEL;
        if (TextUtils.isEmpty(this.ajj)) {
            this.ajj = "NUL";
        } else {
            this.ajj = this.ajj.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.ajk = Build.MANUFACTURER;
        if (TextUtils.isEmpty(this.ajk)) {
            this.ajk = "NUL";
        } else {
            this.ajk = this.ajk.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.ajl = Build.VERSION.RELEASE;
        if (TextUtils.isEmpty(this.ajl)) {
            this.ajl = "0.0";
        } else {
            this.ajl = this.ajl.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.ajm = sk();
        this.ajn = new String(Base64Encoder.B64Encode(this.ajm.getBytes()));
    }

    private String sk() {
        String str = this.ajj;
        String str2 = this.ajl;
        int i = Build.VERSION.SDK_INT;
        return str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.ajk;
    }

    public String getDeviceInfo() {
        return this.ajm;
    }
}
