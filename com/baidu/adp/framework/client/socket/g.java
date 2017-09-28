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
    private d.a og;
    private final LinkedList<e> oh;
    private final LinkedList<e> oi;
    private final LinkedList<e> oj;
    private com.baidu.adp.framework.client.socket.link.a ol;
    private boolean om;
    private b oo;
    private long oq;
    private int or;

    public g(MessageManager messageManager) {
        super(messageManager);
        this.og = null;
        this.oh = new LinkedList<>();
        this.oi = new LinkedList<>();
        this.oj = new LinkedList<>();
        this.ol = null;
        this.om = true;
        this.oo = null;
        this.oq = 0L;
        this.or = 0;
        BdSocketLinkService.setConnStateCallBack(this);
        this.og = new d.a() { // from class: com.baidu.adp.framework.client.socket.g.1
            @Override // com.baidu.adp.framework.client.socket.d.a
            public void a(d.b bVar) {
                g.this.b(bVar);
            }
        };
    }

    public boolean a(SocketMessage socketMessage) {
        if (socketMessage != null && (socketMessage instanceof a)) {
            a aVar = (a) socketMessage;
            if (c.a(this.oi, aVar, socketMessage.getCmd()) || c.a(this.oh, aVar, socketMessage.getCmd()) || c.a(this.oj, aVar, socketMessage.getCmd())) {
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
                i.a("queue", socketMessage, 0, "sendMessage", h.oR, "duplicate message be removed");
                return;
            }
            e eVar = new e(socketMessage, socketMessageTask, this);
            if (BdSocketLinkService.hasAbsoluteClose()) {
                i.a("queue", socketMessage, 0, "sendMessage", h.pa, "user manual close socket");
                eVar.M(h.pa);
            } else if (!BdSocketLinkService.isAvailable()) {
                i.a("queue", socketMessage, 0, "sendMessage", h.oQ, "isManualBlock message be removed");
                eVar.M(h.oQ);
            } else {
                i.a("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                c.a(eVar, this.oi);
                cR();
            }
        }
    }

    private boolean a(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        if (socketMessage != null) {
            int cmd = socketMessage.getCmd();
            switch (dupLicateMode) {
                case REMOVE_ALL:
                    c.c(this.oi, cmd);
                    c.c(this.oh, cmd);
                    c.c(this.oj, cmd);
                    break;
                case REMOVE_WAITING:
                    c.c(this.oi, cmd);
                    break;
                case REMOVE_ME:
                    if (c.b(this.oi, cmd) || c.b(this.oh, cmd) || c.b(this.oj, cmd)) {
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
            if (bVar.nS != null) {
                a(bVar.nS, h.oy, null);
                return;
            }
            SocketResponsedMessage socketResponsedMessage = bVar.nR;
            if (socketResponsedMessage != null) {
                i.a("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
                b(socketResponsedMessage);
            }
        }
    }

    public void b(e eVar) {
        if (eVar != null && eVar.cL() && eVar.cO() < eVar.cv()) {
            c.a(this.oh, this.oj, eVar);
            if (this.oo != null) {
                this.oo.c(true, "timeout seq = " + eVar.cK());
            }
            i.a("queue", eVar.cH(), eVar.cK(), "onSendTimeOut", h.oU, String.valueOf(eVar.cO()));
            return;
        }
        e(eVar);
        a(eVar, h.oL, null);
        cR();
    }

    public void a(int i, e eVar) {
        int i2;
        if (i == 2) {
            if (eVar.cF() != null) {
                i2 = eVar.cF().getErrorCode();
            } else {
                i2 = h.oH;
            }
        } else {
            i2 = h.oM;
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
                c.a(this.oi, this.oh, eVar);
                return;
            }
            c.b(eVar, this.oi);
        }
    }

    protected void a(e eVar, int i, String str) {
        SocketResponsedMessage socketResponsedMessage = null;
        if (eVar != null && eVar.cH() != null) {
            int cmd = eVar.cH().getCmd();
            int cK = eVar.cK();
            i.a("queue", eVar.cH(), cK, "onMessageSendFail", i, str + " retryTime-" + eVar.cO());
            SocketMessageTask cI = eVar != null ? eVar.cI() : null;
            SocketMessageTask socketMessageTask = cI == null ? (SocketMessageTask) this.nB.findTask(cmd) : cI;
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
                this.nB.dispatchResponsedMessage(socketResponsedMessage);
            }
        }
    }

    private void cR() {
        e d = c.d(this.oi);
        if (d != null) {
            if (BdSocketLinkService.isClose()) {
                i.a("queue", d.cH(), 0, "sendNext", h.oS, "");
                BdSocketLinkService.startService(false, "send message");
            } else if (!this.om || d.getPriority() <= -3) {
                BdSocketLinkService.sendMessage(d);
            }
        }
    }

    private void b(SocketResponsedMessage socketResponsedMessage) {
        this.nB.dispatchResponsedMessage(socketResponsedMessage);
    }

    private void e(e eVar) {
        if (eVar != null) {
            eVar.cB();
            c.b(eVar, this.oh);
            c.b(eVar, this.oi);
            c.b(eVar, this.oj);
        }
    }

    private void h(LinkedList<e> linkedList) {
        while (true) {
            e e = c.e(linkedList);
            if (e != null) {
                e.cB();
                a(e, h.oN, null);
            } else {
                return;
            }
        }
    }

    public void cS() {
        h(this.oh);
        h(this.oi);
        h(this.oj);
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public boolean d(int i, String str) {
        if (this.ol != null) {
            this.ol.d(i, str);
        }
        if (this.oo != null) {
            this.oo.cs();
        }
        if (!l.hy() || c.f(this.oj) || c.f(this.oi) || c.f(this.oh) || !BdSocketLinkService.isAvailable()) {
            cS();
            return false;
        }
        c.g(this.oh);
        c.a(this.oi, this.oj);
        c.a(this.oi, this.oh);
        while (true) {
            e c = c.c(this.oi);
            if (c == null) {
                break;
            }
            c.cB();
            a(c, h.oN, null);
        }
        if (c.b(this.oi) > 0) {
            i.a("queue", 0, 0, "onClose", h.oV, "have retry message, MessageQueue:reconnect");
            BdSocketLinkService.startService(false, "have retry message");
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void d(Map<String, String> map) {
        f.cQ().c(map);
        if (this.oo != null) {
            this.oo.ct();
        }
        this.om = true;
        i.a("queue", 0, 0, "onConnected", h.oZ, "Queue blocked");
        if (this.ol != null) {
            this.ol.d(map);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void a(k.a aVar) {
        byte[] bArr;
        if (aVar != null && (bArr = aVar.zW) != null) {
            this.oq = System.currentTimeMillis();
            try {
                com.baidu.adp.framework.client.socket.coder.c e = com.baidu.adp.framework.client.socket.coder.b.dj().e(bArr);
                this.or = 0;
                int de = e.pA.de();
                int dg = e.pA.dg();
                i.a("queue", de, dg, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
                e n = n(de, dg);
                if (n != null) {
                    n.oc = aVar.oc;
                    n.od = aVar.od;
                }
                if (this.oo != null) {
                    if (e.pA.de() == this.oo.getCmd() && c.a(this.oi, this.oj)) {
                        cR();
                    }
                    this.oo.ct();
                }
                if (dg == 0 || (n != null && n.getCmd() == de)) {
                    new d(e, n, this.og, dg).execute(new String[0]);
                } else if (n != null) {
                    a(n, h.pd, null);
                }
                if (this.ol != null) {
                    this.ol.a(aVar);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2000986));
            } catch (CoderException e2) {
                int maxAlertCount = com.baidu.adp.lib.stats.switchs.a.gz().getMaxAlertCount("alert_protobuf", 2);
                int i = this.or + 1;
                this.or = i;
                if (i >= maxAlertCount) {
                    BdStatisticsManager.getInstance().alert("alert_protobuf", "protbuf");
                }
                i.a("queue", 0, 0, "onBinaryMesssage", h.oI, "onBinaryMesssage decodeHeader error");
            }
        }
    }

    private e n(int i, int i2) {
        e eVar = null;
        if (i2 != 0) {
            e a = c.a(i2, this.oh);
            if (a == null && (a = c.a(i2, this.oj)) == null) {
                eVar = c.a(i2, this.oi);
                if (eVar == null) {
                    i.a("queue", i, i2, "findSenderData", h.oX, "original message removed , responsedMessage not dispatchMessage");
                }
            } else {
                eVar = a;
            }
            i.a("queue", i, i2, "findSenderData", h.oW, "received ack message");
        }
        return eVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
        cR();
        if (this.ol != null) {
            this.ol.a(cVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void C(String str) {
        if (this.ol != null) {
            this.ol.C(str);
        }
    }

    public void a(com.baidu.adp.framework.client.socket.link.a aVar) {
        this.ol = aVar;
    }

    public void cT() {
        boolean z = this.om;
        this.om = false;
        i.a("queue", 0, 0, "unBlockMessageQueue", h.oT, "Queue block has release");
        if (z) {
            cR();
        }
    }

    public void a(b bVar) {
        this.oo = bVar;
    }

    public boolean isValid() {
        return BdSocketLinkService.isOpen() && !this.om && BdSocketLinkService.isAvailable();
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        removeMessage(0, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        c.b(this.oh, i, bdUniqueId);
        c.b(this.oi, i, bdUniqueId);
        c.b(this.oj, i, bdUniqueId);
    }

    public LinkedList<SocketMessage> a(BdUniqueId bdUniqueId) {
        return null;
    }

    @Override // com.baidu.adp.framework.b
    public LinkedList<SocketMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return null;
    }

    public boolean a(int i, BdUniqueId bdUniqueId) {
        return c.a(this.oi, i, bdUniqueId) || c.a(this.oh, i, bdUniqueId) || c.a(this.oj, i, bdUniqueId);
    }

    public long cU() {
        return this.oq;
    }

    public int cV() {
        return BdAsyncTask.getTaskNum(d.cu());
    }

    public int N(int i) {
        return BdAsyncTask.getTaskNum(String.valueOf(i), d.cu());
    }

    public b cW() {
        return this.oo;
    }
}
