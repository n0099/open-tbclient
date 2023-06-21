package com.baidu.swan.facade.provider.processor;

import com.baidu.tieba.fy3;
import com.baidu.tieba.gy3;
import com.baidu.tieba.hy3;
import com.baidu.tieba.iy3;
/* loaded from: classes4.dex */
public enum ProcessorInfo {
    PARAMS(iy3.class, "params"),
    FAVORITE(gy3.class, "favorite"),
    HISTORY(hy3.class, "history");
    
    public Class<? extends fy3> mClass;
    public int mMatcherCode = ordinal();
    public String mPath;

    ProcessorInfo(Class cls, String str) {
        this.mClass = cls;
        this.mPath = str;
    }

    private Class<? extends fy3> getProcessorClass() {
        return this.mClass;
    }

    public int getMatcherCode() {
        return this.mMatcherCode;
    }

    public String getPath() {
        return this.mPath;
    }

    public static Class<? extends fy3> getProcessorClass(int i) {
        ProcessorInfo[] values;
        for (ProcessorInfo processorInfo : values()) {
            if (processorInfo != null && processorInfo.getMatcherCode() == i) {
                return processorInfo.getProcessorClass();
            }
        }
        return null;
    }
}
