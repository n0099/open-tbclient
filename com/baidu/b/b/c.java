package com.baidu.b.b;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.util.Base64Encoder;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes8.dex */
public class c {
    private String ale;
    private String alf;
    private String alg;
    private String alh;
    private String ali;

    public c() {
        init();
    }

    private void init() {
        this.ale = Build.MODEL;
        if (TextUtils.isEmpty(this.ale)) {
            this.ale = "NUL";
        } else {
            this.ale = this.ale.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.alf = Build.MANUFACTURER;
        if (TextUtils.isEmpty(this.alf)) {
            this.alf = "NUL";
        } else {
            this.alf = this.alf.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.alg = Build.VERSION.RELEASE;
        if (TextUtils.isEmpty(this.alg)) {
            this.alg = "0.0";
        } else {
            this.alg = this.alg.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.alh = sR();
        this.ali = new String(Base64Encoder.B64Encode(this.alh.getBytes()));
    }

    private String sR() {
        String str = this.ale;
        String str2 = this.alg;
        int i = Build.VERSION.SDK_INT;
        return str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.alf;
    }

    public String getDeviceInfo() {
        return this.alh;
    }
}
