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
import com.baidu.adp.lib.util.l;
import com.baidu.adp.lib.webSocket.k;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.framework.client.a<SocketMessage, SocketMessageTask> implements com.baidu.adp.framework.client.socket.link.a {
    private d.a oh;
    private final LinkedList<e> oi;
    private final LinkedList<e> oj;
    private final LinkedList<e> ol;
    private com.baidu.adp.framework.client.socket.link.a om;
    private boolean oo;
    private b oq;
    private long or;
    private int ot;

    public g(MessageManager messageManager) {
        super(messageManager);
        this.oh = null;
        this.oi = new LinkedList<>();
        this.oj = new LinkedList<>();
        this.ol = new LinkedList<>();
        this.om = null;
        this.oo = true;
        this.oq = null;
        this.or = 0L;
        this.ot = 0;
        BdSocketLinkService.setConnStateCallBack(this);
        this.oh = new d.a() { // from class: com.baidu.adp.framework.client.socket.g.1
            @Override // com.baidu.adp.framework.client.socket.d.a
            public void a(d.b bVar) {
                g.this.b(bVar);
            }
        };
    }

    public boolean a(SocketMessage socketMessage) {
        if (socketMessage != null && (socketMessage instanceof a)) {
            a aVar = (a) socketMessage;
            if (c.a(this.oj, aVar, socketMessage.getCmd()) || c.a(this.oi, aVar, socketMessage.getCmd()) || c.a(this.ol, aVar, socketMessage.getCmd())) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b
    public void a(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        l.hw();
        if (socketMessage != null && socketMessageTask != null) {
            if (a(socketMessage, socketMessageTask.dC())) {
                i.a("queue", socketMessage, 0, "sendMessage", h.oS, "duplicate message be removed");
                return;
            }
            e eVar = new e(socketMessage, socketMessageTask, this);
            if (BdSocketLinkService.hasAbsoluteClose()) {
                i.a("queue", socketMessage, 0, "sendMessage", h.pd, "user manual close socket");
                eVar.M(h.pd);
            } else if (!BdSocketLinkService.isAvailable()) {
                i.a("queue", socketMessage, 0, "sendMessage", h.oR, "isManualBlock message be removed");
                eVar.M(h.oR);
            } else {
                i.a("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                c.a(eVar, this.oj);
                cR();
            }
        }
    }

    private boolean a(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        if (socketMessage != null) {
            int cmd = socketMessage.getCmd();
            switch (dupLicateMode) {
                case REMOVE_ALL:
                    c.c(this.oj, cmd);
                    c.c(this.oi, cmd);
                    c.c(this.ol, cmd);
                    break;
                case REMOVE_WAITING:
                    c.c(this.oj, cmd);
                    break;
                case REMOVE_ME:
                    if (c.b(this.oj, cmd) || c.b(this.oi, cmd) || c.b(this.ol, cmd)) {
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
            if (bVar.nT != null) {
                a(bVar.nT, h.oz, null);
                return;
            }
            SocketResponsedMessage socketResponsedMessage = bVar.nS;
            if (socketResponsedMessage != null) {
                i.a("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
                b(socketResponsedMessage);
            }
        }
    }

    public void b(e eVar) {
        if (eVar != null && eVar.cL() && eVar.cO() < eVar.cv()) {
            c.a(this.oi, this.ol, eVar);
            if (this.oq != null) {
                this.oq.c(true, "timeout seq = " + eVar.cK());
            }
            i.a("queue", eVar.cH(), eVar.cK(), "onSendTimeOut", h.oV, String.valueOf(eVar.cO()));
            return;
        }
        e(eVar);
        a(eVar, h.oM, null);
        cR();
    }

    public void a(int i, e eVar) {
        int i2;
        if (i == 2) {
            if (eVar.cF() != null) {
                i2 = eVar.cF().getErrorCode();
            } else {
                i2 = h.oI;
            }
        } else {
            i2 = h.oN;
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
                eVar.cP();
                c.a(this.oj, this.oi, eVar);
                return;
            }
            c.b(eVar, this.oj);
        }
    }

    protected void a(e eVar, int i, String str) {
        SocketResponsedMessage socketResponsedMessage = null;
        if (eVar != null && eVar.cH() != null) {
            int cmd = eVar.cH().getCmd();
            int cK = eVar.cK();
            i.a("queue", eVar.cH(), cK, "onMessageSendFail", i, str + " retryTime-" + eVar.cO());
            SocketMessageTask cI = eVar != null ? eVar.cI() : null;
            SocketMessageTask socketMessageTask = cI == null ? (SocketMessageTask) this.nC.findTask(cmd) : cI;
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
                this.nC.dispatchResponsedMessage(socketResponsedMessage);
            }
        }
    }

    private void cR() {
        e d = c.d(this.oj);
        if (d != null) {
            if (BdSocketLinkService.isClose()) {
                i.a("queue", d.cH(), 0, "sendNext", h.oT, "");
                BdSocketLinkService.startService(false, "send message");
            } else if (!this.oo || d.getPriority() <= -3) {
                BdSocketLinkService.sendMessage(d);
            }
        }
    }

    private void b(SocketResponsedMessage socketResponsedMessage) {
        this.nC.dispatchResponsedMessage(socketResponsedMessage);
    }

    private void e(e eVar) {
        if (eVar != null) {
            eVar.cB();
            c.b(eVar, this.oi);
            c.b(eVar, this.oj);
            c.b(eVar, this.ol);
        }
    }

    private void h(LinkedList<e> linkedList) {
        while (true) {
            e e = c.e(linkedList);
            if (e != null) {
                e.cB();
                a(e, h.oO, null);
            } else {
                return;
            }
        }
    }

    public void cS() {
        h(this.oi);
        h(this.oj);
        h(this.ol);
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public boolean d(int i, String str) {
        if (this.om != null) {
            this.om.d(i, str);
        }
        if (this.oq != null) {
            this.oq.cs();
        }
        if (!l.hy() || c.f(this.ol) || c.f(this.oj) || c.f(this.oi) || !BdSocketLinkService.isAvailable()) {
            cS();
            return false;
        }
        c.g(this.oi);
        c.a(this.oj, this.ol);
        c.a(this.oj, this.oi);
        while (true) {
            e c = c.c(this.oj);
            if (c == null) {
                break;
            }
            c.cB();
            a(c, h.oO, null);
        }
        if (c.b(this.oj) > 0) {
            i.a("queue", 0, 0, "onClose", h.oW, "have retry message, MessageQueue:reconnect");
            BdSocketLinkService.startService(false, "have retry message");
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void d(Map<String, String> map) {
        f.cQ().c(map);
        if (this.oq != null) {
            this.oq.ct();
        }
        this.oo = true;
        i.a("queue", 0, 0, "onConnected", h.pa, "Queue blocked");
        if (this.om != null) {
            this.om.d(map);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void a(k.a aVar) {
        byte[] bArr;
        if (aVar != null && (bArr = aVar.zX) != null) {
            this.or = System.currentTimeMillis();
            try {
                com.baidu.adp.framework.client.socket.coder.c e = com.baidu.adp.framework.client.socket.coder.b.dj().e(bArr);
                this.ot = 0;
                int de = e.pB.de();
                int dg = e.pB.dg();
                i.a("queue", de, dg, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
                e n = n(de, dg);
                if (n != null) {
                    n.od = aVar.od;
                    n.oe = aVar.oe;
                }
                if (this.oq != null) {
                    if (e.pB.de() == this.oq.getCmd() && c.a(this.oj, this.ol)) {
                        cR();
                    }
                    this.oq.ct();
                }
                if (dg == 0 || (n != null && n.getCmd() == de)) {
                    new d(e, n, this.oh, dg).execute(new String[0]);
                } else if (n != null) {
                    a(n, h.pe, null);
                }
                if (this.om != null) {
                    this.om.a(aVar);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2000986));
            } catch (CoderException e2) {
                int maxAlertCount = com.baidu.adp.lib.stats.switchs.a.gz().getMaxAlertCount("alert_protobuf", 2);
                int i = this.ot + 1;
                this.ot = i;
                if (i >= maxAlertCount) {
                    BdStatisticsManager.getInstance().alert("alert_protobuf", "protbuf");
                }
                i.a("queue", 0, 0, "onBinaryMesssage", h.oJ, "onBinaryMesssage decodeHeader error");
            }
        }
    }

    private e n(int i, int i2) {
        e eVar = null;
        if (i2 != 0) {
            e a = c.a(i2, this.oi);
            if (a == null && (a = c.a(i2, this.ol)) == null) {
                eVar = c.a(i2, this.oj);
                if (eVar == null) {
                    i.a("queue", i, i2, "findSenderData", h.oY, "original message removed , responsedMessage not dispatchMessage");
                }
            } else {
                eVar = a;
            }
            i.a("queue", i, i2, "findSenderData", h.oX, "received ack message");
        }
        return eVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
        cR();
        if (this.om != null) {
            this.om.a(cVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void C(String str) {
        if (this.om != null) {
            this.om.C(str);
        }
    }

    public void a(com.baidu.adp.framework.client.socket.link.a aVar) {
        this.om = aVar;
    }

    public void cT() {
        boolean z = this.oo;
        this.oo = false;
        i.a("queue", 0, 0, "unBlockMessageQueue", h.oU, "Queue block has release");
        if (z) {
            cR();
        }
    }

    public void a(b bVar) {
        this.oq = bVar;
    }

    public boolean isValid() {
        return BdSocketLinkService.isOpen() && !this.oo && BdSocketLinkService.isAvailable();
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        removeMessage(0, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        c.b(this.oi, i, bdUniqueId);
        c.b(this.oj, i, bdUniqueId);
        c.b(this.ol, i, bdUniqueId);
    }

    public LinkedList<SocketMessage> a(BdUniqueId bdUniqueId) {
        return null;
    }

    @Override // com.baidu.adp.framework.b
    public LinkedList<SocketMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return null;
    }

    public boolean a(int i, BdUniqueId bdUniqueId) {
        return c.a(this.oj, i, bdUniqueId) || c.a(this.oi, i, bdUniqueId) || c.a(this.ol, i, bdUniqueId);
    }

    public long cU() {
        return this.or;
    }

    public int cV() {
        return BdAsyncTask.getTaskNum(d.cu());
    }

    public int N(int i) {
        return BdAsyncTask.getTaskNum(String.valueOf(i), d.cu());
    }

    public b cW() {
        return this.oq;
    }
}
