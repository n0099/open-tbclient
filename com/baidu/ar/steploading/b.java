package com.baidu.ar.steploading;

import com.baidu.ar.callback.ICallback;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.callback.IError;
/* loaded from: classes14.dex */
class b<T> extends com.baidu.ar.e.a<T, T> {
    private ICallback wH;
    private IError wI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ICallback iCallback, IError iError) {
        this.wH = iCallback;
        this.wI = iError;
    }

    @Override // com.baidu.ar.e.a
    protected void a(int i, String str, IError iError) {
        if (this.wI != null) {
            this.wI.onError(i, str, null);
        }
    }

    @Override // com.baidu.ar.e.a
    protected void a(T t, ICallbackWith<T> iCallbackWith, IError iError) {
        if (this.wH != null) {
            this.wH.run();
        }
    }

    @Override // com.baidu.ar.e.a
    protected void fq() {
    }
}
