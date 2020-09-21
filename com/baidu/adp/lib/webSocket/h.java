package com.baidu.adp.lib.webSocket;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.g;
import com.baidu.adp.lib.webSocket.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class h {
    private static h PJ = null;
    private String[] PO;
    private g.a PT;
    private String PM = null;
    private List<BasicNameValuePair> PN = null;
    private String PP = null;
    private i PQ = null;
    private ArrayList<g.a> PR = new ArrayList<>();

    public static h oD() {
        if (PJ == null) {
            synchronized (h.class) {
                if (PJ == null) {
                    PJ = new h();
                }
            }
        }
        return PJ;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.PM = str;
        this.PP = str2;
        this.PO = strArr;
        this.PN = list;
        if (isDebug()) {
        }
    }

    private h() {
        this.PT = null;
        this.PT = new g.a() { // from class: com.baidu.adp.lib.webSocket.h.1
            @Override // com.baidu.adp.lib.webSocket.g.a
            public void onTextMessage(String str) {
                Iterator it = h.this.PR.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).onTextMessage(str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void m(byte[] bArr) {
                Iterator it = h.this.PR.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).m(bArr);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(k.a aVar) {
                Iterator it = h.this.PR.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).b(aVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void onOpen(Map<String, String> map) {
                Iterator it = h.this.PR.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).onOpen(map);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void c(int i, String str) {
                h.this.PQ = null;
                Iterator it = h.this.PR.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).c(i, str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(c cVar) {
                Iterator it = h.this.PR.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).a(cVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void oC() {
                Iterator it = h.this.PR.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).oC();
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(c cVar) {
                if (cVar != null) {
                    cVar.onStartSend();
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(int i, c cVar) {
                if (cVar != null) {
                    cVar.onSendError(i);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void c(c cVar) {
                if (cVar != null) {
                    cVar.onFinishSend();
                }
            }
        };
    }

    public boolean oE() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        if (this.PQ != null) {
            if (this.PQ.isConnecting() || this.PQ.isOpen()) {
                if (isDebug()) {
                }
                return true;
            }
            this.PQ.close(1, null);
            this.PQ = null;
        }
        this.PQ = new i();
        try {
            l lVar = new l();
            lVar.ck(this.PP);
            this.PQ.a(this.PM, this.PO, this.PT, lVar, this.PN);
            return true;
        } catch (WebSocketException e) {
            this.PQ = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.PQ != null) {
            i iVar = this.PQ;
            this.PQ = null;
            iVar.close(i, str);
            if (this.PQ != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.PQ = null;
            }
        }
    }

    public boolean getIsIdle() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return (this.PQ == null || !this.PQ.isOpen() || this.PQ.oM()) ? false : true;
    }

    public boolean oF() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return this.PQ != null && this.PQ.isOpen();
    }

    public boolean isConnecting() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return this.PQ != null && this.PQ.isConnecting();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.l.checkMainThread();
                if (this.PQ != null) {
                    z = this.PQ.sendMessage(cVar);
                } else if (cVar != null) {
                    cVar.onSendError(1);
                }
            }
        }
        return z;
    }

    public boolean a(g.a aVar) {
        if (aVar != null) {
            synchronized (h.class) {
                if (!this.PR.contains(aVar)) {
                    return this.PR.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void oG() {
        if (this.PQ != null) {
            this.PQ.oG();
        }
    }

    public long getUpFlowSize() {
        if (this.PQ != null) {
            return this.PQ.getUpFlowSize();
        }
        return -1L;
    }

    public void oH() {
        if (this.PQ != null) {
            this.PQ.oH();
        }
    }

    public long getDownFlowSize() {
        if (this.PQ != null) {
            return this.PQ.getDownFlowSize();
        }
        return -1L;
    }

    public long oA() {
        if (this.PQ != null) {
            return this.PQ.oN();
        }
        return -1L;
    }

    public String oz() {
        if (this.PQ != null) {
            return this.PQ.oO();
        }
        return null;
    }

    public long oI() {
        if (this.PQ != null) {
            return this.PQ.oP();
        }
        return -1L;
    }

    public String getLocalDns() {
        if (this.PQ != null) {
            return this.PQ.getLocalDns();
        }
        return null;
    }

    public String getLocalDnsBak() {
        if (this.PQ != null) {
            return this.PQ.getLocalDnsBak();
        }
        return null;
    }

    public String getUrl() {
        return this.PM;
    }
}
