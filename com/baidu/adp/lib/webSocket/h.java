package com.baidu.adp.lib.webSocket;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.g;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class h {
    private static h zU = null;
    private g.a Ab;
    private String[] zX;
    private String zV = null;
    private List<BasicNameValuePair> zW = null;
    private String zY = null;
    private j zZ = null;
    private ArrayList<g.a> Aa = new ArrayList<>();

    public static h hX() {
        if (zU == null) {
            synchronized (h.class) {
                if (zU == null) {
                    zU = new h();
                }
            }
        }
        return zU;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.zV = str;
        this.zY = str2;
        this.zX = strArr;
        this.zW = list;
        isDebug();
    }

    private h() {
        this.Ab = null;
        this.Ab = new i(this);
    }

    public boolean hY() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.hy();
        }
        if (this.zZ != null) {
            if (this.zZ.ib() || this.zZ.isOpen()) {
                isDebug();
                return true;
            }
            this.zZ.close(1, null);
            this.zZ = null;
        }
        this.zZ = new j();
        try {
            n nVar = new n();
            nVar.aL(this.zY);
            this.zZ.a(this.zV, this.zX, this.Ab, nVar, this.zW);
            return true;
        } catch (WebSocketException e) {
            this.zZ = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.zZ != null) {
            j jVar = this.zZ;
            this.zZ = null;
            jVar.close(i, str);
            if (this.zZ != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.zZ = null;
            }
        }
    }

    public boolean hZ() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.hy();
        }
        return (this.zZ == null || !this.zZ.isOpen() || this.zZ.ii()) ? false : true;
    }

    public boolean ia() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.hy();
        }
        return this.zZ != null && this.zZ.isOpen();
    }

    public boolean ib() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.hy();
        }
        return this.zZ != null && this.zZ.ib();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.k.hy();
                if (this.zZ != null) {
                    z = this.zZ.sendMessage(cVar);
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
                if (!this.Aa.contains(aVar)) {
                    return this.Aa.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void ic() {
        if (this.zZ != null) {
            this.zZ.ic();
        }
    }

    public long getUpFlowSize() {
        if (this.zZ != null) {
            return this.zZ.getUpFlowSize();
        }
        return -1L;
    }

    public void id() {
        if (this.zZ != null) {
            this.zZ.id();
        }
    }

    public long getDownFlowSize() {
        if (this.zZ != null) {
            return this.zZ.getDownFlowSize();
        }
        return -1L;
    }

    public long hU() {
        if (this.zZ != null) {
            return this.zZ.ij();
        }
        return -1L;
    }

    public String hT() {
        if (this.zZ != null) {
            return this.zZ.ik();
        }
        return null;
    }

    public long ie() {
        if (this.zZ != null) {
            return this.zZ.il();
        }
        return -1L;
    }

    public String hB() {
        if (this.zZ != null) {
            return this.zZ.hB();
        }
        return null;
    }

    public String hC() {
        if (this.zZ != null) {
            return this.zZ.hC();
        }
        return null;
    }

    public String getUrl() {
        return this.zV;
    }
}
