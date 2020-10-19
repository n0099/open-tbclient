package com.baidu.d.c;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.util.Base64Encoder;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes9.dex */
public class c {
    private String ans;
    private String ant;
    private String anu;
    private String anv;
    private String anw;

    public c() {
        init();
    }

    private void init() {
        this.ans = Build.MODEL;
        if (TextUtils.isEmpty(this.ans)) {
            this.ans = "NUL";
        } else {
            this.ans = this.ans.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.ant = Build.MANUFACTURER;
        if (TextUtils.isEmpty(this.ant)) {
            this.ant = "NUL";
        } else {
            this.ant = this.ant.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.anu = Build.VERSION.RELEASE;
        if (TextUtils.isEmpty(this.anu)) {
            this.anu = "0.0";
        } else {
            this.anu = this.anu.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        this.anv = uW();
        this.anw = new String(Base64Encoder.B64Encode(this.anv.getBytes()));
    }

    private String uW() {
        String str = this.ans;
        String str2 = this.anu;
        int i = Build.VERSION.SDK_INT;
        return str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.ant;
    }

    public String getDeviceInfo() {
        return this.anv;
    }
}
