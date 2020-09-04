package com.baidu.h.b.a.a;

import com.baidu.h.a.b.a.d;
import com.baidu.h.a.b.a.e;
import com.baidu.h.a.b.a.f;
import java.util.List;
/* loaded from: classes18.dex */
public class a implements com.baidu.h.a.b.a.b {
    private com.baidu.h.a.b.c bxI;
    private int bxJ;
    private com.baidu.h.a.b.b bxK;
    private boolean bxL;
    private boolean bxM;
    private String mCastId;
    private String mUrl;

    public a(com.baidu.h.a.b.c cVar) {
        this.bxI = cVar;
    }

    public com.baidu.h.a.b.c Ro() {
        return this.bxI;
    }

    @Override // com.baidu.h.a.b.a.b
    public void a(String str, String str2, int i, final com.baidu.h.a.b.b bVar, boolean z) {
        this.mCastId = str;
        this.mUrl = str2;
        this.bxJ = i;
        this.bxK = bVar;
        this.bxM = z;
        this.bxI.setPullInterval(i);
        this.bxI.a(new com.baidu.h.a.b.b() { // from class: com.baidu.h.b.a.a.a.1
            @Override // com.baidu.h.a.b.b
            public void onResult(int i2, long j, long j2) {
                if (bVar != null) {
                    bVar.onResult(i2, j, j2);
                }
                a.this.bxL = true;
            }
        });
    }

    public void Br() {
        this.bxI.a(new com.baidu.h.a.b.b() { // from class: com.baidu.h.b.a.a.a.2
            @Override // com.baidu.h.a.b.b
            public void onResult(int i, long j, long j2) {
                if (a.this.bxK != null) {
                    a.this.bxK.onResult(i, j, j2);
                }
                a.this.bxL = true;
            }
        });
    }

    @Override // com.baidu.h.a.b.a.b
    public void hC(String str) {
        if (this.bxI != null) {
            this.bxI.hB(str);
            this.bxI.b(new com.baidu.h.a.b.b() { // from class: com.baidu.h.b.a.a.a.3
                @Override // com.baidu.h.a.b.b
                public void onResult(int i, long j, long j2) {
                    a.this.bxL = false;
                }
            });
            this.bxI.quitLiveShow();
        }
    }

    @Override // com.baidu.h.a.b.a.b
    public void IW() {
        hC(this.mCastId);
    }

    @Override // com.baidu.h.a.b.a.b
    public void a(final String str, e eVar, final f fVar) {
        if (this.bxI != null && eVar != null) {
            this.bxI.a(eVar, null, new com.baidu.h.a.b.f() { // from class: com.baidu.h.b.a.a.a.4
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
        this.bxI.a(str, new com.baidu.h.a.b.e() { // from class: com.baidu.h.b.a.a.a.5
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

    public boolean Rp() {
        return this.bxL;
    }
}
