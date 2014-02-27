package com.baidu.adp.framework.a;

import com.baidu.adp.lib.network.a.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class g extends a<com.baidu.adp.framework.message.g, com.baidu.adp.framework.task.c> implements com.baidu.adp.lib.network.a.d, com.baidu.adp.lib.network.a.e {
    private com.baidu.adp.lib.network.a.d b;
    private final LinkedList<com.baidu.adp.lib.network.a.h> c;
    private final LinkedList<com.baidu.adp.lib.network.a.h> d;
    private final LinkedList<com.baidu.adp.lib.network.a.h> e;
    private boolean f;

    public final boolean a(int i) {
        boolean z = a(i, this.c);
        if (a(i, this.d)) {
            z = true;
        }
        if (a(i, this.e)) {
            return true;
        }
        return z;
    }

    public final com.baidu.adp.framework.message.g a(l lVar) {
        com.baidu.adp.lib.network.a.h a = a(lVar, this.c);
        if (a != null) {
            return a.f();
        }
        com.baidu.adp.lib.network.a.h a2 = a(lVar, this.e);
        if (a2 != null) {
            return a2.f();
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
    public final void a(com.baidu.adp.framework.message.g gVar, com.baidu.adp.framework.task.c cVar) {
        int i;
        int i2;
        com.baidu.adp.lib.network.a.h hVar = new com.baidu.adp.lib.network.a.h(gVar, cVar.a(), cVar.l(), cVar.c(), this, cVar.j(), cVar.k());
        LinkedList<com.baidu.adp.lib.network.a.h> linkedList = this.d;
        if (hVar != null && linkedList != null) {
            while (true) {
                i2 = i;
                i = (i2 < linkedList.size() && (linkedList.get(i2) == null || linkedList.get(i2).e() <= hVar.e())) ? i2 + 1 : 0;
            }
            linkedList.add(i2, hVar);
        }
        b();
    }

    private void b() {
        com.baidu.adp.lib.network.a.h first;
        if (!this.d.isEmpty() && (first = this.d.getFirst()) != null) {
            if (com.baidu.adp.lib.network.a.a.a()) {
                com.baidu.adp.lib.network.a.a.a(false, "send message");
            } else if (this.f) {
                com.baidu.adp.lib.util.e.e("The message quene is locked!");
            } else {
                com.baidu.adp.lib.network.a.a.a(first);
            }
        }
    }

    private static com.baidu.adp.lib.network.a.h a(l lVar, List<com.baidu.adp.lib.network.a.h> list) {
        for (com.baidu.adp.lib.network.a.h hVar : list) {
            if (hVar != null) {
                hVar.f();
                if (lVar.a()) {
                    return hVar;
                }
            }
        }
        return null;
    }

    @Override // com.baidu.adp.lib.network.a.d
    public final boolean a(int i, String str) {
        a(true);
        if (this.b != null) {
            this.b.a(i, str);
            return false;
        }
        return false;
    }

    @Override // com.baidu.adp.lib.network.a.d
    public final void a(Map<String, String> map) {
        a(false);
        if (this.b != null) {
            this.b.a(map);
        }
    }

    @Override // com.baidu.adp.lib.network.a.d
    public final void a(byte[] bArr) {
        new h(this, bArr).execute(new byte[0]);
        if (this.b != null) {
            this.b.a(bArr);
        }
    }

    @Override // com.baidu.adp.lib.network.a.d
    public final void a(com.baidu.adp.lib.webSocket.d dVar) {
        b();
        if (this.b != null) {
            this.b.a(dVar);
        }
    }

    @Override // com.baidu.adp.lib.network.a.d
    public final void a(String str) {
        if (this.b != null) {
            this.b.a(str);
        }
    }

    private void a(boolean z) {
        boolean z2 = this.f;
        this.f = z;
        if (!this.f && z2) {
            b();
        }
    }

    @Override // com.baidu.adp.lib.network.a.e
    public final void a(int i, com.baidu.adp.lib.network.a.h hVar) {
        c(hVar);
        a(hVar, i, "");
        b();
    }

    @Override // com.baidu.adp.lib.network.a.e
    public final void a(com.baidu.adp.lib.network.a.h hVar) {
        if (hVar != null && hVar.h() < hVar.j()) {
            a(hVar, this.c, this.e);
            return;
        }
        c(hVar);
        a(hVar, -2001001, "发送超时！");
        b();
    }

    private void c(com.baidu.adp.lib.network.a.h hVar) {
        a(hVar, this.c);
        a(hVar, this.e);
        a(hVar, this.d);
    }

    private void a(com.baidu.adp.lib.network.a.h hVar, int i, String str) {
        com.baidu.adp.framework.message.g f;
        if (hVar != null && (f = hVar.f()) != null) {
            try {
                com.baidu.adp.framework.message.h newInstance = ((com.baidu.adp.framework.task.c) this.a.b(f.d())).d().newInstance();
                newInstance.a(i);
                newInstance.a(str);
                newInstance.a(f);
                this.a.a(newInstance);
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b(e.toString());
            }
        }
    }

    @Override // com.baidu.adp.lib.network.a.e
    public final void a() {
        b();
    }

    @Override // com.baidu.adp.lib.network.a.e
    public final void b(com.baidu.adp.lib.network.a.h hVar) {
        if (hVar != null) {
            if (hVar.d()) {
                hVar.i();
                a(hVar, this.d, this.c);
                return;
            }
            a(hVar, this.d);
        }
    }

    private static boolean a(int i, List<com.baidu.adp.lib.network.a.h> list) {
        Iterator<com.baidu.adp.lib.network.a.h> it = list.iterator();
        boolean z = false;
        while (it.hasNext()) {
            com.baidu.adp.lib.network.a.h next = it.next();
            if (next != null && next.f() != null && next.f().e() == i) {
                it.remove();
                next.a();
                z = true;
            }
        }
        return z;
    }

    private static void a(com.baidu.adp.lib.network.a.h hVar, List<com.baidu.adp.lib.network.a.h> list) {
        a(hVar, list, (List<com.baidu.adp.lib.network.a.h>) null);
        hVar.a();
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
