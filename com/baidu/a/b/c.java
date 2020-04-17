package com.baidu.a.b;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.util.Base64Encoder;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes12.dex */
public class c {
    private String aje;
    private String ajf;
    private String ajg;
    private String ajh;
    private String aji;

    public c() {
        init();
    }

    private void init() {
        this.aje = Build.MODEL;
        if (TextUtils.isEmpty(this.aje)) {
            this.aje = "NUL";
        } else {
            this.aje = this.aje.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.ajf = Build.MANUFACTURER;
        if (TextUtils.isEmpty(this.ajf)) {
            this.ajf = "NUL";
        } else {
            this.ajf = this.ajf.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.ajg = Build.VERSION.RELEASE;
        if (TextUtils.isEmpty(this.ajg)) {
            this.ajg = "0.0";
        } else {
            this.ajg = this.ajg.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.ajh = sl();
        this.aji = new String(Base64Encoder.B64Encode(this.ajh.getBytes()));
    }

    private String sl() {
        String str = this.aje;
        String str2 = this.ajg;
        int i = Build.VERSION.SDK_INT;
        return str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.ajf;
    }

    public String getDeviceInfo() {
        return this.ajh;
    }
}
