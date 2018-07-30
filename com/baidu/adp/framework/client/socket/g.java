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
    private d.a tl;
    private final LinkedList<e> tm;
    private final LinkedList<e> tp;
    private final LinkedList<e> tq;
    private com.baidu.adp.framework.client.socket.link.a tr;
    private boolean ts;
    private b tt;
    private long tu;

    /* renamed from: tv  reason: collision with root package name */
    private int f0tv;

    public g(MessageManager messageManager) {
        super(messageManager);
        this.tl = null;
        this.tm = new LinkedList<>();
        this.tp = new LinkedList<>();
        this.tq = new LinkedList<>();
        this.tr = null;
        this.ts = true;
        this.tt = null;
        this.tu = 0L;
        this.f0tv = 0;
        BdSocketLinkService.setConnStateCallBack(this);
        this.tl = new d.a() { // from class: com.baidu.adp.framework.client.socket.g.1
            @Override // com.baidu.adp.framework.client.socket.d.a
            public void a(d.b bVar) {
                g.this.b(bVar);
            }
        };
    }

    public boolean a(SocketMessage socketMessage) {
        if (socketMessage != null && (socketMessage instanceof a)) {
            a aVar = (a) socketMessage;
            if (c.a(this.tp, aVar, socketMessage.getCmd()) || c.a(this.tm, aVar, socketMessage.getCmd()) || c.a(this.tq, aVar, socketMessage.getCmd())) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b
    public void a(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        l.jT();
        if (socketMessage != null && socketMessageTask != null) {
            if (a(socketMessage, socketMessageTask.fY())) {
                i.a("queue", socketMessage, 0, "sendMessage", h.tW, "duplicate message be removed");
                return;
            }
            e eVar = new e(socketMessage, socketMessageTask, this);
            if (BdSocketLinkService.hasAbsoluteClose()) {
                i.a("queue", socketMessage, 0, "sendMessage", h.ug, "user manual close socket");
                eVar.G(h.ug);
            } else if (!BdSocketLinkService.isAvailable()) {
                i.a("queue", socketMessage, 0, "sendMessage", h.tV, "isManualBlock message be removed");
                eVar.G(h.tV);
            } else {
                i.a("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                c.a(eVar, this.tp);
                fm();
            }
        }
    }

    private boolean a(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        if (socketMessage != null) {
            int cmd = socketMessage.getCmd();
            switch (dupLicateMode) {
                case REMOVE_ALL:
                    c.c(this.tp, cmd);
                    c.c(this.tm, cmd);
                    c.c(this.tq, cmd);
                    break;
                case REMOVE_WAITING:
                    c.c(this.tp, cmd);
                    break;
                case REMOVE_ME:
                    if (c.b(this.tp, cmd) || c.b(this.tm, cmd) || c.b(this.tq, cmd)) {
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
            if (bVar.sX != null) {
                a(bVar.sX, h.tD, null);
                return;
            }
            SocketResponsedMessage socketResponsedMessage = bVar.sW;
            if (socketResponsedMessage != null) {
                i.a("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
                b(socketResponsedMessage);
            }
        }
    }

    public void b(e eVar) {
        if (eVar != null && eVar.fg() && eVar.fj() < eVar.eR()) {
            c.a(this.tm, this.tq, eVar);
            if (this.tt != null) {
                this.tt.c(true, "timeout seq = " + eVar.getSequenceId());
            }
            i.a("queue", eVar.fd(), eVar.getSequenceId(), "onSendTimeOut", h.tZ, String.valueOf(eVar.fj()));
            return;
        }
        e(eVar);
        a(eVar, h.tQ, null);
        fm();
    }

    public void a(int i, e eVar) {
        int i2;
        if (i == 2) {
            if (eVar.fb() != null) {
                i2 = eVar.fb().getErrorCode();
            } else {
                i2 = h.tM;
            }
        } else {
            i2 = h.tR;
        }
        String I = h.I(i2);
        e(eVar);
        a(eVar, i2, I);
    }

    public void c(e eVar) {
    }

    public void d(e eVar) {
        if (eVar != null) {
            if (eVar.fc()) {
                eVar.fk();
                c.a(this.tp, this.tm, eVar);
                return;
            }
            c.b(eVar, this.tp);
        }
    }

    protected void a(e eVar, int i, String str) {
        SocketResponsedMessage socketResponsedMessage = null;
        if (eVar != null && eVar.fd() != null) {
            int cmd = eVar.fd().getCmd();
            int sequenceId = eVar.getSequenceId();
            i.a("queue", eVar.fd(), sequenceId, "onMessageSendFail", i, str + " retryTime-" + eVar.fj());
            SocketMessageTask fe = eVar != null ? eVar.fe() : null;
            SocketMessageTask socketMessageTask = fe == null ? (SocketMessageTask) this.sG.findTask(cmd) : fe;
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
                socketResponsedMessage.setOrginalMessage(eVar.fd());
                i.a("queue", eVar.fd(), sequenceId, "onMessageSendFail", i, "onMessageSendFail class = " + socketResponsedMessage.getClass().getName());
                this.sG.dispatchResponsedMessage(socketResponsedMessage);
            }
        }
    }

    private void fm() {
        e e = c.e(this.tp);
        if (e != null) {
            if (BdSocketLinkService.isClose()) {
                i.a("queue", e.fd(), 0, "sendNext", h.tX, "");
                BdSocketLinkService.startService(false, "send message");
            } else if (!this.ts || e.getPriority() <= -3) {
                BdSocketLinkService.sendMessage(e);
            }
        }
    }

    private void b(SocketResponsedMessage socketResponsedMessage) {
        this.sG.dispatchResponsedMessage(socketResponsedMessage);
    }

    private void e(e eVar) {
        if (eVar != null) {
            eVar.eX();
            c.b(eVar, this.tm);
            c.b(eVar, this.tp);
            c.b(eVar, this.tq);
        }
    }

    private void i(LinkedList<e> linkedList) {
        while (true) {
            e f = c.f(linkedList);
            if (f != null) {
                f.eX();
                a(f, h.tS, null);
            } else {
                return;
            }
        }
    }

    public void fn() {
        i(this.tm);
        i(this.tp);
        i(this.tq);
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public boolean e(int i, String str) {
        if (this.tr != null) {
            this.tr.e(i, str);
        }
        if (this.tt != null) {
            this.tt.eO();
        }
        if (!l.jV() || c.g(this.tq) || c.g(this.tp) || c.g(this.tm) || !BdSocketLinkService.isAvailable()) {
            fn();
            return false;
        }
        c.h(this.tm);
        c.a(this.tp, this.tq);
        c.a(this.tp, this.tm);
        while (true) {
            e d = c.d(this.tp);
            if (d == null) {
                break;
            }
            d.eX();
            a(d, h.tS, null);
        }
        if (c.c(this.tp) > 0) {
            i.a("queue", 0, 0, "onClose", h.ub, "have retry message, MessageQueue:reconnect");
            BdSocketLinkService.startService(false, "have retry message");
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void h(Map<String, String> map) {
        f.fl().g(map);
        if (this.tt != null) {
            this.tt.eP();
        }
        this.ts = true;
        i.a("queue", 0, 0, "onConnected", h.uf, "Queue blocked");
        if (this.tr != null) {
            this.tr.h(map);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void a(k.a aVar) {
        byte[] bArr;
        if (aVar != null && (bArr = aVar.EK) != null) {
            this.tu = System.currentTimeMillis();
            try {
                com.baidu.adp.framework.client.socket.coder.c g = com.baidu.adp.framework.client.socket.coder.b.fF().g(bArr);
                this.f0tv = 0;
                int fA = g.uC.fA();
                int fC = g.uC.fC();
                i.a("queue", fA, fC, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
                e n = n(fA, fC);
                if (n != null) {
                    n.th = aVar.th;
                    n.ti = aVar.ti;
                }
                if (this.tt != null) {
                    if (g.uC.fA() == this.tt.getCmd() && c.a(this.tp, this.tq)) {
                        fm();
                    }
                    this.tt.eP();
                }
                if (fC == 0 || (n != null && n.getCmd() == fA)) {
                    new d(g, n, this.tl, fC).execute(new String[0]);
                } else if (n != null) {
                    a(n, h.uh, null);
                }
                if (this.tr != null) {
                    this.tr.a(aVar);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2000986));
            } catch (CoderException e) {
                int maxAlertCount = com.baidu.adp.lib.stats.switchs.a.iW().getMaxAlertCount("alert_protobuf", 2);
                int i = this.f0tv + 1;
                this.f0tv = i;
                if (i >= maxAlertCount) {
                    BdStatisticsManager.getInstance().alert("alert_protobuf", "protbuf");
                }
                i.a("queue", 0, 0, "onBinaryMesssage", h.tN, "onBinaryMesssage decodeHeader error");
            }
        }
    }

    private e n(int i, int i2) {
        e eVar = null;
        if (i2 != 0) {
            e a = c.a(i2, this.tm);
            if (a == null && (a = c.a(i2, this.tq)) == null) {
                eVar = c.a(i2, this.tp);
                if (eVar == null) {
                    i.a("queue", i, i2, "findSenderData", h.ud, "original message removed , responsedMessage not dispatchMessage");
                }
            } else {
                eVar = a;
            }
            i.a("queue", i, i2, "findSenderData", h.uc, "received ack message");
        }
        return eVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
        fm();
        if (this.tr != null) {
            this.tr.a(cVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void S(String str) {
        if (this.tr != null) {
            this.tr.S(str);
        }
    }

    public void a(com.baidu.adp.framework.client.socket.link.a aVar) {
        this.tr = aVar;
    }

    public void fo() {
        boolean z = this.ts;
        this.ts = false;
        i.a("queue", 0, 0, "unBlockMessageQueue", h.tY, "Queue block has release");
        if (z) {
            fm();
        }
    }

    public void a(b bVar) {
        this.tt = bVar;
    }

    public boolean isValid() {
        return BdSocketLinkService.isOpen() && !this.ts && BdSocketLinkService.isAvailable();
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        removeMessage(0, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        c.b(this.tm, i, bdUniqueId);
        c.b(this.tp, i, bdUniqueId);
        c.b(this.tq, i, bdUniqueId);
    }

    public LinkedList<SocketMessage> a(BdUniqueId bdUniqueId) {
        return null;
    }

    @Override // com.baidu.adp.framework.b
    public LinkedList<SocketMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return null;
    }

    public boolean a(int i, BdUniqueId bdUniqueId) {
        return c.a(this.tp, i, bdUniqueId) || c.a(this.tm, i, bdUniqueId) || c.a(this.tq, i, bdUniqueId);
    }

    public long fp() {
        return this.tu;
    }

    public int fq() {
        return BdAsyncTask.getTaskNum(d.eQ());
    }

    public int H(int i) {
        return BdAsyncTask.getTaskNum(String.valueOf(i), d.eQ());
    }

    public b fs() {
        return this.tt;
    }
}
