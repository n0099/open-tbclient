package com.baidu.h.b.a.a;

import com.baidu.h.a.b.a.d;
import com.baidu.h.a.b.a.e;
import com.baidu.h.a.b.a.f;
import java.util.List;
/* loaded from: classes15.dex */
public class a implements com.baidu.h.a.b.a.b {
    private com.baidu.h.a.b.c bQc;
    private int bQd;
    private com.baidu.h.a.b.b bQe;
    private boolean bQf;
    private boolean bQg;
    private String mCastId;
    private String mUrl;

    public a(com.baidu.h.a.b.c cVar) {
        this.bQc = cVar;
    }

    public com.baidu.h.a.b.c VS() {
        return this.bQc;
    }

    @Override // com.baidu.h.a.b.a.b
    public void a(String str, String str2, int i, final com.baidu.h.a.b.b bVar, boolean z) {
        this.mCastId = str;
        this.mUrl = str2;
        this.bQd = i;
        this.bQe = bVar;
        this.bQg = z;
        this.bQc.setPullInterval(i);
        this.bQc.a(new com.baidu.h.a.b.b() { // from class: com.baidu.h.b.a.a.a.1
            @Override // com.baidu.h.a.b.b
            public void onResult(int i2, long j, long j2) {
                if (bVar != null) {
                    bVar.onResult(i2, j, j2);
                }
                a.this.bQf = true;
            }
        });
    }

    public void CJ() {
        this.bQc.a(new com.baidu.h.a.b.b() { // from class: com.baidu.h.b.a.a.a.2
            @Override // com.baidu.h.a.b.b
            public void onResult(int i, long j, long j2) {
                if (a.this.bQe != null) {
                    a.this.bQe.onResult(i, j, j2);
                }
                a.this.bQf = true;
            }
        });
    }

    @Override // com.baidu.h.a.b.a.b
    public void iS(String str) {
        if (this.bQc != null) {
            this.bQc.iR(str);
            this.bQc.b(new com.baidu.h.a.b.b() { // from class: com.baidu.h.b.a.a.a.3
                @Override // com.baidu.h.a.b.b
                public void onResult(int i, long j, long j2) {
                    a.this.bQf = false;
                }
            });
            this.bQc.quitLiveShow();
        }
    }

    @Override // com.baidu.h.a.b.a.b
    public void La() {
        iS(this.mCastId);
    }

    @Override // com.baidu.h.a.b.a.b
    public void a(final String str, e eVar, final f fVar) {
        if (this.bQc != null && eVar != null) {
            this.bQc.a(eVar, null, new com.baidu.h.a.b.f() { // from class: com.baidu.h.b.a.a.a.4
                @Override // com.baidu.h.a.b.f
                public void d(int i, Object obj) {
                    if (fVar != null) {
                        try {
                            fVar.a(str, i, obj != null ? (List) obj : null);
                        } catch (Exception e) {
                        }
                    }
                }
            });
        } else if (fVar != null) {
            fVar.a(str, -1, null);
        }
    }

    @Override // com.baidu.h.a.b.a.b
    public void a(String str, final d dVar) {
        this.bQc.a(str, new com.baidu.h.a.b.e() { // from class: com.baidu.h.b.a.a.a.5
            @Override // com.baidu.h.a.b.e
            public void c(int i, Object obj) {
                if (dVar != null) {
                    try {
                        dVar.e(i, (List) obj);
                    } catch (Exception e) {
                    }
                }
            }
        });
    }

    public boolean VT() {
        return this.bQf;
    }
}
