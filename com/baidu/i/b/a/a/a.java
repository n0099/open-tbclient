package com.baidu.i.b.a.a;

import com.baidu.i.a.b.a.d;
import com.baidu.i.a.b.a.e;
import com.baidu.i.a.b.a.f;
import java.util.List;
/* loaded from: classes11.dex */
public class a implements com.baidu.i.a.b.a.b {
    private com.baidu.i.a.b.c bZs;
    private int bZt;
    private com.baidu.i.a.b.b bZu;
    private boolean bZv;
    private String mCastId;
    private boolean mNecessary;
    private String mUrl;

    public a(com.baidu.i.a.b.c cVar) {
        this.bZs = cVar;
    }

    public com.baidu.i.a.b.c aal() {
        return this.bZs;
    }

    @Override // com.baidu.i.a.b.a.b
    public void a(String str, String str2, int i, final com.baidu.i.a.b.b bVar, boolean z) {
        this.mCastId = str;
        this.mUrl = str2;
        this.bZt = i;
        this.bZu = bVar;
        this.mNecessary = z;
        this.bZs.setPullInterval(i);
        this.bZs.a(new com.baidu.i.a.b.b() { // from class: com.baidu.i.b.a.a.a.1
            @Override // com.baidu.i.a.b.b
            public void onResult(int i2, long j, long j2) {
                if (bVar != null) {
                    bVar.onResult(i2, j, j2);
                }
                a.this.bZv = true;
            }
        });
    }

    public void Ed() {
        this.bZs.a(new com.baidu.i.a.b.b() { // from class: com.baidu.i.b.a.a.a.2
            @Override // com.baidu.i.a.b.b
            public void onResult(int i, long j, long j2) {
                if (a.this.bZu != null) {
                    a.this.bZu.onResult(i, j, j2);
                }
                a.this.bZv = true;
            }
        });
    }

    @Override // com.baidu.i.a.b.a.b
    public void jD(String str) {
        if (this.bZs != null) {
            this.bZs.jC(str);
            this.bZs.b(new com.baidu.i.a.b.b() { // from class: com.baidu.i.b.a.a.a.3
                @Override // com.baidu.i.a.b.b
                public void onResult(int i, long j, long j2) {
                    a.this.bZv = false;
                }
            });
            this.bZs.quitLiveShow();
        }
    }

    @Override // com.baidu.i.a.b.a.b
    public void MU() {
        jD(this.mCastId);
    }

    @Override // com.baidu.i.a.b.a.b
    public void a(final String str, e eVar, final f fVar) {
        if (this.bZs != null && eVar != null) {
            this.bZs.a(eVar, null, new com.baidu.i.a.b.f() { // from class: com.baidu.i.b.a.a.a.4
                @Override // com.baidu.i.a.b.f
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

    @Override // com.baidu.i.a.b.a.b
    public void a(String str, final d dVar) {
        this.bZs.a(str, new com.baidu.i.a.b.e() { // from class: com.baidu.i.b.a.a.a.5
            @Override // com.baidu.i.a.b.e
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

    public boolean aam() {
        return this.bZv;
    }
}
