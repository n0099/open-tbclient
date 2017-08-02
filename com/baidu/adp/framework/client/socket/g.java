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
    private d.a oN;
    private final LinkedList<e> oO;
    private final LinkedList<e> oP;
    private final LinkedList<e> oQ;
    private com.baidu.adp.framework.client.socket.link.a oR;
    private boolean oS;
    private b oT;
    private long oU;
    private int oV;

    public g(MessageManager messageManager) {
        super(messageManager);
        this.oN = null;
        this.oO = new LinkedList<>();
        this.oP = new LinkedList<>();
        this.oQ = new LinkedList<>();
        this.oR = null;
        this.oS = true;
        this.oT = null;
        this.oU = 0L;
        this.oV = 0;
        BdSocketLinkService.setConnStateCallBack(this);
        this.oN = new d.a() { // from class: com.baidu.adp.framework.client.socket.g.1
            @Override // com.baidu.adp.framework.client.socket.d.a
            public void a(d.b bVar) {
                g.this.b(bVar);
            }
        };
    }

    public boolean a(SocketMessage socketMessage) {
        if (socketMessage != null && (socketMessage instanceof a)) {
            a aVar = (a) socketMessage;
            if (c.a(this.oP, aVar, socketMessage.getCmd()) || c.a(this.oO, aVar, socketMessage.getCmd()) || c.a(this.oQ, aVar, socketMessage.getCmd())) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b
    public void a(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        k.hw();
        if (socketMessage != null && socketMessageTask != null) {
            if (a(socketMessage, socketMessageTask.dB())) {
                i.a("queue", socketMessage, 0, "sendMessage", h.pA, "duplicate message be removed");
                return;
            }
            e eVar = new e(socketMessage, socketMessageTask, this);
            if (BdSocketLinkService.hasAbsoluteClose()) {
                i.a("queue", socketMessage, 0, "sendMessage", h.pJ, "user manual close socket");
                eVar.M(h.pJ);
            } else if (!BdSocketLinkService.isAvailable()) {
                i.a("queue", socketMessage, 0, "sendMessage", h.pz, "isManualBlock message be removed");
                eVar.M(h.pz);
            } else {
                i.a("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                c.a(eVar, this.oP);
                cQ();
            }
        }
    }

    private boolean a(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        if (socketMessage != null) {
            int cmd = socketMessage.getCmd();
            switch (dupLicateMode) {
                case REMOVE_ALL:
                    c.c(this.oP, cmd);
                    c.c(this.oO, cmd);
                    c.c(this.oQ, cmd);
                    break;
                case REMOVE_WAITING:
                    c.c(this.oP, cmd);
                    break;
                case REMOVE_ME:
                    if (c.b(this.oP, cmd) || c.b(this.oO, cmd) || c.b(this.oQ, cmd)) {
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
            if (bVar.oz != null) {
                a(bVar.oz, h.pd, null);
                return;
            }
            SocketResponsedMessage socketResponsedMessage = bVar.oy;
            if (socketResponsedMessage != null) {
                i.a("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
                b(socketResponsedMessage);
            }
        }
    }

    public void b(e eVar) {
        if (eVar != null && eVar.canRetry() && eVar.cN() < eVar.cv()) {
            c.a(this.oO, this.oQ, eVar);
            if (this.oT != null) {
                this.oT.b(true, "timeout seq = " + eVar.cK());
            }
            i.a("queue", eVar.cH(), eVar.cK(), "onSendTimeOut", h.pD, String.valueOf(eVar.cN()));
            return;
        }
        e(eVar);
        a(eVar, h.pu, null);
        cQ();
    }

    public void a(int i, e eVar) {
        int i2;
        if (i == 2) {
            if (eVar.cF() != null) {
                i2 = eVar.cF().getErrorCode();
            } else {
                i2 = h.pp;
            }
        } else {
            i2 = h.pv;
        }
        String O = h.O(i2);
        e(eVar);
        a(eVar, i2, O);
    }

    public void c(e eVar) {
    }

    public void d(e eVar) {
        if (eVar != null) {
            if (eVar.cG()) {
                eVar.cO();
                c.a(this.oP, this.oO, eVar);
                return;
            }
            c.b(eVar, this.oP);
        }
    }

    protected void a(e eVar, int i, String str) {
        SocketResponsedMessage socketResponsedMessage = null;
        if (eVar != null && eVar.cH() != null) {
            int cmd = eVar.cH().getCmd();
            int cK = eVar.cK();
            i.a("queue", eVar.cH(), cK, "onMessageSendFail", i, str + " retryTime-" + eVar.cN());
            SocketMessageTask cI = eVar != null ? eVar.cI() : null;
            SocketMessageTask socketMessageTask = cI == null ? (SocketMessageTask) this.oe.findTask(cmd) : cI;
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
                    socketResponsedMessage.setErrorString(h.O(i));
                } else {
                    socketResponsedMessage.setErrorString(str);
                }
                socketResponsedMessage.setOrginalMessage(eVar.cH());
                i.a("queue", eVar.cH(), cK, "onMessageSendFail", i, "onMessageSendFail class = " + socketResponsedMessage.getClass().getName());
                this.oe.dispatchResponsedMessage(socketResponsedMessage);
            }
        }
    }

    private void cQ() {
        e d = c.d(this.oP);
        if (d != null) {
            if (BdSocketLinkService.isClose()) {
                i.a("queue", d.cH(), 0, "sendNext", h.pB, "");
                BdSocketLinkService.startService(false, "send message");
            } else if (!this.oS || d.getPriority() <= -3) {
                BdSocketLinkService.sendMessage(d);
            }
        }
    }

    private void b(SocketResponsedMessage socketResponsedMessage) {
        this.oe.dispatchResponsedMessage(socketResponsedMessage);
    }

    private void e(e eVar) {
        if (eVar != null) {
            eVar.cB();
            c.b(eVar, this.oO);
            c.b(eVar, this.oP);
            c.b(eVar, this.oQ);
        }
    }

    private void h(LinkedList<e> linkedList) {
        while (true) {
            e e = c.e(linkedList);
            if (e != null) {
                e.cB();
                a(e, h.pw, null);
            } else {
                return;
            }
        }
    }

    public void cR() {
        h(this.oO);
        h(this.oP);
        h(this.oQ);
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public boolean d(int i, String str) {
        if (this.oR != null) {
            this.oR.d(i, str);
        }
        if (this.oT != null) {
            this.oT.cs();
        }
        if (!k.hy() || c.f(this.oQ) || c.f(this.oP) || c.f(this.oO) || !BdSocketLinkService.isAvailable()) {
            cR();
            return false;
        }
        c.g(this.oO);
        c.a(this.oP, this.oQ);
        c.a(this.oP, this.oO);
        while (true) {
            e c = c.c(this.oP);
            if (c == null) {
                break;
            }
            c.cB();
            a(c, h.pw, null);
        }
        if (c.b(this.oP) > 0) {
            i.a("queue", 0, 0, "onClose", h.pE, "have retry message, MessageQueue:reconnect");
            BdSocketLinkService.startService(false, "have retry message");
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void d(Map<String, String> map) {
        f.cP().c(map);
        if (this.oT != null) {
            this.oT.ct();
        }
        this.oS = true;
        i.a("queue", 0, 0, "onConnected", h.pI, "Queue blocked");
        if (this.oR != null) {
            this.oR.d(map);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void a(k.a aVar) {
        byte[] bArr;
        if (aVar != null && (bArr = aVar.Az) != null) {
            this.oU = System.currentTimeMillis();
            try {
                com.baidu.adp.framework.client.socket.coder.c i = com.baidu.adp.framework.client.socket.coder.b.di().i(bArr);
                this.oV = 0;
                int dd = i.qd.dd();
                int df = i.qd.df();
                i.a("queue", dd, df, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
                e n = n(dd, df);
                if (n != null) {
                    n.oJ = aVar.oJ;
                    n.oK = aVar.oK;
                }
                if (this.oT != null) {
                    if (i.qd.dd() == this.oT.getCmd() && c.a(this.oP, this.oQ)) {
                        cQ();
                    }
                    this.oT.ct();
                }
                if (df == 0 || (n != null && n.getCmd() == dd)) {
                    new d(i, n, this.oN, df).execute(new String[0]);
                } else if (n != null) {
                    a(n, h.pK, null);
                }
                if (this.oR != null) {
                    this.oR.a(aVar);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2000986));
            } catch (CoderException e) {
                int maxAlertCount = com.baidu.adp.lib.stats.switchs.a.gz().getMaxAlertCount("alert_protobuf", 2);
                int i2 = this.oV + 1;
                this.oV = i2;
                if (i2 >= maxAlertCount) {
                    BdStatisticsManager.getInstance().alert("alert_protobuf", "protbuf");
                }
                i.a("queue", 0, 0, "onBinaryMesssage", h.pq, "onBinaryMesssage decodeHeader error");
            }
        }
    }

    private e n(int i, int i2) {
        e eVar = null;
        if (i2 != 0) {
            e a = c.a(i2, this.oO);
            if (a == null && (a = c.a(i2, this.oQ)) == null) {
                eVar = c.a(i2, this.oP);
                if (eVar == null) {
                    i.a("queue", i, i2, "findSenderData", h.pG, "original message removed , responsedMessage not dispatchMessage");
                }
            } else {
                eVar = a;
            }
            i.a("queue", i, i2, "findSenderData", h.pF, "received ack message");
        }
        return eVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
        cQ();
        if (this.oR != null) {
            this.oR.a(cVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void C(String str) {
        if (this.oR != null) {
            this.oR.C(str);
        }
    }

    public void a(com.baidu.adp.framework.client.socket.link.a aVar) {
        this.oR = aVar;
    }

    public void cS() {
        boolean z = this.oS;
        this.oS = false;
        i.a("queue", 0, 0, "unBlockMessageQueue", h.pC, "Queue block has release");
        if (z) {
            cQ();
        }
    }

    public void a(b bVar) {
        this.oT = bVar;
    }

    public boolean isValid() {
        return BdSocketLinkService.isOpen() && !this.oS && BdSocketLinkService.isAvailable();
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        removeMessage(0, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        c.b(this.oO, i, bdUniqueId);
        c.b(this.oP, i, bdUniqueId);
        c.b(this.oQ, i, bdUniqueId);
    }

    public LinkedList<SocketMessage> a(BdUniqueId bdUniqueId) {
        return null;
    }

    @Override // com.baidu.adp.framework.b
    public LinkedList<SocketMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return null;
    }

    public boolean a(int i, BdUniqueId bdUniqueId) {
        return c.a(this.oP, i, bdUniqueId) || c.a(this.oO, i, bdUniqueId) || c.a(this.oQ, i, bdUniqueId);
    }

    public long cT() {
        return this.oU;
    }

    public int cU() {
        return BdAsyncTask.getTaskNum(d.cu());
    }

    public int N(int i) {
        return BdAsyncTask.getTaskNum(String.valueOf(i), d.cu());
    }

    public b cV() {
        return this.oT;
    }
}
