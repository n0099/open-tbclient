package com.baidu.swan.facade.provider.processor;

import com.baidu.tieba.qs3;
import com.baidu.tieba.rs3;
import com.baidu.tieba.ss3;
import com.baidu.tieba.ts3;
/* loaded from: classes4.dex */
public enum ProcessorInfo {
    PARAMS(ts3.class, "params"),
    FAVORITE(rs3.class, "favorite"),
    HISTORY(ss3.class, "history");
    
    public Class<? extends qs3> mClass;
    public int mMatcherCode = ordinal();
    public String mPath;

    ProcessorInfo(Class cls, String str) {
        this.mClass = cls;
        this.mPath = str;
    }

    private Class<? extends qs3> getProcessorClass() {
        return this.mClass;
    }

    public int getMatcherCode() {
        return this.mMatcherCode;
    }

    public String getPath() {
        return this.mPath;
    }

    public static Class<? extends qs3> getProcessorClass(int i) {
        ProcessorInfo[] values;
        for (ProcessorInfo processorInfo : values()) {
            if (processorInfo != null && processorInfo.getMatcherCode() == i) {
                return processorInfo.getProcessorClass();
            }
        }
        return null;
    }
}
