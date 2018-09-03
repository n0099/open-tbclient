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
    private d.a tm;
    private final LinkedList<e> tp;
    private final LinkedList<e> tq;
    private final LinkedList<e> tr;
    private com.baidu.adp.framework.client.socket.link.a ts;
    private boolean tt;
    private b tu;

    /* renamed from: tv  reason: collision with root package name */
    private long f0tv;
    private int tw;

    public g(MessageManager messageManager) {
        super(messageManager);
        this.tm = null;
        this.tp = new LinkedList<>();
        this.tq = new LinkedList<>();
        this.tr = new LinkedList<>();
        this.ts = null;
        this.tt = true;
        this.tu = null;
        this.f0tv = 0L;
        this.tw = 0;
        BdSocketLinkService.setConnStateCallBack(this);
        this.tm = new d.a() { // from class: com.baidu.adp.framework.client.socket.g.1
            @Override // com.baidu.adp.framework.client.socket.d.a
            public void a(d.b bVar) {
                g.this.b(bVar);
            }
        };
    }

    public boolean a(SocketMessage socketMessage) {
        if (socketMessage != null && (socketMessage instanceof a)) {
            a aVar = (a) socketMessage;
            if (c.a(this.tq, aVar, socketMessage.getCmd()) || c.a(this.tp, aVar, socketMessage.getCmd()) || c.a(this.tr, aVar, socketMessage.getCmd())) {
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
                i.a("queue", socketMessage, 0, "sendMessage", h.tX, "duplicate message be removed");
                return;
            }
            e eVar = new e(socketMessage, socketMessageTask, this);
            if (BdSocketLinkService.hasAbsoluteClose()) {
                i.a("queue", socketMessage, 0, "sendMessage", h.uh, "user manual close socket");
                eVar.G(h.uh);
            } else if (!BdSocketLinkService.isAvailable()) {
                i.a("queue", socketMessage, 0, "sendMessage", h.tW, "isManualBlock message be removed");
                eVar.G(h.tW);
            } else {
                i.a("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                c.a(eVar, this.tq);
                fm();
            }
        }
    }

    private boolean a(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        if (socketMessage != null) {
            int cmd = socketMessage.getCmd();
            switch (dupLicateMode) {
                case REMOVE_ALL:
                    c.c(this.tq, cmd);
                    c.c(this.tp, cmd);
                    c.c(this.tr, cmd);
                    break;
                case REMOVE_WAITING:
                    c.c(this.tq, cmd);
                    break;
                case REMOVE_ME:
                    if (c.b(this.tq, cmd) || c.b(this.tp, cmd) || c.b(this.tr, cmd)) {
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
            if (bVar.sY != null) {
                a(bVar.sY, h.tE, null);
                return;
            }
            SocketResponsedMessage socketResponsedMessage = bVar.sX;
            if (socketResponsedMessage != null) {
                i.a("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
                b(socketResponsedMessage);
            }
        }
    }

    public void b(e eVar) {
        if (eVar != null && eVar.fg() && eVar.fj() < eVar.eR()) {
            c.a(this.tp, this.tr, eVar);
            if (this.tu != null) {
                this.tu.b(true, "timeout seq = " + eVar.getSequenceId());
            }
            i.a("queue", eVar.fd(), eVar.getSequenceId(), "onSendTimeOut", h.ub, String.valueOf(eVar.fj()));
            return;
        }
        e(eVar);
        a(eVar, h.tR, null);
        fm();
    }

    public void a(int i, e eVar) {
        int i2;
        if (i == 2) {
            if (eVar.fb() != null) {
                i2 = eVar.fb().getErrorCode();
            } else {
                i2 = h.tN;
            }
        } else {
            i2 = h.tS;
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
                c.a(this.tq, this.tp, eVar);
                return;
            }
            c.b(eVar, this.tq);
        }
    }

    protected void a(e eVar, int i, String str) {
        SocketResponsedMessage socketResponsedMessage = null;
        if (eVar != null && eVar.fd() != null) {
            int cmd = eVar.fd().getCmd();
            int sequenceId = eVar.getSequenceId();
            i.a("queue", eVar.fd(), sequenceId, "onMessageSendFail", i, str + " retryTime-" + eVar.fj());
            SocketMessageTask fe = eVar != null ? eVar.fe() : null;
            SocketMessageTask socketMessageTask = fe == null ? (SocketMessageTask) this.sH.findTask(cmd) : fe;
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
                this.sH.dispatchResponsedMessage(socketResponsedMessage);
            }
        }
    }

    private void fm() {
        e e = c.e(this.tq);
        if (e != null) {
            if (BdSocketLinkService.isClose()) {
                i.a("queue", e.fd(), 0, "sendNext", h.tY, "");
                BdSocketLinkService.startService(false, "send message");
            } else if (!this.tt || e.getPriority() <= -3) {
                BdSocketLinkService.sendMessage(e);
            }
        }
    }

    private void b(SocketResponsedMessage socketResponsedMessage) {
        this.sH.dispatchResponsedMessage(socketResponsedMessage);
    }

    private void e(e eVar) {
        if (eVar != null) {
            eVar.eX();
            c.b(eVar, this.tp);
            c.b(eVar, this.tq);
            c.b(eVar, this.tr);
        }
    }

    private void i(LinkedList<e> linkedList) {
        while (true) {
            e f = c.f(linkedList);
            if (f != null) {
                f.eX();
                a(f, h.tT, null);
            } else {
                return;
            }
        }
    }

    public void fn() {
        i(this.tp);
        i(this.tq);
        i(this.tr);
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public boolean e(int i, String str) {
        if (this.ts != null) {
            this.ts.e(i, str);
        }
        if (this.tu != null) {
            this.tu.eO();
        }
        if (!l.jV() || c.g(this.tr) || c.g(this.tq) || c.g(this.tp) || !BdSocketLinkService.isAvailable()) {
            fn();
            return false;
        }
        c.h(this.tp);
        c.a(this.tq, this.tr);
        c.a(this.tq, this.tp);
        while (true) {
            e d = c.d(this.tq);
            if (d == null) {
                break;
            }
            d.eX();
            a(d, h.tT, null);
        }
        if (c.c(this.tq) > 0) {
            i.a("queue", 0, 0, "onClose", h.uc, "have retry message, MessageQueue:reconnect");
            BdSocketLinkService.startService(false, "have retry message");
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void h(Map<String, String> map) {
        f.fl().g(map);
        if (this.tu != null) {
            this.tu.eP();
        }
        this.tt = true;
        i.a("queue", 0, 0, "onConnected", h.ug, "Queue blocked");
        if (this.ts != null) {
            this.ts.h(map);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void a(k.a aVar) {
        byte[] bArr;
        if (aVar != null && (bArr = aVar.EK) != null) {
            this.f0tv = System.currentTimeMillis();
            try {
                com.baidu.adp.framework.client.socket.coder.c g = com.baidu.adp.framework.client.socket.coder.b.fF().g(bArr);
                this.tw = 0;
                int fA = g.uD.fA();
                int fC = g.uD.fC();
                i.a("queue", fA, fC, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
                e n = n(fA, fC);
                if (n != null) {
                    n.ti = aVar.ti;
                    n.tj = aVar.tj;
                }
                if (this.tu != null) {
                    if (g.uD.fA() == this.tu.getCmd() && c.a(this.tq, this.tr)) {
                        fm();
                    }
                    this.tu.eP();
                }
                if (fC == 0 || (n != null && n.getCmd() == fA)) {
                    new d(g, n, this.tm, fC).execute(new String[0]);
                } else if (n != null) {
                    a(n, h.ui, null);
                }
                if (this.ts != null) {
                    this.ts.a(aVar);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2000986));
            } catch (CoderException e) {
                int maxAlertCount = com.baidu.adp.lib.stats.switchs.a.iW().getMaxAlertCount("alert_protobuf", 2);
                int i = this.tw + 1;
                this.tw = i;
                if (i >= maxAlertCount) {
                    BdStatisticsManager.getInstance().alert("alert_protobuf", "protbuf");
                }
                i.a("queue", 0, 0, "onBinaryMesssage", h.tO, "onBinaryMesssage decodeHeader error");
            }
        }
    }

    private e n(int i, int i2) {
        e eVar = null;
        if (i2 != 0) {
            e a = c.a(i2, this.tp);
            if (a == null && (a = c.a(i2, this.tr)) == null) {
                eVar = c.a(i2, this.tq);
                if (eVar == null) {
                    i.a("queue", i, i2, "findSenderData", h.ue, "original message removed , responsedMessage not dispatchMessage");
                }
            } else {
                eVar = a;
            }
            i.a("queue", i, i2, "findSenderData", h.ud, "received ack message");
        }
        return eVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
        fm();
        if (this.ts != null) {
            this.ts.a(cVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void S(String str) {
        if (this.ts != null) {
            this.ts.S(str);
        }
    }

    public void a(com.baidu.adp.framework.client.socket.link.a aVar) {
        this.ts = aVar;
    }

    public void fo() {
        boolean z = this.tt;
        this.tt = false;
        i.a("queue", 0, 0, "unBlockMessageQueue", h.tZ, "Queue block has release");
        if (z) {
            fm();
        }
    }

    public void a(b bVar) {
        this.tu = bVar;
    }

    public boolean isValid() {
        return BdSocketLinkService.isOpen() && !this.tt && BdSocketLinkService.isAvailable();
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        removeMessage(0, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        c.b(this.tp, i, bdUniqueId);
        c.b(this.tq, i, bdUniqueId);
        c.b(this.tr, i, bdUniqueId);
    }

    public LinkedList<SocketMessage> a(BdUniqueId bdUniqueId) {
        return null;
    }

    @Override // com.baidu.adp.framework.b
    public LinkedList<SocketMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return null;
    }

    public boolean a(int i, BdUniqueId bdUniqueId) {
        return c.a(this.tq, i, bdUniqueId) || c.a(this.tp, i, bdUniqueId) || c.a(this.tr, i, bdUniqueId);
    }

    public long fp() {
        return this.f0tv;
    }

    public int fq() {
        return BdAsyncTask.getTaskNum(d.eQ());
    }

    public int H(int i) {
        return BdAsyncTask.getTaskNum(String.valueOf(i), d.eQ());
    }

    public b fs() {
        return this.tu;
    }
}
