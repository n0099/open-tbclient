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
    private d.a acJ;
    private final LinkedList<e> acK;
    private final LinkedList<e> acL;
    private final LinkedList<e> acM;
    private com.baidu.adp.framework.client.socket.link.a acN;
    private boolean acO;
    private b acP;
    private long acQ;
    private int acR;

    public g(MessageManager messageManager) {
        super(messageManager);
        this.acJ = null;
        this.acK = new LinkedList<>();
        this.acL = new LinkedList<>();
        this.acM = new LinkedList<>();
        this.acN = null;
        this.acO = true;
        this.acP = null;
        this.acQ = 0L;
        this.acR = 0;
        BdSocketLinkService.setConnStateCallBack(this);
        this.acJ = new d.a() { // from class: com.baidu.adp.framework.client.socket.g.1
            @Override // com.baidu.adp.framework.client.socket.d.a
            public void a(d.b bVar) {
                g.this.b(bVar);
            }
        };
    }

    public boolean a(SocketMessage socketMessage) {
        if (socketMessage != null && (socketMessage instanceof a)) {
            a aVar = (a) socketMessage;
            if (c.a(this.acL, aVar, socketMessage.getCmd()) || c.a(this.acK, aVar, socketMessage.getCmd()) || c.a(this.acM, aVar, socketMessage.getCmd())) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b
    public void a(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        l.oY();
        if (socketMessage != null && socketMessageTask != null) {
            if (a(socketMessage, socketMessageTask.lg())) {
                i.a("queue", socketMessage, 0, "sendMessage", h.adr, "duplicate message be removed");
                return;
            }
            e eVar = new e(socketMessage, socketMessageTask, this);
            if (BdSocketLinkService.hasAbsoluteClose()) {
                i.a("queue", socketMessage, 0, "sendMessage", h.adA, "user manual close socket");
                eVar.cF(h.adA);
            } else if (!BdSocketLinkService.isAvailable()) {
                i.a("queue", socketMessage, 0, "sendMessage", h.adq, "isManualBlock message be removed");
                eVar.cF(h.adq);
            } else {
                i.a("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                c.a(eVar, this.acL);
                kv();
            }
        }
    }

    private boolean a(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        if (socketMessage != null) {
            int cmd = socketMessage.getCmd();
            switch (dupLicateMode) {
                case REMOVE_ALL:
                    c.c(this.acL, cmd);
                    c.c(this.acK, cmd);
                    c.c(this.acM, cmd);
                    break;
                case REMOVE_WAITING:
                    c.c(this.acL, cmd);
                    break;
                case REMOVE_ME:
                    if (c.b(this.acL, cmd) || c.b(this.acK, cmd) || c.b(this.acM, cmd)) {
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
            if (bVar.acw != null) {
                a(bVar.acw, h.acX, null);
                return;
            }
            SocketResponsedMessage socketResponsedMessage = bVar.acv;
            if (socketResponsedMessage != null) {
                i.a("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
                b(socketResponsedMessage);
            }
        }
    }

    public void b(e eVar) {
        if (eVar != null && eVar.kp() && eVar.ks() < eVar.ka()) {
            c.a(this.acK, this.acM, eVar);
            if (this.acP != null) {
                this.acP.c(true, "timeout seq = " + eVar.getSequenceId());
            }
            i.a("queue", eVar.km(), eVar.getSequenceId(), "onSendTimeOut", h.adu, String.valueOf(eVar.ks()));
            return;
        }
        e(eVar);
        a(eVar, h.adl, null);
        kv();
    }

    public void a(int i, e eVar) {
        int i2;
        if (i == 2) {
            if (eVar.kk() != null) {
                i2 = eVar.kk().getErrorCode();
            } else {
                i2 = h.adh;
            }
        } else {
            i2 = h.adm;
        }
        String cH = h.cH(i2);
        e(eVar);
        a(eVar, i2, cH);
    }

    public void c(e eVar) {
    }

    public void d(e eVar) {
        if (eVar != null) {
            if (eVar.kl()) {
                eVar.kt();
                c.a(this.acL, this.acK, eVar);
                return;
            }
            c.b(eVar, this.acL);
        }
    }

    protected void a(e eVar, int i, String str) {
        SocketResponsedMessage socketResponsedMessage = null;
        if (eVar != null && eVar.km() != null) {
            int cmd = eVar.km().getCmd();
            int sequenceId = eVar.getSequenceId();
            i.a("queue", eVar.km(), sequenceId, "onMessageSendFail", i, str + " retryTime-" + eVar.ks());
            SocketMessageTask kn = eVar != null ? eVar.kn() : null;
            SocketMessageTask socketMessageTask = kn == null ? (SocketMessageTask) this.acf.findTask(cmd) : kn;
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
                    socketResponsedMessage.setErrorString(h.cH(i));
                } else {
                    socketResponsedMessage.setErrorString(str);
                }
                socketResponsedMessage.setOrginalMessage(eVar.km());
                i.a("queue", eVar.km(), sequenceId, "onMessageSendFail", i, "onMessageSendFail class = " + socketResponsedMessage.getClass().getName());
                this.acf.dispatchResponsedMessage(socketResponsedMessage);
            }
        }
    }

    private void kv() {
        e e = c.e(this.acL);
        if (e != null) {
            if (BdSocketLinkService.isClose()) {
                i.a("queue", e.km(), 0, "sendNext", h.ads, "");
                BdSocketLinkService.startService(false, "send message");
            } else if (!this.acO || e.getPriority() <= -3) {
                BdSocketLinkService.sendMessage(e);
            }
        }
    }

    private void b(SocketResponsedMessage socketResponsedMessage) {
        this.acf.dispatchResponsedMessage(socketResponsedMessage);
    }

    private void e(e eVar) {
        if (eVar != null) {
            eVar.kg();
            c.b(eVar, this.acK);
            c.b(eVar, this.acL);
            c.b(eVar, this.acM);
        }
    }

    private void i(LinkedList<e> linkedList) {
        while (true) {
            e f = c.f(linkedList);
            if (f != null) {
                f.kg();
                a(f, h.adn, null);
            } else {
                return;
            }
        }
    }

    public void kw() {
        i(this.acK);
        i(this.acL);
        i(this.acM);
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public boolean d(int i, String str) {
        if (this.acN != null) {
            this.acN.d(i, str);
        }
        if (this.acP != null) {
            this.acP.jX();
        }
        if (!l.pa() || c.g(this.acM) || c.g(this.acL) || c.g(this.acK) || !BdSocketLinkService.isAvailable()) {
            kw();
            return false;
        }
        c.h(this.acK);
        c.a(this.acL, this.acM);
        c.a(this.acL, this.acK);
        while (true) {
            e d = c.d(this.acL);
            if (d == null) {
                break;
            }
            d.kg();
            a(d, h.adn, null);
        }
        if (c.c(this.acL) > 0) {
            i.a("queue", 0, 0, "onClose", h.adv, "have retry message, MessageQueue:reconnect");
            BdSocketLinkService.startService(false, "have retry message");
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void d(Map<String, String> map) {
        f.ku().c(map);
        if (this.acP != null) {
            this.acP.jY();
        }
        this.acO = true;
        i.a("queue", 0, 0, "onConnected", h.adz, "Queue blocked");
        if (this.acN != null) {
            this.acN.d(map);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void a(k.a aVar) {
        byte[] bArr;
        if (aVar != null && (bArr = aVar.aob) != null) {
            this.acQ = System.currentTimeMillis();
            try {
                com.baidu.adp.framework.client.socket.coder.c e = com.baidu.adp.framework.client.socket.coder.b.kN().e(bArr);
                this.acR = 0;
                int kI = e.adU.kI();
                int kK = e.adU.kK();
                i.a("queue", kI, kK, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
                e ao = ao(kI, kK);
                if (ao != null) {
                    ao.acF = aVar.acF;
                    ao.acG = aVar.acG;
                }
                if (this.acP != null) {
                    if (e.adU.kI() == this.acP.getCmd() && c.a(this.acL, this.acM)) {
                        kv();
                    }
                    this.acP.jY();
                }
                if (kK == 0 || (ao != null && ao.getCmd() == kI)) {
                    new d(e, ao, this.acJ, kK).execute(new String[0]);
                } else if (ao != null) {
                    a(ao, h.adB, null);
                }
                if (this.acN != null) {
                    this.acN.a(aVar);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2000986));
            } catch (CoderException e2) {
                int maxAlertCount = com.baidu.adp.lib.stats.switchs.a.ob().getMaxAlertCount("alert_protobuf", 2);
                int i = this.acR + 1;
                this.acR = i;
                if (i >= maxAlertCount) {
                    BdStatisticsManager.getInstance().alert("alert_protobuf", "protbuf");
                }
                i.a("queue", 0, 0, "onBinaryMesssage", h.adi, "onBinaryMesssage decodeHeader error");
            }
        }
    }

    private e ao(int i, int i2) {
        e eVar = null;
        if (i2 != 0) {
            e a = c.a(i2, this.acK);
            if (a == null && (a = c.a(i2, this.acM)) == null) {
                eVar = c.a(i2, this.acL);
                if (eVar == null) {
                    i.a("queue", i, i2, "findSenderData", h.adx, "original message removed , responsedMessage not dispatchMessage");
                }
            } else {
                eVar = a;
            }
            i.a("queue", i, i2, "findSenderData", h.adw, "received ack message");
        }
        return eVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
        kv();
        if (this.acN != null) {
            this.acN.a(cVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void J(String str) {
        if (this.acN != null) {
            this.acN.J(str);
        }
    }

    public void a(com.baidu.adp.framework.client.socket.link.a aVar) {
        this.acN = aVar;
    }

    public void kx() {
        boolean z = this.acO;
        this.acO = false;
        i.a("queue", 0, 0, "unBlockMessageQueue", h.adt, "Queue block has release");
        if (z) {
            kv();
        }
    }

    public void a(b bVar) {
        this.acP = bVar;
    }

    public boolean isValid() {
        return BdSocketLinkService.isOpen() && !this.acO && BdSocketLinkService.isAvailable();
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        removeMessage(0, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        c.b(this.acK, i, bdUniqueId);
        c.b(this.acL, i, bdUniqueId);
        c.b(this.acM, i, bdUniqueId);
    }

    public LinkedList<SocketMessage> a(BdUniqueId bdUniqueId) {
        return null;
    }

    @Override // com.baidu.adp.framework.b
    public LinkedList<SocketMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return null;
    }

    public boolean a(int i, BdUniqueId bdUniqueId) {
        return c.a(this.acL, i, bdUniqueId) || c.a(this.acK, i, bdUniqueId) || c.a(this.acM, i, bdUniqueId);
    }

    public long ky() {
        return this.acQ;
    }

    public int kz() {
        return BdAsyncTask.getTaskNum(d.jZ());
    }

    public int cG(int i) {
        return BdAsyncTask.getTaskNum(String.valueOf(i), d.jZ());
    }

    public b kA() {
        return this.acP;
    }
}
