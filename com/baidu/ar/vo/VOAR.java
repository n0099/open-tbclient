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
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes11.dex */
public class VOAR extends c {
    private static final String TAG = VOAR.class.getSimpleName();
    private com.baidu.ar.lua.c qR;
    private g rm;
    private com.baidu.ar.vo.a.b wW;
    private e wX;
    private com.baidu.ar.c.e wY;
    private com.baidu.ar.vo.b.c wZ;
    private b xa;
    private f xb;

    private com.baidu.ar.vo.c.g a(d dVar) {
        com.baidu.ar.vo.c.g gVar = new com.baidu.ar.vo.c.g(r(), this.wW, this.wZ, new a() { // from class: com.baidu.ar.vo.VOAR.3
            @Override // com.baidu.ar.vo.a
            public void b(int i, HashMap<String, Object> hashMap) {
                VOAR.this.b(i, hashMap);
            }

            @Override // com.baidu.ar.vo.a
            public void d(HashMap<String, Object> hashMap) {
                VOAR.this.d(hashMap);
            }
        });
        gVar.setPreviewSize(dVar.xC, dVar.xD);
        return gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, int i2, HashMap<String, Object> hashMap) {
        if (this.xa == null) {
            return;
        }
        switch (i) {
            case 401:
                if (this.xa == null || hashMap == null || !(hashMap.get("app_type") instanceof String)) {
                    return;
                }
                this.xa.W("None".equals((String) hashMap.get("app_type")));
                return;
            case ARPMessageType.MSG_TYPE_LUA_SDK_BRIDGE /* 1901 */:
                if (hashMap != null) {
                    int a = com.baidu.ar.arplay.c.c.a(hashMap.get("id"), -1);
                    if (4100 == a) {
                        com.baidu.ar.vo.c.b u = u(hashMap);
                        u.xM = true;
                        this.xa.a(u);
                        return;
                    } else if (4200 == a) {
                        this.xa.start();
                        return;
                    } else {
                        return;
                    }
                }
                return;
            case 4100:
                com.baidu.ar.vo.c.b u2 = u(hashMap);
                u2.xM = false;
                this.xa.a(u2);
                return;
            default:
                return;
        }
    }

    private d fI() {
        d dVar = new d();
        dVar.xC = PlatformPlugin.DEFAULT_SYSTEM_UI;
        dVar.xD = 720;
        dVar.xE = new d.a() { // from class: com.baidu.ar.vo.VOAR.2
            @Override // com.baidu.ar.vo.b.d.a
            public float[] fM() {
                return VOAR.this.fM();
            }

            @Override // com.baidu.ar.vo.b.d.a
            public float getAngle() {
                return VOAR.this.fN();
            }
        };
        return dVar;
    }

    private void fJ() {
        a(this.wX);
        if (this.qR != null) {
            b(this.qR);
            this.qR = null;
        }
        if (this.rm != null) {
            a(this.rm);
            this.rm = null;
        }
        this.wX = null;
        this.wY = null;
        if (this.xa != null) {
            this.xa.release();
            this.xa = null;
        }
        if (this.wZ != null) {
            this.wZ.release();
            this.wZ = null;
        }
    }

    private com.baidu.ar.lua.c fK() {
        return new com.baidu.ar.lua.c() { // from class: com.baidu.ar.vo.VOAR.5
            @Override // com.baidu.ar.lua.c
            public void a(final int i, final int i2, final HashMap<String, Object> hashMap) {
                p.runOnUiThread(new Runnable() { // from class: com.baidu.ar.vo.VOAR.5.1
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
                arrayList.add(Integer.valueOf((int) ARPMessageType.MSG_TYPE_LUA_SDK_BRIDGE));
                return arrayList;
            }
        };
    }

    private void fL() {
        i iVar = new i();
        iVar.b(com.baidu.ar.imu.b.WORLD);
        iVar.J(0);
        iVar.H(false);
        iVar.I(true);
        this.rm = new g() { // from class: com.baidu.ar.vo.VOAR.6
            @Override // com.baidu.ar.imu.g
            public void onImuUpdate(f fVar) {
                VOAR.this.xb = fVar;
            }
        };
        a(iVar, this.rm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float[] fM() {
        if (this.xb == null) {
            return null;
        }
        return this.xb.getMatrix();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float fN() {
        return (this.xb == null ? null : Float.valueOf(this.xb.getAngle())).floatValue();
    }

    private com.baidu.ar.vo.c.b u(HashMap<String, Object> hashMap) {
        com.baidu.ar.vo.c.b bVar = new com.baidu.ar.vo.c.b();
        bVar.x = ((Float) hashMap.get(Config.EVENT_HEAT_X)).floatValue();
        bVar.y = ((Float) hashMap.get("y")).floatValue();
        bVar.type = ((Integer) hashMap.get("type")).intValue();
        bVar.xL = ((Float) hashMap.get("distance")).floatValue();
        bVar.xM = true;
        return bVar;
    }

    @Override // com.baidu.ar.c
    public void onCaseCreate(String str) {
        fL();
        r().m(true);
        r().n(true);
        r().a(56.144978f);
        r().a(new ARPEngine.e() { // from class: com.baidu.ar.vo.VOAR.4
            @Override // com.baidu.ar.arplay.core.engine.ARPEngine.e
            public void a(float f, float f2, float f3) {
                if (VOAR.this.xa != null) {
                    VOAR.this.xa.c(f, f2, f3);
                }
            }
        });
        a(this.wX, this.wY);
    }

    @Override // com.baidu.ar.c
    public void onCaseDestroy() {
    }

    @Override // com.baidu.ar.c
    public void release() {
        fJ();
        super.release();
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        super.setup(hashMap);
        this.wW = com.baidu.ar.vo.a.a.aP(r().bs());
        d fI = fI();
        this.wZ = new com.baidu.ar.vo.b.c(fI);
        this.wX = new e(this.wW, this.wZ);
        this.wY = new com.baidu.ar.c.e() { // from class: com.baidu.ar.vo.VOAR.1
            private int xc = 0;

            @Override // com.baidu.ar.c.e
            public void a(com.baidu.ar.c.b bVar) {
                if (VOAR.this.xa == null || bVar == null || !(bVar instanceof com.baidu.ar.vo.b.f)) {
                    return;
                }
                if (this.xc < 3) {
                    this.xc++;
                    return;
                }
                VOAR.this.xa.a((com.baidu.ar.vo.b.f) bVar, VOAR.this.fM());
            }

            @Override // com.baidu.ar.c.e
            public void a(l lVar) {
                this.xc = 0;
            }

            @Override // com.baidu.ar.c.e
            public void b(l lVar) {
            }
        };
        this.xa = new b(a(fI), this.wW, this.wZ, fI);
        this.qR = fK();
        a(this.qR);
    }
}
