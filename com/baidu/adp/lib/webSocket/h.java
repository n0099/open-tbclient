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
    private static h Rc = null;
    private String[] Rf;
    private g.a Rj;
    private String Rd = null;
    private List<BasicNameValuePair> Re = null;
    private String Rg = null;
    private i Rh = null;
    private ArrayList<g.a> Ri = new ArrayList<>();

    public static h od() {
        if (Rc == null) {
            synchronized (h.class) {
                if (Rc == null) {
                    Rc = new h();
                }
            }
        }
        return Rc;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.Rd = str;
        this.Rg = str2;
        this.Rf = strArr;
        this.Re = list;
        if (isDebug()) {
        }
    }

    private h() {
        this.Rj = null;
        this.Rj = new g.a() { // from class: com.baidu.adp.lib.webSocket.h.1
            @Override // com.baidu.adp.lib.webSocket.g.a
            public void onTextMessage(String str) {
                Iterator it = h.this.Ri.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).onTextMessage(str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void m(byte[] bArr) {
                Iterator it = h.this.Ri.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).m(bArr);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(k.a aVar) {
                Iterator it = h.this.Ri.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).b(aVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void onOpen(Map<String, String> map) {
                Iterator it = h.this.Ri.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).onOpen(map);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void c(int i, String str) {
                h.this.Rh = null;
                Iterator it = h.this.Ri.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).c(i, str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(c cVar) {
                Iterator it = h.this.Ri.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).a(cVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void oc() {
                Iterator it = h.this.Ri.iterator();
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
        if (this.Rh != null) {
            if (this.Rh.isConnecting() || this.Rh.isOpen()) {
                if (isDebug()) {
                }
                return true;
            }
            this.Rh.close(1, null);
            this.Rh = null;
        }
        this.Rh = new i();
        try {
            l lVar = new l();
            lVar.ch(this.Rg);
            this.Rh.a(this.Rd, this.Rf, this.Rj, lVar, this.Re);
            return true;
        } catch (WebSocketException e) {
            this.Rh = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.Rh != null) {
            i iVar = this.Rh;
            this.Rh = null;
            iVar.close(i, str);
            if (this.Rh != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.Rh = null;
            }
        }
    }

    public boolean oe() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return (this.Rh == null || !this.Rh.isOpen() || this.Rh.on()) ? false : true;
    }

    public boolean og() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return this.Rh != null && this.Rh.isOpen();
    }

    public boolean isConnecting() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return this.Rh != null && this.Rh.isConnecting();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.l.checkMainThread();
                if (this.Rh != null) {
                    z = this.Rh.sendMessage(cVar);
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
                if (!this.Ri.contains(aVar)) {
                    return this.Ri.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void oh() {
        if (this.Rh != null) {
            this.Rh.oh();
        }
    }

    public long getUpFlowSize() {
        if (this.Rh != null) {
            return this.Rh.getUpFlowSize();
        }
        return -1L;
    }

    public void oi() {
        if (this.Rh != null) {
            this.Rh.oi();
        }
    }

    public long getDownFlowSize() {
        if (this.Rh != null) {
            return this.Rh.getDownFlowSize();
        }
        return -1L;
    }

    public long oa() {
        if (this.Rh != null) {
            return this.Rh.oo();
        }
        return -1L;
    }

    public String nZ() {
        if (this.Rh != null) {
            return this.Rh.op();
        }
        return null;
    }

    public long oj() {
        if (this.Rh != null) {
            return this.Rh.oq();
        }
        return -1L;
    }

    public String getLocalDns() {
        if (this.Rh != null) {
            return this.Rh.getLocalDns();
        }
        return null;
    }

    public String getLocalDnsBak() {
        if (this.Rh != null) {
            return this.Rh.getLocalDnsBak();
        }
        return null;
    }

    public String getUrl() {
        return this.Rd;
    }
}
