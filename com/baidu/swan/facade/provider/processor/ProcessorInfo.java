package com.baidu.swan.facade.provider.processor;

import com.baidu.tieba.iy3;
import com.baidu.tieba.jy3;
import com.baidu.tieba.ky3;
import com.baidu.tieba.ly3;
/* loaded from: classes4.dex */
public enum ProcessorInfo {
    PARAMS(ly3.class, "params"),
    FAVORITE(jy3.class, "favorite"),
    HISTORY(ky3.class, "history");
    
    public Class<? extends iy3> mClass;
    public int mMatcherCode = ordinal();
    public String mPath;

    ProcessorInfo(Class cls, String str) {
        this.mClass = cls;
        this.mPath = str;
    }

    private Class<? extends iy3> getProcessorClass() {
        return this.mClass;
    }

    public int getMatcherCode() {
        return this.mMatcherCode;
    }

    public String getPath() {
        return this.mPath;
    }

    public static Class<? extends iy3> getProcessorClass(int i) {
        ProcessorInfo[] values;
        for (ProcessorInfo processorInfo : values()) {
            if (processorInfo != null && processorInfo.getMatcherCode() == i) {
                return processorInfo.getProcessorClass();
            }
        }
        return null;
    }
}
