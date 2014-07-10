package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.framework.client.socket.l;
/* loaded from: classes.dex */
public class CoderException extends Exception {
    private static final long serialVersionUID = -4477017113691535623L;
    private final int mErrorCode;

    public CoderException(int i) {
        super(l.a(i));
        this.mErrorCode = i;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }
}
