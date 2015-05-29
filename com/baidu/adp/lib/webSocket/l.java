package com.baidu.adp.lib.webSocket;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class l {
    private static l zM = null;
    private String[] zP;
    private k zT;
    private String zN = null;
    private List<BasicNameValuePair> zO = null;
    private String zQ = null;
    private n zR = null;
    private ArrayList<k> zS = new ArrayList<>();

    public static synchronized l jI() {
        l lVar;
        synchronized (l.class) {
            if (zM == null) {
                zM = new l();
            }
            lVar = zM;
        }
        return lVar;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.zN = str;
        this.zQ = str2;
        this.zP = strArr;
        this.zO = list;
        jN();
    }

    private l() {
        this.zT = null;
        this.zT = new m(this);
    }

    public boolean jJ() {
        if (jN()) {
            com.baidu.adp.lib.util.n.jk();
        }
        if (this.zR != null) {
            if (this.zR.jM() || this.zR.isOpen()) {
                jN();
                return true;
            }
            this.zR.close(1, null);
            this.zR = null;
        }
        this.zR = new n();
        try {
            al alVar = new al();
            alVar.be(this.zQ);
            this.zR.a(this.zN, this.zP, this.zT, alVar, this.zO);
            return true;
        } catch (WebSocketException e) {
            this.zR = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.zR != null) {
            n nVar = this.zR;
            this.zR = null;
            nVar.close(i, str);
            if (this.zR != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.zR = null;
            }
        }
    }

    public boolean jK() {
        if (jN()) {
            com.baidu.adp.lib.util.n.jk();
        }
        return (this.zR == null || !this.zR.isOpen() || this.zR.jT()) ? false : true;
    }

    public boolean jL() {
        if (jN()) {
            com.baidu.adp.lib.util.n.jk();
        }
        return this.zR != null && this.zR.isOpen();
    }

    public boolean jM() {
        if (jN()) {
            com.baidu.adp.lib.util.n.jk();
        }
        return this.zR != null && this.zR.jM();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.n.jk();
                if (this.zR != null) {
                    z = this.zR.sendMessage(cVar);
                } else if (cVar != null) {
                    cVar.w(1);
                }
            }
        }
        return z;
    }

    public boolean a(k kVar) {
        if (kVar != null) {
            synchronized (l.class) {
                if (!this.zS.contains(kVar)) {
                    return this.zS.add(kVar);
                }
            }
        }
        return false;
    }

    private boolean jN() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void jO() {
        if (this.zR != null) {
            this.zR.jO();
        }
    }

    public long getUpFlowSize() {
        if (this.zR != null) {
            return this.zR.getUpFlowSize();
        }
        return 0L;
    }

    public void jP() {
        if (this.zR != null) {
            this.zR.jP();
        }
    }

    public long getDownFlowSize() {
        if (this.zR != null) {
            return this.zR.getDownFlowSize();
        }
        return 0L;
    }

    public long jF() {
        if (this.zR != null) {
            return this.zR.jU();
        }
        return 0L;
    }

    public String jE() {
        if (this.zR != null) {
            return this.zR.jV();
        }
        return null;
    }

    public long jQ() {
        if (this.zR != null) {
            return this.zR.jW();
        }
        return 0L;
    }

    public String jm() {
        if (this.zR != null) {
            return this.zR.jm();
        }
        return null;
    }

    public String jn() {
        if (this.zR != null) {
            return this.zR.jn();
        }
        return null;
    }

    public String getUrl() {
        return this.zN;
    }
}
