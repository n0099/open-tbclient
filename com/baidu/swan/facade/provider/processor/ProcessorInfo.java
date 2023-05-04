package com.baidu.swan.facade.provider.processor;

import com.baidu.tieba.du3;
import com.baidu.tieba.eu3;
import com.baidu.tieba.fu3;
import com.baidu.tieba.gu3;
/* loaded from: classes3.dex */
public enum ProcessorInfo {
    PARAMS(gu3.class, "params"),
    FAVORITE(eu3.class, "favorite"),
    HISTORY(fu3.class, "history");
    
    public Class<? extends du3> mClass;
    public int mMatcherCode = ordinal();
    public String mPath;

    ProcessorInfo(Class cls, String str) {
        this.mClass = cls;
        this.mPath = str;
    }

    private Class<? extends du3> getProcessorClass() {
        return this.mClass;
    }

    public int getMatcherCode() {
        return this.mMatcherCode;
    }

    public String getPath() {
        return this.mPath;
    }

    public static Class<? extends du3> getProcessorClass(int i) {
        ProcessorInfo[] values;
        for (ProcessorInfo processorInfo : values()) {
            if (processorInfo != null && processorInfo.getMatcherCode() == i) {
                return processorInfo.getProcessorClass();
            }
        }
        return null;
    }
}
