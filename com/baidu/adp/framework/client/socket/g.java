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
    private d.a nc;
    private final LinkedList<e> nd;
    private final LinkedList<e> ne;
    private final LinkedList<e> nf;
    private com.baidu.adp.framework.client.socket.link.a ng;
    private boolean nh;
    private b ni;
    private long nj;
    private int nk;

    public g(MessageManager messageManager) {
        super(messageManager);
        this.nc = null;
        this.nd = new LinkedList<>();
        this.ne = new LinkedList<>();
        this.nf = new LinkedList<>();
        this.ng = null;
        this.nh = true;
        this.ni = null;
        this.nj = 0L;
        this.nk = 0;
        BdSocketLinkService.setConnStateCallBack(this);
        this.nc = new d.a() { // from class: com.baidu.adp.framework.client.socket.g.1
            @Override // com.baidu.adp.framework.client.socket.d.a
            public void a(d.b bVar) {
                g.this.b(bVar);
            }
        };
    }

    public boolean a(SocketMessage socketMessage) {
        if (socketMessage != null && (socketMessage instanceof a)) {
            a aVar = (a) socketMessage;
            if (c.a(this.ne, aVar, socketMessage.getCmd()) || c.a(this.nd, aVar, socketMessage.getCmd()) || c.a(this.nf, aVar, socketMessage.getCmd())) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b
    public void a(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        l.he();
        if (socketMessage != null && socketMessageTask != null) {
            if (a(socketMessage, socketMessageTask.dk())) {
                i.a("queue", socketMessage, 0, "sendMessage", h.nK, "duplicate message be removed");
                return;
            }
            e eVar = new e(socketMessage, socketMessageTask, this);
            if (BdSocketLinkService.hasAbsoluteClose()) {
                i.a("queue", socketMessage, 0, "sendMessage", h.nT, "user manual close socket");
                eVar.F(h.nT);
            } else if (!BdSocketLinkService.isAvailable()) {
                i.a("queue", socketMessage, 0, "sendMessage", h.nJ, "isManualBlock message be removed");
                eVar.F(h.nJ);
            } else {
                i.a("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                c.a(eVar, this.ne);
                cz();
            }
        }
    }

    private boolean a(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        if (socketMessage != null) {
            int cmd = socketMessage.getCmd();
            switch (dupLicateMode) {
                case REMOVE_ALL:
                    c.c(this.ne, cmd);
                    c.c(this.nd, cmd);
                    c.c(this.nf, cmd);
                    break;
                case REMOVE_WAITING:
                    c.c(this.ne, cmd);
                    break;
                case REMOVE_ME:
                    if (c.b(this.ne, cmd) || c.b(this.nd, cmd) || c.b(this.nf, cmd)) {
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
            if (bVar.mM != null) {
                a(bVar.mM, h.nr, null);
                return;
            }
            SocketResponsedMessage socketResponsedMessage = bVar.mL;
            if (socketResponsedMessage != null) {
                i.a("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
                b(socketResponsedMessage);
            }
        }
    }

    public void b(e eVar) {
        if (eVar != null && eVar.ct() && eVar.cw() < eVar.ce()) {
            c.a(this.nd, this.nf, eVar);
            if (this.ni != null) {
                this.ni.c(true, "timeout seq = " + eVar.getSequenceId());
            }
            i.a("queue", eVar.cq(), eVar.getSequenceId(), "onSendTimeOut", h.nN, String.valueOf(eVar.cw()));
            return;
        }
        e(eVar);
        a(eVar, h.nE, null);
        cz();
    }

    public void a(int i, e eVar) {
        int i2;
        if (i == 2) {
            if (eVar.co() != null) {
                i2 = eVar.co().getErrorCode();
            } else {
                i2 = h.nA;
            }
        } else {
            i2 = h.nF;
        }
        String H = h.H(i2);
        e(eVar);
        a(eVar, i2, H);
    }

    public void c(e eVar) {
    }

    public void d(e eVar) {
        if (eVar != null) {
            if (eVar.cp()) {
                eVar.cx();
                c.a(this.ne, this.nd, eVar);
                return;
            }
            c.b(eVar, this.ne);
        }
    }

    protected void a(e eVar, int i, String str) {
        SocketResponsedMessage socketResponsedMessage = null;
        if (eVar != null && eVar.cq() != null) {
            int cmd = eVar.cq().getCmd();
            int sequenceId = eVar.getSequenceId();
            i.a("queue", eVar.cq(), sequenceId, "onMessageSendFail", i, str + " retryTime-" + eVar.cw());
            SocketMessageTask cr = eVar != null ? eVar.cr() : null;
            SocketMessageTask socketMessageTask = cr == null ? (SocketMessageTask) this.mt.findTask(cmd) : cr;
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
                    socketResponsedMessage.setErrorString(h.H(i));
                } else {
                    socketResponsedMessage.setErrorString(str);
                }
                socketResponsedMessage.setOrginalMessage(eVar.cq());
                i.a("queue", eVar.cq(), sequenceId, "onMessageSendFail", i, "onMessageSendFail class = " + socketResponsedMessage.getClass().getName());
                this.mt.dispatchResponsedMessage(socketResponsedMessage);
            }
        }
    }

    private void cz() {
        e e = c.e(this.ne);
        if (e != null) {
            if (BdSocketLinkService.isClose()) {
                i.a("queue", e.cq(), 0, "sendNext", h.nL, "");
                BdSocketLinkService.startService(false, "send message");
            } else if (!this.nh || e.getPriority() <= -3) {
                BdSocketLinkService.sendMessage(e);
            }
        }
    }

    private void b(SocketResponsedMessage socketResponsedMessage) {
        this.mt.dispatchResponsedMessage(socketResponsedMessage);
    }

    private void e(e eVar) {
        if (eVar != null) {
            eVar.ck();
            c.b(eVar, this.nd);
            c.b(eVar, this.ne);
            c.b(eVar, this.nf);
        }
    }

    private void i(LinkedList<e> linkedList) {
        while (true) {
            e f = c.f(linkedList);
            if (f != null) {
                f.ck();
                a(f, h.nG, null);
            } else {
                return;
            }
        }
    }

    public void cA() {
        i(this.nd);
        i(this.ne);
        i(this.nf);
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public boolean d(int i, String str) {
        if (this.ng != null) {
            this.ng.d(i, str);
        }
        if (this.ni != null) {
            this.ni.cb();
        }
        if (!l.hg() || c.g(this.nf) || c.g(this.ne) || c.g(this.nd) || !BdSocketLinkService.isAvailable()) {
            cA();
            return false;
        }
        c.h(this.nd);
        c.a(this.ne, this.nf);
        c.a(this.ne, this.nd);
        while (true) {
            e d = c.d(this.ne);
            if (d == null) {
                break;
            }
            d.ck();
            a(d, h.nG, null);
        }
        if (c.c(this.ne) > 0) {
            i.a("queue", 0, 0, "onClose", h.nO, "have retry message, MessageQueue:reconnect");
            BdSocketLinkService.startService(false, "have retry message");
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void d(Map<String, String> map) {
        f.cy().c(map);
        if (this.ni != null) {
            this.ni.cc();
        }
        this.nh = true;
        i.a("queue", 0, 0, "onConnected", h.nS, "Queue blocked");
        if (this.ng != null) {
            this.ng.d(map);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void a(k.a aVar) {
        byte[] bArr;
        if (aVar != null && (bArr = aVar.yD) != null) {
            this.nj = System.currentTimeMillis();
            try {
                com.baidu.adp.framework.client.socket.coder.c h = com.baidu.adp.framework.client.socket.coder.b.cR().h(bArr);
                this.nk = 0;
                int cM = h.oo.cM();
                int cO = h.oo.cO();
                i.a("queue", cM, cO, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
                e n = n(cM, cO);
                if (n != null) {
                    n.mW = aVar.mW;
                    n.mZ = aVar.mZ;
                }
                if (this.ni != null) {
                    if (h.oo.cM() == this.ni.getCmd() && c.a(this.ne, this.nf)) {
                        cz();
                    }
                    this.ni.cc();
                }
                if (cO == 0 || (n != null && n.getCmd() == cM)) {
                    new d(h, n, this.nc, cO).execute(new String[0]);
                } else if (n != null) {
                    a(n, h.nU, null);
                }
                if (this.ng != null) {
                    this.ng.a(aVar);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2000986));
            } catch (CoderException e) {
                int maxAlertCount = com.baidu.adp.lib.stats.switchs.a.gg().getMaxAlertCount("alert_protobuf", 2);
                int i = this.nk + 1;
                this.nk = i;
                if (i >= maxAlertCount) {
                    BdStatisticsManager.getInstance().alert("alert_protobuf", "protbuf");
                }
                i.a("queue", 0, 0, "onBinaryMesssage", h.nB, "onBinaryMesssage decodeHeader error");
            }
        }
    }

    private e n(int i, int i2) {
        e eVar = null;
        if (i2 != 0) {
            e a = c.a(i2, this.nd);
            if (a == null && (a = c.a(i2, this.nf)) == null) {
                eVar = c.a(i2, this.ne);
                if (eVar == null) {
                    i.a("queue", i, i2, "findSenderData", h.nQ, "original message removed , responsedMessage not dispatchMessage");
                }
            } else {
                eVar = a;
            }
            i.a("queue", i, i2, "findSenderData", h.nP, "received ack message");
        }
        return eVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
        cz();
        if (this.ng != null) {
            this.ng.a(cVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void G(String str) {
        if (this.ng != null) {
            this.ng.G(str);
        }
    }

    public void a(com.baidu.adp.framework.client.socket.link.a aVar) {
        this.ng = aVar;
    }

    public void cB() {
        boolean z = this.nh;
        this.nh = false;
        i.a("queue", 0, 0, "unBlockMessageQueue", h.nM, "Queue block has release");
        if (z) {
            cz();
        }
    }

    public void a(b bVar) {
        this.ni = bVar;
    }

    public boolean isValid() {
        return BdSocketLinkService.isOpen() && !this.nh && BdSocketLinkService.isAvailable();
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        removeMessage(0, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        c.b(this.nd, i, bdUniqueId);
        c.b(this.ne, i, bdUniqueId);
        c.b(this.nf, i, bdUniqueId);
    }

    public LinkedList<SocketMessage> a(BdUniqueId bdUniqueId) {
        return null;
    }

    @Override // com.baidu.adp.framework.b
    public LinkedList<SocketMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return null;
    }

    public boolean a(int i, BdUniqueId bdUniqueId) {
        return c.a(this.ne, i, bdUniqueId) || c.a(this.nd, i, bdUniqueId) || c.a(this.nf, i, bdUniqueId);
    }

    public long cC() {
        return this.nj;
    }

    public int cD() {
        return BdAsyncTask.getTaskNum(d.cd());
    }

    public int G(int i) {
        return BdAsyncTask.getTaskNum(String.valueOf(i), d.cd());
    }

    public b cE() {
        return this.ni;
    }
}
