package com.baidu.ar.e;

import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.callback.IError;
/* loaded from: classes11.dex */
public abstract class a<InT, OutT> implements b<InT, OutT> {
    private boolean qr;
    private a<OutT, ?> sQ;
    private OutT sR;
    private boolean sS;
    private boolean sT;
    private boolean sU;
    private int sV;
    private String sW;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        this.sU = true;
        this.sV = i;
        this.sW = str;
    }

    private void fp() {
        if (this.qr || !this.sS || this.sQ == null) {
            return;
        }
        if (this.sU) {
            this.sQ.b(this.sV, this.sW);
        } else if (this.sT) {
        } else {
            this.sQ.h(this.sR);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.ar.e.a<OutT, T> */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> b<OutT, T> a(a<OutT, T> aVar) {
        this.sQ = aVar;
        fp();
        return aVar;
    }

    protected void a(int i, String str, IError iError) {
        if (iError != null) {
            iError.onError(i, str, null);
        }
    }

    protected abstract void a(InT r1, ICallbackWith<OutT> iCallbackWith, IError iError);

    protected final void b(int i, String str) {
        this.sS = true;
        this.sT = true;
        a(i, str, new IError() { // from class: com.baidu.ar.e.a.3
            @Override // com.baidu.ar.callback.IError
            public void onError(int i2, String str2, Exception exc) {
                a.this.a(i2, str2);
                if (a.this.qr || a.this.sQ == null) {
                    return;
                }
                a.this.sQ.b(i2, str2);
            }
        });
    }

    @Override // com.baidu.ar.callback.ICancellable
    public void cancel() {
        this.qr = true;
        fq();
    }

    protected abstract void fq();

    public final void h(InT r3) {
        if (this.qr) {
            return;
        }
        a((a<InT, OutT>) r3, new ICallbackWith<OutT>() { // from class: com.baidu.ar.e.a.1
            @Override // com.baidu.ar.callback.ICallbackWith
            public void run(OutT outt) {
                a.this.sS = true;
                a.this.sR = outt;
                if (a.this.qr || a.this.sQ == null) {
                    return;
                }
                a.this.sQ.h(outt);
            }
        }, new IError() { // from class: com.baidu.ar.e.a.2
            @Override // com.baidu.ar.callback.IError
            public void onError(int i, String str, Exception exc) {
                a.this.b(i, str);
            }
        });
    }
}
