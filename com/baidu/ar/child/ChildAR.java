package com.baidu.ar.child;

import android.text.TextUtils;
import com.baidu.ala.dumixar.utils.LuaMessageHelper;
import com.baidu.ar.arrender.j;
import com.baidu.ar.c.k;
import com.baidu.ar.c.l;
import com.baidu.ar.child.a;
import com.baidu.ar.child.a.d;
import com.baidu.ar.child.a.e;
import com.baidu.ar.child.b.b;
import com.baidu.ar.databasic.AlgoHandleController;
import com.baidu.ar.lua.LuaMsgListener;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes11.dex */
public class ChildAR extends com.baidu.ar.c implements LuaMsgListener {
    private a kB;
    private com.baidu.ar.child.a.b kC;
    private com.baidu.ar.child.b.b kD;
    private boolean kE;
    private e kF;
    private String bJ = null;
    private AlgoHandleController ch = null;
    private com.baidu.ar.c.e kG = new com.baidu.ar.c.e() { // from class: com.baidu.ar.child.ChildAR.1
        @Override // com.baidu.ar.c.e
        public void a(com.baidu.ar.c.b bVar) {
            if (ChildAR.this.kB == null || ChildAR.this.kE) {
                if (ChildAR.this.ch != null) {
                    ChildAR.this.ch.destroyHandle(bVar.cF());
                    return;
                }
                return;
            }
            if (ChildAR.this.ch.getHandleType(bVar.cF()) == 10) {
                long createHandle = ChildAR.this.ch.createHandle();
                ChildAR.this.kF = new e();
                if (ChildAR.this.kB != null) {
                    ChildAR.this.kF.f(ChildAR.this.kB.l(bVar.cF()));
                    ChildAR.this.kF.e(ChildAR.this.kB.k(bVar.cF()));
                    ChildAR.this.kF.i(createHandle);
                }
            }
            if (ChildAR.this.ch != null && !ChildAR.this.kE) {
                ChildAR.this.ch.destroyHandle(bVar.cF());
            }
            ChildAR.this.cq();
        }

        @Override // com.baidu.ar.c.e
        public void a(l lVar) {
        }

        @Override // com.baidu.ar.c.e
        public void b(l lVar) {
        }
    };

    private void a(final float f, final d dVar) {
        a(dVar, new com.baidu.ar.c.e() { // from class: com.baidu.ar.child.ChildAR.3
            @Override // com.baidu.ar.c.e
            public void a(com.baidu.ar.c.b bVar) {
                if (bVar != null && (bVar instanceof com.baidu.ar.child.a.c)) {
                    com.baidu.ar.child.a.c cVar = (com.baidu.ar.child.a.c) bVar;
                    if (cVar == null || cVar.cx() == null) {
                        return;
                    }
                    long createHandle = ChildAR.this.ch.createHandle();
                    ChildAR.this.kB.m(createHandle);
                    ChildAR.this.kB.a(createHandle, cVar.cx(), ChildAR.this.S, ChildAR.this.R, f);
                    j r = ChildAR.this.r();
                    if (r != null && createHandle > 0 && ChildAR.this.ch != null) {
                        if (ChildAR.this.kE) {
                            return;
                        }
                        ChildAR.this.ch.sendHandleToRenderer(createHandle, r, "ability_face_child");
                    }
                }
                ChildAR.this.b(dVar);
            }

            @Override // com.baidu.ar.c.e
            public void a(l lVar) {
            }

            @Override // com.baidu.ar.c.e
            public void b(l lVar) {
            }
        });
    }

