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
import com.baidu.adp.lib.util.n;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.framework.client.a<SocketMessage, SocketMessageTask> implements com.baidu.adp.framework.client.socket.link.g {
    private static /* synthetic */ int[] oM;
    private e oE;
    private final LinkedList<g> oF;
    private final LinkedList<g> oG;
    private final LinkedList<g> oH;
    private com.baidu.adp.framework.client.socket.link.g oI;
    private boolean oJ;
    private b oK;
    private long oL;

    static /* synthetic */ int[] ex() {
        int[] iArr = oM;
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
            oM = iArr;
        }
        return iArr;
    }

    public j(MessageManager messageManager) {
        super(messageManager);
        this.oE = null;
        this.oF = new LinkedList<>();
        this.oG = new LinkedList<>();
        this.oH = new LinkedList<>();
        this.oI = null;
        this.oJ = true;
        this.oK = null;
        this.oL = 0L;
        BdSocketLinkService.setConnStateCallBack(this);
        this.oE = new k(this);
    }

    public boolean a(SocketMessage socketMessage) {
        if (socketMessage != null && (socketMessage instanceof a)) {
            a aVar = (a) socketMessage;
            if (c.a(this.oG, aVar, socketMessage.getCmd()) || c.a(this.oF, aVar, socketMessage.getCmd()) || c.a(this.oH, aVar, socketMessage.getCmd())) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a
    /* renamed from: a */
    public void sendMessage(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        n.iV();
        if (socketMessage != null && socketMessageTask != null) {
            if (a(socketMessage, socketMessageTask.fe())) {
                m.a("queue", socketMessage, 0, "sendMessage", l.pl, "duplicate message be removed");
                return;
            }
            g gVar = new g(socketMessage, socketMessageTask, this);
            if (BdSocketLinkService.hasAbsoluteClose()) {
                m.a("queue", socketMessage, 0, "sendMessage", l.pw, "user manual close socket");
                gVar.v(l.pw);
            } else if (!BdSocketLinkService.isAvailable()) {
                m.a("queue", socketMessage, 0, "sendMessage", l.pj, "isManualBlock message be removed");
                gVar.v(l.pj);
            } else {
                m.a("queue", socketMessage, 0, "sendMessage", "socketclient: send message");
                c.a(gVar, this.oG);
                er();
            }
        }
    }

    private boolean a(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        if (socketMessage != null) {
            int cmd = socketMessage.getCmd();
            switch (ex()[dupLicateMode.ordinal()]) {
                case 2:
                    if (c.b(this.oG, cmd) || c.b(this.oF, cmd) || c.b(this.oH, cmd)) {
                        return true;
                    }
                    break;
                case 3:
                    c.c(this.oG, cmd);
                    break;
                case 4:
                    c.c(this.oG, cmd);
                    c.c(this.oF, cmd);
                    c.c(this.oH, cmd);
                    break;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(f fVar) {
        if (fVar != null) {
            if (fVar.os != null) {
                a(fVar.os, l.oR, null);
                return;
            }
            SocketResponsedMessage socketResponsedMessage = fVar.or;
            if (socketResponsedMessage != null) {
                m.a("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", "unpack succ");
                b(socketResponsedMessage);
            }
        }
    }

    public void b(g gVar) {
        if (gVar != null && gVar.el() && gVar.eo() < gVar.dV()) {
            c.a(this.oF, this.oH, gVar);
            if (this.oK != null) {
                this.oK.b(true, "timeout seq = " + gVar.ek());
            }
            m.a("queue", gVar.eh(), gVar.ek(), "onSendTimeOut", l.pq, String.valueOf(gVar.eo()));
            return;
        }
        e(gVar);
        a(gVar, l.pe, null);
        er();
    }

    public void a(int i, g gVar) {
        int i2;
        if (i == 2) {
            if (gVar.ef() != null) {
                i2 = gVar.ef().getErrorCode();
            } else {
                i2 = l.oY;
            }
        } else {
            i2 = l.pf;
        }
        String x = l.x(i2);
        e(gVar);
        a(gVar, i2, x);
    }

    public void c(g gVar) {
    }

    public void d(g gVar) {
        if (gVar != null) {
            if (gVar.eg()) {
                gVar.ep();
                c.a(this.oG, this.oF, gVar);
                return;
            }
            c.b(gVar, this.oG);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void a(g gVar, int i, String str) {
        SocketResponsedMessage socketResponsedMessage;
        if (gVar != null && gVar.eh() != null) {
            int cmd = gVar.eh().getCmd();
            int ek = gVar.ek();
            m.a("queue", gVar.eh(), ek, "onMessageSendFail", i, String.valueOf(str) + " retryTime-" + gVar.eo());
            SocketMessageTask ei = gVar != null ? gVar.ei() : null;
            if (ei == null) {
                ei = (SocketMessageTask) this.nY.findTask(cmd);
            }
            if (ei != null && ei.getResponsedClass() != null) {
                try {
                    socketResponsedMessage = ei.getResponsedClass().newInstance();
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
                if (socketResponsedMessage == null) {
                    socketResponsedMessage.setError(i);
                    if (str == null) {
                        socketResponsedMessage.setErrorString(l.x(i));
                    } else {
                        socketResponsedMessage.setErrorString(str);
                    }
                    socketResponsedMessage.setOrginalMessage(gVar.eh());
                    m.a("queue", gVar.eh(), ek, "onMessageSendFail", "onMessageSendFail class = " + socketResponsedMessage.getClass().getName());
                    this.nY.dispatchResponsedMessage(socketResponsedMessage);
                    return;
                }
                return;
            }
            socketResponsedMessage = null;
            if (socketResponsedMessage == null) {
            }
        }
    }

    private void er() {
        g d = c.d(this.oG);
        if (d != null) {
            if (BdSocketLinkService.isClose()) {
                m.a("queue", d.eh(), 0, "sendNext", l.po, "");
                BdSocketLinkService.startService(false, "send message");
            } else if (!this.oJ || d.getPriority() <= -3) {
                BdSocketLinkService.sendMessage(d);
            }
        }
    }

    private void b(SocketResponsedMessage socketResponsedMessage) {
        this.nY.dispatchResponsedMessage(socketResponsedMessage);
    }

    private void e(g gVar) {
        if (gVar != null) {
            gVar.eb();
            c.b(gVar, this.oF);
            c.b(gVar, this.oG);
            c.b(gVar, this.oH);
        }
    }

    private void h(LinkedList<g> linkedList) {
        while (true) {
            g e = c.e(linkedList);
            if (e != null) {
                e.eb();
                a(e, l.pg, null);
            } else {
                return;
            }
        }
    }

    public void es() {
        h(this.oF);
        h(this.oG);
        h(this.oH);
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public boolean k(int i, String str) {
        if (this.oI != null) {
            this.oI.k(i, str);
        }
        if (this.oK != null) {
            this.oK.dS();
        }
        if (!n.isNetOk() || c.f(this.oH) || c.f(this.oG) || c.f(this.oF) || !BdSocketLinkService.isAvailable()) {
            es();
            return false;
        }
        c.g(this.oF);
        c.a(this.oG, this.oH);
        c.a(this.oG, this.oF);
        while (true) {
            g c = c.c(this.oG);
            if (c == null) {
                break;
            }
            c.eb();
            a(c, l.pg, null);
        }
        if (c.b(this.oG) > 0) {
            m.a("queue", 0, 0, "onClose", l.pr, "have retry message, MessageQueue:reconnect");
            BdSocketLinkService.startService(false, "have retry message");
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void c(Map<String, String> map) {
        i.eq().b(map);
        if (this.oK != null) {
            this.oK.dT();
        }
        this.oJ = true;
        m.a("queue", 0, 0, "onConnected", l.pv, "Queue blocked");
        if (this.oI != null) {
            this.oI.c(map);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void e(byte[] bArr) {
        if (bArr != null) {
            this.oL = System.currentTimeMillis();
            try {
                com.baidu.adp.framework.client.socket.coder.c h = com.baidu.adp.framework.client.socket.coder.b.eH().h(bArr);
                int eE = h.pL.eE();
                int eG = h.pL.eG();
                m.a("queue", eE, eG, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
                g b = b(eE, eG);
                if (this.oK != null) {
                    if (h.pL.eE() == this.oK.getCmd() && c.a(this.oG, this.oH)) {
                        er();
                    }
                    this.oK.dT();
                }
                if (eG == 0 || (b != null && b.getCmd() == eE)) {
                    new d(h, b, this.oE, eG).execute(new String[0]);
                } else if (b != null) {
                    a(b, l.px, null);
                }
                if (this.oI != null) {
                    this.oI.e(bArr);
                }
            } catch (CoderException e) {
                m.a("queue", 0, 0, "onBinaryMesssage", l.oZ, "onBinaryMesssage decodeHeader error");
            }
        }
    }

    private g b(int i, int i2) {
        g gVar = null;
        if (i2 != 0) {
            g a = c.a(i2, this.oF);
            if (a == null && (a = c.a(i2, this.oH)) == null) {
                gVar = c.a(i2, this.oG);
                if (gVar == null) {
                    m.a("queue", i, i2, "findSenderData", l.pt, "original message removed , responsedMessage not dispatchMessage");
                }
            } else {
                gVar = a;
            }
            m.a("queue", i, i2, "findSenderData", l.ps, "received ack message");
        }
        return gVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
        er();
        if (this.oI != null) {
            this.oI.a(cVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void G(String str) {
        if (this.oI != null) {
            this.oI.G(str);
        }
    }

    public void a(com.baidu.adp.framework.client.socket.link.g gVar) {
        this.oI = gVar;
    }

    public void et() {
        boolean z = this.oJ;
        this.oJ = false;
        m.a("queue", 0, 0, "unBlockMessageQueue", l.pp, "Queue block has release");
        if (z) {
            er();
        }
    }

    public void a(b bVar) {
        this.oK = bVar;
    }

    public boolean isValid() {
        return BdSocketLinkService.isOpen() && !this.oJ && BdSocketLinkService.isAvailable();
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        removeMessage(0, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.a
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        c.b(this.oF, i, bdUniqueId);
        c.b(this.oG, i, bdUniqueId);
        c.b(this.oH, i, bdUniqueId);
    }

    public LinkedList<SocketMessage> a(BdUniqueId bdUniqueId) {
        return null;
    }

    @Override // com.baidu.adp.framework.a
    public LinkedList<SocketMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return null;
    }

    public boolean a(int i, BdUniqueId bdUniqueId) {
        return c.a(this.oG, i, bdUniqueId) || c.a(this.oF, i, bdUniqueId) || c.a(this.oH, i, bdUniqueId);
    }

    public long eu() {
        return this.oL;
    }

    public int ev() {
        return BdAsyncTask.getTaskNum(d.dU());
    }

    public int w(int i) {
        return BdAsyncTask.getTaskNum(String.valueOf(i), d.dU());
    }

    public b ew() {
        return this.oK;
    }
}
