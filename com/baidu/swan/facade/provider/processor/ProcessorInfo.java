package com.baidu.swan.facade.provider.processor;

import com.baidu.tieba.vr3;
import com.baidu.tieba.wr3;
import com.baidu.tieba.xr3;
import com.baidu.tieba.yr3;
/* loaded from: classes4.dex */
public enum ProcessorInfo {
    PARAMS(yr3.class, "params"),
    FAVORITE(wr3.class, "favorite"),
    HISTORY(xr3.class, "history");
    
    public Class<? extends vr3> mClass;
    public int mMatcherCode = ordinal();
    public String mPath;

    ProcessorInfo(Class cls, String str) {
        this.mClass = cls;
        this.mPath = str;
    }

    private Class<? extends vr3> getProcessorClass() {
        return this.mClass;
    }

    public int getMatcherCode() {
        return this.mMatcherCode;
    }

    public String getPath() {
        return this.mPath;
    }

    public static Class<? extends vr3> getProcessorClass(int i) {
        ProcessorInfo[] values;
        for (ProcessorInfo processorInfo : values()) {
            if (processorInfo != null && processorInfo.getMatcherCode() == i) {
                return processorInfo.getProcessorClass();
            }
        }
        return null;
    }
}
