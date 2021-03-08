package com.baidu.ar.child;

import android.text.TextUtils;
import com.baidu.ala.dumixar.utils.LuaMessageHelper;
import com.baidu.ar.child.a;
import com.baidu.ar.child.a.d;
import com.baidu.ar.child.a.e;
import com.baidu.ar.child.b.b;
import com.baidu.ar.d.k;
import com.baidu.ar.d.l;
import com.baidu.ar.databasic.AlgoHandleController;
import com.baidu.ar.lua.LuaMsgListener;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class ChildAR extends com.baidu.ar.c implements LuaMsgListener {
    private com.baidu.ar.child.a.b lA;
    private com.baidu.ar.child.b.b lB;
    private boolean lC;
    private e lD;
    private a lz;
    private String bD = null;
    private AlgoHandleController cb = null;
    private com.baidu.ar.d.e lE = new com.baidu.ar.d.e() { // from class: com.baidu.ar.child.ChildAR.1
        @Override // com.baidu.ar.d.e
        public void a(com.baidu.ar.d.b bVar) {
            if (ChildAR.this.lz == null || ChildAR.this.lC) {
                if (ChildAR.this.cb != null) {
                    ChildAR.this.cb.destroyHandle(bVar.de());
                    return;
                }
                return;
            }
            if (ChildAR.this.cb.getHandleType(bVar.de()) == 10) {
                long createHandle = ChildAR.this.cb.createHandle();
                ChildAR.this.lD = new e();
                if (ChildAR.this.lz != null) {
                    ChildAR.this.lD.e(ChildAR.this.lz.j(bVar.de()));
                    ChildAR.this.lD.d(ChildAR.this.lz.i(bVar.de()));
                    ChildAR.this.lD.g(createHandle);
                }
            }
            if (ChildAR.this.cb != null && !ChildAR.this.lC) {
                ChildAR.this.cb.destroyHandle(bVar.de());
            }
            ChildAR.this.cP();
        }

        @Override // com.baidu.ar.d.e
        public void a(l lVar) {
        }

        @Override // com.baidu.ar.d.e
        public void b(l lVar) {
        }
    };

    private void a(final float f, final d dVar) {
        a(dVar, new com.baidu.ar.d.e() { // from class: com.baidu.ar.child.ChildAR.3
            @Override // com.baidu.ar.d.e
            public void a(com.baidu.ar.d.b bVar) {
                if (bVar != null && (bVar instanceof com.baidu.ar.child.a.c)) {
                    com.baidu.ar.child.a.c cVar = (com.baidu.ar.child.a.c) bVar;
                    if (cVar == null || cVar.cW() == null) {
                        return;
                    }
                    long createHandle = ChildAR.this.cb.createHandle();
                    ChildAR.this.lz.k(createHandle);
                    ChildAR.this.lz.a(createHandle, cVar.cW(), ChildAR.this.mInputHeight, ChildAR.this.mInputWidth, f);
                    com.baidu.ar.arrender.l r = ChildAR.this.r();
                    if (r != null && createHandle > 0 && ChildAR.this.cb != null) {
                        if (ChildAR.this.lC) {
                            return;
                        }
                        ChildAR.this.cb.sendHandleToRenderer(createHandle, r, "ability_face_child");
                    }
                }
                ChildAR.this.b(dVar);
            }

            @Override // com.baidu.ar.d.e
            public void a(l lVar) {
            }

            @Override // com.baidu.ar.d.e
            public void b(l lVar) {
            }
        });
    }

    private void a(String str, float f) {
        d dVar = new d();
        dVar.v(str);
        cO();
        b(f);
        a(f, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(byte[] bArr, long j) {
        com.baidu.ar.arrender.l r;
        if (this.lz == null || this.lC || j <= 0) {
            return;
        }
        this.lz.a(j, bArr);
        if (TextUtils.isEmpty(this.bD) || (r = r()) == null || j <= 0 || this.cb == null) {
            return;
        }
        this.cb.sendHandleToRenderer(j, r, "ability_face_child");
    }

    private void b(final float f) {
        this.lA = new com.baidu.ar.child.a.b();
        a(this.lA, new com.baidu.ar.d.e() { // from class: com.baidu.ar.child.ChildAR.4
            @Override // com.baidu.ar.d.e
            public void a(com.baidu.ar.d.b bVar) {
                if (ChildAR.this.lC || ChildAR.this.lz == null || ChildAR.this.lD == null || !(bVar instanceof com.baidu.ar.child.a.a)) {
                    return;
                }
                ChildAR.this.lz.k(ChildAR.this.lD.cY());
                b bVar2 = new b((com.baidu.ar.child.a.a) bVar, f);
                bVar2.a(ChildAR.this.lD);
                ChildAR.this.lz.a(bVar2);
                ChildAR.this.b(ChildAR.this.lA);
            }

            @Override // com.baidu.ar.d.e
            public void a(l lVar) {
            }

            @Override // com.baidu.ar.d.e
            public void b(l lVar) {
            }
        });
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

    private void cO() {
        a("FaceDetector", this.lE, (HashMap<String, Object>) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cP() {
        if (this.lE != null) {
            a("FaceDetector", this.lE);
        }
    }

    private void i(HashMap<String, Object> hashMap) {
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
        if (j <= 0 || this.cb == null || this.cb.getHandleType(j) != 20) {
            return;
        }
        this.cb.destroyHandle(j);
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
        if (this.lC || hashMap == null || hashMap.keySet().size() < 1) {
            return;
        }
        i(hashMap);
    }

    @Override // com.baidu.ar.c
    public void pause() {
        super.pause();
    }

    @Override // com.baidu.ar.c
    public void release() {
        super.release();
        this.lC = !this.lC;
        if (this.lA != null) {
            this.lA = null;
        }
        if (this.cb != null) {
            this.cb.release();
            this.cb = null;
        }
        if (this.lz != null && !this.lC) {
            this.lz.a((a.InterfaceC0083a) null);
            this.lz.cQ();
            this.lz = null;
        }
        com.baidu.ar.arrender.l r = r();
        if (r != null) {
            r.q(20);
        }
    }

    @Override // com.baidu.ar.c
    public void resume() {
        super.resume();
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        if (this.cb == null) {
            this.cb = new AlgoHandleController();
        }
        this.bD = (String) hashMap.get("ability_name");
        this.lz = new a(this.mInputWidth, this.mInputHeight);
        this.lB = new com.baidu.ar.child.b.b();
        this.lz.a(new a.InterfaceC0083a() { // from class: com.baidu.ar.child.ChildAR.2
            @Override // com.baidu.ar.child.a.InterfaceC0083a
            public void a(final long j, byte[] bArr, int i) {
                if (bArr == null || bArr.length <= 0) {
                    return;
                }
                ChildAR.this.lB.a(bArr, i, new b.a() { // from class: com.baidu.ar.child.ChildAR.2.1
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
        com.baidu.ar.arrender.l r = r();
        if (r != null) {
            r.b(20, false);
        }
    }
}
