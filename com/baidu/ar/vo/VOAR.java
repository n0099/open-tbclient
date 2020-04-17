package com.baidu.ar.vo;

import com.baidu.ar.arplay.core.engine.ARPEngine;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.c;
import com.baidu.ar.c.l;
import com.baidu.ar.f.p;
import com.baidu.ar.imu.f;
import com.baidu.ar.imu.g;
import com.baidu.ar.imu.i;
import com.baidu.ar.vo.b.d;
import com.baidu.ar.vo.b.e;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class VOAR extends c {
    private static final String TAG = VOAR.class.getSimpleName();
    private g qN;
    private com.baidu.ar.lua.c qs;
    private b wA;
    private f wB;
    private com.baidu.ar.vo.a.b ww;
    private e wx;
    private com.baidu.ar.c.e wy;
    private com.baidu.ar.vo.b.c wz;

    private com.baidu.ar.vo.c.g a(d dVar) {
        com.baidu.ar.vo.c.g gVar = new com.baidu.ar.vo.c.g(r(), this.ww, this.wz, new a() { // from class: com.baidu.ar.vo.VOAR.3
            @Override // com.baidu.ar.vo.a
            public void b(int i, HashMap<String, Object> hashMap) {
                VOAR.this.b(i, hashMap);
            }

            @Override // com.baidu.ar.vo.a
            public void d(HashMap<String, Object> hashMap) {
                VOAR.this.d(hashMap);
            }
        });
        gVar.setPreviewSize(dVar.xc, dVar.xd);
        return gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, HashMap<String, Object> hashMap) {
        if (this.wA == null) {
            return;
        }
        switch (i) {
            case 401:
                if (this.wA == null || hashMap == null || !(hashMap.get("app_type") instanceof String)) {
                    return;
                }
                this.wA.V("None".equals((String) hashMap.get("app_type")));
                return;
            case ARPMessageType.MSG_TYPE_LUA_SDK_BRIDGE /* 1901 */:
                if (hashMap != null) {
                    int a = com.baidu.ar.arplay.c.c.a(hashMap.get("id"), -1);
                    if (4100 == a) {
                        com.baidu.ar.vo.c.b u = u(hashMap);
                        u.xm = true;
                        this.wA.a(u);
                        return;
                    } else if (4200 == a) {
                        this.wA.start();
                        return;
                    } else {
                        return;
                    }
                }
                return;
            case 4100:
                com.baidu.ar.vo.c.b u2 = u(hashMap);
                u2.xm = false;
                this.wA.a(u2);
                return;
            default:
                return;
        }
    }

    private d fs() {
        d dVar = new d();
        dVar.xc = 1280;
        dVar.xd = 720;
        dVar.xe = new d.a() { // from class: com.baidu.ar.vo.VOAR.2
            @Override // com.baidu.ar.vo.b.d.a
            public float[] fw() {
                return VOAR.this.fw();
            }

            @Override // com.baidu.ar.vo.b.d.a
            public float getAngle() {
                return VOAR.this.fx();
            }
        };
        return dVar;
    }

    private void ft() {
        a(this.wx);
        if (this.qs != null) {
            b(this.qs);
            this.qs = null;
        }
        if (this.qN != null) {
            a(this.qN);
            this.qN = null;
        }
        this.wx = null;
        this.wy = null;
        if (this.wA != null) {
            this.wA.release();
            this.wA = null;
        }
        if (this.wz != null) {
            this.wz.release();
            this.wz = null;
        }
    }

    private com.baidu.ar.lua.c fu() {
        return new com.baidu.ar.lua.c() { // from class: com.baidu.ar.vo.VOAR.5
            @Override // com.baidu.ar.lua.c
            public void a(final int i, final int i2, final HashMap<String, Object> hashMap) {
                p.runOnUiThread(new Runnable() { // from class: com.baidu.ar.vo.VOAR.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        VOAR.this.b(i, i2, hashMap);
                    }
                });
            }

            @Override // com.baidu.ar.lua.c
            public List<Integer> n() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(401);
                arrayList.add(4100);
                arrayList.add(Integer.valueOf((int) ARPMessageType.MSG_TYPE_LUA_SDK_BRIDGE));
                return arrayList;
            }
        };
    }

    private void fv() {
        i iVar = new i();
        iVar.b(com.baidu.ar.imu.b.WORLD);
        iVar.D(0);
        iVar.H(false);
        iVar.I(true);
        this.qN = new g() { // from class: com.baidu.ar.vo.VOAR.6
            @Override // com.baidu.ar.imu.g
            public void onImuUpdate(f fVar) {
                VOAR.this.wB = fVar;
            }
        };
        a(iVar, this.qN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float[] fw() {
        if (this.wB == null) {
            return null;
        }
        return this.wB.getMatrix();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float fx() {
        return (this.wB == null ? null : Float.valueOf(this.wB.getAngle())).floatValue();
    }

    private com.baidu.ar.vo.c.b u(HashMap<String, Object> hashMap) {
        com.baidu.ar.vo.c.b bVar = new com.baidu.ar.vo.c.b();
        bVar.x = ((Float) hashMap.get(Config.EVENT_HEAT_X)).floatValue();
        bVar.y = ((Float) hashMap.get("y")).floatValue();
        bVar.type = ((Integer) hashMap.get("type")).intValue();
        bVar.xl = ((Float) hashMap.get("distance")).floatValue();
        bVar.xm = true;
        return bVar;
    }

    @Override // com.baidu.ar.c
    public void onCaseCreate(String str) {
        fv();
        r().n(true);
        r().o(true);
        r().a(56.144978f);
        r().a(new ARPEngine.g() { // from class: com.baidu.ar.vo.VOAR.4
            @Override // com.baidu.ar.arplay.core.engine.ARPEngine.g
            public void a(float f, float f2, float f3) {
                if (VOAR.this.wA != null) {
                    VOAR.this.wA.c(f, f2, f3);
                }
            }
        });
        a(this.wx, this.wy);
    }

    @Override // com.baidu.ar.c
    public void onCaseDestroy() {
    }

    @Override // com.baidu.ar.c
    public void release() {
        ft();
        super.release();
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        super.setup(hashMap);
        this.ww = com.baidu.ar.vo.a.a.aO(r().be());
        d fs = fs();
        this.wz = new com.baidu.ar.vo.b.c(fs);
        this.wx = new e(this.ww, this.wz);
        this.wy = new com.baidu.ar.c.e() { // from class: com.baidu.ar.vo.VOAR.1
            private int wC = 0;

            @Override // com.baidu.ar.c.e
            public void a(com.baidu.ar.c.b bVar) {
                if (VOAR.this.wA == null || bVar == null || !(bVar instanceof com.baidu.ar.vo.b.f)) {
                    return;
                }
                if (this.wC < 3) {
                    this.wC++;
                    return;
                }
                VOAR.this.wA.a((com.baidu.ar.vo.b.f) bVar, VOAR.this.fw());
            }

            @Override // com.baidu.ar.c.e
            public void a(l lVar) {
                this.wC = 0;
            }

            @Override // com.baidu.ar.c.e
            public void b(l lVar) {
            }
        };
        this.wA = new b(a(fs), this.ww, this.wz, fs);
        this.qs = fu();
        a(this.qs);
    }
}
