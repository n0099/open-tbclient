package com.baidu.adp.framework.a;

import com.baidu.adp.lib.network.a.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class g extends a<com.baidu.adp.framework.message.g, com.baidu.adp.framework.task.c> implements com.baidu.adp.lib.network.a.d, com.baidu.adp.lib.network.a.e {
    private com.baidu.adp.lib.network.a.d b;
    private final LinkedList<com.baidu.adp.lib.network.a.h> c;
    private final LinkedList<com.baidu.adp.lib.network.a.h> d;
    private final LinkedList<com.baidu.adp.lib.network.a.h> e;
    private boolean f;

    public boolean a(int i) {
        boolean z = a(i, this.c);
        if (a(i, this.d)) {
            z = true;
        }
        if (a(i, this.e)) {
            return true;
        }
        return z;
    }

    public com.baidu.adp.framework.message.g a(l lVar) {
        com.baidu.adp.lib.network.a.h a = a(lVar, this.c);
        if (a != null) {
            return a.g();
        }
        com.baidu.adp.lib.network.a.h a2 = a(lVar, this.e);
        if (a2 != null) {
            return a2.g();
        }
        return null;
    }

    public g(com.baidu.adp.framework.c cVar) {
        super(cVar);
        this.b = null;
        this.c = new LinkedList<>();
        this.d = new LinkedList<>();
        this.e = new LinkedList<>();
        this.f = true;
        com.baidu.adp.lib.network.a.a.a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a
    public void a(com.baidu.adp.framework.message.g gVar, com.baidu.adp.framework.task.c cVar) {
        a(new com.baidu.adp.lib.network.a.h(gVar, cVar.a(), cVar.l(), cVar.c(), this, cVar.j(), cVar.k()), this.d);
        a();
    }

    private void a() {
        com.baidu.adp.lib.network.a.h first;
        if (!this.d.isEmpty() && (first = this.d.getFirst()) != null) {
            if (com.baidu.adp.lib.network.a.a.a()) {
                com.baidu.adp.lib.network.a.a.a(false, "send message");
            } else if (this.f) {
                com.baidu.adp.lib.util.f.e("The message quene is locked!");
            } else {
                com.baidu.adp.lib.network.a.a.a(first);
            }
        }
    }

    private static com.baidu.adp.lib.network.a.h a(l lVar, List<com.baidu.adp.lib.network.a.h> list) {
        for (com.baidu.adp.lib.network.a.h hVar : list) {
            if (hVar != null && lVar.a(hVar.g())) {
                return hVar;
            }
        }
        return null;
    }

    private static void a(com.baidu.adp.lib.network.a.h hVar, LinkedList<com.baidu.adp.lib.network.a.h> linkedList) {
        int i;
        int i2;
        if (hVar != null && linkedList != null) {
            while (true) {
                i2 = i;
                i = (i2 < linkedList.size() && (linkedList.get(i2) == null || linkedList.get(i2).f() <= hVar.f())) ? i2 + 1 : 0;
            }
            linkedList.add(i2, hVar);
        }
    }

    @Override // com.baidu.adp.lib.network.a.d
    public boolean a(int i, String str) {
        a(true);
        if (this.b != null) {
            this.b.a(i, str);
            return false;
        }
        return false;
    }

    @Override // com.baidu.adp.lib.network.a.d
    public void a(Map<String, String> map) {
        a(false);
        if (this.b != null) {
            this.b.a(map);
        }
    }

    @Override // com.baidu.adp.lib.network.a.d
    public void a(byte[] bArr) {
        new h(this, bArr).execute(new byte[0]);
        if (this.b != null) {
            this.b.a(bArr);
        }
    }

    @Override // com.baidu.adp.lib.network.a.d
    public void a(com.baidu.adp.lib.webSocket.d dVar) {
        a();
        if (this.b != null) {
            this.b.a(dVar);
        }
    }

    @Override // com.baidu.adp.lib.network.a.d
    public void a(String str) {
        if (this.b != null) {
            this.b.a(str);
        }
    }

    public void a(boolean z) {
        boolean z2 = this.f;
        this.f = z;
        if (!this.f && z2) {
            a();
        }
    }

    @Override // com.baidu.adp.lib.network.a.e
    public void a(int i, com.baidu.adp.lib.network.a.h hVar) {
        d(hVar);
        a(hVar, i, "");
        a();
    }

    @Override // com.baidu.adp.lib.network.a.e
    public void a(com.baidu.adp.lib.network.a.h hVar) {
        if (hVar != null && hVar.i() < hVar.k()) {
            a(hVar, this.c, this.e);
            return;
        }
        d(hVar);
        a(hVar, -2001001, "发送超时！");
        a();
    }

    private void d(com.baidu.adp.lib.network.a.h hVar) {
        a(hVar, (List<com.baidu.adp.lib.network.a.h>) this.c);
        a(hVar, (List<com.baidu.adp.lib.network.a.h>) this.e);
        a(hVar, (List<com.baidu.adp.lib.network.a.h>) this.d);
    }

    private void a(com.baidu.adp.lib.network.a.h hVar, int i, String str) {
        com.baidu.adp.framework.message.g g;
        if (hVar != null && (g = hVar.g()) != null) {
            try {
                com.baidu.adp.framework.message.h newInstance = ((com.baidu.adp.framework.task.c) this.a.e(g.d())).d().newInstance();
                newInstance.a(i);
                newInstance.a(str);
                newInstance.a(g);
                this.a.a(newInstance);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(e.toString());
            }
        }
    }

    @Override // com.baidu.adp.lib.network.a.e
    public void b(com.baidu.adp.lib.network.a.h hVar) {
        a();
    }

    @Override // com.baidu.adp.lib.network.a.e
    public void c(com.baidu.adp.lib.network.a.h hVar) {
        if (hVar != null) {
            if (hVar.e()) {
                hVar.j();
                a(hVar, this.d, this.c);
                return;
            }
            a(hVar, (List<com.baidu.adp.lib.network.a.h>) this.d);
        }
    }

    private static boolean a(int i, List<com.baidu.adp.lib.network.a.h> list) {
        Iterator<com.baidu.adp.lib.network.a.h> it = list.iterator();
        boolean z = false;
        while (it.hasNext()) {
            com.baidu.adp.lib.network.a.h next = it.next();
            if (next != null && next.g() != null && next.g().e() == i) {
                it.remove();
                next.b();
                z = true;
            }
        }
        return z;
    }

    public static void a(com.baidu.adp.lib.network.a.h hVar, List<com.baidu.adp.lib.network.a.h> list) {
        a(hVar, list, (List<com.baidu.adp.lib.network.a.h>) null);
        hVar.b();
    }

    private static void a(com.baidu.adp.lib.network.a.h hVar, List<com.baidu.adp.lib.network.a.h> list, List<com.baidu.adp.lib.network.a.h> list2) {
        if (hVar != null) {
            if (list != null && list.contains(hVar)) {
                list.remove(hVar);
            }
            if (list2 != null) {
                list2.add(hVar);
            }
        }
    }
}
