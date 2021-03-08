package com.baidu.mobads.production.cpu;

import com.baidu.mobads.nativecpu.CpuLpFontSize;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class CPUWebAdRequestParam {
    private static final String DARK_MODE = "dark";
    private static final String LIGHT_MODE = "light";
    private final Map<String, Object> mParameters;

    private CPUWebAdRequestParam(Builder builder) {
        this.mParameters = new HashMap();
        if (builder == null || builder.mExtras == null) {
            return;
        }
        this.mParameters.putAll(builder.mExtras);
    }

    public Map<String, Object> getParameters() {
        return this.mParameters;
    }

    /* loaded from: classes4.dex */
    public static class Builder {
        private HashMap<String, Object> mExtras = new HashMap<>();

        public Builder setCustomUserId(String str) {
            this.mExtras.put("outerId", str);
            return this;
        }

        public Builder setLpDarkMode(boolean z) {
            this.mExtras.put("preferscolortheme", z ? CPUWebAdRequestParam.DARK_MODE : CPUWebAdRequestParam.LIGHT_MODE);
            return this;
        }

        public Builder setLpFontSize(CpuLpFontSize cpuLpFontSize) {
            this.mExtras.put("prefersfontsize", cpuLpFontSize.getValue());
            return this;
        }

        public Builder setCityIfLocalChannel(String str) {
            this.mExtras.put("city", str);
            return this;
        }

        public CPUWebAdRequestParam build() {
            return new CPUWebAdRequestParam(this);
        }
    }
}
