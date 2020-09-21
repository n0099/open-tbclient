package com.baidu.h.b.a.a;

import com.baidu.h.a.b.a.d;
import com.baidu.h.a.b.a.e;
import com.baidu.h.a.b.a.f;
import java.util.List;
/* loaded from: classes23.dex */
public class a implements com.baidu.h.a.b.a.b {
    private com.baidu.h.a.b.c bBf;
    private int bBg;
    private com.baidu.h.a.b.b bBh;
    private boolean bBi;
    private boolean bBj;
    private String mCastId;
    private String mUrl;

    public a(com.baidu.h.a.b.c cVar) {
        this.bBf = cVar;
    }

    public com.baidu.h.a.b.c Sf() {
        return this.bBf;
    }

    @Override // com.baidu.h.a.b.a.b
    public void a(String str, String str2, int i, final com.baidu.h.a.b.b bVar, boolean z) {
        this.mCastId = str;
        this.mUrl = str2;
        this.bBg = i;
        this.bBh = bVar;
        this.bBj = z;
        this.bBf.setPullInterval(i);
        this.bBf.a(new com.baidu.h.a.b.b() { // from class: com.baidu.h.b.a.a.a.1
            @Override // com.baidu.h.a.b.b
            public void onResult(int i2, long j, long j2) {
                if (bVar != null) {
                    bVar.onResult(i2, j, j2);
                }
                a.this.bBi = true;
            }
        });
    }

    public void BG() {
        this.bBf.a(new com.baidu.h.a.b.b() { // from class: com.baidu.h.b.a.a.a.2
            @Override // com.baidu.h.a.b.b
            public void onResult(int i, long j, long j2) {
                if (a.this.bBh != null) {
                    a.this.bBh.onResult(i, j, j2);
                }
                a.this.bBi = true;
            }
        });
    }

    @Override // com.baidu.h.a.b.a.b
    public void hY(String str) {
        if (this.bBf != null) {
            this.bBf.hX(str);
            this.bBf.b(new com.baidu.h.a.b.b() { // from class: com.baidu.h.b.a.a.a.3
                @Override // com.baidu.h.a.b.b
                public void onResult(int i, long j, long j2) {
                    a.this.bBi = false;
                }
            });
            this.bBf.quitLiveShow();
        }
    }

    @Override // com.baidu.h.a.b.a.b
    public void JA() {
        hY(this.mCastId);
    }

    @Override // com.baidu.h.a.b.a.b
    public void a(final String str, e eVar, final f fVar) {
        if (this.bBf != null && eVar != null) {
            this.bBf.a(eVar, null, new com.baidu.h.a.b.f() { // from class: com.baidu.h.b.a.a.a.4
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
        this.bBf.a(str, new com.baidu.h.a.b.e() { // from class: com.baidu.h.b.a.a.a.5
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

    public boolean Sg() {
        return this.bBi;
    }
}
