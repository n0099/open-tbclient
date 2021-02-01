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
    private static h QY = null;
    private String[] Rb;
    private g.a Rf;
    private String QZ = null;
    private List<BasicNameValuePair> Ra = null;
    private String Rc = null;
    private i Rd = null;
    private ArrayList<g.a> Re = new ArrayList<>();

    public static h ob() {
        if (QY == null) {
            synchronized (h.class) {
                if (QY == null) {
                    QY = new h();
                }
            }
        }
        return QY;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.QZ = str;
        this.Rc = str2;
        this.Rb = strArr;
        this.Ra = list;
        if (isDebug()) {
        }
    }

    private h() {
        this.Rf = null;
        this.Rf = new g.a() { // from class: com.baidu.adp.lib.webSocket.h.1
            @Override // com.baidu.adp.lib.webSocket.g.a
            public void onTextMessage(String str) {
                Iterator it = h.this.Re.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).onTextMessage(str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void m(byte[] bArr) {
                Iterator it = h.this.Re.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).m(bArr);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(k.a aVar) {
                Iterator it = h.this.Re.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).b(aVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void onOpen(Map<String, String> map) {
                Iterator it = h.this.Re.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).onOpen(map);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void d(int i, String str) {
                h.this.Rd = null;
                Iterator it = h.this.Re.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).d(i, str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(c cVar) {
                Iterator it = h.this.Re.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).a(cVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void oa() {
                Iterator it = h.this.Re.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).oa();
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

    public boolean open() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        if (this.Rd != null) {
            if (this.Rd.isConnecting() || this.Rd.isOpen()) {
                if (isDebug()) {
                }
                return true;
            }
            this.Rd.close(1, null);
            this.Rd = null;
        }
        this.Rd = new i();
        try {
            l lVar = new l();
            lVar.ch(this.Rc);
            this.Rd.a(this.QZ, this.Rb, this.Rf, lVar, this.Ra);
            return true;
        } catch (WebSocketException e) {
            this.Rd = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.Rd != null) {
            i iVar = this.Rd;
            this.Rd = null;
            iVar.close(i, str);
            if (this.Rd != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.Rd = null;
            }
        }
    }

    public boolean oc() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return (this.Rd == null || !this.Rd.isOpen() || this.Rd.ol()) ? false : true;
    }

    public boolean od() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return this.Rd != null && this.Rd.isOpen();
    }

    public boolean isConnecting() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return this.Rd != null && this.Rd.isConnecting();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.l.checkMainThread();
                if (this.Rd != null) {
                    z = this.Rd.sendMessage(cVar);
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
                if (!this.Re.contains(aVar)) {
                    return this.Re.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void oe() {
        if (this.Rd != null) {
            this.Rd.oe();
        }
    }

    public long getUpFlowSize() {
        if (this.Rd != null) {
            return this.Rd.getUpFlowSize();
        }
        return -1L;
    }

    public void og() {
        if (this.Rd != null) {
            this.Rd.og();
        }
    }

    public long getDownFlowSize() {
        if (this.Rd != null) {
            return this.Rd.getDownFlowSize();
        }
        return -1L;
    }

    public long nY() {
        if (this.Rd != null) {
            return this.Rd.om();
        }
        return -1L;
    }

    public String nX() {
        if (this.Rd != null) {
            return this.Rd.on();
        }
        return null;
    }

    public long oh() {
        if (this.Rd != null) {
            return this.Rd.oo();
        }
        return -1L;
    }

    public String getLocalDns() {
        if (this.Rd != null) {
            return this.Rd.getLocalDns();
        }
        return null;
    }

    public String getLocalDnsBak() {
        if (this.Rd != null) {
            return this.Rd.getLocalDnsBak();
        }
        return null;
    }

    public String getUrl() {
        return this.QZ;
    }
}
