package com.baidu.ar.e;

import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.callback.IError;
/* loaded from: classes6.dex */
public abstract class a<InT, OutT> implements b<InT, OutT> {
    private boolean qH;
    private a<OutT, ?> tD;
    private OutT tE;
    private boolean tF;
    private boolean tG;
    private boolean tH;
    private int tI;
    private String tJ;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        this.tH = true;
        this.tI = i;
        this.tJ = str;
    }

    private void fo() {
        if (this.qH || !this.tF || this.tD == null) {
            return;
        }
        if (this.tH) {
            this.tD.b(this.tI, this.tJ);
        } else if (this.tG) {
        } else {
            this.tD.h(this.tE);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.ar.e.a<OutT, T> */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> b<OutT, T> a(a<OutT, T> aVar) {
        this.tD = aVar;
        fo();
        return aVar;
    }

    protected void a(int i, String str, IError iError) {
        if (iError != null) {
            iError.onError(i, str, null);
        }
    }

    protected abstract void a(InT r1, ICallbackWith<OutT> iCallbackWith, IError iError);

    protected final void b(int i, String str) {
        this.tF = true;
        this.tG = true;
        a(i, str, new IError() { // from class: com.baidu.ar.e.a.3
            @Override // com.baidu.ar.callback.IError
            public void onError(int i2, String str2, Exception exc) {
                a.this.a(i2, str2);
                if (a.this.qH || a.this.tD == null) {
                    return;
                }
                a.this.tD.b(i2, str2);
            }
        });
    }

    @Override // com.baidu.ar.callback.ICancellable
    public void cancel() {
        this.qH = true;
        fp();
    }

    protected abstract void fp();

    public final void h(InT r3) {
        if (this.qH) {
            return;
        }
        a((a<InT, OutT>) r3, new ICallbackWith<OutT>() { // from class: com.baidu.ar.e.a.1
            @Override // com.baidu.ar.callback.ICallbackWith
            public void run(OutT outt) {
                a.this.tF = true;
                a.this.tE = outt;
                if (a.this.qH || a.this.tD == null) {
                    return;
                }
                a.this.tD.h(outt);
            }
        }, new IError() { // from class: com.baidu.ar.e.a.2
            @Override // com.baidu.ar.callback.IError
            public void onError(int i, String str, Exception exc) {
                a.this.b(i, str);
            }
        });
    }
}
