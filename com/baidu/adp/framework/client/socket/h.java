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
    private static /* synthetic */ int[] hF;
    private com.baidu.adp.framework.client.socket.link.e hA;
    private boolean hB;
    private b hC;
    private long hD;
    private int hE;
    private d.a hw;
    private final LinkedList<e> hx;
    private final LinkedList<e> hy;
    private final LinkedList<e> hz;

    static /* synthetic */ int[] bO() {
        int[] iArr = hF;
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
            hF = iArr;
        }
        return iArr;
    }

    public h(MessageManager messageManager) {
        super(messageManager);
        this.hw = null;
        this.hx = new LinkedList<>();
        this.hy = new LinkedList<>();
        this.hz = new LinkedList<>();
        this.hA = null;
        this.hB = true;
        this.hC = null;
        this.hD = 0L;
        this.hE = 0;
        BdSocketLinkService.setConnStateCallBack(this);
        this.hw = new i(this);
    }

    public boolean a(SocketMessage socketMessage) {
        if (socketMessage != null && (socketMessage instanceof a)) {
            a aVar = (a) socketMessage;
            if (c.a(this.hy, aVar, socketMessage.getCmd()) || c.a(this.hx, aVar, socketMessage.getCmd()) || c.a(this.hz, aVar, socketMessage.getCmd())) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b
    public void a(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        com.baidu.adp.lib.util.k.gB();
        if (socketMessage != null && socketMessageTask != null) {
            if (a(socketMessage, socketMessageTask.cv())) {
                k.a("queue", socketMessage, 0, "sendMessage", j.ib, "duplicate message be removed");
                return;
            }
            e eVar = new e(socketMessage, socketMessageTask, this);
            if (BdSocketLinkService.hasAbsoluteClose()) {
                k.a("queue", socketMessage, 0, "sendMessage", j.il, "user manual close socket");
                eVar.N(j.il);
            } else if (!BdSocketLinkService.isAvailable()) {
                k.a("queue", socketMessage, 0, "sendMessage", j.ia, "isManualBlock message be removed");
                eVar.N(j.ia);
            } else {
                k.a("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                c.a(eVar, this.hy);
                bI();
            }
        }
    }

    private boolean a(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        if (socketMessage != null) {
            int cmd = socketMessage.getCmd();
            switch (bO()[dupLicateMode.ordinal()]) {
                case 2:
                    if (c.b(this.hy, cmd) || c.b(this.hx, cmd) || c.b(this.hz, cmd)) {
                        return true;
                    }
                    break;
                case 3:
                    c.c(this.hy, cmd);
                    break;
                case 4:
                    c.c(this.hy, cmd);
                    c.c(this.hx, cmd);
                    c.c(this.hz, cmd);
                    break;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(d.b bVar) {
        if (bVar != null) {
            if (bVar.hi != null) {
                a(bVar.hi, j.hK, null);
                return;
            }
            SocketResponsedMessage socketResponsedMessage = bVar.hh;
            if (socketResponsedMessage != null) {
                k.a("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
                b(socketResponsedMessage);
            }
        }
    }

    public void b(e eVar) {
        if (eVar != null && eVar.canRetry() && eVar.bF() < eVar.bn()) {
            c.a(this.hx, this.hz, eVar);
            if (this.hC != null) {
                this.hC.b(true, "timeout seq = " + eVar.bC());
            }
            k.a("queue", eVar.bz(), eVar.bC(), "onSendTimeOut", j.f0if, String.valueOf(eVar.bF()));
            return;
        }
        e(eVar);
        a(eVar, j.hV, null);
        bI();
    }

    public void a(int i, e eVar) {
        int i2;
        if (i == 2) {
            if (eVar.bx() != null) {
                i2 = eVar.bx().getErrorCode();
            } else {
                i2 = j.hR;
            }
        } else {
            i2 = j.hW;
        }
        String P = j.P(i2);
        e(eVar);
        a(eVar, i2, P);
    }

    public void c(e eVar) {
    }

    public void d(e eVar) {
        if (eVar != null) {
            if (eVar.by()) {
                eVar.bG();
                c.a(this.hy, this.hx, eVar);
                return;
            }
            c.b(eVar, this.hy);
        }
    }

    protected void a(e eVar, int i, String str) {
        SocketResponsedMessage socketResponsedMessage = null;
        if (eVar != null && eVar.bz() != null) {
            int cmd = eVar.bz().getCmd();
            int bC = eVar.bC();
            k.a("queue", eVar.bz(), bC, "onMessageSendFail", i, String.valueOf(str) + " retryTime-" + eVar.bF());
            SocketMessageTask bA = eVar != null ? eVar.bA() : null;
            SocketMessageTask socketMessageTask = bA == null ? (SocketMessageTask) this.gQ.findTask(cmd) : bA;
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
                    socketResponsedMessage.setErrorString(j.P(i));
                } else {
                    socketResponsedMessage.setErrorString(str);
                }
                socketResponsedMessage.setOrginalMessage(eVar.bz());
                k.a("queue", eVar.bz(), bC, "onMessageSendFail", i, "onMessageSendFail class = " + socketResponsedMessage.getClass().getName());
                this.gQ.dispatchResponsedMessage(socketResponsedMessage);
            }
        }
    }

    private void bI() {
        e c = c.c(this.hy);
        if (c != null) {
            if (BdSocketLinkService.isClose()) {
                k.a("queue", c.bz(), 0, "sendNext", j.ic, "");
                BdSocketLinkService.startService(false, "send message");
            } else if (!this.hB || c.getPriority() <= -3) {
                BdSocketLinkService.sendMessage(c);
            }
        }
    }

    private void b(SocketResponsedMessage socketResponsedMessage) {
        this.gQ.dispatchResponsedMessage(socketResponsedMessage);
    }

    private void e(e eVar) {
        if (eVar != null) {
            eVar.bt();
            c.b(eVar, this.hx);
            c.b(eVar, this.hy);
            c.b(eVar, this.hz);
        }
    }

    private void g(LinkedList<e> linkedList) {
        while (true) {
            e d = c.d(linkedList);
            if (d != null) {
                d.bt();
                a(d, j.hX, null);
            } else {
                return;
            }
        }
    }

    public void bJ() {
        g(this.hx);
        g(this.hy);
        g(this.hz);
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public boolean c(int i, String str) {
        if (this.hA != null) {
            this.hA.c(i, str);
        }
        if (this.hC != null) {
            this.hC.bk();
        }
        if (!com.baidu.adp.lib.util.k.gD() || c.e(this.hz) || c.e(this.hy) || c.e(this.hx) || !BdSocketLinkService.isAvailable()) {
            bJ();
            return false;
        }
        c.f(this.hx);
        c.a(this.hy, this.hz);
        c.a(this.hy, this.hx);
        while (true) {
            e b = c.b(this.hy);
            if (b == null) {
                break;
            }
            b.bt();
            a(b, j.hX, null);
        }
        if (c.a(this.hy) > 0) {
            k.a("queue", 0, 0, "onClose", j.ig, "have retry message, MessageQueue:reconnect");
            BdSocketLinkService.startService(false, "have retry message");
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void d(Map<String, String> map) {
        g.bH().c(map);
        if (this.hC != null) {
            this.hC.bl();
        }
        this.hB = true;
        k.a("queue", 0, 0, "onConnected", j.ik, "Queue blocked");
        if (this.hA != null) {
            this.hA.d(map);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void a(m.a aVar) {
        byte[] bArr;
        if (aVar != null && (bArr = aVar.tP) != null) {
            this.hD = System.currentTimeMillis();
            try {
                com.baidu.adp.framework.client.socket.coder.c i = com.baidu.adp.framework.client.socket.coder.b.ca().i(bArr);
                this.hE = 0;
                int bW = i.iH.bW();
                int bY = i.iH.bY();
                k.a("queue", bW, bY, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
                e g = g(bW, bY);
                if (g != null) {
                    g.hs = aVar.hs;
                    g.ht = aVar.ht;
                }
                if (this.hC != null) {
                    if (i.iH.bW() == this.hC.getCmd() && c.a(this.hy, this.hz)) {
                        bI();
                    }
                    this.hC.bl();
                }
                if (bY == 0 || (g != null && g.getCmd() == bW)) {
                    new d(i, g, this.hw, bY).execute(new String[0]);
                } else if (g != null) {
                    a(g, j.im, null);
                }
                if (this.hA != null) {
                    this.hA.a(aVar);
                }
            } catch (CoderException e) {
                int maxAlertCount = com.baidu.adp.lib.stats.switchs.a.fD().getMaxAlertCount("alert_protobuf", 2);
                int i2 = this.hE + 1;
                this.hE = i2;
                if (i2 >= maxAlertCount) {
                    com.baidu.adp.lib.stats.a.eI().p("alert_protobuf", "protbuf");
                }
                k.a("queue", 0, 0, "onBinaryMesssage", j.hS, "onBinaryMesssage decodeHeader error");
            }
        }
    }

    private e g(int i, int i2) {
        e eVar = null;
        if (i2 != 0) {
            e a = c.a(i2, this.hx);
            if (a == null && (a = c.a(i2, this.hz)) == null) {
                eVar = c.a(i2, this.hy);
                if (eVar == null) {
                    k.a("queue", i, i2, "findSenderData", j.ii, "original message removed , responsedMessage not dispatchMessage");
                }
            } else {
                eVar = a;
            }
            k.a("queue", i, i2, "findSenderData", j.ih, "received ack message");
        }
        return eVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
        bI();
        if (this.hA != null) {
            this.hA.a(cVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void B(String str) {
        if (this.hA != null) {
            this.hA.B(str);
        }
    }

    public void a(com.baidu.adp.framework.client.socket.link.e eVar) {
        this.hA = eVar;
    }

    public void bK() {
        boolean z = this.hB;
        this.hB = false;
        k.a("queue", 0, 0, "unBlockMessageQueue", j.ie, "Queue block has release");
        if (z) {
            bI();
        }
    }

    public void a(b bVar) {
        this.hC = bVar;
    }

    public boolean isValid() {
        return BdSocketLinkService.isOpen() && !this.hB && BdSocketLinkService.isAvailable();
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        removeMessage(0, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        c.b(this.hx, i, bdUniqueId);
        c.b(this.hy, i, bdUniqueId);
        c.b(this.hz, i, bdUniqueId);
    }

    public LinkedList<SocketMessage> a(BdUniqueId bdUniqueId) {
        return null;
    }

    @Override // com.baidu.adp.framework.b
    public LinkedList<SocketMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return null;
    }

    public boolean a(int i, BdUniqueId bdUniqueId) {
        return c.a(this.hy, i, bdUniqueId) || c.a(this.hx, i, bdUniqueId) || c.a(this.hz, i, bdUniqueId);
    }

    public long bL() {
        return this.hD;
    }

    public int bM() {
        return BdAsyncTask.getTaskNum(d.bm());
    }

    public int O(int i) {
        return BdAsyncTask.getTaskNum(String.valueOf(i), d.bm());
    }

    public b bN() {
        return this.hC;
    }
}
