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
    private static h uI = null;
    private String[] uL;
    private g.a uP;
    private String uJ = null;
    private List<BasicNameValuePair> uK = null;
    private String uM = null;
    private i uN = null;
    private ArrayList<g.a> uO = new ArrayList<>();

    public static h hN() {
        if (uI == null) {
            synchronized (h.class) {
                if (uI == null) {
                    uI = new h();
                }
            }
        }
        return uI;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.uJ = str;
        this.uM = str2;
        this.uL = strArr;
        this.uK = list;
        if (isDebug()) {
        }
    }

    private h() {
        this.uP = null;
        this.uP = new g.a() { // from class: com.baidu.adp.lib.webSocket.h.1
            @Override // com.baidu.adp.lib.webSocket.g.a
            public void onTextMessage(String str) {
                Iterator it = h.this.uO.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).onTextMessage(str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void h(byte[] bArr) {
                Iterator it = h.this.uO.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).h(bArr);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(k.a aVar) {
                Iterator it = h.this.uO.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).b(aVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void onOpen(Map<String, String> map) {
                Iterator it = h.this.uO.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).onOpen(map);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void e(int i, String str) {
                h.this.uN = null;
                Iterator it = h.this.uO.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).e(i, str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(c cVar) {
                Iterator it = h.this.uO.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).a(cVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void hM() {
                Iterator it = h.this.uO.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).hM();
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

    public boolean hO() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        if (this.uN != null) {
            if (this.uN.isConnecting() || this.uN.isOpen()) {
                if (isDebug()) {
                }
                return true;
            }
            this.uN.close(1, null);
            this.uN = null;
        }
        this.uN = new i();
        try {
            l lVar = new l();
            lVar.aK(this.uM);
            this.uN.a(this.uJ, this.uL, this.uP, lVar, this.uK);
            return true;
        } catch (WebSocketException e) {
            this.uN = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.uN != null) {
            i iVar = this.uN;
            this.uN = null;
            iVar.close(i, str);
            if (this.uN != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.uN = null;
            }
        }
    }

    public boolean getIsIdle() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return (this.uN == null || !this.uN.isOpen() || this.uN.hW()) ? false : true;
    }

    public boolean hP() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return this.uN != null && this.uN.isOpen();
    }

    public boolean isConnecting() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return this.uN != null && this.uN.isConnecting();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.l.checkMainThread();
                if (this.uN != null) {
                    z = this.uN.sendMessage(cVar);
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
                if (!this.uO.contains(aVar)) {
                    return this.uO.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void hQ() {
        if (this.uN != null) {
            this.uN.hQ();
        }
    }

    public long getUpFlowSize() {
        if (this.uN != null) {
            return this.uN.getUpFlowSize();
        }
        return -1L;
    }

    public void hR() {
        if (this.uN != null) {
            this.uN.hR();
        }
    }

    public long getDownFlowSize() {
        if (this.uN != null) {
            return this.uN.getDownFlowSize();
        }
        return -1L;
    }

    public long hK() {
        if (this.uN != null) {
            return this.uN.hX();
        }
        return -1L;
    }

    public String hJ() {
        if (this.uN != null) {
            return this.uN.hY();
        }
        return null;
    }

    public long hS() {
        if (this.uN != null) {
            return this.uN.hZ();
        }
        return -1L;
    }

    public String getLocalDns() {
        if (this.uN != null) {
            return this.uN.getLocalDns();
        }
        return null;
    }

    public String getLocalDnsBak() {
        if (this.uN != null) {
            return this.uN.getLocalDnsBak();
        }
        return null;
    }

    public String getUrl() {
        return this.uJ;
    }
}
