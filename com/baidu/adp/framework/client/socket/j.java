package com.baidu.adp.framework.client.socket;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.coder.CoderException;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.framework.client.a<SocketMessage, SocketMessageTask> implements com.baidu.adp.framework.client.socket.link.g {
    private static /* synthetic */ int[] dy;
    private e dq;
    private final LinkedList<g> dr;
    private final LinkedList<g> ds;
    private final LinkedList<g> dt;
    private com.baidu.adp.framework.client.socket.link.g du;
    private boolean dv;
    private b dw;
    private long dx;

    static /* synthetic */ int[] ba() {
        int[] iArr = dy;
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
            dy = iArr;
        }
        return iArr;
    }

    public j(MessageManager messageManager) {
        super(messageManager);
        this.dq = null;
        this.dr = new LinkedList<>();
        this.ds = new LinkedList<>();
        this.dt = new LinkedList<>();
        this.du = null;
        this.dv = true;
        this.dw = null;
        this.dx = 0L;
        BdSocketLinkService.setConnStateCallBack(this);
        this.dq = new k(this);
    }

    public boolean a(SocketMessage socketMessage) {
        if (socketMessage != null && (socketMessage instanceof a)) {
            a aVar = (a) socketMessage;
            if (c.a(this.ds, aVar, socketMessage.getCmd()) || c.a(this.dr, aVar, socketMessage.getCmd()) || c.a(this.dt, aVar, socketMessage.getCmd())) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a
    /* renamed from: a */
    public void sendMessage(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        com.baidu.adp.lib.util.l.fs();
        if (socketMessage != null && socketMessageTask != null) {
            if (a(socketMessage, socketMessageTask.bG())) {
                m.a("queue", socketMessage, 0, "sendMessage", l.dU, "duplicate message be removed");
                return;
            }
            g gVar = new g(socketMessage, socketMessageTask, this);
            if (BdSocketLinkService.hasAbsoluteClose()) {
                m.a("queue", socketMessage, 0, "sendMessage", l.ed, "user manual close socket");
                gVar.u(l.ed);
            } else if (!BdSocketLinkService.isAvailable()) {
                m.a("queue", socketMessage, 0, "sendMessage", l.dT, "isManualBlock message be removed");
                gVar.u(l.dT);
            } else {
                m.a("queue", socketMessage, 0, "sendMessage", "socketclient: send message");
                c.a(gVar, this.ds);
                aU();
            }
        }
    }

    private boolean a(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        if (socketMessage != null) {
            int cmd = socketMessage.getCmd();
            switch (ba()[dupLicateMode.ordinal()]) {
                case 2:
                    if (c.b(this.ds, cmd) || c.b(this.dr, cmd) || c.b(this.dt, cmd)) {
                        return true;
                    }
                    break;
                case 3:
                    c.c(this.ds, cmd);
                    break;
                case 4:
                    c.c(this.ds, cmd);
                    c.c(this.dr, cmd);
                    c.c(this.dt, cmd);
                    break;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(f fVar) {
        if (fVar != null) {
            if (fVar.de != null) {
                a(fVar.de, l.dD, null);
                return;
            }
            SocketResponsedMessage socketResponsedMessage = fVar.dd;
            if (socketResponsedMessage != null) {
                m.a("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", "unpack succ");
                b(socketResponsedMessage);
            }
        }
    }

    public void b(g gVar) {
        if (gVar != null && gVar.aO() && gVar.aR() < gVar.ay()) {
            c.a(this.dr, this.dt, gVar);
            if (this.dw != null) {
                this.dw.b(true, "timeout seq = " + gVar.aN());
            }
            m.a("queue", gVar.aK(), gVar.aN(), "onSendTimeOut", l.dX, String.valueOf(gVar.aR()));
            return;
        }
        e(gVar);
        a(gVar, l.dO, null);
        aU();
    }

    public void a(int i, g gVar) {
        int i2;
        if (i == 2) {
            if (gVar.aI() != null) {
                i2 = gVar.aI().getErrorCode();
            } else {
                i2 = l.dK;
            }
        } else {
            i2 = l.dP;
        }
        String w = l.w(i2);
        e(gVar);
        a(gVar, i2, w);
    }

    public void c(g gVar) {
    }

    public void d(g gVar) {
        if (gVar != null) {
            if (gVar.aJ()) {
                gVar.aS();
                c.a(this.ds, this.dr, gVar);
                return;
            }
            c.b(gVar, this.ds);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void a(g gVar, int i, String str) {
        SocketResponsedMessage socketResponsedMessage;
        if (gVar != null && gVar.aK() != null) {
            int cmd = gVar.aK().getCmd();
            int aN = gVar.aN();
            m.a("queue", gVar.aK(), aN, "onMessageSendFail", i, String.valueOf(str) + " retryTime-" + gVar.aR());
            SocketMessageTask aL = gVar != null ? gVar.aL() : null;
            if (aL == null) {
                aL = (SocketMessageTask) this.cO.findTask(cmd);
            }
            if (aL != null && aL.getResponsedClass() != null) {
                try {
                    socketResponsedMessage = aL.getResponsedClass().newInstance();
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
                if (socketResponsedMessage == null) {
                    socketResponsedMessage.setError(i);
                    if (str == null) {
                        socketResponsedMessage.setErrorString(l.w(i));
                    } else {
                        socketResponsedMessage.setErrorString(str);
                    }
                    socketResponsedMessage.setOrginalMessage(gVar.aK());
                    m.a("queue", gVar.aK(), aN, "onMessageSendFail", "onMessageSendFail class = " + socketResponsedMessage.getClass().getName());
                    this.cO.dispatchResponsedMessage(socketResponsedMessage);
                    return;
                }
                return;
            }
            socketResponsedMessage = null;
            if (socketResponsedMessage == null) {
            }
        }
    }

    private void aU() {
        g d = c.d(this.ds);
        if (d != null) {
            if (BdSocketLinkService.isClose()) {
                m.a("queue", d.aK(), 0, "sendNext", l.dV, "");
                BdSocketLinkService.startService(false, "send message");
            } else if (!this.dv || d.getPriority() <= -3) {
                BdSocketLinkService.sendMessage(d);
            }
        }
    }

    private void b(SocketResponsedMessage socketResponsedMessage) {
        this.cO.dispatchResponsedMessage(socketResponsedMessage);
    }

    private void e(g gVar) {
        if (gVar != null) {
            gVar.aE();
            c.b(gVar, this.dr);
            c.b(gVar, this.ds);
            c.b(gVar, this.dt);
        }
    }

    private void h(LinkedList<g> linkedList) {
        while (true) {
            g e = c.e(linkedList);
            if (e != null) {
                e.aE();
                a(e, l.dQ, null);
            } else {
                return;
            }
        }
    }

    public void aV() {
        h(this.dr);
        h(this.ds);
        h(this.dt);
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public boolean k(int i, String str) {
        if (this.du != null) {
            this.du.k(i, str);
        }
        if (this.dw != null) {
            this.dw.av();
        }
        if (!com.baidu.adp.lib.util.l.isNetOk() || c.f(this.dt) || c.f(this.ds) || c.f(this.dr) || !BdSocketLinkService.isAvailable()) {
            aV();
            return false;
        }
        c.g(this.dr);
        c.a(this.ds, this.dt);
        c.a(this.ds, this.dr);
        while (true) {
            g c = c.c(this.ds);
            if (c == null) {
                break;
            }
            c.aE();
            a(c, l.dQ, null);
        }
        if (c.b(this.ds) > 0) {
            m.a("queue", 0, 0, "onClose", l.dY, "have retry message, MessageQueue:reconnect");
            BdSocketLinkService.startService(false, "have retry message");
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void c(Map<String, String> map) {
        i.aT().b(map);
        if (this.dw != null) {
            this.dw.aw();
        }
        this.dv = true;
        m.a("queue", 0, 0, "onConnected", l.ec, "Queue blocked");
        if (this.du != null) {
            this.du.c(map);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void e(byte[] bArr) {
        if (bArr != null) {
            this.dx = System.currentTimeMillis();
            try {
                com.baidu.adp.framework.client.socket.coder.c g = com.baidu.adp.framework.client.socket.coder.b.bk().g(bArr);
                int bh = g.es.bh();
                int bj = g.es.bj();
                m.a("queue", bh, bj, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
                g b = b(bh, bj);
                if (this.dw != null) {
                    if (g.es.bh() == this.dw.getCmd() && c.a(this.ds, this.dt)) {
                        aU();
                    }
                    this.dw.aw();
                }
                if (bj == 0 || (b != null && b.getCmd() == bh)) {
                    new d(g, b, this.dq, bj).execute(new String[0]);
                } else if (b != null) {
                    a(b, l.ee, null);
                }
                if (this.du != null) {
                    this.du.e(bArr);
                }
            } catch (CoderException e) {
                m.a("queue", 0, 0, "onBinaryMesssage", l.dL, "onBinaryMesssage decodeHeader error");
            }
        }
    }

    private g b(int i, int i2) {
        g gVar = null;
        if (i2 != 0) {
            g a = c.a(i2, this.dr);
            if (a == null && (a = c.a(i2, this.dt)) == null) {
                gVar = c.a(i2, this.ds);
                if (gVar == null) {
                    m.a("queue", i, i2, "findSenderData", l.ea, "original message removed , responsedMessage not dispatchMessage");
                }
            } else {
                gVar = a;
            }
            m.a("queue", i, i2, "findSenderData", l.dZ, "received ack message");
        }
        return gVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void a(com.baidu.adp.lib.webSocket.d dVar) {
        aU();
        if (this.du != null) {
            this.du.a(dVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void y(String str) {
        if (this.du != null) {
            this.du.y(str);
        }
    }

    public void a(com.baidu.adp.framework.client.socket.link.g gVar) {
        this.du = gVar;
    }

    public void aW() {
        boolean z = this.dv;
        this.dv = false;
        m.a("queue", 0, 0, "unBlockMessageQueue", l.dW, "Queue block has release");
        if (z) {
            aU();
        }
    }

    public void a(b bVar) {
        this.dw = bVar;
    }

    public boolean isValid() {
        return BdSocketLinkService.isOpen() && !this.dv && BdSocketLinkService.isAvailable();
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        removeMessage(0, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.a
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        c.b(this.dr, i, bdUniqueId);
        c.b(this.ds, i, bdUniqueId);
        c.b(this.dt, i, bdUniqueId);
    }

    public LinkedList<SocketMessage> a(BdUniqueId bdUniqueId) {
        return null;
    }

    @Override // com.baidu.adp.framework.a
    public LinkedList<SocketMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return null;
    }

    public boolean a(int i, BdUniqueId bdUniqueId) {
        return c.a(this.ds, i, bdUniqueId) || c.a(this.dr, i, bdUniqueId) || c.a(this.dt, i, bdUniqueId);
    }

    public long aX() {
        return this.dx;
    }

    public int aY() {
        return BdAsyncTask.getTaskNum(d.ax());
    }

    public int v(int i) {
        return BdAsyncTask.getTaskNum(String.valueOf(i), d.ax());
    }

    public b aZ() {
        return this.dw;
    }
}
