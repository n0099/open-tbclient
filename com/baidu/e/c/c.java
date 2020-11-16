package com.baidu.e.c;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.util.Base64Encoder;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes14.dex */
public class c {
    private String anA;
    private String anB;
    private String anC;
    private String anD;
    private String anz;

    public c() {
        init();
    }

    private void init() {
        this.anz = Build.MODEL;
        if (TextUtils.isEmpty(this.anz)) {
            this.anz = "NUL";
        } else {
            this.anz = this.anz.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.anA = Build.MANUFACTURER;
        if (TextUtils.isEmpty(this.anA)) {
            this.anA = "NUL";
        } else {
            this.anA = this.anA.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.anB = Build.VERSION.RELEASE;
        if (TextUtils.isEmpty(this.anB)) {
            this.anB = "0.0";
        } else {
            this.anB = this.anB.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.anC = uV();
        this.anD = new String(Base64Encoder.B64Encode(this.anC.getBytes()));
    }

    private String uV() {
        String str = this.anz;
        String str2 = this.anB;
        int i = Build.VERSION.SDK_INT;
        return str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.anA;
    }

    public String getDeviceInfo() {
        return this.anC;
    }
}
