package com.baidu.searchbox.v8engine;
/* loaded from: classes4.dex */
public class V8ExceptionInfo {
    public static final String V8_EXCEPTION_ERROR = "Error";
    public static final String V8_EXCEPTION_RANGE_ERROR = "RangeError";
    public static final String V8_EXCEPTION_REFERENCE_ERROR = "ReferenceError";
    public static final String V8_EXCEPTION_SYNTAX_ERROR = "SyntaxError";
    public static final String V8_EXCEPTION_TYPE_ERROR = "TypeError";
    public String exceptionMsg;
    public long exceptionTime;
    public String exceptionTrace;
    public String exceptionType;
    public String filePath;

    public V8ExceptionInfo() {
    }

    public void reset() {
        reset(0L, "", "", "", "");
    }

    public V8ExceptionInfo(long j, String str, String str2, String str3, String str4) {
        this.exceptionTime = j;
        this.exceptionMsg = str;
        this.exceptionTrace = str2;
        this.exceptionType = str3;
        this.filePath = str4;
    }

    public void reset(long j, String str, String str2, String str3, String str4) {
        this.exceptionTime = j;
        this.exceptionMsg = str;
        this.exceptionTrace = str2;
        this.exceptionType = str3;
        this.filePath = str4;
    }

    public String toString() {
        return "V8ExceptionInfo{exceptionTime=" + this.exceptionTime + ", exceptionMsg='" + this.exceptionMsg + "', exceptionTrace='" + this.exceptionTrace + "', exceptionType='" + this.exceptionType + "', filePath='" + this.filePath + "'}";
    }
}
