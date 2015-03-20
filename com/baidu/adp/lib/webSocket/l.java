package com.baidu.adp.lib.webSocket;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class l {
    private static l zX = null;
    private String[] Aa;
    private k Af;
    private String zY = null;
    private List<BasicNameValuePair> zZ = null;
    private String Ab = null;
    private n Ac = null;
    private ArrayList<k> Ae = new ArrayList<>();

    public static synchronized l jr() {
        l lVar;
        synchronized (l.class) {
            if (zX == null) {
                zX = new l();
            }
            lVar = zX;
        }
        return lVar;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.zY = str;
        this.Ab = str2;
        this.Aa = strArr;
        this.zZ = list;
        jw();
    }

    private l() {
        this.Af = null;
        this.Af = new m(this);
    }

    public boolean js() {
        if (jw()) {
            com.baidu.adp.lib.util.n.iV();
        }
        if (this.Ac != null) {
            if (this.Ac.jv() || this.Ac.isOpen()) {
                jw();
                return true;
            }
            this.Ac.close(1, null);
            this.Ac = null;
        }
        this.Ac = new n();
        try {
            al alVar = new al();
            alVar.aU(this.Ab);
            this.Ac.a(this.zY, this.Aa, this.Af, alVar, this.zZ);
            return true;
        } catch (WebSocketException e) {
            this.Ac = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.Ac != null) {
            n nVar = this.Ac;
            this.Ac = null;
            nVar.close(i, str);
            if (this.Ac != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.Ac = null;
            }
        }
    }

    public boolean jt() {
        if (jw()) {
            com.baidu.adp.lib.util.n.iV();
        }
        return (this.Ac == null || !this.Ac.isOpen() || this.Ac.jC()) ? false : true;
    }

    public boolean ju() {
        if (jw()) {
            com.baidu.adp.lib.util.n.iV();
        }
        return this.Ac != null && this.Ac.isOpen();
    }

    public boolean jv() {
        if (jw()) {
            com.baidu.adp.lib.util.n.iV();
        }
        return this.Ac != null && this.Ac.jv();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.n.iV();
                if (this.Ac != null) {
                    z = this.Ac.sendMessage(cVar);
                } else if (cVar != null) {
                    cVar.v(1);
                }
            }
        }
        return z;
    }

    public boolean a(k kVar) {
        if (kVar != null) {
            synchronized (l.class) {
                if (!this.Ae.contains(kVar)) {
                    return this.Ae.add(kVar);
                }
            }
        }
        return false;
    }

    private boolean jw() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void jx() {
        if (this.Ac != null) {
            this.Ac.jx();
        }
    }

    public long getUpFlowSize() {
        if (this.Ac != null) {
            return this.Ac.getUpFlowSize();
        }
        return 0L;
    }

    public void jy() {
        if (this.Ac != null) {
            this.Ac.jy();
        }
    }

    public long getDownFlowSize() {
        if (this.Ac != null) {
            return this.Ac.getDownFlowSize();
        }
        return 0L;
    }

    public long jo() {
        if (this.Ac != null) {
            return this.Ac.jD();
        }
        return 0L;
    }

    public String jn() {
        if (this.Ac != null) {
            return this.Ac.jE();
        }
        return null;
    }

    public long jz() {
        if (this.Ac != null) {
            return this.Ac.jF();
        }
        return 0L;
    }

    public String iX() {
        if (this.Ac != null) {
            return this.Ac.iX();
        }
        return null;
    }

    public String iY() {
        if (this.Ac != null) {
            return this.Ac.iY();
        }
        return null;
    }

    public String getUrl() {
        return this.zY;
    }
}
