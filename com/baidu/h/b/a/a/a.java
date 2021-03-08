package com.baidu.h.b.a.a;

import com.baidu.h.a.b.a.d;
import com.baidu.h.a.b.a.e;
import com.baidu.h.a.b.a.f;
import java.util.List;
/* loaded from: classes9.dex */
public class a implements com.baidu.h.a.b.a.b {
    private com.baidu.h.a.b.c cgY;
    private int cgZ;
    private com.baidu.h.a.b.b cha;
    private boolean chb;
    private String mCastId;
    private boolean mNecessary;
    private String mUrl;

    public a(com.baidu.h.a.b.c cVar) {
        this.cgY = cVar;
    }

    public com.baidu.h.a.b.c aad() {
        return this.cgY;
    }

    @Override // com.baidu.h.a.b.a.b
    public void a(String str, String str2, int i, final com.baidu.h.a.b.b bVar, boolean z) {
        this.mCastId = str;
        this.mUrl = str2;
        this.cgZ = i;
        this.cha = bVar;
        this.mNecessary = z;
        this.cgY.setPullInterval(i);
        this.cgY.a(new com.baidu.h.a.b.b() { // from class: com.baidu.h.b.a.a.a.1
            @Override // com.baidu.h.a.b.b
            public void onResult(int i2, long j, long j2) {
                if (bVar != null) {
                    bVar.onResult(i2, j, j2);
                }
                a.this.chb = true;
            }
        });
    }

    public void Ak() {
        this.cgY.a(new com.baidu.h.a.b.b() { // from class: com.baidu.h.b.a.a.a.2
            @Override // com.baidu.h.a.b.b
            public void onResult(int i, long j, long j2) {
                if (a.this.cha != null) {
                    a.this.cha.onResult(i, j, j2);
                }
                a.this.chb = true;
            }
        });
    }

    @Override // com.baidu.h.a.b.a.b
    public void iX(String str) {
        if (this.cgY != null) {
            this.cgY.iW(str);
            this.cgY.b(new com.baidu.h.a.b.b() { // from class: com.baidu.h.b.a.a.a.3
                @Override // com.baidu.h.a.b.b
                public void onResult(int i, long j, long j2) {
                    a.this.chb = false;
                }
            });
            this.cgY.quitLiveShow();
        }
    }

    @Override // com.baidu.h.a.b.a.b
    public void JX() {
        iX(this.mCastId);
    }

    @Override // com.baidu.h.a.b.a.b
    public void a(final String str, e eVar, final f fVar) {
        if (this.cgY != null && eVar != null) {
            this.cgY.a(eVar, null, new com.baidu.h.a.b.f() { // from class: com.baidu.h.b.a.a.a.4
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
        this.cgY.a(str, new com.baidu.h.a.b.e() { // from class: com.baidu.h.b.a.a.a.5
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

    public boolean aae() {
        return this.chb;
    }
}
