package com.baidu.swan.facade.provider.processor;

import d.b.h0.d.i.a.a;
import d.b.h0.d.i.a.b;
import d.b.h0.d.i.a.c;
import d.b.h0.d.i.a.d;
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

    public static Class<? extends a> getProcessorClass(int i) {
        ProcessorInfo[] values;
        for (ProcessorInfo processorInfo : values()) {
            if (processorInfo != null && processorInfo.getMatcherCode() == i) {
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
