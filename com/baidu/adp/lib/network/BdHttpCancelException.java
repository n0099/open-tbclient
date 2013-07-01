package com.baidu.adp.lib.network;

import java.io.IOException;
/* loaded from: classes.dex */
public class BdHttpCancelException extends IOException {
    public BdHttpCancelException() {
    }

    public BdHttpCancelException(String str) {
        super(str);
    }

    public BdHttpCancelException(String str, Throwable th) {
        super(str);
        initCause(th);
    }
}
