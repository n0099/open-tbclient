package com.baidu.swan.facade.provider.processor;

import com.baidu.tieba.jx3;
import com.baidu.tieba.kx3;
import com.baidu.tieba.lx3;
import com.baidu.tieba.mx3;
/* loaded from: classes4.dex */
public enum ProcessorInfo {
    PARAMS(mx3.class, "params"),
    FAVORITE(kx3.class, "favorite"),
    HISTORY(lx3.class, "history");
    
    public Class<? extends jx3> mClass;
    public int mMatcherCode = ordinal();
    public String mPath;

    ProcessorInfo(Class cls, String str) {
        this.mClass = cls;
        this.mPath = str;
    }

    private Class<? extends jx3> getProcessorClass() {
        return this.mClass;
    }

    public int getMatcherCode() {
        return this.mMatcherCode;
    }

    public String getPath() {
        return this.mPath;
    }

    public static Class<? extends jx3> getProcessorClass(int i) {
        ProcessorInfo[] values;
        for (ProcessorInfo processorInfo : values()) {
            if (processorInfo != null && processorInfo.getMatcherCode() == i) {
                return processorInfo.getProcessorClass();
            }
        }
        return null;
    }
}
