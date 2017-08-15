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
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.webSocket.k;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.framework.client.a<SocketMessage, SocketMessageTask> implements com.baidu.adp.framework.client.socket.link.a {
    private final LinkedList<e> qA;
    private com.baidu.adp.framework.client.socket.link.a qB;
    private boolean qC;
    private b qD;
    private long qE;
    private int qF;
    private d.a qx;
    private final LinkedList<e> qy;
    private final LinkedList<e> qz;

    public g(MessageManager messageManager) {
        super(messageManager);
        this.qx = null;
        this.qy = new LinkedList<>();
        this.qz = new LinkedList<>();
        this.qA = new LinkedList<>();
        this.qB = null;
        this.qC = true;
        this.qD = null;
        this.qE = 0L;
        this.qF = 0;
        BdSocketLinkService.setConnStateCallBack(this);
        this.qx = new d.a() { // from class: com.baidu.adp.framework.client.socket.g.1
            @Override // com.baidu.adp.framework.client.socket.d.a
            public void a(d.b bVar) {
                g.this.b(bVar);
            }
        };
    }

    public boolean a(SocketMessage socketMessage) {
        if (socketMessage != null && (socketMessage instanceof a)) {
            a aVar = (a) socketMessage;
            if (c.a(this.qz, aVar, socketMessage.getCmd()) || c.a(this.qy, aVar, socketMessage.getCmd()) || c.a(this.qA, aVar, socketMessage.getCmd())) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b
    public void a(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        k.hG();
        if (socketMessage != null && socketMessageTask != null) {
            if (a(socketMessage, socketMessageTask.dM())) {
                i.a("queue", socketMessage, 0, "sendMessage", h.re, "duplicate message be removed");
                return;
            }
            e eVar = new e(socketMessage, socketMessageTask, this);
            if (BdSocketLinkService.hasAbsoluteClose()) {
                i.a("queue", socketMessage, 0, "sendMessage", h.ro, "user manual close socket");
                eVar.P(h.ro);
            } else if (!BdSocketLinkService.isAvailable()) {
                i.a("queue", socketMessage, 0, "sendMessage", h.rd, "isManualBlock message be removed");
                eVar.P(h.rd);
            } else {
                i.a("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                c.a(eVar, this.qz);
                db();
            }
        }
    }

    private boolean a(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        if (socketMessage != null) {
            int cmd = socketMessage.getCmd();
            switch (dupLicateMode) {
                case REMOVE_ALL:
                    c.c(this.qz, cmd);
                    c.c(this.qy, cmd);
                    c.c(this.qA, cmd);
                    break;
                case REMOVE_WAITING:
                    c.c(this.qz, cmd);
                    break;
                case REMOVE_ME:
                    if (c.b(this.qz, cmd) || c.b(this.qy, cmd) || c.b(this.qA, cmd)) {
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
            if (bVar.qj != null) {
                a(bVar.qj, h.qL, null);
                return;
            }
            SocketResponsedMessage socketResponsedMessage = bVar.qi;
            if (socketResponsedMessage != null) {
                i.a("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
                b(socketResponsedMessage);
            }
        }
    }

    public void b(e eVar) {
        if (eVar != null && eVar.canRetry() && eVar.cY() < eVar.cG()) {
            c.a(this.qy, this.qA, eVar);
            if (this.qD != null) {
                this.qD.b(true, "timeout seq = " + eVar.cV());
            }
            i.a("queue", eVar.cS(), eVar.cV(), "onSendTimeOut", h.rh, String.valueOf(eVar.cY()));
            return;
        }
        e(eVar);
        a(eVar, h.qY, null);
        db();
    }

    public void a(int i, e eVar) {
        int i2;
        if (i == 2) {
            if (eVar.cQ() != null) {
                i2 = eVar.cQ().getErrorCode();
            } else {
                i2 = h.qU;
            }
        } else {
            i2 = h.qZ;
        }
        String R = h.R(i2);
        e(eVar);
        a(eVar, i2, R);
    }

    public void c(e eVar) {
    }

    public void d(e eVar) {
        if (eVar != null) {
            if (eVar.cR()) {
                eVar.cZ();
                c.a(this.qz, this.qy, eVar);
                return;
            }
            c.b(eVar, this.qz);
        }
    }

    protected void a(e eVar, int i, String str) {
        SocketResponsedMessage socketResponsedMessage = null;
        if (eVar != null && eVar.cS() != null) {
            int cmd = eVar.cS().getCmd();
            int cV = eVar.cV();
            i.a("queue", eVar.cS(), cV, "onMessageSendFail", i, str + " retryTime-" + eVar.cY());
            SocketMessageTask cT = eVar != null ? eVar.cT() : null;
            SocketMessageTask socketMessageTask = cT == null ? (SocketMessageTask) this.pS.findTask(cmd) : cT;
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
                    socketResponsedMessage.setErrorString(h.R(i));
                } else {
                    socketResponsedMessage.setErrorString(str);
                }
                socketResponsedMessage.setOrginalMessage(eVar.cS());
                i.a("queue", eVar.cS(), cV, "onMessageSendFail", i, "onMessageSendFail class = " + socketResponsedMessage.getClass().getName());
                this.pS.dispatchResponsedMessage(socketResponsedMessage);
            }
        }
    }

    private void db() {
        e d = c.d(this.qz);
        if (d != null) {
            if (BdSocketLinkService.isClose()) {
                i.a("queue", d.cS(), 0, "sendNext", h.rf, "");
                BdSocketLinkService.startService(false, "send message");
            } else if (!this.qC || d.getPriority() <= -3) {
                BdSocketLinkService.sendMessage(d);
            }
        }
    }

    private void b(SocketResponsedMessage socketResponsedMessage) {
        this.pS.dispatchResponsedMessage(socketResponsedMessage);
    }

    private void e(e eVar) {
        if (eVar != null) {
            eVar.cM();
            c.b(eVar, this.qy);
            c.b(eVar, this.qz);
            c.b(eVar, this.qA);
        }
    }

    private void h(LinkedList<e> linkedList) {
        while (true) {
            e e = c.e(linkedList);
            if (e != null) {
                e.cM();
                a(e, h.ra, null);
            } else {
                return;
            }
        }
    }

    public void dc() {
        h(this.qy);
        h(this.qz);
        h(this.qA);
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public boolean d(int i, String str) {
        if (this.qB != null) {
            this.qB.d(i, str);
        }
        if (this.qD != null) {
            this.qD.cD();
        }
        if (!k.hI() || c.f(this.qA) || c.f(this.qz) || c.f(this.qy) || !BdSocketLinkService.isAvailable()) {
            dc();
            return false;
        }
        c.g(this.qy);
        c.a(this.qz, this.qA);
        c.a(this.qz, this.qy);
        while (true) {
            e c = c.c(this.qz);
            if (c == null) {
                break;
            }
            c.cM();
            a(c, h.ra, null);
        }
        if (c.b(this.qz) > 0) {
            i.a("queue", 0, 0, "onClose", h.ri, "have retry message, MessageQueue:reconnect");
            BdSocketLinkService.startService(false, "have retry message");
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void e(Map<String, String> map) {
        f.da().d(map);
        if (this.qD != null) {
            this.qD.cE();
        }
        this.qC = true;
        i.a("queue", 0, 0, "onConnected", h.rm, "Queue blocked");
        if (this.qB != null) {
            this.qB.e(map);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void a(k.a aVar) {
        byte[] bArr;
        if (aVar != null && (bArr = aVar.Cb) != null) {
            this.qE = System.currentTimeMillis();
            try {
                com.baidu.adp.framework.client.socket.coder.c l = com.baidu.adp.framework.client.socket.coder.b.dt().l(bArr);
                this.qF = 0;
                int m2do = l.rI.m2do();
                int dq = l.rI.dq();
                i.a("queue", m2do, dq, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
                e o = o(m2do, dq);
                if (o != null) {
                    o.qt = aVar.qt;
                    o.qu = aVar.qu;
                }
                if (this.qD != null) {
                    if (l.rI.m2do() == this.qD.getCmd() && c.a(this.qz, this.qA)) {
                        db();
                    }
                    this.qD.cE();
                }
                if (dq == 0 || (o != null && o.getCmd() == m2do)) {
                    new d(l, o, this.qx, dq).execute(new String[0]);
                } else if (o != null) {
                    a(o, h.rp, null);
                }
                if (this.qB != null) {
                    this.qB.a(aVar);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2000986));
            } catch (CoderException e) {
                int maxAlertCount = com.baidu.adp.lib.stats.switchs.a.gJ().getMaxAlertCount("alert_protobuf", 2);
                int i = this.qF + 1;
                this.qF = i;
                if (i >= maxAlertCount) {
                    BdStatisticsManager.getInstance().alert("alert_protobuf", "protbuf");
                }
                i.a("queue", 0, 0, "onBinaryMesssage", h.qV, "onBinaryMesssage decodeHeader error");
            }
        }
    }

    private e o(int i, int i2) {
        e eVar = null;
        if (i2 != 0) {
            e a = c.a(i2, this.qy);
            if (a == null && (a = c.a(i2, this.qA)) == null) {
                eVar = c.a(i2, this.qz);
                if (eVar == null) {
                    i.a("queue", i, i2, "findSenderData", h.rk, "original message removed , responsedMessage not dispatchMessage");
                }
            } else {
                eVar = a;
            }
            i.a("queue", i, i2, "findSenderData", h.rj, "received ack message");
        }
        return eVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
        db();
        if (this.qB != null) {
            this.qB.a(cVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void I(String str) {
        if (this.qB != null) {
            this.qB.I(str);
        }
    }

    public void a(com.baidu.adp.framework.client.socket.link.a aVar) {
        this.qB = aVar;
    }

    public void dd() {
        boolean z = this.qC;
        this.qC = false;
        i.a("queue", 0, 0, "unBlockMessageQueue", h.rg, "Queue block has release");
        if (z) {
            db();
        }
    }

    public void a(b bVar) {
        this.qD = bVar;
    }

    public boolean isValid() {
        return BdSocketLinkService.isOpen() && !this.qC && BdSocketLinkService.isAvailable();
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        removeMessage(0, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        c.b(this.qy, i, bdUniqueId);
        c.b(this.qz, i, bdUniqueId);
        c.b(this.qA, i, bdUniqueId);
    }

    public LinkedList<SocketMessage> a(BdUniqueId bdUniqueId) {
        return null;
    }

    @Override // com.baidu.adp.framework.b
    public LinkedList<SocketMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return null;
    }

    public boolean a(int i, BdUniqueId bdUniqueId) {
        return c.a(this.qz, i, bdUniqueId) || c.a(this.qy, i, bdUniqueId) || c.a(this.qA, i, bdUniqueId);
    }

    public long de() {
        return this.qE;
    }

    public int df() {
        return BdAsyncTask.getTaskNum(d.cF());
    }

    public int Q(int i) {
        return BdAsyncTask.getTaskNum(String.valueOf(i), d.cF());
    }

    public b dg() {
        return this.qD;
    }
}
