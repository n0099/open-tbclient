package com.baidu.adp.lib.network;

import java.io.IOException;
/* loaded from: classes.dex */
public class BdHttpErrorException extends IOException {
    public BdHttpErrorException() {
    }

    public BdHttpErrorException(String str) {
        super(str);
    }

    public BdHttpErrorException(String str, Throwable th) {
        super(str);
        initCause(th);
    }
}
