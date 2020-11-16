package com.baidu.h.b.a.a;

import com.baidu.h.a.b.a.d;
import com.baidu.h.a.b.a.e;
import com.baidu.h.a.b.a.f;
import java.util.List;
/* loaded from: classes9.dex */
public class a implements com.baidu.h.a.b.a.b {
    private com.baidu.h.a.b.c bUc;
    private int bUd;
    private com.baidu.h.a.b.b bUe;
    private boolean bUf;
    private boolean bUg;
    private String mCastId;
    private String mUrl;

    public a(com.baidu.h.a.b.c cVar) {
        this.bUc = cVar;
    }

    public com.baidu.h.a.b.c XI() {
        return this.bUc;
    }

    @Override // com.baidu.h.a.b.a.b
    public void a(String str, String str2, int i, final com.baidu.h.a.b.b bVar, boolean z) {
        this.mCastId = str;
        this.mUrl = str2;
        this.bUd = i;
        this.bUe = bVar;
        this.bUg = z;
        this.bUc.setPullInterval(i);
        this.bUc.a(new com.baidu.h.a.b.b() { // from class: com.baidu.h.b.a.a.a.1
            @Override // com.baidu.h.a.b.b
            public void onResult(int i2, long j, long j2) {
                if (bVar != null) {
                    bVar.onResult(i2, j, j2);
                }
                a.this.bUf = true;
            }
        });
    }

    public void Ct() {
        this.bUc.a(new com.baidu.h.a.b.b() { // from class: com.baidu.h.b.a.a.a.2
            @Override // com.baidu.h.a.b.b
            public void onResult(int i, long j, long j2) {
                if (a.this.bUe != null) {
                    a.this.bUe.onResult(i, j, j2);
                }
                a.this.bUf = true;
            }
        });
    }

    @Override // com.baidu.h.a.b.a.b
    public void iZ(String str) {
        if (this.bUc != null) {
            this.bUc.iY(str);
            this.bUc.b(new com.baidu.h.a.b.b() { // from class: com.baidu.h.b.a.a.a.3
                @Override // com.baidu.h.a.b.b
                public void onResult(int i, long j, long j2) {
                    a.this.bUf = false;
                }
            });
            this.bUc.quitLiveShow();
        }
    }

    @Override // com.baidu.h.a.b.a.b
    public void KR() {
        iZ(this.mCastId);
    }

    @Override // com.baidu.h.a.b.a.b
    public void a(final String str, e eVar, final f fVar) {
        if (this.bUc != null && eVar != null) {
            this.bUc.a(eVar, null, new com.baidu.h.a.b.f() { // from class: com.baidu.h.b.a.a.a.4
                @Override // com.baidu.h.a.b.f
                public void c(int i, Object obj) {
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
        this.bUc.a(str, new com.baidu.h.a.b.e() { // from class: com.baidu.h.b.a.a.a.5
            @Override // com.baidu.h.a.b.e
            public void b(int i, Object obj) {
                if (dVar != null) {
                    try {
                        dVar.e(i, (List) obj);
                    } catch (Exception e) {
                    }
                }
            }
        });
    }

    public boolean XJ() {
        return this.bUf;
    }
}
