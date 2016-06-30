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
    private static /* synthetic */ int[] eP;
    private d.a eG;
    private final LinkedList<e> eH;
    private final LinkedList<e> eI;
    private final LinkedList<e> eJ;
    private com.baidu.adp.framework.client.socket.link.e eK;
    private boolean eL;
    private b eM;
    private long eN;
    private int eO;

    static /* synthetic */ int[] aU() {
        int[] iArr = eP;
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
            eP = iArr;
        }
        return iArr;
    }

    public h(MessageManager messageManager) {
        super(messageManager);
        this.eG = null;
        this.eH = new LinkedList<>();
        this.eI = new LinkedList<>();
        this.eJ = new LinkedList<>();
        this.eK = null;
        this.eL = true;
        this.eM = null;
        this.eN = 0L;
        this.eO = 0;
        BdSocketLinkService.setConnStateCallBack(this);
        this.eG = new i(this);
    }

    public boolean a(SocketMessage socketMessage) {
        if (socketMessage != null && (socketMessage instanceof a)) {
            a aVar = (a) socketMessage;
            if (c.a(this.eI, aVar, socketMessage.getCmd()) || c.a(this.eH, aVar, socketMessage.getCmd()) || c.a(this.eJ, aVar, socketMessage.getCmd())) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b
    public void a(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        com.baidu.adp.lib.util.k.fG();
        if (socketMessage != null && socketMessageTask != null) {
            if (a(socketMessage, socketMessageTask.bB())) {
                k.a("queue", socketMessage, 0, "sendMessage", j.fl, "duplicate message be removed");
                return;
            }
            e eVar = new e(socketMessage, socketMessageTask, this);
            if (BdSocketLinkService.hasAbsoluteClose()) {
                k.a("queue", socketMessage, 0, "sendMessage", j.fu, "user manual close socket");
                eVar.x(j.fu);
            } else if (!BdSocketLinkService.isAvailable()) {
                k.a("queue", socketMessage, 0, "sendMessage", j.fk, "isManualBlock message be removed");
                eVar.x(j.fk);
            } else {
                k.a("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                c.a(eVar, this.eI);
                aO();
            }
        }
    }

    private boolean a(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        if (socketMessage != null) {
            int cmd = socketMessage.getCmd();
            switch (aU()[dupLicateMode.ordinal()]) {
                case 2:
                    if (c.b(this.eI, cmd) || c.b(this.eH, cmd) || c.b(this.eJ, cmd)) {
                        return true;
                    }
                    break;
                case 3:
                    c.c(this.eI, cmd);
                    break;
                case 4:
                    c.c(this.eI, cmd);
                    c.c(this.eH, cmd);
                    c.c(this.eJ, cmd);
                    break;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(d.b bVar) {
        if (bVar != null) {
            if (bVar.er != null) {
                a(bVar.er, j.eU, null);
                return;
            }
            SocketResponsedMessage socketResponsedMessage = bVar.eq;
            if (socketResponsedMessage != null) {
                k.a("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
                b(socketResponsedMessage);
            }
        }
    }

    public void b(e eVar) {
        if (eVar != null && eVar.aI() && eVar.aL() < eVar.as()) {
            c.a(this.eH, this.eJ, eVar);
            if (this.eM != null) {
                this.eM.b(true, "timeout seq = " + eVar.aH());
            }
            k.a("queue", eVar.aE(), eVar.aH(), "onSendTimeOut", j.fo, String.valueOf(eVar.aL()));
            return;
        }
        e(eVar);
        a(eVar, j.ff, null);
        aO();
    }

    public void a(int i, e eVar) {
        int i2;
        if (i == 2) {
            if (eVar.aC() != null) {
                i2 = eVar.aC().getErrorCode();
            } else {
                i2 = j.fb;
            }
        } else {
            i2 = j.fg;
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
                c.a(this.eI, this.eH, eVar);
                return;
            }
            c.b(eVar, this.eI);
        }
    }

    protected void a(e eVar, int i, String str) {
        SocketResponsedMessage socketResponsedMessage = null;
        if (eVar != null && eVar.aE() != null) {
            int cmd = eVar.aE().getCmd();
            int aH = eVar.aH();
            k.a("queue", eVar.aE(), aH, "onMessageSendFail", i, String.valueOf(str) + " retryTime-" + eVar.aL());
            SocketMessageTask aF = eVar != null ? eVar.aF() : null;
            SocketMessageTask socketMessageTask = aF == null ? (SocketMessageTask) this.ea.findTask(cmd) : aF;
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
                this.ea.dispatchResponsedMessage(socketResponsedMessage);
            }
        }
    }

    private void aO() {
        e c = c.c(this.eI);
        if (c != null) {
            if (BdSocketLinkService.isClose()) {
                k.a("queue", c.aE(), 0, "sendNext", j.fm, "");
                BdSocketLinkService.startService(false, "send message");
            } else if (!this.eL || c.getPriority() <= -3) {
                BdSocketLinkService.sendMessage(c);
            }
        }
    }

    private void b(SocketResponsedMessage socketResponsedMessage) {
        this.ea.dispatchResponsedMessage(socketResponsedMessage);
    }

    private void e(e eVar) {
        if (eVar != null) {
            eVar.ay();
            c.b(eVar, this.eH);
            c.b(eVar, this.eI);
            c.b(eVar, this.eJ);
        }
    }

    private void g(LinkedList<e> linkedList) {
        while (true) {
            e d = c.d(linkedList);
            if (d != null) {
                d.ay();
                a(d, j.fh, null);
            } else {
                return;
            }
        }
    }

    public void aP() {
        g(this.eH);
        g(this.eI);
        g(this.eJ);
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public boolean d(int i, String str) {
        if (this.eK != null) {
            this.eK.d(i, str);
        }
        if (this.eM != null) {
            this.eM.ap();
        }
        if (!com.baidu.adp.lib.util.k.fI() || c.e(this.eJ) || c.e(this.eI) || c.e(this.eH) || !BdSocketLinkService.isAvailable()) {
            aP();
            return false;
        }
        c.f(this.eH);
        c.a(this.eI, this.eJ);
        c.a(this.eI, this.eH);
        while (true) {
            e b = c.b(this.eI);
            if (b == null) {
                break;
            }
            b.ay();
            a(b, j.fh, null);
        }
        if (c.a(this.eI) > 0) {
            k.a("queue", 0, 0, "onClose", j.fp, "have retry message, MessageQueue:reconnect");
            BdSocketLinkService.startService(false, "have retry message");
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void d(Map<String, String> map) {
        g.aN().c(map);
        if (this.eM != null) {
            this.eM.aq();
        }
        this.eL = true;
        k.a("queue", 0, 0, "onConnected", j.ft, "Queue blocked");
        if (this.eK != null) {
            this.eK.d(map);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void a(m.a aVar) {
        byte[] bArr;
        if (aVar != null && (bArr = aVar.qT) != null) {
            this.eN = System.currentTimeMillis();
            try {
                com.baidu.adp.framework.client.socket.coder.c e = com.baidu.adp.framework.client.socket.coder.b.bg().e(bArr);
                this.eO = 0;
                int bc = e.fL.bc();
                int be = e.fL.be();
                k.a("queue", bc, be, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
                e e2 = e(bc, be);
                if (e2 != null) {
                    e2.eC = aVar.eC;
                    e2.eD = aVar.eD;
                }
                if (this.eM != null) {
                    if (e.fL.bc() == this.eM.getCmd() && c.a(this.eI, this.eJ)) {
                        aO();
                    }
                    this.eM.aq();
                }
                if (be == 0 || (e2 != null && e2.getCmd() == bc)) {
                    new d(e, e2, this.eG, be).execute(new String[0]);
                } else if (e2 != null) {
                    a(e2, j.fv, null);
                }
                if (this.eK != null) {
                    this.eK.a(aVar);
                }
            } catch (CoderException e3) {
                int maxAlertCount = com.baidu.adp.lib.stats.switchs.a.eJ().getMaxAlertCount("alert_protobuf", 2);
                int i = this.eO + 1;
                this.eO = i;
                if (i >= maxAlertCount) {
                    com.baidu.adp.lib.stats.a.dO().p("alert_protobuf", "protbuf");
                }
                k.a("queue", 0, 0, "onBinaryMesssage", j.fc, "onBinaryMesssage decodeHeader error");
            }
        }
    }

    private e e(int i, int i2) {
        e eVar = null;
        if (i2 != 0) {
            e a = c.a(i2, this.eH);
            if (a == null && (a = c.a(i2, this.eJ)) == null) {
                eVar = c.a(i2, this.eI);
                if (eVar == null) {
                    k.a("queue", i, i2, "findSenderData", j.fr, "original message removed , responsedMessage not dispatchMessage");
                }
            } else {
                eVar = a;
            }
            k.a("queue", i, i2, "findSenderData", j.fq, "received ack message");
        }
        return eVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
        aO();
        if (this.eK != null) {
            this.eK.a(cVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void y(String str) {
        if (this.eK != null) {
            this.eK.y(str);
        }
    }

    public void a(com.baidu.adp.framework.client.socket.link.e eVar) {
        this.eK = eVar;
    }

    public void aQ() {
        boolean z = this.eL;
        this.eL = false;
        k.a("queue", 0, 0, "unBlockMessageQueue", j.fn, "Queue block has release");
        if (z) {
            aO();
        }
    }

    public void a(b bVar) {
        this.eM = bVar;
    }

    public boolean isValid() {
        return BdSocketLinkService.isOpen() && !this.eL && BdSocketLinkService.isAvailable();
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        removeMessage(0, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        c.b(this.eH, i, bdUniqueId);
        c.b(this.eI, i, bdUniqueId);
        c.b(this.eJ, i, bdUniqueId);
    }

    public LinkedList<SocketMessage> a(BdUniqueId bdUniqueId) {
        return null;
    }

    @Override // com.baidu.adp.framework.b
    public LinkedList<SocketMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return null;
    }

    public boolean a(int i, BdUniqueId bdUniqueId) {
        return c.a(this.eI, i, bdUniqueId) || c.a(this.eH, i, bdUniqueId) || c.a(this.eJ, i, bdUniqueId);
    }

    public long aR() {
        return this.eN;
    }

    public int aS() {
        return BdAsyncTask.getTaskNum(d.ar());
    }

    public int y(int i) {
        return BdAsyncTask.getTaskNum(String.valueOf(i), d.ar());
    }

    public b aT() {
        return this.eM;
    }
}
