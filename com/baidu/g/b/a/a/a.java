package com.baidu.g.b.a.a;

import com.baidu.g.a.b.a.d;
import com.baidu.g.a.b.a.e;
import com.baidu.g.a.b.a.f;
import com.baidu.g.a.b.g;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements com.baidu.g.a.b.a.b {
    private com.baidu.g.a.b.c aIJ;
    private int aIK;
    private com.baidu.g.a.b.b aIL;
    private boolean aIM;
    private boolean aIN;
    private String mCastId;
    private String mUrl;

    public a(com.baidu.g.a.b.c cVar) {
        this.aIJ = cVar;
    }

    public com.baidu.g.a.b.c BV() {
        return this.aIJ;
    }

    @Override // com.baidu.g.a.b.a.b
    public void a(String str, String str2, int i, final com.baidu.g.a.b.b bVar, boolean z) {
        this.mCastId = str;
        this.mUrl = str2;
        this.aIK = i;
        this.aIL = bVar;
        this.aIN = z;
        this.aIJ.setPullInterval(i);
        this.aIJ.a(new com.baidu.g.a.b.b() { // from class: com.baidu.g.b.a.a.a.1
            @Override // com.baidu.g.a.b.b
            public void onResult(int i2, long j, long j2) {
                if (bVar != null) {
                    bVar.onResult(i2, j, j2);
                }
                a.this.aIM = true;
            }
        });
    }

    public void yi() {
        this.aIJ.quitLiveShow();
        this.aIJ.a(new com.baidu.g.a.b.b() { // from class: com.baidu.g.b.a.a.a.2
            @Override // com.baidu.g.a.b.b
            public void onResult(int i, long j, long j2) {
                if (a.this.aIL != null) {
                    a.this.aIL.onResult(i, j, j2);
                }
                a.this.aIM = true;
            }
        });
    }

    @Override // com.baidu.g.a.b.a.b
    public void eu(String str) {
        if (this.aIJ != null) {
            this.aIJ.et(str);
            this.aIJ.b(new com.baidu.g.a.b.b() { // from class: com.baidu.g.b.a.a.a.3
                @Override // com.baidu.g.a.b.b
                public void onResult(int i, long j, long j2) {
                    a.this.aIM = false;
                }
            });
            this.aIJ.quitLiveShow();
        }
    }

    @Override // com.baidu.g.a.b.a.b
    public void wl() {
        eu(this.mCastId);
    }

    @Override // com.baidu.g.a.b.a.b
    public void a(final String str, e eVar, final f fVar) {
        if (this.aIJ != null && eVar != null) {
            this.aIJ.a(eVar, (g) null, new com.baidu.g.a.b.f() { // from class: com.baidu.g.b.a.a.a.4
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
        this.aIJ.a(str, this.aIN, new com.baidu.g.a.b.e() { // from class: com.baidu.g.b.a.a.a.5
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

    public boolean BW() {
        return this.aIM;
    }
}
