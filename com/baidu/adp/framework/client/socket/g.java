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
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.webSocket.k;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.framework.client.a<SocketMessage, SocketMessageTask> implements com.baidu.adp.framework.client.socket.link.a {
    private d.a of;
    private final LinkedList<e> og;
    private final LinkedList<e> oh;
    private final LinkedList<e> oi;
    private com.baidu.adp.framework.client.socket.link.a oj;
    private boolean ol;
    private b om;
    private long oo;
    private int oq;

    public g(MessageManager messageManager) {
        super(messageManager);
        this.of = null;
        this.og = new LinkedList<>();
        this.oh = new LinkedList<>();
        this.oi = new LinkedList<>();
        this.oj = null;
        this.ol = true;
        this.om = null;
        this.oo = 0L;
        this.oq = 0;
        BdSocketLinkService.setConnStateCallBack(this);
        this.of = new d.a() { // from class: com.baidu.adp.framework.client.socket.g.1
            @Override // com.baidu.adp.framework.client.socket.d.a
            public void a(d.b bVar) {
                g.this.b(bVar);
            }
        };
    }

    public boolean a(SocketMessage socketMessage) {
        if (socketMessage != null && (socketMessage instanceof a)) {
            a aVar = (a) socketMessage;
            if (c.a(this.oh, aVar, socketMessage.getCmd()) || c.a(this.og, aVar, socketMessage.getCmd()) || c.a(this.oi, aVar, socketMessage.getCmd())) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b
    public void a(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        k.hx();
        if (socketMessage != null && socketMessageTask != null) {
            if (a(socketMessage, socketMessageTask.dC())) {
                i.a("queue", socketMessage, 0, "sendMessage", h.oQ, "duplicate message be removed");
                return;
            }
            e eVar = new e(socketMessage, socketMessageTask, this);
            if (BdSocketLinkService.hasAbsoluteClose()) {
                i.a("queue", socketMessage, 0, "sendMessage", h.oZ, "user manual close socket");
                eVar.M(h.oZ);
            } else if (!BdSocketLinkService.isAvailable()) {
                i.a("queue", socketMessage, 0, "sendMessage", h.oP, "isManualBlock message be removed");
                eVar.M(h.oP);
            } else {
                i.a("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                c.a(eVar, this.oh);
                cR();
            }
        }
    }

    private boolean a(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        if (socketMessage != null) {
            int cmd = socketMessage.getCmd();
            switch (dupLicateMode) {
                case REMOVE_ALL:
                    c.c(this.oh, cmd);
                    c.c(this.og, cmd);
                    c.c(this.oi, cmd);
                    break;
                case REMOVE_WAITING:
                    c.c(this.oh, cmd);
                    break;
                case REMOVE_ME:
                    if (c.b(this.oh, cmd) || c.b(this.og, cmd) || c.b(this.oi, cmd)) {
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
            if (bVar.nR != null) {
                a(bVar.nR, h.ox, null);
                return;
            }
            SocketResponsedMessage socketResponsedMessage = bVar.nQ;
            if (socketResponsedMessage != null) {
                i.a("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
                b(socketResponsedMessage);
            }
        }
    }

    public void b(e eVar) {
        if (eVar != null && eVar.cL() && eVar.cO() < eVar.cv()) {
            c.a(this.og, this.oi, eVar);
            if (this.om != null) {
                this.om.c(true, "timeout seq = " + eVar.cK());
            }
            i.a("queue", eVar.cH(), eVar.cK(), "onSendTimeOut", h.oT, String.valueOf(eVar.cO()));
            return;
        }
        e(eVar);
        a(eVar, h.oK, null);
        cR();
    }

    public void a(int i, e eVar) {
        int i2;
        if (i == 2) {
            if (eVar.cF() != null) {
                i2 = eVar.cF().getErrorCode();
            } else {
                i2 = h.oG;
            }
        } else {
            i2 = h.oL;
        }
        String O = h.O(i2);
        e(eVar);
        a(eVar, i2, O);
    }

    public void c(e eVar) {
    }

    public void d(e eVar) {
        if (eVar != null) {
            if (eVar.cG()) {
                eVar.cP();
                c.a(this.oh, this.og, eVar);
                return;
            }
            c.b(eVar, this.oh);
        }
    }

    protected void a(e eVar, int i, String str) {
        SocketResponsedMessage socketResponsedMessage = null;
        if (eVar != null && eVar.cH() != null) {
            int cmd = eVar.cH().getCmd();
            int cK = eVar.cK();
            i.a("queue", eVar.cH(), cK, "onMessageSendFail", i, str + " retryTime-" + eVar.cO());
            SocketMessageTask cI = eVar != null ? eVar.cI() : null;
            SocketMessageTask socketMessageTask = cI == null ? (SocketMessageTask) this.nA.findTask(cmd) : cI;
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
                    socketResponsedMessage.setErrorString(h.O(i));
                } else {
                    socketResponsedMessage.setErrorString(str);
                }
                socketResponsedMessage.setOrginalMessage(eVar.cH());
                i.a("queue", eVar.cH(), cK, "onMessageSendFail", i, "onMessageSendFail class = " + socketResponsedMessage.getClass().getName());
                this.nA.dispatchResponsedMessage(socketResponsedMessage);
            }
        }
    }

    private void cR() {
        e d = c.d(this.oh);
        if (d != null) {
            if (BdSocketLinkService.isClose()) {
                i.a("queue", d.cH(), 0, "sendNext", h.oR, "");
                BdSocketLinkService.startService(false, "send message");
            } else if (!this.ol || d.getPriority() <= -3) {
                BdSocketLinkService.sendMessage(d);
            }
        }
    }

    private void b(SocketResponsedMessage socketResponsedMessage) {
        this.nA.dispatchResponsedMessage(socketResponsedMessage);
    }

    private void e(e eVar) {
        if (eVar != null) {
            eVar.cB();
            c.b(eVar, this.og);
            c.b(eVar, this.oh);
            c.b(eVar, this.oi);
        }
    }

    private void h(LinkedList<e> linkedList) {
        while (true) {
            e e = c.e(linkedList);
            if (e != null) {
                e.cB();
                a(e, h.oM, null);
            } else {
                return;
            }
        }
    }

    public void cS() {
        h(this.og);
        h(this.oh);
        h(this.oi);
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public boolean d(int i, String str) {
        if (this.oj != null) {
            this.oj.d(i, str);
        }
        if (this.om != null) {
            this.om.cs();
        }
        if (!k.hz() || c.f(this.oi) || c.f(this.oh) || c.f(this.og) || !BdSocketLinkService.isAvailable()) {
            cS();
            return false;
        }
        c.g(this.og);
        c.a(this.oh, this.oi);
        c.a(this.oh, this.og);
        while (true) {
            e c = c.c(this.oh);
            if (c == null) {
                break;
            }
            c.cB();
            a(c, h.oM, null);
        }
        if (c.b(this.oh) > 0) {
            i.a("queue", 0, 0, "onClose", h.oU, "have retry message, MessageQueue:reconnect");
            BdSocketLinkService.startService(false, "have retry message");
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void d(Map<String, String> map) {
        f.cQ().c(map);
        if (this.om != null) {
            this.om.ct();
        }
        this.ol = true;
        i.a("queue", 0, 0, "onConnected", h.oY, "Queue blocked");
        if (this.oj != null) {
            this.oj.d(map);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void a(k.a aVar) {
        byte[] bArr;
        if (aVar != null && (bArr = aVar.zU) != null) {
            this.oo = System.currentTimeMillis();
            try {
                com.baidu.adp.framework.client.socket.coder.c e = com.baidu.adp.framework.client.socket.coder.b.dj().e(bArr);
                this.oq = 0;
                int de = e.pz.de();
                int dg = e.pz.dg();
                i.a("queue", de, dg, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
                e n = n(de, dg);
                if (n != null) {
                    n.ob = aVar.ob;
                    n.oc = aVar.oc;
                }
                if (this.om != null) {
                    if (e.pz.de() == this.om.getCmd() && c.a(this.oh, this.oi)) {
                        cR();
                    }
                    this.om.ct();
                }
                if (dg == 0 || (n != null && n.getCmd() == de)) {
                    new d(e, n, this.of, dg).execute(new String[0]);
                } else if (n != null) {
                    a(n, h.pa, null);
                }
                if (this.oj != null) {
                    this.oj.a(aVar);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2000986));
            } catch (CoderException e2) {
                int maxAlertCount = com.baidu.adp.lib.stats.switchs.a.gA().getMaxAlertCount("alert_protobuf", 2);
                int i = this.oq + 1;
                this.oq = i;
                if (i >= maxAlertCount) {
                    BdStatisticsManager.getInstance().alert("alert_protobuf", "protbuf");
                }
                i.a("queue", 0, 0, "onBinaryMesssage", h.oH, "onBinaryMesssage decodeHeader error");
            }
        }
    }

    private e n(int i, int i2) {
        e eVar = null;
        if (i2 != 0) {
            e a = c.a(i2, this.og);
            if (a == null && (a = c.a(i2, this.oi)) == null) {
                eVar = c.a(i2, this.oh);
                if (eVar == null) {
                    i.a("queue", i, i2, "findSenderData", h.oW, "original message removed , responsedMessage not dispatchMessage");
                }
            } else {
                eVar = a;
            }
            i.a("queue", i, i2, "findSenderData", h.oV, "received ack message");
        }
        return eVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
        cR();
        if (this.oj != null) {
            this.oj.a(cVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.a
    public void C(String str) {
        if (this.oj != null) {
            this.oj.C(str);
        }
    }

    public void a(com.baidu.adp.framework.client.socket.link.a aVar) {
        this.oj = aVar;
    }

    public void cT() {
        boolean z = this.ol;
        this.ol = false;
        i.a("queue", 0, 0, "unBlockMessageQueue", h.oS, "Queue block has release");
        if (z) {
            cR();
        }
    }

    public void a(b bVar) {
        this.om = bVar;
    }

    public boolean isValid() {
        return BdSocketLinkService.isOpen() && !this.ol && BdSocketLinkService.isAvailable();
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        removeMessage(0, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        c.b(this.og, i, bdUniqueId);
        c.b(this.oh, i, bdUniqueId);
        c.b(this.oi, i, bdUniqueId);
    }

    public LinkedList<SocketMessage> a(BdUniqueId bdUniqueId) {
        return null;
    }

    @Override // com.baidu.adp.framework.b
    public LinkedList<SocketMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return null;
    }

    public boolean a(int i, BdUniqueId bdUniqueId) {
        return c.a(this.oh, i, bdUniqueId) || c.a(this.og, i, bdUniqueId) || c.a(this.oi, i, bdUniqueId);
    }

    public long cU() {
        return this.oo;
    }

    public int cV() {
        return BdAsyncTask.getTaskNum(d.cu());
    }

    public int N(int i) {
        return BdAsyncTask.getTaskNum(String.valueOf(i), d.cu());
    }

    public b cW() {
        return this.om;
    }
}
