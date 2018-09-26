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
    private d.a vL;
    private final LinkedList<e> vM;
    private final LinkedList<e> vN;
    private final LinkedList<e> vO;
    private com.baidu.adp.framework.client.socket.link.a vP;
    private boolean vQ;
    private b vR;
    private long vS;
    private int vT;

    public g(MessageManager messageManager) {
        super(messageManager);
        this.vL = null;
        this.vM = new LinkedList<>();
        this.vN = new LinkedList<>();
        this.vO = new LinkedList<>();
        this.vP = null;
        this.vQ = true;
        this.vR = null;
        this.vS = 0L;
        this.vT = 0;
        BdSocketLinkService.setConnStateCallBack(this);
        this.vL = new d.a() { // from class: com.baidu.adp.framework.client.socket.g.1
            @Override // com.baidu.adp.framework.client.socket.d.a
            public void a(d.b bVar) {
                g.this.b(bVar);
            }
        };
    }

    public boolean a(SocketMessage socketMessage) {
        if (socketMessage != null && (socketMessage instanceof a)) {
            a aVar = (a) socketMessage;
            if (c.a(this.vN, aVar, socketMessage.getCmd()) || c.a(this.vM, aVar, socketMessage.getCmd()) || c.a(this.vO, aVar, socketMessage.getCmd())) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b
    public void a(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        l.kZ();
        if (socketMessage != null && socketMessageTask != null) {
            if (a(socketMessage, socketMessageTask.hg())) {
                i.a("queue", socketMessage, 0, "sendMessage", h.wt, "duplicate message be removed");
                return;
            }
            e eVar = new e(socketMessage, socketMessageTask, this);
            if (BdSocketLinkService.hasAbsoluteClose()) {
                i.a("queue", socketMessage, 0, "sendMessage", h.wC, "user manual close socket");
                eVar.O(h.wC);
            } else if (!BdSocketLinkService.isAvailable()) {
                i.a("queue", socketMessage, 0, "sendMessage", h.ws, "isManualBlock message be removed");
                eVar.O(h.ws);
            } else {
                i.a("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                c.a(eVar, this.vN);
                gv();
            }
        }
    }

    private boolean a(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        if (socketMessage != null) {
            int cmd = socketMessage.getCmd();
            switch (dupLicateMode) {
                case REMOVE_ALL:
                    c.c(this.vN, cmd);
                    c.c(this.vM, cmd);
                    c.c(this.vO, cmd);
                    break;
                case REMOVE_WAITING:
                    c.c(this.vN, cmd);
                    break;
                case REMOVE_ME:
                    if (c.b(this.vN, cmd) || c.b(this.vM, cmd) || c.b(this.vO, cmd)) {
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
            if (bVar.vy != null) {
                a(bVar.vy, h.vZ, null);
                return;
            }
            SocketResponsedMessage socketResponsedMessage = bVar.vx;
            if (socketResponsedMessage != null) {
                i.a("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
                b(socketResponsedMessage);
            }
        }
    }

    public void b(e eVar) {
        if (eVar != null && eVar.gp() && eVar.gs() < eVar.fZ()) {
            c.a(this.vM, this.vO, eVar);
            if (this.vR != null) {
                this.vR.b(true, "timeout seq = " + eVar.getSequenceId());
            }
            i.a("queue", eVar.gm(), eVar.getSequenceId(), "onSendTimeOut", h.ww, String.valueOf(eVar.gs()));
            return;
        }
        e(eVar);
        a(eVar, h.wn, null);
        gv();
    }

    public void a(int i, e eVar) {
        int i2;
        if (i == 2) {
            if (eVar.gk() != null) {
                i2 = eVar.gk().getErrorCode();
            } else {
                i2 = h.wi;
            }
        } else {
            i2 = h.wo;
        }
        String Q = h.Q(i2);
        e(eVar);
        a(eVar, i2, Q);
    }

    public void c(e eVar) {
    }

    public void d(e eVar) {
        if (eVar != null) {
            if (eVar.gl()) {
                eVar.gt();
                c.a(this.vN, this.vM, eVar);
                return;
            }
            c.b(eVar, this.vN);
        }
    }

    protected void a(e eVar, int i, String str) {
        SocketResponsedMessage socketResponsedMessage = null;
        if (eVar != null && eVar.gm() != null) {
            int cmd = eVar.gm().getCmd();
            int sequenceId = eVar.getSequenceId();
            i.a("queue", eVar.gm(), sequenceId, "onMessageSendFail", i, str + " retryTime-" + eVar.gs());
            SocketMessageTask gn = eVar != null ? eVar.gn() : null;
            SocketMessageTask socketMessageTask = gn == null ? (SocketMessageTask) this.vh.findTask(cmd) : gn;
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
                    socketResponsedMessage.setErrorString(h.Q(i));
                } else {
                    socketResponsedMessage.setErrorString(str);
                }
                socketResponsedMessage.setOrginalMessage(eVar.gm());
                i.a("queue", eVar.gm(), sequenceId, "onMessageSendFail", i, "onMessageSendFail class = " + socketResponsedMessage.getClass().getName());
                this.vh.dispatchResponsedMessage(socketResponsedMessage);
            }
        }
    }

    private void gv() {
        e e = c.e(this.vN);
        if (e != null) {
            if (BdSocketLinkService.isClose()) {
                i.a("queue", e.gm(), 0, "sendNext", h.wu, "");
                BdSocketLinkService.startService(false, "send message");
            } else if (!this.vQ || e.getPriority() <= -3) {
                BdSocketLinkService.sendMessage(e);
            }
        }
    }

    private void b(SocketResponsedMessage socketResponsedMessage) {
        this.vh.dispatchResponsedMessage(socketResponsedMessage);
    }

    private void e(e eVar) {
        if (eVar != null) {
            eVar.gg();
            c.b(eVar, this.vM);
            c.b(eVar, this.vN);
            c.b(eVar, this.vO);
        }
    }

    private void i(LinkedList<e> linkedList) {
        while (true) {
            e f = c.f(linkedList);
            if (f != null) {
                f.gg();
                a(f, h.wp, null);
            } else {
                return;
            }
        }
    }

    public void gw() {
        i(this.vM);
        i(this.vN);
        i(this.vO);
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public boolean e(int i, String str) {
        if (this.vP != null) {
            this.vP.e(i, str);
        }
        if (this.vR != null) {
            this.vR.fW();
        }
        if (!l.lb() || c.g(this.vO) || c.g(this.vN) || c.g(this.vM) || !BdSocketLinkService.isAvailable()) {
            gw();
            return false;
        }
        c.h(this.vM);
        c.a(this.vN, this.vO);
        c.a(this.vN, this.vM);
        while (true) {
            e d = c.d(this.vN);
            if (d == null) {
                break;
            }
            d.gg();
            a(d, h.wp, null);
        }
        if (c.c(this.vN) > 0) {
            i.a("queue", 0, 0, "onClose", h.wx, "have retry message, MessageQueue:reconnect");
            BdSocketLinkService.startService(false, "have retry message");
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void i(Map<String, String> map) {
        f.gu().h(map);
        if (this.vR != null) {
            this.vR.fX();
        }
        this.vQ = true;
        i.a("queue", 0, 0, "onConnected", h.wB, "Queue blocked");
        if (this.vP != null) {
            this.vP.i(map);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void a(k.a aVar) {
        byte[] bArr;
        if (aVar != null && (bArr = aVar.Hg) != null) {
            this.vS = System.currentTimeMillis();
            try {
                com.baidu.adp.framework.client.socket.coder.c o = com.baidu.adp.framework.client.socket.coder.b.gN().o(bArr);
                this.vT = 0;
                int command = o.wW.getCommand();
                int gK = o.wW.gK();
                i.a("queue", command, gK, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
                e p = p(command, gK);
                if (p != null) {
                    p.vH = aVar.vH;
                    p.vI = aVar.vI;
                }
                if (this.vR != null) {
                    if (o.wW.getCommand() == this.vR.getCmd() && c.a(this.vN, this.vO)) {
                        gv();
                    }
                    this.vR.fX();
                }
                if (gK == 0 || (p != null && p.getCmd() == command)) {
                    new d(o, p, this.vL, gK).execute(new String[0]);
                } else if (p != null) {
                    a(p, h.wD, null);
                }
                if (this.vP != null) {
                    this.vP.a(aVar);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2000986));
            } catch (CoderException e) {
                int maxAlertCount = com.baidu.adp.lib.stats.switchs.a.kc().getMaxAlertCount("alert_protobuf", 2);
                int i = this.vT + 1;
                this.vT = i;
                if (i >= maxAlertCount) {
                    BdStatisticsManager.getInstance().alert("alert_protobuf", "protbuf");
                }
                i.a("queue", 0, 0, "onBinaryMesssage", h.wj, "onBinaryMesssage decodeHeader error");
            }
        }
    }

    private e p(int i, int i2) {
        e eVar = null;
        if (i2 != 0) {
            e a = c.a(i2, this.vM);
            if (a == null && (a = c.a(i2, this.vO)) == null) {
                eVar = c.a(i2, this.vN);
                if (eVar == null) {
                    i.a("queue", i, i2, "findSenderData", h.wz, "original message removed , responsedMessage not dispatchMessage");
                }
            } else {
                eVar = a;
            }
            i.a("queue", i, i2, "findSenderData", h.wy, "received ack message");
        }
        return eVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
        gv();
        if (this.vP != null) {
            this.vP.a(cVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void aj(String str) {
        if (this.vP != null) {
            this.vP.aj(str);
        }
    }

    public void a(com.baidu.adp.framework.client.socket.link.a aVar) {
        this.vP = aVar;
    }

    public void gx() {
        boolean z = this.vQ;
        this.vQ = false;
        i.a("queue", 0, 0, "unBlockMessageQueue", h.wv, "Queue block has release");
        if (z) {
            gv();
        }
    }

    public void a(b bVar) {
        this.vR = bVar;
    }

    public boolean isValid() {
        return BdSocketLinkService.isOpen() && !this.vQ && BdSocketLinkService.isAvailable();
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        removeMessage(0, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        c.b(this.vM, i, bdUniqueId);
        c.b(this.vN, i, bdUniqueId);
        c.b(this.vO, i, bdUniqueId);
    }

    public LinkedList<SocketMessage> a(BdUniqueId bdUniqueId) {
        return null;
    }

    @Override // com.baidu.adp.framework.b
    public LinkedList<SocketMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return null;
    }

    public boolean a(int i, BdUniqueId bdUniqueId) {
        return c.a(this.vN, i, bdUniqueId) || c.a(this.vM, i, bdUniqueId) || c.a(this.vO, i, bdUniqueId);
    }

    public long gy() {
        return this.vS;
    }

    public int gA() {
        return BdAsyncTask.getTaskNum(d.fY());
    }

    public int P(int i) {
        return BdAsyncTask.getTaskNum(String.valueOf(i), d.fY());
    }

    public b gB() {
        return this.vR;
    }
}
