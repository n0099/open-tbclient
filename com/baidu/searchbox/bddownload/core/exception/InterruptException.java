package com.baidu.searchbox.bddownload.core.exception;

import java.io.IOException;
/* loaded from: classes3.dex */
public class InterruptException extends IOException {
    public static final InterruptException SIGNAL = new InterruptException() { // from class: com.baidu.searchbox.bddownload.core.exception.InterruptException.1
        @Override // java.lang.Throwable
        public void printStackTrace() {
            throw new IllegalAccessError("Stack is ignored for signal");
        }
    };

    public InterruptException() {
        super("Interrupted");
    }
}
