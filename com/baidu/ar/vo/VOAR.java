package com.baidu.ar.vo;

import com.baidu.ar.arplay.core.engine.ARPEngine;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.c;
import com.baidu.ar.d.l;
import com.baidu.ar.g.r;
import com.baidu.ar.imu.f;
import com.baidu.ar.imu.g;
import com.baidu.ar.imu.i;
import com.baidu.ar.vo.b.d;
import com.baidu.ar.vo.b.e;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes10.dex */
public class VOAR extends c {
    private static final String TAG = VOAR.class.getSimpleName();
    private g rR;
    private com.baidu.ar.lua.c rw;
    private f xA;
    private com.baidu.ar.vo.a.b xv;
    private e xw;
    private com.baidu.ar.d.e xx;
    private com.baidu.ar.vo.b.c xy;
    private b xz;

    private com.baidu.ar.vo.c.g a(d dVar) {
        com.baidu.ar.vo.c.g gVar = new com.baidu.ar.vo.c.g(r(), this.xv, this.xy, new a() { // from class: com.baidu.ar.vo.VOAR.3
            @Override // com.baidu.ar.vo.a
            public void b(int i, HashMap<String, Object> hashMap) {
                VOAR.this.b(i, hashMap);
            }

            @Override // com.baidu.ar.vo.a
            public void d(HashMap<String, Object> hashMap) {
                VOAR.this.d(hashMap);
            }
        });
        gVar.setPreviewSize(dVar.yb, dVar.yc);
        return gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, int i2, HashMap<String, Object> hashMap) {
        if (this.xz == null) {
            return;
        }
        switch (i) {
            case 401:
                if (this.xz == null || hashMap == null || !(hashMap.get("app_type") instanceof String)) {
                    return;
                }
                this.xz.W("None".equals((String) hashMap.get("app_type")));
                return;
            case ARPMessageType.MSG_TYPE_LUA_SDK_BRIDGE /* 1901 */:
                if (hashMap != null) {
                    int a = com.baidu.ar.arplay.c.c.a(hashMap.get("id"), -1);
                    if (4100 == a) {
                        com.baidu.ar.vo.c.b s = s(hashMap);
                        s.yl = true;
                        this.xz.a(s);
                        return;
                    } else if (4200 == a) {
                        this.xz.start();
                        return;
                    } else {
                        return;
                    }
                }
                return;
            case 4100:
                com.baidu.ar.vo.c.b s2 = s(hashMap);
                s2.yl = false;
                this.xz.a(s2);
                return;
            default:
                return;
        }
    }

    private d gX() {
        d dVar = new d();
        dVar.yb = PlatformPlugin.DEFAULT_SYSTEM_UI;
        dVar.yc = 720;
        dVar.yd = new d.a() { // from class: com.baidu.ar.vo.VOAR.2
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
        a(this.xw);
        if (this.rw != null) {
            b(this.rw);
            this.rw = null;
        }
        if (this.rR != null) {
            a(this.rR);
            this.rR = null;
        }
        this.xw = null;
        this.xx = null;
        if (this.xz != null) {
            this.xz.release();
            this.xz = null;
        }
        if (this.xy != null) {
            this.xy.release();
            this.xy = null;
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
                arrayList.add(Integer.valueOf((int) ARPMessageType.MSG_TYPE_LUA_SDK_BRIDGE));
                return arrayList;
            }
        };
    }

    private void ha() {
        i iVar = new i();
        iVar.b(com.baidu.ar.imu.b.WORLD);
        iVar.L(0);
        iVar.I(false);
        iVar.J(true);
        this.rR = new g() { // from class: com.baidu.ar.vo.VOAR.6
            @Override // com.baidu.ar.imu.g
            public void onImuUpdate(f fVar) {
                VOAR.this.xA = fVar;
            }
        };
        a(iVar, this.rR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float[] hb() {
        if (this.xA == null) {
            return null;
        }
        return this.xA.getMatrix();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float hc() {
        return (this.xA == null ? null : Float.valueOf(this.xA.getAngle())).floatValue();
    }

    private com.baidu.ar.vo.c.b s(HashMap<String, Object> hashMap) {
        com.baidu.ar.vo.c.b bVar = new com.baidu.ar.vo.c.b();
        bVar.x = ((Float) hashMap.get("x")).floatValue();
        bVar.y = ((Float) hashMap.get("y")).floatValue();
        bVar.type = ((Integer) hashMap.get("type")).intValue();
        bVar.yk = ((Float) hashMap.get("distance")).floatValue();
        bVar.yl = true;
        return bVar;
    }

    @Override // com.baidu.ar.c
    public void onCaseCreate(String str) {
        ha();
        r().n(true);
        r().o(true);
        r().a(56.144978f);
        r().a(new ARPEngine.d() { // from class: com.baidu.ar.vo.VOAR.4
            @Override // com.baidu.ar.arplay.core.engine.ARPEngine.d
            public void a(float f, float f2, float f3) {
                if (VOAR.this.xz != null) {
                    VOAR.this.xz.c(f, f2, f3);
                }
            }
        });
        a(this.xw, this.xx);
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
        this.xv = com.baidu.ar.vo.a.a.aT(r().bA());
        d gX = gX();
        this.xy = new com.baidu.ar.vo.b.c(gX);
        this.xw = new e(this.xv, this.xy);
        this.xx = new com.baidu.ar.d.e() { // from class: com.baidu.ar.vo.VOAR.1
            private int xB = 0;

            @Override // com.baidu.ar.d.e
            public void a(com.baidu.ar.d.b bVar) {
                if (VOAR.this.xz == null || bVar == null || !(bVar instanceof com.baidu.ar.vo.b.f)) {
                    return;
                }
                if (this.xB < 3) {
                    this.xB++;
                    return;
                }
                VOAR.this.xz.a((com.baidu.ar.vo.b.f) bVar, VOAR.this.hb());
            }

            @Override // com.baidu.ar.d.e
            public void a(l lVar) {
                this.xB = 0;
            }

            @Override // com.baidu.ar.d.e
            public void b(l lVar) {
            }
        };
        this.xz = new b(a(gX), this.xv, this.xy, gX);
        this.rw = gZ();
        a(this.rw);
    }
}
