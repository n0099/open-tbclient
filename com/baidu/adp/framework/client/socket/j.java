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
    private static /* synthetic */ int[] dx;
    private e dp;
    private final LinkedList<g> dq;
    private final LinkedList<g> dr;
    private final LinkedList<g> ds;
    private com.baidu.adp.framework.client.socket.link.g dt;
    private boolean du;
    private b dv;
    private long dw;

    static /* synthetic */ int[] ba() {
        int[] iArr = dx;
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
            dx = iArr;
        }
        return iArr;
    }

    public j(MessageManager messageManager) {
        super(messageManager);
        this.dp = null;
        this.dq = new LinkedList<>();
        this.dr = new LinkedList<>();
        this.ds = new LinkedList<>();
        this.dt = null;
        this.du = true;
        this.dv = null;
        this.dw = 0L;
        BdSocketLinkService.setConnStateCallBack(this);
        this.dp = new k(this);
    }

    public boolean a(SocketMessage socketMessage) {
        if (socketMessage != null && (socketMessage instanceof a)) {
            a aVar = (a) socketMessage;
            if (c.a(this.dr, aVar, socketMessage.getCmd()) || c.a(this.dq, aVar, socketMessage.getCmd()) || c.a(this.ds, aVar, socketMessage.getCmd())) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a
    /* renamed from: a */
    public void sendMessage(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        com.baidu.adp.lib.util.l.ft();
        if (socketMessage != null && socketMessageTask != null) {
            if (a(socketMessage, socketMessageTask.bI())) {
                m.a("queue", socketMessage, 0, "sendMessage", l.dT, "duplicate message be removed");
                return;
            }
            g gVar = new g(socketMessage, socketMessageTask, this);
            if (!BdSocketLinkService.isAvailable()) {
                m.a("queue", socketMessage, 0, "sendMessage", l.dS, "isManualBlock message be removed");
                gVar.u(l.dS);
                return;
            }
            m.a("queue", socketMessage, 0, "sendMessage", "socketclient: send message");
            c.a(gVar, this.dr);
            aU();
        }
    }

    private boolean a(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        if (socketMessage != null) {
            int cmd = socketMessage.getCmd();
            switch (ba()[dupLicateMode.ordinal()]) {
                case 2:
                    if (c.b(this.dr, cmd) || c.b(this.dq, cmd) || c.b(this.ds, cmd)) {
                        return true;
                    }
                    break;
                case 3:
                    c.c(this.dr, cmd);
                    break;
                case 4:
                    c.c(this.dr, cmd);
                    c.c(this.dq, cmd);
                    c.c(this.ds, cmd);
                    break;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(f fVar) {
        if (fVar != null) {
            if (fVar.dd != null) {
                a(fVar.dd, l.dC, null);
                return;
            }
            SocketResponsedMessage socketResponsedMessage = fVar.dc;
            if (socketResponsedMessage != null) {
                m.a("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", "unpack succ");
                b(socketResponsedMessage);
            }
        }
    }

    public void b(g gVar) {
        if (gVar != null && gVar.aO() && gVar.aR() < gVar.ay()) {
            c.a(this.dq, this.ds, gVar);
            if (this.dv != null) {
                this.dv.b(true, "timeout seq = " + gVar.aN());
            }
            m.a("queue", gVar.aK(), gVar.aN(), "onSendTimeOut", l.dW, String.valueOf(gVar.aR()));
            return;
        }
        e(gVar);
        a(gVar, l.dN, null);
        aU();
    }

    public void a(int i, g gVar) {
        int i2;
        if (i == 2) {
            if (gVar.aI() != null) {
                i2 = gVar.aI().getErrorCode();
            } else {
                i2 = l.dJ;
            }
        } else {
            i2 = l.dO;
        }
        String v = l.v(i2);
        e(gVar);
        a(gVar, i2, v);
    }

    public void c(g gVar) {
    }

    public void d(g gVar) {
        if (gVar != null) {
            if (gVar.aJ()) {
                gVar.aS();
                c.a(this.dr, this.dq, gVar);
                return;
            }
            c.b(gVar, this.dr);
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
                aL = (SocketMessageTask) this.cN.findTask(cmd);
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
                        socketResponsedMessage.setErrorString(l.v(i));
                    } else {
                        socketResponsedMessage.setErrorString(str);
                    }
                    socketResponsedMessage.setOrginalMessage(gVar.aK());
                    m.a("queue", gVar.aK(), aN, "onMessageSendFail", "onMessageSendFail class = " + socketResponsedMessage.getClass().getName());
                    this.cN.dispatchResponsedMessage(socketResponsedMessage);
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
        g d = c.d(this.dr);
        if (d != null) {
            if (BdSocketLinkService.isClose()) {
                m.a("queue", d.aK(), 0, "sendNext", l.dU, "");
                BdSocketLinkService.startService(false, "send message");
            } else if (!this.du || d.getPriority() <= -3) {
                BdSocketLinkService.sendMessage(d);
            }
        }
    }

    private void b(SocketResponsedMessage socketResponsedMessage) {
        this.cN.dispatchResponsedMessage(socketResponsedMessage);
    }

    private void e(g gVar) {
        if (gVar != null) {
            gVar.aE();
            c.b(gVar, this.dq);
            c.b(gVar, this.dr);
            c.b(gVar, this.ds);
        }
    }

    private void h(LinkedList<g> linkedList) {
        while (true) {
            g e = c.e(linkedList);
            if (e != null) {
                e.aE();
                a(e, l.dP, null);
            } else {
                return;
            }
        }
    }

    void aV() {
        h(this.dq);
        h(this.dr);
        h(this.ds);
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public boolean k(int i, String str) {
        if (this.dt != null) {
            this.dt.k(i, str);
        }
        if (this.dv != null) {
            this.dv.av();
        }
        if (!com.baidu.adp.lib.util.l.isNetOk() || c.f(this.ds) || c.f(this.dr) || c.f(this.dq) || !BdSocketLinkService.isAvailable()) {
            aV();
            return false;
        }
        c.g(this.dq);
        c.a(this.dr, this.ds);
        c.a(this.dr, this.dq);
        while (true) {
            g c = c.c(this.dr);
            if (c == null) {
                break;
            }
            c.aE();
            a(c, l.dP, null);
        }
        if (c.b(this.dr) > 0) {
            m.a("queue", 0, 0, "onClose", l.dX, "have retry message, MessageQueue:reconnect");
            BdSocketLinkService.startService(false, "have retry message");
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void c(Map<String, String> map) {
        i.aT().b(map);
        if (this.dv != null) {
            this.dv.aw();
        }
        this.du = true;
        m.a("queue", 0, 0, "onConnected", l.eb, "Queue blocked");
        if (this.dt != null) {
            this.dt.c(map);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void e(byte[] bArr) {
        if (bArr != null) {
            this.dw = System.currentTimeMillis();
            try {
                com.baidu.adp.framework.client.socket.coder.c g = com.baidu.adp.framework.client.socket.coder.b.bk().g(bArr);
                int bh = g.eq.bh();
                int bj = g.eq.bj();
                m.a("queue", bh, bj, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
                g b = b(bh, bj);
                if (this.dv != null) {
                    if (g.eq.bh() == this.dv.getCmd() && c.a(this.dr, this.ds)) {
                        aU();
                    }
                    this.dv.aw();
                }
                if (bj == 0 || (b != null && b.getCmd() == bh)) {
                    new d(g, b, this.dp, bj).execute(new String[0]);
                } else if (b != null) {
                    a(b, l.ec, null);
                }
                if (this.dt != null) {
                    this.dt.e(bArr);
                }
            } catch (CoderException e) {
                m.a("queue", 0, 0, "onBinaryMesssage", l.dK, "onBinaryMesssage decodeHeader error");
            }
        }
    }

    private g b(int i, int i2) {
        g gVar = null;
        if (i2 != 0) {
            g a = c.a(i2, this.dq);
            if (a == null && (a = c.a(i2, this.ds)) == null) {
                gVar = c.a(i2, this.dr);
                if (gVar == null) {
                    m.a("queue", i, i2, "findSenderData", l.dZ, "original message removed , responsedMessage not dispatchMessage");
                }
            } else {
                gVar = a;
            }
            m.a("queue", i, i2, "findSenderData", l.dY, "received ack message");
        }
        return gVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void a(com.baidu.adp.lib.webSocket.d dVar) {
        aU();
        if (this.dt != null) {
            this.dt.a(dVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void y(String str) {
        if (this.dt != null) {
            this.dt.y(str);
        }
    }

    public void a(com.baidu.adp.framework.client.socket.link.g gVar) {
        this.dt = gVar;
    }

    public void aW() {
        boolean z = this.du;
        this.du = false;
        m.a("queue", 0, 0, "unBlockMessageQueue", l.dV, "Queue block has release");
        if (z) {
            aU();
        }
    }

    public void a(b bVar) {
        this.dv = bVar;
    }

    public boolean isValid() {
        return BdSocketLinkService.isOpen() && !this.du && BdSocketLinkService.isAvailable();
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        removeMessage(0, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.a
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        c.a(this.dq, i, bdUniqueId);
        c.a(this.dr, i, bdUniqueId);
        c.a(this.ds, i, bdUniqueId);
    }

    public LinkedList<SocketMessage> a(BdUniqueId bdUniqueId) {
        return null;
    }

    @Override // com.baidu.adp.framework.a
    public LinkedList<SocketMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return null;
    }

    public long aX() {
        return this.dw;
    }

    public int aY() {
        return BdAsyncTask.getTaskNum(d.ax());
    }

    public b aZ() {
        return this.dv;
    }
}
