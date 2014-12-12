package com.baidu.adp.lib.webSocket;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class m {
    private static m pg = null;
    private String[] pj;
    private l pq;
    private String ph = null;
    private List<BasicNameValuePair> pi = null;
    private String pl = null;
    private o po = null;
    private ArrayList<l> pp = new ArrayList<>();

    public static synchronized m fV() {
        m mVar;
        synchronized (m.class) {
            if (pg == null) {
                pg = new m();
            }
            mVar = pg;
        }
        return mVar;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.ph = str;
        this.pl = str2;
        this.pj = strArr;
        this.pi = list;
        ga();
    }

    private m() {
        this.pq = null;
        this.pq = new n(this);
    }

    public boolean fW() {
        if (ga()) {
            com.baidu.adp.lib.util.l.ft();
        }
        if (this.po != null) {
            if (this.po.fZ() || this.po.isOpen()) {
                ga();
                return true;
            }
            this.po.close(1, null);
            this.po = null;
        }
        this.po = new o();
        try {
            am amVar = new am();
            amVar.aM(this.pl);
            this.po.a(this.ph, this.pj, this.pq, amVar, this.pi);
            return true;
        } catch (WebSocketException e) {
            this.po = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.po != null) {
            o oVar = this.po;
            this.po = null;
            oVar.close(i, str);
            if (this.po != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.po = null;
            }
        }
    }

    public boolean fX() {
        if (ga()) {
            com.baidu.adp.lib.util.l.ft();
        }
        return (this.po == null || !this.po.isOpen() || this.po.gh()) ? false : true;
    }

    public boolean fY() {
        if (ga()) {
            com.baidu.adp.lib.util.l.ft();
        }
        return this.po != null && this.po.isOpen();
    }

    public boolean fZ() {
        if (ga()) {
            com.baidu.adp.lib.util.l.ft();
        }
        return this.po != null && this.po.fZ();
    }

    public synchronized boolean sendMessage(d dVar) {
        boolean z = false;
        synchronized (this) {
            if (dVar != null) {
                com.baidu.adp.lib.util.l.ft();
                if (this.po != null) {
                    z = this.po.sendMessage(dVar);
                } else if (dVar != null) {
                    dVar.u(1);
                }
            }
        }
        return z;
    }

    public boolean a(l lVar) {
        if (lVar != null) {
            synchronized (m.class) {
                if (!this.pp.contains(lVar)) {
                    return this.pp.add(lVar);
                }
            }
        }
        return false;
    }

    private boolean ga() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void gb() {
        if (this.po != null) {
            this.po.gb();
        }
    }

    public long getUpFlowSize() {
        if (this.po != null) {
            return this.po.getUpFlowSize();
        }
        return 0L;
    }

    public void gd() {
        if (this.po != null) {
            this.po.gd();
        }
    }

    public long getDownFlowSize() {
        if (this.po != null) {
            return this.po.getDownFlowSize();
        }
        return 0L;
    }

    public long fT() {
        if (this.po != null) {
            return this.po.gi();
        }
        return 0L;
    }

    public String fS() {
        if (this.po != null) {
            return this.po.gj();
        }
        return null;
    }

    public long ge() {
        if (this.po != null) {
            return this.po.gk();
        }
        return 0L;
    }

    public String fv() {
        if (this.po != null) {
            return this.po.fv();
        }
        return null;
    }

    public String fw() {
        if (this.po != null) {
            return this.po.fw();
        }
        return null;
    }

    public String getUrl() {
        return this.ph;
    }
}
