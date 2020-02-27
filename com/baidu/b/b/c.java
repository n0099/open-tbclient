package com.baidu.b.b;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.util.Base64Encoder;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes12.dex */
public class c {
    private String QD;
    private String QE;
    private String QF;
    private String QG;
    private String QH;

    public c() {
        init();
    }

    private void init() {
        this.QD = Build.MODEL;
        if (TextUtils.isEmpty(this.QD)) {
            this.QD = "NUL";
        } else {
            this.QD = this.QD.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.QE = Build.MANUFACTURER;
        if (TextUtils.isEmpty(this.QE)) {
            this.QE = "NUL";
        } else {
            this.QE = this.QE.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.QF = Build.VERSION.RELEASE;
        if (TextUtils.isEmpty(this.QF)) {
            this.QF = "0.0";
        } else {
            this.QF = this.QF.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.QG = nT();
        this.QH = new String(Base64Encoder.B64Encode(this.QG.getBytes()));
    }

    private String nT() {
        String str = this.QD;
        String str2 = this.QF;
        int i = Build.VERSION.SDK_INT;
        return str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.QE;
    }

    public String getDeviceInfo() {
        return this.QG;
    }
}
