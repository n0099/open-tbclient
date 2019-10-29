package com.baidu.c.b.a.a;

import com.baidu.c.a.b.a.d;
import com.baidu.c.a.b.a.e;
import com.baidu.c.a.b.a.f;
import com.baidu.c.a.b.g;
import java.util.List;
/* loaded from: classes6.dex */
public class a implements com.baidu.c.a.b.a.b {
    private com.baidu.c.a.b.c awj;
    private int awk;
    private com.baidu.c.a.b.b awl;
    private boolean awm;
    private boolean awn;
    private String mCastId;
    private String mUrl;

    public a(com.baidu.c.a.b.c cVar) {
        this.awj = cVar;
    }

    public com.baidu.c.a.b.c xi() {
        return this.awj;
    }

    @Override // com.baidu.c.a.b.a.b
    public void a(String str, String str2, int i, final com.baidu.c.a.b.b bVar, boolean z) {
        this.mCastId = str;
        this.mUrl = str2;
        this.awk = i;
        this.awl = bVar;
        this.awn = z;
        this.awj.setPullInterval(i);
        this.awj.a(new com.baidu.c.a.b.b() { // from class: com.baidu.c.b.a.a.a.1
            @Override // com.baidu.c.a.b.b
            public void onResult(int i2, long j, long j2) {
                if (bVar != null) {
                    bVar.onResult(i2, j, j2);
                }
                a.this.awm = true;
            }
        });
    }

    public void tQ() {
        this.awj.quitLiveShow();
        this.awj.a(new com.baidu.c.a.b.b() { // from class: com.baidu.c.b.a.a.a.2
            @Override // com.baidu.c.a.b.b
            public void onResult(int i, long j, long j2) {
                if (a.this.awl != null) {
                    a.this.awl.onResult(i, j, j2);
                }
                a.this.awm = true;
            }
        });
    }

    @Override // com.baidu.c.a.b.a.b
    public void dm(String str) {
        if (this.awj != null) {
            this.awj.dl(str);
            this.awj.b(new com.baidu.c.a.b.b() { // from class: com.baidu.c.b.a.a.a.3
                @Override // com.baidu.c.a.b.b
                public void onResult(int i, long j, long j2) {
                    a.this.awm = false;
                }
            });
            this.awj.quitLiveShow();
        }
    }

    @Override // com.baidu.c.a.b.a.b
    public void sy() {
        dm(this.mCastId);
    }

    @Override // com.baidu.c.a.b.a.b
    public void a(final String str, e eVar, final f fVar) {
        if (this.awj != null && eVar != null) {
            this.awj.a(eVar, (g) null, new com.baidu.c.a.b.f() { // from class: com.baidu.c.b.a.a.a.4
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
        this.awj.a(str, this.awn, new com.baidu.c.a.b.e() { // from class: com.baidu.c.b.a.a.a.5
            @Override // com.baidu.c.a.b.e
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

    public boolean xj() {
        return this.awm;
    }
}
