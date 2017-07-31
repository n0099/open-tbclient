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
    private boolean qA;
    private b qB;
    private long qC;
    private int qD;
    private d.a qv;
    private final LinkedList<e> qw;
    private final LinkedList<e> qx;
    private final LinkedList<e> qy;
    private com.baidu.adp.framework.client.socket.link.a qz;

    public g(MessageManager messageManager) {
        super(messageManager);
        this.qv = null;
        this.qw = new LinkedList<>();
        this.qx = new LinkedList<>();
        this.qy = new LinkedList<>();
        this.qz = null;
        this.qA = true;
        this.qB = null;
        this.qC = 0L;
        this.qD = 0;
        BdSocketLinkService.setConnStateCallBack(this);
        this.qv = new d.a() { // from class: com.baidu.adp.framework.client.socket.g.1
            @Override // com.baidu.adp.framework.client.socket.d.a
            public void a(d.b bVar) {
                g.this.b(bVar);
            }
        };
    }

    public boolean a(SocketMessage socketMessage) {
        if (socketMessage != null && (socketMessage instanceof a)) {
            a aVar = (a) socketMessage;
            if (c.a(this.qx, aVar, socketMessage.getCmd()) || c.a(this.qw, aVar, socketMessage.getCmd()) || c.a(this.qy, aVar, socketMessage.getCmd())) {
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
                i.a("queue", socketMessage, 0, "sendMessage", h.rc, "duplicate message be removed");
                return;
            }
            e eVar = new e(socketMessage, socketMessageTask, this);
            if (BdSocketLinkService.hasAbsoluteClose()) {
                i.a("queue", socketMessage, 0, "sendMessage", h.rl, "user manual close socket");
                eVar.P(h.rl);
            } else if (!BdSocketLinkService.isAvailable()) {
                i.a("queue", socketMessage, 0, "sendMessage", h.rb, "isManualBlock message be removed");
                eVar.P(h.rb);
            } else {
                i.a("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                c.a(eVar, this.qx);
                db();
            }
        }
    }

    private boolean a(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        if (socketMessage != null) {
            int cmd = socketMessage.getCmd();
            switch (dupLicateMode) {
                case REMOVE_ALL:
                    c.c(this.qx, cmd);
                    c.c(this.qw, cmd);
                    c.c(this.qy, cmd);
                    break;
                case REMOVE_WAITING:
                    c.c(this.qx, cmd);
                    break;
                case REMOVE_ME:
                    if (c.b(this.qx, cmd) || c.b(this.qw, cmd) || c.b(this.qy, cmd)) {
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
            if (bVar.qh != null) {
                a(bVar.qh, h.qJ, null);
                return;
            }
            SocketResponsedMessage socketResponsedMessage = bVar.qg;
            if (socketResponsedMessage != null) {
                i.a("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
                b(socketResponsedMessage);
            }
        }
    }

    public void b(e eVar) {
        if (eVar != null && eVar.canRetry() && eVar.cY() < eVar.cG()) {
            c.a(this.qw, this.qy, eVar);
            if (this.qB != null) {
                this.qB.b(true, "timeout seq = " + eVar.cV());
            }
            i.a("queue", eVar.cS(), eVar.cV(), "onSendTimeOut", h.rf, String.valueOf(eVar.cY()));
            return;
        }
        e(eVar);
        a(eVar, h.qW, null);
        db();
    }

    public void a(int i, e eVar) {
        int i2;
        if (i == 2) {
            if (eVar.cQ() != null) {
                i2 = eVar.cQ().getErrorCode();
            } else {
                i2 = h.qS;
            }
        } else {
            i2 = h.qX;
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
                c.a(this.qx, this.qw, eVar);
                return;
            }
            c.b(eVar, this.qx);
        }
    }

    protected void a(e eVar, int i, String str) {
        SocketResponsedMessage socketResponsedMessage = null;
        if (eVar != null && eVar.cS() != null) {
            int cmd = eVar.cS().getCmd();
            int cV = eVar.cV();
            i.a("queue", eVar.cS(), cV, "onMessageSendFail", i, str + " retryTime-" + eVar.cY());
            SocketMessageTask cT = eVar != null ? eVar.cT() : null;
            SocketMessageTask socketMessageTask = cT == null ? (SocketMessageTask) this.pQ.findTask(cmd) : cT;
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
                this.pQ.dispatchResponsedMessage(socketResponsedMessage);
            }
        }
    }

    private void db() {
        e d = c.d(this.qx);
        if (d != null) {
            if (BdSocketLinkService.isClose()) {
                i.a("queue", d.cS(), 0, "sendNext", h.rd, "");
                BdSocketLinkService.startService(false, "send message");
            } else if (!this.qA || d.getPriority() <= -3) {
                BdSocketLinkService.sendMessage(d);
            }
        }
    }

    private void b(SocketResponsedMessage socketResponsedMessage) {
        this.pQ.dispatchResponsedMessage(socketResponsedMessage);
    }

    private void e(e eVar) {
        if (eVar != null) {
            eVar.cM();
            c.b(eVar, this.qw);
            c.b(eVar, this.qx);
            c.b(eVar, this.qy);
        }
    }

    private void h(LinkedList<e> linkedList) {
        while (true) {
            e e = c.e(linkedList);
            if (e != null) {
                e.cM();
                a(e, h.qY, null);
            } else {
                return;
            }
        }
    }

    public void dc() {
        h(this.qw);
        h(this.qx);
        h(this.qy);
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public boolean d(int i, String str) {
        if (this.qz != null) {
            this.qz.d(i, str);
        }
        if (this.qB != null) {
            this.qB.cD();
        }
        if (!k.hI() || c.f(this.qy) || c.f(this.qx) || c.f(this.qw) || !BdSocketLinkService.isAvailable()) {
            dc();
            return false;
        }
        c.g(this.qw);
        c.a(this.qx, this.qy);
        c.a(this.qx, this.qw);
        while (true) {
            e c = c.c(this.qx);
            if (c == null) {
                break;
            }
            c.cM();
            a(c, h.qY, null);
        }
        if (c.b(this.qx) > 0) {
            i.a("queue", 0, 0, "onClose", h.rg, "have retry message, MessageQueue:reconnect");
            BdSocketLinkService.startService(false, "have retry message");
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void e(Map<String, String> map) {
        f.da().d(map);
        if (this.qB != null) {
            this.qB.cE();
        }
        this.qA = true;
        i.a("queue", 0, 0, "onConnected", h.rk, "Queue blocked");
        if (this.qz != null) {
            this.qz.e(map);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void a(k.a aVar) {
        byte[] bArr;
        if (aVar != null && (bArr = aVar.BZ) != null) {
            this.qC = System.currentTimeMillis();
            try {
                com.baidu.adp.framework.client.socket.coder.c l = com.baidu.adp.framework.client.socket.coder.b.dt().l(bArr);
                this.qD = 0;
                int m2do = l.rG.m2do();
                int dq = l.rG.dq();
                i.a("queue", m2do, dq, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
                e o = o(m2do, dq);
                if (o != null) {
                    o.qr = aVar.qr;
                    o.qs = aVar.qs;
                }
                if (this.qB != null) {
                    if (l.rG.m2do() == this.qB.getCmd() && c.a(this.qx, this.qy)) {
                        db();
                    }
                    this.qB.cE();
                }
                if (dq == 0 || (o != null && o.getCmd() == m2do)) {
                    new d(l, o, this.qv, dq).execute(new String[0]);
                } else if (o != null) {
                    a(o, h.rm, null);
                }
                if (this.qz != null) {
                    this.qz.a(aVar);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2000986));
            } catch (CoderException e) {
                int maxAlertCount = com.baidu.adp.lib.stats.switchs.a.gJ().getMaxAlertCount("alert_protobuf", 2);
                int i = this.qD + 1;
                this.qD = i;
                if (i >= maxAlertCount) {
                    BdStatisticsManager.getInstance().alert("alert_protobuf", "protbuf");
                }
                i.a("queue", 0, 0, "onBinaryMesssage", h.qT, "onBinaryMesssage decodeHeader error");
            }
        }
    }

    private e o(int i, int i2) {
        e eVar = null;
        if (i2 != 0) {
            e a = c.a(i2, this.qw);
            if (a == null && (a = c.a(i2, this.qy)) == null) {
                eVar = c.a(i2, this.qx);
                if (eVar == null) {
                    i.a("queue", i, i2, "findSenderData", h.ri, "original message removed , responsedMessage not dispatchMessage");
                }
            } else {
                eVar = a;
            }
            i.a("queue", i, i2, "findSenderData", h.rh, "received ack message");
        }
        return eVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
        db();
        if (this.qz != null) {
            this.qz.a(cVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void I(String str) {
        if (this.qz != null) {
            this.qz.I(str);
        }
    }

    public void a(com.baidu.adp.framework.client.socket.link.a aVar) {
        this.qz = aVar;
    }

    public void dd() {
        boolean z = this.qA;
        this.qA = false;
        i.a("queue", 0, 0, "unBlockMessageQueue", h.re, "Queue block has release");
        if (z) {
            db();
        }
    }

    public void a(b bVar) {
        this.qB = bVar;
    }

    public boolean isValid() {
        return BdSocketLinkService.isOpen() && !this.qA && BdSocketLinkService.isAvailable();
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        removeMessage(0, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        c.b(this.qw, i, bdUniqueId);
        c.b(this.qx, i, bdUniqueId);
        c.b(this.qy, i, bdUniqueId);
    }

    public LinkedList<SocketMessage> a(BdUniqueId bdUniqueId) {
        return null;
    }

    @Override // com.baidu.adp.framework.b
    public LinkedList<SocketMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return null;
    }

    public boolean a(int i, BdUniqueId bdUniqueId) {
        return c.a(this.qx, i, bdUniqueId) || c.a(this.qw, i, bdUniqueId) || c.a(this.qy, i, bdUniqueId);
    }

    public long de() {
        return this.qC;
    }

    public int df() {
        return BdAsyncTask.getTaskNum(d.cF());
    }

    public int Q(int i) {
        return BdAsyncTask.getTaskNum(String.valueOf(i), d.cF());
    }

    public b dg() {
        return this.qB;
    }
}
