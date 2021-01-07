package com.baidu.j.b.a.a;

import com.baidu.j.a.b.a.d;
import com.baidu.j.a.b.a.e;
import com.baidu.j.a.b.a.f;
import java.util.List;
/* loaded from: classes10.dex */
public class a implements com.baidu.j.a.b.a.b {
    private com.baidu.j.a.b.c cgc;
    private int cgd;
    private com.baidu.j.a.b.b cge;
    private boolean cgf;
    private String mCastId;
    private boolean mNecessary;
    private String mUrl;

    public a(com.baidu.j.a.b.c cVar) {
        this.cgc = cVar;
    }

    public com.baidu.j.a.b.c abZ() {
        return this.cgc;
    }

    @Override // com.baidu.j.a.b.a.b
    public void a(String str, String str2, int i, final com.baidu.j.a.b.b bVar, boolean z) {
        this.mCastId = str;
        this.mUrl = str2;
        this.cgd = i;
        this.cge = bVar;
        this.mNecessary = z;
        this.cgc.setPullInterval(i);
        this.cgc.a(new com.baidu.j.a.b.b() { // from class: com.baidu.j.b.a.a.a.1
            @Override // com.baidu.j.a.b.b
            public void onResult(int i2, long j, long j2) {
                if (bVar != null) {
                    bVar.onResult(i2, j, j2);
                }
                a.this.cgf = true;
            }
        });
    }

    public void Ds() {
        this.cgc.a(new com.baidu.j.a.b.b() { // from class: com.baidu.j.b.a.a.a.2
            @Override // com.baidu.j.a.b.b
            public void onResult(int i, long j, long j2) {
                if (a.this.cge != null) {
                    a.this.cge.onResult(i, j, j2);
                }
                a.this.cgf = true;
            }
        });
    }

    @Override // com.baidu.j.a.b.a.b
    public void jw(String str) {
        if (this.cgc != null) {
            this.cgc.jv(str);
            this.cgc.b(new com.baidu.j.a.b.b() { // from class: com.baidu.j.b.a.a.a.3
                @Override // com.baidu.j.a.b.b
                public void onResult(int i, long j, long j2) {
                    a.this.cgf = false;
                }
            });
            this.cgc.quitLiveShow();
        }
    }

    @Override // com.baidu.j.a.b.a.b
    public void Mr() {
        jw(this.mCastId);
    }

    @Override // com.baidu.j.a.b.a.b
    public void a(final String str, e eVar, final f fVar) {
        if (this.cgc != null && eVar != null) {
            this.cgc.a(eVar, null, new com.baidu.j.a.b.f() { // from class: com.baidu.j.b.a.a.a.4
                @Override // com.baidu.j.a.b.f
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

    @Override // com.baidu.j.a.b.a.b
    public void a(String str, final d dVar) {
        this.cgc.a(str, new com.baidu.j.a.b.e() { // from class: com.baidu.j.b.a.a.a.5
            @Override // com.baidu.j.a.b.e
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

    public boolean aca() {
        return this.cgf;
    }
}
