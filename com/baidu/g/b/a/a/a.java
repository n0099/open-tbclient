package com.baidu.g.b.a.a;

import com.baidu.g.a.b.a.d;
import com.baidu.g.a.b.a.e;
import com.baidu.g.a.b.a.f;
import com.baidu.g.a.b.g;
import java.util.List;
/* loaded from: classes2.dex */
public class a implements com.baidu.g.a.b.a.b {
    private com.baidu.g.a.b.c aEB;
    private int aEC;
    private com.baidu.g.a.b.b aED;
    private boolean aEE;
    private boolean aEF;
    private String mCastId;
    private String mUrl;

    public a(com.baidu.g.a.b.c cVar) {
        this.aEB = cVar;
    }

    public com.baidu.g.a.b.c zD() {
        return this.aEB;
    }

    @Override // com.baidu.g.a.b.a.b
    public void a(String str, String str2, int i, final com.baidu.g.a.b.b bVar, boolean z) {
        this.mCastId = str;
        this.mUrl = str2;
        this.aEC = i;
        this.aED = bVar;
        this.aEF = z;
        this.aEB.setPullInterval(i);
        this.aEB.a(new com.baidu.g.a.b.b() { // from class: com.baidu.g.b.a.a.a.1
            @Override // com.baidu.g.a.b.b
            public void onResult(int i2, long j, long j2) {
                if (bVar != null) {
                    bVar.onResult(i2, j, j2);
                }
                a.this.aEE = true;
            }
        });
    }

    public void we() {
        this.aEB.quitLiveShow();
        this.aEB.a(new com.baidu.g.a.b.b() { // from class: com.baidu.g.b.a.a.a.2
            @Override // com.baidu.g.a.b.b
            public void onResult(int i, long j, long j2) {
                if (a.this.aED != null) {
                    a.this.aED.onResult(i, j, j2);
                }
                a.this.aEE = true;
            }
        });
    }

    @Override // com.baidu.g.a.b.a.b
    public void ef(String str) {
        if (this.aEB != null) {
            this.aEB.ee(str);
            this.aEB.b(new com.baidu.g.a.b.b() { // from class: com.baidu.g.b.a.a.a.3
                @Override // com.baidu.g.a.b.b
                public void onResult(int i, long j, long j2) {
                    a.this.aEE = false;
                }
            });
            this.aEB.quitLiveShow();
        }
    }

    @Override // com.baidu.g.a.b.a.b
    public void uH() {
        ef(this.mCastId);
    }

    @Override // com.baidu.g.a.b.a.b
    public void a(final String str, e eVar, final f fVar) {
        if (this.aEB != null && eVar != null) {
            this.aEB.a(eVar, (g) null, new com.baidu.g.a.b.f() { // from class: com.baidu.g.b.a.a.a.4
                @Override // com.baidu.g.a.b.f
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

    @Override // com.baidu.g.a.b.a.b
    public void a(String str, final d dVar) {
        this.aEB.a(str, this.aEF, new com.baidu.g.a.b.e() { // from class: com.baidu.g.b.a.a.a.5
            @Override // com.baidu.g.a.b.e
            public void b(int i, Object obj) {
                if (dVar != null) {
                    try {
                        dVar.d(i, (List) obj);
                    } catch (Exception e) {
                    }
                }
            }
        });
    }

    public boolean zE() {
        return this.aEE;
    }
}
