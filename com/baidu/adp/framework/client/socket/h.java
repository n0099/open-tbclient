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
import com.baidu.adp.lib.webSocket.m;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.framework.client.a<SocketMessage, SocketMessageTask> implements com.baidu.adp.framework.client.socket.link.e {
    private static /* synthetic */ int[] oV;
    private d.a oM;
    private final LinkedList<e> oN;
    private final LinkedList<e> oO;
    private final LinkedList<e> oP;
    private com.baidu.adp.framework.client.socket.link.e oQ;
    private boolean oR;
    private b oS;
    private long oT;
    private int oU;

    static /* synthetic */ int[] cW() {
        int[] iArr = oV;
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
            oV = iArr;
        }
        return iArr;
    }

    public h(MessageManager messageManager) {
        super(messageManager);
        this.oM = null;
        this.oN = new LinkedList<>();
        this.oO = new LinkedList<>();
        this.oP = new LinkedList<>();
        this.oQ = null;
        this.oR = true;
        this.oS = null;
        this.oT = 0L;
        this.oU = 0;
        BdSocketLinkService.setConnStateCallBack(this);
        this.oM = new i(this);
    }

    public boolean a(SocketMessage socketMessage) {
        if (socketMessage != null && (socketMessage instanceof a)) {
            a aVar = (a) socketMessage;
            if (c.a(this.oO, aVar, socketMessage.getCmd()) || c.a(this.oN, aVar, socketMessage.getCmd()) || c.a(this.oP, aVar, socketMessage.getCmd())) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b
    public void a(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        com.baidu.adp.lib.util.k.hz();
        if (socketMessage != null && socketMessageTask != null) {
            if (a(socketMessage, socketMessageTask.dC())) {
                k.a("queue", socketMessage, 0, "sendMessage", j.pz, "duplicate message be removed");
                return;
            }
            e eVar = new e(socketMessage, socketMessageTask, this);
            if (BdSocketLinkService.hasAbsoluteClose()) {
                k.a("queue", socketMessage, 0, "sendMessage", j.pI, "user manual close socket");
                eVar.M(j.pI);
            } else if (!BdSocketLinkService.isAvailable()) {
                k.a("queue", socketMessage, 0, "sendMessage", j.py, "isManualBlock message be removed");
                eVar.M(j.py);
            } else {
                k.a("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                c.a(eVar, this.oO);
                cQ();
            }
        }
    }

    private boolean a(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        if (socketMessage != null) {
            int cmd = socketMessage.getCmd();
            switch (cW()[dupLicateMode.ordinal()]) {
                case 2:
                    if (c.b(this.oO, cmd) || c.b(this.oN, cmd) || c.b(this.oP, cmd)) {
                        return true;
                    }
                    break;
                case 3:
                    c.c(this.oO, cmd);
                    break;
                case 4:
                    c.c(this.oO, cmd);
                    c.c(this.oN, cmd);
                    c.c(this.oP, cmd);
                    break;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(d.b bVar) {
        if (bVar != null) {
            if (bVar.oy != null) {
                a(bVar.oy, j.pa, null);
                return;
            }
            SocketResponsedMessage socketResponsedMessage = bVar.ox;
            if (socketResponsedMessage != null) {
                k.a("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
                b(socketResponsedMessage);
            }
        }
    }

    public void b(e eVar) {
        if (eVar != null && eVar.canRetry() && eVar.cN() < eVar.cv()) {
            c.a(this.oN, this.oP, eVar);
            if (this.oS != null) {
                this.oS.b(true, "timeout seq = " + eVar.cK());
            }
            k.a("queue", eVar.cH(), eVar.cK(), "onSendTimeOut", j.pC, String.valueOf(eVar.cN()));
            return;
        }
        e(eVar);
        a(eVar, j.pt, null);
        cQ();
    }

    public void a(int i, e eVar) {
        int i2;
        if (i == 2) {
            if (eVar.cF() != null) {
                i2 = eVar.cF().getErrorCode();
            } else {
                i2 = j.po;
            }
        } else {
            i2 = j.pu;
        }
        String O = j.O(i2);
        e(eVar);
        a(eVar, i2, O);
    }

    public void c(e eVar) {
    }

    public void d(e eVar) {
        if (eVar != null) {
            if (eVar.cG()) {
                eVar.cO();
                c.a(this.oO, this.oN, eVar);
                return;
            }
            c.b(eVar, this.oO);
        }
    }

    protected void a(e eVar, int i, String str) {
        SocketResponsedMessage socketResponsedMessage = null;
        if (eVar != null && eVar.cH() != null) {
            int cmd = eVar.cH().getCmd();
            int cK = eVar.cK();
            k.a("queue", eVar.cH(), cK, "onMessageSendFail", i, String.valueOf(str) + " retryTime-" + eVar.cN());
            SocketMessageTask cI = eVar != null ? eVar.cI() : null;
            SocketMessageTask socketMessageTask = cI == null ? (SocketMessageTask) this.od.findTask(cmd) : cI;
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
                    socketResponsedMessage.setErrorString(j.O(i));
                } else {
                    socketResponsedMessage.setErrorString(str);
                }
                socketResponsedMessage.setOrginalMessage(eVar.cH());
                k.a("queue", eVar.cH(), cK, "onMessageSendFail", i, "onMessageSendFail class = " + socketResponsedMessage.getClass().getName());
                this.od.dispatchResponsedMessage(socketResponsedMessage);
            }
        }
    }

    private void cQ() {
        e c = c.c(this.oO);
        if (c != null) {
            if (BdSocketLinkService.isClose()) {
                k.a("queue", c.cH(), 0, "sendNext", j.pA, "");
                BdSocketLinkService.startService(false, "send message");
            } else if (!this.oR || c.getPriority() <= -3) {
                BdSocketLinkService.sendMessage(c);
            }
        }
    }

    private void b(SocketResponsedMessage socketResponsedMessage) {
        this.od.dispatchResponsedMessage(socketResponsedMessage);
    }

    private void e(e eVar) {
        if (eVar != null) {
            eVar.cB();
            c.b(eVar, this.oN);
            c.b(eVar, this.oO);
            c.b(eVar, this.oP);
        }
    }

    private void g(LinkedList<e> linkedList) {
        while (true) {
            e d = c.d(linkedList);
            if (d != null) {
                d.cB();
                a(d, j.pv, null);
            } else {
                return;
            }
        }
    }

    public void cR() {
        g(this.oN);
        g(this.oO);
        g(this.oP);
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public boolean d(int i, String str) {
        if (this.oQ != null) {
            this.oQ.d(i, str);
        }
        if (this.oS != null) {
            this.oS.cs();
        }
        if (!com.baidu.adp.lib.util.k.hB() || c.e(this.oP) || c.e(this.oO) || c.e(this.oN) || !BdSocketLinkService.isAvailable()) {
            cR();
            return false;
        }
        c.f(this.oN);
        c.a(this.oO, this.oP);
        c.a(this.oO, this.oN);
        while (true) {
            e b = c.b(this.oO);
            if (b == null) {
                break;
            }
            b.cB();
            a(b, j.pv, null);
        }
        if (c.a(this.oO) > 0) {
            k.a("queue", 0, 0, "onClose", j.pD, "have retry message, MessageQueue:reconnect");
            BdSocketLinkService.startService(false, "have retry message");
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void d(Map<String, String> map) {
        g.cP().c(map);
        if (this.oS != null) {
            this.oS.ct();
        }
        this.oR = true;
        k.a("queue", 0, 0, "onConnected", j.pH, "Queue blocked");
        if (this.oQ != null) {
            this.oQ.d(map);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void a(m.a aVar) {
        byte[] bArr;
        if (aVar != null && (bArr = aVar.Az) != null) {
            this.oT = System.currentTimeMillis();
            try {
                com.baidu.adp.framework.client.socket.coder.c i = com.baidu.adp.framework.client.socket.coder.b.dj().i(bArr);
                this.oU = 0;
                int de = i.qc.de();
                int dg = i.qc.dg();
                k.a("queue", de, dg, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
                e n = n(de, dg);
                if (n != null) {
                    n.oI = aVar.oI;
                    n.oJ = aVar.oJ;
                }
                if (this.oS != null) {
                    if (i.qc.de() == this.oS.getCmd() && c.a(this.oO, this.oP)) {
                        cQ();
                    }
                    this.oS.ct();
                }
                if (dg == 0 || (n != null && n.getCmd() == de)) {
                    new d(i, n, this.oM, dg).execute(new String[0]);
                } else if (n != null) {
                    a(n, j.pJ, null);
                }
                if (this.oQ != null) {
                    this.oQ.a(aVar);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2000986));
            } catch (CoderException e) {
                int maxAlertCount = com.baidu.adp.lib.stats.switchs.a.gC().getMaxAlertCount("alert_protobuf", 2);
                int i2 = this.oU + 1;
                this.oU = i2;
                if (i2 >= maxAlertCount) {
                    BdStatisticsManager.getInstance().alert("alert_protobuf", "protbuf");
                }
                k.a("queue", 0, 0, "onBinaryMesssage", j.pp, "onBinaryMesssage decodeHeader error");
            }
        }
    }

    private e n(int i, int i2) {
        e eVar = null;
        if (i2 != 0) {
            e a = c.a(i2, this.oN);
            if (a == null && (a = c.a(i2, this.oP)) == null) {
                eVar = c.a(i2, this.oO);
                if (eVar == null) {
                    k.a("queue", i, i2, "findSenderData", j.pF, "original message removed , responsedMessage not dispatchMessage");
                }
            } else {
                eVar = a;
            }
            k.a("queue", i, i2, "findSenderData", j.pE, "received ack message");
        }
        return eVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
        cQ();
        if (this.oQ != null) {
            this.oQ.a(cVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void x(String str) {
        if (this.oQ != null) {
            this.oQ.x(str);
        }
    }

    public void a(com.baidu.adp.framework.client.socket.link.e eVar) {
        this.oQ = eVar;
    }

    public void cS() {
        boolean z = this.oR;
        this.oR = false;
        k.a("queue", 0, 0, "unBlockMessageQueue", j.pB, "Queue block has release");
        if (z) {
            cQ();
        }
    }

    public void a(b bVar) {
        this.oS = bVar;
    }

    public boolean isValid() {
        return BdSocketLinkService.isOpen() && !this.oR && BdSocketLinkService.isAvailable();
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        removeMessage(0, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        c.b(this.oN, i, bdUniqueId);
        c.b(this.oO, i, bdUniqueId);
        c.b(this.oP, i, bdUniqueId);
    }

    public LinkedList<SocketMessage> a(BdUniqueId bdUniqueId) {
        return null;
    }

    @Override // com.baidu.adp.framework.b
    public LinkedList<SocketMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return null;
    }

    public boolean a(int i, BdUniqueId bdUniqueId) {
        return c.a(this.oO, i, bdUniqueId) || c.a(this.oN, i, bdUniqueId) || c.a(this.oP, i, bdUniqueId);
    }

    public long cT() {
        return this.oT;
    }

    public int cU() {
        return BdAsyncTask.getTaskNum(d.cu());
    }

    public int N(int i) {
        return BdAsyncTask.getTaskNum(String.valueOf(i), d.cu());
    }

    public b cV() {
        return this.oS;
    }
}
