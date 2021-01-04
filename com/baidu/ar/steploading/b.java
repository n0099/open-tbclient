package com.baidu.ar.steploading;

import com.baidu.ar.callback.ICallback;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.callback.IError;
/* loaded from: classes6.dex */
class b<T> extends com.baidu.ar.e.a<T, T> {
    private ICallback xv;
    private IError xw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ICallback iCallback, IError iError) {
        this.xv = iCallback;
        this.xw = iError;
    }

    @Override // com.baidu.ar.e.a
    protected void a(int i, String str, IError iError) {
        if (this.xw != null) {
            this.xw.onError(i, str, null);
        }
    }

    @Override // com.baidu.ar.e.a
    protected void a(T t, ICallbackWith<T> iCallbackWith, IError iError) {
        if (this.xv != null) {
            this.xv.run();
        }
    }

    @Override // com.baidu.ar.e.a
    protected void fp() {
    }
}
