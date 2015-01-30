package com.baidu.adp.lib.webSocket;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class m {
    private static m po = null;
    private String[] pr;
    private l pv;
    private String pp = null;
    private List<BasicNameValuePair> pq = null;
    private String ps = null;
    private o pt = null;
    private ArrayList<l> pu = new ArrayList<>();

    public static synchronized m fU() {
        m mVar;
        synchronized (m.class) {
            if (po == null) {
                po = new m();
            }
            mVar = po;
        }
        return mVar;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.pp = str;
        this.ps = str2;
        this.pr = strArr;
        this.pq = list;
        fZ();
    }

    private m() {
        this.pv = null;
        this.pv = new n(this);
    }

    public boolean fV() {
        if (fZ()) {
            com.baidu.adp.lib.util.l.fs();
        }
        if (this.pt != null) {
            if (this.pt.fY() || this.pt.isOpen()) {
                fZ();
                return true;
            }
            this.pt.close(1, null);
            this.pt = null;
        }
        this.pt = new o();
        try {
            am amVar = new am();
            amVar.aM(this.ps);
            this.pt.a(this.pp, this.pr, this.pv, amVar, this.pq);
            return true;
        } catch (WebSocketException e) {
            this.pt = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.pt != null) {
            o oVar = this.pt;
            this.pt = null;
            oVar.close(i, str);
            if (this.pt != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.pt = null;
            }
        }
    }

    public boolean fW() {
        if (fZ()) {
            com.baidu.adp.lib.util.l.fs();
        }
        return (this.pt == null || !this.pt.isOpen() || this.pt.gg()) ? false : true;
    }

    public boolean fX() {
        if (fZ()) {
            com.baidu.adp.lib.util.l.fs();
        }
        return this.pt != null && this.pt.isOpen();
    }

    public boolean fY() {
        if (fZ()) {
            com.baidu.adp.lib.util.l.fs();
        }
        return this.pt != null && this.pt.fY();
    }

    public synchronized boolean sendMessage(d dVar) {
        boolean z = false;
        synchronized (this) {
            if (dVar != null) {
                com.baidu.adp.lib.util.l.fs();
                if (this.pt != null) {
                    z = this.pt.sendMessage(dVar);
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
                if (!this.pu.contains(lVar)) {
                    return this.pu.add(lVar);
                }
            }
        }
        return false;
    }

    private boolean fZ() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void ga() {
        if (this.pt != null) {
            this.pt.ga();
        }
    }

    public long getUpFlowSize() {
        if (this.pt != null) {
            return this.pt.getUpFlowSize();
        }
        return 0L;
    }

    public void gb() {
        if (this.pt != null) {
            this.pt.gb();
        }
    }

    public long getDownFlowSize() {
        if (this.pt != null) {
            return this.pt.getDownFlowSize();
        }
        return 0L;
    }

    public long fS() {
        if (this.pt != null) {
            return this.pt.gh();
        }
        return 0L;
    }

    public String fR() {
        if (this.pt != null) {
            return this.pt.gi();
        }
        return null;
    }

    public long gd() {
        if (this.pt != null) {
            return this.pt.gj();
        }
        return 0L;
    }

    public String fu() {
        if (this.pt != null) {
            return this.pt.fu();
        }
        return null;
    }

    public String fv() {
        if (this.pt != null) {
            return this.pt.fv();
        }
        return null;
    }

    public String getUrl() {
        return this.pp;
    }
}
