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
    private static h QZ = null;
    private String[] Rc;
    private g.a Rg;
    private String Ra = null;
    private List<BasicNameValuePair> Rb = null;
    private String Rd = null;
    private i Re = null;
    private ArrayList<g.a> Rf = new ArrayList<>();

    public static h oC() {
        if (QZ == null) {
            synchronized (h.class) {
                if (QZ == null) {
                    QZ = new h();
                }
            }
        }
        return QZ;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.Ra = str;
        this.Rd = str2;
        this.Rc = strArr;
        this.Rb = list;
        if (isDebug()) {
        }
    }

    private h() {
        this.Rg = null;
        this.Rg = new g.a() { // from class: com.baidu.adp.lib.webSocket.h.1
            @Override // com.baidu.adp.lib.webSocket.g.a
            public void onTextMessage(String str) {
                Iterator it = h.this.Rf.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).onTextMessage(str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void m(byte[] bArr) {
                Iterator it = h.this.Rf.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).m(bArr);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(k.a aVar) {
                Iterator it = h.this.Rf.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).b(aVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void onOpen(Map<String, String> map) {
                Iterator it = h.this.Rf.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).onOpen(map);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void c(int i, String str) {
                h.this.Re = null;
                Iterator it = h.this.Rf.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).c(i, str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(c cVar) {
                Iterator it = h.this.Rf.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).a(cVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void oB() {
                Iterator it = h.this.Rf.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).oB();
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

    public boolean oD() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        if (this.Re != null) {
            if (this.Re.isConnecting() || this.Re.isOpen()) {
                if (isDebug()) {
                }
                return true;
            }
            this.Re.close(1, null);
            this.Re = null;
        }
        this.Re = new i();
        try {
            l lVar = new l();
            lVar.co(this.Rd);
            this.Re.a(this.Ra, this.Rc, this.Rg, lVar, this.Rb);
            return true;
        } catch (WebSocketException e) {
            this.Re = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.Re != null) {
            i iVar = this.Re;
            this.Re = null;
            iVar.close(i, str);
            if (this.Re != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.Re = null;
            }
        }
    }

    public boolean oE() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return (this.Re == null || !this.Re.isOpen() || this.Re.oM()) ? false : true;
    }

    public boolean oF() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return this.Re != null && this.Re.isOpen();
    }

    public boolean isConnecting() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return this.Re != null && this.Re.isConnecting();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.l.checkMainThread();
                if (this.Re != null) {
                    z = this.Re.sendMessage(cVar);
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
                if (!this.Rf.contains(aVar)) {
                    return this.Rf.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void oG() {
        if (this.Re != null) {
            this.Re.oG();
        }
    }

    public long getUpFlowSize() {
        if (this.Re != null) {
            return this.Re.getUpFlowSize();
        }
        return -1L;
    }

    public void oH() {
        if (this.Re != null) {
            this.Re.oH();
        }
    }

    public long getDownFlowSize() {
        if (this.Re != null) {
            return this.Re.getDownFlowSize();
        }
        return -1L;
    }

    public long oz() {
        if (this.Re != null) {
            return this.Re.oN();
        }
        return -1L;
    }

    public String oy() {
        if (this.Re != null) {
            return this.Re.oO();
        }
        return null;
    }

    public long oI() {
        if (this.Re != null) {
            return this.Re.oP();
        }
        return -1L;
    }

    public String getLocalDns() {
        if (this.Re != null) {
            return this.Re.getLocalDns();
        }
        return null;
    }

    public String getLocalDnsBak() {
        if (this.Re != null) {
            return this.Re.getLocalDnsBak();
        }
        return null;
    }

    public String getUrl() {
        return this.Ra;
    }
}
