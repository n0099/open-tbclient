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
    private d.a uf;
    private final LinkedList<e> ug;
    private final LinkedList<e> uh;
    private final LinkedList<e> ui;
    private com.baidu.adp.framework.client.socket.link.a uj;
    private boolean uk;
    private b ul;
    private long um;
    private int uo;

    public g(MessageManager messageManager) {
        super(messageManager);
        this.uf = null;
        this.ug = new LinkedList<>();
        this.uh = new LinkedList<>();
        this.ui = new LinkedList<>();
        this.uj = null;
        this.uk = true;
        this.ul = null;
        this.um = 0L;
        this.uo = 0;
        BdSocketLinkService.setConnStateCallBack(this);
        this.uf = new d.a() { // from class: com.baidu.adp.framework.client.socket.g.1
            @Override // com.baidu.adp.framework.client.socket.d.a
            public void a(d.b bVar) {
                g.this.b(bVar);
            }
        };
    }

    public boolean a(SocketMessage socketMessage) {
        if (socketMessage != null && (socketMessage instanceof a)) {
            a aVar = (a) socketMessage;
            if (c.a(this.uh, aVar, socketMessage.getCmd()) || c.a(this.ug, aVar, socketMessage.getCmd()) || c.a(this.ui, aVar, socketMessage.getCmd())) {
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
                i.a("queue", socketMessage, 0, "sendMessage", h.uO, "duplicate message be removed");
                return;
            }
            e eVar = new e(socketMessage, socketMessageTask, this);
            if (BdSocketLinkService.hasAbsoluteClose()) {
                i.a("queue", socketMessage, 0, "sendMessage", h.uX, "user manual close socket");
                eVar.G(h.uX);
            } else if (!BdSocketLinkService.isAvailable()) {
                i.a("queue", socketMessage, 0, "sendMessage", h.uN, "isManualBlock message be removed");
                eVar.G(h.uN);
            } else {
                i.a("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                c.a(eVar, this.uh);
                fD();
            }
        }
    }

    private boolean a(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        if (socketMessage != null) {
            int cmd = socketMessage.getCmd();
            switch (dupLicateMode) {
                case REMOVE_ALL:
                    c.c(this.uh, cmd);
                    c.c(this.ug, cmd);
                    c.c(this.ui, cmd);
                    break;
                case REMOVE_WAITING:
                    c.c(this.uh, cmd);
                    break;
                case REMOVE_ME:
                    if (c.b(this.uh, cmd) || c.b(this.ug, cmd) || c.b(this.ui, cmd)) {
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
            if (bVar.tR != null) {
                a(bVar.tR, h.uv, null);
                return;
            }
            SocketResponsedMessage socketResponsedMessage = bVar.tQ;
            if (socketResponsedMessage != null) {
                i.a("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
                b(socketResponsedMessage);
            }
        }
    }

    public void b(e eVar) {
        if (eVar != null && eVar.fx() && eVar.fA() < eVar.fh()) {
            c.a(this.ug, this.ui, eVar);
            if (this.ul != null) {
                this.ul.b(true, "timeout seq = " + eVar.getSequenceId());
            }
            i.a("queue", eVar.fu(), eVar.getSequenceId(), "onSendTimeOut", h.uR, String.valueOf(eVar.fA()));
            return;
        }
        e(eVar);
        a(eVar, h.uI, null);
        fD();
    }

    public void a(int i, e eVar) {
        int i2;
        if (i == 2) {
            if (eVar.fs() != null) {
                i2 = eVar.fs().getErrorCode();
            } else {
                i2 = h.uE;
            }
        } else {
            i2 = h.uJ;
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
                c.a(this.uh, this.ug, eVar);
                return;
            }
            c.b(eVar, this.uh);
        }
    }

    protected void a(e eVar, int i, String str) {
        SocketResponsedMessage socketResponsedMessage = null;
        if (eVar != null && eVar.fu() != null) {
            int cmd = eVar.fu().getCmd();
            int sequenceId = eVar.getSequenceId();
            i.a("queue", eVar.fu(), sequenceId, "onMessageSendFail", i, str + " retryTime-" + eVar.fA());
            SocketMessageTask fv = eVar != null ? eVar.fv() : null;
            SocketMessageTask socketMessageTask = fv == null ? (SocketMessageTask) this.tA.findTask(cmd) : fv;
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
                this.tA.dispatchResponsedMessage(socketResponsedMessage);
            }
        }
    }

    private void fD() {
        e e = c.e(this.uh);
        if (e != null) {
            if (BdSocketLinkService.isClose()) {
                i.a("queue", e.fu(), 0, "sendNext", h.uP, "");
                BdSocketLinkService.startService(false, "send message");
            } else if (!this.uk || e.getPriority() <= -3) {
                BdSocketLinkService.sendMessage(e);
            }
        }
    }

    private void b(SocketResponsedMessage socketResponsedMessage) {
        this.tA.dispatchResponsedMessage(socketResponsedMessage);
    }

    private void e(e eVar) {
        if (eVar != null) {
            eVar.fn();
            c.b(eVar, this.ug);
            c.b(eVar, this.uh);
            c.b(eVar, this.ui);
        }
    }

    private void i(LinkedList<e> linkedList) {
        while (true) {
            e f = c.f(linkedList);
            if (f != null) {
                f.fn();
                a(f, h.uK, null);
            } else {
                return;
            }
        }
    }

    public void fE() {
        i(this.ug);
        i(this.uh);
        i(this.ui);
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public boolean e(int i, String str) {
        if (this.uj != null) {
            this.uj.e(i, str);
        }
        if (this.ul != null) {
            this.ul.fe();
        }
        if (!l.ki() || c.g(this.ui) || c.g(this.uh) || c.g(this.ug) || !BdSocketLinkService.isAvailable()) {
            fE();
            return false;
        }
        c.h(this.ug);
        c.a(this.uh, this.ui);
        c.a(this.uh, this.ug);
        while (true) {
            e d = c.d(this.uh);
            if (d == null) {
                break;
            }
            d.fn();
            a(d, h.uK, null);
        }
        if (c.c(this.uh) > 0) {
            i.a("queue", 0, 0, "onClose", h.uS, "have retry message, MessageQueue:reconnect");
            BdSocketLinkService.startService(false, "have retry message");
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void h(Map<String, String> map) {
        f.fC().g(map);
        if (this.ul != null) {
            this.ul.ff();
        }
        this.uk = true;
        i.a("queue", 0, 0, "onConnected", h.uW, "Queue blocked");
        if (this.uj != null) {
            this.uj.h(map);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void a(k.a aVar) {
        byte[] bArr;
        if (aVar != null && (bArr = aVar.FB) != null) {
            this.um = System.currentTimeMillis();
            try {
                com.baidu.adp.framework.client.socket.coder.c g = com.baidu.adp.framework.client.socket.coder.b.fU().g(bArr);
                this.uo = 0;
                int command = g.vq.getCommand();
                int fR = g.vq.fR();
                i.a("queue", command, fR, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
                e n = n(command, fR);
                if (n != null) {
                    n.ub = aVar.ub;
                    n.uc = aVar.uc;
                }
                if (this.ul != null) {
                    if (g.vq.getCommand() == this.ul.getCmd() && c.a(this.uh, this.ui)) {
                        fD();
                    }
                    this.ul.ff();
                }
                if (fR == 0 || (n != null && n.getCmd() == command)) {
                    new d(g, n, this.uf, fR).execute(new String[0]);
                } else if (n != null) {
                    a(n, h.uY, null);
                }
                if (this.uj != null) {
                    this.uj.a(aVar);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2000986));
            } catch (CoderException e) {
                int maxAlertCount = com.baidu.adp.lib.stats.switchs.a.jk().getMaxAlertCount("alert_protobuf", 2);
                int i = this.uo + 1;
                this.uo = i;
                if (i >= maxAlertCount) {
                    BdStatisticsManager.getInstance().alert("alert_protobuf", "protbuf");
                }
                i.a("queue", 0, 0, "onBinaryMesssage", h.uF, "onBinaryMesssage decodeHeader error");
            }
        }
    }

    private e n(int i, int i2) {
        e eVar = null;
        if (i2 != 0) {
            e a = c.a(i2, this.ug);
            if (a == null && (a = c.a(i2, this.ui)) == null) {
                eVar = c.a(i2, this.uh);
                if (eVar == null) {
                    i.a("queue", i, i2, "findSenderData", h.uU, "original message removed , responsedMessage not dispatchMessage");
                }
            } else {
                eVar = a;
            }
            i.a("queue", i, i2, "findSenderData", h.uT, "received ack message");
        }
        return eVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
        fD();
        if (this.uj != null) {
            this.uj.a(cVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void S(String str) {
        if (this.uj != null) {
            this.uj.S(str);
        }
    }

    public void a(com.baidu.adp.framework.client.socket.link.a aVar) {
        this.uj = aVar;
    }

    public void fF() {
        boolean z = this.uk;
        this.uk = false;
        i.a("queue", 0, 0, "unBlockMessageQueue", h.uQ, "Queue block has release");
        if (z) {
            fD();
        }
    }

    public void a(b bVar) {
        this.ul = bVar;
    }

    public boolean isValid() {
        return BdSocketLinkService.isOpen() && !this.uk && BdSocketLinkService.isAvailable();
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        removeMessage(0, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        c.b(this.ug, i, bdUniqueId);
        c.b(this.uh, i, bdUniqueId);
        c.b(this.ui, i, bdUniqueId);
    }

    public LinkedList<SocketMessage> a(BdUniqueId bdUniqueId) {
        return null;
    }

    @Override // com.baidu.adp.framework.b
    public LinkedList<SocketMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return null;
    }

    public boolean a(int i, BdUniqueId bdUniqueId) {
        return c.a(this.uh, i, bdUniqueId) || c.a(this.ug, i, bdUniqueId) || c.a(this.ui, i, bdUniqueId);
    }

    public long fG() {
        return this.um;
    }

    public int fH() {
        return BdAsyncTask.getTaskNum(d.fg());
    }

    public int H(int i) {
        return BdAsyncTask.getTaskNum(String.valueOf(i), d.fg());
    }

    public b fI() {
        return this.ul;
    }
}
