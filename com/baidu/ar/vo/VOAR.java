package com.baidu.ar.vo;

import com.baidu.ar.arplay.core.engine.ARPDataInteraction;
import com.baidu.ar.c;
import com.baidu.ar.d.l;
import com.baidu.ar.h.r;
import com.baidu.ar.imu.f;
import com.baidu.ar.imu.g;
import com.baidu.ar.imu.i;
import com.baidu.ar.vo.b.d;
import com.baidu.ar.vo.b.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class VOAR extends c {
    public static final String TAG = "VOAR";
    public com.baidu.ar.lua.c rN;
    public g si;
    public com.baidu.ar.vo.a.b yk;
    public e yl;
    public com.baidu.ar.d.e ym;
    public com.baidu.ar.vo.b.c yn;
    public b yo;
    public f yp;

    private com.baidu.ar.vo.c.g a(d dVar) {
        com.baidu.ar.vo.c.g gVar = new com.baidu.ar.vo.c.g(r(), this.yk, this.yn, new a() { // from class: com.baidu.ar.vo.VOAR.3
            @Override // com.baidu.ar.vo.a
            public void b(int i, HashMap<String, Object> hashMap) {
                VOAR.this.b(i, hashMap);
            }

            @Override // com.baidu.ar.vo.a
            public void d(HashMap<String, Object> hashMap) {
                VOAR.this.d(hashMap);
            }
        });
        gVar.setPreviewSize(dVar.yQ, dVar.yR);
        return gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, int i2, HashMap<String, Object> hashMap) {
        com.baidu.ar.vo.c.b s;
        boolean z;
        b bVar = this.yo;
        if (bVar == null) {
            return;
        }
        if (i == 401) {
            if (bVar == null || hashMap == null || !(hashMap.get("app_type") instanceof String)) {
                return;
            }
            this.yo.U("None".equals((String) hashMap.get("app_type")));
            return;
        }
        if (i != 1901) {
            if (i != 4100) {
                return;
            }
            s = s(hashMap);
            z = false;
        } else if (hashMap == null) {
            return;
        } else {
            int a = com.baidu.ar.arplay.c.c.a(hashMap.get("id"), -1);
            if (4100 != a) {
                if (4200 == a) {
                    this.yo.start();
                    return;
                }
                return;
            }
            s = s(hashMap);
            z = true;
        }
        s.za = z;
        this.yo.a(s);
    }

    private d gX() {
        d dVar = new d();
        dVar.yQ = 1280;
        dVar.yR = 720;
        dVar.yS = new d.a() { // from class: com.baidu.ar.vo.VOAR.2
            @Override // com.baidu.ar.vo.b.d.a
            public float getAngle() {
                return VOAR.this.hc();
            }

            @Override // com.baidu.ar.vo.b.d.a
            public float[] hb() {
                return VOAR.this.hb();
            }
        };
        return dVar;
    }

    private void gY() {
        a(this.yl);
        com.baidu.ar.lua.c cVar = this.rN;
        if (cVar != null) {
            b(cVar);
            this.rN = null;
        }
        g gVar = this.si;
        if (gVar != null) {
            a(gVar);
            this.si = null;
        }
        this.yl = null;
        this.ym = null;
        b bVar = this.yo;
        if (bVar != null) {
            bVar.release();
            this.yo = null;
        }
        com.baidu.ar.vo.b.c cVar2 = this.yn;
        if (cVar2 != null) {
            cVar2.release();
            this.yn = null;
        }
    }

    private com.baidu.ar.lua.c gZ() {
        return new com.baidu.ar.lua.c() { // from class: com.baidu.ar.vo.VOAR.5
            @Override // com.baidu.ar.lua.c
            public void a(final int i, final int i2, final HashMap<String, Object> hashMap) {
                r.runOnUiThread(new Runnable() { // from class: com.baidu.ar.vo.VOAR.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        VOAR.this.c(i, i2, hashMap);
                    }
                });
            }

            @Override // com.baidu.ar.lua.c
            public List<Integer> n() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(401);
                arrayList.add(4100);
                arrayList.add(1901);
                return arrayList;
            }
        };
    }

    private void ha() {
        i iVar = new i();
        iVar.b(com.baidu.ar.imu.b.WORLD);
        iVar.N(0);
        iVar.G(false);
        iVar.H(true);
        g gVar = new g() { // from class: com.baidu.ar.vo.VOAR.6
            @Override // com.baidu.ar.imu.g
            public void onImuUpdate(f fVar) {
                VOAR.this.yp = fVar;
            }
        };
        this.si = gVar;
        a(iVar, gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float[] hb() {
        f fVar = this.yp;
        if (fVar == null) {
            return null;
        }
        return fVar.getMatrix();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float hc() {
        f fVar = this.yp;
        return (fVar == null ? null : Float.valueOf(fVar.getAngle())).floatValue();
    }

    private com.baidu.ar.vo.c.b s(HashMap<String, Object> hashMap) {
        com.baidu.ar.vo.c.b bVar = new com.baidu.ar.vo.c.b();
        bVar.x = ((Float) hashMap.get("x")).floatValue();
        bVar.y = ((Float) hashMap.get("y")).floatValue();
        bVar.type = ((Integer) hashMap.get("type")).intValue();
        bVar.yZ = ((Float) hashMap.get("distance")).floatValue();
        bVar.za = true;
        return bVar;
    }

    @Override // com.baidu.ar.c
    public void onCaseCreate(String str) {
        ha();
        r().l(true);
        r().m(true);
        r().setFieldOfView(56.144978f);
        r().initWorldAxis();
        r().a(new ARPDataInteraction.b() { // from class: com.baidu.ar.vo.VOAR.4
            @Override // com.baidu.ar.arplay.core.engine.ARPDataInteraction.b
            public void a(float f, float f2, float f3) {
                if (VOAR.this.yo != null) {
                    VOAR.this.yo.c(f, f2, f3);
                }
            }
        });
        a(this.yl, this.ym);
    }

    @Override // com.baidu.ar.c
    public void onCaseDestroy() {
    }

    @Override // com.baidu.ar.c
    public void release() {
        gY();
        super.release();
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        super.setup(hashMap);
        this.yk = com.baidu.ar.vo.a.a.aW(r().bx());
        d gX = gX();
        this.yn = new com.baidu.ar.vo.b.c(gX);
        this.yl = new e(this.yk, this.yn);
        this.ym = new com.baidu.ar.d.e() { // from class: com.baidu.ar.vo.VOAR.1
            public int yq = 0;

            @Override // com.baidu.ar.d.e
            public void a(com.baidu.ar.d.b bVar) {
                if (VOAR.this.yo == null || bVar == null || !(bVar instanceof com.baidu.ar.vo.b.f)) {
                    return;
                }
                int i = this.yq;
                if (i < 3) {
                    this.yq = i + 1;
                    return;
                }
                VOAR.this.yo.a((com.baidu.ar.vo.b.f) bVar, VOAR.this.hb());
            }

            @Override // com.baidu.ar.d.e
            public void a(l lVar) {
                this.yq = 0;
            }

            @Override // com.baidu.ar.d.e
            public void b(l lVar) {
            }
        };
        this.yo = new b(a(gX), this.yk, this.yn, gX);
        com.baidu.ar.lua.c gZ = gZ();
        this.rN = gZ;
        a(gZ);
    }
}
