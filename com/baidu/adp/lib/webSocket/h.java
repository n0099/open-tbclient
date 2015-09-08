package com.baidu.adp.lib.webSocket;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.g;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class h {
    private static h zw = null;
    private g.a zD;
    private String[] zz;
    private String zx = null;
    private List<BasicNameValuePair> zy = null;
    private String zA = null;
    private j zB = null;
    private ArrayList<g.a> zC = new ArrayList<>();

    public static synchronized h jy() {
        h hVar;
        synchronized (h.class) {
            if (zw == null) {
                zw = new h();
            }
            hVar = zw;
        }
        return hVar;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.zx = str;
        this.zA = str2;
        this.zz = strArr;
        this.zy = list;
        isDebug();
    }

    private h() {
        this.zD = null;
        this.zD = new i(this);
    }

    public boolean jz() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.ja();
        }
        if (this.zB != null) {
            if (this.zB.jC() || this.zB.isOpen()) {
                isDebug();
                return true;
            }
            this.zB.close(1, null);
            this.zB = null;
        }
        this.zB = new j();
        try {
            n nVar = new n();
            nVar.aX(this.zA);
            this.zB.a(this.zx, this.zz, this.zD, nVar, this.zy);
            return true;
        } catch (WebSocketException e) {
            this.zB = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.zB != null) {
            j jVar = this.zB;
            this.zB = null;
            jVar.close(i, str);
            if (this.zB != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.zB = null;
            }
        }
    }

    public boolean jA() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.ja();
        }
        return (this.zB == null || !this.zB.isOpen() || this.zB.jJ()) ? false : true;
    }

    public boolean jB() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.ja();
        }
        return this.zB != null && this.zB.isOpen();
    }

    public boolean jC() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.ja();
        }
        return this.zB != null && this.zB.jC();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.k.ja();
                if (this.zB != null) {
                    z = this.zB.sendMessage(cVar);
                } else if (cVar != null) {
                    cVar.y(1);
                }
            }
        }
        return z;
    }

    public boolean a(g.a aVar) {
        if (aVar != null) {
            synchronized (h.class) {
                if (!this.zC.contains(aVar)) {
                    return this.zC.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void jD() {
        if (this.zB != null) {
            this.zB.jD();
        }
    }

    public long getUpFlowSize() {
        if (this.zB != null) {
            return this.zB.getUpFlowSize();
        }
        return 0L;
    }

    public void jE() {
        if (this.zB != null) {
            this.zB.jE();
        }
    }

    public long getDownFlowSize() {
        if (this.zB != null) {
            return this.zB.getDownFlowSize();
        }
        return 0L;
    }

    public long jv() {
        if (this.zB != null) {
            return this.zB.jK();
        }
        return 0L;
    }

    public String ju() {
        if (this.zB != null) {
            return this.zB.jL();
        }
        return null;
    }

    public long jF() {
        if (this.zB != null) {
            return this.zB.jM();
        }
        return 0L;
    }

    public String jd() {
        if (this.zB != null) {
            return this.zB.jd();
        }
        return null;
    }

    public String je() {
        if (this.zB != null) {
            return this.zB.je();
        }
        return null;
    }

    public String getUrl() {
        return this.zx;
    }
}