    private void a(String str, float f) {
        d dVar = new d();
        dVar.s(str);
        cp();
        c(f);
        a(f, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(byte[] bArr, long j) {
        j r;
        if (this.kB == null || this.kE || j <= 0) {
            return;
        }
        this.kB.a(j, bArr);
        if (TextUtils.isEmpty(this.bJ) || (r = r()) == null || j <= 0 || this.ch == null) {
            return;
        }
        this.ch.sendHandleToRenderer(j, r, "ability_face_child");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final k kVar) {
        if (kVar == null) {
            return;
        }
        new Thread(new Runnable() { // from class: com.baidu.ar.child.ChildAR.5
            @Override // java.lang.Runnable
            public void run() {
                ChildAR.this.a(kVar);
            }
        }).start();
    }

    private void c(final float f) {
        this.kC = new com.baidu.ar.child.a.b();
        a(this.kC, new com.baidu.ar.c.e() { // from class: com.baidu.ar.child.ChildAR.4
            @Override // com.baidu.ar.c.e
            public void a(com.baidu.ar.c.b bVar) {
                if (ChildAR.this.kE || ChildAR.this.kB == null || ChildAR.this.kF == null || !(bVar instanceof com.baidu.ar.child.a.a)) {
                    return;
                }
                ChildAR.this.kB.m(ChildAR.this.kF.cz());
                b bVar2 = new b((com.baidu.ar.child.a.a) bVar, f);
                bVar2.a(ChildAR.this.kF);
                ChildAR.this.kB.a(bVar2);
                ChildAR.this.b(ChildAR.this.kC);
            }

            @Override // com.baidu.ar.c.e
            public void a(l lVar) {
            }

            @Override // com.baidu.ar.c.e
            public void b(l lVar) {
            }
        });
    }

    private void cp() {
        a("FaceDetector", this.kG, (HashMap<String, Object>) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cq() {
        if (this.kG != null) {
            a("FaceDetector", this.kG);
        }
    }

    private void j(HashMap<String, Object> hashMap) {
        if (hashMap.containsKey("case_texture")) {
            String str = (String) hashMap.get("case_texture");
            if (hashMap.containsKey("excute_frame")) {
                float floatValue = ((Float) hashMap.get("excute_frame")).floatValue();
                if (hashMap.containsKey("index")) {
                    float floatValue2 = ((Float) hashMap.get("index")).floatValue();
                    if (floatValue != 1.0f || TextUtils.isEmpty(str)) {
                        return;
                    }
                    a(str, floatValue2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.c
    public void a(long j) {
        super.a(j);
        if (j <= 0 || this.ch == null || this.ch.getHandleType(j) != 20) {
            return;
        }
        this.ch.destroyHandle(j);
    }

    @Override // com.baidu.ar.c
    public void adjust(HashMap<String, Object> hashMap) {
        super.adjust(hashMap);
    }

    @Override // com.baidu.ar.lua.LuaMsgListener
    public List<String> getMsgKeyListened() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(LuaMessageHelper.KEY_EVENT_NAME);
        return arrayList;
    }

    @Override // com.baidu.ar.lua.LuaMsgListener
    public void onLuaMessage(HashMap<String, Object> hashMap) {
        if (this.kE || hashMap == null || hashMap.keySet().size() < 1) {
            return;
        }
        j(hashMap);
    }

    @Override // com.baidu.ar.c
    public void pause() {
        super.pause();
    }

    @Override // com.baidu.ar.c
    public void release() {
        super.release();
        this.kE = !this.kE;
        if (this.kC != null) {
            this.kC = null;
        }
        if (this.ch != null) {
            this.ch.release();
            this.ch = null;
        }
        if (this.kB != null && !this.kE) {
            this.kB.a((a.InterfaceC0082a) null);
            this.kB.cr();
            this.kB = null;
        }
        j r = r();
        if (r != null) {
            r.r(20);
        }
    }

    @Override // com.baidu.ar.c
    public void resume() {
        super.resume();
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        if (this.ch == null) {
            this.ch = new AlgoHandleController();
        }
        this.bJ = (String) hashMap.get("ability_name");
        this.kB = new a(this.R, this.S);
        this.kD = new com.baidu.ar.child.b.b();
        this.kB.a(new a.InterfaceC0082a() { // from class: com.baidu.ar.child.ChildAR.2
            @Override // com.baidu.ar.child.a.InterfaceC0082a
            public void a(final long j, byte[] bArr, int i) {
                if (bArr == null || bArr.length <= 0) {
                    return;
                }
                ChildAR.this.kD.a(bArr, i, new b.a() { // from class: com.baidu.ar.child.ChildAR.2.1
                    @Override // com.baidu.ar.child.b.b.a
                    public void e(byte[] bArr2) {
                        if (bArr2 == null) {
                            return;
                        }
                        StatisticApi.onEvent(StatisticConstants.EVENT_FACE2CHILD_CASEUSE);
                        ChildAR.this.a(bArr2, j);
                    }
                });
            }
        });
        a((LuaMsgListener) this);
        j r = r();
        if (r != null) {
            r.a(20, false);
        }
    }
}
