package com.baidu.b.b;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.util.Base64Encoder;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes12.dex */
public class c {
    private String QF;
    private String QG;
    private String QH;
    private String QI;
    private String QJ;

    public c() {
        init();
    }

    private void init() {
        this.QF = Build.MODEL;
        if (TextUtils.isEmpty(this.QF)) {
            this.QF = "NUL";
        } else {
            this.QF = this.QF.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.QG = Build.MANUFACTURER;
        if (TextUtils.isEmpty(this.QG)) {
            this.QG = "NUL";
        } else {
            this.QG = this.QG.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.QH = Build.VERSION.RELEASE;
        if (TextUtils.isEmpty(this.QH)) {
            this.QH = "0.0";
        } else {
            this.QH = this.QH.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.QI = nS();
        this.QJ = new String(Base64Encoder.B64Encode(this.QI.getBytes()));
    }

    private String nS() {
        String str = this.QF;
        String str2 = this.QH;
        int i = Build.VERSION.SDK_INT;
        return str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.QG;
    }

    public String getDeviceInfo() {
        return this.QI;
    }
}
