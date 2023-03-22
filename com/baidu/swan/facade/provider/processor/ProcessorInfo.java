package com.baidu.swan.facade.provider.processor;

import com.baidu.tieba.au3;
import com.baidu.tieba.bu3;
import com.baidu.tieba.cu3;
import com.baidu.tieba.zt3;
/* loaded from: classes3.dex */
public enum ProcessorInfo {
    PARAMS(cu3.class, "params"),
    FAVORITE(au3.class, "favorite"),
    HISTORY(bu3.class, "history");
    
    public Class<? extends zt3> mClass;
    public int mMatcherCode = ordinal();
    public String mPath;

    ProcessorInfo(Class cls, String str) {
        this.mClass = cls;
        this.mPath = str;
    }

    private Class<? extends zt3> getProcessorClass() {
        return this.mClass;
    }

    public int getMatcherCode() {
        return this.mMatcherCode;
    }

    public String getPath() {
        return this.mPath;
    }

    public static Class<? extends zt3> getProcessorClass(int i) {
        ProcessorInfo[] values;
        for (ProcessorInfo processorInfo : values()) {
            if (processorInfo != null && processorInfo.getMatcherCode() == i) {
                return processorInfo.getProcessorClass();
            }
        }
        return null;
    }
}
