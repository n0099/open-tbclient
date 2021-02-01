package com.baidu.h.b.a.a;

import com.baidu.h.a.b.a.d;
import com.baidu.h.a.b.a.e;
import com.baidu.h.a.b.a.f;
import java.util.List;
/* loaded from: classes10.dex */
public class a implements com.baidu.h.a.b.a.b {
    private com.baidu.h.a.b.b cfA;
    private boolean cfB;
    private com.baidu.h.a.b.c cfy;
    private int cfz;
    private String mCastId;
    private boolean mNecessary;
    private String mUrl;

    public a(com.baidu.h.a.b.c cVar) {
        this.cfy = cVar;
    }

    public com.baidu.h.a.b.c aaa() {
        return this.cfy;
    }

    @Override // com.baidu.h.a.b.a.b
    public void a(String str, String str2, int i, final com.baidu.h.a.b.b bVar, boolean z) {
        this.mCastId = str;
        this.mUrl = str2;
        this.cfz = i;
        this.cfA = bVar;
        this.mNecessary = z;
        this.cfy.setPullInterval(i);
        this.cfy.a(new com.baidu.h.a.b.b() { // from class: com.baidu.h.b.a.a.a.1
            @Override // com.baidu.h.a.b.b
            public void onResult(int i2, long j, long j2) {
                if (bVar != null) {
                    bVar.onResult(i2, j, j2);
                }
                a.this.cfB = true;
            }
        });
    }

    public void Ah() {
        this.cfy.a(new com.baidu.h.a.b.b() { // from class: com.baidu.h.b.a.a.a.2
            @Override // com.baidu.h.a.b.b
            public void onResult(int i, long j, long j2) {
                if (a.this.cfA != null) {
                    a.this.cfA.onResult(i, j, j2);
                }
                a.this.cfB = true;
            }
        });
    }

    @Override // com.baidu.h.a.b.a.b
    public void iR(String str) {
        if (this.cfy != null) {
            this.cfy.iQ(str);
            this.cfy.b(new com.baidu.h.a.b.b() { // from class: com.baidu.h.b.a.a.a.3
                @Override // com.baidu.h.a.b.b
                public void onResult(int i, long j, long j2) {
                    a.this.cfB = false;
                }
            });
            this.cfy.quitLiveShow();
        }
    }

    @Override // com.baidu.h.a.b.a.b
    public void JU() {
        iR(this.mCastId);
    }

    @Override // com.baidu.h.a.b.a.b
    public void a(final String str, e eVar, final f fVar) {
        if (this.cfy != null && eVar != null) {
            this.cfy.a(eVar, null, new com.baidu.h.a.b.f() { // from class: com.baidu.h.b.a.a.a.4
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
        this.cfy.a(str, new com.baidu.h.a.b.e() { // from class: com.baidu.h.b.a.a.a.5
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

    public boolean aab() {
        return this.cfB;
    }
}
