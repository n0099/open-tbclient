package com.baidu.ar.steploading;

import com.baidu.ar.callback.ICallback;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.callback.IError;
/* loaded from: classes3.dex */
public class b<T> extends com.baidu.ar.e.a<T, T> {
    public ICallback xv;
    public IError xw;

    public b(ICallback iCallback, IError iError) {
        this.xv = iCallback;
        this.xw = iError;
    }

    @Override // com.baidu.ar.e.a
    public void a(int i, String str, IError iError) {
        IError iError2 = this.xw;
        if (iError2 != null) {
            iError2.onError(i, str, null);
        }
    }

    @Override // com.baidu.ar.e.a
    public void a(T t, ICallbackWith<T> iCallbackWith, IError iError) {
        ICallback iCallback = this.xv;
        if (iCallback != null) {
            iCallback.run();
        }
    }

    @Override // com.baidu.ar.e.a
    public void fp() {
    }
}
