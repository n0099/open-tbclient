package com.baidu.sapi2.httpwrap;

import android.os.Looper;
/* loaded from: classes.dex */
public class BinaryHttpHandlerWrap extends HttpHandlerWrap {
    public String[] allowedContentTypes;

    public BinaryHttpHandlerWrap(Looper looper) {
        super(looper);
    }

    public BinaryHttpHandlerWrap(Looper looper, String[] strArr) {
        this.allowedContentTypes = strArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSuccess(int i, byte[] bArr) {
    }
}
