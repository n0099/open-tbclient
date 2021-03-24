package com.baidu.mobads.production.cpu;

import com.baidu.mobads.nativecpu.CpuLpFontSize;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class CPUWebAdRequestParam {
    public static final String DARK_MODE = "dark";
    public static final String LIGHT_MODE = "light";
    public final Map<String, Object> mParameters;

    /* loaded from: classes2.dex */
    public static class Builder {
        public HashMap<String, Object> mExtras = new HashMap<>();

        public CPUWebAdRequestParam build() {
            return new CPUWebAdRequestParam(this);
        }

        public Builder setCityIfLocalChannel(String str) {
            this.mExtras.put("city", str);
            return this;
        }

        public Builder setCustomUserId(String str) {
            this.mExtras.put("outerId", str);
            return this;
        }

        public Builder setLpDarkMode(boolean z) {
            this.mExtras.put("preferscolortheme", z ? "dark" : CPUWebAdRequestParam.LIGHT_MODE);
            return this;
        }

        public Builder setLpFontSize(CpuLpFontSize cpuLpFontSize) {
            this.mExtras.put("prefersfontsize", cpuLpFontSize.getValue());
            return this;
        }
    }

    public Map<String, Object> getParameters() {
        return this.mParameters;
    }

    public CPUWebAdRequestParam(Builder builder) {
        this.mParameters = new HashMap();
        if (builder == null || builder.mExtras == null) {
            return;
        }
        this.mParameters.putAll(builder.mExtras);
    }
}
