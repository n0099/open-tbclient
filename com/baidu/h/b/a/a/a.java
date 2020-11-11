package com.baidu.h.b.a.a;

import com.baidu.h.a.b.a.d;
import com.baidu.h.a.b.a.e;
import com.baidu.h.a.b.a.f;
import java.util.List;
/* loaded from: classes15.dex */
public class a implements com.baidu.h.a.b.a.b {
    private com.baidu.h.a.b.c bVM;
    private int bVN;
    private com.baidu.h.a.b.b bVO;
    private boolean bVP;
    private boolean bVQ;
    private String mCastId;
    private String mUrl;

    public a(com.baidu.h.a.b.c cVar) {
        this.bVM = cVar;
    }

    public com.baidu.h.a.b.c Yr() {
        return this.bVM;
    }

    @Override // com.baidu.h.a.b.a.b
    public void a(String str, String str2, int i, final com.baidu.h.a.b.b bVar, boolean z) {
        this.mCastId = str;
        this.mUrl = str2;
        this.bVN = i;
        this.bVO = bVar;
        this.bVQ = z;
        this.bVM.setPullInterval(i);
        this.bVM.a(new com.baidu.h.a.b.b() { // from class: com.baidu.h.b.a.a.a.1
            @Override // com.baidu.h.a.b.b
            public void onResult(int i2, long j, long j2) {
                if (bVar != null) {
                    bVar.onResult(i2, j, j2);
                }
                a.this.bVP = true;
            }
        });
    }

    public void Dc() {
        this.bVM.a(new com.baidu.h.a.b.b() { // from class: com.baidu.h.b.a.a.a.2
            @Override // com.baidu.h.a.b.b
            public void onResult(int i, long j, long j2) {
                if (a.this.bVO != null) {
                    a.this.bVO.onResult(i, j, j2);
                }
                a.this.bVP = true;
            }
        });
    }

    @Override // com.baidu.h.a.b.a.b
    public void jf(String str) {
        if (this.bVM != null) {
            this.bVM.je(str);
            this.bVM.b(new com.baidu.h.a.b.b() { // from class: com.baidu.h.b.a.a.a.3
                @Override // com.baidu.h.a.b.b
                public void onResult(int i, long j, long j2) {
                    a.this.bVP = false;
                }
            });
            this.bVM.quitLiveShow();
        }
    }

    @Override // com.baidu.h.a.b.a.b
    public void LA() {
        jf(this.mCastId);
    }

    @Override // com.baidu.h.a.b.a.b
    public void a(final String str, e eVar, final f fVar) {
        if (this.bVM != null && eVar != null) {
            this.bVM.a(eVar, null, new com.baidu.h.a.b.f() { // from class: com.baidu.h.b.a.a.a.4
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
        this.bVM.a(str, new com.baidu.h.a.b.e() { // from class: com.baidu.h.b.a.a.a.5
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

    public boolean Ys() {
        return this.bVP;
    }
}
