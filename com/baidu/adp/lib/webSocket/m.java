package com.baidu.adp.lib.webSocket;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class m {
    private static m pi = null;
    private String[] po;
    private l ps;
    private String pj = null;
    private List<BasicNameValuePair> pl = null;
    private String pp = null;
    private o pq = null;
    private ArrayList<l> pr = new ArrayList<>();

    public static synchronized m fT() {
        m mVar;
        synchronized (m.class) {
            if (pi == null) {
                pi = new m();
            }
            mVar = pi;
        }
        return mVar;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.pj = str;
        this.pp = str2;
        this.po = strArr;
        this.pl = list;
        fY();
    }

    private m() {
        this.ps = null;
        this.ps = new n(this);
    }

    public boolean fU() {
        if (fY()) {
            com.baidu.adp.lib.util.m.ft();
        }
        if (this.pq != null) {
            if (this.pq.fX() || this.pq.isOpen()) {
                fY();
                return true;
            }
            this.pq.close(1, null);
            this.pq = null;
        }
        this.pq = new o();
        try {
            am amVar = new am();
            amVar.aK(this.pp);
            this.pq.a(this.pj, this.po, this.ps, amVar, this.pl);
            return true;
        } catch (WebSocketException e) {
            this.pq = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.pq != null) {
            o oVar = this.pq;
            this.pq = null;
            oVar.close(i, str);
            if (this.pq != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.pq = null;
            }
        }
    }

    public boolean fV() {
        if (fY()) {
            com.baidu.adp.lib.util.m.ft();
        }
        return (this.pq == null || !this.pq.isOpen() || this.pq.gg()) ? false : true;
    }

    public boolean fW() {
        if (fY()) {
            com.baidu.adp.lib.util.m.ft();
        }
        return this.pq != null && this.pq.isOpen();
    }

    public boolean fX() {
        if (fY()) {
            com.baidu.adp.lib.util.m.ft();
        }
        return this.pq != null && this.pq.fX();
    }

    public synchronized boolean sendMessage(d dVar) {
        boolean z = false;
        synchronized (this) {
            if (dVar != null) {
                com.baidu.adp.lib.util.m.ft();
                if (this.pq != null) {
                    z = this.pq.sendMessage(dVar);
                } else if (dVar != null) {
                    dVar.i(1);
                }
            }
        }
        return z;
    }

    public boolean a(l lVar) {
        if (lVar != null) {
            synchronized (m.class) {
                if (!this.pr.contains(lVar)) {
                    return this.pr.add(lVar);
                }
            }
        }
        return false;
    }

    private boolean fY() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void fZ() {
        if (this.pq != null) {
            this.pq.fZ();
        }
    }

    public long getUpFlowSize() {
        if (this.pq != null) {
            return this.pq.getUpFlowSize();
        }
        return 0L;
    }

    public void ga() {
        if (this.pq != null) {
            this.pq.ga();
        }
    }

    public long getDownFlowSize() {
        if (this.pq != null) {
            return this.pq.getDownFlowSize();
        }
        return 0L;
    }

    public long fR() {
        if (this.pq != null) {
            return this.pq.gh();
        }
        return 0L;
    }

    public String fQ() {
        if (this.pq != null) {
            return this.pq.gi();
        }
        return null;
    }

    public long gb() {
        if (this.pq != null) {
            return this.pq.gj();
        }
        return 0L;
    }

    public String fv() {
        if (this.pq != null) {
            return this.pq.fv();
        }
        return null;
    }

    public String fw() {
        if (this.pq != null) {
            return this.pq.fw();
        }
        return null;
    }

    public String getUrl() {
        return this.pj;
    }
}
