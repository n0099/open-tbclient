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
    private static /* synthetic */ int[] hE;
    private boolean hA;
    private b hB;
    private long hC;
    private int hD;
    private d.a hv;
    private final LinkedList<e> hw;
    private final LinkedList<e> hx;
    private final LinkedList<e> hy;
    private com.baidu.adp.framework.client.socket.link.e hz;

    static /* synthetic */ int[] bO() {
        int[] iArr = hE;
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
            hE = iArr;
        }
        return iArr;
    }

    public h(MessageManager messageManager) {
        super(messageManager);
        this.hv = null;
        this.hw = new LinkedList<>();
        this.hx = new LinkedList<>();
        this.hy = new LinkedList<>();
        this.hz = null;
        this.hA = true;
        this.hB = null;
        this.hC = 0L;
        this.hD = 0;
        BdSocketLinkService.setConnStateCallBack(this);
        this.hv = new i(this);
    }

    public boolean a(SocketMessage socketMessage) {
        if (socketMessage != null && (socketMessage instanceof a)) {
            a aVar = (a) socketMessage;
            if (c.a(this.hx, aVar, socketMessage.getCmd()) || c.a(this.hw, aVar, socketMessage.getCmd()) || c.a(this.hy, aVar, socketMessage.getCmd())) {
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
                k.a("queue", socketMessage, 0, "sendMessage", j.ia, "duplicate message be removed");
                return;
            }
            e eVar = new e(socketMessage, socketMessageTask, this);
            if (BdSocketLinkService.hasAbsoluteClose()) {
                k.a("queue", socketMessage, 0, "sendMessage", j.ik, "user manual close socket");
                eVar.N(j.ik);
            } else if (!BdSocketLinkService.isAvailable()) {
                k.a("queue", socketMessage, 0, "sendMessage", j.hZ, "isManualBlock message be removed");
                eVar.N(j.hZ);
            } else {
                k.a("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                c.a(eVar, this.hx);
                bI();
            }
        }
    }

    private boolean a(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        if (socketMessage != null) {
            int cmd = socketMessage.getCmd();
            switch (bO()[dupLicateMode.ordinal()]) {
                case 2:
                    if (c.b(this.hx, cmd) || c.b(this.hw, cmd) || c.b(this.hy, cmd)) {
                        return true;
                    }
                    break;
                case 3:
                    c.c(this.hx, cmd);
                    break;
                case 4:
                    c.c(this.hx, cmd);
                    c.c(this.hw, cmd);
                    c.c(this.hy, cmd);
                    break;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(d.b bVar) {
        if (bVar != null) {
            if (bVar.hh != null) {
                a(bVar.hh, j.hJ, null);
                return;
            }
            SocketResponsedMessage socketResponsedMessage = bVar.hg;
            if (socketResponsedMessage != null) {
                k.a("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
                b(socketResponsedMessage);
            }
        }
    }

    public void b(e eVar) {
        if (eVar != null && eVar.canRetry() && eVar.bF() < eVar.bn()) {
            c.a(this.hw, this.hy, eVar);
            if (this.hB != null) {
                this.hB.b(true, "timeout seq = " + eVar.bC());
            }
            k.a("queue", eVar.bz(), eVar.bC(), "onSendTimeOut", j.ie, String.valueOf(eVar.bF()));
            return;
        }
        e(eVar);
        a(eVar, j.hU, null);
        bI();
    }

    public void a(int i, e eVar) {
        int i2;
        if (i == 2) {
            if (eVar.bx() != null) {
                i2 = eVar.bx().getErrorCode();
            } else {
                i2 = j.hQ;
            }
        } else {
            i2 = j.hV;
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
                c.a(this.hx, this.hw, eVar);
                return;
            }
            c.b(eVar, this.hx);
        }
    }

    protected void a(e eVar, int i, String str) {
        SocketResponsedMessage socketResponsedMessage = null;
        if (eVar != null && eVar.bz() != null) {
            int cmd = eVar.bz().getCmd();
            int bC = eVar.bC();
            k.a("queue", eVar.bz(), bC, "onMessageSendFail", i, String.valueOf(str) + " retryTime-" + eVar.bF());
            SocketMessageTask bA = eVar != null ? eVar.bA() : null;
            SocketMessageTask socketMessageTask = bA == null ? (SocketMessageTask) this.gP.findTask(cmd) : bA;
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
                this.gP.dispatchResponsedMessage(socketResponsedMessage);
            }
        }
    }

    private void bI() {
        e c = c.c(this.hx);
        if (c != null) {
            if (BdSocketLinkService.isClose()) {
                k.a("queue", c.bz(), 0, "sendNext", j.ib, "");
                BdSocketLinkService.startService(false, "send message");
            } else if (!this.hA || c.getPriority() <= -3) {
                BdSocketLinkService.sendMessage(c);
            }
        }
    }

    private void b(SocketResponsedMessage socketResponsedMessage) {
        this.gP.dispatchResponsedMessage(socketResponsedMessage);
    }

    private void e(e eVar) {
        if (eVar != null) {
            eVar.bt();
            c.b(eVar, this.hw);
            c.b(eVar, this.hx);
            c.b(eVar, this.hy);
        }
    }

    private void g(LinkedList<e> linkedList) {
        while (true) {
            e d = c.d(linkedList);
            if (d != null) {
                d.bt();
                a(d, j.hW, null);
            } else {
                return;
            }
        }
    }

    public void bJ() {
        g(this.hw);
        g(this.hx);
        g(this.hy);
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public boolean d(int i, String str) {
        if (this.hz != null) {
            this.hz.d(i, str);
        }
        if (this.hB != null) {
            this.hB.bk();
        }
        if (!com.baidu.adp.lib.util.k.gD() || c.e(this.hy) || c.e(this.hx) || c.e(this.hw) || !BdSocketLinkService.isAvailable()) {
            bJ();
            return false;
        }
        c.f(this.hw);
        c.a(this.hx, this.hy);
        c.a(this.hx, this.hw);
        while (true) {
            e b = c.b(this.hx);
            if (b == null) {
                break;
            }
            b.bt();
            a(b, j.hW, null);
        }
        if (c.a(this.hx) > 0) {
            k.a("queue", 0, 0, "onClose", j.f0if, "have retry message, MessageQueue:reconnect");
            BdSocketLinkService.startService(false, "have retry message");
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void d(Map<String, String> map) {
        g.bH().c(map);
        if (this.hB != null) {
            this.hB.bl();
        }
        this.hA = true;
        k.a("queue", 0, 0, "onConnected", j.ij, "Queue blocked");
        if (this.hz != null) {
            this.hz.d(map);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void a(m.a aVar) {
        byte[] bArr;
        if (aVar != null && (bArr = aVar.tO) != null) {
            this.hC = System.currentTimeMillis();
            try {
                com.baidu.adp.framework.client.socket.coder.c i = com.baidu.adp.framework.client.socket.coder.b.ca().i(bArr);
                this.hD = 0;
                int bW = i.iG.bW();
                int bY = i.iG.bY();
                k.a("queue", bW, bY, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
                e g = g(bW, bY);
                if (g != null) {
                    g.hr = aVar.hr;
                    g.hs = aVar.hs;
                }
                if (this.hB != null) {
                    if (i.iG.bW() == this.hB.getCmd() && c.a(this.hx, this.hy)) {
                        bI();
                    }
                    this.hB.bl();
                }
                if (bY == 0 || (g != null && g.getCmd() == bW)) {
                    new d(i, g, this.hv, bY).execute(new String[0]);
                } else if (g != null) {
                    a(g, j.il, null);
                }
                if (this.hz != null) {
                    this.hz.a(aVar);
                }
            } catch (CoderException e) {
                int maxAlertCount = com.baidu.adp.lib.stats.switchs.a.fD().getMaxAlertCount("alert_protobuf", 2);
                int i2 = this.hD + 1;
                this.hD = i2;
                if (i2 >= maxAlertCount) {
                    com.baidu.adp.lib.stats.a.eI().p("alert_protobuf", "protbuf");
                }
                k.a("queue", 0, 0, "onBinaryMesssage", j.hR, "onBinaryMesssage decodeHeader error");
            }
        }
    }

    private e g(int i, int i2) {
        e eVar = null;
        if (i2 != 0) {
            e a = c.a(i2, this.hw);
            if (a == null && (a = c.a(i2, this.hy)) == null) {
                eVar = c.a(i2, this.hx);
                if (eVar == null) {
                    k.a("queue", i, i2, "findSenderData", j.ih, "original message removed , responsedMessage not dispatchMessage");
                }
            } else {
                eVar = a;
            }
            k.a("queue", i, i2, "findSenderData", j.ig, "received ack message");
        }
        return eVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
        bI();
        if (this.hz != null) {
            this.hz.a(cVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void B(String str) {
        if (this.hz != null) {
            this.hz.B(str);
        }
    }

    public void a(com.baidu.adp.framework.client.socket.link.e eVar) {
        this.hz = eVar;
    }

    public void bK() {
        boolean z = this.hA;
        this.hA = false;
        k.a("queue", 0, 0, "unBlockMessageQueue", j.ic, "Queue block has release");
        if (z) {
            bI();
        }
    }

    public void a(b bVar) {
        this.hB = bVar;
    }

    public boolean isValid() {
        return BdSocketLinkService.isOpen() && !this.hA && BdSocketLinkService.isAvailable();
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        removeMessage(0, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        c.b(this.hw, i, bdUniqueId);
        c.b(this.hx, i, bdUniqueId);
        c.b(this.hy, i, bdUniqueId);
    }

    public LinkedList<SocketMessage> a(BdUniqueId bdUniqueId) {
        return null;
    }

    @Override // com.baidu.adp.framework.b
    public LinkedList<SocketMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return null;
    }

    public boolean a(int i, BdUniqueId bdUniqueId) {
        return c.a(this.hx, i, bdUniqueId) || c.a(this.hw, i, bdUniqueId) || c.a(this.hy, i, bdUniqueId);
    }

    public long bL() {
        return this.hC;
    }

    public int bM() {
        return BdAsyncTask.getTaskNum(d.bm());
    }

    public int O(int i) {
        return BdAsyncTask.getTaskNum(String.valueOf(i), d.bm());
    }

    public b bN() {
        return this.hB;
    }
}
