package com.baidu.adp.framework.client.socket.coder;

import d.a.c.c.e.c.h;
/* loaded from: classes.dex */
public class CoderException extends Exception {
    public static final long serialVersionUID = -4477017113691535623L;
    public final int mErrorCode;

    public CoderException(int i2) {
        super(h.i(i2));
        this.mErrorCode = i2;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }
}
