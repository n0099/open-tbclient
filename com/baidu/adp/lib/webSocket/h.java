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
    private static h rN = null;
    private String[] rQ;
    private g.a rU;
    private String rO = null;
    private List<BasicNameValuePair> rP = null;
    private String rR = null;
    private i rS = null;
    private ArrayList<g.a> rT = new ArrayList<>();

    public static h hr() {
        if (rN == null) {
            synchronized (h.class) {
                if (rN == null) {
                    rN = new h();
                }
            }
        }
        return rN;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.rO = str;
        this.rR = str2;
        this.rQ = strArr;
        this.rP = list;
        if (isDebug()) {
        }
    }

    private h() {
        this.rU = null;
        this.rU = new g.a() { // from class: com.baidu.adp.lib.webSocket.h.1
            @Override // com.baidu.adp.lib.webSocket.g.a
            public void onTextMessage(String str) {
                Iterator it = h.this.rT.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).onTextMessage(str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void i(byte[] bArr) {
                Iterator it = h.this.rT.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).i(bArr);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(k.a aVar) {
                Iterator it = h.this.rT.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).b(aVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void onOpen(Map<String, String> map) {
                Iterator it = h.this.rT.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).onOpen(map);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void e(int i, String str) {
                h.this.rS = null;
                Iterator it = h.this.rT.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).e(i, str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(c cVar) {
                Iterator it = h.this.rT.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).a(cVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void hq() {
                Iterator it = h.this.rT.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).hq();
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

    public boolean hs() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        if (this.rS != null) {
            if (this.rS.isConnecting() || this.rS.isOpen()) {
                if (isDebug()) {
                }
                return true;
            }
            this.rS.close(1, null);
            this.rS = null;
        }
        this.rS = new i();
        try {
            l lVar = new l();
            lVar.ay(this.rR);
            this.rS.a(this.rO, this.rQ, this.rU, lVar, this.rP);
            return true;
        } catch (WebSocketException e) {
            this.rS = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.rS != null) {
            i iVar = this.rS;
            this.rS = null;
            iVar.close(i, str);
            if (this.rS != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.rS = null;
            }
        }
    }

    public boolean ht() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return (this.rS == null || !this.rS.isOpen() || this.rS.hB()) ? false : true;
    }

    public boolean hu() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return this.rS != null && this.rS.isOpen();
    }

    public boolean isConnecting() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return this.rS != null && this.rS.isConnecting();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.l.checkMainThread();
                if (this.rS != null) {
                    z = this.rS.sendMessage(cVar);
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
                if (!this.rT.contains(aVar)) {
                    return this.rT.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void hv() {
        if (this.rS != null) {
            this.rS.hv();
        }
    }

    public long getUpFlowSize() {
        if (this.rS != null) {
            return this.rS.getUpFlowSize();
        }
        return -1L;
    }

    public void hw() {
        if (this.rS != null) {
            this.rS.hw();
        }
    }

    public long getDownFlowSize() {
        if (this.rS != null) {
            return this.rS.getDownFlowSize();
        }
        return -1L;
    }

    public long ho() {
        if (this.rS != null) {
            return this.rS.hC();
        }
        return -1L;
    }

    public String hn() {
        if (this.rS != null) {
            return this.rS.hD();
        }
        return null;
    }

    public long hx() {
        if (this.rS != null) {
            return this.rS.hE();
        }
        return -1L;
    }

    public String getLocalDns() {
        if (this.rS != null) {
            return this.rS.getLocalDns();
        }
        return null;
    }

    public String getLocalDnsBak() {
        if (this.rS != null) {
            return this.rS.getLocalDnsBak();
        }
        return null;
    }

    public String getUrl() {
        return this.rO;
    }
}
