package com.baidu.live.adp.framework.client.socket.coder;

import com.baidu.live.adp.framework.client.socket.SocketConfig;
/* loaded from: classes10.dex */
public class CoderException extends Exception {
    private static final long serialVersionUID = -4477017113691535623L;
    private final int mErrorCode;

    public CoderException(int i) {
        super(SocketConfig.toErrorMsg(i));
        this.mErrorCode = i;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }
}
