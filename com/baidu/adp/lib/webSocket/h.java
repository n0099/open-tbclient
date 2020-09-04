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
    private static h Po = null;
    private String[] Pr;
    private g.a Pv;
    private String Pp = null;
    private List<BasicNameValuePair> Pq = null;
    private String Ps = null;
    private i Pt = null;
    private ArrayList<g.a> Pu = new ArrayList<>();

    public static h oy() {
        if (Po == null) {
            synchronized (h.class) {
                if (Po == null) {
                    Po = new h();
                }
            }
        }
        return Po;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.Pp = str;
        this.Ps = str2;
        this.Pr = strArr;
        this.Pq = list;
        if (isDebug()) {
        }
    }

    private h() {
        this.Pv = null;
        this.Pv = new g.a() { // from class: com.baidu.adp.lib.webSocket.h.1
            @Override // com.baidu.adp.lib.webSocket.g.a
            public void onTextMessage(String str) {
                Iterator it = h.this.Pu.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).onTextMessage(str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void m(byte[] bArr) {
                Iterator it = h.this.Pu.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).m(bArr);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(k.a aVar) {
                Iterator it = h.this.Pu.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).b(aVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void onOpen(Map<String, String> map) {
                Iterator it = h.this.Pu.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).onOpen(map);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void c(int i, String str) {
                h.this.Pt = null;
                Iterator it = h.this.Pu.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).c(i, str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(c cVar) {
                Iterator it = h.this.Pu.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).a(cVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void ox() {
                Iterator it = h.this.Pu.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).ox();
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

    public boolean oz() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        if (this.Pt != null) {
            if (this.Pt.isConnecting() || this.Pt.isOpen()) {
                if (isDebug()) {
                }
                return true;
            }
            this.Pt.close(1, null);
            this.Pt = null;
        }
        this.Pt = new i();
        try {
            l lVar = new l();
            lVar.ci(this.Ps);
            this.Pt.a(this.Pp, this.Pr, this.Pv, lVar, this.Pq);
            return true;
        } catch (WebSocketException e) {
            this.Pt = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.Pt != null) {
            i iVar = this.Pt;
            this.Pt = null;
            iVar.close(i, str);
            if (this.Pt != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.Pt = null;
            }
        }
    }

    public boolean getIsIdle() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return (this.Pt == null || !this.Pt.isOpen() || this.Pt.oH()) ? false : true;
    }

    public boolean oA() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return this.Pt != null && this.Pt.isOpen();
    }

    public boolean isConnecting() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return this.Pt != null && this.Pt.isConnecting();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.l.checkMainThread();
                if (this.Pt != null) {
                    z = this.Pt.sendMessage(cVar);
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
                if (!this.Pu.contains(aVar)) {
                    return this.Pu.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void oB() {
        if (this.Pt != null) {
            this.Pt.oB();
        }
    }

    public long getUpFlowSize() {
        if (this.Pt != null) {
            return this.Pt.getUpFlowSize();
        }
        return -1L;
    }

    public void oC() {
        if (this.Pt != null) {
            this.Pt.oC();
        }
    }

    public long getDownFlowSize() {
        if (this.Pt != null) {
            return this.Pt.getDownFlowSize();
        }
        return -1L;
    }

    public long ov() {
        if (this.Pt != null) {
            return this.Pt.oI();
        }
        return -1L;
    }

    public String ou() {
        if (this.Pt != null) {
            return this.Pt.oJ();
        }
        return null;
    }

    public long oD() {
        if (this.Pt != null) {
            return this.Pt.oK();
        }
        return -1L;
    }

    public String getLocalDns() {
        if (this.Pt != null) {
            return this.Pt.getLocalDns();
        }
        return null;
    }

    public String getLocalDnsBak() {
        if (this.Pt != null) {
            return this.Pt.getLocalDnsBak();
        }
        return null;
    }

    public String getUrl() {
        return this.Pp;
    }
}
