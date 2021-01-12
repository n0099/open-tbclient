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
    private static h Ra = null;
    private String[] Rd;
    private g.a Rh;
    private String Rb = null;
    private List<BasicNameValuePair> Rc = null;
    private String Re = null;
    private i Rf = null;
    private ArrayList<g.a> Rg = new ArrayList<>();

    public static h od() {
        if (Ra == null) {
            synchronized (h.class) {
                if (Ra == null) {
                    Ra = new h();
                }
            }
        }
        return Ra;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.Rb = str;
        this.Re = str2;
        this.Rd = strArr;
        this.Rc = list;
        if (isDebug()) {
        }
    }

    private h() {
        this.Rh = null;
        this.Rh = new g.a() { // from class: com.baidu.adp.lib.webSocket.h.1
            @Override // com.baidu.adp.lib.webSocket.g.a
            public void onTextMessage(String str) {
                Iterator it = h.this.Rg.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).onTextMessage(str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void m(byte[] bArr) {
                Iterator it = h.this.Rg.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).m(bArr);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(k.a aVar) {
                Iterator it = h.this.Rg.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).b(aVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void onOpen(Map<String, String> map) {
                Iterator it = h.this.Rg.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).onOpen(map);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void d(int i, String str) {
                h.this.Rf = null;
                Iterator it = h.this.Rg.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).d(i, str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(c cVar) {
                Iterator it = h.this.Rg.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).a(cVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void oc() {
                Iterator it = h.this.Rg.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).oc();
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
        if (this.Rf != null) {
            if (this.Rf.isConnecting() || this.Rf.isOpen()) {
                if (isDebug()) {
                }
                return true;
            }
            this.Rf.close(1, null);
            this.Rf = null;
        }
        this.Rf = new i();
        try {
            l lVar = new l();
            lVar.ch(this.Re);
            this.Rf.a(this.Rb, this.Rd, this.Rh, lVar, this.Rc);
            return true;
        } catch (WebSocketException e) {
            this.Rf = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.Rf != null) {
            i iVar = this.Rf;
            this.Rf = null;
            iVar.close(i, str);
            if (this.Rf != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.Rf = null;
            }
        }
    }

    public boolean oe() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return (this.Rf == null || !this.Rf.isOpen() || this.Rf.on()) ? false : true;
    }

    public boolean og() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return this.Rf != null && this.Rf.isOpen();
    }

    public boolean isConnecting() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return this.Rf != null && this.Rf.isConnecting();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.l.checkMainThread();
                if (this.Rf != null) {
                    z = this.Rf.sendMessage(cVar);
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
                if (!this.Rg.contains(aVar)) {
                    return this.Rg.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void oh() {
        if (this.Rf != null) {
            this.Rf.oh();
        }
    }

    public long getUpFlowSize() {
        if (this.Rf != null) {
            return this.Rf.getUpFlowSize();
        }
        return -1L;
    }

    public void oi() {
        if (this.Rf != null) {
            this.Rf.oi();
        }
    }

    public long getDownFlowSize() {
        if (this.Rf != null) {
            return this.Rf.getDownFlowSize();
        }
        return -1L;
    }

    public long oa() {
        if (this.Rf != null) {
            return this.Rf.oo();
        }
        return -1L;
    }

    public String nZ() {
        if (this.Rf != null) {
            return this.Rf.op();
        }
        return null;
    }

    public long oj() {
        if (this.Rf != null) {
            return this.Rf.oq();
        }
        return -1L;
    }

    public String getLocalDns() {
        if (this.Rf != null) {
            return this.Rf.getLocalDns();
        }
        return null;
    }

    public String getLocalDnsBak() {
        if (this.Rf != null) {
            return this.Rf.getLocalDnsBak();
        }
        return null;
    }

    public String getUrl() {
        return this.Rb;
    }
}
