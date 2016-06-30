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

    public static h gg() {
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
        gl();
    }

    private h() {
        this.qz = null;
        this.qz = new i(this);
    }

    public boolean gh() {
        if (gl()) {
            com.baidu.adp.lib.util.k.fG();
        }
        if (this.qx != null) {
            if (this.qx.gk() || this.qx.isOpen()) {
                gl();
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

    public boolean gi() {
        if (gl()) {
            com.baidu.adp.lib.util.k.fG();
        }
        return (this.qx == null || !this.qx.isOpen() || this.qx.gs()) ? false : true;
    }

    public boolean gj() {
        if (gl()) {
            com.baidu.adp.lib.util.k.fG();
        }
        return this.qx != null && this.qx.isOpen();
    }

    public boolean gk() {
        if (gl()) {
            com.baidu.adp.lib.util.k.fG();
        }
        return this.qx != null && this.qx.gk();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.k.fG();
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

    private boolean gl() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void gm() {
        if (this.qx != null) {
            this.qx.gm();
        }
    }

    public long getUpFlowSize() {
        if (this.qx != null) {
            return this.qx.getUpFlowSize();
        }
        return -1L;
    }

    public void gn() {
        if (this.qx != null) {
            this.qx.gn();
        }
    }

    public long getDownFlowSize() {
        if (this.qx != null) {
            return this.qx.getDownFlowSize();
        }
        return -1L;
    }

    public long gd() {
        if (this.qx != null) {
            return this.qx.gt();
        }
        return -1L;
    }

    public String gb() {
        if (this.qx != null) {
            return this.qx.gu();
        }
        return null;
    }

    public long go() {
        if (this.qx != null) {
            return this.qx.gv();
        }
        return -1L;
    }

    public String fJ() {
        if (this.qx != null) {
            return this.qx.fJ();
        }
        return null;
    }

    public String fK() {
        if (this.qx != null) {
            return this.qx.fK();
        }
        return null;
    }

    public String getUrl() {
        return this.qt;
    }
}
