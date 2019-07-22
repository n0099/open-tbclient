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
    private d.a uh;
    private final LinkedList<e> ui;
    private final LinkedList<e> uj;
    private final LinkedList<e> uk;
    private com.baidu.adp.framework.client.socket.link.a ul;
    private boolean um;
    private b uo;
    private long uq;
    private int ur;

    public g(MessageManager messageManager) {
        super(messageManager);
        this.uh = null;
        this.ui = new LinkedList<>();
        this.uj = new LinkedList<>();
        this.uk = new LinkedList<>();
        this.ul = null;
        this.um = true;
        this.uo = null;
        this.uq = 0L;
        this.ur = 0;
        BdSocketLinkService.setConnStateCallBack(this);
        this.uh = new d.a() { // from class: com.baidu.adp.framework.client.socket.g.1
            @Override // com.baidu.adp.framework.client.socket.d.a
            public void a(d.b bVar) {
                g.this.b(bVar);
            }
        };
    }

    public boolean a(SocketMessage socketMessage) {
        if (socketMessage != null && (socketMessage instanceof a)) {
            a aVar = (a) socketMessage;
            if (c.a(this.uj, aVar, socketMessage.getCmd()) || c.a(this.ui, aVar, socketMessage.getCmd()) || c.a(this.uk, aVar, socketMessage.getCmd())) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b
    public void a(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        l.kr();
        if (socketMessage != null && socketMessageTask != null) {
            if (a(socketMessage, socketMessageTask.gx())) {
                i.a("queue", socketMessage, 0, "sendMessage", h.uQ, "duplicate message be removed");
                return;
            }
            e eVar = new e(socketMessage, socketMessageTask, this);
            if (BdSocketLinkService.hasAbsoluteClose()) {
                i.a("queue", socketMessage, 0, "sendMessage", h.uZ, "user manual close socket");
                eVar.G(h.uZ);
            } else if (!BdSocketLinkService.isAvailable()) {
                i.a("queue", socketMessage, 0, "sendMessage", h.uP, "isManualBlock message be removed");
                eVar.G(h.uP);
            } else {
                i.a("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                c.a(eVar, this.uj);
                fL();
            }
        }
    }

    private boolean a(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        if (socketMessage != null) {
            int cmd = socketMessage.getCmd();
            switch (dupLicateMode) {
                case REMOVE_ALL:
                    c.c(this.uj, cmd);
                    c.c(this.ui, cmd);
                    c.c(this.uk, cmd);
                    break;
                case REMOVE_WAITING:
                    c.c(this.uj, cmd);
                    break;
                case REMOVE_ME:
                    if (c.b(this.uj, cmd) || c.b(this.ui, cmd) || c.b(this.uk, cmd)) {
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
            if (bVar.tT != null) {
                a(bVar.tT, h.ux, null);
                return;
            }
            SocketResponsedMessage socketResponsedMessage = bVar.tS;
            if (socketResponsedMessage != null) {
                i.a("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
                b(socketResponsedMessage);
            }
        }
    }

    public void b(e eVar) {
        if (eVar != null && eVar.fF() && eVar.fI() < eVar.fo()) {
            c.a(this.ui, this.uk, eVar);
            if (this.uo != null) {
                this.uo.b(true, "timeout seq = " + eVar.fE());
            }
            i.a("queue", eVar.fB(), eVar.fE(), "onSendTimeOut", h.uT, String.valueOf(eVar.fI()));
            return;
        }
        e(eVar);
        a(eVar, h.uK, null);
        fL();
    }

    public void a(int i, e eVar) {
        int i2;
        if (i == 2) {
            if (eVar.fz() != null) {
                i2 = eVar.fz().getErrorCode();
            } else {
                i2 = h.uG;
            }
        } else {
            i2 = h.uL;
        }
        String I = h.I(i2);
        e(eVar);
        a(eVar, i2, I);
    }

    public void c(e eVar) {
    }

    public void d(e eVar) {
        if (eVar != null) {
            if (eVar.fA()) {
                eVar.fJ();
                c.a(this.uj, this.ui, eVar);
                return;
            }
            c.b(eVar, this.uj);
        }
    }

    protected void a(e eVar, int i, String str) {
        SocketResponsedMessage socketResponsedMessage = null;
        if (eVar != null && eVar.fB() != null) {
            int cmd = eVar.fB().getCmd();
            int fE = eVar.fE();
            i.a("queue", eVar.fB(), fE, "onMessageSendFail", i, str + " retryTime-" + eVar.fI());
            SocketMessageTask fC = eVar != null ? eVar.fC() : null;
            SocketMessageTask socketMessageTask = fC == null ? (SocketMessageTask) this.tC.findTask(cmd) : fC;
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
                    socketResponsedMessage.setErrorString(h.I(i));
                } else {
                    socketResponsedMessage.setErrorString(str);
                }
                socketResponsedMessage.setOrginalMessage(eVar.fB());
                i.a("queue", eVar.fB(), fE, "onMessageSendFail", i, "onMessageSendFail class = " + socketResponsedMessage.getClass().getName());
                this.tC.dispatchResponsedMessage(socketResponsedMessage);
            }
        }
    }

    private void fL() {
        e e = c.e(this.uj);
        if (e != null) {
            if (BdSocketLinkService.isClose()) {
                i.a("queue", e.fB(), 0, "sendNext", h.uR, "");
                BdSocketLinkService.startService(false, "send message");
            } else if (!this.um || e.getPriority() <= -3) {
                BdSocketLinkService.sendMessage(e);
            }
        }
    }

    private void b(SocketResponsedMessage socketResponsedMessage) {
        this.tC.dispatchResponsedMessage(socketResponsedMessage);
    }

    private void e(e eVar) {
        if (eVar != null) {
            eVar.fv();
            c.b(eVar, this.ui);
            c.b(eVar, this.uj);
            c.b(eVar, this.uk);
        }
    }

    private void i(LinkedList<e> linkedList) {
        while (true) {
            e f = c.f(linkedList);
            if (f != null) {
                f.fv();
                a(f, h.uM, null);
            } else {
                return;
            }
        }
    }

    public void fM() {
        i(this.ui);
        i(this.uj);
        i(this.uk);
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public boolean e(int i, String str) {
        if (this.ul != null) {
            this.ul.e(i, str);
        }
        if (this.uo != null) {
            this.uo.fl();
        }
        if (!l.kt() || c.g(this.uk) || c.g(this.uj) || c.g(this.ui) || !BdSocketLinkService.isAvailable()) {
            fM();
            return false;
        }
        c.h(this.ui);
        c.a(this.uj, this.uk);
        c.a(this.uj, this.ui);
        while (true) {
            e d = c.d(this.uj);
            if (d == null) {
                break;
            }
            d.fv();
            a(d, h.uM, null);
        }
        if (c.c(this.uj) > 0) {
            i.a("queue", 0, 0, "onClose", h.uU, "have retry message, MessageQueue:reconnect");
            BdSocketLinkService.startService(false, "have retry message");
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void h(Map<String, String> map) {
        f.fK().g(map);
        if (this.uo != null) {
            this.uo.fm();
        }
        this.um = true;
        i.a("queue", 0, 0, "onConnected", h.uY, "Queue blocked");
        if (this.ul != null) {
            this.ul.h(map);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void a(k.a aVar) {
        byte[] bArr;
        if (aVar != null && (bArr = aVar.FH) != null) {
            this.uq = System.currentTimeMillis();
            try {
                com.baidu.adp.framework.client.socket.coder.c g = com.baidu.adp.framework.client.socket.coder.b.gd().g(bArr);
                this.ur = 0;
                int command = g.vs.getCommand();
                int fZ = g.vs.fZ();
                i.a("queue", command, fZ, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
                e p = p(command, fZ);
                if (p != null) {
                    p.ud = aVar.ud;
                    p.ue = aVar.ue;
                }
                if (this.uo != null) {
                    if (g.vs.getCommand() == this.uo.getCmd() && c.a(this.uj, this.uk)) {
                        fL();
                    }
                    this.uo.fm();
                }
                if (fZ == 0 || (p != null && p.getCmd() == command)) {
                    new d(g, p, this.uh, fZ).execute(new String[0]);
                } else if (p != null) {
                    a(p, h.va, null);
                }
                if (this.ul != null) {
                    this.ul.a(aVar);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2000986));
            } catch (CoderException e) {
                int maxAlertCount = com.baidu.adp.lib.stats.switchs.a.jt().getMaxAlertCount("alert_protobuf", 2);
                int i = this.ur + 1;
                this.ur = i;
                if (i >= maxAlertCount) {
                    BdStatisticsManager.getInstance().alert("alert_protobuf", "protbuf");
                }
                i.a("queue", 0, 0, "onBinaryMesssage", h.uH, "onBinaryMesssage decodeHeader error");
            }
        }
    }

    private e p(int i, int i2) {
        e eVar = null;
        if (i2 != 0) {
            e a = c.a(i2, this.ui);
            if (a == null && (a = c.a(i2, this.uk)) == null) {
                eVar = c.a(i2, this.uj);
                if (eVar == null) {
                    i.a("queue", i, i2, "findSenderData", h.uW, "original message removed , responsedMessage not dispatchMessage");
                }
            } else {
                eVar = a;
            }
            i.a("queue", i, i2, "findSenderData", h.uV, "received ack message");
        }
        return eVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
        fL();
        if (this.ul != null) {
            this.ul.a(cVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void S(String str) {
        if (this.ul != null) {
            this.ul.S(str);
        }
    }

    public void a(com.baidu.adp.framework.client.socket.link.a aVar) {
        this.ul = aVar;
    }

    public void fN() {
        boolean z = this.um;
        this.um = false;
        i.a("queue", 0, 0, "unBlockMessageQueue", h.uS, "Queue block has release");
        if (z) {
            fL();
        }
    }

    public void a(b bVar) {
        this.uo = bVar;
    }

    public boolean isValid() {
        return BdSocketLinkService.isOpen() && !this.um && BdSocketLinkService.isAvailable();
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        removeMessage(0, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        c.b(this.ui, i, bdUniqueId);
        c.b(this.uj, i, bdUniqueId);
        c.b(this.uk, i, bdUniqueId);
    }

    public LinkedList<SocketMessage> a(BdUniqueId bdUniqueId) {
        return null;
    }

    @Override // com.baidu.adp.framework.b
    public LinkedList<SocketMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return null;
    }

    public boolean a(int i, BdUniqueId bdUniqueId) {
        return c.a(this.uj, i, bdUniqueId) || c.a(this.ui, i, bdUniqueId) || c.a(this.uk, i, bdUniqueId);
    }

    public long fO() {
        return this.uq;
    }

    public int fP() {
        return BdAsyncTask.getTaskNum(d.fn());
    }

    public int H(int i) {
        return BdAsyncTask.getTaskNum(String.valueOf(i), d.fn());
    }

    public b fQ() {
        return this.uo;
    }
}
