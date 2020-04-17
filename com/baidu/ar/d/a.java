package com.baidu.ar.d;

import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.callback.IError;
/* loaded from: classes3.dex */
public abstract class a<InT, OutT> implements b<InT, OutT> {
    private boolean pn;
    private a<OutT, ?> rM;
    private OutT rN;
    private boolean rO;
    private boolean rP;
    private boolean rQ;
    private int rR;
    private String rS;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        this.rQ = true;
        this.rR = i;
        this.rS = str;
    }

    private void dN() {
        if (this.pn || !this.rO || this.rM == null) {
            return;
        }
        if (this.rQ) {
            this.rM.b(this.rR, this.rS);
        } else if (this.rP) {
        } else {
            this.rM.b((a<OutT, ?>) this.rN);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.ar.d.a<OutT, T> */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> b<OutT, T> a(a<OutT, T> aVar) {
        this.rM = aVar;
        dN();
        return aVar;
    }

    protected void a(int i, String str, IError iError) {
        if (iError != null) {
            iError.onError(i, str, null);
        }
    }

    protected abstract void a(InT r1, ICallbackWith<OutT> iCallbackWith, IError iError);

    protected final void b(int i, String str) {
        this.rO = true;
        this.rP = true;
        a(i, str, new IError() { // from class: com.baidu.ar.d.a.3
            @Override // com.baidu.ar.callback.IError
            public void onError(int i2, String str2, Exception exc) {
                a.this.a(i2, str2);
                if (a.this.pn || a.this.rM == null) {
                    return;
                }
                a.this.rM.b(i2, str2);
            }
        });
    }

    public final void b(InT r3) {
        if (this.pn) {
            return;
        }
        a((a<InT, OutT>) r3, new ICallbackWith<OutT>() { // from class: com.baidu.ar.d.a.1
            @Override // com.baidu.ar.callback.ICallbackWith
            public void run(OutT outt) {
                a.this.rO = true;
                a.this.rN = outt;
                if (a.this.pn || a.this.rM == null) {
                    return;
                }
                a.this.rM.b((a) outt);
            }
        }, new IError() { // from class: com.baidu.ar.d.a.2
            @Override // com.baidu.ar.callback.IError
            public void onError(int i, String str, Exception exc) {
                a.this.b(i, str);
            }
        });
    }

    @Override // com.baidu.ar.callback.ICancellable
    public void cancel() {
        this.pn = true;
        dO();
    }

    protected abstract void dO();
}
