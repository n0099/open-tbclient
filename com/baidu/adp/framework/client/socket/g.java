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
    private com.baidu.adp.framework.client.socket.link.a tB;
    private boolean tC;
    private b tD;
    private long tE;
    private int tF;

    /* renamed from: tv  reason: collision with root package name */
    private d.a f0tv;
    private final LinkedList<e> tw;
    private final LinkedList<e> tz;

    public g(MessageManager messageManager) {
        super(messageManager);
        this.f0tv = null;
        this.tw = new LinkedList<>();
        this.tz = new LinkedList<>();
        this.tA = new LinkedList<>();
        this.tB = null;
        this.tC = true;
        this.tD = null;
        this.tE = 0L;
        this.tF = 0;
        BdSocketLinkService.setConnStateCallBack(this);
        this.f0tv = new d.a() { // from class: com.baidu.adp.framework.client.socket.g.1
            @Override // com.baidu.adp.framework.client.socket.d.a
            public void a(d.b bVar) {
                g.this.b(bVar);
            }
        };
    }

    public boolean a(SocketMessage socketMessage) {
        if (socketMessage != null && (socketMessage instanceof a)) {
            a aVar = (a) socketMessage;
            if (c.a(this.tz, aVar, socketMessage.getCmd()) || c.a(this.tw, aVar, socketMessage.getCmd()) || c.a(this.tA, aVar, socketMessage.getCmd())) {
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
                i.a("queue", socketMessage, 0, "sendMessage", h.uf, "duplicate message be removed");
                return;
            }
            e eVar = new e(socketMessage, socketMessageTask, this);
            if (BdSocketLinkService.hasAbsoluteClose()) {
                i.a("queue", socketMessage, 0, "sendMessage", h.uq, "user manual close socket");
                eVar.G(h.uq);
            } else if (!BdSocketLinkService.isAvailable()) {
                i.a("queue", socketMessage, 0, "sendMessage", h.ue, "isManualBlock message be removed");
                eVar.G(h.ue);
            } else {
                i.a("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                c.a(eVar, this.tz);
                fn();
            }
        }
    }

    private boolean a(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        if (socketMessage != null) {
            int cmd = socketMessage.getCmd();
            switch (dupLicateMode) {
                case REMOVE_ALL:
                    c.c(this.tz, cmd);
                    c.c(this.tw, cmd);
                    c.c(this.tA, cmd);
                    break;
                case REMOVE_WAITING:
                    c.c(this.tz, cmd);
                    break;
                case REMOVE_ME:
                    if (c.b(this.tz, cmd) || c.b(this.tw, cmd) || c.b(this.tA, cmd)) {
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
            if (bVar.tg != null) {
                a(bVar.tg, h.tL, null);
                return;
            }
            SocketResponsedMessage socketResponsedMessage = bVar.tf;
            if (socketResponsedMessage != null) {
                i.a("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
                b(socketResponsedMessage);
            }
        }
    }

    public void b(e eVar) {
        if (eVar != null && eVar.fh() && eVar.fk() < eVar.eS()) {
            c.a(this.tw, this.tA, eVar);
            if (this.tD != null) {
                this.tD.c(true, "timeout seq = " + eVar.getSequenceId());
            }
            i.a("queue", eVar.fe(), eVar.getSequenceId(), "onSendTimeOut", h.ui, String.valueOf(eVar.fk()));
            return;
        }
        e(eVar);
        a(eVar, h.tY, null);
        fn();
    }

    public void a(int i, e eVar) {
        int i2;
        if (i == 2) {
            if (eVar.fc() != null) {
                i2 = eVar.fc().getErrorCode();
            } else {
                i2 = h.tU;
            }
        } else {
            i2 = h.tZ;
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
                c.a(this.tz, this.tw, eVar);
                return;
            }
            c.b(eVar, this.tz);
        }
    }

    protected void a(e eVar, int i, String str) {
        SocketResponsedMessage socketResponsedMessage = null;
        if (eVar != null && eVar.fe() != null) {
            int cmd = eVar.fe().getCmd();
            int sequenceId = eVar.getSequenceId();
            i.a("queue", eVar.fe(), sequenceId, "onMessageSendFail", i, str + " retryTime-" + eVar.fk());
            SocketMessageTask ff = eVar != null ? eVar.ff() : null;
            SocketMessageTask socketMessageTask = ff == null ? (SocketMessageTask) this.sO.findTask(cmd) : ff;
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
                this.sO.dispatchResponsedMessage(socketResponsedMessage);
            }
        }
    }

    private void fn() {
        e e = c.e(this.tz);
        if (e != null) {
            if (BdSocketLinkService.isClose()) {
                i.a("queue", e.fe(), 0, "sendNext", h.ug, "");
                BdSocketLinkService.startService(false, "send message");
            } else if (!this.tC || e.getPriority() <= -3) {
                BdSocketLinkService.sendMessage(e);
            }
        }
    }

    private void b(SocketResponsedMessage socketResponsedMessage) {
        this.sO.dispatchResponsedMessage(socketResponsedMessage);
    }

    private void e(e eVar) {
        if (eVar != null) {
            eVar.eY();
            c.b(eVar, this.tw);
            c.b(eVar, this.tz);
            c.b(eVar, this.tA);
        }
    }

    private void i(LinkedList<e> linkedList) {
        while (true) {
            e f = c.f(linkedList);
            if (f != null) {
                f.eY();
                a(f, h.ub, null);
            } else {
                return;
            }
        }
    }

    public void fo() {
        i(this.tw);
        i(this.tz);
        i(this.tA);
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public boolean d(int i, String str) {
        if (this.tB != null) {
            this.tB.d(i, str);
        }
        if (this.tD != null) {
            this.tD.eP();
        }
        if (!l.jU() || c.g(this.tA) || c.g(this.tz) || c.g(this.tw) || !BdSocketLinkService.isAvailable()) {
            fo();
            return false;
        }
        c.h(this.tw);
        c.a(this.tz, this.tA);
        c.a(this.tz, this.tw);
        while (true) {
            e d = c.d(this.tz);
            if (d == null) {
                break;
            }
            d.eY();
            a(d, h.ub, null);
        }
        if (c.c(this.tz) > 0) {
            i.a("queue", 0, 0, "onClose", h.uj, "have retry message, MessageQueue:reconnect");
            BdSocketLinkService.startService(false, "have retry message");
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void h(Map<String, String> map) {
        f.fm().g(map);
        if (this.tD != null) {
            this.tD.eQ();
        }
        this.tC = true;
        i.a("queue", 0, 0, "onConnected", h.uo, "Queue blocked");
        if (this.tB != null) {
            this.tB.h(map);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void a(k.a aVar) {
        byte[] bArr;
        if (aVar != null && (bArr = aVar.EN) != null) {
            this.tE = System.currentTimeMillis();
            try {
                com.baidu.adp.framework.client.socket.coder.c i = com.baidu.adp.framework.client.socket.coder.b.fG().i(bArr);
                this.tF = 0;
                int fB = i.uK.fB();
                int fD = i.uK.fD();
                i.a("queue", fB, fD, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
                e n = n(fB, fD);
                if (n != null) {
                    n.tr = aVar.tr;
                    n.ts = aVar.ts;
                }
                if (this.tD != null) {
                    if (i.uK.fB() == this.tD.getCmd() && c.a(this.tz, this.tA)) {
                        fn();
                    }
                    this.tD.eQ();
                }
                if (fD == 0 || (n != null && n.getCmd() == fB)) {
                    new d(i, n, this.f0tv, fD).execute(new String[0]);
                } else if (n != null) {
                    a(n, h.ur, null);
                }
                if (this.tB != null) {
                    this.tB.a(aVar);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2000986));
            } catch (CoderException e) {
                int maxAlertCount = com.baidu.adp.lib.stats.switchs.a.iV().getMaxAlertCount("alert_protobuf", 2);
                int i2 = this.tF + 1;
                this.tF = i2;
                if (i2 >= maxAlertCount) {
                    BdStatisticsManager.getInstance().alert("alert_protobuf", "protbuf");
                }
                i.a("queue", 0, 0, "onBinaryMesssage", h.tV, "onBinaryMesssage decodeHeader error");
            }
        }
    }

    private e n(int i, int i2) {
        e eVar = null;
        if (i2 != 0) {
            e a = c.a(i2, this.tw);
            if (a == null && (a = c.a(i2, this.tA)) == null) {
                eVar = c.a(i2, this.tz);
                if (eVar == null) {
                    i.a("queue", i, i2, "findSenderData", h.ul, "original message removed , responsedMessage not dispatchMessage");
                }
            } else {
                eVar = a;
            }
            i.a("queue", i, i2, "findSenderData", h.uk, "received ack message");
        }
        return eVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
        fn();
        if (this.tB != null) {
            this.tB.a(cVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void S(String str) {
        if (this.tB != null) {
            this.tB.S(str);
        }
    }

    public void a(com.baidu.adp.framework.client.socket.link.a aVar) {
        this.tB = aVar;
    }

    public void fp() {
        boolean z = this.tC;
        this.tC = false;
        i.a("queue", 0, 0, "unBlockMessageQueue", h.uh, "Queue block has release");
        if (z) {
            fn();
        }
    }

    public void a(b bVar) {
        this.tD = bVar;
    }

    public boolean isValid() {
        return BdSocketLinkService.isOpen() && !this.tC && BdSocketLinkService.isAvailable();
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        removeMessage(0, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        c.b(this.tw, i, bdUniqueId);
        c.b(this.tz, i, bdUniqueId);
        c.b(this.tA, i, bdUniqueId);
    }

    public LinkedList<SocketMessage> a(BdUniqueId bdUniqueId) {
        return null;
    }

    @Override // com.baidu.adp.framework.b
    public LinkedList<SocketMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return null;
    }

    public boolean a(int i, BdUniqueId bdUniqueId) {
        return c.a(this.tz, i, bdUniqueId) || c.a(this.tw, i, bdUniqueId) || c.a(this.tA, i, bdUniqueId);
    }

    public long fq() {
        return this.tE;
    }

    public int fs() {
        return BdAsyncTask.getTaskNum(d.eR());
    }

    public int H(int i) {
        return BdAsyncTask.getTaskNum(String.valueOf(i), d.eR());
    }

    public b ft() {
        return this.tD;
    }
}
