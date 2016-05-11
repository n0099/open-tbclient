package com.baidu.adp.lib.webSocket;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.g;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class h {
    private static h qs = null;
    private String[] qv;
    private g.a qz;
    private String qt = null;
    private List<BasicNameValuePair> qu = null;
    private String qw = null;
    private j qx = null;
    private ArrayList<g.a> qy = new ArrayList<>();

    public static h gf() {
        if (qs == null) {
            synchronized (h.class) {
                if (qs == null) {
                    qs = new h();
                }
            }
        }
        return qs;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.qt = str;
        this.qw = str2;
        this.qv = strArr;
        this.qu = list;
        isDebug();
    }

    private h() {
        this.qz = null;
        this.qz = new i(this);
    }

    public boolean gg() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.fF();
        }
        if (this.qx != null) {
            if (this.qx.gj() || this.qx.isOpen()) {
                isDebug();
                return true;
            }
            this.qx.close(1, null);
            this.qx = null;
        }
        this.qx = new j();
        try {
            n nVar = new n();
            nVar.aV(this.qw);
            this.qx.a(this.qt, this.qv, this.qz, nVar, this.qu);
            return true;
        } catch (WebSocketException e) {
            this.qx = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.qx != null) {
            j jVar = this.qx;
            this.qx = null;
            jVar.close(i, str);
            if (this.qx != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.qx = null;
            }
        }
    }

    public boolean gh() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.fF();
        }
        return (this.qx == null || !this.qx.isOpen() || this.qx.gq()) ? false : true;
    }

    public boolean gi() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.fF();
        }
        return this.qx != null && this.qx.isOpen();
    }

    public boolean gj() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.fF();
        }
        return this.qx != null && this.qx.gj();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.k.fF();
                if (this.qx != null) {
                    z = this.qx.sendMessage(cVar);
                } else if (cVar != null) {
                    cVar.x(1);
                }
            }
        }
        return z;
    }

    public boolean a(g.a aVar) {
        if (aVar != null) {
            synchronized (h.class) {
                if (!this.qy.contains(aVar)) {
                    return this.qy.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void gk() {
        if (this.qx != null) {
            this.qx.gk();
        }
    }

    public long getUpFlowSize() {
        if (this.qx != null) {
            return this.qx.getUpFlowSize();
        }
        return -1L;
    }

    public void gl() {
        if (this.qx != null) {
            this.qx.gl();
        }
    }

    public long getDownFlowSize() {
        if (this.qx != null) {
            return this.qx.getDownFlowSize();
        }
        return -1L;
    }

    public long gb() {
        if (this.qx != null) {
            return this.qx.gr();
        }
        return -1L;
    }

    public String ga() {
        if (this.qx != null) {
            return this.qx.gs();
        }
        return null;
    }

    public long gm() {
        if (this.qx != null) {
            return this.qx.gt();
        }
        return -1L;
    }

    public String fI() {
        if (this.qx != null) {
            return this.qx.fI();
        }
        return null;
    }

    public String fJ() {
        if (this.qx != null) {
            return this.qx.fJ();
        }
        return null;
    }

    public String getUrl() {
        return this.qt;
    }
}
