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
    private static /* synthetic */ int[] eQ;
    private d.a eH;
    private final LinkedList<e> eI;
    private final LinkedList<e> eJ;
    private final LinkedList<e> eK;
    private com.baidu.adp.framework.client.socket.link.e eL;
    private boolean eM;
    private b eN;
    private long eO;
    private int eP;

    static /* synthetic */ int[] aU() {
        int[] iArr = eQ;
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
            eQ = iArr;
        }
        return iArr;
    }

    public h(MessageManager messageManager) {
        super(messageManager);
        this.eH = null;
        this.eI = new LinkedList<>();
        this.eJ = new LinkedList<>();
        this.eK = new LinkedList<>();
        this.eL = null;
        this.eM = true;
        this.eN = null;
        this.eO = 0L;
        this.eP = 0;
        BdSocketLinkService.setConnStateCallBack(this);
        this.eH = new i(this);
    }

    public boolean a(SocketMessage socketMessage) {
        if (socketMessage != null && (socketMessage instanceof a)) {
            a aVar = (a) socketMessage;
            if (c.a(this.eJ, aVar, socketMessage.getCmd()) || c.a(this.eI, aVar, socketMessage.getCmd()) || c.a(this.eK, aVar, socketMessage.getCmd())) {
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
                k.a("queue", socketMessage, 0, "sendMessage", j.fm, "duplicate message be removed");
                return;
            }
            e eVar = new e(socketMessage, socketMessageTask, this);
            if (BdSocketLinkService.hasAbsoluteClose()) {
                k.a("queue", socketMessage, 0, "sendMessage", j.fv, "user manual close socket");
                eVar.x(j.fv);
            } else if (!BdSocketLinkService.isAvailable()) {
                k.a("queue", socketMessage, 0, "sendMessage", j.fl, "isManualBlock message be removed");
                eVar.x(j.fl);
            } else {
                k.a("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                c.a(eVar, this.eJ);
                aO();
            }
        }
    }

    private boolean a(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        if (socketMessage != null) {
            int cmd = socketMessage.getCmd();
            switch (aU()[dupLicateMode.ordinal()]) {
                case 2:
                    if (c.b(this.eJ, cmd) || c.b(this.eI, cmd) || c.b(this.eK, cmd)) {
                        return true;
                    }
                    break;
                case 3:
                    c.c(this.eJ, cmd);
                    break;
                case 4:
                    c.c(this.eJ, cmd);
                    c.c(this.eI, cmd);
                    c.c(this.eK, cmd);
                    break;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(d.b bVar) {
        if (bVar != null) {
            if (bVar.es != null) {
                a(bVar.es, j.eV, null);
                return;
            }
            SocketResponsedMessage socketResponsedMessage = bVar.er;
            if (socketResponsedMessage != null) {
                k.a("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
                b(socketResponsedMessage);
            }
        }
    }

    public void b(e eVar) {
        if (eVar != null && eVar.aI() && eVar.aL() < eVar.as()) {
            c.a(this.eI, this.eK, eVar);
            if (this.eN != null) {
                this.eN.b(true, "timeout seq = " + eVar.aH());
            }
            k.a("queue", eVar.aE(), eVar.aH(), "onSendTimeOut", j.fp, String.valueOf(eVar.aL()));
            return;
        }
        e(eVar);
        a(eVar, j.fg, null);
        aO();
    }

    public void a(int i, e eVar) {
        int i2;
        if (i == 2) {
            if (eVar.aC() != null) {
                i2 = eVar.aC().getErrorCode();
            } else {
                i2 = j.fc;
            }
        } else {
            i2 = j.fh;
        }
        String z = j.z(i2);
        e(eVar);
        a(eVar, i2, z);
    }

    public void c(e eVar) {
    }

    public void d(e eVar) {
        if (eVar != null) {
            if (eVar.aD()) {
                eVar.aM();
                c.a(this.eJ, this.eI, eVar);
                return;
            }
            c.b(eVar, this.eJ);
        }
    }

    protected void a(e eVar, int i, String str) {
        SocketResponsedMessage socketResponsedMessage = null;
        if (eVar != null && eVar.aE() != null) {
            int cmd = eVar.aE().getCmd();
            int aH = eVar.aH();
            k.a("queue", eVar.aE(), aH, "onMessageSendFail", i, String.valueOf(str) + " retryTime-" + eVar.aL());
            SocketMessageTask aF = eVar != null ? eVar.aF() : null;
            SocketMessageTask socketMessageTask = aF == null ? (SocketMessageTask) this.eb.findTask(cmd) : aF;
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
                    socketResponsedMessage.setErrorString(j.z(i));
                } else {
                    socketResponsedMessage.setErrorString(str);
                }
                socketResponsedMessage.setOrginalMessage(eVar.aE());
                k.a("queue", eVar.aE(), aH, "onMessageSendFail", i, "onMessageSendFail class = " + socketResponsedMessage.getClass().getName());
                this.eb.dispatchResponsedMessage(socketResponsedMessage);
            }
        }
    }

    private void aO() {
        e c = c.c(this.eJ);
        if (c != null) {
            if (BdSocketLinkService.isClose()) {
                k.a("queue", c.aE(), 0, "sendNext", j.fn, "");
                BdSocketLinkService.startService(false, "send message");
            } else if (!this.eM || c.getPriority() <= -3) {
                BdSocketLinkService.sendMessage(c);
            }
        }
    }

    private void b(SocketResponsedMessage socketResponsedMessage) {
        this.eb.dispatchResponsedMessage(socketResponsedMessage);
    }

    private void e(e eVar) {
        if (eVar != null) {
            eVar.ay();
            c.b(eVar, this.eI);
            c.b(eVar, this.eJ);
            c.b(eVar, this.eK);
        }
    }

    private void g(LinkedList<e> linkedList) {
        while (true) {
            e d = c.d(linkedList);
            if (d != null) {
                d.ay();
                a(d, j.fi, null);
            } else {
                return;
            }
        }
    }

    public void aP() {
        g(this.eI);
        g(this.eJ);
        g(this.eK);
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public boolean d(int i, String str) {
        if (this.eL != null) {
            this.eL.d(i, str);
        }
        if (this.eN != null) {
            this.eN.ap();
        }
        if (!com.baidu.adp.lib.util.k.fH() || c.e(this.eK) || c.e(this.eJ) || c.e(this.eI) || !BdSocketLinkService.isAvailable()) {
            aP();
            return false;
        }
        c.f(this.eI);
        c.a(this.eJ, this.eK);
        c.a(this.eJ, this.eI);
        while (true) {
            e b = c.b(this.eJ);
            if (b == null) {
                break;
            }
            b.ay();
            a(b, j.fi, null);
        }
        if (c.a(this.eJ) > 0) {
            k.a("queue", 0, 0, "onClose", j.fq, "have retry message, MessageQueue:reconnect");
            BdSocketLinkService.startService(false, "have retry message");
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void c(Map<String, String> map) {
        g.aN().b(map);
        if (this.eN != null) {
            this.eN.aq();
        }
        this.eM = true;
        k.a("queue", 0, 0, "onConnected", j.fu, "Queue blocked");
        if (this.eL != null) {
            this.eL.c(map);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void a(m.a aVar) {
        byte[] bArr;
        if (aVar != null && (bArr = aVar.qT) != null) {
            this.eO = System.currentTimeMillis();
            try {
                com.baidu.adp.framework.client.socket.coder.c e = com.baidu.adp.framework.client.socket.coder.b.bf().e(bArr);
                this.eP = 0;
                int bb = e.fM.bb();
                int bd = e.fM.bd();
                k.a("queue", bb, bd, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
                e e2 = e(bb, bd);
                if (e2 != null) {
                    e2.eD = aVar.eD;
                    e2.eE = aVar.eE;
                }
                if (this.eN != null) {
                    if (e.fM.bb() == this.eN.getCmd() && c.a(this.eJ, this.eK)) {
                        aO();
                    }
                    this.eN.aq();
                }
                if (bd == 0 || (e2 != null && e2.getCmd() == bb)) {
                    new d(e, e2, this.eH, bd).execute(new String[0]);
                } else if (e2 != null) {
                    a(e2, j.fw, null);
                }
                if (this.eL != null) {
                    this.eL.a(aVar);
                }
            } catch (CoderException e3) {
                int maxAlertCount = com.baidu.adp.lib.stats.switchs.a.eI().getMaxAlertCount("alert_protobuf", 2);
                int i = this.eP + 1;
                this.eP = i;
                if (i >= maxAlertCount) {
                    com.baidu.adp.lib.stats.a.dN().p("alert_protobuf", "protbuf");
                }
                k.a("queue", 0, 0, "onBinaryMesssage", j.fd, "onBinaryMesssage decodeHeader error");
            }
        }
    }

    private e e(int i, int i2) {
        e eVar = null;
        if (i2 != 0) {
            e a = c.a(i2, this.eI);
            if (a == null && (a = c.a(i2, this.eK)) == null) {
                eVar = c.a(i2, this.eJ);
                if (eVar == null) {
                    k.a("queue", i, i2, "findSenderData", j.fs, "original message removed , responsedMessage not dispatchMessage");
                }
            } else {
                eVar = a;
            }
            k.a("queue", i, i2, "findSenderData", j.fr, "received ack message");
        }
        return eVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
        aO();
        if (this.eL != null) {
            this.eL.a(cVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void y(String str) {
        if (this.eL != null) {
            this.eL.y(str);
        }
    }

    public void a(com.baidu.adp.framework.client.socket.link.e eVar) {
        this.eL = eVar;
    }

    public void aQ() {
        boolean z = this.eM;
        this.eM = false;
        k.a("queue", 0, 0, "unBlockMessageQueue", j.fo, "Queue block has release");
        if (z) {
            aO();
        }
    }

    public void a(b bVar) {
        this.eN = bVar;
    }

    public boolean isValid() {
        return BdSocketLinkService.isOpen() && !this.eM && BdSocketLinkService.isAvailable();
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        removeMessage(0, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        c.b(this.eI, i, bdUniqueId);
        c.b(this.eJ, i, bdUniqueId);
        c.b(this.eK, i, bdUniqueId);
    }

    public LinkedList<SocketMessage> a(BdUniqueId bdUniqueId) {
        return null;
    }

    @Override // com.baidu.adp.framework.b
    public LinkedList<SocketMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return null;
    }

    public boolean a(int i, BdUniqueId bdUniqueId) {
        return c.a(this.eJ, i, bdUniqueId) || c.a(this.eI, i, bdUniqueId) || c.a(this.eK, i, bdUniqueId);
    }

    public long aR() {
        return this.eO;
    }

    public int aS() {
        return BdAsyncTask.getTaskNum(d.ar());
    }

    public int y(int i) {
        return BdAsyncTask.getTaskNum(String.valueOf(i), d.ar());
    }

    public b aT() {
        return this.eN;
    }
}
