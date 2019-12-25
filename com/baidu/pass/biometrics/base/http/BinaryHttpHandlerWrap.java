package com.baidu.pass.biometrics.base.http;

import android.os.Looper;
/* loaded from: classes4.dex */
public class BinaryHttpHandlerWrap extends HttpHandlerWrap {
    public String[] allowedContentTypes;

    public BinaryHttpHandlerWrap(Looper looper) {
        super(looper);
    }

    public BinaryHttpHandlerWrap(Looper looper, String[] strArr) {
        this.allowedContentTypes = strArr;
    }

    public BinaryHttpHandlerWrap(boolean z, String[] strArr) {
        this.executCallbackInChildThread = z;
        this.allowedContentTypes = strArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSuccess(int i, byte[] bArr) {
    }
}
