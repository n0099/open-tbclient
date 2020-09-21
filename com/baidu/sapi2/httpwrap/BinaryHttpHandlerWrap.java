package com.baidu.sapi2.httpwrap;

import android.os.Looper;
/* loaded from: classes25.dex */
public class BinaryHttpHandlerWrap extends HttpHandlerWrap {
    public String[] allowedContentTypes;

    public BinaryHttpHandlerWrap(Looper looper) {
        super(looper);
    }

    protected void onSuccess(int i, byte[] bArr) {
    }

    public BinaryHttpHandlerWrap(Looper looper, String[] strArr) {
        this.allowedContentTypes = strArr;
    }

    public BinaryHttpHandlerWrap(boolean z, String[] strArr) {
        this.executCallbackInChildThread = z;
        this.allowedContentTypes = strArr;
    }
}
