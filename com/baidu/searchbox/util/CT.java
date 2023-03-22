package com.baidu.searchbox.util;

import android.text.TextUtils;
import com.baidu.util.Base64Encoder;
/* loaded from: classes2.dex */
public class CT {
    public static final String DEFAULT_CTV = "1";
    public String mCtv;

    public CT() {
        init();
    }

    private void init() {
        int B64GetVersion = Base64Encoder.B64GetVersion();
        if (B64GetVersion == 0) {
            this.mCtv = "1";
            return;
        }
        this.mCtv = B64GetVersion + "";
    }

    public String getVersion() {
        return this.mCtv;
    }

    public boolean isDefaultCtv() {
        return TextUtils.equals(this.mCtv, "1");
    }
}
