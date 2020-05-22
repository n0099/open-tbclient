package com.baidu.ar.child;

import android.text.TextUtils;
import com.baidu.ala.dumixar.utils.LuaMessageHelper;
import com.baidu.ar.arrender.j;
import com.baidu.ar.c;
import com.baidu.ar.c.l;
import com.baidu.ar.child.a;
import com.baidu.ar.child.a.d;
import com.baidu.ar.child.a.e;
import com.baidu.ar.databasic.AlgoHandleAdapter;
import com.baidu.ar.databasic.AlgoHandleController;
import com.baidu.ar.lua.LuaMsgListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
/* loaded from: classes3.dex */
public class ChildAR extends c implements LuaMsgListener {
    private a kj;
    private com.baidu.ar.child.a.b kl;
    private boolean ko;
    private String bx = null;
    private int kk = 10;
    private TreeMap<Long, com.baidu.ar.child.a.a> km = new TreeMap<>();
    private TreeMap<Long, com.baidu.ar.child.a.c> kn = new TreeMap<>();
    private AlgoHandleController bU = null;

    private void a(String str, final float f) {
        final e eVar = new e();
        eVar.s(str);
        a(eVar, new com.baidu.ar.c.e() { // from class: com.baidu.ar.child.ChildAR.4
            @Override // com.baidu.ar.c.e
            public void a(com.baidu.ar.c.b bVar) {
                com.baidu.ar.child.a.c cVar;
                com.baidu.ar.child.a.a aVar;
                if (bVar != null && (bVar instanceof d)) {
                    d dVar = (d) bVar;
                    if (ChildAR.this.kn.size() <= 0 || dVar == null || dVar.cf() == null) {
                        return;
                    }
                    if (ChildAR.this.kn.containsKey(Long.valueOf(dVar.getTimestamp()))) {
                        ChildAR.this.kn.remove(Long.valueOf(dVar.getTimestamp()));
                        cVar = (com.baidu.ar.child.a.c) ChildAR.this.kn.get(Long.valueOf(dVar.getTimestamp()));
                    } else {
                        long longValue = ((Long) ChildAR.this.kn.lastKey()).longValue();
                        ChildAR.this.kn.remove(Long.valueOf(longValue));
                        cVar = (com.baidu.ar.child.a.c) ChildAR.this.kn.get(Long.valueOf(longValue));
                    }
                    if (ChildAR.this.km.containsKey(Long.valueOf(dVar.getTimestamp()))) {
                        aVar = (com.baidu.ar.child.a.a) ChildAR.this.km.get(Long.valueOf(dVar.getTimestamp()));
                        ChildAR.this.km.remove(Long.valueOf(dVar.getTimestamp()));
                    } else {
                        long longValue2 = ((Long) ChildAR.this.km.lastKey()).longValue();
                        aVar = (com.baidu.ar.child.a.a) ChildAR.this.km.get(Long.valueOf(longValue2));
                        ChildAR.this.km.remove(Long.valueOf(longValue2));
                    }
                    if (cVar != null && aVar != null && aVar.cf() != null) {
                        long createHandle = AlgoHandleAdapter.createHandle();
                        ChildAR.this.kj.n(createHandle);
                        ChildAR.this.kj.a(createHandle, dVar.cf(), dVar.cf().length, 720, 1280, f);
                        j r = ChildAR.this.r();
                        if (r != null && createHandle > 0 && ChildAR.this.bU != null) {
                            if (ChildAR.this.ko) {
                                return;
                            }
                            ChildAR.this.bU.sendHandleToRenderer(createHandle, r, "ability_face_child");
                        }
                        ChildAR.this.kj.n(cVar.bv());
                        b bVar2 = new b(aVar, f);
                        bVar2.a(cVar);
                        ChildAR.this.kj.a(bVar2);
                    }
                }
                new Thread(new Runnable() { // from class: com.baidu.ar.child.ChildAR.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ChildAR.this.a(eVar);
                    }
                }).start();
            }

            @Override // com.baidu.ar.c.e
            public void a(l lVar) {
            }

            @Override // com.baidu.ar.c.e
            public void b(l lVar) {
            }
        });
    }

    private void bZ() {
        if (this.kn.size() <= 0) {
            return;
        }
        for (Long l : this.kn.keySet()) {
            com.baidu.ar.child.a.c cVar = this.kn.get(l);
            if (cVar != null && cVar.bv() > 0 && this.bU != null) {
                this.bU.destroyHandle(cVar.bv());
                cVar.i(0L);
            }
        }
        this.kn.clear();
    }

    private void ca() {
        if (this.km.size() <= 0) {
            return;
        }
        this.km.clear();
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
        if (j <= 0 || AlgoHandleAdapter.getHandleType(j) != 20 || this.bU == null) {
            return;
        }
        this.bU.destroyHandle(j);
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
        if (this.ko || hashMap == null || hashMap.keySet().size() < 1) {
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
        this.ko = !this.ko;
        bZ();
        ca();
        if (this.kl != null) {
            a(this.kl);
            this.kl = null;
        }
        if (this.bU != null) {
            this.bU.release();
            this.bU = null;
        }
        if (this.kj == null || this.ko) {
            return;
        }
        this.kj.a((a.InterfaceC0080a) null);
        this.kj.cb();
        this.kj = null;
    }

    @Override // com.baidu.ar.c
    public void resume() {
        super.resume();
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        if (this.bU == null) {
            this.bU = new AlgoHandleController();
        }
        this.bx = (String) hashMap.get("ability_name");
        this.kj = new a();
        this.kj.a(new a.InterfaceC0080a() { // from class: com.baidu.ar.child.ChildAR.1
            @Override // com.baidu.ar.child.a.InterfaceC0080a
            public void k(long j) {
                j r;
                if (TextUtils.isEmpty(ChildAR.this.bx) || j <= 0 || (r = ChildAR.this.r()) == null || j <= 0 || ChildAR.this.bU == null || ChildAR.this.ko) {
                    return;
                }
                ChildAR.this.bU.sendHandleToRenderer(j, r, "ability_face_child");
            }
        });
        a("FaceDetector", new com.baidu.ar.c.e() { // from class: com.baidu.ar.child.ChildAR.2
            @Override // com.baidu.ar.c.e
            public void a(com.baidu.ar.c.b bVar) {
                if (ChildAR.this.ko) {
                    return;
                }
                if (ChildAR.this.kj == null) {
                    if (ChildAR.this.bU != null) {
                        ChildAR.this.bU.destroyHandle(bVar.cn());
                        return;
                    }
                    return;
                }
                if (AlgoHandleAdapter.getHandleType(bVar.cn()) == 10) {
                    if (ChildAR.this.kn.size() >= ChildAR.this.kk) {
                        ChildAR.this.bU.destroyHandle(((com.baidu.ar.child.a.c) ChildAR.this.kn.get(ChildAR.this.kn.firstKey())).bv());
                        ChildAR.this.kn.remove(ChildAR.this.kn.firstKey());
                    }
                    long createHandle = AlgoHandleAdapter.createHandle();
                    com.baidu.ar.child.a.c cVar = new com.baidu.ar.child.a.c();
                    if (ChildAR.this.kj != null) {
                        cVar.d(ChildAR.this.kj.m(bVar.cn()));
                        cVar.e(ChildAR.this.kj.l(bVar.cn()));
                        cVar.i(createHandle);
                        ChildAR.this.kn.put(Long.valueOf(bVar.getTimestamp()), cVar);
                    }
                }
                if (ChildAR.this.bU != null) {
                    ChildAR.this.bU.destroyHandle(bVar.cn());
                }
            }

            @Override // com.baidu.ar.c.e
            public void a(l lVar) {
            }

            @Override // com.baidu.ar.c.e
            public void b(l lVar) {
            }
        }, null);
        this.kl = new com.baidu.ar.child.a.b();
        a(this.kl, new com.baidu.ar.c.e() { // from class: com.baidu.ar.child.ChildAR.3
            @Override // com.baidu.ar.c.e
            public void a(com.baidu.ar.c.b bVar) {
                if (!ChildAR.this.ko && (bVar instanceof com.baidu.ar.child.a.a)) {
                    com.baidu.ar.child.a.a aVar = (com.baidu.ar.child.a.a) bVar;
                    if (ChildAR.this.km.size() >= ChildAR.this.kk) {
                        ChildAR.this.km.remove(ChildAR.this.km.firstKey());
                    }
                    ChildAR.this.km.put(Long.valueOf(bVar.getTimestamp()), aVar);
                }
            }

            @Override // com.baidu.ar.c.e
            public void a(l lVar) {
            }

            @Override // com.baidu.ar.c.e
            public void b(l lVar) {
            }
        });
        a((LuaMsgListener) this);
    }
}
