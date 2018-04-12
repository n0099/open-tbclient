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
    private static h yd = null;
    private String[] yg;
    private g.a yk;
    private String ye = null;
    private List<BasicNameValuePair> yf = null;
    private String yh = null;
    private i yi = null;
    private ArrayList<g.a> yj = new ArrayList<>();

    public static h hB() {
        if (yd == null) {
            synchronized (h.class) {
                if (yd == null) {
                    yd = new h();
                }
            }
        }
        return yd;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.ye = str;
        this.yh = str2;
        this.yg = strArr;
        this.yf = list;
        if (isDebug()) {
        }
    }

    private h() {
        this.yk = null;
        this.yk = new g.a() { // from class: com.baidu.adp.lib.webSocket.h.1
            @Override // com.baidu.adp.lib.webSocket.g.a
            public void G(String str) {
                Iterator it = h.this.yj.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).G(str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void q(byte[] bArr) {
                Iterator it = h.this.yj.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).q(bArr);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(k.a aVar) {
                Iterator it = h.this.yj.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).b(aVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void e(Map<String, String> map) {
                Iterator it = h.this.yj.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).e(map);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void e(int i, String str) {
                h.this.yi = null;
                Iterator it = h.this.yj.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).e(i, str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(c cVar) {
                Iterator it = h.this.yj.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).a(cVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void hA() {
                Iterator it = h.this.yj.iterator();
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
        if (this.yi != null) {
            if (this.yi.isConnecting() || this.yi.isOpen()) {
                if (isDebug()) {
                }
                return true;
            }
            this.yi.close(1, null);
            this.yi = null;
        }
        this.yi = new i();
        try {
            l lVar = new l();
            lVar.ba(this.yh);
            this.yi.a(this.ye, this.yg, this.yk, lVar, this.yf);
            return true;
        } catch (WebSocketException e) {
            this.yi = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.yi != null) {
            i iVar = this.yi;
            this.yi = null;
            iVar.close(i, str);
            if (this.yi != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.yi = null;
            }
        }
    }

    public boolean hD() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.he();
        }
        return (this.yi == null || !this.yi.isOpen() || this.yi.hL()) ? false : true;
    }

    public boolean hE() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.he();
        }
        return this.yi != null && this.yi.isOpen();
    }

    public boolean isConnecting() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.he();
        }
        return this.yi != null && this.yi.isConnecting();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.l.he();
                if (this.yi != null) {
                    z = this.yi.sendMessage(cVar);
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
                if (!this.yj.contains(aVar)) {
                    return this.yj.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void hF() {
        if (this.yi != null) {
            this.yi.hF();
        }
    }

    public long getUpFlowSize() {
        if (this.yi != null) {
            return this.yi.getUpFlowSize();
        }
        return -1L;
    }

    public void hG() {
        if (this.yi != null) {
            this.yi.hG();
        }
    }

    public long getDownFlowSize() {
        if (this.yi != null) {
            return this.yi.getDownFlowSize();
        }
        return -1L;
    }

    public long hy() {
        if (this.yi != null) {
            return this.yi.hM();
        }
        return -1L;
    }

    public String hx() {
        if (this.yi != null) {
            return this.yi.hN();
        }
        return null;
    }

    public long hH() {
        if (this.yi != null) {
            return this.yi.hO();
        }
        return -1L;
    }

    public String hh() {
        if (this.yi != null) {
            return this.yi.hh();
        }
        return null;
    }

    public String hi() {
        if (this.yi != null) {
            return this.yi.hi();
        }
        return null;
    }

    public String getUrl() {
        return this.ye;
    }
}
