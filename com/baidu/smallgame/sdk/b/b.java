package com.baidu.smallgame.sdk.b;

import com.baidu.searchbox.v8engine.V8ExceptionInfo;
/* loaded from: classes11.dex */
public class b {
    long aYY;
    V8ExceptionInfo mV8ExceptionInfo;
    int type;

    public b(int i, V8ExceptionInfo v8ExceptionInfo, long j) {
        this.aYY = j;
        this.mV8ExceptionInfo = new V8ExceptionInfo(v8ExceptionInfo.exceptionTime, v8ExceptionInfo.exceptionMsg, v8ExceptionInfo.exceptionTrace, v8ExceptionInfo.exceptionType, v8ExceptionInfo.filePath);
        this.type = i;
    }

    public V8ExceptionInfo Ge() {
        return this.mV8ExceptionInfo;
    }

    public String toString() {
        return "StuckScreenExceptionInfo{mLastOnScreenHappenedTime=" + this.aYY + ", mV8ExceptionInfo=" + this.mV8ExceptionInfo + ", type=" + this.type + '}';
    }
}
