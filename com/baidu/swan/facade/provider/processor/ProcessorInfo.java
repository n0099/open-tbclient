package com.baidu.swan.facade.provider.processor;

import com.baidu.tieba.ns3;
import com.baidu.tieba.os3;
import com.baidu.tieba.ps3;
import com.baidu.tieba.qs3;
/* loaded from: classes4.dex */
public enum ProcessorInfo {
    PARAMS(qs3.class, "params"),
    FAVORITE(os3.class, "favorite"),
    HISTORY(ps3.class, "history");
    
    public Class<? extends ns3> mClass;
    public int mMatcherCode = ordinal();
    public String mPath;

    ProcessorInfo(Class cls, String str) {
        this.mClass = cls;
        this.mPath = str;
    }

    private Class<? extends ns3> getProcessorClass() {
        return this.mClass;
    }

    public int getMatcherCode() {
        return this.mMatcherCode;
    }

    public String getPath() {
        return this.mPath;
    }

    public static Class<? extends ns3> getProcessorClass(int i) {
        ProcessorInfo[] values;
        for (ProcessorInfo processorInfo : values()) {
            if (processorInfo != null && processorInfo.getMatcherCode() == i) {
                return processorInfo.getProcessorClass();
            }
        }
        return null;
    }
}
