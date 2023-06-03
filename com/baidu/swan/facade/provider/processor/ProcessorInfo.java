package com.baidu.swan.facade.provider.processor;

import com.baidu.tieba.ey3;
import com.baidu.tieba.fy3;
import com.baidu.tieba.gy3;
import com.baidu.tieba.hy3;
/* loaded from: classes4.dex */
public enum ProcessorInfo {
    PARAMS(hy3.class, "params"),
    FAVORITE(fy3.class, "favorite"),
    HISTORY(gy3.class, "history");
    
    public Class<? extends ey3> mClass;
    public int mMatcherCode = ordinal();
    public String mPath;

    ProcessorInfo(Class cls, String str) {
        this.mClass = cls;
        this.mPath = str;
    }

    private Class<? extends ey3> getProcessorClass() {
        return this.mClass;
    }

    public int getMatcherCode() {
        return this.mMatcherCode;
    }

    public String getPath() {
        return this.mPath;
    }

    public static Class<? extends ey3> getProcessorClass(int i) {
        ProcessorInfo[] values;
        for (ProcessorInfo processorInfo : values()) {
            if (processorInfo != null && processorInfo.getMatcherCode() == i) {
                return processorInfo.getProcessorClass();
            }
        }
        return null;
    }
}
