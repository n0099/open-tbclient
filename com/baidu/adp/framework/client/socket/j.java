package com.baidu.adp.framework.client.socket;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.coder.CoderException;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.util.BdLog;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.framework.client.a<SocketMessage, SocketMessageTask> implements com.baidu.adp.framework.client.socket.link.c {
    private static /* synthetic */ int[] j;
    private e b;
    private final LinkedList<g> c;
    private final LinkedList<g> d;
    private final LinkedList<g> e;
    private com.baidu.adp.framework.client.socket.link.c f;
    private boolean g;
    private b h;
    private long i;

    static /* synthetic */ int[] e() {
        int[] iArr = j;
        if (iArr == null) {
            iArr = new int[SocketMessageTask.DupLicateMode.valuesCustom().length];
            try {
                iArr[SocketMessageTask.DupLicateMode.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[SocketMessageTask.DupLicateMode.REMOVE_ALL.ordinal()] = 4;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[SocketMessageTask.DupLicateMode.REMOVE_ME.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[SocketMessageTask.DupLicateMode.REMOVE_WAITING.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            j = iArr;
        }
        return iArr;
    }

    public j(MessageManager messageManager) {
        super(messageManager);
        this.b = null;
        this.c = new LinkedList<>();
        this.d = new LinkedList<>();
        this.e = new LinkedList<>();
        this.f = null;
        this.g = true;
        this.h = null;
        this.i = 0L;
        BdSocketLinkService.setConnStateCallBack(this);
        this.b = new k(this);
    }

    public boolean a(SocketMessage socketMessage) {
        if (socketMessage != null && (socketMessage instanceof a)) {
            a aVar = (a) socketMessage;
            if (c.a(this.d, aVar, socketMessage.getCmd()) || c.a(this.c, aVar, socketMessage.getCmd()) || c.a(this.e, aVar, socketMessage.getCmd())) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a
    public void a(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        com.baidu.adp.lib.util.k.b();
        if (socketMessage != null && socketMessageTask != null) {
            if (a(socketMessage, socketMessageTask.e())) {
                m.a("queue", socketMessage, 0, "sendMessage", l.u, "duplicate message be removed");
                return;
            }
            g gVar = new g(socketMessage, socketMessageTask.a(), socketMessageTask.getPriority(), socketMessageTask.b(), this, socketMessageTask.getTimeOut(), socketMessageTask.d(), socketMessageTask.getRetry());
            if (!BdSocketLinkService.isAvailable()) {
                m.a("queue", socketMessage, 0, "sendMessage", l.t, "isManualBlock message be removed");
                gVar.a(l.t);
                return;
            }
            m.a("queue", socketMessage, 0, "sendMessage", "socketclient: send message");
            c.a(gVar, this.d);
            f();
        }
    }

    private boolean a(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        if (socketMessage != null) {
            int cmd = socketMessage.getCmd();
            switch (e()[dupLicateMode.ordinal()]) {
                case 2:
                    if (c.a(this.d, cmd) || c.a(this.c, cmd) || c.a(this.e, cmd)) {
                        return true;
                    }
                    break;
                case 3:
                    c.b(this.d, cmd);
                    break;
                case 4:
                    c.b(this.d, cmd);
                    c.b(this.c, cmd);
                    c.b(this.e, cmd);
                    break;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar) {
        if (fVar != null) {
            if (fVar.b != null) {
                a(fVar.b, l.d, null);
                return;
            }
            SocketResponsedMessage socketResponsedMessage = fVar.a;
            if (socketResponsedMessage != null) {
                m.a("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", "unpack succ");
                a(socketResponsedMessage);
            }
        }
    }

    public void a(g gVar) {
        if (gVar != null && gVar.n() && gVar.q() < gVar.a()) {
            c.a(this.c, this.e, gVar);
            if (this.h != null) {
                this.h.a(true, "timeout seq = " + gVar.m());
            }
            m.a("queue", gVar.j(), gVar.m(), "onSendTimeOut", l.x, String.valueOf(gVar.q()));
            return;
        }
        d(gVar);
        a(gVar, l.o, null);
        f();
    }

    public void a(int i, g gVar) {
        int i2;
        if (i == 2) {
            if (gVar.g() != null) {
                i2 = gVar.g().getErrorCode();
            } else {
                i2 = l.k;
            }
        } else {
            i2 = l.p;
        }
        String a = l.a(i2);
        d(gVar);
        a(gVar, i2, a);
    }

    public void b(g gVar) {
    }

    public void c(g gVar) {
        if (gVar != null) {
            if (gVar.h()) {
                gVar.r();
                c.a(this.d, this.c, gVar);
                return;
            }
            c.b(gVar, this.d);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void a(g gVar, int i, String str) {
        SocketResponsedMessage socketResponsedMessage;
        if (gVar != null && gVar.j() != null) {
            int cmd = gVar.j().getCmd();
            int m = gVar.m();
            m.a("queue", gVar.j(), m, "onMessageSendFail", i, String.valueOf(str) + " retryTime-" + gVar.q());
            SocketMessageTask socketMessageTask = (SocketMessageTask) this.a.findTask(cmd);
            if (socketMessageTask != null && socketMessageTask.c() != null) {
                try {
                    socketResponsedMessage = socketMessageTask.c().newInstance();
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
                if (socketResponsedMessage == null) {
                    socketResponsedMessage.setError(i);
                    if (str == null) {
                        socketResponsedMessage.setErrorString(l.a(i));
                    } else {
                        socketResponsedMessage.setErrorString(str);
                    }
                    socketResponsedMessage.setOrginalMessage(gVar.j());
                    m.a("queue", gVar.j(), m, "onMessageSendFail", "onMessageSendFail class = " + socketResponsedMessage.getClass().getName());
                    this.a.dispatchResponsedMessage(socketResponsedMessage);
                    return;
                }
                return;
            }
            socketResponsedMessage = null;
            if (socketResponsedMessage == null) {
            }
        }
    }

    private void f() {
        g c = c.c(this.d);
        if (c != null) {
            if (BdSocketLinkService.isClose()) {
                m.a("queue", c.j(), 0, "sendNext", l.v, "");
                BdSocketLinkService.startService(false, "send message");
            } else if (!this.g || c.i() <= -3) {
                BdSocketLinkService.sendMessage(c);
            }
        }
    }

    private void a(SocketResponsedMessage socketResponsedMessage) {
        this.a.dispatchResponsedMessage(socketResponsedMessage);
    }

    private void d(g gVar) {
        if (gVar != null) {
            gVar.c();
            c.b(gVar, this.c);
            c.b(gVar, this.d);
            c.b(gVar, this.e);
        }
    }

    private void a(LinkedList<g> linkedList) {
        while (true) {
            g d = c.d(linkedList);
            if (d != null) {
                d.c();
                a(d, l.q, null);
            } else {
                return;
            }
        }
    }

    void a() {
        a(this.c);
        a(this.d);
        a(this.e);
    }

    @Override // com.baidu.adp.framework.client.socket.link.c
    public boolean a(int i, String str) {
        if (this.f != null) {
            this.f.a(i, str);
        }
        if (this.h != null) {
            this.h.a();
        }
        if (!com.baidu.adp.lib.util.k.d() || c.e(this.e) || c.e(this.d) || c.e(this.c) || !BdSocketLinkService.isAvailable()) {
            a();
            return false;
        }
        c.f(this.c);
        c.a(this.d, this.e);
        c.a(this.d, this.c);
        while (true) {
            g b = c.b(this.d);
            if (b == null) {
                break;
            }
            b.c();
            a(b, l.q, null);
        }
        if (c.a(this.d) > 0) {
            m.a("queue", 0, 0, "onClose", l.y, "have retry message, MessageQueue:reconnect");
            BdSocketLinkService.startService(false, "have retry message");
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.c
    public void a(Map<String, String> map) {
        i.a().a(map);
        if (this.h != null) {
            this.h.b();
        }
        this.g = true;
        m.a("queue", 0, 0, "onConnected", l.C, "Queue blocked");
        if (this.f != null) {
            this.f.a(map);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.c
    public void a(byte[] bArr) {
        if (bArr != null) {
            this.i = System.currentTimeMillis();
            try {
                com.baidu.adp.framework.client.socket.coder.c a = com.baidu.adp.framework.client.socket.coder.b.a().a(bArr);
                int c = a.a.c();
                int e = a.a.e();
                m.a("queue", c, e, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
                g c2 = c(c, e);
                if (this.h != null) {
                    if (a.a.c() == this.h.c() && c.a(this.d, this.e)) {
                        f();
                    }
                    this.h.b();
                }
                if (e == 0 || (c2 != null && c2.l() == c)) {
                    new d(a, c2, this.b, e).execute(new String[0]);
                } else if (c2 != null) {
                    a(c2, l.D, null);
                }
                if (this.f != null) {
                    this.f.a(bArr);
                }
            } catch (CoderException e2) {
                m.a("queue", 0, 0, "onBinaryMesssage", l.l, "onBinaryMesssage decodeHeader error");
            }
        }
    }

    private g c(int i, int i2) {
        g gVar = null;
        if (i2 != 0) {
            g a = c.a(i2, this.c);
            if (a == null && (a = c.a(i2, this.e)) == null) {
                gVar = c.a(i2, this.d);
                if (gVar == null) {
                    m.a("queue", i, i2, "findSenderData", l.A, "original message removed , responsedMessage not dispatchMessage");
                }
            } else {
                gVar = a;
            }
            m.a("queue", i, i2, "findSenderData", l.z, "received ack message");
        }
        return gVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.c
    public void a(com.baidu.adp.lib.webSocket.d dVar) {
        f();
        if (this.f != null) {
            this.f.a(dVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.c
    public void a(String str) {
        if (this.f != null) {
            this.f.a(str);
        }
    }

    public void a(com.baidu.adp.framework.client.socket.link.c cVar) {
        this.f = cVar;
    }

    public void b() {
        boolean z = this.g;
        this.g = false;
        m.a("queue", 0, 0, "unBlockMessageQueue", l.w, "Queue block has release");
        if (z) {
            f();
        }
    }

    public void a(b bVar) {
        this.h = bVar;
    }

    public boolean c() {
        return BdSocketLinkService.isOpen() && !this.g && BdSocketLinkService.isAvailable();
    }

    public void a(int i) {
        a(0, i);
    }

    @Override // com.baidu.adp.framework.a
    public void a(int i, int i2) {
        c.a(this.c, i, i2);
        c.a(this.d, i, i2);
        c.a(this.e, i, i2);
    }

    public LinkedList<SocketMessage> b(int i) {
        return null;
    }

    @Override // com.baidu.adp.framework.a
    public LinkedList<SocketMessage> b(int i, int i2) {
        return null;
    }

    public long d() {
        return this.i;
    }
}
