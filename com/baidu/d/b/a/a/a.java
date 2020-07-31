package com.baidu.d.b.a.a;

import com.baidu.d.a.b.a.d;
import com.baidu.d.a.b.a.e;
import com.baidu.d.a.b.a.f;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements com.baidu.d.a.b.a.b {
    private com.baidu.d.a.b.c brP;
    private int brQ;
    private com.baidu.d.a.b.b brR;
    private boolean brS;
    private boolean brT;
    private String mCastId;
    private String mUrl;

    public a(com.baidu.d.a.b.c cVar) {
        this.brP = cVar;
    }

    public com.baidu.d.a.b.c Lo() {
        return this.brP;
    }

    @Override // com.baidu.d.a.b.a.b
    public void a(String str, String str2, int i, final com.baidu.d.a.b.b bVar, boolean z) {
        this.mCastId = str;
        this.mUrl = str2;
        this.brQ = i;
        this.brR = bVar;
        this.brT = z;
        this.brP.setPullInterval(i);
        this.brP.a(new com.baidu.d.a.b.b() { // from class: com.baidu.d.b.a.a.a.1
            @Override // com.baidu.d.a.b.b
            public void onResult(int i2, long j, long j2) {
                if (bVar != null) {
                    bVar.onResult(i2, j, j2);
                }
                a.this.brS = true;
            }
        });
    }

    public void vT() {
        this.brP.a(new com.baidu.d.a.b.b() { // from class: com.baidu.d.b.a.a.a.2
            @Override // com.baidu.d.a.b.b
            public void onResult(int i, long j, long j2) {
                if (a.this.brR != null) {
                    a.this.brR.onResult(i, j, j2);
                }
                a.this.brS = true;
            }
        });
    }

    @Override // com.baidu.d.a.b.a.b
    public void gg(String str) {
        if (this.brP != null) {
            this.brP.gf(str);
            this.brP.b(new com.baidu.d.a.b.b() { // from class: com.baidu.d.b.a.a.a.3
                @Override // com.baidu.d.a.b.b
                public void onResult(int i, long j, long j2) {
                    a.this.brS = false;
                }
            });
            this.brP.quitLiveShow();
        }
    }

    @Override // com.baidu.d.a.b.a.b
    public void Dt() {
        gg(this.mCastId);
    }

    @Override // com.baidu.d.a.b.a.b
    public void a(final String str, e eVar, final f fVar) {
        if (this.brP != null && eVar != null) {
            this.brP.a(eVar, null, new com.baidu.d.a.b.f() { // from class: com.baidu.d.b.a.a.a.4
                @Override // com.baidu.d.a.b.f
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

    @Override // com.baidu.d.a.b.a.b
    public void a(String str, final d dVar) {
        this.brP.a(str, new com.baidu.d.a.b.e() { // from class: com.baidu.d.b.a.a.a.5
            @Override // com.baidu.d.a.b.e
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

    public boolean Lp() {
        return this.brS;
    }
}
