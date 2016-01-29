package com.baidu.adp.framework.client.socket;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.coder.CoderException;
import com.baidu.adp.framework.client.socket.d;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.framework.client.a<SocketMessage, SocketMessageTask> implements com.baidu.adp.framework.client.socket.link.e {
    private static /* synthetic */ int[] oV;
    private d.a oN;
    private final LinkedList<e> oO;
    private final LinkedList<e> oP;
    private final LinkedList<e> oQ;
    private com.baidu.adp.framework.client.socket.link.e oR;
    private boolean oS;
    private b oT;
    private long oU;

    static /* synthetic */ int[] eE() {
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
        this.oN = null;
        this.oO = new LinkedList<>();
        this.oP = new LinkedList<>();
        this.oQ = new LinkedList<>();
        this.oR = null;
        this.oS = true;
        this.oT = null;
        this.oU = 0L;
        BdSocketLinkService.setConnStateCallBack(this);
        this.oN = new i(this);
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
    /* renamed from: a */
    public void sendMessage(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        com.baidu.adp.lib.util.k.jo();
        if (socketMessage != null && socketMessageTask != null) {
            if (a(socketMessage, socketMessageTask.fl())) {
                k.a("queue", socketMessage, 0, "sendMessage", j.pw, "duplicate message be removed");
                return;
            }
            e eVar = new e(socketMessage, socketMessageTask, this);
            if (BdSocketLinkService.hasAbsoluteClose()) {
                k.a("queue", socketMessage, 0, "sendMessage", j.pF, "user manual close socket");
                eVar.J(j.pF);
            } else if (!BdSocketLinkService.isAvailable()) {
                k.a("queue", socketMessage, 0, "sendMessage", j.pv, "isManualBlock message be removed");
                eVar.J(j.pv);
            } else {
                k.a("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                c.a(eVar, this.oP);
                ey();
            }
        }
    }

    private boolean a(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        if (socketMessage != null) {
            int cmd = socketMessage.getCmd();
            switch (eE()[dupLicateMode.ordinal()]) {
                case 2:
                    if (c.b(this.oP, cmd) || c.b(this.oO, cmd) || c.b(this.oQ, cmd)) {
                        return true;
                    }
                    break;
                case 3:
                    c.c(this.oP, cmd);
                    break;
                case 4:
                    c.c(this.oP, cmd);
                    c.c(this.oO, cmd);
                    c.c(this.oQ, cmd);
                    break;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(d.b bVar) {
        if (bVar != null) {
            if (bVar.oB != null) {
                a(bVar.oB, j.pa, null);
                return;
            }
            SocketResponsedMessage socketResponsedMessage = bVar.oA;
            if (socketResponsedMessage != null) {
                k.a("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
                b(socketResponsedMessage);
            }
        }
    }

    public void b(e eVar) {
        if (eVar != null && eVar.es() && eVar.ev() < eVar.ec()) {
            c.a(this.oO, this.oQ, eVar);
            if (this.oT != null) {
                this.oT.b(true, "timeout seq = " + eVar.er());
            }
            k.a("queue", eVar.eo(), eVar.er(), "onSendTimeOut", j.pz, String.valueOf(eVar.ev()));
            return;
        }
        e(eVar);
        a(eVar, j.pq, null);
        ey();
    }

    public void a(int i, e eVar) {
        int i2;
        if (i == 2) {
            if (eVar.em() != null) {
                i2 = eVar.em().getErrorCode();
            } else {
                i2 = j.pj;
            }
        } else {
            i2 = j.pr;
        }
        String L = j.L(i2);
        e(eVar);
        a(eVar, i2, L);
    }

    public void c(e eVar) {
    }

    public void d(e eVar) {
        if (eVar != null) {
            if (eVar.en()) {
                eVar.ew();
                c.a(this.oP, this.oO, eVar);
                return;
            }
            c.b(eVar, this.oP);
        }
    }

    protected void a(e eVar, int i, String str) {
        SocketResponsedMessage socketResponsedMessage = null;
        if (eVar != null && eVar.eo() != null) {
            int cmd = eVar.eo().getCmd();
            int er = eVar.er();
            k.a("queue", eVar.eo(), er, "onMessageSendFail", i, String.valueOf(str) + " retryTime-" + eVar.ev());
            SocketMessageTask ep = eVar != null ? eVar.ep() : null;
            SocketMessageTask socketMessageTask = ep == null ? (SocketMessageTask) this.og.findTask(cmd) : ep;
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
                    socketResponsedMessage.setErrorString(j.L(i));
                } else {
                    socketResponsedMessage.setErrorString(str);
                }
                socketResponsedMessage.setOrginalMessage(eVar.eo());
                k.a("queue", eVar.eo(), er, "onMessageSendFail", i, "onMessageSendFail class = " + socketResponsedMessage.getClass().getName());
                this.og.dispatchResponsedMessage(socketResponsedMessage);
            }
        }
    }

    private void ey() {
        e d = c.d(this.oP);
        if (d != null) {
            if (BdSocketLinkService.isClose()) {
                k.a("queue", d.eo(), 0, "sendNext", j.px, "");
                BdSocketLinkService.startService(false, "send message");
            } else if (!this.oS || d.getPriority() <= -3) {
                BdSocketLinkService.sendMessage(d);
            }
        }
    }

    private void b(SocketResponsedMessage socketResponsedMessage) {
        this.og.dispatchResponsedMessage(socketResponsedMessage);
    }

    private void e(e eVar) {
        if (eVar != null) {
            eVar.ei();
            c.b(eVar, this.oO);
            c.b(eVar, this.oP);
            c.b(eVar, this.oQ);
        }
    }

    private void h(LinkedList<e> linkedList) {
        while (true) {
            e e = c.e(linkedList);
            if (e != null) {
                e.ei();
                a(e, j.ps, null);
            } else {
                return;
            }
        }
    }

    public void ez() {
        h(this.oO);
        h(this.oP);
        h(this.oQ);
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public boolean k(int i, String str) {
        if (this.oR != null) {
            this.oR.k(i, str);
        }
        if (this.oT != null) {
            this.oT.dZ();
        }
        if (!com.baidu.adp.lib.util.k.jq() || c.f(this.oQ) || c.f(this.oP) || c.f(this.oO) || !BdSocketLinkService.isAvailable()) {
            ez();
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
            c.ei();
            a(c, j.ps, null);
        }
        if (c.b(this.oP) > 0) {
            k.a("queue", 0, 0, "onClose", j.pA, "have retry message, MessageQueue:reconnect");
            BdSocketLinkService.startService(false, "have retry message");
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void c(Map<String, String> map) {
        g.ex().b(map);
        if (this.oT != null) {
            this.oT.ea();
        }
        this.oS = true;
        k.a("queue", 0, 0, "onConnected", j.pE, "Queue blocked");
        if (this.oR != null) {
            this.oR.c(map);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void s(byte[] bArr) {
        if (bArr != null) {
            this.oU = System.currentTimeMillis();
            try {
                com.baidu.adp.framework.client.socket.coder.c u = com.baidu.adp.framework.client.socket.coder.b.eO().u(bArr);
                int eL = u.pU.eL();
                int eN = u.pU.eN();
                k.a("queue", eL, eN, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
                e e = e(eL, eN);
                if (this.oT != null) {
                    if (u.pU.eL() == this.oT.getCmd() && c.a(this.oP, this.oQ)) {
                        ey();
                    }
                    this.oT.ea();
                }
                if (eN == 0 || (e != null && e.getCmd() == eL)) {
                    new d(u, e, this.oN, eN).execute(new String[0]);
                } else if (e != null) {
                    a(e, j.pG, null);
                }
                if (this.oR != null) {
                    this.oR.s(bArr);
                }
            } catch (CoderException e2) {
                k.a("queue", 0, 0, "onBinaryMesssage", j.pl, "onBinaryMesssage decodeHeader error");
            }
        }
    }

    private e e(int i, int i2) {
        e eVar = null;
        if (i2 != 0) {
            e a = c.a(i2, this.oO);
            if (a == null && (a = c.a(i2, this.oQ)) == null) {
                eVar = c.a(i2, this.oP);
                if (eVar == null) {
                    k.a("queue", i, i2, "findSenderData", j.pC, "original message removed , responsedMessage not dispatchMessage");
                }
            } else {
                eVar = a;
            }
            k.a("queue", i, i2, "findSenderData", j.pB, "received ack message");
        }
        return eVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
        ey();
        if (this.oR != null) {
            this.oR.a(cVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void H(String str) {
        if (this.oR != null) {
            this.oR.H(str);
        }
    }

    public void a(com.baidu.adp.framework.client.socket.link.e eVar) {
        this.oR = eVar;
    }

    public void eA() {
        boolean z = this.oS;
        this.oS = false;
        k.a("queue", 0, 0, "unBlockMessageQueue", j.py, "Queue block has release");
        if (z) {
            ey();
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

    public long eB() {
        return this.oU;
    }

    public int eC() {
        return BdAsyncTask.getTaskNum(d.eb());
    }

    public int K(int i) {
        return BdAsyncTask.getTaskNum(String.valueOf(i), d.eb());
    }

    public b eD() {
        return this.oT;
    }
}
