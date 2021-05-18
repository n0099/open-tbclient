package com.baidu.swan.facade.provider.processor;

import d.a.i0.e.n.a.a;
import d.a.i0.e.n.a.b;
import d.a.i0.e.n.a.c;
import d.a.i0.e.n.a.d;
/* loaded from: classes3.dex */
public enum ProcessorInfo {
    PARAMS(d.class, "params"),
    FAVORITE(b.class, "favorite"),
    HISTORY(c.class, "history");
    
    public Class<? extends a> mClass;
    public int mMatcherCode = ordinal();
    public String mPath;

    ProcessorInfo(Class cls, String str) {
        this.mClass = cls;
        this.mPath = str;
    }

    public static Class<? extends a> getProcessorClass(int i2) {
        ProcessorInfo[] values;
        for (ProcessorInfo processorInfo : values()) {
            if (processorInfo != null && processorInfo.getMatcherCode() == i2) {
                return processorInfo.getProcessorClass();
            }
        }
        return null;
    }

    public int getMatcherCode() {
        return this.mMatcherCode;
    }

    public String getPath() {
        return this.mPath;
    }

    private Class<? extends a> getProcessorClass() {
        return this.mClass;
    }
}
