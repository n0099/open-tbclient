package com.baidu.swan.facade.provider.processor;

import com.baidu.tieba.mv3;
import com.baidu.tieba.nv3;
import com.baidu.tieba.ov3;
import com.baidu.tieba.pv3;
/* loaded from: classes4.dex */
public enum ProcessorInfo {
    PARAMS(pv3.class, "params"),
    FAVORITE(nv3.class, "favorite"),
    HISTORY(ov3.class, "history");
    
    public Class<? extends mv3> mClass;
    public int mMatcherCode = ordinal();
    public String mPath;

    ProcessorInfo(Class cls, String str) {
        this.mClass = cls;
        this.mPath = str;
    }

    private Class<? extends mv3> getProcessorClass() {
        return this.mClass;
    }

    public int getMatcherCode() {
        return this.mMatcherCode;
    }

    public String getPath() {
        return this.mPath;
    }

    public static Class<? extends mv3> getProcessorClass(int i) {
        ProcessorInfo[] values;
        for (ProcessorInfo processorInfo : values()) {
            if (processorInfo != null && processorInfo.getMatcherCode() == i) {
                return processorInfo.getProcessorClass();
            }
        }
        return null;
    }
}
