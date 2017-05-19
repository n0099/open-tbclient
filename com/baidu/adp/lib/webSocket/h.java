package com.baidu.adp.lib.webSocket;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.g;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class h {
    private static h zX = null;
    private String[] Aa;
    private g.a Af;
    private String zY = null;
    private List<BasicNameValuePair> zZ = null;
    private String Ab = null;
    private j Ac = null;
    private ArrayList<g.a> Ae = new ArrayList<>();

    public static h hX() {
        if (zX == null) {
            synchronized (h.class) {
                if (zX == null) {
                    zX = new h();
                }
            }
        }
        return zX;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.zY = str;
        this.Ab = str2;
        this.Aa = strArr;
        this.zZ = list;
        isDebug();
    }

    private h() {
        this.Af = null;
        this.Af = new i(this);
    }

    public boolean hY() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.hz();
        }
        if (this.Ac != null) {
            if (this.Ac.ib() || this.Ac.isOpen()) {
                isDebug();
                return true;
            }
            this.Ac.close(1, null);
            this.Ac = null;
        }
        this.Ac = new j();
        try {
            n nVar = new n();
            nVar.aL(this.Ab);
            this.Ac.a(this.zY, this.Aa, this.Af, nVar, this.zZ);
            return true;
        } catch (WebSocketException e) {
            this.Ac = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.Ac != null) {
            j jVar = this.Ac;
            this.Ac = null;
            jVar.close(i, str);
            if (this.Ac != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.Ac = null;
            }
        }
    }

    public boolean hZ() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.hz();
        }
        return (this.Ac == null || !this.Ac.isOpen() || this.Ac.ii()) ? false : true;
    }

    public boolean ia() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.hz();
        }
        return this.Ac != null && this.Ac.isOpen();
    }

    public boolean ib() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.hz();
        }
        return this.Ac != null && this.Ac.ib();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.k.hz();
                if (this.Ac != null) {
                    z = this.Ac.sendMessage(cVar);
                } else if (cVar != null) {
                    cVar.M(1);
                }
            }
        }
        return z;
    }

    public boolean a(g.a aVar) {
        if (aVar != null) {
            synchronized (h.class) {
                if (!this.Ae.contains(aVar)) {
                    return this.Ae.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void ic() {
        if (this.Ac != null) {
            this.Ac.ic();
        }
    }

    public long getUpFlowSize() {
        if (this.Ac != null) {
            return this.Ac.getUpFlowSize();
        }
        return -1L;
    }

    public void id() {
        if (this.Ac != null) {
            this.Ac.id();
        }
    }

    public long getDownFlowSize() {
        if (this.Ac != null) {
            return this.Ac.getDownFlowSize();
        }
        return -1L;
    }

    public long hU() {
        if (this.Ac != null) {
            return this.Ac.ij();
        }
        return -1L;
    }

    public String hT() {
        if (this.Ac != null) {
            return this.Ac.ik();
        }
        return null;
    }

    public long ie() {
        if (this.Ac != null) {
            return this.Ac.il();
        }
        return -1L;
    }

    public String hC() {
        if (this.Ac != null) {
            return this.Ac.hC();
        }
        return null;
    }

    public String hD() {
        if (this.Ac != null) {
            return this.Ac.hD();
        }
        return null;
    }

    public String getUrl() {
        return this.zY;
    }
}
