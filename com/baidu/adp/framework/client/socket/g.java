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
    private final LinkedList<e> wA;
    private final LinkedList<e> wB;
    private com.baidu.adp.framework.client.socket.link.a wC;
    private boolean wD;
    private b wE;
    private long wF;
    private int wG;
    private d.a wy;
    private final LinkedList<e> wz;

    public g(MessageManager messageManager) {
        super(messageManager);
        this.wy = null;
        this.wz = new LinkedList<>();
        this.wA = new LinkedList<>();
        this.wB = new LinkedList<>();
        this.wC = null;
        this.wD = true;
        this.wE = null;
        this.wF = 0L;
        this.wG = 0;
        BdSocketLinkService.setConnStateCallBack(this);
        this.wy = new d.a() { // from class: com.baidu.adp.framework.client.socket.g.1
            @Override // com.baidu.adp.framework.client.socket.d.a
            public void a(d.b bVar) {
                g.this.b(bVar);
            }
        };
    }

    public boolean a(SocketMessage socketMessage) {
        if (socketMessage != null && (socketMessage instanceof a)) {
            a aVar = (a) socketMessage;
            if (c.a(this.wA, aVar, socketMessage.getCmd()) || c.a(this.wz, aVar, socketMessage.getCmd()) || c.a(this.wB, aVar, socketMessage.getCmd())) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b
    public void a(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        l.lm();
        if (socketMessage != null && socketMessageTask != null) {
            if (a(socketMessage, socketMessageTask.hu())) {
                i.a("queue", socketMessage, 0, "sendMessage", h.xf, "duplicate message be removed");
                return;
            }
            e eVar = new e(socketMessage, socketMessageTask, this);
            if (BdSocketLinkService.hasAbsoluteClose()) {
                i.a("queue", socketMessage, 0, "sendMessage", h.xo, "user manual close socket");
                eVar.N(h.xo);
            } else if (!BdSocketLinkService.isAvailable()) {
                i.a("queue", socketMessage, 0, "sendMessage", h.xe, "isManualBlock message be removed");
                eVar.N(h.xe);
            } else {
                i.a("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                c.a(eVar, this.wA);
                gK();
            }
        }
    }

    private boolean a(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        if (socketMessage != null) {
            int cmd = socketMessage.getCmd();
            switch (dupLicateMode) {
                case REMOVE_ALL:
                    c.c(this.wA, cmd);
                    c.c(this.wz, cmd);
                    c.c(this.wB, cmd);
                    break;
                case REMOVE_WAITING:
                    c.c(this.wA, cmd);
                    break;
                case REMOVE_ME:
                    if (c.b(this.wA, cmd) || c.b(this.wz, cmd) || c.b(this.wB, cmd)) {
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
            if (bVar.wk != null) {
                a(bVar.wk, h.wM, null);
                return;
            }
            SocketResponsedMessage socketResponsedMessage = bVar.wj;
            if (socketResponsedMessage != null) {
                i.a("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
                b(socketResponsedMessage);
            }
        }
    }

    public void b(e eVar) {
        if (eVar != null && eVar.gE() && eVar.gH() < eVar.gp()) {
            c.a(this.wz, this.wB, eVar);
            if (this.wE != null) {
                this.wE.b(true, "timeout seq = " + eVar.getSequenceId());
            }
            i.a("queue", eVar.gB(), eVar.getSequenceId(), "onSendTimeOut", h.xi, String.valueOf(eVar.gH()));
            return;
        }
        e(eVar);
        a(eVar, h.wZ, null);
        gK();
    }

    public void a(int i, e eVar) {
        int i2;
        if (i == 2) {
            if (eVar.gz() != null) {
                i2 = eVar.gz().getErrorCode();
            } else {
                i2 = h.wV;
            }
        } else {
            i2 = h.xa;
        }
        String P = h.P(i2);
        e(eVar);
        a(eVar, i2, P);
    }

    public void c(e eVar) {
    }

    public void d(e eVar) {
        if (eVar != null) {
            if (eVar.gA()) {
                eVar.gI();
                c.a(this.wA, this.wz, eVar);
                return;
            }
            c.b(eVar, this.wA);
        }
    }

    protected void a(e eVar, int i, String str) {
        SocketResponsedMessage socketResponsedMessage = null;
        if (eVar != null && eVar.gB() != null) {
            int cmd = eVar.gB().getCmd();
            int sequenceId = eVar.getSequenceId();
            i.a("queue", eVar.gB(), sequenceId, "onMessageSendFail", i, str + " retryTime-" + eVar.gH());
            SocketMessageTask gC = eVar != null ? eVar.gC() : null;
            SocketMessageTask socketMessageTask = gC == null ? (SocketMessageTask) this.vS.findTask(cmd) : gC;
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
                    socketResponsedMessage.setErrorString(h.P(i));
                } else {
                    socketResponsedMessage.setErrorString(str);
                }
                socketResponsedMessage.setOrginalMessage(eVar.gB());
                i.a("queue", eVar.gB(), sequenceId, "onMessageSendFail", i, "onMessageSendFail class = " + socketResponsedMessage.getClass().getName());
                this.vS.dispatchResponsedMessage(socketResponsedMessage);
            }
        }
    }

    private void gK() {
        e e = c.e(this.wA);
        if (e != null) {
            if (BdSocketLinkService.isClose()) {
                i.a("queue", e.gB(), 0, "sendNext", h.xg, "");
                BdSocketLinkService.startService(false, "send message");
            } else if (!this.wD || e.getPriority() <= -3) {
                BdSocketLinkService.sendMessage(e);
            }
        }
    }

    private void b(SocketResponsedMessage socketResponsedMessage) {
        this.vS.dispatchResponsedMessage(socketResponsedMessage);
    }

    private void e(e eVar) {
        if (eVar != null) {
            eVar.gv();
            c.b(eVar, this.wz);
            c.b(eVar, this.wA);
            c.b(eVar, this.wB);
        }
    }

    private void i(LinkedList<e> linkedList) {
        while (true) {
            e f = c.f(linkedList);
            if (f != null) {
                f.gv();
                a(f, h.xb, null);
            } else {
                return;
            }
        }
    }

    public void gL() {
        i(this.wz);
        i(this.wA);
        i(this.wB);
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public boolean e(int i, String str) {
        if (this.wC != null) {
            this.wC.e(i, str);
        }
        if (this.wE != null) {
            this.wE.gm();
        }
        if (!l.lo() || c.g(this.wB) || c.g(this.wA) || c.g(this.wz) || !BdSocketLinkService.isAvailable()) {
            gL();
            return false;
        }
        c.h(this.wz);
        c.a(this.wA, this.wB);
        c.a(this.wA, this.wz);
        while (true) {
            e d = c.d(this.wA);
            if (d == null) {
                break;
            }
            d.gv();
            a(d, h.xb, null);
        }
        if (c.c(this.wA) > 0) {
            i.a("queue", 0, 0, "onClose", h.xj, "have retry message, MessageQueue:reconnect");
            BdSocketLinkService.startService(false, "have retry message");
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void i(Map<String, String> map) {
        f.gJ().h(map);
        if (this.wE != null) {
            this.wE.gn();
        }
        this.wD = true;
        i.a("queue", 0, 0, "onConnected", h.xn, "Queue blocked");
        if (this.wC != null) {
            this.wC.i(map);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void a(k.a aVar) {
        byte[] bArr;
        if (aVar != null && (bArr = aVar.HQ) != null) {
            this.wF = System.currentTimeMillis();
            try {
                com.baidu.adp.framework.client.socket.coder.c o = com.baidu.adp.framework.client.socket.coder.b.hb().o(bArr);
                this.wG = 0;
                int command = o.xH.getCommand();
                int gY = o.xH.gY();
                i.a("queue", command, gY, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
                e p = p(command, gY);
                if (p != null) {
                    p.wu = aVar.wu;
                    p.wv = aVar.wv;
                }
                if (this.wE != null) {
                    if (o.xH.getCommand() == this.wE.getCmd() && c.a(this.wA, this.wB)) {
                        gK();
                    }
                    this.wE.gn();
                }
                if (gY == 0 || (p != null && p.getCmd() == command)) {
                    new d(o, p, this.wy, gY).execute(new String[0]);
                } else if (p != null) {
                    a(p, h.xp, null);
                }
                if (this.wC != null) {
                    this.wC.a(aVar);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2000986));
            } catch (CoderException e) {
                int maxAlertCount = com.baidu.adp.lib.stats.switchs.a.kq().getMaxAlertCount("alert_protobuf", 2);
                int i = this.wG + 1;
                this.wG = i;
                if (i >= maxAlertCount) {
                    BdStatisticsManager.getInstance().alert("alert_protobuf", "protbuf");
                }
                i.a("queue", 0, 0, "onBinaryMesssage", h.wW, "onBinaryMesssage decodeHeader error");
            }
        }
    }

    private e p(int i, int i2) {
        e eVar = null;
        if (i2 != 0) {
            e a = c.a(i2, this.wz);
            if (a == null && (a = c.a(i2, this.wB)) == null) {
                eVar = c.a(i2, this.wA);
                if (eVar == null) {
                    i.a("queue", i, i2, "findSenderData", h.xl, "original message removed , responsedMessage not dispatchMessage");
                }
            } else {
                eVar = a;
            }
            i.a("queue", i, i2, "findSenderData", h.xk, "received ack message");
        }
        return eVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
        gK();
        if (this.wC != null) {
            this.wC.a(cVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void aj(String str) {
        if (this.wC != null) {
            this.wC.aj(str);
        }
    }

    public void a(com.baidu.adp.framework.client.socket.link.a aVar) {
        this.wC = aVar;
    }

    public void gM() {
        boolean z = this.wD;
        this.wD = false;
        i.a("queue", 0, 0, "unBlockMessageQueue", h.xh, "Queue block has release");
        if (z) {
            gK();
        }
    }

    public void a(b bVar) {
        this.wE = bVar;
    }

    public boolean isValid() {
        return BdSocketLinkService.isOpen() && !this.wD && BdSocketLinkService.isAvailable();
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        removeMessage(0, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        c.b(this.wz, i, bdUniqueId);
        c.b(this.wA, i, bdUniqueId);
        c.b(this.wB, i, bdUniqueId);
    }

    public LinkedList<SocketMessage> a(BdUniqueId bdUniqueId) {
        return null;
    }

    @Override // com.baidu.adp.framework.b
    public LinkedList<SocketMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return null;
    }

    public boolean a(int i, BdUniqueId bdUniqueId) {
        return c.a(this.wA, i, bdUniqueId) || c.a(this.wz, i, bdUniqueId) || c.a(this.wB, i, bdUniqueId);
    }

    public long gN() {
        return this.wF;
    }

    public int gO() {
        return BdAsyncTask.getTaskNum(d.go());
    }

    public int O(int i) {
        return BdAsyncTask.getTaskNum(String.valueOf(i), d.go());
    }

    public b gP() {
        return this.wE;
    }
}
