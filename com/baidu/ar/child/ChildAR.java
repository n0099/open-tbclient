package com.baidu.ar.child;

import android.text.TextUtils;
import com.baidu.ala.dumixar.utils.LuaMessageHelper;
import com.baidu.ar.arrender.k;
import com.baidu.ar.child.a;
import com.baidu.ar.child.a.d;
import com.baidu.ar.child.a.e;
import com.baidu.ar.child.b.b;
import com.baidu.ar.d.l;
import com.baidu.ar.databasic.AlgoHandleController;
import com.baidu.ar.lua.LuaMsgListener;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes10.dex */
public class ChildAR extends com.baidu.ar.c implements LuaMsgListener {
    private a lk;
    private com.baidu.ar.child.a.b ll;
    private com.baidu.ar.child.b.b lm;
    private boolean ln;
    private e lo;
    private String bA = null;
    private AlgoHandleController bY = null;
    private com.baidu.ar.d.e lp = new com.baidu.ar.d.e() { // from class: com.baidu.ar.child.ChildAR.1
        @Override // com.baidu.ar.d.e
        public void a(com.baidu.ar.d.b bVar) {
            if (ChildAR.this.lk == null || ChildAR.this.ln) {
                if (ChildAR.this.bY != null) {
                    ChildAR.this.bY.destroyHandle(bVar.df());
                    return;
                }
                return;
            }
            if (ChildAR.this.bY.getHandleType(bVar.df()) == 10) {
                long createHandle = ChildAR.this.bY.createHandle();
                ChildAR.this.lo = new e();
                if (ChildAR.this.lk != null) {
                    ChildAR.this.lo.f(ChildAR.this.lk.l(bVar.df()));
                    ChildAR.this.lo.e(ChildAR.this.lk.k(bVar.df()));
                    ChildAR.this.lo.i(createHandle);
                }
            }
            if (ChildAR.this.bY != null && !ChildAR.this.ln) {
                ChildAR.this.bY.destroyHandle(bVar.df());
            }
            ChildAR.this.cQ();
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
                    if (cVar == null || cVar.cX() == null) {
                        return;
                    }
                    long createHandle = ChildAR.this.bY.createHandle();
                    ChildAR.this.lk.m(createHandle);
                    ChildAR.this.lk.a(createHandle, cVar.cX(), ChildAR.this.S, ChildAR.this.R, f);
                    k r = ChildAR.this.r();
                    if (r != null && createHandle > 0 && ChildAR.this.bY != null) {
                        if (ChildAR.this.ln) {
                            return;
                        }
                        ChildAR.this.bY.sendHandleToRenderer(createHandle, r, "ability_face_child");
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
        dVar.t(str);
        cP();
        c(f);
        a(f, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(byte[] bArr, long j) {
        k r;
        if (this.lk == null || this.ln || j <= 0) {
            return;
        }
        this.lk.a(j, bArr);
        if (TextUtils.isEmpty(this.bA) || (r = r()) == null || j <= 0 || this.bY == null) {
            return;
        }
        this.bY.sendHandleToRenderer(j, r, "ability_face_child");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.ar.d.k kVar) {
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
        this.ll = new com.baidu.ar.child.a.b();
        a(this.ll, new com.baidu.ar.d.e() { // from class: com.baidu.ar.child.ChildAR.4
            @Override // com.baidu.ar.d.e
            public void a(com.baidu.ar.d.b bVar) {
                if (ChildAR.this.ln || ChildAR.this.lk == null || ChildAR.this.lo == null || !(bVar instanceof com.baidu.ar.child.a.a)) {
                    return;
                }
                ChildAR.this.lk.m(ChildAR.this.lo.cZ());
                b bVar2 = new b((com.baidu.ar.child.a.a) bVar, f);
                bVar2.a(ChildAR.this.lo);
                ChildAR.this.lk.a(bVar2);
                ChildAR.this.b(ChildAR.this.ll);
            }

            @Override // com.baidu.ar.d.e
            public void a(l lVar) {
            }

            @Override // com.baidu.ar.d.e
            public void b(l lVar) {
            }
        });
    }

    private void cP() {
        a("FaceDetector", this.lp, (HashMap<String, Object>) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQ() {
        if (this.lp != null) {
            a("FaceDetector", this.lp);
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
        if (j <= 0 || this.bY == null || this.bY.getHandleType(j) != 20) {
            return;
        }
        this.bY.destroyHandle(j);
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
        if (this.ln || hashMap == null || hashMap.keySet().size() < 1) {
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
        this.ln = !this.ln;
        if (this.ll != null) {
            this.ll = null;
        }
        if (this.bY != null) {
            this.bY.release();
            this.bY = null;
        }
        if (this.lk != null && !this.ln) {
            this.lk.a((a.InterfaceC0081a) null);
            this.lk.cR();
            this.lk = null;
        }
        k r = r();
        if (r != null) {
            r.o(20);
        }
    }

    @Override // com.baidu.ar.c
    public void resume() {
        super.resume();
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        if (this.bY == null) {
            this.bY = new AlgoHandleController();
        }
        this.bA = (String) hashMap.get("ability_name");
        this.lk = new a(this.R, this.S);
        this.lm = new com.baidu.ar.child.b.b();
        this.lk.a(new a.InterfaceC0081a() { // from class: com.baidu.ar.child.ChildAR.2
            @Override // com.baidu.ar.child.a.InterfaceC0081a
            public void a(final long j, byte[] bArr, int i) {
                if (bArr == null || bArr.length <= 0) {
                    return;
                }
                ChildAR.this.lm.a(bArr, i, new b.a() { // from class: com.baidu.ar.child.ChildAR.2.1
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
        k r = r();
        if (r != null) {
            r.b(20, false);
        }
    }
}
