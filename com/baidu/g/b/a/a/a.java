package com.baidu.g.b.a.a;

import com.baidu.g.a.b.a.d;
import com.baidu.g.a.b.a.e;
import com.baidu.g.a.b.a.f;
import com.baidu.g.a.b.g;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements com.baidu.g.a.b.a.b {
    private com.baidu.g.a.b.c aIH;
    private int aII;
    private com.baidu.g.a.b.b aIJ;
    private boolean aIK;
    private boolean aIL;
    private String mCastId;
    private String mUrl;

    public a(com.baidu.g.a.b.c cVar) {
        this.aIH = cVar;
    }

    public com.baidu.g.a.b.c BT() {
        return this.aIH;
    }

    @Override // com.baidu.g.a.b.a.b
    public void a(String str, String str2, int i, final com.baidu.g.a.b.b bVar, boolean z) {
        this.mCastId = str;
        this.mUrl = str2;
        this.aII = i;
        this.aIJ = bVar;
        this.aIL = z;
        this.aIH.setPullInterval(i);
        this.aIH.a(new com.baidu.g.a.b.b() { // from class: com.baidu.g.b.a.a.a.1
            @Override // com.baidu.g.a.b.b
            public void onResult(int i2, long j, long j2) {
                if (bVar != null) {
                    bVar.onResult(i2, j, j2);
                }
                a.this.aIK = true;
            }
        });
    }

    public void yi() {
        this.aIH.quitLiveShow();
        this.aIH.a(new com.baidu.g.a.b.b() { // from class: com.baidu.g.b.a.a.a.2
            @Override // com.baidu.g.a.b.b
            public void onResult(int i, long j, long j2) {
                if (a.this.aIJ != null) {
                    a.this.aIJ.onResult(i, j, j2);
                }
                a.this.aIK = true;
            }
        });
    }

    @Override // com.baidu.g.a.b.a.b
    public void eu(String str) {
        if (this.aIH != null) {
            this.aIH.et(str);
            this.aIH.b(new com.baidu.g.a.b.b() { // from class: com.baidu.g.b.a.a.a.3
                @Override // com.baidu.g.a.b.b
                public void onResult(int i, long j, long j2) {
                    a.this.aIK = false;
                }
            });
            this.aIH.quitLiveShow();
        }
    }

    @Override // com.baidu.g.a.b.a.b
    public void wl() {
        eu(this.mCastId);
    }

    @Override // com.baidu.g.a.b.a.b
    public void a(final String str, e eVar, final f fVar) {
        if (this.aIH != null && eVar != null) {
            this.aIH.a(eVar, (g) null, new com.baidu.g.a.b.f() { // from class: com.baidu.g.b.a.a.a.4
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
        this.aIH.a(str, this.aIL, new com.baidu.g.a.b.e() { // from class: com.baidu.g.b.a.a.a.5
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

    public boolean BU() {
        return this.aIK;
    }
}
