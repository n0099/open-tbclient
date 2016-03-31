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
import com.baidu.adp.lib.webSocket.m;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.framework.client.a<SocketMessage, SocketMessageTask> implements com.baidu.adp.framework.client.socket.link.e {
    private static /* synthetic */ int[] oX;
    private d.a oP;
    private final LinkedList<e> oQ;
    private final LinkedList<e> oR;
    private final LinkedList<e> oS;
    private com.baidu.adp.framework.client.socket.link.e oT;
    private boolean oU;
    private b oV;
    private long oW;

    static /* synthetic */ int[] eE() {
        int[] iArr = oX;
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
            oX = iArr;
        }
        return iArr;
    }

    public h(MessageManager messageManager) {
        super(messageManager);
        this.oP = null;
        this.oQ = new LinkedList<>();
        this.oR = new LinkedList<>();
        this.oS = new LinkedList<>();
        this.oT = null;
        this.oU = true;
        this.oV = null;
        this.oW = 0L;
        BdSocketLinkService.setConnStateCallBack(this);
        this.oP = new i(this);
    }

    public boolean a(SocketMessage socketMessage) {
        if (socketMessage != null && (socketMessage instanceof a)) {
            a aVar = (a) socketMessage;
            if (c.a(this.oR, aVar, socketMessage.getCmd()) || c.a(this.oQ, aVar, socketMessage.getCmd()) || c.a(this.oS, aVar, socketMessage.getCmd())) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b
    /* renamed from: a */
    public void sendMessage(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        com.baidu.adp.lib.util.k.ju();
        if (socketMessage != null && socketMessageTask != null) {
            if (a(socketMessage, socketMessageTask.fm())) {
                k.a("queue", socketMessage, 0, "sendMessage", j.py, "duplicate message be removed");
                return;
            }
            e eVar = new e(socketMessage, socketMessageTask, this);
            if (BdSocketLinkService.hasAbsoluteClose()) {
                k.a("queue", socketMessage, 0, "sendMessage", j.pH, "user manual close socket");
                eVar.I(j.pH);
            } else if (!BdSocketLinkService.isAvailable()) {
                k.a("queue", socketMessage, 0, "sendMessage", j.px, "isManualBlock message be removed");
                eVar.I(j.px);
            } else {
                k.a("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                c.a(eVar, this.oR);
                ey();
            }
        }
    }

    private boolean a(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        if (socketMessage != null) {
            int cmd = socketMessage.getCmd();
            switch (eE()[dupLicateMode.ordinal()]) {
                case 2:
                    if (c.b(this.oR, cmd) || c.b(this.oQ, cmd) || c.b(this.oS, cmd)) {
                        return true;
                    }
                    break;
                case 3:
                    c.c(this.oR, cmd);
                    break;
                case 4:
                    c.c(this.oR, cmd);
                    c.c(this.oQ, cmd);
                    c.c(this.oS, cmd);
                    break;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(d.b bVar) {
        if (bVar != null) {
            if (bVar.oB != null) {
                a(bVar.oB, j.pe, null);
                return;
            }
            SocketResponsedMessage socketResponsedMessage = bVar.oA;
            if (socketResponsedMessage != null) {
                k.a("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
                b(socketResponsedMessage);
            }
        }
    }

    public void b(e eVar) {
        if (eVar != null && eVar.es() && eVar.ev() < eVar.ec()) {
            c.a(this.oQ, this.oS, eVar);
            if (this.oV != null) {
                this.oV.b(true, "timeout seq = " + eVar.er());
            }
            k.a("queue", eVar.eo(), eVar.er(), "onSendTimeOut", j.pB, String.valueOf(eVar.ev()));
            return;
        }
        e(eVar);
        a(eVar, j.ps, null);
        ey();
    }

    public void a(int i, e eVar) {
        int i2;
        if (i == 2) {
            if (eVar.em() != null) {
                i2 = eVar.em().getErrorCode();
            } else {
                i2 = j.po;
            }
        } else {
            i2 = j.pt;
        }
        String K = j.K(i2);
        e(eVar);
        a(eVar, i2, K);
    }

    public void c(e eVar) {
    }

    public void d(e eVar) {
        if (eVar != null) {
            if (eVar.en()) {
                eVar.ew();
                c.a(this.oR, this.oQ, eVar);
                return;
            }
            c.b(eVar, this.oR);
        }
    }

    protected void a(e eVar, int i, String str) {
        SocketResponsedMessage socketResponsedMessage = null;
        if (eVar != null && eVar.eo() != null) {
            int cmd = eVar.eo().getCmd();
            int er = eVar.er();
            k.a("queue", eVar.eo(), er, "onMessageSendFail", i, String.valueOf(str) + " retryTime-" + eVar.ev());
            SocketMessageTask ep = eVar != null ? eVar.ep() : null;
            SocketMessageTask socketMessageTask = ep == null ? (SocketMessageTask) this.og.findTask(cmd) : ep;
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
                    socketResponsedMessage.setErrorString(j.K(i));
                } else {
                    socketResponsedMessage.setErrorString(str);
                }
                socketResponsedMessage.setOrginalMessage(eVar.eo());
                k.a("queue", eVar.eo(), er, "onMessageSendFail", i, "onMessageSendFail class = " + socketResponsedMessage.getClass().getName());
                this.og.dispatchResponsedMessage(socketResponsedMessage);
            }
        }
    }

    private void ey() {
        e d = c.d(this.oR);
        if (d != null) {
            if (BdSocketLinkService.isClose()) {
                k.a("queue", d.eo(), 0, "sendNext", j.pz, "");
                BdSocketLinkService.startService(false, "send message");
            } else if (!this.oU || d.getPriority() <= -3) {
                BdSocketLinkService.sendMessage(d);
            }
        }
    }

    private void b(SocketResponsedMessage socketResponsedMessage) {
        this.og.dispatchResponsedMessage(socketResponsedMessage);
    }

    private void e(e eVar) {
        if (eVar != null) {
            eVar.ei();
            c.b(eVar, this.oQ);
            c.b(eVar, this.oR);
            c.b(eVar, this.oS);
        }
    }

    private void h(LinkedList<e> linkedList) {
        while (true) {
            e e = c.e(linkedList);
            if (e != null) {
                e.ei();
                a(e, j.pu, null);
            } else {
                return;
            }
        }
    }

    public void ez() {
        h(this.oQ);
        h(this.oR);
        h(this.oS);
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public boolean d(int i, String str) {
        if (this.oT != null) {
            this.oT.d(i, str);
        }
        if (this.oV != null) {
            this.oV.dZ();
        }
        if (!com.baidu.adp.lib.util.k.jw() || c.f(this.oS) || c.f(this.oR) || c.f(this.oQ) || !BdSocketLinkService.isAvailable()) {
            ez();
            return false;
        }
        c.g(this.oQ);
        c.a(this.oR, this.oS);
        c.a(this.oR, this.oQ);
        while (true) {
            e c = c.c(this.oR);
            if (c == null) {
                break;
            }
            c.ei();
            a(c, j.pu, null);
        }
        if (c.b(this.oR) > 0) {
            k.a("queue", 0, 0, "onClose", j.pC, "have retry message, MessageQueue:reconnect");
            BdSocketLinkService.startService(false, "have retry message");
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void c(Map<String, String> map) {
        g.ex().b(map);
        if (this.oV != null) {
            this.oV.ea();
        }
        this.oU = true;
        k.a("queue", 0, 0, "onConnected", j.pG, "Queue blocked");
        if (this.oT != null) {
            this.oT.c(map);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void a(m.a aVar) {
        byte[] bArr;
        if (aVar != null && (bArr = aVar.AH) != null) {
            this.oW = System.currentTimeMillis();
            try {
                com.baidu.adp.framework.client.socket.coder.c e = com.baidu.adp.framework.client.socket.coder.b.eP().e(bArr);
                int eL = e.pY.eL();
                int eN = e.pY.eN();
                k.a("queue", eL, eN, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
                e e2 = e(eL, eN);
                if (e2 != null) {
                    e2.oL = aVar.oL;
                    e2.oM = aVar.oM;
                }
                if (this.oV != null) {
                    if (e.pY.eL() == this.oV.getCmd() && c.a(this.oR, this.oS)) {
                        ey();
                    }
                    this.oV.ea();
                }
                if (eN == 0 || (e2 != null && e2.getCmd() == eL)) {
                    new d(e, e2, this.oP, eN).execute(new String[0]);
                } else if (e2 != null) {
                    a(e2, j.pI, null);
                }
                if (this.oT != null) {
                    this.oT.a(aVar);
                }
            } catch (CoderException e3) {
                k.a("queue", 0, 0, "onBinaryMesssage", j.pp, "onBinaryMesssage decodeHeader error");
            }
        }
    }

    private e e(int i, int i2) {
        e eVar = null;
        if (i2 != 0) {
            e a = c.a(i2, this.oQ);
            if (a == null && (a = c.a(i2, this.oS)) == null) {
                eVar = c.a(i2, this.oR);
                if (eVar == null) {
                    k.a("queue", i, i2, "findSenderData", j.pE, "original message removed , responsedMessage not dispatchMessage");
                }
            } else {
                eVar = a;
            }
            k.a("queue", i, i2, "findSenderData", j.pD, "received ack message");
        }
        return eVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
        ey();
        if (this.oT != null) {
            this.oT.a(cVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void H(String str) {
        if (this.oT != null) {
            this.oT.H(str);
        }
    }

    public void a(com.baidu.adp.framework.client.socket.link.e eVar) {
        this.oT = eVar;
    }

    public void eA() {
        boolean z = this.oU;
        this.oU = false;
        k.a("queue", 0, 0, "unBlockMessageQueue", j.pA, "Queue block has release");
        if (z) {
            ey();
        }
    }

    public void a(b bVar) {
        this.oV = bVar;
    }

    public boolean isValid() {
        return BdSocketLinkService.isOpen() && !this.oU && BdSocketLinkService.isAvailable();
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        removeMessage(0, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        c.b(this.oQ, i, bdUniqueId);
        c.b(this.oR, i, bdUniqueId);
        c.b(this.oS, i, bdUniqueId);
    }

    public LinkedList<SocketMessage> a(BdUniqueId bdUniqueId) {
        return null;
    }

    @Override // com.baidu.adp.framework.b
    public LinkedList<SocketMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return null;
    }

    public boolean a(int i, BdUniqueId bdUniqueId) {
        return c.a(this.oR, i, bdUniqueId) || c.a(this.oQ, i, bdUniqueId) || c.a(this.oS, i, bdUniqueId);
    }

    public long eB() {
        return this.oW;
    }

    public int eC() {
        return BdAsyncTask.getTaskNum(d.eb());
    }

    public int J(int i) {
        return BdAsyncTask.getTaskNum(String.valueOf(i), d.eb());
    }

    public b eD() {
        return this.oV;
    }
}
