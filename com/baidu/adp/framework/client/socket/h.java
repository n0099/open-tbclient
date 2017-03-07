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
    private static /* synthetic */ int[] pC;
    private long pA;
    private int pB;
    private d.a pt;
    private final LinkedList<e> pu;
    private final LinkedList<e> pv;
    private final LinkedList<e> pw;
    private com.baidu.adp.framework.client.socket.link.e px;
    private boolean py;
    private b pz;

    static /* synthetic */ int[] cX() {
        int[] iArr = pC;
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
            pC = iArr;
        }
        return iArr;
    }

    public h(MessageManager messageManager) {
        super(messageManager);
        this.pt = null;
        this.pu = new LinkedList<>();
        this.pv = new LinkedList<>();
        this.pw = new LinkedList<>();
        this.px = null;
        this.py = true;
        this.pz = null;
        this.pA = 0L;
        this.pB = 0;
        BdSocketLinkService.setConnStateCallBack(this);
        this.pt = new i(this);
    }

    public boolean a(SocketMessage socketMessage) {
        if (socketMessage != null && (socketMessage instanceof a)) {
            a aVar = (a) socketMessage;
            if (c.a(this.pv, aVar, socketMessage.getCmd()) || c.a(this.pu, aVar, socketMessage.getCmd()) || c.a(this.pw, aVar, socketMessage.getCmd())) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b
    public void a(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        com.baidu.adp.lib.util.k.ht();
        if (socketMessage != null && socketMessageTask != null) {
            if (a(socketMessage, socketMessageTask.dC())) {
                k.a("queue", socketMessage, 0, "sendMessage", j.pY, "duplicate message be removed");
                return;
            }
            e eVar = new e(socketMessage, socketMessageTask, this);
            if (BdSocketLinkService.hasAbsoluteClose()) {
                k.a("queue", socketMessage, 0, "sendMessage", j.qh, "user manual close socket");
                eVar.O(j.qh);
            } else if (!BdSocketLinkService.isAvailable()) {
                k.a("queue", socketMessage, 0, "sendMessage", j.pX, "isManualBlock message be removed");
                eVar.O(j.pX);
            } else {
                k.a("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                c.a(eVar, this.pv);
                cR();
            }
        }
    }

    private boolean a(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        if (socketMessage != null) {
            int cmd = socketMessage.getCmd();
            switch (cX()[dupLicateMode.ordinal()]) {
                case 2:
                    if (c.b(this.pv, cmd) || c.b(this.pu, cmd) || c.b(this.pw, cmd)) {
                        return true;
                    }
                    break;
                case 3:
                    c.c(this.pv, cmd);
                    break;
                case 4:
                    c.c(this.pv, cmd);
                    c.c(this.pu, cmd);
                    c.c(this.pw, cmd);
                    break;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(d.b bVar) {
        if (bVar != null) {
            if (bVar.oZ != null) {
                a(bVar.oZ, j.pH, null);
                return;
            }
            SocketResponsedMessage socketResponsedMessage = bVar.oY;
            if (socketResponsedMessage != null) {
                k.a("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
                b(socketResponsedMessage);
            }
        }
    }

    public void b(e eVar) {
        if (eVar != null && eVar.canRetry() && eVar.cO() < eVar.cw()) {
            c.a(this.pu, this.pw, eVar);
            if (this.pz != null) {
                this.pz.b(true, "timeout seq = " + eVar.cL());
            }
            k.a("queue", eVar.cI(), eVar.cL(), "onSendTimeOut", j.qb, String.valueOf(eVar.cO()));
            return;
        }
        e(eVar);
        a(eVar, j.pS, null);
        cR();
    }

    public void a(int i, e eVar) {
        int i2;
        if (i == 2) {
            if (eVar.cG() != null) {
                i2 = eVar.cG().getErrorCode();
            } else {
                i2 = j.pO;
            }
        } else {
            i2 = j.pT;
        }
        String Q = j.Q(i2);
        e(eVar);
        a(eVar, i2, Q);
    }

    public void c(e eVar) {
    }

    public void d(e eVar) {
        if (eVar != null) {
            if (eVar.cH()) {
                eVar.cP();
                c.a(this.pv, this.pu, eVar);
                return;
            }
            c.b(eVar, this.pv);
        }
    }

    protected void a(e eVar, int i, String str) {
        SocketResponsedMessage socketResponsedMessage = null;
        if (eVar != null && eVar.cI() != null) {
            int cmd = eVar.cI().getCmd();
            int cL = eVar.cL();
            k.a("queue", eVar.cI(), cL, "onMessageSendFail", i, String.valueOf(str) + " retryTime-" + eVar.cO());
            SocketMessageTask cJ = eVar != null ? eVar.cJ() : null;
            SocketMessageTask socketMessageTask = cJ == null ? (SocketMessageTask) this.oI.findTask(cmd) : cJ;
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
                    socketResponsedMessage.setErrorString(j.Q(i));
                } else {
                    socketResponsedMessage.setErrorString(str);
                }
                socketResponsedMessage.setOrginalMessage(eVar.cI());
                k.a("queue", eVar.cI(), cL, "onMessageSendFail", i, "onMessageSendFail class = " + socketResponsedMessage.getClass().getName());
                this.oI.dispatchResponsedMessage(socketResponsedMessage);
            }
        }
    }

    private void cR() {
        e c = c.c(this.pv);
        if (c != null) {
            if (BdSocketLinkService.isClose()) {
                k.a("queue", c.cI(), 0, "sendNext", j.pZ, "");
                BdSocketLinkService.startService(false, "send message");
            } else if (!this.py || c.getPriority() <= -3) {
                BdSocketLinkService.sendMessage(c);
            }
        }
    }

    private void b(SocketResponsedMessage socketResponsedMessage) {
        this.oI.dispatchResponsedMessage(socketResponsedMessage);
    }

    private void e(e eVar) {
        if (eVar != null) {
            eVar.cC();
            c.b(eVar, this.pu);
            c.b(eVar, this.pv);
            c.b(eVar, this.pw);
        }
    }

    private void g(LinkedList<e> linkedList) {
        while (true) {
            e d = c.d(linkedList);
            if (d != null) {
                d.cC();
                a(d, j.pU, null);
            } else {
                return;
            }
        }
    }

    public void cS() {
        g(this.pu);
        g(this.pv);
        g(this.pw);
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public boolean d(int i, String str) {
        if (this.px != null) {
            this.px.d(i, str);
        }
        if (this.pz != null) {
            this.pz.ct();
        }
        if (!com.baidu.adp.lib.util.k.hv() || c.e(this.pw) || c.e(this.pv) || c.e(this.pu) || !BdSocketLinkService.isAvailable()) {
            cS();
            return false;
        }
        c.f(this.pu);
        c.a(this.pv, this.pw);
        c.a(this.pv, this.pu);
        while (true) {
            e b = c.b(this.pv);
            if (b == null) {
                break;
            }
            b.cC();
            a(b, j.pU, null);
        }
        if (c.a(this.pv) > 0) {
            k.a("queue", 0, 0, "onClose", j.qc, "have retry message, MessageQueue:reconnect");
            BdSocketLinkService.startService(false, "have retry message");
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void d(Map<String, String> map) {
        g.cQ().c(map);
        if (this.pz != null) {
            this.pz.cu();
        }
        this.py = true;
        k.a("queue", 0, 0, "onConnected", j.qg, "Queue blocked");
        if (this.px != null) {
            this.px.d(map);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void a(m.a aVar) {
        byte[] bArr;
        if (aVar != null && (bArr = aVar.AV) != null) {
            this.pA = System.currentTimeMillis();
            try {
                com.baidu.adp.framework.client.socket.coder.c i = com.baidu.adp.framework.client.socket.coder.b.dj().i(bArr);
                this.pB = 0;
                int df = i.qy.df();
                int dh = i.qy.dh();
                k.a("queue", df, dh, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
                e n = n(df, dh);
                if (n != null) {
                    n.po = aVar.po;
                    n.pp = aVar.pp;
                }
                if (this.pz != null) {
                    if (i.qy.df() == this.pz.getCmd() && c.a(this.pv, this.pw)) {
                        cR();
                    }
                    this.pz.cu();
                }
                if (dh == 0 || (n != null && n.getCmd() == df)) {
                    new d(i, n, this.pt, dh).execute(new String[0]);
                } else if (n != null) {
                    a(n, j.qi, null);
                }
                if (this.px != null) {
                    this.px.a(aVar);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2000986));
            } catch (CoderException e) {
                int maxAlertCount = com.baidu.adp.lib.stats.switchs.a.gw().getMaxAlertCount("alert_protobuf", 2);
                int i2 = this.pB + 1;
                this.pB = i2;
                if (i2 >= maxAlertCount) {
                    BdStatisticsManager.getInstance().alert("alert_protobuf", "protbuf");
                }
                k.a("queue", 0, 0, "onBinaryMesssage", j.pP, "onBinaryMesssage decodeHeader error");
            }
        }
    }

    private e n(int i, int i2) {
        e eVar = null;
        if (i2 != 0) {
            e a = c.a(i2, this.pu);
            if (a == null && (a = c.a(i2, this.pw)) == null) {
                eVar = c.a(i2, this.pv);
                if (eVar == null) {
                    k.a("queue", i, i2, "findSenderData", j.qe, "original message removed , responsedMessage not dispatchMessage");
                }
            } else {
                eVar = a;
            }
            k.a("queue", i, i2, "findSenderData", j.qd, "received ack message");
        }
        return eVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
        cR();
        if (this.px != null) {
            this.px.a(cVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void A(String str) {
        if (this.px != null) {
            this.px.A(str);
        }
    }

    public void a(com.baidu.adp.framework.client.socket.link.e eVar) {
        this.px = eVar;
    }

    public void cT() {
        boolean z = this.py;
        this.py = false;
        k.a("queue", 0, 0, "unBlockMessageQueue", j.qa, "Queue block has release");
        if (z) {
            cR();
        }
    }

    public void a(b bVar) {
        this.pz = bVar;
    }

    public boolean isValid() {
        return BdSocketLinkService.isOpen() && !this.py && BdSocketLinkService.isAvailable();
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        removeMessage(0, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        c.b(this.pu, i, bdUniqueId);
        c.b(this.pv, i, bdUniqueId);
        c.b(this.pw, i, bdUniqueId);
    }

    public LinkedList<SocketMessage> a(BdUniqueId bdUniqueId) {
        return null;
    }

    @Override // com.baidu.adp.framework.b
    public LinkedList<SocketMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return null;
    }

    public boolean a(int i, BdUniqueId bdUniqueId) {
        return c.a(this.pv, i, bdUniqueId) || c.a(this.pu, i, bdUniqueId) || c.a(this.pw, i, bdUniqueId);
    }

    public long cU() {
        return this.pA;
    }

    public int cV() {
        return BdAsyncTask.getTaskNum(d.cv());
    }

    public int P(int i) {
        return BdAsyncTask.getTaskNum(String.valueOf(i), d.cv());
    }

    public b cW() {
        return this.pz;
    }
}
