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
    private final LinkedList<e> qB;
    private com.baidu.adp.framework.client.socket.link.a qC;
    private boolean qD;
    private b qE;
    private long qF;
    private int qG;
    private d.a qy;
    private final LinkedList<e> qz;

    public g(MessageManager messageManager) {
        super(messageManager);
        this.qy = null;
        this.qz = new LinkedList<>();
        this.qA = new LinkedList<>();
        this.qB = new LinkedList<>();
        this.qC = null;
        this.qD = true;
        this.qE = null;
        this.qF = 0L;
        this.qG = 0;
        BdSocketLinkService.setConnStateCallBack(this);
        this.qy = new d.a() { // from class: com.baidu.adp.framework.client.socket.g.1
            @Override // com.baidu.adp.framework.client.socket.d.a
            public void a(d.b bVar) {
                g.this.b(bVar);
            }
        };
    }

    public boolean a(SocketMessage socketMessage) {
        if (socketMessage != null && (socketMessage instanceof a)) {
            a aVar = (a) socketMessage;
            if (c.a(this.qA, aVar, socketMessage.getCmd()) || c.a(this.qz, aVar, socketMessage.getCmd()) || c.a(this.qB, aVar, socketMessage.getCmd())) {
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
                i.a("queue", socketMessage, 0, "sendMessage", h.rf, "duplicate message be removed");
                return;
            }
            e eVar = new e(socketMessage, socketMessageTask, this);
            if (BdSocketLinkService.hasAbsoluteClose()) {
                i.a("queue", socketMessage, 0, "sendMessage", h.rp, "user manual close socket");
                eVar.P(h.rp);
            } else if (!BdSocketLinkService.isAvailable()) {
                i.a("queue", socketMessage, 0, "sendMessage", h.re, "isManualBlock message be removed");
                eVar.P(h.re);
            } else {
                i.a("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                c.a(eVar, this.qA);
                db();
            }
        }
    }

    private boolean a(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        if (socketMessage != null) {
            int cmd = socketMessage.getCmd();
            switch (dupLicateMode) {
                case REMOVE_ALL:
                    c.c(this.qA, cmd);
                    c.c(this.qz, cmd);
                    c.c(this.qB, cmd);
                    break;
                case REMOVE_WAITING:
                    c.c(this.qA, cmd);
                    break;
                case REMOVE_ME:
                    if (c.b(this.qA, cmd) || c.b(this.qz, cmd) || c.b(this.qB, cmd)) {
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
            if (bVar.qk != null) {
                a(bVar.qk, h.qM, null);
                return;
            }
            SocketResponsedMessage socketResponsedMessage = bVar.qj;
            if (socketResponsedMessage != null) {
                i.a("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
                b(socketResponsedMessage);
            }
        }
    }

    public void b(e eVar) {
        if (eVar != null && eVar.canRetry() && eVar.cY() < eVar.cG()) {
            c.a(this.qz, this.qB, eVar);
            if (this.qE != null) {
                this.qE.c(true, "timeout seq = " + eVar.cV());
            }
            i.a("queue", eVar.cS(), eVar.cV(), "onSendTimeOut", h.ri, String.valueOf(eVar.cY()));
            return;
        }
        e(eVar);
        a(eVar, h.qZ, null);
        db();
    }

    public void a(int i, e eVar) {
        int i2;
        if (i == 2) {
            if (eVar.cQ() != null) {
                i2 = eVar.cQ().getErrorCode();
            } else {
                i2 = h.qV;
            }
        } else {
            i2 = h.ra;
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
                c.a(this.qA, this.qz, eVar);
                return;
            }
            c.b(eVar, this.qA);
        }
    }

    protected void a(e eVar, int i, String str) {
        SocketResponsedMessage socketResponsedMessage = null;
        if (eVar != null && eVar.cS() != null) {
            int cmd = eVar.cS().getCmd();
            int cV = eVar.cV();
            i.a("queue", eVar.cS(), cV, "onMessageSendFail", i, str + " retryTime-" + eVar.cY());
            SocketMessageTask cT = eVar != null ? eVar.cT() : null;
            SocketMessageTask socketMessageTask = cT == null ? (SocketMessageTask) this.pT.findTask(cmd) : cT;
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
                this.pT.dispatchResponsedMessage(socketResponsedMessage);
            }
        }
    }

    private void db() {
        e d = c.d(this.qA);
        if (d != null) {
            if (BdSocketLinkService.isClose()) {
                i.a("queue", d.cS(), 0, "sendNext", h.rg, "");
                BdSocketLinkService.startService(false, "send message");
            } else if (!this.qD || d.getPriority() <= -3) {
                BdSocketLinkService.sendMessage(d);
            }
        }
    }

    private void b(SocketResponsedMessage socketResponsedMessage) {
        this.pT.dispatchResponsedMessage(socketResponsedMessage);
    }

    private void e(e eVar) {
        if (eVar != null) {
            eVar.cM();
            c.b(eVar, this.qz);
            c.b(eVar, this.qA);
            c.b(eVar, this.qB);
        }
    }

    private void h(LinkedList<e> linkedList) {
        while (true) {
            e e = c.e(linkedList);
            if (e != null) {
                e.cM();
                a(e, h.rb, null);
            } else {
                return;
            }
        }
    }

    public void dc() {
        h(this.qz);
        h(this.qA);
        h(this.qB);
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public boolean d(int i, String str) {
        if (this.qC != null) {
            this.qC.d(i, str);
        }
        if (this.qE != null) {
            this.qE.cD();
        }
        if (!k.hI() || c.f(this.qB) || c.f(this.qA) || c.f(this.qz) || !BdSocketLinkService.isAvailable()) {
            dc();
            return false;
        }
        c.g(this.qz);
        c.a(this.qA, this.qB);
        c.a(this.qA, this.qz);
        while (true) {
            e c = c.c(this.qA);
            if (c == null) {
                break;
            }
            c.cM();
            a(c, h.rb, null);
        }
        if (c.b(this.qA) > 0) {
            i.a("queue", 0, 0, "onClose", h.rj, "have retry message, MessageQueue:reconnect");
            BdSocketLinkService.startService(false, "have retry message");
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void e(Map<String, String> map) {
        f.da().d(map);
        if (this.qE != null) {
            this.qE.cE();
        }
        this.qD = true;
        i.a("queue", 0, 0, "onConnected", h.ro, "Queue blocked");
        if (this.qC != null) {
            this.qC.e(map);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void a(k.a aVar) {
        byte[] bArr;
        if (aVar != null && (bArr = aVar.Cb) != null) {
            this.qF = System.currentTimeMillis();
            try {
                com.baidu.adp.framework.client.socket.coder.c l = com.baidu.adp.framework.client.socket.coder.b.dt().l(bArr);
                this.qG = 0;
                int m2do = l.rJ.m2do();
                int dq = l.rJ.dq();
                i.a("queue", m2do, dq, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
                e o = o(m2do, dq);
                if (o != null) {
                    o.qu = aVar.qu;
                    o.qv = aVar.qv;
                }
                if (this.qE != null) {
                    if (l.rJ.m2do() == this.qE.getCmd() && c.a(this.qA, this.qB)) {
                        db();
                    }
                    this.qE.cE();
                }
                if (dq == 0 || (o != null && o.getCmd() == m2do)) {
                    new d(l, o, this.qy, dq).execute(new String[0]);
                } else if (o != null) {
                    a(o, h.rq, null);
                }
                if (this.qC != null) {
                    this.qC.a(aVar);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2000986));
            } catch (CoderException e) {
                int maxAlertCount = com.baidu.adp.lib.stats.switchs.a.gJ().getMaxAlertCount("alert_protobuf", 2);
                int i = this.qG + 1;
                this.qG = i;
                if (i >= maxAlertCount) {
                    BdStatisticsManager.getInstance().alert("alert_protobuf", "protbuf");
                }
                i.a("queue", 0, 0, "onBinaryMesssage", h.qW, "onBinaryMesssage decodeHeader error");
            }
        }
    }

    private e o(int i, int i2) {
        e eVar = null;
        if (i2 != 0) {
            e a = c.a(i2, this.qz);
            if (a == null && (a = c.a(i2, this.qB)) == null) {
                eVar = c.a(i2, this.qA);
                if (eVar == null) {
                    i.a("queue", i, i2, "findSenderData", h.rl, "original message removed , responsedMessage not dispatchMessage");
                }
            } else {
                eVar = a;
            }
            i.a("queue", i, i2, "findSenderData", h.rk, "received ack message");
        }
        return eVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
        db();
        if (this.qC != null) {
            this.qC.a(cVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void J(String str) {
        if (this.qC != null) {
            this.qC.J(str);
        }
    }

    public void a(com.baidu.adp.framework.client.socket.link.a aVar) {
        this.qC = aVar;
    }

    public void dd() {
        boolean z = this.qD;
        this.qD = false;
        i.a("queue", 0, 0, "unBlockMessageQueue", h.rh, "Queue block has release");
        if (z) {
            db();
        }
    }

    public void a(b bVar) {
        this.qE = bVar;
    }

    public boolean isValid() {
        return BdSocketLinkService.isOpen() && !this.qD && BdSocketLinkService.isAvailable();
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        removeMessage(0, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        c.b(this.qz, i, bdUniqueId);
        c.b(this.qA, i, bdUniqueId);
        c.b(this.qB, i, bdUniqueId);
    }

    public LinkedList<SocketMessage> a(BdUniqueId bdUniqueId) {
        return null;
    }

    @Override // com.baidu.adp.framework.b
    public LinkedList<SocketMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return null;
    }

    public boolean a(int i, BdUniqueId bdUniqueId) {
        return c.a(this.qA, i, bdUniqueId) || c.a(this.qz, i, bdUniqueId) || c.a(this.qB, i, bdUniqueId);
    }

    public long de() {
        return this.qF;
    }

    public int df() {
        return BdAsyncTask.getTaskNum(d.cF());
    }

    public int Q(int i) {
        return BdAsyncTask.getTaskNum(String.valueOf(i), d.cF());
    }

    public b dg() {
        return this.qE;
    }
}
