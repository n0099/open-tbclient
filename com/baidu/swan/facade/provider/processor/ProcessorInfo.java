package com.baidu.swan.facade.provider.processor;

import com.baidu.tieba.sv3;
import com.baidu.tieba.tv3;
import com.baidu.tieba.uv3;
import com.baidu.tieba.vv3;
/* loaded from: classes3.dex */
public enum ProcessorInfo {
    PARAMS(vv3.class, "params"),
    FAVORITE(tv3.class, "favorite"),
    HISTORY(uv3.class, "history");
    
    public Class<? extends sv3> mClass;
    public int mMatcherCode = ordinal();
    public String mPath;

    ProcessorInfo(Class cls, String str) {
        this.mClass = cls;
        this.mPath = str;
    }

    private Class<? extends sv3> getProcessorClass() {
        return this.mClass;
    }

    public int getMatcherCode() {
        return this.mMatcherCode;
    }

    public String getPath() {
        return this.mPath;
    }

    public static Class<? extends sv3> getProcessorClass(int i) {
        ProcessorInfo[] values;
        for (ProcessorInfo processorInfo : values()) {
            if (processorInfo != null && processorInfo.getMatcherCode() == i) {
                return processorInfo.getProcessorClass();
            }
        }
        return null;
    }
}
