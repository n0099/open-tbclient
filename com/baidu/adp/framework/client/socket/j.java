package com.baidu.adp.framework.client.socket;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.coder.CoderException;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.n;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.framework.client.a<SocketMessage, SocketMessageTask> implements com.baidu.adp.framework.client.socket.link.g {
    private static /* synthetic */ int[] oR;
    private e oJ;
    private final LinkedList<g> oK;
    private final LinkedList<g> oL;
    private final LinkedList<g> oM;
    private com.baidu.adp.framework.client.socket.link.g oN;
    private boolean oO;
    private b oP;
    private long oQ;

    static /* synthetic */ int[] eA() {
        int[] iArr = oR;
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
            oR = iArr;
        }
        return iArr;
    }

    public j(MessageManager messageManager) {
        super(messageManager);
        this.oJ = null;
        this.oK = new LinkedList<>();
        this.oL = new LinkedList<>();
        this.oM = new LinkedList<>();
        this.oN = null;
        this.oO = true;
        this.oP = null;
        this.oQ = 0L;
        BdSocketLinkService.setConnStateCallBack(this);
        this.oJ = new k(this);
    }

    public boolean a(SocketMessage socketMessage) {
        if (socketMessage != null && (socketMessage instanceof a)) {
            a aVar = (a) socketMessage;
            if (c.a(this.oL, aVar, socketMessage.getCmd()) || c.a(this.oK, aVar, socketMessage.getCmd()) || c.a(this.oM, aVar, socketMessage.getCmd())) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b
    /* renamed from: a */
    public void sendMessage(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        n.jk();
        if (socketMessage != null && socketMessageTask != null) {
            if (a(socketMessage, socketMessageTask.fj())) {
                m.a("queue", socketMessage, 0, "sendMessage", l.ps, "duplicate message be removed");
                return;
            }
            g gVar = new g(socketMessage, socketMessageTask, this);
            if (BdSocketLinkService.hasAbsoluteClose()) {
                m.a("queue", socketMessage, 0, "sendMessage", l.pB, "user manual close socket");
                gVar.w(l.pB);
            } else if (!BdSocketLinkService.isAvailable()) {
                m.a("queue", socketMessage, 0, "sendMessage", l.pr, "isManualBlock message be removed");
                gVar.w(l.pr);
            } else {
                m.a("queue", socketMessage, 0, "sendMessage", "socketclient: send message");
                c.a(gVar, this.oL);
                eu();
            }
        }
    }

    private boolean a(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        if (socketMessage != null) {
            int cmd = socketMessage.getCmd();
            switch (eA()[dupLicateMode.ordinal()]) {
                case 2:
                    if (c.b(this.oL, cmd) || c.b(this.oK, cmd) || c.b(this.oM, cmd)) {
                        return true;
                    }
                    break;
                case 3:
                    c.c(this.oL, cmd);
                    break;
                case 4:
                    c.c(this.oL, cmd);
                    c.c(this.oK, cmd);
                    c.c(this.oM, cmd);
                    break;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(f fVar) {
        if (fVar != null) {
            if (fVar.ox != null) {
                a(fVar.ox, l.oW, null);
                return;
            }
            SocketResponsedMessage socketResponsedMessage = fVar.ow;
            if (socketResponsedMessage != null) {
                m.a("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", "unpack succ");
                b(socketResponsedMessage);
            }
        }
    }

    public void b(g gVar) {
        if (gVar != null && gVar.eo() && gVar.er() < gVar.dY()) {
            c.a(this.oK, this.oM, gVar);
            if (this.oP != null) {
                this.oP.b(true, "timeout seq = " + gVar.en());
            }
            m.a("queue", gVar.ek(), gVar.en(), "onSendTimeOut", l.pv, String.valueOf(gVar.er()));
            return;
        }
        e(gVar);
        a(gVar, l.pj, null);
        eu();
    }

    public void a(int i, g gVar) {
        int i2;
        if (i == 2) {
            if (gVar.ei() != null) {
                i2 = gVar.ei().getErrorCode();
            } else {
                i2 = l.pf;
            }
        } else {
            i2 = l.pl;
        }
        String y = l.y(i2);
        e(gVar);
        a(gVar, i2, y);
    }

    public void c(g gVar) {
    }

    public void d(g gVar) {
        if (gVar != null) {
            if (gVar.ej()) {
                gVar.es();
                c.a(this.oL, this.oK, gVar);
                return;
            }
            c.b(gVar, this.oL);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void a(g gVar, int i, String str) {
        SocketResponsedMessage socketResponsedMessage;
        if (gVar != null && gVar.ek() != null) {
            int cmd = gVar.ek().getCmd();
            int en = gVar.en();
            m.a("queue", gVar.ek(), en, "onMessageSendFail", i, String.valueOf(str) + " retryTime-" + gVar.er());
            SocketMessageTask el = gVar != null ? gVar.el() : null;
            if (el == null) {
                el = (SocketMessageTask) this.od.findTask(cmd);
            }
            if (el != null && el.getResponsedClass() != null) {
                try {
                    socketResponsedMessage = el.getResponsedClass().newInstance();
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
                if (socketResponsedMessage == null) {
                    socketResponsedMessage.setError(i);
                    if (str == null) {
                        socketResponsedMessage.setErrorString(l.y(i));
                    } else {
                        socketResponsedMessage.setErrorString(str);
                    }
                    socketResponsedMessage.setOrginalMessage(gVar.ek());
                    m.a("queue", gVar.ek(), en, "onMessageSendFail", "onMessageSendFail class = " + socketResponsedMessage.getClass().getName());
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
        g d = c.d(this.oL);
        if (d != null) {
            if (BdSocketLinkService.isClose()) {
                m.a("queue", d.ek(), 0, "sendNext", l.pt, "");
                BdSocketLinkService.startService(false, "send message");
            } else if (!this.oO || d.getPriority() <= -3) {
                BdSocketLinkService.sendMessage(d);
            }
        }
    }

    private void b(SocketResponsedMessage socketResponsedMessage) {
        this.od.dispatchResponsedMessage(socketResponsedMessage);
    }

    private void e(g gVar) {
        if (gVar != null) {
            gVar.ee();
            c.b(gVar, this.oK);
            c.b(gVar, this.oL);
            c.b(gVar, this.oM);
        }
    }

    private void h(LinkedList<g> linkedList) {
        while (true) {
            g e = c.e(linkedList);
            if (e != null) {
                e.ee();
                a(e, l.po, null);
            } else {
                return;
            }
        }
    }

    public void ev() {
        h(this.oK);
        h(this.oL);
        h(this.oM);
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public boolean k(int i, String str) {
        if (this.oN != null) {
            this.oN.k(i, str);
        }
        if (this.oP != null) {
            this.oP.dV();
        }
        if (!n.isNetOk() || c.f(this.oM) || c.f(this.oL) || c.f(this.oK) || !BdSocketLinkService.isAvailable()) {
            ev();
            return false;
        }
        c.g(this.oK);
        c.a(this.oL, this.oM);
        c.a(this.oL, this.oK);
        while (true) {
            g c = c.c(this.oL);
            if (c == null) {
                break;
            }
            c.ee();
            a(c, l.po, null);
        }
        if (c.b(this.oL) > 0) {
            m.a("queue", 0, 0, "onClose", l.pw, "have retry message, MessageQueue:reconnect");
            BdSocketLinkService.startService(false, "have retry message");
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void c(Map<String, String> map) {
        i.et().b(map);
        if (this.oP != null) {
            this.oP.dW();
        }
        this.oO = true;
        m.a("queue", 0, 0, "onConnected", l.pA, "Queue blocked");
        if (this.oN != null) {
            this.oN.c(map);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void e(byte[] bArr) {
        if (bArr != null) {
            this.oQ = System.currentTimeMillis();
            try {
                com.baidu.adp.framework.client.socket.coder.c h = com.baidu.adp.framework.client.socket.coder.b.eK().h(bArr);
                int eH = h.pQ.eH();
                int eJ = h.pQ.eJ();
                m.a("queue", eH, eJ, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
                g b = b(eH, eJ);
                if (this.oP != null) {
                    if (h.pQ.eH() == this.oP.getCmd() && c.a(this.oL, this.oM)) {
                        eu();
                    }
                    this.oP.dW();
                }
                if (eJ == 0 || (b != null && b.getCmd() == eH)) {
                    new d(h, b, this.oJ, eJ).execute(new String[0]);
                } else if (b != null) {
                    a(b, l.pC, null);
                }
                if (this.oN != null) {
                    this.oN.e(bArr);
                }
            } catch (CoderException e) {
                m.a("queue", 0, 0, "onBinaryMesssage", l.pg, "onBinaryMesssage decodeHeader error");
            }
        }
    }

    private g b(int i, int i2) {
        g gVar = null;
        if (i2 != 0) {
            g a = c.a(i2, this.oK);
            if (a == null && (a = c.a(i2, this.oM)) == null) {
                gVar = c.a(i2, this.oL);
                if (gVar == null) {
                    m.a("queue", i, i2, "findSenderData", l.py, "original message removed , responsedMessage not dispatchMessage");
                }
            } else {
                gVar = a;
            }
            m.a("queue", i, i2, "findSenderData", l.px, "received ack message");
        }
        return gVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
        eu();
        if (this.oN != null) {
            this.oN.a(cVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void J(String str) {
        if (this.oN != null) {
            this.oN.J(str);
        }
    }

    public void a(com.baidu.adp.framework.client.socket.link.g gVar) {
        this.oN = gVar;
    }

    public void ew() {
        boolean z = this.oO;
        this.oO = false;
        m.a("queue", 0, 0, "unBlockMessageQueue", l.pu, "Queue block has release");
        if (z) {
            eu();
        }
    }

    public void a(b bVar) {
        this.oP = bVar;
    }

    public boolean isValid() {
        return BdSocketLinkService.isOpen() && !this.oO && BdSocketLinkService.isAvailable();
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        removeMessage(0, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        c.b(this.oK, i, bdUniqueId);
        c.b(this.oL, i, bdUniqueId);
        c.b(this.oM, i, bdUniqueId);
    }

    public LinkedList<SocketMessage> a(BdUniqueId bdUniqueId) {
        return null;
    }

    @Override // com.baidu.adp.framework.b
    public LinkedList<SocketMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return null;
    }

    public boolean a(int i, BdUniqueId bdUniqueId) {
        return c.a(this.oL, i, bdUniqueId) || c.a(this.oK, i, bdUniqueId) || c.a(this.oM, i, bdUniqueId);
    }

    public long ex() {
        return this.oQ;
    }

    public int ey() {
        return BdAsyncTask.getTaskNum(d.dX());
    }

    public int x(int i) {
        return BdAsyncTask.getTaskNum(String.valueOf(i), d.dX());
    }

    public b ez() {
        return this.oP;
    }
}
