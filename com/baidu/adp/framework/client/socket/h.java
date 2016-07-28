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
import com.baidu.adp.lib.webSocket.m;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.framework.client.a<SocketMessage, SocketMessageTask> implements com.baidu.adp.framework.client.socket.link.e {
    private static /* synthetic */ int[] fr;
    private d.a fi;
    private final LinkedList<e> fj;
    private final LinkedList<e> fk;
    private final LinkedList<e> fl;
    private com.baidu.adp.framework.client.socket.link.e fm;
    private boolean fn;
    private b fo;
    private long fp;
    private int fq;

    static /* synthetic */ int[] aT() {
        int[] iArr = fr;
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
            fr = iArr;
        }
        return iArr;
    }

    public h(MessageManager messageManager) {
        super(messageManager);
        this.fi = null;
        this.fj = new LinkedList<>();
        this.fk = new LinkedList<>();
        this.fl = new LinkedList<>();
        this.fm = null;
        this.fn = true;
        this.fo = null;
        this.fp = 0L;
        this.fq = 0;
        BdSocketLinkService.setConnStateCallBack(this);
        this.fi = new i(this);
    }

    public boolean a(SocketMessage socketMessage) {
        if (socketMessage != null && (socketMessage instanceof a)) {
            a aVar = (a) socketMessage;
            if (c.a(this.fk, aVar, socketMessage.getCmd()) || c.a(this.fj, aVar, socketMessage.getCmd()) || c.a(this.fl, aVar, socketMessage.getCmd())) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b
    public void a(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        com.baidu.adp.lib.util.k.fF();
        if (socketMessage != null && socketMessageTask != null) {
            if (a(socketMessage, socketMessageTask.bA())) {
                k.a("queue", socketMessage, 0, "sendMessage", j.fN, "duplicate message be removed");
                return;
            }
            e eVar = new e(socketMessage, socketMessageTask, this);
            if (BdSocketLinkService.hasAbsoluteClose()) {
                k.a("queue", socketMessage, 0, "sendMessage", j.fW, "user manual close socket");
                eVar.A(j.fW);
            } else if (!BdSocketLinkService.isAvailable()) {
                k.a("queue", socketMessage, 0, "sendMessage", j.fM, "isManualBlock message be removed");
                eVar.A(j.fM);
            } else {
                k.a("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                c.a(eVar, this.fk);
                aN();
            }
        }
    }

    private boolean a(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        if (socketMessage != null) {
            int cmd = socketMessage.getCmd();
            switch (aT()[dupLicateMode.ordinal()]) {
                case 2:
                    if (c.b(this.fk, cmd) || c.b(this.fj, cmd) || c.b(this.fl, cmd)) {
                        return true;
                    }
                    break;
                case 3:
                    c.c(this.fk, cmd);
                    break;
                case 4:
                    c.c(this.fk, cmd);
                    c.c(this.fj, cmd);
                    c.c(this.fl, cmd);
                    break;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(d.b bVar) {
        if (bVar != null) {
            if (bVar.eU != null) {
                a(bVar.eU, j.fw, null);
                return;
            }
            SocketResponsedMessage socketResponsedMessage = bVar.eT;
            if (socketResponsedMessage != null) {
                k.a("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
                b(socketResponsedMessage);
            }
        }
    }

    public void b(e eVar) {
        if (eVar != null && eVar.canRetry() && eVar.aK() < eVar.as()) {
            c.a(this.fj, this.fl, eVar);
            if (this.fo != null) {
                this.fo.b(true, "timeout seq = " + eVar.aH());
            }
            k.a("queue", eVar.aE(), eVar.aH(), "onSendTimeOut", j.fQ, String.valueOf(eVar.aK()));
            return;
        }
        e(eVar);
        a(eVar, j.fH, null);
        aN();
    }

    public void a(int i, e eVar) {
        int i2;
        if (i == 2) {
            if (eVar.aC() != null) {
                i2 = eVar.aC().getErrorCode();
            } else {
                i2 = j.fD;
            }
        } else {
            i2 = j.fI;
        }
        String C = j.C(i2);
        e(eVar);
        a(eVar, i2, C);
    }

    public void c(e eVar) {
    }

    public void d(e eVar) {
        if (eVar != null) {
            if (eVar.aD()) {
                eVar.aL();
                c.a(this.fk, this.fj, eVar);
                return;
            }
            c.b(eVar, this.fk);
        }
    }

    protected void a(e eVar, int i, String str) {
        SocketResponsedMessage socketResponsedMessage = null;
        if (eVar != null && eVar.aE() != null) {
            int cmd = eVar.aE().getCmd();
            int aH = eVar.aH();
            k.a("queue", eVar.aE(), aH, "onMessageSendFail", i, String.valueOf(str) + " retryTime-" + eVar.aK());
            SocketMessageTask aF = eVar != null ? eVar.aF() : null;
            SocketMessageTask socketMessageTask = aF == null ? (SocketMessageTask) this.eD.findTask(cmd) : aF;
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
                    socketResponsedMessage.setErrorString(j.C(i));
                } else {
                    socketResponsedMessage.setErrorString(str);
                }
                socketResponsedMessage.setOrginalMessage(eVar.aE());
                k.a("queue", eVar.aE(), aH, "onMessageSendFail", i, "onMessageSendFail class = " + socketResponsedMessage.getClass().getName());
                this.eD.dispatchResponsedMessage(socketResponsedMessage);
            }
        }
    }

    private void aN() {
        e c = c.c(this.fk);
        if (c != null) {
            if (BdSocketLinkService.isClose()) {
                k.a("queue", c.aE(), 0, "sendNext", j.fO, "");
                BdSocketLinkService.startService(false, "send message");
            } else if (!this.fn || c.getPriority() <= -3) {
                BdSocketLinkService.sendMessage(c);
            }
        }
    }

    private void b(SocketResponsedMessage socketResponsedMessage) {
        this.eD.dispatchResponsedMessage(socketResponsedMessage);
    }

    private void e(e eVar) {
        if (eVar != null) {
            eVar.ay();
            c.b(eVar, this.fj);
            c.b(eVar, this.fk);
            c.b(eVar, this.fl);
        }
    }

    private void g(LinkedList<e> linkedList) {
        while (true) {
            e d = c.d(linkedList);
            if (d != null) {
                d.ay();
                a(d, j.fJ, null);
            } else {
                return;
            }
        }
    }

    public void aO() {
        g(this.fj);
        g(this.fk);
        g(this.fl);
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public boolean d(int i, String str) {
        if (this.fm != null) {
            this.fm.d(i, str);
        }
        if (this.fo != null) {
            this.fo.ap();
        }
        if (!com.baidu.adp.lib.util.k.fH() || c.e(this.fl) || c.e(this.fk) || c.e(this.fj) || !BdSocketLinkService.isAvailable()) {
            aO();
            return false;
        }
        c.f(this.fj);
        c.a(this.fk, this.fl);
        c.a(this.fk, this.fj);
        while (true) {
            e b = c.b(this.fk);
            if (b == null) {
                break;
            }
            b.ay();
            a(b, j.fJ, null);
        }
        if (c.a(this.fk) > 0) {
            k.a("queue", 0, 0, "onClose", j.fR, "have retry message, MessageQueue:reconnect");
            BdSocketLinkService.startService(false, "have retry message");
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void d(Map<String, String> map) {
        g.aM().c(map);
        if (this.fo != null) {
            this.fo.aq();
        }
        this.fn = true;
        k.a("queue", 0, 0, "onConnected", j.fV, "Queue blocked");
        if (this.fm != null) {
            this.fm.d(map);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void a(m.a aVar) {
        byte[] bArr;
        if (aVar != null && (bArr = aVar.rw) != null) {
            this.fp = System.currentTimeMillis();
            try {
                com.baidu.adp.framework.client.socket.coder.c i = com.baidu.adp.framework.client.socket.coder.b.bf().i(bArr);
                this.fq = 0;
                int bb = i.gn.bb();
                int bd = i.gn.bd();
                k.a("queue", bb, bd, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
                e e = e(bb, bd);
                if (e != null) {
                    e.fe = aVar.fe;
                    e.ff = aVar.ff;
                }
                if (this.fo != null) {
                    if (i.gn.bb() == this.fo.getCmd() && c.a(this.fk, this.fl)) {
                        aN();
                    }
                    this.fo.aq();
                }
                if (bd == 0 || (e != null && e.getCmd() == bb)) {
                    new d(i, e, this.fi, bd).execute(new String[0]);
                } else if (e != null) {
                    a(e, j.fX, null);
                }
                if (this.fm != null) {
                    this.fm.a(aVar);
                }
            } catch (CoderException e2) {
                int maxAlertCount = com.baidu.adp.lib.stats.switchs.a.eI().getMaxAlertCount("alert_protobuf", 2);
                int i2 = this.fq + 1;
                this.fq = i2;
                if (i2 >= maxAlertCount) {
                    com.baidu.adp.lib.stats.a.dN().p("alert_protobuf", "protbuf");
                }
                k.a("queue", 0, 0, "onBinaryMesssage", j.fE, "onBinaryMesssage decodeHeader error");
            }
        }
    }

    private e e(int i, int i2) {
        e eVar = null;
        if (i2 != 0) {
            e a = c.a(i2, this.fj);
            if (a == null && (a = c.a(i2, this.fl)) == null) {
                eVar = c.a(i2, this.fk);
                if (eVar == null) {
                    k.a("queue", i, i2, "findSenderData", j.fT, "original message removed , responsedMessage not dispatchMessage");
                }
            } else {
                eVar = a;
            }
            k.a("queue", i, i2, "findSenderData", j.fS, "received ack message");
        }
        return eVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
        aN();
        if (this.fm != null) {
            this.fm.a(cVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void A(String str) {
        if (this.fm != null) {
            this.fm.A(str);
        }
    }

    public void a(com.baidu.adp.framework.client.socket.link.e eVar) {
        this.fm = eVar;
    }

    public void aP() {
        boolean z = this.fn;
        this.fn = false;
        k.a("queue", 0, 0, "unBlockMessageQueue", j.fP, "Queue block has release");
        if (z) {
            aN();
        }
    }

    public void a(b bVar) {
        this.fo = bVar;
    }

    public boolean isValid() {
        return BdSocketLinkService.isOpen() && !this.fn && BdSocketLinkService.isAvailable();
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        removeMessage(0, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        c.b(this.fj, i, bdUniqueId);
        c.b(this.fk, i, bdUniqueId);
        c.b(this.fl, i, bdUniqueId);
    }

    public LinkedList<SocketMessage> a(BdUniqueId bdUniqueId) {
        return null;
    }

    @Override // com.baidu.adp.framework.b
    public LinkedList<SocketMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return null;
    }

    public boolean a(int i, BdUniqueId bdUniqueId) {
        return c.a(this.fk, i, bdUniqueId) || c.a(this.fj, i, bdUniqueId) || c.a(this.fl, i, bdUniqueId);
    }

    public long aQ() {
        return this.fp;
    }

    public int aR() {
        return BdAsyncTask.getTaskNum(d.ar());
    }

    public int B(int i) {
        return BdAsyncTask.getTaskNum(String.valueOf(i), d.ar());
    }

    public b aS() {
        return this.fo;
    }
}
