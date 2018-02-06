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
    private d.a acP;
    private final LinkedList<e> acQ;
    private final LinkedList<e> acR;
    private final LinkedList<e> acS;
    private com.baidu.adp.framework.client.socket.link.a acT;
    private boolean acU;
    private b acV;
    private long acW;
    private int acX;

    public g(MessageManager messageManager) {
        super(messageManager);
        this.acP = null;
        this.acQ = new LinkedList<>();
        this.acR = new LinkedList<>();
        this.acS = new LinkedList<>();
        this.acT = null;
        this.acU = true;
        this.acV = null;
        this.acW = 0L;
        this.acX = 0;
        BdSocketLinkService.setConnStateCallBack(this);
        this.acP = new d.a() { // from class: com.baidu.adp.framework.client.socket.g.1
            @Override // com.baidu.adp.framework.client.socket.d.a
            public void a(d.b bVar) {
                g.this.b(bVar);
            }
        };
    }

    public boolean a(SocketMessage socketMessage) {
        if (socketMessage != null && (socketMessage instanceof a)) {
            a aVar = (a) socketMessage;
            if (c.a(this.acR, aVar, socketMessage.getCmd()) || c.a(this.acQ, aVar, socketMessage.getCmd()) || c.a(this.acS, aVar, socketMessage.getCmd())) {
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
                i.a("queue", socketMessage, 0, "sendMessage", h.adx, "duplicate message be removed");
                return;
            }
            e eVar = new e(socketMessage, socketMessageTask, this);
            if (BdSocketLinkService.hasAbsoluteClose()) {
                i.a("queue", socketMessage, 0, "sendMessage", h.adG, "user manual close socket");
                eVar.cF(h.adG);
            } else if (!BdSocketLinkService.isAvailable()) {
                i.a("queue", socketMessage, 0, "sendMessage", h.adw, "isManualBlock message be removed");
                eVar.cF(h.adw);
            } else {
                i.a("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                c.a(eVar, this.acR);
                kv();
            }
        }
    }

    private boolean a(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        if (socketMessage != null) {
            int cmd = socketMessage.getCmd();
            switch (dupLicateMode) {
                case REMOVE_ALL:
                    c.c(this.acR, cmd);
                    c.c(this.acQ, cmd);
                    c.c(this.acS, cmd);
                    break;
                case REMOVE_WAITING:
                    c.c(this.acR, cmd);
                    break;
                case REMOVE_ME:
                    if (c.b(this.acR, cmd) || c.b(this.acQ, cmd) || c.b(this.acS, cmd)) {
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
            if (bVar.acC != null) {
                a(bVar.acC, h.ade, null);
                return;
            }
            SocketResponsedMessage socketResponsedMessage = bVar.acB;
            if (socketResponsedMessage != null) {
                i.a("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
                b(socketResponsedMessage);
            }
        }
    }

    public void b(e eVar) {
        if (eVar != null && eVar.kp() && eVar.ks() < eVar.ka()) {
            c.a(this.acQ, this.acS, eVar);
            if (this.acV != null) {
                this.acV.c(true, "timeout seq = " + eVar.getSequenceId());
            }
            i.a("queue", eVar.km(), eVar.getSequenceId(), "onSendTimeOut", h.adA, String.valueOf(eVar.ks()));
            return;
        }
        e(eVar);
        a(eVar, h.adr, null);
        kv();
    }

    public void a(int i, e eVar) {
        int i2;
        if (i == 2) {
            if (eVar.kk() != null) {
                i2 = eVar.kk().getErrorCode();
            } else {
                i2 = h.adn;
            }
        } else {
            i2 = h.ads;
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
                c.a(this.acR, this.acQ, eVar);
                return;
            }
            c.b(eVar, this.acR);
        }
    }

    protected void a(e eVar, int i, String str) {
        SocketResponsedMessage socketResponsedMessage = null;
        if (eVar != null && eVar.km() != null) {
            int cmd = eVar.km().getCmd();
            int sequenceId = eVar.getSequenceId();
            i.a("queue", eVar.km(), sequenceId, "onMessageSendFail", i, str + " retryTime-" + eVar.ks());
            SocketMessageTask kn = eVar != null ? eVar.kn() : null;
            SocketMessageTask socketMessageTask = kn == null ? (SocketMessageTask) this.acl.findTask(cmd) : kn;
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
                this.acl.dispatchResponsedMessage(socketResponsedMessage);
            }
        }
    }

    private void kv() {
        e e = c.e(this.acR);
        if (e != null) {
            if (BdSocketLinkService.isClose()) {
                i.a("queue", e.km(), 0, "sendNext", h.ady, "");
                BdSocketLinkService.startService(false, "send message");
            } else if (!this.acU || e.getPriority() <= -3) {
                BdSocketLinkService.sendMessage(e);
            }
        }
    }

    private void b(SocketResponsedMessage socketResponsedMessage) {
        this.acl.dispatchResponsedMessage(socketResponsedMessage);
    }

    private void e(e eVar) {
        if (eVar != null) {
            eVar.kg();
            c.b(eVar, this.acQ);
            c.b(eVar, this.acR);
            c.b(eVar, this.acS);
        }
    }

    private void i(LinkedList<e> linkedList) {
        while (true) {
            e f = c.f(linkedList);
            if (f != null) {
                f.kg();
                a(f, h.adt, null);
            } else {
                return;
            }
        }
    }

    public void kw() {
        i(this.acQ);
        i(this.acR);
        i(this.acS);
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public boolean d(int i, String str) {
        if (this.acT != null) {
            this.acT.d(i, str);
        }
        if (this.acV != null) {
            this.acV.jX();
        }
        if (!l.pa() || c.g(this.acS) || c.g(this.acR) || c.g(this.acQ) || !BdSocketLinkService.isAvailable()) {
            kw();
            return false;
        }
        c.h(this.acQ);
        c.a(this.acR, this.acS);
        c.a(this.acR, this.acQ);
        while (true) {
            e d = c.d(this.acR);
            if (d == null) {
                break;
            }
            d.kg();
            a(d, h.adt, null);
        }
        if (c.c(this.acR) > 0) {
            i.a("queue", 0, 0, "onClose", h.adB, "have retry message, MessageQueue:reconnect");
            BdSocketLinkService.startService(false, "have retry message");
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void d(Map<String, String> map) {
        f.ku().c(map);
        if (this.acV != null) {
            this.acV.jY();
        }
        this.acU = true;
        i.a("queue", 0, 0, "onConnected", h.adF, "Queue blocked");
        if (this.acT != null) {
            this.acT.d(map);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void a(k.a aVar) {
        byte[] bArr;
        if (aVar != null && (bArr = aVar.aoh) != null) {
            this.acW = System.currentTimeMillis();
            try {
                com.baidu.adp.framework.client.socket.coder.c e = com.baidu.adp.framework.client.socket.coder.b.kN().e(bArr);
                this.acX = 0;
                int kI = e.aea.kI();
                int kK = e.aea.kK();
                i.a("queue", kI, kK, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
                e ao = ao(kI, kK);
                if (ao != null) {
                    ao.acL = aVar.acL;
                    ao.acM = aVar.acM;
                }
                if (this.acV != null) {
                    if (e.aea.kI() == this.acV.getCmd() && c.a(this.acR, this.acS)) {
                        kv();
                    }
                    this.acV.jY();
                }
                if (kK == 0 || (ao != null && ao.getCmd() == kI)) {
                    new d(e, ao, this.acP, kK).execute(new String[0]);
                } else if (ao != null) {
                    a(ao, h.adH, null);
                }
                if (this.acT != null) {
                    this.acT.a(aVar);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2000986));
            } catch (CoderException e2) {
                int maxAlertCount = com.baidu.adp.lib.stats.switchs.a.ob().getMaxAlertCount("alert_protobuf", 2);
                int i = this.acX + 1;
                this.acX = i;
                if (i >= maxAlertCount) {
                    BdStatisticsManager.getInstance().alert("alert_protobuf", "protbuf");
                }
                i.a("queue", 0, 0, "onBinaryMesssage", h.ado, "onBinaryMesssage decodeHeader error");
            }
        }
    }

    private e ao(int i, int i2) {
        e eVar = null;
        if (i2 != 0) {
            e a = c.a(i2, this.acQ);
            if (a == null && (a = c.a(i2, this.acS)) == null) {
                eVar = c.a(i2, this.acR);
                if (eVar == null) {
                    i.a("queue", i, i2, "findSenderData", h.adD, "original message removed , responsedMessage not dispatchMessage");
                }
            } else {
                eVar = a;
            }
            i.a("queue", i, i2, "findSenderData", h.adC, "received ack message");
        }
        return eVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
        kv();
        if (this.acT != null) {
            this.acT.a(cVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void J(String str) {
        if (this.acT != null) {
            this.acT.J(str);
        }
    }

    public void a(com.baidu.adp.framework.client.socket.link.a aVar) {
        this.acT = aVar;
    }

    public void kx() {
        boolean z = this.acU;
        this.acU = false;
        i.a("queue", 0, 0, "unBlockMessageQueue", h.adz, "Queue block has release");
        if (z) {
            kv();
        }
    }

    public void a(b bVar) {
        this.acV = bVar;
    }

    public boolean isValid() {
        return BdSocketLinkService.isOpen() && !this.acU && BdSocketLinkService.isAvailable();
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        removeMessage(0, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        c.b(this.acQ, i, bdUniqueId);
        c.b(this.acR, i, bdUniqueId);
        c.b(this.acS, i, bdUniqueId);
    }

    public LinkedList<SocketMessage> a(BdUniqueId bdUniqueId) {
        return null;
    }

    @Override // com.baidu.adp.framework.b
    public LinkedList<SocketMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return null;
    }

    public boolean a(int i, BdUniqueId bdUniqueId) {
        return c.a(this.acR, i, bdUniqueId) || c.a(this.acQ, i, bdUniqueId) || c.a(this.acS, i, bdUniqueId);
    }

    public long ky() {
        return this.acW;
    }

    public int kz() {
        return BdAsyncTask.getTaskNum(d.jZ());
    }

    public int cG(int i) {
        return BdAsyncTask.getTaskNum(String.valueOf(i), d.jZ());
    }

    public b kA() {
        return this.acV;
    }
}
