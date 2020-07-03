package com.baidu.ar.d;

import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.callback.IError;
/* loaded from: classes3.dex */
public abstract class a<InT, OutT> implements b<InT, OutT> {
    private boolean pM;
    private a<OutT, ?> sl;
    private OutT sm;
    private boolean sn;
    private boolean so;
    private boolean sp;
    private int sq;
    private String sr;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        this.sp = true;
        this.sq = i;
        this.sr = str;
    }

    private void ed() {
        if (this.pM || !this.sn || this.sl == null) {
            return;
        }
        if (this.sp) {
            this.sl.b(this.sq, this.sr);
        } else if (this.so) {
        } else {
            this.sl.b((a<OutT, ?>) this.sm);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.ar.d.a<OutT, T> */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> b<OutT, T> a(a<OutT, T> aVar) {
        this.sl = aVar;
        ed();
        return aVar;
    }

    protected void a(int i, String str, IError iError) {
        if (iError != null) {
            iError.onError(i, str, null);
        }
    }

    protected abstract void a(InT r1, ICallbackWith<OutT> iCallbackWith, IError iError);

    protected final void b(int i, String str) {
        this.sn = true;
        this.so = true;
        a(i, str, new IError() { // from class: com.baidu.ar.d.a.3
            @Override // com.baidu.ar.callback.IError
            public void onError(int i2, String str2, Exception exc) {
                a.this.a(i2, str2);
                if (a.this.pM || a.this.sl == null) {
                    return;
                }
                a.this.sl.b(i2, str2);
            }
        });
    }

    public final void b(InT r3) {
        if (this.pM) {
            return;
        }
        a((a<InT, OutT>) r3, new ICallbackWith<OutT>() { // from class: com.baidu.ar.d.a.1
            @Override // com.baidu.ar.callback.ICallbackWith
            public void run(OutT outt) {
                a.this.sn = true;
                a.this.sm = outt;
                if (a.this.pM || a.this.sl == null) {
                    return;
                }
                a.this.sl.b((a) outt);
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
        this.pM = true;
        ee();
    }

    protected abstract void ee();
}
