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
    private final LinkedList<e> tA;
    private final LinkedList<e> tB;
    private final LinkedList<e> tC;
    private com.baidu.adp.framework.client.socket.link.a tD;
    private boolean tE;
    private b tF;
    private long tG;
    private int tH;
    private d.a tz;

    public g(MessageManager messageManager) {
        super(messageManager);
        this.tz = null;
        this.tA = new LinkedList<>();
        this.tB = new LinkedList<>();
        this.tC = new LinkedList<>();
        this.tD = null;
        this.tE = true;
        this.tF = null;
        this.tG = 0L;
        this.tH = 0;
        BdSocketLinkService.setConnStateCallBack(this);
        this.tz = new d.a() { // from class: com.baidu.adp.framework.client.socket.g.1
            @Override // com.baidu.adp.framework.client.socket.d.a
            public void a(d.b bVar) {
                g.this.b(bVar);
            }
        };
    }

    public boolean a(SocketMessage socketMessage) {
        if (socketMessage != null && (socketMessage instanceof a)) {
            a aVar = (a) socketMessage;
            if (c.a(this.tB, aVar, socketMessage.getCmd()) || c.a(this.tA, aVar, socketMessage.getCmd()) || c.a(this.tC, aVar, socketMessage.getCmd())) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b
    public void a(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        l.jS();
        if (socketMessage != null && socketMessageTask != null) {
            if (a(socketMessage, socketMessageTask.fZ())) {
                i.a("queue", socketMessage, 0, "sendMessage", h.uh, "duplicate message be removed");
                return;
            }
            e eVar = new e(socketMessage, socketMessageTask, this);
            if (BdSocketLinkService.hasAbsoluteClose()) {
                i.a("queue", socketMessage, 0, "sendMessage", h.us, "user manual close socket");
                eVar.G(h.us);
            } else if (!BdSocketLinkService.isAvailable()) {
                i.a("queue", socketMessage, 0, "sendMessage", h.ug, "isManualBlock message be removed");
                eVar.G(h.ug);
            } else {
                i.a("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                c.a(eVar, this.tB);
                fn();
            }
        }
    }

    private boolean a(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        if (socketMessage != null) {
            int cmd = socketMessage.getCmd();
            switch (dupLicateMode) {
                case REMOVE_ALL:
                    c.c(this.tB, cmd);
                    c.c(this.tA, cmd);
                    c.c(this.tC, cmd);
                    break;
                case REMOVE_WAITING:
                    c.c(this.tB, cmd);
                    break;
                case REMOVE_ME:
                    if (c.b(this.tB, cmd) || c.b(this.tA, cmd) || c.b(this.tC, cmd)) {
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
            if (bVar.ti != null) {
                a(bVar.ti, h.tN, null);
                return;
            }
            SocketResponsedMessage socketResponsedMessage = bVar.th;
            if (socketResponsedMessage != null) {
                i.a("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
                b(socketResponsedMessage);
            }
        }
    }

    public void b(e eVar) {
        if (eVar != null && eVar.fh() && eVar.fk() < eVar.eS()) {
            c.a(this.tA, this.tC, eVar);
            if (this.tF != null) {
                this.tF.c(true, "timeout seq = " + eVar.getSequenceId());
            }
            i.a("queue", eVar.fe(), eVar.getSequenceId(), "onSendTimeOut", h.uk, String.valueOf(eVar.fk()));
            return;
        }
        e(eVar);
        a(eVar, h.ub, null);
        fn();
    }

    public void a(int i, e eVar) {
        int i2;
        if (i == 2) {
            if (eVar.fc() != null) {
                i2 = eVar.fc().getErrorCode();
            } else {
                i2 = h.tW;
            }
        } else {
            i2 = h.uc;
        }
        String I = h.I(i2);
        e(eVar);
        a(eVar, i2, I);
    }

    public void c(e eVar) {
    }

    public void d(e eVar) {
        if (eVar != null) {
            if (eVar.fd()) {
                eVar.fl();
                c.a(this.tB, this.tA, eVar);
                return;
            }
            c.b(eVar, this.tB);
        }
    }

    protected void a(e eVar, int i, String str) {
        SocketResponsedMessage socketResponsedMessage = null;
        if (eVar != null && eVar.fe() != null) {
            int cmd = eVar.fe().getCmd();
            int sequenceId = eVar.getSequenceId();
            i.a("queue", eVar.fe(), sequenceId, "onMessageSendFail", i, str + " retryTime-" + eVar.fk());
            SocketMessageTask ff = eVar != null ? eVar.ff() : null;
            SocketMessageTask socketMessageTask = ff == null ? (SocketMessageTask) this.sQ.findTask(cmd) : ff;
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
                socketResponsedMessage.setOrginalMessage(eVar.fe());
                i.a("queue", eVar.fe(), sequenceId, "onMessageSendFail", i, "onMessageSendFail class = " + socketResponsedMessage.getClass().getName());
                this.sQ.dispatchResponsedMessage(socketResponsedMessage);
            }
        }
    }

    private void fn() {
        e e = c.e(this.tB);
        if (e != null) {
            if (BdSocketLinkService.isClose()) {
                i.a("queue", e.fe(), 0, "sendNext", h.ui, "");
                BdSocketLinkService.startService(false, "send message");
            } else if (!this.tE || e.getPriority() <= -3) {
                BdSocketLinkService.sendMessage(e);
            }
        }
    }

    private void b(SocketResponsedMessage socketResponsedMessage) {
        this.sQ.dispatchResponsedMessage(socketResponsedMessage);
    }

    private void e(e eVar) {
        if (eVar != null) {
            eVar.eY();
            c.b(eVar, this.tA);
            c.b(eVar, this.tB);
            c.b(eVar, this.tC);
        }
    }

    private void i(LinkedList<e> linkedList) {
        while (true) {
            e f = c.f(linkedList);
            if (f != null) {
                f.eY();
                a(f, h.ud, null);
            } else {
                return;
            }
        }
    }

    public void fo() {
        i(this.tA);
        i(this.tB);
        i(this.tC);
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public boolean d(int i, String str) {
        if (this.tD != null) {
            this.tD.d(i, str);
        }
        if (this.tF != null) {
            this.tF.eP();
        }
        if (!l.jU() || c.g(this.tC) || c.g(this.tB) || c.g(this.tA) || !BdSocketLinkService.isAvailable()) {
            fo();
            return false;
        }
        c.h(this.tA);
        c.a(this.tB, this.tC);
        c.a(this.tB, this.tA);
        while (true) {
            e d = c.d(this.tB);
            if (d == null) {
                break;
            }
            d.eY();
            a(d, h.ud, null);
        }
        if (c.c(this.tB) > 0) {
            i.a("queue", 0, 0, "onClose", h.ul, "have retry message, MessageQueue:reconnect");
            BdSocketLinkService.startService(false, "have retry message");
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void h(Map<String, String> map) {
        f.fm().g(map);
        if (this.tF != null) {
            this.tF.eQ();
        }
        this.tE = true;
        i.a("queue", 0, 0, "onConnected", h.ur, "Queue blocked");
        if (this.tD != null) {
            this.tD.h(map);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void a(k.a aVar) {
        byte[] bArr;
        if (aVar != null && (bArr = aVar.EL) != null) {
            this.tG = System.currentTimeMillis();
            try {
                com.baidu.adp.framework.client.socket.coder.c h = com.baidu.adp.framework.client.socket.coder.b.fG().h(bArr);
                this.tH = 0;
                int fB = h.uM.fB();
                int fD = h.uM.fD();
                i.a("queue", fB, fD, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
                e n = n(fB, fD);
                if (n != null) {
                    n.tt = aVar.tt;
                    n.tu = aVar.tu;
                }
                if (this.tF != null) {
                    if (h.uM.fB() == this.tF.getCmd() && c.a(this.tB, this.tC)) {
                        fn();
                    }
                    this.tF.eQ();
                }
                if (fD == 0 || (n != null && n.getCmd() == fB)) {
                    new d(h, n, this.tz, fD).execute(new String[0]);
                } else if (n != null) {
                    a(n, h.ut, null);
                }
                if (this.tD != null) {
                    this.tD.a(aVar);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2000986));
            } catch (CoderException e) {
                int maxAlertCount = com.baidu.adp.lib.stats.switchs.a.iV().getMaxAlertCount("alert_protobuf", 2);
                int i = this.tH + 1;
                this.tH = i;
                if (i >= maxAlertCount) {
                    BdStatisticsManager.getInstance().alert("alert_protobuf", "protbuf");
                }
                i.a("queue", 0, 0, "onBinaryMesssage", h.tX, "onBinaryMesssage decodeHeader error");
            }
        }
    }

    private e n(int i, int i2) {
        e eVar = null;
        if (i2 != 0) {
            e a = c.a(i2, this.tA);
            if (a == null && (a = c.a(i2, this.tC)) == null) {
                eVar = c.a(i2, this.tB);
                if (eVar == null) {
                    i.a("queue", i, i2, "findSenderData", h.uo, "original message removed , responsedMessage not dispatchMessage");
                }
            } else {
                eVar = a;
            }
            i.a("queue", i, i2, "findSenderData", h.um, "received ack message");
        }
        return eVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
        fn();
        if (this.tD != null) {
            this.tD.a(cVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void S(String str) {
        if (this.tD != null) {
            this.tD.S(str);
        }
    }

    public void a(com.baidu.adp.framework.client.socket.link.a aVar) {
        this.tD = aVar;
    }

    public void fp() {
        boolean z = this.tE;
        this.tE = false;
        i.a("queue", 0, 0, "unBlockMessageQueue", h.uj, "Queue block has release");
        if (z) {
            fn();
        }
    }

    public void a(b bVar) {
        this.tF = bVar;
    }

    public boolean isValid() {
        return BdSocketLinkService.isOpen() && !this.tE && BdSocketLinkService.isAvailable();
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        removeMessage(0, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        c.b(this.tA, i, bdUniqueId);
        c.b(this.tB, i, bdUniqueId);
        c.b(this.tC, i, bdUniqueId);
    }

    public LinkedList<SocketMessage> a(BdUniqueId bdUniqueId) {
        return null;
    }

    @Override // com.baidu.adp.framework.b
    public LinkedList<SocketMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return null;
    }

    public boolean a(int i, BdUniqueId bdUniqueId) {
        return c.a(this.tB, i, bdUniqueId) || c.a(this.tA, i, bdUniqueId) || c.a(this.tC, i, bdUniqueId);
    }

    public long fq() {
        return this.tG;
    }

    public int fs() {
        return BdAsyncTask.getTaskNum(d.eR());
    }

    public int H(int i) {
        return BdAsyncTask.getTaskNum(String.valueOf(i), d.eR());
    }

    public b ft() {
        return this.tF;
    }
}
