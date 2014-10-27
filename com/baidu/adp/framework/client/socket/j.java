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
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.framework.client.a<SocketMessage, SocketMessageTask> implements com.baidu.adp.framework.client.socket.link.g {
    private static /* synthetic */ int[] br;
    private e bj;
    private final LinkedList<g> bk;
    private final LinkedList<g> bl;
    private final LinkedList<g> bm;
    private com.baidu.adp.framework.client.socket.link.g bn;
    private boolean bo;
    private b bp;
    private long bq;

    static /* synthetic */ int[] aA() {
        int[] iArr = br;
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
            br = iArr;
        }
        return iArr;
    }

    public j(MessageManager messageManager) {
        super(messageManager);
        this.bj = null;
        this.bk = new LinkedList<>();
        this.bl = new LinkedList<>();
        this.bm = new LinkedList<>();
        this.bn = null;
        this.bo = true;
        this.bp = null;
        this.bq = 0L;
        BdSocketLinkService.setConnStateCallBack(this);
        this.bj = new k(this);
    }

    public boolean a(SocketMessage socketMessage) {
        if (socketMessage != null && (socketMessage instanceof a)) {
            a aVar = (a) socketMessage;
            if (c.a(this.bl, aVar, socketMessage.getCmd()) || c.a(this.bk, aVar, socketMessage.getCmd()) || c.a(this.bm, aVar, socketMessage.getCmd())) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a
    /* renamed from: a */
    public void sendMessage(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        com.baidu.adp.lib.util.m.ft();
        if (socketMessage != null && socketMessageTask != null) {
            if (a(socketMessage, socketMessageTask.bh())) {
                m.a("queue", socketMessage, 0, "sendMessage", l.bN, "duplicate message be removed");
                return;
            }
            g gVar = new g(socketMessage, socketMessageTask, this);
            if (!BdSocketLinkService.isAvailable()) {
                m.a("queue", socketMessage, 0, "sendMessage", l.bM, "isManualBlock message be removed");
                gVar.i(l.bM);
                return;
            }
            m.a("queue", socketMessage, 0, "sendMessage", "socketclient: send message");
            c.a(gVar, this.bl);
            au();
        }
    }

    private boolean a(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        if (socketMessage != null) {
            int cmd = socketMessage.getCmd();
            switch (aA()[dupLicateMode.ordinal()]) {
                case 2:
                    if (c.b(this.bl, cmd) || c.b(this.bk, cmd) || c.b(this.bm, cmd)) {
                        return true;
                    }
                    break;
                case 3:
                    c.c(this.bl, cmd);
                    break;
                case 4:
                    c.c(this.bl, cmd);
                    c.c(this.bk, cmd);
                    c.c(this.bm, cmd);
                    break;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(f fVar) {
        if (fVar != null) {
            if (fVar.aX != null) {
                a(fVar.aX, l.bw, null);
                return;
            }
            SocketResponsedMessage socketResponsedMessage = fVar.aW;
            if (socketResponsedMessage != null) {
                m.a("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", "unpack succ");
                b(socketResponsedMessage);
            }
        }
    }

    public void b(g gVar) {
        if (gVar != null && gVar.ao() && gVar.ar() < gVar.Y()) {
            c.a(this.bk, this.bm, gVar);
            if (this.bp != null) {
                this.bp.a(true, "timeout seq = " + gVar.an());
            }
            m.a("queue", gVar.ak(), gVar.an(), "onSendTimeOut", l.bQ, String.valueOf(gVar.ar()));
            return;
        }
        e(gVar);
        a(gVar, l.bH, null);
        au();
    }

    public void a(int i, g gVar) {
        int i2;
        if (i == 2) {
            if (gVar.ai() != null) {
                i2 = gVar.ai().getErrorCode();
            } else {
                i2 = l.bD;
            }
        } else {
            i2 = l.bI;
        }
        String j = l.j(i2);
        e(gVar);
        a(gVar, i2, j);
    }

    public void c(g gVar) {
    }

    public void d(g gVar) {
        if (gVar != null) {
            if (gVar.aj()) {
                gVar.as();
                c.a(this.bl, this.bk, gVar);
                return;
            }
            c.b(gVar, this.bl);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void a(g gVar, int i, String str) {
        SocketResponsedMessage socketResponsedMessage;
        if (gVar != null && gVar.ak() != null) {
            int cmd = gVar.ak().getCmd();
            int an = gVar.an();
            m.a("queue", gVar.ak(), an, "onMessageSendFail", i, String.valueOf(str) + " retryTime-" + gVar.ar());
            SocketMessageTask al = gVar != null ? gVar.al() : null;
            if (al == null) {
                al = (SocketMessageTask) this.aH.findTask(cmd);
            }
            if (al != null && al.getResponsedClass() != null) {
                try {
                    socketResponsedMessage = al.getResponsedClass().newInstance();
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
                if (socketResponsedMessage == null) {
                    socketResponsedMessage.setError(i);
                    if (str == null) {
                        socketResponsedMessage.setErrorString(l.j(i));
                    } else {
                        socketResponsedMessage.setErrorString(str);
                    }
                    socketResponsedMessage.setOrginalMessage(gVar.ak());
                    m.a("queue", gVar.ak(), an, "onMessageSendFail", "onMessageSendFail class = " + socketResponsedMessage.getClass().getName());
                    this.aH.dispatchResponsedMessage(socketResponsedMessage);
                    return;
                }
                return;
            }
            socketResponsedMessage = null;
            if (socketResponsedMessage == null) {
            }
        }
    }

    private void au() {
        g d = c.d(this.bl);
        if (d != null) {
            if (BdSocketLinkService.isClose()) {
                m.a("queue", d.ak(), 0, "sendNext", l.bO, "");
                BdSocketLinkService.startService(false, "send message");
            } else if (!this.bo || d.getPriority() <= -3) {
                BdSocketLinkService.sendMessage(d);
            }
        }
    }

    private void b(SocketResponsedMessage socketResponsedMessage) {
        this.aH.dispatchResponsedMessage(socketResponsedMessage);
    }

    private void e(g gVar) {
        if (gVar != null) {
            gVar.ae();
            c.b(gVar, this.bk);
            c.b(gVar, this.bl);
            c.b(gVar, this.bm);
        }
    }

    private void h(LinkedList<g> linkedList) {
        while (true) {
            g e = c.e(linkedList);
            if (e != null) {
                e.ae();
                a(e, l.bJ, null);
            } else {
                return;
            }
        }
    }

    void av() {
        h(this.bk);
        h(this.bl);
        h(this.bm);
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public boolean a(int i, String str) {
        if (this.bn != null) {
            this.bn.a(i, str);
        }
        if (this.bp != null) {
            this.bp.V();
        }
        if (!com.baidu.adp.lib.util.m.isNetOk() || c.f(this.bm) || c.f(this.bl) || c.f(this.bk) || !BdSocketLinkService.isAvailable()) {
            av();
            return false;
        }
        c.g(this.bk);
        c.a(this.bl, this.bm);
        c.a(this.bl, this.bk);
        while (true) {
            g c = c.c(this.bl);
            if (c == null) {
                break;
            }
            c.ae();
            a(c, l.bJ, null);
        }
        if (c.b(this.bl) > 0) {
            m.a("queue", 0, 0, "onClose", l.bR, "have retry message, MessageQueue:reconnect");
            BdSocketLinkService.startService(false, "have retry message");
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void b(Map<String, String> map) {
        i.at().a(map);
        if (this.bp != null) {
            this.bp.W();
        }
        this.bo = true;
        m.a("queue", 0, 0, "onConnected", l.bV, "Queue blocked");
        if (this.bn != null) {
            this.bn.b(map);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void d(byte[] bArr) {
        if (bArr != null) {
            this.bq = System.currentTimeMillis();
            try {
                com.baidu.adp.framework.client.socket.coder.c f = com.baidu.adp.framework.client.socket.coder.b.aK().f(bArr);
                int aH = f.ck.aH();
                int aJ = f.ck.aJ();
                m.a("queue", aH, aJ, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
                g a = a(aH, aJ);
                if (this.bp != null) {
                    if (f.ck.aH() == this.bp.getCmd() && c.a(this.bl, this.bm)) {
                        au();
                    }
                    this.bp.W();
                }
                if (aJ == 0 || (a != null && a.getCmd() == aH)) {
                    new d(f, a, this.bj, aJ).execute(new String[0]);
                } else if (a != null) {
                    a(a, l.bW, null);
                }
                if (this.bn != null) {
                    this.bn.d(bArr);
                }
            } catch (CoderException e) {
                m.a("queue", 0, 0, "onBinaryMesssage", l.bE, "onBinaryMesssage decodeHeader error");
            }
        }
    }

    private g a(int i, int i2) {
        g gVar = null;
        if (i2 != 0) {
            g a = c.a(i2, this.bk);
            if (a == null && (a = c.a(i2, this.bm)) == null) {
                gVar = c.a(i2, this.bl);
                if (gVar == null) {
                    m.a("queue", i, i2, "findSenderData", l.bT, "original message removed , responsedMessage not dispatchMessage");
                }
            } else {
                gVar = a;
            }
            m.a("queue", i, i2, "findSenderData", l.bS, "received ack message");
        }
        return gVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void a(com.baidu.adp.lib.webSocket.d dVar) {
        au();
        if (this.bn != null) {
            this.bn.a(dVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void j(String str) {
        if (this.bn != null) {
            this.bn.j(str);
        }
    }

    public void a(com.baidu.adp.framework.client.socket.link.g gVar) {
        this.bn = gVar;
    }

    public void aw() {
        boolean z = this.bo;
        this.bo = false;
        m.a("queue", 0, 0, "unBlockMessageQueue", l.bP, "Queue block has release");
        if (z) {
            au();
        }
    }

    public void a(b bVar) {
        this.bp = bVar;
    }

    public boolean isValid() {
        return BdSocketLinkService.isOpen() && !this.bo && BdSocketLinkService.isAvailable();
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        removeMessage(0, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.a
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        c.a(this.bk, i, bdUniqueId);
        c.a(this.bl, i, bdUniqueId);
        c.a(this.bm, i, bdUniqueId);
    }

    public LinkedList<SocketMessage> a(BdUniqueId bdUniqueId) {
        return null;
    }

    @Override // com.baidu.adp.framework.a
    public LinkedList<SocketMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return null;
    }

    public long ax() {
        return this.bq;
    }

    public int ay() {
        return BdAsyncTask.getTaskNum(d.X());
    }

    public b az() {
        return this.bp;
    }
}
