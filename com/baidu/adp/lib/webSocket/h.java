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
    private static h St = null;
    private g.a SA;
    private String[] Sw;
    private String Su = null;
    private List<BasicNameValuePair> Sv = null;
    private String Sx = null;
    private i Sy = null;
    private ArrayList<g.a> Sz = new ArrayList<>();

    public static h ob() {
        if (St == null) {
            synchronized (h.class) {
                if (St == null) {
                    St = new h();
                }
            }
        }
        return St;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.Su = str;
        this.Sx = str2;
        this.Sw = strArr;
        this.Sv = list;
        if (isDebug()) {
        }
    }

    private h() {
        this.SA = null;
        this.SA = new g.a() { // from class: com.baidu.adp.lib.webSocket.h.1
            @Override // com.baidu.adp.lib.webSocket.g.a
            public void onTextMessage(String str) {
                Iterator it = h.this.Sz.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).onTextMessage(str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void m(byte[] bArr) {
                Iterator it = h.this.Sz.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).m(bArr);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(k.a aVar) {
                Iterator it = h.this.Sz.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).b(aVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void onOpen(Map<String, String> map) {
                Iterator it = h.this.Sz.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).onOpen(map);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void d(int i, String str) {
                h.this.Sy = null;
                Iterator it = h.this.Sz.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).d(i, str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(c cVar) {
                Iterator it = h.this.Sz.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).a(cVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void oa() {
                Iterator it = h.this.Sz.iterator();
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
        if (this.Sy != null) {
            if (this.Sy.isConnecting() || this.Sy.isOpen()) {
                if (isDebug()) {
                }
                return true;
            }
            this.Sy.close(1, null);
            this.Sy = null;
        }
        this.Sy = new i();
        try {
            l lVar = new l();
            lVar.cl(this.Sx);
            this.Sy.a(this.Su, this.Sw, this.SA, lVar, this.Sv);
            return true;
        } catch (WebSocketException e) {
            this.Sy = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.Sy != null) {
            i iVar = this.Sy;
            this.Sy = null;
            iVar.close(i, str);
            if (this.Sy != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.Sy = null;
            }
        }
    }

    public boolean oc() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return (this.Sy == null || !this.Sy.isOpen() || this.Sy.ol()) ? false : true;
    }

    public boolean od() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return this.Sy != null && this.Sy.isOpen();
    }

    public boolean isConnecting() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return this.Sy != null && this.Sy.isConnecting();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.l.checkMainThread();
                if (this.Sy != null) {
                    z = this.Sy.sendMessage(cVar);
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
                if (!this.Sz.contains(aVar)) {
                    return this.Sz.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void oe() {
        if (this.Sy != null) {
            this.Sy.oe();
        }
    }

    public long getUpFlowSize() {
        if (this.Sy != null) {
            return this.Sy.getUpFlowSize();
        }
        return -1L;
    }

    public void og() {
        if (this.Sy != null) {
            this.Sy.og();
        }
    }

    public long getDownFlowSize() {
        if (this.Sy != null) {
            return this.Sy.getDownFlowSize();
        }
        return -1L;
    }

    public long nY() {
        if (this.Sy != null) {
            return this.Sy.om();
        }
        return -1L;
    }

    public String nX() {
        if (this.Sy != null) {
            return this.Sy.on();
        }
        return null;
    }

    public long oh() {
        if (this.Sy != null) {
            return this.Sy.oo();
        }
        return -1L;
    }

    public String getLocalDns() {
        if (this.Sy != null) {
            return this.Sy.getLocalDns();
        }
        return null;
    }

    public String getLocalDnsBak() {
        if (this.Sy != null) {
            return this.Sy.getLocalDnsBak();
        }
        return null;
    }

    public String getUrl() {
        return this.Su;
    }
}
