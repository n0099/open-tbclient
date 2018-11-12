package com.baidu.adp.framework.client.socket;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.coder.CoderException;
import com.baidu.adp.framework.client.socket.d;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.lib.webSocket.k;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.framework.client.a<SocketMessage, SocketMessageTask> implements com.baidu.adp.framework.client.socket.link.a {
    private d.a wB;
    private final LinkedList<e> wC;
    private final LinkedList<e> wD;
    private final LinkedList<e> wE;
    private com.baidu.adp.framework.client.socket.link.a wF;
    private boolean wG;
    private b wH;
    private long wI;
    private int wJ;

    public g(MessageManager messageManager) {
        super(messageManager);
        this.wB = null;
        this.wC = new LinkedList<>();
        this.wD = new LinkedList<>();
        this.wE = new LinkedList<>();
        this.wF = null;
        this.wG = true;
        this.wH = null;
        this.wI = 0L;
        this.wJ = 0;
        BdSocketLinkService.setConnStateCallBack(this);
        this.wB = new d.a() { // from class: com.baidu.adp.framework.client.socket.g.1
            @Override // com.baidu.adp.framework.client.socket.d.a
            public void a(d.b bVar) {
                g.this.b(bVar);
            }
        };
    }

    public boolean a(SocketMessage socketMessage) {
        if (socketMessage != null && (socketMessage instanceof a)) {
            a aVar = (a) socketMessage;
            if (c.a(this.wD, aVar, socketMessage.getCmd()) || c.a(this.wC, aVar, socketMessage.getCmd()) || c.a(this.wE, aVar, socketMessage.getCmd())) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b
    public void a(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        l.lk();
        if (socketMessage != null && socketMessageTask != null) {
            if (a(socketMessage, socketMessageTask.hw())) {
                i.a("queue", socketMessage, 0, "sendMessage", h.xi, "duplicate message be removed");
                return;
            }
            e eVar = new e(socketMessage, socketMessageTask, this);
            if (BdSocketLinkService.hasAbsoluteClose()) {
                i.a("queue", socketMessage, 0, "sendMessage", h.xr, "user manual close socket");
                eVar.af(h.xr);
            } else if (!BdSocketLinkService.isAvailable()) {
                i.a("queue", socketMessage, 0, "sendMessage", h.xh, "isManualBlock message be removed");
                eVar.af(h.xh);
            } else {
                i.a("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                c.a(eVar, this.wD);
                gN();
            }
        }
    }

    private boolean a(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        if (socketMessage != null) {
            int cmd = socketMessage.getCmd();
            switch (dupLicateMode) {
                case REMOVE_ALL:
                    c.c(this.wD, cmd);
                    c.c(this.wC, cmd);
                    c.c(this.wE, cmd);
                    break;
                case REMOVE_WAITING:
                    c.c(this.wD, cmd);
                    break;
                case REMOVE_ME:
                    if (c.b(this.wD, cmd) || c.b(this.wC, cmd) || c.b(this.wE, cmd)) {
                        return true;
                    }
                    break;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(d.b bVar) {
        if (bVar != null) {
            if (bVar.wp != null) {
                a(bVar.wp, h.wP, null);
                return;
            }
            SocketResponsedMessage socketResponsedMessage = bVar.wo;
            if (socketResponsedMessage != null) {
                i.a("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
                b(socketResponsedMessage);
            }
        }
    }

    public void b(e eVar) {
        if (eVar != null && eVar.gH() && eVar.gK() < eVar.gs()) {
            c.a(this.wC, this.wE, eVar);
            if (this.wH != null) {
                this.wH.b(true, "timeout seq = " + eVar.getSequenceId());
            }
            i.a("queue", eVar.gE(), eVar.getSequenceId(), "onSendTimeOut", h.xl, String.valueOf(eVar.gK()));
            return;
        }
        e(eVar);
        a(eVar, h.xc, null);
        gN();
    }

    public void a(int i, e eVar) {
        int i2;
        if (i == 2) {
            if (eVar.gC() != null) {
                i2 = eVar.gC().getErrorCode();
            } else {
                i2 = h.wY;
            }
        } else {
            i2 = h.xd;
        }
        String ah = h.ah(i2);
        e(eVar);
        a(eVar, i2, ah);
    }

    public void c(e eVar) {
    }

    public void d(e eVar) {
        if (eVar != null) {
            if (eVar.gD()) {
                eVar.gL();
                c.a(this.wD, this.wC, eVar);
                return;
            }
            c.b(eVar, this.wD);
        }
    }

    protected void a(e eVar, int i, String str) {
        SocketResponsedMessage socketResponsedMessage = null;
        if (eVar != null && eVar.gE() != null) {
            int cmd = eVar.gE().getCmd();
            int sequenceId = eVar.getSequenceId();
            i.a("queue", eVar.gE(), sequenceId, "onMessageSendFail", i, str + " retryTime-" + eVar.gK());
            SocketMessageTask gF = eVar != null ? eVar.gF() : null;
            SocketMessageTask socketMessageTask = gF == null ? (SocketMessageTask) this.vW.findTask(cmd) : gF;
            if (socketMessageTask != null && socketMessageTask.getResponsedClass() != null) {
                try {
                    socketResponsedMessage = socketMessageTask.getResponsedClass().newInstance();
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    try {
                        socketResponsedMessage = socketMessageTask.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(cmd));
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
            }
            if (socketResponsedMessage != null) {
                socketResponsedMessage.setError(i);
                if (str == null) {
                    socketResponsedMessage.setErrorString(h.ah(i));
                } else {
                    socketResponsedMessage.setErrorString(str);
                }
                socketResponsedMessage.setOrginalMessage(eVar.gE());
                i.a("queue", eVar.gE(), sequenceId, "onMessageSendFail", i, "onMessageSendFail class = " + socketResponsedMessage.getClass().getName());
                this.vW.dispatchResponsedMessage(socketResponsedMessage);
            }
        }
    }

    private void gN() {
        e e = c.e(this.wD);
        if (e != null) {
            if (BdSocketLinkService.isClose()) {
                i.a("queue", e.gE(), 0, "sendNext", h.xj, "");
                BdSocketLinkService.startService(false, "send message");
            } else if (!this.wG || e.getPriority() <= -3) {
                BdSocketLinkService.sendMessage(e);
            }
        }
    }

    private void b(SocketResponsedMessage socketResponsedMessage) {
        this.vW.dispatchResponsedMessage(socketResponsedMessage);
    }

    private void e(e eVar) {
        if (eVar != null) {
            eVar.gy();
            c.b(eVar, this.wC);
            c.b(eVar, this.wD);
            c.b(eVar, this.wE);
        }
    }

    private void i(LinkedList<e> linkedList) {
        while (true) {
            e f = c.f(linkedList);
            if (f != null) {
                f.gy();
                a(f, h.xe, null);
            } else {
                return;
            }
        }
    }

    public void gO() {
        i(this.wC);
        i(this.wD);
        i(this.wE);
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public boolean e(int i, String str) {
        if (this.wF != null) {
            this.wF.e(i, str);
        }
        if (this.wH != null) {
            this.wH.gp();
        }
        if (!l.lm() || c.g(this.wE) || c.g(this.wD) || c.g(this.wC) || !BdSocketLinkService.isAvailable()) {
            gO();
            return false;
        }
        c.h(this.wC);
        c.a(this.wD, this.wE);
        c.a(this.wD, this.wC);
        while (true) {
            e d = c.d(this.wD);
            if (d == null) {
                break;
            }
            d.gy();
            a(d, h.xe, null);
        }
        if (c.c(this.wD) > 0) {
            i.a("queue", 0, 0, "onClose", h.xm, "have retry message, MessageQueue:reconnect");
            BdSocketLinkService.startService(false, "have retry message");
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void i(Map<String, String> map) {
        f.gM().h(map);
        if (this.wH != null) {
            this.wH.gq();
        }
        this.wG = true;
        i.a("queue", 0, 0, "onConnected", h.xq, "Queue blocked");
        if (this.wF != null) {
            this.wF.i(map);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void a(k.a aVar) {
        byte[] bArr;
        if (aVar != null && (bArr = aVar.HP) != null) {
            this.wI = System.currentTimeMillis();
            try {
                com.baidu.adp.framework.client.socket.coder.c n = com.baidu.adp.framework.client.socket.coder.b.he().n(bArr);
                this.wJ = 0;
                int command = n.xL.getCommand();
                int hb = n.xL.hb();
                i.a("queue", command, hb, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
                e p = p(command, hb);
                if (p != null) {
                    p.wx = aVar.wx;
                    p.wy = aVar.wy;
                }
                if (this.wH != null) {
                    if (n.xL.getCommand() == this.wH.getCmd() && c.a(this.wD, this.wE)) {
                        gN();
                    }
                    this.wH.gq();
                }
                if (hb == 0 || (p != null && p.getCmd() == command)) {
                    new d(n, p, this.wB, hb).execute(new String[0]);
                } else if (p != null) {
                    a(p, h.xs, null);
                }
                if (this.wF != null) {
                    this.wF.a(aVar);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2000986));
            } catch (CoderException e) {
                int maxAlertCount = com.baidu.adp.lib.stats.switchs.a.ko().getMaxAlertCount("alert_protobuf", 2);
                int i = this.wJ + 1;
                this.wJ = i;
                if (i >= maxAlertCount) {
                    BdStatisticsManager.getInstance().alert("alert_protobuf", "protbuf");
                }
                i.a("queue", 0, 0, "onBinaryMesssage", h.wZ, "onBinaryMesssage decodeHeader error");
            }
        }
    }

    private e p(int i, int i2) {
        e eVar = null;
        if (i2 != 0) {
            e a = c.a(i2, this.wC);
            if (a == null && (a = c.a(i2, this.wE)) == null) {
                eVar = c.a(i2, this.wD);
                if (eVar == null) {
                    i.a("queue", i, i2, "findSenderData", h.xo, "original message removed , responsedMessage not dispatchMessage");
                }
            } else {
                eVar = a;
            }
            i.a("queue", i, i2, "findSenderData", h.xn, "received ack message");
        }
        return eVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
        gN();
        if (this.wF != null) {
            this.wF.a(cVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void aj(String str) {
        if (this.wF != null) {
            this.wF.aj(str);
        }
    }

    public void a(com.baidu.adp.framework.client.socket.link.a aVar) {
        this.wF = aVar;
    }

    public void gP() {
        boolean z = this.wG;
        this.wG = false;
        i.a("queue", 0, 0, "unBlockMessageQueue", h.xk, "Queue block has release");
        if (z) {
            gN();
        }
    }

    public void a(b bVar) {
        this.wH = bVar;
    }

    public boolean isValid() {
        return BdSocketLinkService.isOpen() && !this.wG && BdSocketLinkService.isAvailable();
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        removeMessage(0, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        c.b(this.wC, i, bdUniqueId);
        c.b(this.wD, i, bdUniqueId);
        c.b(this.wE, i, bdUniqueId);
    }

    public LinkedList<SocketMessage> a(BdUniqueId bdUniqueId) {
        return null;
    }

    @Override // com.baidu.adp.framework.b
    public LinkedList<SocketMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return null;
    }

    public boolean a(int i, BdUniqueId bdUniqueId) {
        return c.a(this.wD, i, bdUniqueId) || c.a(this.wC, i, bdUniqueId) || c.a(this.wE, i, bdUniqueId);
    }

    public long gQ() {
        return this.wI;
    }

    public int gR() {
        return BdAsyncTask.getTaskNum(d.gr());
    }

    public int ag(int i) {
        return BdAsyncTask.getTaskNum(String.valueOf(i), d.gr());
    }

    public b gS() {
        return this.wH;
    }
}
