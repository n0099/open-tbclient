package com.baidu.c.b.a.a;

import com.baidu.c.a.b.a.d;
import com.baidu.c.a.b.a.e;
import com.baidu.c.a.b.a.f;
import com.baidu.c.a.b.g;
import java.util.List;
/* loaded from: classes6.dex */
public class a implements com.baidu.c.a.b.a.b {
    private com.baidu.c.a.b.c bru;
    private int brv;
    private com.baidu.c.a.b.b brw;
    private boolean brx;
    private boolean bry;
    private String mCastId;
    private String mUrl;

    public a(com.baidu.c.a.b.c cVar) {
        this.bru = cVar;
    }

    public com.baidu.c.a.b.c Lh() {
        return this.bru;
    }

    @Override // com.baidu.c.a.b.a.b
    public void a(String str, String str2, int i, final com.baidu.c.a.b.b bVar, boolean z) {
        this.mCastId = str;
        this.mUrl = str2;
        this.brv = i;
        this.brw = bVar;
        this.bry = z;
        this.bru.setPullInterval(i);
        this.bru.a(new com.baidu.c.a.b.b() { // from class: com.baidu.c.b.a.a.a.1
            @Override // com.baidu.c.a.b.b
            public void onResult(int i2, long j, long j2) {
                if (bVar != null) {
                    bVar.onResult(i2, j, j2);
                }
                a.this.brx = true;
            }
        });
    }

    public void Fh() {
        this.bru.a(new com.baidu.c.a.b.b() { // from class: com.baidu.c.b.a.a.a.2
            @Override // com.baidu.c.a.b.b
            public void onResult(int i, long j, long j2) {
                if (a.this.brw != null) {
                    a.this.brw.onResult(i, j, j2);
                }
                a.this.brx = true;
            }
        });
    }

    @Override // com.baidu.c.a.b.a.b
    public void gh(String str) {
        if (this.bru != null) {
            this.bru.gg(str);
            this.bru.b(new com.baidu.c.a.b.b() { // from class: com.baidu.c.b.a.a.a.3
                @Override // com.baidu.c.a.b.b
                public void onResult(int i, long j, long j2) {
                    a.this.brx = false;
                }
            });
            this.bru.quitLiveShow();
        }
    }

    @Override // com.baidu.c.a.b.a.b
    public void CS() {
        gh(this.mCastId);
    }

    @Override // com.baidu.c.a.b.a.b
    public void a(final String str, e eVar, final f fVar) {
        if (this.bru != null && eVar != null) {
            this.bru.a(eVar, (g) null, new com.baidu.c.a.b.f() { // from class: com.baidu.c.b.a.a.a.4
                @Override // com.baidu.c.a.b.f
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

    @Override // com.baidu.c.a.b.a.b
    public void a(String str, final d dVar) {
        this.bru.a(str, this.bry, new com.baidu.c.a.b.e() { // from class: com.baidu.c.b.a.a.a.5
            @Override // com.baidu.c.a.b.e
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

    public boolean Li() {
        return this.brx;
    }
}
