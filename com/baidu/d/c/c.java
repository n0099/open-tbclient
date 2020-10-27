package com.baidu.d.c;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.util.Base64Encoder;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes9.dex */
public class c {
    private String ant;
    private String anu;
    private String anv;
    private String anw;
    private String anx;

    public c() {
        init();
    }

    private void init() {
        this.ant = Build.MODEL;
        if (TextUtils.isEmpty(this.ant)) {
            this.ant = "NUL";
        } else {
            this.ant = this.ant.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.anu = Build.MANUFACTURER;
        if (TextUtils.isEmpty(this.anu)) {
            this.anu = "NUL";
        } else {
            this.anu = this.anu.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.anv = Build.VERSION.RELEASE;
        if (TextUtils.isEmpty(this.anv)) {
            this.anv = "0.0";
        } else {
            this.anv = this.anv.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.anw = uW();
        this.anx = new String(Base64Encoder.B64Encode(this.anw.getBytes()));
    }

    private String uW() {
        String str = this.ant;
        String str2 = this.anv;
        int i = Build.VERSION.SDK_INT;
        return str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.anu;
    }

    public String getDeviceInfo() {
        return this.anw;
    }
}
