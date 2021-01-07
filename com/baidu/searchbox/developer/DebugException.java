package com.baidu.searchbox.developer;
/* loaded from: classes4.dex */
public class DebugException extends RuntimeException {
    public static final String PREFIX = "ONLY DEBUG MODE CAN SEE THIS EXCEPTION: ";

    public DebugException() {
    }

    public DebugException(String str) {
        super(PREFIX + str);
    }

    public DebugException(String str, Throwable th) {
        super(PREFIX + str, th);
    }
}
