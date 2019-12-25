package com.baidu.g.b.a.a;

import com.baidu.g.a.b.a.d;
import com.baidu.g.a.b.a.e;
import com.baidu.g.a.b.a.f;
import com.baidu.g.a.b.g;
import java.util.List;
/* loaded from: classes2.dex */
public class a implements com.baidu.g.a.b.a.b {
    private com.baidu.g.a.b.c aDJ;
    private int aDK;
    private com.baidu.g.a.b.b aDL;
    private boolean aDM;
    private boolean aDN;
    private String mCastId;
    private String mUrl;

    public a(com.baidu.g.a.b.c cVar) {
        this.aDJ = cVar;
    }

    public com.baidu.g.a.b.c zh() {
        return this.aDJ;
    }

    @Override // com.baidu.g.a.b.a.b
    public void a(String str, String str2, int i, final com.baidu.g.a.b.b bVar, boolean z) {
        this.mCastId = str;
        this.mUrl = str2;
        this.aDK = i;
        this.aDL = bVar;
        this.aDN = z;
        this.aDJ.setPullInterval(i);
        this.aDJ.a(new com.baidu.g.a.b.b() { // from class: com.baidu.g.b.a.a.a.1
            @Override // com.baidu.g.a.b.b
            public void onResult(int i2, long j, long j2) {
                if (bVar != null) {
                    bVar.onResult(i2, j, j2);
                }
                a.this.aDM = true;
            }
        });
    }

    public void vN() {
        this.aDJ.quitLiveShow();
        this.aDJ.a(new com.baidu.g.a.b.b() { // from class: com.baidu.g.b.a.a.a.2
            @Override // com.baidu.g.a.b.b
            public void onResult(int i, long j, long j2) {
                if (a.this.aDL != null) {
                    a.this.aDL.onResult(i, j, j2);
                }
                a.this.aDM = true;
            }
        });
    }

    @Override // com.baidu.g.a.b.a.b
    public void ec(String str) {
        if (this.aDJ != null) {
            this.aDJ.eb(str);
            this.aDJ.b(new com.baidu.g.a.b.b() { // from class: com.baidu.g.b.a.a.a.3
                @Override // com.baidu.g.a.b.b
                public void onResult(int i, long j, long j2) {
                    a.this.aDM = false;
                }
            });
            this.aDJ.quitLiveShow();
        }
    }

    @Override // com.baidu.g.a.b.a.b
    public void uq() {
        ec(this.mCastId);
    }

    @Override // com.baidu.g.a.b.a.b
    public void a(final String str, e eVar, final f fVar) {
        if (this.aDJ != null && eVar != null) {
            this.aDJ.a(eVar, (g) null, new com.baidu.g.a.b.f() { // from class: com.baidu.g.b.a.a.a.4
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
        this.aDJ.a(str, this.aDN, new com.baidu.g.a.b.e() { // from class: com.baidu.g.b.a.a.a.5
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

    public boolean zi() {
        return this.aDM;
    }
}
