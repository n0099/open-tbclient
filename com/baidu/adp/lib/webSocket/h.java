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
    private static h uL = null;
    private String[] uO;
    private g.a uS;
    private String uM = null;
    private List<BasicNameValuePair> uN = null;
    private String uP = null;
    private i uQ = null;
    private ArrayList<g.a> uR = new ArrayList<>();

    public static h hM() {
        if (uL == null) {
            synchronized (h.class) {
                if (uL == null) {
                    uL = new h();
                }
            }
        }
        return uL;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.uM = str;
        this.uP = str2;
        this.uO = strArr;
        this.uN = list;
        if (isDebug()) {
        }
    }

    private h() {
        this.uS = null;
        this.uS = new g.a() { // from class: com.baidu.adp.lib.webSocket.h.1
            @Override // com.baidu.adp.lib.webSocket.g.a
            public void onTextMessage(String str) {
                Iterator it = h.this.uR.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).onTextMessage(str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void h(byte[] bArr) {
                Iterator it = h.this.uR.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).h(bArr);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(k.a aVar) {
                Iterator it = h.this.uR.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).b(aVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void onOpen(Map<String, String> map) {
                Iterator it = h.this.uR.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).onOpen(map);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void e(int i, String str) {
                h.this.uQ = null;
                Iterator it = h.this.uR.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).e(i, str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(c cVar) {
                Iterator it = h.this.uR.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).a(cVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void hL() {
                Iterator it = h.this.uR.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).hL();
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

    public boolean hN() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        if (this.uQ != null) {
            if (this.uQ.isConnecting() || this.uQ.isOpen()) {
                if (isDebug()) {
                }
                return true;
            }
            this.uQ.close(1, null);
            this.uQ = null;
        }
        this.uQ = new i();
        try {
            l lVar = new l();
            lVar.aK(this.uP);
            this.uQ.a(this.uM, this.uO, this.uS, lVar, this.uN);
            return true;
        } catch (WebSocketException e) {
            this.uQ = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.uQ != null) {
            i iVar = this.uQ;
            this.uQ = null;
            iVar.close(i, str);
            if (this.uQ != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.uQ = null;
            }
        }
    }

    public boolean getIsIdle() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return (this.uQ == null || !this.uQ.isOpen() || this.uQ.hV()) ? false : true;
    }

    public boolean hO() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return this.uQ != null && this.uQ.isOpen();
    }

    public boolean isConnecting() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return this.uQ != null && this.uQ.isConnecting();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.l.checkMainThread();
                if (this.uQ != null) {
                    z = this.uQ.sendMessage(cVar);
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
                if (!this.uR.contains(aVar)) {
                    return this.uR.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void hP() {
        if (this.uQ != null) {
            this.uQ.hP();
        }
    }

    public long getUpFlowSize() {
        if (this.uQ != null) {
            return this.uQ.getUpFlowSize();
        }
        return -1L;
    }

    public void hQ() {
        if (this.uQ != null) {
            this.uQ.hQ();
        }
    }

    public long getDownFlowSize() {
        if (this.uQ != null) {
            return this.uQ.getDownFlowSize();
        }
        return -1L;
    }

    public long hJ() {
        if (this.uQ != null) {
            return this.uQ.hW();
        }
        return -1L;
    }

    public String hI() {
        if (this.uQ != null) {
            return this.uQ.hX();
        }
        return null;
    }

    public long hR() {
        if (this.uQ != null) {
            return this.uQ.hY();
        }
        return -1L;
    }

    public String getLocalDns() {
        if (this.uQ != null) {
            return this.uQ.getLocalDns();
        }
        return null;
    }

    public String getLocalDnsBak() {
        if (this.uQ != null) {
            return this.uQ.getLocalDnsBak();
        }
        return null;
    }

    public String getUrl() {
        return this.uM;
    }
}
