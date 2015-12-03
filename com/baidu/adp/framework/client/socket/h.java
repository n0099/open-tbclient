package com.baidu.adp.framework.client.socket;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.coder.CoderException;
import com.baidu.adp.framework.client.socket.d;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.framework.client.a<SocketMessage, SocketMessageTask> implements com.baidu.adp.framework.client.socket.link.e {
    private static /* synthetic */ int[] oS;
    private d.a oK;
    private final LinkedList<e> oL;
    private final LinkedList<e> oM;
    private final LinkedList<e> oN;
    private com.baidu.adp.framework.client.socket.link.e oO;
    private boolean oP;
    private b oQ;
    private long oR;

    static /* synthetic */ int[] eA() {
        int[] iArr = oS;
        if (iArr == null) {
            iArr = new int[SocketMessageTask.DupLicateMode.valuesCustom().length];
            try {
                iArr[SocketMessageTask.DupLicateMode.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[SocketMessageTask.DupLicateMode.REMOVE_ALL.ordinal()] = 4;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[SocketMessageTask.DupLicateMode.REMOVE_ME.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[SocketMessageTask.DupLicateMode.REMOVE_WAITING.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            oS = iArr;
        }
        return iArr;
    }

    public h(MessageManager messageManager) {
        super(messageManager);
        this.oK = null;
        this.oL = new LinkedList<>();
        this.oM = new LinkedList<>();
        this.oN = new LinkedList<>();
        this.oO = null;
        this.oP = true;
        this.oQ = null;
        this.oR = 0L;
        BdSocketLinkService.setConnStateCallBack(this);
        this.oK = new i(this);
    }

    public boolean a(SocketMessage socketMessage) {
        if (socketMessage != null && (socketMessage instanceof a)) {
            a aVar = (a) socketMessage;
            if (c.a(this.oM, aVar, socketMessage.getCmd()) || c.a(this.oL, aVar, socketMessage.getCmd()) || c.a(this.oN, aVar, socketMessage.getCmd())) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b
    /* renamed from: a */
    public void sendMessage(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        com.baidu.adp.lib.util.k.je();
        if (socketMessage != null && socketMessageTask != null) {
            if (a(socketMessage, socketMessageTask.fd())) {
                k.a("queue", socketMessage, 0, "sendMessage", j.pt, "duplicate message be removed");
                return;
            }
            e eVar = new e(socketMessage, socketMessageTask, this);
            if (BdSocketLinkService.hasAbsoluteClose()) {
                k.a("queue", socketMessage, 0, "sendMessage", j.pC, "user manual close socket");
                eVar.z(j.pC);
            } else if (!BdSocketLinkService.isAvailable()) {
                k.a("queue", socketMessage, 0, "sendMessage", j.ps, "isManualBlock message be removed");
                eVar.z(j.ps);
            } else {
                k.a("queue", socketMessage, 0, "sendMessage", "socketclient: send message");
                c.a(eVar, this.oM);
                eu();
            }
        }
    }

    private boolean a(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        if (socketMessage != null) {
            int cmd = socketMessage.getCmd();
            switch (eA()[dupLicateMode.ordinal()]) {
                case 2:
                    if (c.b(this.oM, cmd) || c.b(this.oL, cmd) || c.b(this.oN, cmd)) {
                        return true;
                    }
                    break;
                case 3:
                    c.c(this.oM, cmd);
                    break;
                case 4:
                    c.c(this.oM, cmd);
                    c.c(this.oL, cmd);
                    c.c(this.oN, cmd);
                    break;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(d.b bVar) {
        if (bVar != null) {
            if (bVar.oy != null) {
                a(bVar.oy, j.oX, null);
                return;
            }
            SocketResponsedMessage socketResponsedMessage = bVar.ox;
            if (socketResponsedMessage != null) {
                k.a("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", "unpack succ");
                b(socketResponsedMessage);
            }
        }
    }

    public void b(e eVar) {
        if (eVar != null && eVar.eo() && eVar.er() < eVar.dZ()) {
            c.a(this.oL, this.oN, eVar);
            if (this.oQ != null) {
                this.oQ.b(true, "timeout seq = " + eVar.en());
            }
            k.a("queue", eVar.ek(), eVar.en(), "onSendTimeOut", j.pw, String.valueOf(eVar.er()));
            return;
        }
        e(eVar);
        a(eVar, j.pl, null);
        eu();
    }

    public void a(int i, e eVar) {
        int i2;
        if (i == 2) {
            if (eVar.ei() != null) {
                i2 = eVar.ei().getErrorCode();
            } else {
                i2 = j.pg;
            }
        } else {
            i2 = j.po;
        }
        String B = j.B(i2);
        e(eVar);
        a(eVar, i2, B);
    }

    public void c(e eVar) {
    }

    public void d(e eVar) {
        if (eVar != null) {
            if (eVar.ej()) {
                eVar.es();
                c.a(this.oM, this.oL, eVar);
                return;
            }
            c.b(eVar, this.oM);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void a(e eVar, int i, String str) {
        SocketResponsedMessage socketResponsedMessage;
        if (eVar != null && eVar.ek() != null) {
            int cmd = eVar.ek().getCmd();
            int en = eVar.en();
            k.a("queue", eVar.ek(), en, "onMessageSendFail", i, String.valueOf(str) + " retryTime-" + eVar.er());
            SocketMessageTask el = eVar != null ? eVar.el() : null;
            SocketMessageTask socketMessageTask = el == null ? (SocketMessageTask) this.od.findTask(cmd) : el;
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
                if (socketResponsedMessage == null) {
                    socketResponsedMessage.setError(i);
                    if (str == null) {
                        socketResponsedMessage.setErrorString(j.B(i));
                    } else {
                        socketResponsedMessage.setErrorString(str);
                    }
                    socketResponsedMessage.setOrginalMessage(eVar.ek());
                    k.a("queue", eVar.ek(), en, "onMessageSendFail", "onMessageSendFail class = " + socketResponsedMessage.getClass().getName());
                    this.od.dispatchResponsedMessage(socketResponsedMessage);
                    return;
                }
                return;
            }
            socketResponsedMessage = null;
            if (socketResponsedMessage == null) {
            }
        }
    }

    private void eu() {
        e d = c.d(this.oM);
        if (d != null) {
            if (BdSocketLinkService.isClose()) {
                k.a("queue", d.ek(), 0, "sendNext", j.pu, "");
                BdSocketLinkService.startService(false, "send message");
            } else if (!this.oP || d.getPriority() <= -3) {
                BdSocketLinkService.sendMessage(d);
            }
        }
    }

    private void b(SocketResponsedMessage socketResponsedMessage) {
        this.od.dispatchResponsedMessage(socketResponsedMessage);
    }

    private void e(e eVar) {
        if (eVar != null) {
            eVar.onRemove();
            c.b(eVar, this.oL);
            c.b(eVar, this.oM);
            c.b(eVar, this.oN);
        }
    }

    private void h(LinkedList<e> linkedList) {
        while (true) {
            e e = c.e(linkedList);
            if (e != null) {
                e.onRemove();
                a(e, j.pp, null);
            } else {
                return;
            }
        }
    }

    public void ev() {
        h(this.oL);
        h(this.oM);
        h(this.oN);
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public boolean k(int i, String str) {
        if (this.oO != null) {
            this.oO.k(i, str);
        }
        if (this.oQ != null) {
            this.oQ.dW();
        }
        if (!com.baidu.adp.lib.util.k.jg() || c.f(this.oN) || c.f(this.oM) || c.f(this.oL) || !BdSocketLinkService.isAvailable()) {
            ev();
            return false;
        }
        c.g(this.oL);
        c.a(this.oM, this.oN);
        c.a(this.oM, this.oL);
        while (true) {
            e c = c.c(this.oM);
            if (c == null) {
                break;
            }
            c.onRemove();
            a(c, j.pp, null);
        }
        if (c.b(this.oM) > 0) {
            k.a("queue", 0, 0, "onClose", j.px, "have retry message, MessageQueue:reconnect");
            BdSocketLinkService.startService(false, "have retry message");
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void b(Map<String, String> map) {
        g.et().a(map);
        if (this.oQ != null) {
            this.oQ.dX();
        }
        this.oP = true;
        k.a("queue", 0, 0, "onConnected", j.pB, "Queue blocked");
        if (this.oO != null) {
            this.oO.b(map);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void s(byte[] bArr) {
        if (bArr != null) {
            this.oR = System.currentTimeMillis();
            try {
                com.baidu.adp.framework.client.socket.coder.c u = com.baidu.adp.framework.client.socket.coder.b.eK().u(bArr);
                int eH = u.pR.eH();
                int eJ = u.pR.eJ();
                k.a("queue", eH, eJ, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
                e d = d(eH, eJ);
                if (this.oQ != null) {
                    if (u.pR.eH() == this.oQ.getCmd() && c.a(this.oM, this.oN)) {
                        eu();
                    }
                    this.oQ.dX();
                }
                if (eJ == 0 || (d != null && d.getCmd() == eH)) {
                    new d(u, d, this.oK, eJ).execute(new String[0]);
                } else if (d != null) {
                    a(d, j.pD, null);
                }
                if (this.oO != null) {
                    this.oO.s(bArr);
                }
            } catch (CoderException e) {
                k.a("queue", 0, 0, "onBinaryMesssage", j.ph, "onBinaryMesssage decodeHeader error");
            }
        }
    }

    private e d(int i, int i2) {
        e eVar = null;
        if (i2 != 0) {
            e a = c.a(i2, this.oL);
            if (a == null && (a = c.a(i2, this.oN)) == null) {
                eVar = c.a(i2, this.oM);
                if (eVar == null) {
                    k.a("queue", i, i2, "findSenderData", j.pz, "original message removed , responsedMessage not dispatchMessage");
                }
            } else {
                eVar = a;
            }
            k.a("queue", i, i2, "findSenderData", j.py, "received ack message");
        }
        return eVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
        eu();
        if (this.oO != null) {
            this.oO.a(cVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void I(String str) {
        if (this.oO != null) {
            this.oO.I(str);
        }
    }

    public void a(com.baidu.adp.framework.client.socket.link.e eVar) {
        this.oO = eVar;
    }

    public void ew() {
        boolean z = this.oP;
        this.oP = false;
        k.a("queue", 0, 0, "unBlockMessageQueue", j.pv, "Queue block has release");
        if (z) {
            eu();
        }
    }

    public void a(b bVar) {
        this.oQ = bVar;
    }

    public boolean isValid() {
        return BdSocketLinkService.isOpen() && !this.oP && BdSocketLinkService.isAvailable();
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        removeMessage(0, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        c.b(this.oL, i, bdUniqueId);
        c.b(this.oM, i, bdUniqueId);
        c.b(this.oN, i, bdUniqueId);
    }

    public LinkedList<SocketMessage> a(BdUniqueId bdUniqueId) {
        return null;
    }

    @Override // com.baidu.adp.framework.b
    public LinkedList<SocketMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return null;
    }

    public boolean a(int i, BdUniqueId bdUniqueId) {
        return c.a(this.oM, i, bdUniqueId) || c.a(this.oL, i, bdUniqueId) || c.a(this.oN, i, bdUniqueId);
    }

    public long ex() {
        return this.oR;
    }

    public int ey() {
        return BdAsyncTask.getTaskNum(d.dY());
    }

    public int A(int i) {
        return BdAsyncTask.getTaskNum(String.valueOf(i), d.dY());
    }

    public b ez() {
        return this.oQ;
    }
}
