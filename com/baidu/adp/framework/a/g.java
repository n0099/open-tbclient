package com.baidu.adp.framework.a;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.network.websocket.BdSocketLinkService;
import com.baidu.adp.lib.network.websocket.i;
import com.baidu.adp.lib.network.websocket.m;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class g extends a<com.baidu.adp.framework.message.g, SocketMessageTask> implements com.baidu.adp.lib.network.websocket.c, com.baidu.adp.lib.network.websocket.d {
    private com.baidu.adp.lib.network.websocket.c b;
    private final LinkedList<com.baidu.adp.lib.network.websocket.g> c;
    private final LinkedList<com.baidu.adp.lib.network.websocket.g> d;
    private final LinkedList<com.baidu.adp.lib.network.websocket.g> e;
    private boolean f;

    public final LinkedList<com.baidu.adp.framework.message.g> a(int i) {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(a(i, this.c));
        linkedList.addAll(a(i, this.d));
        linkedList.addAll(a(i, this.e));
        return a(linkedList);
    }

    @Override // com.baidu.adp.framework.a
    public final LinkedList<com.baidu.adp.framework.message.g> a(int i, int i2) {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(a(i2, i, this.c));
        linkedList.addAll(a(i2, i, this.d));
        linkedList.addAll(a(i2, i, this.e));
        return a(linkedList);
    }

    @Override // com.baidu.adp.framework.a
    public final LinkedList<com.baidu.adp.framework.message.g> b(int i, int i2) {
        LinkedList<com.baidu.adp.framework.message.g> linkedList = new LinkedList<>();
        linkedList.addAll(b(i2, i, this.c));
        linkedList.addAll(b(i2, i, this.d));
        linkedList.addAll(b(i2, i, this.e));
        return linkedList;
    }

    private static LinkedList<com.baidu.adp.framework.message.g> a(LinkedList<com.baidu.adp.lib.network.websocket.g> linkedList) {
        LinkedList<com.baidu.adp.framework.message.g> linkedList2 = new LinkedList<>();
        Iterator<com.baidu.adp.lib.network.websocket.g> it = linkedList.iterator();
        while (it.hasNext()) {
            linkedList2.add(it.next().f());
        }
        return linkedList2;
    }

    public final com.baidu.adp.lib.network.websocket.g a(m mVar) {
        com.baidu.adp.lib.network.websocket.g a = a(mVar, this.c);
        if (a == null) {
            com.baidu.adp.lib.network.websocket.g a2 = a(mVar, this.e);
            if (a2 == null) {
                return null;
            }
            return a2;
        }
        return a;
    }

    public g(com.baidu.adp.framework.c cVar) {
        super(cVar);
        this.b = null;
        this.c = new LinkedList<>();
        this.d = new LinkedList<>();
        this.e = new LinkedList<>();
        this.f = true;
        BdSocketLinkService.a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d1  */
    @Override // com.baidu.adp.framework.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(com.baidu.adp.framework.message.g gVar, SocketMessageTask socketMessageTask) {
        boolean z;
        com.baidu.adp.lib.util.f.e("sendMessage:" + gVar.getClass().getName());
        com.baidu.adp.lib.network.websocket.g gVar2 = new com.baidu.adp.lib.network.websocket.g(gVar, socketMessageTask.a(), socketMessageTask.l(), socketMessageTask.c(), this, socketMessageTask.j(), socketMessageTask.k(), socketMessageTask.e());
        if (this.f && !socketMessageTask.e()) {
            com.baidu.adp.lib.util.f.e("MessageQuene is BlockedCMD=" + gVar.getClass().getName());
            gVar2.a(1);
            return;
        }
        SocketMessageTask.DupLicateMode f = socketMessageTask.f();
        if (f == SocketMessageTask.DupLicateMode.REMOVE_ME) {
            LinkedList<com.baidu.adp.framework.message.g> c = c(gVar.e(), this.d);
            if (c == null || c.size() <= 0) {
                LinkedList<com.baidu.adp.framework.message.g> c2 = c(gVar.e(), this.c);
                if (c2 == null || c2.size() <= 0) {
                    LinkedList<com.baidu.adp.framework.message.g> c3 = c(gVar.e(), this.e);
                    if (c3 != null && c3.size() > 0) {
                        z = true;
                    }
                } else {
                    z = true;
                }
            } else {
                z = true;
            }
            if (!z) {
                if (com.baidu.adp.framework.e.c.a().i() != null) {
                    com.baidu.adp.framework.e.c.a().i().a("sendMessage", "duplicate remove", 0, gVar);
                    return;
                }
                return;
            }
            a(gVar2, this.d);
            c();
            return;
        } else if (f == SocketMessageTask.DupLicateMode.REMOVE_WAITING) {
            b(gVar.e(), this.d);
        }
        z = false;
        if (!z) {
        }
    }

    private void c() {
        com.baidu.adp.lib.network.websocket.g first;
        if (!this.d.isEmpty() && (first = this.d.getFirst()) != null) {
            if (BdSocketLinkService.a()) {
                BdSocketLinkService.a(false, "send message");
            } else if (this.f && !first.k()) {
                com.baidu.adp.lib.util.f.e("The message quene is locked!");
            } else {
                BdSocketLinkService.a(first);
            }
        }
    }

    private static com.baidu.adp.lib.network.websocket.g a(m mVar, List<com.baidu.adp.lib.network.websocket.g> list) {
        for (com.baidu.adp.lib.network.websocket.g gVar : list) {
            if (gVar != null && mVar.a(gVar.f())) {
                return gVar;
            }
        }
        return null;
    }

    private static void a(com.baidu.adp.lib.network.websocket.g gVar, LinkedList<com.baidu.adp.lib.network.websocket.g> linkedList) {
        int i;
        if (gVar != null && linkedList != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i < linkedList.size() && (linkedList.get(i) == null || linkedList.get(i).e() <= gVar.e())) {
                    i2 = i + 1;
                }
            }
            linkedList.add(i, gVar);
        }
    }

    @Override // com.baidu.adp.lib.network.websocket.c
    public final boolean a(int i, String str) {
        a(true);
        if (this.b != null) {
            this.b.a(i, str);
            return false;
        }
        return false;
    }

    @Override // com.baidu.adp.lib.network.websocket.c
    public final void a(Map<String, String> map) {
        a(false);
        if (this.b != null) {
            this.b.a(map);
        }
    }

    @Override // com.baidu.adp.lib.network.websocket.c
    public final void a(byte[] bArr) {
        new h(this, bArr).execute(new byte[0]);
        if (this.b != null) {
            this.b.a(bArr);
        }
    }

    @Override // com.baidu.adp.lib.network.websocket.c
    public final void a(com.baidu.adp.lib.webSocket.d dVar) {
        c();
        if (this.b != null) {
            this.b.a(dVar);
        }
    }

    @Override // com.baidu.adp.lib.network.websocket.c
    public final void a(String str) {
        if (this.b != null) {
            this.b.a(str);
        }
    }

    public final void a(boolean z) {
        boolean z2 = this.f;
        this.f = z;
        if (!this.f && z2) {
            c();
        }
    }

    public final void a(com.baidu.adp.lib.network.websocket.c cVar) {
        this.b = cVar;
    }

    @Override // com.baidu.adp.lib.network.websocket.d
    public final void a(int i, com.baidu.adp.lib.network.websocket.g gVar) {
        int i2;
        String string;
        int i3;
        c(gVar);
        if (i == 2) {
            if (gVar.l() != null) {
                i3 = gVar.l().getErrorCode();
            } else {
                i3 = i.k;
            }
            i2 = i3;
            string = i.a(i3);
        } else {
            i2 = i.q;
            string = com.baidu.adp.a.b.a().getString(com.baidu.adp.f.send_error);
        }
        a(gVar, i2, string);
        c();
    }

    @Override // com.baidu.adp.lib.network.websocket.d
    public final void a(com.baidu.adp.lib.network.websocket.g gVar) {
        if (gVar != null && gVar.h() < gVar.j()) {
            a(gVar, this.c, this.e);
            return;
        }
        c(gVar);
        a(gVar, -2001001, "发送超时！");
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.adp.lib.network.websocket.g gVar) {
        a(gVar, (List<com.baidu.adp.lib.network.websocket.g>) this.c);
        a(gVar, (List<com.baidu.adp.lib.network.websocket.g>) this.e);
        a(gVar, (List<com.baidu.adp.lib.network.websocket.g>) this.d);
    }

    private void a(com.baidu.adp.lib.network.websocket.g gVar, int i, String str) {
        com.baidu.adp.framework.message.g f;
        if (gVar != null && (f = gVar.f()) != null) {
            try {
                SocketResponsedMessage newInstance = ((SocketMessageTask) this.a.d(f.e())).d().newInstance();
                newInstance.a(i);
                newInstance.d(str);
                newInstance.a(f);
                if (com.baidu.adp.framework.e.c.a().i() != null) {
                    com.baidu.adp.framework.e.c.a().i().a("dispatchMessage", str, i, newInstance);
                }
                this.a.b(newInstance);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(e.toString());
            }
        }
    }

    @Override // com.baidu.adp.lib.network.websocket.d
    public final void a() {
        c();
    }

    @Override // com.baidu.adp.lib.network.websocket.d
    public final void b(com.baidu.adp.lib.network.websocket.g gVar) {
        if (gVar != null) {
            if (gVar.d()) {
                gVar.i();
                a(gVar, this.d, this.c);
                return;
            }
            a(gVar, (List<com.baidu.adp.lib.network.websocket.g>) this.d);
        }
    }

    private static LinkedList<com.baidu.adp.lib.network.websocket.g> a(int i, List<com.baidu.adp.lib.network.websocket.g> list) {
        LinkedList<com.baidu.adp.lib.network.websocket.g> linkedList = new LinkedList<>();
        Iterator<com.baidu.adp.lib.network.websocket.g> it = list.iterator();
        while (it.hasNext()) {
            com.baidu.adp.lib.network.websocket.g next = it.next();
            if (next != null && next.f() != null && next.f().f() == i) {
                it.remove();
                next.a();
                linkedList.add(next);
            }
        }
        return linkedList;
    }

    private static LinkedList<com.baidu.adp.lib.network.websocket.g> b(int i, List<com.baidu.adp.lib.network.websocket.g> list) {
        LinkedList<com.baidu.adp.lib.network.websocket.g> linkedList = new LinkedList<>();
        Iterator<com.baidu.adp.lib.network.websocket.g> it = list.iterator();
        while (it.hasNext()) {
            com.baidu.adp.lib.network.websocket.g next = it.next();
            if (next != null && next.f() != null && next.f().e() == i) {
                it.remove();
                next.a();
                linkedList.add(next);
            }
        }
        return linkedList;
    }

    private static LinkedList<com.baidu.adp.lib.network.websocket.g> a(int i, int i2, List<com.baidu.adp.lib.network.websocket.g> list) {
        LinkedList<com.baidu.adp.lib.network.websocket.g> linkedList = new LinkedList<>();
        Iterator<com.baidu.adp.lib.network.websocket.g> it = list.iterator();
        while (it.hasNext()) {
            com.baidu.adp.lib.network.websocket.g next = it.next();
            if (next != null && next.f() != null && next.f().f() == i && next.f().e() == i2) {
                it.remove();
                next.a();
                linkedList.add(next);
            }
        }
        return linkedList;
    }

    private static LinkedList<com.baidu.adp.framework.message.g> c(int i, List<com.baidu.adp.lib.network.websocket.g> list) {
        LinkedList<com.baidu.adp.framework.message.g> linkedList = new LinkedList<>();
        for (com.baidu.adp.lib.network.websocket.g gVar : list) {
            if (gVar != null && gVar.f() != null && gVar.f().e() == i) {
                linkedList.add(gVar.f());
            }
        }
        return linkedList;
    }

    private static LinkedList<com.baidu.adp.framework.message.g> b(int i, int i2, List<com.baidu.adp.lib.network.websocket.g> list) {
        LinkedList<com.baidu.adp.framework.message.g> linkedList = new LinkedList<>();
        for (com.baidu.adp.lib.network.websocket.g gVar : list) {
            if (gVar != null && gVar.f() != null && gVar.f().f() == i && gVar.f().e() == i2) {
                linkedList.add(gVar.f());
            }
        }
        return linkedList;
    }

    private static void a(com.baidu.adp.lib.network.websocket.g gVar, List<com.baidu.adp.lib.network.websocket.g> list) {
        a(gVar, list, (List<com.baidu.adp.lib.network.websocket.g>) null);
        gVar.a();
    }

    private static void a(com.baidu.adp.lib.network.websocket.g gVar, List<com.baidu.adp.lib.network.websocket.g> list, List<com.baidu.adp.lib.network.websocket.g> list2) {
        if (gVar != null) {
            if (list != null && list.contains(gVar)) {
                list.remove(gVar);
            }
            if (list2 != null) {
                list2.add(gVar);
            }
        }
    }

    public final boolean b() {
        return BdSocketLinkService.b() && !this.f;
    }
}
