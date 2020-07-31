package com.baidu.ar.steploading;

import com.baidu.ar.callback.ICallback;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.callback.IError;
/* loaded from: classes11.dex */
class b<T> extends com.baidu.ar.d.a<T, T> {
    private ICallback we;
    private IError wf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ICallback iCallback, IError iError) {
        this.we = iCallback;
        this.wf = iError;
    }

    @Override // com.baidu.ar.d.a
    protected void a(int i, String str, IError iError) {
        if (this.wf != null) {
            this.wf.onError(i, str, null);
        }
    }

    @Override // com.baidu.ar.d.a
    protected void a(T t, ICallbackWith<T> iCallbackWith, IError iError) {
        if (this.we != null) {
            this.we.run();
        }
    }

    @Override // com.baidu.ar.d.a
    protected void ee() {
    }
}
