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
    private d.a ue;
    private final LinkedList<e> uf;
    private final LinkedList<e> ug;
    private final LinkedList<e> uh;
    private com.baidu.adp.framework.client.socket.link.a ui;
    private boolean uj;
    private b uk;
    private long ul;
    private int um;

    public g(MessageManager messageManager) {
        super(messageManager);
        this.ue = null;
        this.uf = new LinkedList<>();
        this.ug = new LinkedList<>();
        this.uh = new LinkedList<>();
        this.ui = null;
        this.uj = true;
        this.uk = null;
        this.ul = 0L;
        this.um = 0;
        BdSocketLinkService.setConnStateCallBack(this);
        this.ue = new d.a() { // from class: com.baidu.adp.framework.client.socket.g.1
            @Override // com.baidu.adp.framework.client.socket.d.a
            public void a(d.b bVar) {
                g.this.b(bVar);
            }
        };
    }

    public boolean a(SocketMessage socketMessage) {
        if (socketMessage != null && (socketMessage instanceof a)) {
            a aVar = (a) socketMessage;
            if (c.a(this.ug, aVar, socketMessage.getCmd()) || c.a(this.uf, aVar, socketMessage.getCmd()) || c.a(this.uh, aVar, socketMessage.getCmd())) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b
    public void a(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        l.kg();
        if (socketMessage != null && socketMessageTask != null) {
            if (a(socketMessage, socketMessageTask.go())) {
                i.a("queue", socketMessage, 0, "sendMessage", h.uN, "duplicate message be removed");
                return;
            }
            e eVar = new e(socketMessage, socketMessageTask, this);
            if (BdSocketLinkService.hasAbsoluteClose()) {
                i.a("queue", socketMessage, 0, "sendMessage", h.uW, "user manual close socket");
                eVar.G(h.uW);
            } else if (!BdSocketLinkService.isAvailable()) {
                i.a("queue", socketMessage, 0, "sendMessage", h.uM, "isManualBlock message be removed");
                eVar.G(h.uM);
            } else {
                i.a("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                c.a(eVar, this.ug);
                fD();
            }
        }
    }

    private boolean a(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        if (socketMessage != null) {
            int cmd = socketMessage.getCmd();
            switch (dupLicateMode) {
                case REMOVE_ALL:
                    c.c(this.ug, cmd);
                    c.c(this.uf, cmd);
                    c.c(this.uh, cmd);
                    break;
                case REMOVE_WAITING:
                    c.c(this.ug, cmd);
                    break;
                case REMOVE_ME:
                    if (c.b(this.ug, cmd) || c.b(this.uf, cmd) || c.b(this.uh, cmd)) {
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
            if (bVar.tQ != null) {
                a(bVar.tQ, h.uu, null);
                return;
            }
            SocketResponsedMessage socketResponsedMessage = bVar.tP;
            if (socketResponsedMessage != null) {
                i.a("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
                b(socketResponsedMessage);
            }
        }
    }

    public void b(e eVar) {
        if (eVar != null && eVar.fx() && eVar.fA() < eVar.fh()) {
            c.a(this.uf, this.uh, eVar);
            if (this.uk != null) {
                this.uk.b(true, "timeout seq = " + eVar.getSequenceId());
            }
            i.a("queue", eVar.fu(), eVar.getSequenceId(), "onSendTimeOut", h.uQ, String.valueOf(eVar.fA()));
            return;
        }
        e(eVar);
        a(eVar, h.uH, null);
        fD();
    }

    public void a(int i, e eVar) {
        int i2;
        if (i == 2) {
            if (eVar.fs() != null) {
                i2 = eVar.fs().getErrorCode();
            } else {
                i2 = h.uD;
            }
        } else {
            i2 = h.uI;
        }
        String I = h.I(i2);
        e(eVar);
        a(eVar, i2, I);
    }

    public void c(e eVar) {
    }

    public void d(e eVar) {
        if (eVar != null) {
            if (eVar.ft()) {
                eVar.fB();
                c.a(this.ug, this.uf, eVar);
                return;
            }
            c.b(eVar, this.ug);
        }
    }

    protected void a(e eVar, int i, String str) {
        SocketResponsedMessage socketResponsedMessage = null;
        if (eVar != null && eVar.fu() != null) {
            int cmd = eVar.fu().getCmd();
            int sequenceId = eVar.getSequenceId();
            i.a("queue", eVar.fu(), sequenceId, "onMessageSendFail", i, str + " retryTime-" + eVar.fA());
            SocketMessageTask fv = eVar != null ? eVar.fv() : null;
            SocketMessageTask socketMessageTask = fv == null ? (SocketMessageTask) this.tz.findTask(cmd) : fv;
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
                socketResponsedMessage.setOrginalMessage(eVar.fu());
                i.a("queue", eVar.fu(), sequenceId, "onMessageSendFail", i, "onMessageSendFail class = " + socketResponsedMessage.getClass().getName());
                this.tz.dispatchResponsedMessage(socketResponsedMessage);
            }
        }
    }

    private void fD() {
        e e = c.e(this.ug);
        if (e != null) {
            if (BdSocketLinkService.isClose()) {
                i.a("queue", e.fu(), 0, "sendNext", h.uO, "");
                BdSocketLinkService.startService(false, "send message");
            } else if (!this.uj || e.getPriority() <= -3) {
                BdSocketLinkService.sendMessage(e);
            }
        }
    }

    private void b(SocketResponsedMessage socketResponsedMessage) {
        this.tz.dispatchResponsedMessage(socketResponsedMessage);
    }

    private void e(e eVar) {
        if (eVar != null) {
            eVar.fn();
            c.b(eVar, this.uf);
            c.b(eVar, this.ug);
            c.b(eVar, this.uh);
        }
    }

    private void i(LinkedList<e> linkedList) {
        while (true) {
            e f = c.f(linkedList);
            if (f != null) {
                f.fn();
                a(f, h.uJ, null);
            } else {
                return;
            }
        }
    }

    public void fE() {
        i(this.uf);
        i(this.ug);
        i(this.uh);
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public boolean e(int i, String str) {
        if (this.ui != null) {
            this.ui.e(i, str);
        }
        if (this.uk != null) {
            this.uk.fe();
        }
        if (!l.ki() || c.g(this.uh) || c.g(this.ug) || c.g(this.uf) || !BdSocketLinkService.isAvailable()) {
            fE();
            return false;
        }
        c.h(this.uf);
        c.a(this.ug, this.uh);
        c.a(this.ug, this.uf);
        while (true) {
            e d = c.d(this.ug);
            if (d == null) {
                break;
            }
            d.fn();
            a(d, h.uJ, null);
        }
        if (c.c(this.ug) > 0) {
            i.a("queue", 0, 0, "onClose", h.uR, "have retry message, MessageQueue:reconnect");
            BdSocketLinkService.startService(false, "have retry message");
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void h(Map<String, String> map) {
        f.fC().g(map);
        if (this.uk != null) {
            this.uk.ff();
        }
        this.uj = true;
        i.a("queue", 0, 0, "onConnected", h.uV, "Queue blocked");
        if (this.ui != null) {
            this.ui.h(map);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void a(k.a aVar) {
        byte[] bArr;
        if (aVar != null && (bArr = aVar.FA) != null) {
            this.ul = System.currentTimeMillis();
            try {
                com.baidu.adp.framework.client.socket.coder.c g = com.baidu.adp.framework.client.socket.coder.b.fU().g(bArr);
                this.um = 0;
                int command = g.vp.getCommand();
                int fR = g.vp.fR();
                i.a("queue", command, fR, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
                e n = n(command, fR);
                if (n != null) {
                    n.tZ = aVar.tZ;
                    n.ub = aVar.ub;
                }
                if (this.uk != null) {
                    if (g.vp.getCommand() == this.uk.getCmd() && c.a(this.ug, this.uh)) {
                        fD();
                    }
                    this.uk.ff();
                }
                if (fR == 0 || (n != null && n.getCmd() == command)) {
                    new d(g, n, this.ue, fR).execute(new String[0]);
                } else if (n != null) {
                    a(n, h.uX, null);
                }
                if (this.ui != null) {
                    this.ui.a(aVar);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2000986));
            } catch (CoderException e) {
                int maxAlertCount = com.baidu.adp.lib.stats.switchs.a.jk().getMaxAlertCount("alert_protobuf", 2);
                int i = this.um + 1;
                this.um = i;
                if (i >= maxAlertCount) {
                    BdStatisticsManager.getInstance().alert("alert_protobuf", "protbuf");
                }
                i.a("queue", 0, 0, "onBinaryMesssage", h.uE, "onBinaryMesssage decodeHeader error");
            }
        }
    }

    private e n(int i, int i2) {
        e eVar = null;
        if (i2 != 0) {
            e a = c.a(i2, this.uf);
            if (a == null && (a = c.a(i2, this.uh)) == null) {
                eVar = c.a(i2, this.ug);
                if (eVar == null) {
                    i.a("queue", i, i2, "findSenderData", h.uT, "original message removed , responsedMessage not dispatchMessage");
                }
            } else {
                eVar = a;
            }
            i.a("queue", i, i2, "findSenderData", h.uS, "received ack message");
        }
        return eVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
        fD();
        if (this.ui != null) {
            this.ui.a(cVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void S(String str) {
        if (this.ui != null) {
            this.ui.S(str);
        }
    }

    public void a(com.baidu.adp.framework.client.socket.link.a aVar) {
        this.ui = aVar;
    }

    public void fF() {
        boolean z = this.uj;
        this.uj = false;
        i.a("queue", 0, 0, "unBlockMessageQueue", h.uP, "Queue block has release");
        if (z) {
            fD();
        }
    }

    public void a(b bVar) {
        this.uk = bVar;
    }

    public boolean isValid() {
        return BdSocketLinkService.isOpen() && !this.uj && BdSocketLinkService.isAvailable();
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        removeMessage(0, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        c.b(this.uf, i, bdUniqueId);
        c.b(this.ug, i, bdUniqueId);
        c.b(this.uh, i, bdUniqueId);
    }

    public LinkedList<SocketMessage> a(BdUniqueId bdUniqueId) {
        return null;
    }

    @Override // com.baidu.adp.framework.b
    public LinkedList<SocketMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return null;
    }

    public boolean a(int i, BdUniqueId bdUniqueId) {
        return c.a(this.ug, i, bdUniqueId) || c.a(this.uf, i, bdUniqueId) || c.a(this.uh, i, bdUniqueId);
    }

    public long fG() {
        return this.ul;
    }

    public int fH() {
        return BdAsyncTask.getTaskNum(d.fg());
    }

    public int H(int i) {
        return BdAsyncTask.getTaskNum(String.valueOf(i), d.fg());
    }

    public b fI() {
        return this.uk;
    }
}
