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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.m;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.framework.client.a<SocketMessage, SocketMessageTask> implements com.baidu.adp.framework.client.socket.link.e {
    private static /* synthetic */ int[] hC;
    private long hA;
    private int hB;
    private d.a ht;
    private final LinkedList<e> hu;
    private final LinkedList<e> hv;
    private final LinkedList<e> hw;
    private com.baidu.adp.framework.client.socket.link.e hx;
    private boolean hy;
    private b hz;

    static /* synthetic */ int[] bO() {
        int[] iArr = hC;
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
            hC = iArr;
        }
        return iArr;
    }

    public h(MessageManager messageManager) {
        super(messageManager);
        this.ht = null;
        this.hu = new LinkedList<>();
        this.hv = new LinkedList<>();
        this.hw = new LinkedList<>();
        this.hx = null;
        this.hy = true;
        this.hz = null;
        this.hA = 0L;
        this.hB = 0;
        BdSocketLinkService.setConnStateCallBack(this);
        this.ht = new i(this);
    }

    public boolean a(SocketMessage socketMessage) {
        if (socketMessage != null && (socketMessage instanceof a)) {
            a aVar = (a) socketMessage;
            if (c.a(this.hv, aVar, socketMessage.getCmd()) || c.a(this.hu, aVar, socketMessage.getCmd()) || c.a(this.hw, aVar, socketMessage.getCmd())) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b
    public void a(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        com.baidu.adp.lib.util.k.gz();
        if (socketMessage != null && socketMessageTask != null) {
            if (a(socketMessage, socketMessageTask.ct())) {
                k.a("queue", socketMessage, 0, "sendMessage", j.hY, "duplicate message be removed");
                return;
            }
            e eVar = new e(socketMessage, socketMessageTask, this);
            if (BdSocketLinkService.hasAbsoluteClose()) {
                k.a("queue", socketMessage, 0, "sendMessage", j.ii, "user manual close socket");
                eVar.O(j.ii);
            } else if (!BdSocketLinkService.isAvailable()) {
                k.a("queue", socketMessage, 0, "sendMessage", j.hX, "isManualBlock message be removed");
                eVar.O(j.hX);
            } else {
                k.a("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                c.a(eVar, this.hv);
                bI();
            }
        }
    }

    private boolean a(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        if (socketMessage != null) {
            int cmd = socketMessage.getCmd();
            switch (bO()[dupLicateMode.ordinal()]) {
                case 2:
                    if (c.b(this.hv, cmd) || c.b(this.hu, cmd) || c.b(this.hw, cmd)) {
                        return true;
                    }
                    break;
                case 3:
                    c.c(this.hv, cmd);
                    break;
                case 4:
                    c.c(this.hv, cmd);
                    c.c(this.hu, cmd);
                    c.c(this.hw, cmd);
                    break;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(d.b bVar) {
        if (bVar != null) {
            if (bVar.hf != null) {
                a(bVar.hf, j.hH, null);
                return;
            }
            SocketResponsedMessage socketResponsedMessage = bVar.hd;
            if (socketResponsedMessage != null) {
                k.a("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
                b(socketResponsedMessage);
            }
        }
    }

    public void b(e eVar) {
        if (eVar != null && eVar.canRetry() && eVar.bF() < eVar.bn()) {
            c.a(this.hu, this.hw, eVar);
            if (this.hz != null) {
                this.hz.b(true, "timeout seq = " + eVar.bC());
            }
            k.a("queue", eVar.bz(), eVar.bC(), "onSendTimeOut", j.ib, String.valueOf(eVar.bF()));
            return;
        }
        e(eVar);
        a(eVar, j.hS, null);
        bI();
    }

    public void a(int i, e eVar) {
        int i2;
        if (i == 2) {
            if (eVar.bx() != null) {
                i2 = eVar.bx().getErrorCode();
            } else {
                i2 = j.hO;
            }
        } else {
            i2 = j.hT;
        }
        String Q = j.Q(i2);
        e(eVar);
        a(eVar, i2, Q);
    }

    public void c(e eVar) {
    }

    public void d(e eVar) {
        if (eVar != null) {
            if (eVar.by()) {
                eVar.bG();
                c.a(this.hv, this.hu, eVar);
                return;
            }
            c.b(eVar, this.hv);
        }
    }

    protected void a(e eVar, int i, String str) {
        SocketResponsedMessage socketResponsedMessage = null;
        if (eVar != null && eVar.bz() != null) {
            int cmd = eVar.bz().getCmd();
            int bC = eVar.bC();
            k.a("queue", eVar.bz(), bC, "onMessageSendFail", i, String.valueOf(str) + " retryTime-" + eVar.bF());
            SocketMessageTask bA = eVar != null ? eVar.bA() : null;
            SocketMessageTask socketMessageTask = bA == null ? (SocketMessageTask) this.gN.findTask(cmd) : bA;
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
                socketResponsedMessage.setOrginalMessage(eVar.bz());
                k.a("queue", eVar.bz(), bC, "onMessageSendFail", i, "onMessageSendFail class = " + socketResponsedMessage.getClass().getName());
                this.gN.dispatchResponsedMessage(socketResponsedMessage);
            }
        }
    }

    private void bI() {
        e c = c.c(this.hv);
        if (c != null) {
            if (BdSocketLinkService.isClose()) {
                k.a("queue", c.bz(), 0, "sendNext", j.hZ, "");
                BdSocketLinkService.startService(false, "send message");
            } else if (!this.hy || c.getPriority() <= -3) {
                BdSocketLinkService.sendMessage(c);
            }
        }
    }

    private void b(SocketResponsedMessage socketResponsedMessage) {
        this.gN.dispatchResponsedMessage(socketResponsedMessage);
    }

    private void e(e eVar) {
        if (eVar != null) {
            eVar.bt();
            c.b(eVar, this.hu);
            c.b(eVar, this.hv);
            c.b(eVar, this.hw);
        }
    }

    private void g(LinkedList<e> linkedList) {
        while (true) {
            e d = c.d(linkedList);
            if (d != null) {
                d.bt();
                a(d, j.hU, null);
            } else {
                return;
            }
        }
    }

    public void bJ() {
        g(this.hu);
        g(this.hv);
        g(this.hw);
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public boolean c(int i, String str) {
        if (this.hx != null) {
            this.hx.c(i, str);
        }
        if (this.hz != null) {
            this.hz.bk();
        }
        if (!com.baidu.adp.lib.util.k.gB() || c.e(this.hw) || c.e(this.hv) || c.e(this.hu) || !BdSocketLinkService.isAvailable()) {
            bJ();
            return false;
        }
        c.f(this.hu);
        c.a(this.hv, this.hw);
        c.a(this.hv, this.hu);
        while (true) {
            e b = c.b(this.hv);
            if (b == null) {
                break;
            }
            b.bt();
            a(b, j.hU, null);
        }
        if (c.a(this.hv) > 0) {
            k.a("queue", 0, 0, "onClose", j.ic, "have retry message, MessageQueue:reconnect");
            BdSocketLinkService.startService(false, "have retry message");
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void d(Map<String, String> map) {
        g.bH().c(map);
        if (this.hz != null) {
            this.hz.bl();
        }
        this.hy = true;
        k.a("queue", 0, 0, "onConnected", j.ih, "Queue blocked");
        if (this.hx != null) {
            this.hx.d(map);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void a(m.a aVar) {
        byte[] bArr;
        if (aVar != null && (bArr = aVar.tG) != null) {
            this.hA = System.currentTimeMillis();
            try {
                com.baidu.adp.framework.client.socket.coder.c i = com.baidu.adp.framework.client.socket.coder.b.ca().i(bArr);
                this.hB = 0;
                int bW = i.iD.bW();
                int bY = i.iD.bY();
                k.a("queue", bW, bY, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
                e g = g(bW, bY);
                if (g != null) {
                    g.hp = aVar.hp;
                    g.hq = aVar.hq;
                }
                if (this.hz != null) {
                    if (i.iD.bW() == this.hz.getCmd() && c.a(this.hv, this.hw)) {
                        bI();
                    }
                    this.hz.bl();
                }
                if (bY == 0 || (g != null && g.getCmd() == bW)) {
                    new d(i, g, this.ht, bY).execute(new String[0]);
                } else if (g != null) {
                    a(g, j.ij, null);
                }
                if (this.hx != null) {
                    this.hx.a(aVar);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2000986));
            } catch (CoderException e) {
                int maxAlertCount = com.baidu.adp.lib.stats.switchs.a.fB().getMaxAlertCount("alert_protobuf", 2);
                int i2 = this.hB + 1;
                this.hB = i2;
                if (i2 >= maxAlertCount) {
                    com.baidu.adp.lib.stats.a.eG().p("alert_protobuf", "protbuf");
                }
                k.a("queue", 0, 0, "onBinaryMesssage", j.hP, "onBinaryMesssage decodeHeader error");
            }
        }
    }

    private e g(int i, int i2) {
        e eVar = null;
        if (i2 != 0) {
            e a = c.a(i2, this.hu);
            if (a == null && (a = c.a(i2, this.hw)) == null) {
                eVar = c.a(i2, this.hv);
                if (eVar == null) {
                    k.a("queue", i, i2, "findSenderData", j.f0if, "original message removed , responsedMessage not dispatchMessage");
                }
            } else {
                eVar = a;
            }
            k.a("queue", i, i2, "findSenderData", j.ie, "received ack message");
        }
        return eVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
        bI();
        if (this.hx != null) {
            this.hx.a(cVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void B(String str) {
        if (this.hx != null) {
            this.hx.B(str);
        }
    }

    public void a(com.baidu.adp.framework.client.socket.link.e eVar) {
        this.hx = eVar;
    }

    public void bK() {
        boolean z = this.hy;
        this.hy = false;
        k.a("queue", 0, 0, "unBlockMessageQueue", j.ia, "Queue block has release");
        if (z) {
            bI();
        }
    }

    public void a(b bVar) {
        this.hz = bVar;
    }

    public boolean isValid() {
        return BdSocketLinkService.isOpen() && !this.hy && BdSocketLinkService.isAvailable();
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        removeMessage(0, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        c.b(this.hu, i, bdUniqueId);
        c.b(this.hv, i, bdUniqueId);
        c.b(this.hw, i, bdUniqueId);
    }

    public LinkedList<SocketMessage> a(BdUniqueId bdUniqueId) {
        return null;
    }

    @Override // com.baidu.adp.framework.b
    public LinkedList<SocketMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return null;
    }

    public boolean a(int i, BdUniqueId bdUniqueId) {
        return c.a(this.hv, i, bdUniqueId) || c.a(this.hu, i, bdUniqueId) || c.a(this.hw, i, bdUniqueId);
    }

    public long bL() {
        return this.hA;
    }

    public int bM() {
        return BdAsyncTask.getTaskNum(d.bm());
    }

    public int P(int i) {
        return BdAsyncTask.getTaskNum(String.valueOf(i), d.bm());
    }

    public b bN() {
        return this.hz;
    }
}
