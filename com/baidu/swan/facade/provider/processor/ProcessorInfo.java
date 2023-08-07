package com.baidu.swan.facade.provider.processor;

import com.baidu.tieba.ex3;
import com.baidu.tieba.fx3;
import com.baidu.tieba.gx3;
import com.baidu.tieba.hx3;
/* loaded from: classes4.dex */
public enum ProcessorInfo {
    PARAMS(hx3.class, "params"),
    FAVORITE(fx3.class, "favorite"),
    HISTORY(gx3.class, "history");
    
    public Class<? extends ex3> mClass;
    public int mMatcherCode = ordinal();
    public String mPath;

    ProcessorInfo(Class cls, String str) {
        this.mClass = cls;
        this.mPath = str;
    }

    private Class<? extends ex3> getProcessorClass() {
        return this.mClass;
    }

    public int getMatcherCode() {
        return this.mMatcherCode;
    }

    public String getPath() {
        return this.mPath;
    }

    public static Class<? extends ex3> getProcessorClass(int i) {
        ProcessorInfo[] values;
        for (ProcessorInfo processorInfo : values()) {
            if (processorInfo != null && processorInfo.getMatcherCode() == i) {
                return processorInfo.getProcessorClass();
            }
        }
        return null;
    }
}
