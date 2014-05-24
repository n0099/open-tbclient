package com.baidu.adp.framework.client;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.asyncTask.l;
import com.baidu.adp.lib.network.websocket.BdSocketLinkService;
import com.baidu.adp.lib.network.websocket.g;
import com.baidu.adp.lib.network.websocket.i;
import com.baidu.adp.lib.network.websocket.m;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class e extends a<SocketMessage, SocketMessageTask> implements com.baidu.adp.lib.network.websocket.c, com.baidu.adp.lib.network.websocket.d {
    private static BdAsyncTaskParallel h = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, l.a());
    private com.baidu.adp.framework.c.d b;
    private com.baidu.adp.lib.network.websocket.c c;
    private final LinkedList<g> d;
    private final LinkedList<g> e;
    private final LinkedList<g> f;
    private boolean g;

    public LinkedList<SocketMessage> a(int i) {
        LinkedList<g> linkedList = new LinkedList<>();
        linkedList.addAll(a(i, this.d));
        linkedList.addAll(a(i, this.e));
        linkedList.addAll(a(i, this.f));
        return a(linkedList);
    }

    @Override // com.baidu.adp.framework.a
    public LinkedList<SocketMessage> a(int i, int i2) {
        LinkedList<g> linkedList = new LinkedList<>();
        linkedList.addAll(a(i2, i, this.d));
        linkedList.addAll(a(i2, i, this.e));
        linkedList.addAll(a(i2, i, this.f));
        return a(linkedList);
    }

    public LinkedList<SocketMessage> b(int i) {
        LinkedList<SocketMessage> linkedList = new LinkedList<>();
        linkedList.addAll(c(i, this.d));
        linkedList.addAll(c(i, this.e));
        linkedList.addAll(c(i, this.f));
        return linkedList;
    }

    @Override // com.baidu.adp.framework.a
    public LinkedList<SocketMessage> b(int i, int i2) {
        LinkedList<SocketMessage> linkedList = new LinkedList<>();
        linkedList.addAll(b(i2, i, this.d));
        linkedList.addAll(b(i2, i, this.e));
        linkedList.addAll(b(i2, i, this.f));
        return linkedList;
    }

    public LinkedList<SocketMessage> a(LinkedList<g> linkedList) {
        LinkedList<SocketMessage> linkedList2 = new LinkedList<>();
        Iterator<g> it = linkedList.iterator();
        while (it.hasNext()) {
            linkedList2.add(it.next().g());
        }
        return linkedList2;
    }

    public g a(m mVar) {
        g a = a(mVar, this.d);
        if (a == null) {
            g a2 = a(mVar, this.f);
            if (a2 == null) {
                return null;
            }
            return a2;
        }
        return a;
    }

    public e(MessageManager messageManager) {
        super(messageManager);
        this.b = null;
        this.c = null;
        this.d = new LinkedList<>();
        this.e = new LinkedList<>();
        this.f = new LinkedList<>();
        this.g = true;
        BdSocketLinkService.setConnStateCallBack(this);
    }

    public void a(com.baidu.adp.framework.c.d dVar) {
        this.b = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a
    public void a(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        BdLog.d("sendMessage:" + socketMessage.getClass().getName());
        g gVar = new g(socketMessage, socketMessageTask.a(), socketMessageTask.getPriority(), socketMessageTask.b(), this, socketMessageTask.getTimeOut(), socketMessageTask.getRetry(), socketMessageTask.d(), socketMessageTask.f());
        if (a(socketMessage, socketMessageTask.e())) {
            if (com.baidu.adp.framework.c.c.a().i() != null) {
                com.baidu.adp.framework.c.c.a().i().a("sendMessage", "duplicate remove", 0, socketMessage);
            }
        } else if (this.b != null && !this.b.a()) {
            BdLog.d("网络不通常，已经出黄条CMD=" + socketMessage.getClass().getName());
            gVar.a(1);
        } else {
            a(gVar, this.e);
            e();
        }
    }

    private void e() {
        g first;
        if (!this.e.isEmpty() && (first = this.e.getFirst()) != null) {
            if (BdSocketLinkService.isClose()) {
                BdSocketLinkService.startService(false, "send message");
            } else if (this.g && !first.o()) {
                BdLog.d("The message quene is locked!");
            } else {
                BdSocketLinkService.sendMessage(first);
            }
        }
    }

    private static g a(m mVar, List<g> list) {
        for (g gVar : list) {
            if (gVar != null && mVar.a(gVar.g())) {
                return gVar;
            }
        }
        return null;
    }

    private static void a(g gVar, LinkedList<g> linkedList) {
        int i;
        int i2;
        if (gVar != null && linkedList != null) {
            while (true) {
                i2 = i;
                i = (i2 < linkedList.size() && (linkedList.get(i2) == null || linkedList.get(i2).f() <= gVar.f())) ? i2 + 1 : 0;
            }
            linkedList.add(i2, gVar);
        }
    }

    @Override // com.baidu.adp.lib.network.websocket.c
    public boolean a(int i, String str) {
        a(true);
        if (this.c != null) {
            this.c.a(i, str);
        }
        if (!k.d() || e(this.f) || e(this.e) || e(this.d) || this.g) {
            a();
            return false;
        }
        c(this.d);
        a(this.e, this.f);
        a(this.e, this.d);
        while (true) {
            g d = d(this.e);
            if (d == null) {
                break;
            }
            d.b();
            a(d, i.r, BdBaseApplication.getInst().getString(com.baidu.adp.f.send_error));
        }
        if (this.e == null || this.e.size() <= 0) {
            return false;
        }
        if (com.baidu.adp.framework.c.c.a().i() != null) {
            com.baidu.adp.framework.c.c.a().i().a("have retry message", "MessageQueue:reconnect", 0, (Message<?>) null);
        }
        BdSocketLinkService.startService(false, "have retry message");
        return true;
    }

    @Override // com.baidu.adp.lib.network.websocket.c
    public void a(Map<String, String> map) {
        a(false);
        if (this.c != null) {
            this.c.a(map);
        }
    }

    @Override // com.baidu.adp.lib.network.websocket.c
    public void a(byte[] bArr) {
        if (this.b != null && this.b.a(bArr) && a(this.e, this.f)) {
            e();
        }
        new f(this, bArr).execute(new byte[0]);
        if (this.c != null) {
            this.c.a(bArr);
        }
    }

    @Override // com.baidu.adp.lib.network.websocket.c
    public void a(com.baidu.adp.lib.webSocket.d dVar) {
        e();
        if (this.c != null) {
            this.c.a(dVar);
        }
    }

    @Override // com.baidu.adp.lib.network.websocket.c
    public void a(String str) {
        if (this.c != null) {
            this.c.a(str);
        }
    }

    public void a(boolean z) {
        boolean z2 = this.g;
        this.g = z;
        if (!this.g && z2) {
            e();
        }
    }

    public void a(com.baidu.adp.lib.network.websocket.c cVar) {
        this.c = cVar;
    }

    private boolean a(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        if (dupLicateMode == SocketMessageTask.DupLicateMode.REMOVE_ME) {
            LinkedList<SocketMessage> d = d(socketMessage.getCmd(), this.e);
            if (d != null && d.size() > 0) {
                return true;
            }
            LinkedList<SocketMessage> d2 = d(socketMessage.getCmd(), this.d);
            if (d2 != null && d2.size() > 0) {
                return true;
            }
            LinkedList<SocketMessage> d3 = d(socketMessage.getCmd(), this.f);
            if (d3 != null && d3.size() > 0) {
                return true;
            }
        } else if (dupLicateMode == SocketMessageTask.DupLicateMode.REMOVE_WAITING) {
            b(socketMessage.getCmd(), this.e);
        } else if (dupLicateMode == SocketMessageTask.DupLicateMode.REMOVE_ALL) {
            b(socketMessage.getCmd(), this.e);
            b(socketMessage.getCmd(), this.d);
            b(socketMessage.getCmd(), this.f);
        }
        return false;
    }

    @Override // com.baidu.adp.lib.network.websocket.d
    public void a(int i, g gVar) {
        int i2;
        String string;
        int i3;
        d(gVar);
        if (i == 2) {
            if (gVar.p() != null) {
                i3 = gVar.p().getErrorCode();
            } else {
                i3 = i.k;
            }
            i2 = i3;
            string = i.a(i3);
        } else {
            i2 = i.q;
            string = BdBaseApplication.getInst().getString(com.baidu.adp.f.send_error);
        }
        a(gVar, i2, string);
        e();
    }

    @Override // com.baidu.adp.lib.network.websocket.d
    public void a(g gVar) {
        if (gVar != null && gVar.l() < gVar.n()) {
            a(gVar, this.d, this.f);
            if (this.b != null) {
                this.b.a(gVar);
                return;
            }
            return;
        }
        d(gVar);
        a(gVar, -2003001, "消息通讯超时！");
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(g gVar) {
        a(gVar, (List<g>) this.d);
        a(gVar, (List<g>) this.f);
        a(gVar, (List<g>) this.e);
    }

    private void a(g gVar, int i, String str) {
        SocketMessage g;
        if (gVar != null && (g = gVar.g()) != null) {
            try {
                SocketResponsedMessage newInstance = ((SocketMessageTask) this.a.findTask(g.getCmd())).c().newInstance();
                newInstance.setError(i);
                newInstance.setErrorString(str);
                newInstance.setOrginalMessage(g);
                if (com.baidu.adp.framework.c.c.a().i() != null) {
                    com.baidu.adp.framework.c.c.a().i().a("dispatchMessage", str, i, newInstance);
                }
                this.a.dispatchResponsedMessageToUI(newInstance);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    @Override // com.baidu.adp.lib.network.websocket.d
    public void b(g gVar) {
        e();
    }

    @Override // com.baidu.adp.lib.network.websocket.d
    public void c(g gVar) {
        if (gVar != null) {
            if (gVar.e()) {
                gVar.m();
                a(gVar, this.e, this.d);
                return;
            }
            a(gVar, (List<g>) this.e);
        }
    }

    private static LinkedList<g> a(int i, List<g> list) {
        LinkedList<g> linkedList = new LinkedList<>();
        Iterator<g> it = list.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (next != null && next.g() != null && next.g().getTag() == i) {
                it.remove();
                next.b();
                linkedList.add(next);
            }
        }
        return linkedList;
    }

    private static LinkedList<g> b(int i, List<g> list) {
        LinkedList<g> linkedList = new LinkedList<>();
        Iterator<g> it = list.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (next != null && next.g() != null && next.g().getCmd() == i) {
                it.remove();
                next.b();
                linkedList.add(next);
            }
        }
        return linkedList;
    }

    private static LinkedList<g> a(int i, int i2, List<g> list) {
        LinkedList<g> linkedList = new LinkedList<>();
        Iterator<g> it = list.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (next != null && next.g() != null && next.g().getTag() == i && next.g().getCmd() == i2) {
                it.remove();
                next.b();
                linkedList.add(next);
            }
        }
        return linkedList;
    }

    private static LinkedList<SocketMessage> c(int i, List<g> list) {
        LinkedList<SocketMessage> linkedList = new LinkedList<>();
        for (g gVar : list) {
            if (gVar != null && gVar.g() != null && gVar.g().getTag() == i) {
                linkedList.add(gVar.g());
            }
        }
        return linkedList;
    }

    private static LinkedList<SocketMessage> d(int i, List<g> list) {
        LinkedList<SocketMessage> linkedList = new LinkedList<>();
        for (g gVar : list) {
            if (gVar != null && gVar.g() != null && gVar.g().getCmd() == i) {
                linkedList.add(gVar.g());
            }
        }
        return linkedList;
    }

    private static LinkedList<SocketMessage> b(int i, int i2, List<g> list) {
        LinkedList<SocketMessage> linkedList = new LinkedList<>();
        for (g gVar : list) {
            if (gVar != null && gVar.g() != null && gVar.g().getTag() == i && gVar.g().getCmd() == i2) {
                linkedList.add(gVar.g());
            }
        }
        return linkedList;
    }

    public static void a(g gVar, List<g> list) {
        a(gVar, list, (List<g>) null);
        gVar.b();
    }

    private static boolean e(LinkedList<g> linkedList) {
        if (linkedList == null) {
            return false;
        }
        Iterator<g> it = linkedList.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (next != null) {
                next.k();
                if (next.j() >= next.n()) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void a(g gVar, List<g> list, List<g> list2) {
        if (gVar != null) {
            if (list != null && list.contains(gVar)) {
                list.remove(gVar);
            }
            if (list2 != null) {
                list2.add(gVar);
            }
        }
    }

    public void a() {
        b(this.d);
        b(this.f);
        b(this.e);
    }

    public void b(LinkedList<g> linkedList) {
        Iterator<g> it = linkedList.iterator();
        while (it.hasNext()) {
            g next = it.next();
            next.b();
            a(next, i.r, BdBaseApplication.getInst().getString(com.baidu.adp.f.send_error));
        }
        linkedList.clear();
    }

    public static boolean a(LinkedList<g> linkedList, LinkedList<g> linkedList2) {
        if (linkedList == null || linkedList2 == null || linkedList2.size() <= 0) {
            return false;
        }
        while (true) {
            g poll = linkedList2.poll();
            if (poll != null) {
                a(poll, linkedList);
            } else {
                return true;
            }
        }
    }

    public static void c(LinkedList<g> linkedList) {
        if (linkedList != null) {
            Iterator<g> it = linkedList.iterator();
            while (it.hasNext()) {
                g next = it.next();
                if (next != null) {
                    next.a();
                }
            }
        }
    }

    public static g d(LinkedList<g> linkedList) {
        if (linkedList == null) {
            return null;
        }
        Iterator<g> it = linkedList.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (next != null && !next.q()) {
                it.remove();
                return next;
            }
        }
        return null;
    }

    public boolean b() {
        return BdSocketLinkService.isOpen() && !this.g;
    }

    public boolean c() {
        return this.g;
    }
}
