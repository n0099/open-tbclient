package com.baidu.adp.lib.webSocket;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.g;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class h {
    private static h zy = null;
    private String[] zB;
    private g.a zF;
    private String zz = null;
    private List<BasicNameValuePair> zA = null;
    private String zC = null;
    private j zD = null;
    private ArrayList<g.a> zE = new ArrayList<>();

    public static synchronized h jB() {
        h hVar;
        synchronized (h.class) {
            if (zy == null) {
                zy = new h();
            }
            hVar = zy;
        }
        return hVar;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.zz = str;
        this.zC = str2;
        this.zB = strArr;
        this.zA = list;
        isDebug();
    }

    private h() {
        this.zF = null;
        this.zF = new i(this);
    }

    public boolean jC() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.jd();
        }
        if (this.zD != null) {
            if (this.zD.jF() || this.zD.isOpen()) {
                isDebug();
                return true;
            }
            this.zD.close(1, null);
            this.zD = null;
        }
        this.zD = new j();
        try {
            n nVar = new n();
            nVar.aX(this.zC);
            this.zD.a(this.zz, this.zB, this.zF, nVar, this.zA);
            return true;
        } catch (WebSocketException e) {
            this.zD = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.zD != null) {
            j jVar = this.zD;
            this.zD = null;
            jVar.close(i, str);
            if (this.zD != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.zD = null;
            }
        }
    }

    public boolean jD() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.jd();
        }
        return (this.zD == null || !this.zD.isOpen() || this.zD.jM()) ? false : true;
    }

    public boolean jE() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.jd();
        }
        return this.zD != null && this.zD.isOpen();
    }

    public boolean jF() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.jd();
        }
        return this.zD != null && this.zD.jF();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.k.jd();
                if (this.zD != null) {
                    z = this.zD.sendMessage(cVar);
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
                if (!this.zE.contains(aVar)) {
                    return this.zE.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void jG() {
        if (this.zD != null) {
            this.zD.jG();
        }
    }

    public long getUpFlowSize() {
        if (this.zD != null) {
            return this.zD.getUpFlowSize();
        }
        return 0L;
    }

    public void jH() {
        if (this.zD != null) {
            this.zD.jH();
        }
    }

    public long getDownFlowSize() {
        if (this.zD != null) {
            return this.zD.getDownFlowSize();
        }
        return 0L;
    }

    public long jy() {
        if (this.zD != null) {
            return this.zD.jN();
        }
        return 0L;
    }

    public String jx() {
        if (this.zD != null) {
            return this.zD.jO();
        }
        return null;
    }

    public long jI() {
        if (this.zD != null) {
            return this.zD.jP();
        }
        return 0L;
    }

    public String jg() {
        if (this.zD != null) {
            return this.zD.jg();
        }
        return null;
    }

    public String jh() {
        if (this.zD != null) {
            return this.zD.jh();
        }
        return null;
    }

    public String getUrl() {
        return this.zz;
    }
}
