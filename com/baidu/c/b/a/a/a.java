package com.baidu.c.b.a.a;

import com.baidu.c.a.b.a.d;
import com.baidu.c.a.b.a.e;
import com.baidu.c.a.b.a.f;
import com.baidu.c.a.b.g;
import java.util.List;
/* loaded from: classes6.dex */
public class a implements com.baidu.c.a.b.a.b {
    private com.baidu.c.a.b.c beT;
    private int beU;
    private com.baidu.c.a.b.b beV;
    private boolean beW;
    private boolean beX;
    private String mCastId;
    private String mUrl;

    public a(com.baidu.c.a.b.c cVar) {
        this.beT = cVar;
    }

    public com.baidu.c.a.b.c If() {
        return this.beT;
    }

    @Override // com.baidu.c.a.b.a.b
    public void a(String str, String str2, int i, final com.baidu.c.a.b.b bVar, boolean z) {
        this.mCastId = str;
        this.mUrl = str2;
        this.beU = i;
        this.beV = bVar;
        this.beX = z;
        this.beT.setPullInterval(i);
        this.beT.a(new com.baidu.c.a.b.b() { // from class: com.baidu.c.b.a.a.a.1
            @Override // com.baidu.c.a.b.b
            public void onResult(int i2, long j, long j2) {
                if (bVar != null) {
                    bVar.onResult(i2, j, j2);
                }
                a.this.beW = true;
            }
        });
    }

    public void Df() {
        this.beT.a(new com.baidu.c.a.b.b() { // from class: com.baidu.c.b.a.a.a.2
            @Override // com.baidu.c.a.b.b
            public void onResult(int i, long j, long j2) {
                if (a.this.beV != null) {
                    a.this.beV.onResult(i, j, j2);
                }
                a.this.beW = true;
            }
        });
    }

    @Override // com.baidu.c.a.b.a.b
    public void fn(String str) {
        if (this.beT != null) {
            this.beT.fm(str);
            this.beT.b(new com.baidu.c.a.b.b() { // from class: com.baidu.c.b.a.a.a.3
                @Override // com.baidu.c.a.b.b
                public void onResult(int i, long j, long j2) {
                    a.this.beW = false;
                }
            });
            this.beT.quitLiveShow();
        }
    }

    @Override // com.baidu.c.a.b.a.b
    public void AY() {
        fn(this.mCastId);
    }

    @Override // com.baidu.c.a.b.a.b
    public void a(final String str, e eVar, final f fVar) {
        if (this.beT != null && eVar != null) {
            this.beT.a(eVar, (g) null, new com.baidu.c.a.b.f() { // from class: com.baidu.c.b.a.a.a.4
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
        this.beT.a(str, this.beX, new com.baidu.c.a.b.e() { // from class: com.baidu.c.b.a.a.a.5
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

    public boolean Ig() {
        return this.beW;
    }
}
