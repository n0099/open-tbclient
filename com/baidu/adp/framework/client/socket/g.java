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
    private d.a acR;
    private final LinkedList<e> acS;
    private final LinkedList<e> acT;
    private final LinkedList<e> acU;
    private com.baidu.adp.framework.client.socket.link.a acV;
    private boolean acW;
    private b acX;
    private long acY;
    private int acZ;

    public g(MessageManager messageManager) {
        super(messageManager);
        this.acR = null;
        this.acS = new LinkedList<>();
        this.acT = new LinkedList<>();
        this.acU = new LinkedList<>();
        this.acV = null;
        this.acW = true;
        this.acX = null;
        this.acY = 0L;
        this.acZ = 0;
        BdSocketLinkService.setConnStateCallBack(this);
        this.acR = new d.a() { // from class: com.baidu.adp.framework.client.socket.g.1
            @Override // com.baidu.adp.framework.client.socket.d.a
            public void a(d.b bVar) {
                g.this.b(bVar);
            }
        };
    }

    public boolean a(SocketMessage socketMessage) {
        if (socketMessage != null && (socketMessage instanceof a)) {
            a aVar = (a) socketMessage;
            if (c.a(this.acT, aVar, socketMessage.getCmd()) || c.a(this.acS, aVar, socketMessage.getCmd()) || c.a(this.acU, aVar, socketMessage.getCmd())) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b
    public void a(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        l.oX();
        if (socketMessage != null && socketMessageTask != null) {
            if (a(socketMessage, socketMessageTask.lg())) {
                i.a("queue", socketMessage, 0, "sendMessage", h.adz, "duplicate message be removed");
                return;
            }
            e eVar = new e(socketMessage, socketMessageTask, this);
            if (BdSocketLinkService.hasAbsoluteClose()) {
                i.a("queue", socketMessage, 0, "sendMessage", h.adI, "user manual close socket");
                eVar.cF(h.adI);
            } else if (!BdSocketLinkService.isAvailable()) {
                i.a("queue", socketMessage, 0, "sendMessage", h.ady, "isManualBlock message be removed");
                eVar.cF(h.ady);
            } else {
                i.a("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                c.a(eVar, this.acT);
                kv();
            }
        }
    }

    private boolean a(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        if (socketMessage != null) {
            int cmd = socketMessage.getCmd();
            switch (dupLicateMode) {
                case REMOVE_ALL:
                    c.c(this.acT, cmd);
                    c.c(this.acS, cmd);
                    c.c(this.acU, cmd);
                    break;
                case REMOVE_WAITING:
                    c.c(this.acT, cmd);
                    break;
                case REMOVE_ME:
                    if (c.b(this.acT, cmd) || c.b(this.acS, cmd) || c.b(this.acU, cmd)) {
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
            if (bVar.acE != null) {
                a(bVar.acE, h.adg, null);
                return;
            }
            SocketResponsedMessage socketResponsedMessage = bVar.acD;
            if (socketResponsedMessage != null) {
                i.a("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
                b(socketResponsedMessage);
            }
        }
    }

    public void b(e eVar) {
        if (eVar != null && eVar.kp() && eVar.ks() < eVar.ka()) {
            c.a(this.acS, this.acU, eVar);
            if (this.acX != null) {
                this.acX.c(true, "timeout seq = " + eVar.getSequenceId());
            }
            i.a("queue", eVar.km(), eVar.getSequenceId(), "onSendTimeOut", h.adC, String.valueOf(eVar.ks()));
            return;
        }
        e(eVar);
        a(eVar, h.adt, null);
        kv();
    }

    public void a(int i, e eVar) {
        int i2;
        if (i == 2) {
            if (eVar.kk() != null) {
                i2 = eVar.kk().getErrorCode();
            } else {
                i2 = h.adp;
            }
        } else {
            i2 = h.adu;
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
                c.a(this.acT, this.acS, eVar);
                return;
            }
            c.b(eVar, this.acT);
        }
    }

    protected void a(e eVar, int i, String str) {
        SocketResponsedMessage socketResponsedMessage = null;
        if (eVar != null && eVar.km() != null) {
            int cmd = eVar.km().getCmd();
            int sequenceId = eVar.getSequenceId();
            i.a("queue", eVar.km(), sequenceId, "onMessageSendFail", i, str + " retryTime-" + eVar.ks());
            SocketMessageTask kn = eVar != null ? eVar.kn() : null;
            SocketMessageTask socketMessageTask = kn == null ? (SocketMessageTask) this.acn.findTask(cmd) : kn;
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
                this.acn.dispatchResponsedMessage(socketResponsedMessage);
            }
        }
    }

    private void kv() {
        e e = c.e(this.acT);
        if (e != null) {
            if (BdSocketLinkService.isClose()) {
                i.a("queue", e.km(), 0, "sendNext", h.adA, "");
                BdSocketLinkService.startService(false, "send message");
            } else if (!this.acW || e.getPriority() <= -3) {
                BdSocketLinkService.sendMessage(e);
            }
        }
    }

    private void b(SocketResponsedMessage socketResponsedMessage) {
        this.acn.dispatchResponsedMessage(socketResponsedMessage);
    }

    private void e(e eVar) {
        if (eVar != null) {
            eVar.kg();
            c.b(eVar, this.acS);
            c.b(eVar, this.acT);
            c.b(eVar, this.acU);
        }
    }

    private void i(LinkedList<e> linkedList) {
        while (true) {
            e f = c.f(linkedList);
            if (f != null) {
                f.kg();
                a(f, h.adv, null);
            } else {
                return;
            }
        }
    }

    public void kw() {
        i(this.acS);
        i(this.acT);
        i(this.acU);
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public boolean d(int i, String str) {
        if (this.acV != null) {
            this.acV.d(i, str);
        }
        if (this.acX != null) {
            this.acX.jX();
        }
        if (!l.oZ() || c.g(this.acU) || c.g(this.acT) || c.g(this.acS) || !BdSocketLinkService.isAvailable()) {
            kw();
            return false;
        }
        c.h(this.acS);
        c.a(this.acT, this.acU);
        c.a(this.acT, this.acS);
        while (true) {
            e d = c.d(this.acT);
            if (d == null) {
                break;
            }
            d.kg();
            a(d, h.adv, null);
        }
        if (c.c(this.acT) > 0) {
            i.a("queue", 0, 0, "onClose", h.adD, "have retry message, MessageQueue:reconnect");
            BdSocketLinkService.startService(false, "have retry message");
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void d(Map<String, String> map) {
        f.ku().c(map);
        if (this.acX != null) {
            this.acX.jY();
        }
        this.acW = true;
        i.a("queue", 0, 0, "onConnected", h.adH, "Queue blocked");
        if (this.acV != null) {
            this.acV.d(map);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void a(k.a aVar) {
        byte[] bArr;
        if (aVar != null && (bArr = aVar.aof) != null) {
            this.acY = System.currentTimeMillis();
            try {
                com.baidu.adp.framework.client.socket.coder.c e = com.baidu.adp.framework.client.socket.coder.b.kN().e(bArr);
                this.acZ = 0;
                int kI = e.aec.kI();
                int kK = e.aec.kK();
                i.a("queue", kI, kK, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
                e ao = ao(kI, kK);
                if (ao != null) {
                    ao.acN = aVar.acN;
                    ao.acO = aVar.acO;
                }
                if (this.acX != null) {
                    if (e.aec.kI() == this.acX.getCmd() && c.a(this.acT, this.acU)) {
                        kv();
                    }
                    this.acX.jY();
                }
                if (kK == 0 || (ao != null && ao.getCmd() == kI)) {
                    new d(e, ao, this.acR, kK).execute(new String[0]);
                } else if (ao != null) {
                    a(ao, h.adJ, null);
                }
                if (this.acV != null) {
                    this.acV.a(aVar);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2000986));
            } catch (CoderException e2) {
                int maxAlertCount = com.baidu.adp.lib.stats.switchs.a.oa().getMaxAlertCount("alert_protobuf", 2);
                int i = this.acZ + 1;
                this.acZ = i;
                if (i >= maxAlertCount) {
                    BdStatisticsManager.getInstance().alert("alert_protobuf", "protbuf");
                }
                i.a("queue", 0, 0, "onBinaryMesssage", h.adq, "onBinaryMesssage decodeHeader error");
            }
        }
    }

    private e ao(int i, int i2) {
        e eVar = null;
        if (i2 != 0) {
            e a = c.a(i2, this.acS);
            if (a == null && (a = c.a(i2, this.acU)) == null) {
                eVar = c.a(i2, this.acT);
                if (eVar == null) {
                    i.a("queue", i, i2, "findSenderData", h.adF, "original message removed , responsedMessage not dispatchMessage");
                }
            } else {
                eVar = a;
            }
            i.a("queue", i, i2, "findSenderData", h.adE, "received ack message");
        }
        return eVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
        kv();
        if (this.acV != null) {
            this.acV.a(cVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void J(String str) {
        if (this.acV != null) {
            this.acV.J(str);
        }
    }

    public void a(com.baidu.adp.framework.client.socket.link.a aVar) {
        this.acV = aVar;
    }

    public void kx() {
        boolean z = this.acW;
        this.acW = false;
        i.a("queue", 0, 0, "unBlockMessageQueue", h.adB, "Queue block has release");
        if (z) {
            kv();
        }
    }

    public void a(b bVar) {
        this.acX = bVar;
    }

    public boolean isValid() {
        return BdSocketLinkService.isOpen() && !this.acW && BdSocketLinkService.isAvailable();
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        removeMessage(0, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        c.b(this.acS, i, bdUniqueId);
        c.b(this.acT, i, bdUniqueId);
        c.b(this.acU, i, bdUniqueId);
    }

    public LinkedList<SocketMessage> a(BdUniqueId bdUniqueId) {
        return null;
    }

    @Override // com.baidu.adp.framework.b
    public LinkedList<SocketMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return null;
    }

    public boolean a(int i, BdUniqueId bdUniqueId) {
        return c.a(this.acT, i, bdUniqueId) || c.a(this.acS, i, bdUniqueId) || c.a(this.acU, i, bdUniqueId);
    }

    public long ky() {
        return this.acY;
    }

    public int kz() {
        return BdAsyncTask.getTaskNum(d.jZ());
    }

    public int cG(int i) {
        return BdAsyncTask.getTaskNum(String.valueOf(i), d.jZ());
    }

    public b kA() {
        return this.acX;
    }
}
