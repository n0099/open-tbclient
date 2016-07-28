package com.baidu.adp.lib.webSocket;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.g;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class h {
    private static h qU = null;
    private String[] qX;
    private g.a rb;
    private String qV = null;
    private List<BasicNameValuePair> qW = null;
    private String qY = null;
    private j qZ = null;
    private ArrayList<g.a> ra = new ArrayList<>();

    public static h gf() {
        if (qU == null) {
            synchronized (h.class) {
                if (qU == null) {
                    qU = new h();
                }
            }
        }
        return qU;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.qV = str;
        this.qY = str2;
        this.qX = strArr;
        this.qW = list;
        gk();
    }

    private h() {
        this.rb = null;
        this.rb = new i(this);
    }

    public boolean gg() {
        if (gk()) {
            com.baidu.adp.lib.util.k.fF();
        }
        if (this.qZ != null) {
            if (this.qZ.gj() || this.qZ.isOpen()) {
                gk();
                return true;
            }
            this.qZ.close(1, null);
            this.qZ = null;
        }
        this.qZ = new j();
        try {
            n nVar = new n();
            nVar.aW(this.qY);
            this.qZ.a(this.qV, this.qX, this.rb, nVar, this.qW);
            return true;
        } catch (WebSocketException e) {
            this.qZ = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.qZ != null) {
            j jVar = this.qZ;
            this.qZ = null;
            jVar.close(i, str);
            if (this.qZ != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.qZ = null;
            }
        }
    }

    public boolean gh() {
        if (gk()) {
            com.baidu.adp.lib.util.k.fF();
        }
        return (this.qZ == null || !this.qZ.isOpen() || this.qZ.gr()) ? false : true;
    }

    public boolean gi() {
        if (gk()) {
            com.baidu.adp.lib.util.k.fF();
        }
        return this.qZ != null && this.qZ.isOpen();
    }

    public boolean gj() {
        if (gk()) {
            com.baidu.adp.lib.util.k.fF();
        }
        return this.qZ != null && this.qZ.gj();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.k.fF();
                if (this.qZ != null) {
                    z = this.qZ.sendMessage(cVar);
                } else if (cVar != null) {
                    cVar.A(1);
                }
            }
        }
        return z;
    }

    public boolean a(g.a aVar) {
        if (aVar != null) {
            synchronized (h.class) {
                if (!this.ra.contains(aVar)) {
                    return this.ra.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean gk() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void gl() {
        if (this.qZ != null) {
            this.qZ.gl();
        }
    }

    public long getUpFlowSize() {
        if (this.qZ != null) {
            return this.qZ.getUpFlowSize();
        }
        return -1L;
    }

    public void gm() {
        if (this.qZ != null) {
            this.qZ.gm();
        }
    }

    public long getDownFlowSize() {
        if (this.qZ != null) {
            return this.qZ.getDownFlowSize();
        }
        return -1L;
    }

    public long gb() {
        if (this.qZ != null) {
            return this.qZ.gs();
        }
        return -1L;
    }

    public String ga() {
        if (this.qZ != null) {
            return this.qZ.gt();
        }
        return null;
    }

    public long gn() {
        if (this.qZ != null) {
            return this.qZ.gu();
        }
        return -1L;
    }

    public String fI() {
        if (this.qZ != null) {
            return this.qZ.fI();
        }
        return null;
    }

    public String fJ() {
        if (this.qZ != null) {
            return this.qZ.fJ();
        }
        return null;
    }

    public String getUrl() {
        return this.qV;
    }
}
