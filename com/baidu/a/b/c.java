package com.baidu.a.b;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.util.Base64Encoder;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes12.dex */
public class c {
    private String alj;
    private String alk;
    private String alm;
    private String aln;
    private String alo;

    public c() {
        init();
    }

    private void init() {
        this.alj = Build.MODEL;
        if (TextUtils.isEmpty(this.alj)) {
            this.alj = "NUL";
        } else {
            this.alj = this.alj.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.alk = Build.MANUFACTURER;
        if (TextUtils.isEmpty(this.alk)) {
            this.alk = "NUL";
        } else {
            this.alk = this.alk.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.alm = Build.VERSION.RELEASE;
        if (TextUtils.isEmpty(this.alm)) {
            this.alm = "0.0";
        } else {
            this.alm = this.alm.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.aln = sP();
        this.alo = new String(Base64Encoder.B64Encode(this.aln.getBytes()));
    }

    private String sP() {
        String str = this.alj;
        String str2 = this.alm;
        int i = Build.VERSION.SDK_INT;
        return str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.alk;
    }

    public String getDeviceInfo() {
        return this.aln;
    }
}
