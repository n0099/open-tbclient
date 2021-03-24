package com.baidu.searchbox.logsystem.logsys;
/* loaded from: classes3.dex */
public enum LogType {
    JAVA_CRASH("$JAVA_CRASH$"),
    NATIVE_CRASH("$NATIVE_CRASH$"),
    NONE("$NONE$");
    
    public String mTypeName;

    LogType(String str) {
        this.mTypeName = str;
    }

    public static LogType getLogType(String str) {
        if (JAVA_CRASH.getTypeName().equals(str)) {
            return JAVA_CRASH;
        }
        if (NATIVE_CRASH.getTypeName().equals(str)) {
            return NATIVE_CRASH;
        }
        if (NONE.getTypeName().equals(str)) {
            return NONE;
        }
        return null;
    }

    public static void init() {
    }

    public String getTypeName() {
        return this.mTypeName;
    }
}
