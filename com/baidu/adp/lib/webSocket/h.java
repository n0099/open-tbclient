package com.baidu.adp.lib.webSocket;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.g;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class h {
    private static h td = null;
    private String[] tg;
    private g.a tk;
    private String te = null;
    private List<BasicNameValuePair> tf = null;
    private String th = null;
    private j ti = null;
    private ArrayList<g.a> tj = new ArrayList<>();

    public static h gY() {
        if (td == null) {
            synchronized (h.class) {
                if (td == null) {
                    td = new h();
                }
            }
        }
        return td;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.te = str;
        this.th = str2;
        this.tg = strArr;
        this.tf = list;
        hd();
    }

    private h() {
        this.tk = null;
        this.tk = new i(this);
    }

    public boolean gZ() {
        if (hd()) {
            com.baidu.adp.lib.util.k.gz();
        }
        if (this.ti != null) {
            if (this.ti.hc() || this.ti.isOpen()) {
                hd();
                return true;
            }
            this.ti.close(1, null);
            this.ti = null;
        }
        this.ti = new j();
        try {
            n nVar = new n();
            nVar.aW(this.th);
            this.ti.a(this.te, this.tg, this.tk, nVar, this.tf);
            return true;
        } catch (WebSocketException e) {
            this.ti = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.ti != null) {
            j jVar = this.ti;
            this.ti = null;
            jVar.close(i, str);
            if (this.ti != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.ti = null;
            }
        }
    }

    public boolean ha() {
        if (hd()) {
            com.baidu.adp.lib.util.k.gz();
        }
        return (this.ti == null || !this.ti.isOpen() || this.ti.hk()) ? false : true;
    }

    public boolean hb() {
        if (hd()) {
            com.baidu.adp.lib.util.k.gz();
        }
        return this.ti != null && this.ti.isOpen();
    }

    public boolean hc() {
        if (hd()) {
            com.baidu.adp.lib.util.k.gz();
        }
        return this.ti != null && this.ti.hc();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.k.gz();
                if (this.ti != null) {
                    z = this.ti.sendMessage(cVar);
                } else if (cVar != null) {
                    cVar.O(1);
                }
            }
        }
        return z;
    }

    public boolean a(g.a aVar) {
        if (aVar != null) {
            synchronized (h.class) {
                if (!this.tj.contains(aVar)) {
                    return this.tj.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean hd() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void he() {
        if (this.ti != null) {
            this.ti.he();
        }
    }

    public long getUpFlowSize() {
        if (this.ti != null) {
            return this.ti.getUpFlowSize();
        }
        return -1L;
    }

    public void hf() {
        if (this.ti != null) {
            this.ti.hf();
        }
    }

    public long getDownFlowSize() {
        if (this.ti != null) {
            return this.ti.getDownFlowSize();
        }
        return -1L;
    }

    public long gV() {
        if (this.ti != null) {
            return this.ti.hl();
        }
        return -1L;
    }

    public String gU() {
        if (this.ti != null) {
            return this.ti.hm();
        }
        return null;
    }

    public long hg() {
        if (this.ti != null) {
            return this.ti.hn();
        }
        return -1L;
    }

    public String gC() {
        if (this.ti != null) {
            return this.ti.gC();
        }
        return null;
    }

    public String gD() {
        if (this.ti != null) {
            return this.ti.gD();
        }
        return null;
    }

    public String getUrl() {
        return this.te;
    }
}
