package com.baidu.adp.framework.client.socket.coder;

import d.b.c.c.e.c.h;
/* loaded from: classes.dex */
public class CoderException extends Exception {
    public static final long serialVersionUID = -4477017113691535623L;
    public final int mErrorCode;

    public CoderException(int i) {
        super(h.i(i));
        this.mErrorCode = i;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }
}
