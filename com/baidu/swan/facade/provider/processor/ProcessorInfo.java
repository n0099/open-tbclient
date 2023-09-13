package com.baidu.swan.facade.provider.processor;

import com.baidu.tieba.nx3;
import com.baidu.tieba.ox3;
import com.baidu.tieba.px3;
import com.baidu.tieba.qx3;
/* loaded from: classes4.dex */
public enum ProcessorInfo {
    PARAMS(qx3.class, "params"),
    FAVORITE(ox3.class, "favorite"),
    HISTORY(px3.class, "history");
    
    public Class<? extends nx3> mClass;
    public int mMatcherCode = ordinal();
    public String mPath;

    ProcessorInfo(Class cls, String str) {
        this.mClass = cls;
        this.mPath = str;
    }

    private Class<? extends nx3> getProcessorClass() {
        return this.mClass;
    }

    public int getMatcherCode() {
        return this.mMatcherCode;
    }

    public String getPath() {
        return this.mPath;
    }

    public static Class<? extends nx3> getProcessorClass(int i) {
        ProcessorInfo[] values;
        for (ProcessorInfo processorInfo : values()) {
            if (processorInfo != null && processorInfo.getMatcherCode() == i) {
                return processorInfo.getProcessorClass();
            }
        }
        return null;
    }
}
