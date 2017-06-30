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

    public static h hW() {
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

    public boolean hX() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.hy();
        }
        if (this.Ac != null) {
            if (this.Ac.ia() || this.Ac.isOpen()) {
                isDebug();
                return true;
            }
            this.Ac.close(1, null);
            this.Ac = null;
        }
        this.Ac = new j();
        try {
            n nVar = new n();
            nVar.aQ(this.Ab);
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

    public boolean hY() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.hy();
        }
        return (this.Ac == null || !this.Ac.isOpen() || this.Ac.ih()) ? false : true;
    }

    public boolean hZ() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.hy();
        }
        return this.Ac != null && this.Ac.isOpen();
    }

    public boolean ia() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.hy();
        }
        return this.Ac != null && this.Ac.ia();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.k.hy();
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

    public void ib() {
        if (this.Ac != null) {
            this.Ac.ib();
        }
    }

    public long getUpFlowSize() {
        if (this.Ac != null) {
            return this.Ac.getUpFlowSize();
        }
        return -1L;
    }

    public void ic() {
        if (this.Ac != null) {
            this.Ac.ic();
        }
    }

    public long getDownFlowSize() {
        if (this.Ac != null) {
            return this.Ac.getDownFlowSize();
        }
        return -1L;
    }

    public long hT() {
        if (this.Ac != null) {
            return this.Ac.ii();
        }
        return -1L;
    }

    public String hS() {
        if (this.Ac != null) {
            return this.Ac.ij();
        }
        return null;
    }

    public long id() {
        if (this.Ac != null) {
            return this.Ac.ik();
        }
        return -1L;
    }

    public String hB() {
        if (this.Ac != null) {
            return this.Ac.hB();
        }
        return null;
    }

    public String hC() {
        if (this.Ac != null) {
            return this.Ac.hC();
        }
        return null;
    }

    public String getUrl() {
        return this.zY;
    }
}
