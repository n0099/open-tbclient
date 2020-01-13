package com.baidu.swan.facade.provider.processor;
/* loaded from: classes10.dex */
public enum ProcessorInfo {
    PARAMS(d.class, "params"),
    FAVORITE(b.class, "favorite"),
    HISTORY(c.class, "history");
    
    private Class<? extends a> mClass;
    private int mMatcherCode = ordinal();
    private String mPath;

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

    private Class<? extends a> getProcessorClass() {
        return this.mClass;
    }

    public String getPath() {
        return this.mPath;
    }

    public int getMatcherCode() {
        return this.mMatcherCode;
    }
}
