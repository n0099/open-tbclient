package com.baidu.ar.steploading;

import com.baidu.ar.callback.ICallback;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.callback.IError;
/* loaded from: classes3.dex */
class b<T> extends com.baidu.ar.d.a<T, T> {
    private ICallback vE;
    private IError vF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ICallback iCallback, IError iError) {
        this.vE = iCallback;
        this.vF = iError;
    }

    @Override // com.baidu.ar.d.a
    protected void a(int i, String str, IError iError) {
        if (this.vF != null) {
            this.vF.onError(i, str, null);
        }
    }

    @Override // com.baidu.ar.d.a
    protected void a(T t, ICallbackWith<T> iCallbackWith, IError iError) {
        if (this.vE != null) {
            this.vE.run();
        }
    }

    @Override // com.baidu.ar.d.a
    protected void dO() {
    }
}
