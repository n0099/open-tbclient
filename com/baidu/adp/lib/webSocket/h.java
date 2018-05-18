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
    private static h yc = null;
    private String[] yf;
    private g.a yj;
    private String yd = null;
    private List<BasicNameValuePair> ye = null;
    private String yg = null;
    private i yh = null;
    private ArrayList<g.a> yi = new ArrayList<>();

    public static h hB() {
        if (yc == null) {
            synchronized (h.class) {
                if (yc == null) {
                    yc = new h();
                }
            }
        }
        return yc;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.yd = str;
        this.yg = str2;
        this.yf = strArr;
        this.ye = list;
        if (isDebug()) {
        }
    }

    private h() {
        this.yj = null;
        this.yj = new g.a() { // from class: com.baidu.adp.lib.webSocket.h.1
            @Override // com.baidu.adp.lib.webSocket.g.a
            public void G(String str) {
                Iterator it = h.this.yi.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).G(str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void q(byte[] bArr) {
                Iterator it = h.this.yi.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).q(bArr);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(k.a aVar) {
                Iterator it = h.this.yi.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).b(aVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void e(Map<String, String> map) {
                Iterator it = h.this.yi.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).e(map);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void e(int i, String str) {
                h.this.yh = null;
                Iterator it = h.this.yi.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).e(i, str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(c cVar) {
                Iterator it = h.this.yi.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).a(cVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void hA() {
                Iterator it = h.this.yi.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).hA();
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(c cVar) {
                if (cVar != null) {
                    cVar.cm();
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(int i, c cVar) {
                if (cVar != null) {
                    cVar.F(i);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void c(c cVar) {
                if (cVar != null) {
                    cVar.cn();
                }
            }
        };
    }

    public boolean hC() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.he();
        }
        if (this.yh != null) {
            if (this.yh.isConnecting() || this.yh.isOpen()) {
                if (isDebug()) {
                }
                return true;
            }
            this.yh.close(1, null);
            this.yh = null;
        }
        this.yh = new i();
        try {
            l lVar = new l();
            lVar.ba(this.yg);
            this.yh.a(this.yd, this.yf, this.yj, lVar, this.ye);
            return true;
        } catch (WebSocketException e) {
            this.yh = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.yh != null) {
            i iVar = this.yh;
            this.yh = null;
            iVar.close(i, str);
            if (this.yh != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.yh = null;
            }
        }
    }

    public boolean hD() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.he();
        }
        return (this.yh == null || !this.yh.isOpen() || this.yh.hL()) ? false : true;
    }

    public boolean hE() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.he();
        }
        return this.yh != null && this.yh.isOpen();
    }

    public boolean isConnecting() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.he();
        }
        return this.yh != null && this.yh.isConnecting();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.l.he();
                if (this.yh != null) {
                    z = this.yh.sendMessage(cVar);
                } else if (cVar != null) {
                    cVar.F(1);
                }
            }
        }
        return z;
    }

    public boolean a(g.a aVar) {
        if (aVar != null) {
            synchronized (h.class) {
                if (!this.yi.contains(aVar)) {
                    return this.yi.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void hF() {
        if (this.yh != null) {
            this.yh.hF();
        }
    }

    public long getUpFlowSize() {
        if (this.yh != null) {
            return this.yh.getUpFlowSize();
        }
        return -1L;
    }

    public void hG() {
        if (this.yh != null) {
            this.yh.hG();
        }
    }

    public long getDownFlowSize() {
        if (this.yh != null) {
            return this.yh.getDownFlowSize();
        }
        return -1L;
    }

    public long hy() {
        if (this.yh != null) {
            return this.yh.hM();
        }
        return -1L;
    }

    public String hx() {
        if (this.yh != null) {
            return this.yh.hN();
        }
        return null;
    }

    public long hH() {
        if (this.yh != null) {
            return this.yh.hO();
        }
        return -1L;
    }

    public String hh() {
        if (this.yh != null) {
            return this.yh.hh();
        }
        return null;
    }

    public String hi() {
        if (this.yh != null) {
            return this.yh.hi();
        }
        return null;
    }

    public String getUrl() {
        return this.yd;
    }
}
