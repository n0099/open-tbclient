package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.framework.client.socket.j;
/* loaded from: classes.dex */
public class CoderException extends Exception {
    private static final long serialVersionUID = -4477017113691535623L;
    private final int mErrorCode;

    public CoderException(int i) {
        super(j.O(i));
        this.mErrorCode = i;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }
}
