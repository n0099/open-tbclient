package com.baidu.swan.facade.provider.processor;

import com.baidu.tieba.ms3;
import com.baidu.tieba.ns3;
import com.baidu.tieba.os3;
import com.baidu.tieba.ps3;
/* loaded from: classes4.dex */
public enum ProcessorInfo {
    PARAMS(ps3.class, "params"),
    FAVORITE(ns3.class, "favorite"),
    HISTORY(os3.class, "history");
    
    public Class<? extends ms3> mClass;
    public int mMatcherCode = ordinal();
    public String mPath;

    ProcessorInfo(Class cls, String str) {
        this.mClass = cls;
        this.mPath = str;
    }

    private Class<? extends ms3> getProcessorClass() {
        return this.mClass;
    }

    public int getMatcherCode() {
        return this.mMatcherCode;
    }

    public String getPath() {
        return this.mPath;
    }

    public static Class<? extends ms3> getProcessorClass(int i) {
        ProcessorInfo[] values;
        for (ProcessorInfo processorInfo : values()) {
            if (processorInfo != null && processorInfo.getMatcherCode() == i) {
                return processorInfo.getProcessorClass();
            }
        }
        return null;
    }
}
