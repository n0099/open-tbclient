package com.baidu.d.c;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.util.Base64Encoder;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes11.dex */
public class c {
    private String amJ;
    private String amK;
    private String amL;
    private String amM;
    private String amN;

    public c() {
        init();
    }

    private void init() {
        this.amJ = Build.MODEL;
        if (TextUtils.isEmpty(this.amJ)) {
            this.amJ = "NUL";
        } else {
            this.amJ = this.amJ.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.amK = Build.MANUFACTURER;
        if (TextUtils.isEmpty(this.amK)) {
            this.amK = "NUL";
        } else {
            this.amK = this.amK.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.amL = Build.VERSION.RELEASE;
        if (TextUtils.isEmpty(this.amL)) {
            this.amL = "0.0";
        } else {
            this.amL = this.amL.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.amM = uN();
        this.amN = new String(Base64Encoder.B64Encode(this.amM.getBytes()));
    }

    private String uN() {
        String str = this.amJ;
        String str2 = this.amL;
        int i = Build.VERSION.SDK_INT;
        return str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.amK;
    }

    public String getDeviceInfo() {
        return this.amM;
    }
}
