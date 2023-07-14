package com.baidu.swan.facade.provider.processor;

import com.baidu.tieba.by3;
import com.baidu.tieba.cy3;
import com.baidu.tieba.dy3;
import com.baidu.tieba.ey3;
/* loaded from: classes4.dex */
public enum ProcessorInfo {
    PARAMS(ey3.class, "params"),
    FAVORITE(cy3.class, "favorite"),
    HISTORY(dy3.class, "history");
    
    public Class<? extends by3> mClass;
    public int mMatcherCode = ordinal();
    public String mPath;

    ProcessorInfo(Class cls, String str) {
        this.mClass = cls;
        this.mPath = str;
    }

    private Class<? extends by3> getProcessorClass() {
        return this.mClass;
    }

    public int getMatcherCode() {
        return this.mMatcherCode;
    }

    public String getPath() {
        return this.mPath;
    }

    public static Class<? extends by3> getProcessorClass(int i) {
        ProcessorInfo[] values;
        for (ProcessorInfo processorInfo : values()) {
            if (processorInfo != null && processorInfo.getMatcherCode() == i) {
                return processorInfo.getProcessorClass();
            }
        }
        return null;
    }
}
